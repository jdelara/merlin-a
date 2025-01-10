package analysis;

import java.util.*;
import java.util.function.Predicate;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import adapters.Adapter;
import adapters.AdapterModel;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import handlers.utils.AdaptersUtil;
import merlin.adaptive.utils.HenshinUtils;
import merlin.common.annotations.MerlinAnnotationStructure;
import merlin.common.annotations.presenceCondition.ConditionParser;
import merlin.common.features.DefaultFeatureProvider;
import merlin.common.features.IFeatureProvider;
import merlin.common.features.PartialFeatureProvider;
import merlin.common.issues.GenericIssue;
import merlin.common.utils.EMFUtils;
import merlin.common.utils.FileUtils;
import merlin.common.utils.MerlinAnnotationUtils;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;

public class RuleCompatAnalyser {
	private AdapterModel adapterModel;
	private IFeatureModel fm;
	private DefaultFeatureProvider featureProvider;
	private EPackage ecore;
	private List<AnalysedRule> analysedRules = new ArrayList<>();
	private Module henshinModule;

	public RuleCompatAnalyser(IFile adaptersFile) {
		this.adapterModel = AdaptersUtil.load(adaptersFile);
		
		String ecore = this.adapterModel.getEcore();		
		IFile ecoreFile = FileUtils.getIFile(adaptersFile.getProject(), ecore); 		// to-do: read this from eccore annotation
		List<EPackage> packages = EMFUtils.readEcore(ecoreFile);
		this.ecore = packages.get(0);
		
		String henshin = this.adapterModel.getTransformation();
		IFile henshinFile = FileUtils.getIFile(adaptersFile.getProject(), henshin);	
		this.henshinModule = HenshinUtils.load(henshinFile);
		
		IFile featureModelFile = FileUtils.getIFile(adaptersFile.getProject(), "model.xml"); 		// to-do: read this from eccore annotation
		DefaultFeatureProvider provider = new DefaultFeatureProvider(featureModelFile);
		this.featureProvider = provider;
		
		this.fm = provider.getFeatureModel();	
		this.analyse();
	}
	
	public void analyse() {
		for (Adapter ad : this.adapterModel.getAdapters()) {
			for (String s : ad.getRules()) {
				Rule rule = this.getRule(s);
				AnalysedRule ar = this.analyse(rule, ad);
				this.analysedRules.add(ar);
				System.out.println(ar);
			}
		}
	}

	private AnalysedRule analyse(Rule rule, Adapter ad) {
		AnalysedRule ar = new AnalysedRule(rule.getName(), ad.getName());
		this.checkPreserve(ar, rule, ad);
		this.checkCreate(ar, rule, ad);
		this.checkForbid(ar, rule, ad);
		return ar;
	}

	private void checkCompat (PartialFeatureProvider pfp, Graph g, AnalysedRule ar, String ruleSide, 
							  Predicate<Node> nodeFilter, Predicate<Edge> edgeFilter) {
		Map<Node, String> presenceCondition = new LinkedHashMap<>();
		for (Node n : g.getNodes()) {
			if (nodeFilter.test(n)) continue;
			EClass ct = n.getType();
			EClass mmClass = (EClass)this.ecore.getEClassifier(ct.getName());			
			EAnnotation an = MerlinAnnotationUtils.getClassMerlinAnnotation(mmClass);
			String condition = "true";
			presenceCondition.put(n, condition);
			if (an!=null) {
				condition = an.getDetails().get(MerlinAnnotationStructure.PRESENCE_CONDITION);
				presenceCondition.put(n, condition);
				
				ConditionParser cp = new ConditionParser(condition, mmClass, pfp);
				boolean res = cp.eval();
				
				System.out.println("[merlin] PC for "+mmClass.getName()+" is "+condition);			
				
				if (!res) 
					ar.addError("["+ruleSide+"]: The PC ("+condition+") of the type of node "+n.getName()+" ("+mmClass.getName()+") is not true");
			}
			
			for (Attribute a : n.getAttributes()) {
				EAttribute at = a.getType();
				EAttribute aType = mmClass.getEAllAttributes().stream().filter(atr -> atr.getName().equals(at.getName())).findFirst().get();
				
				String error = this.evalPC(n, presenceCondition, aType, pfp);
				if (error!=null)
					ar.addError("["+ruleSide+"]: "+error);
			}
		}
		
		for (Edge e : g.getEdges()) {
			if (edgeFilter.test(e)) continue;
			Node src = e.getSource();
			EReference ct = e.getType();
			EReference mmReference = this.getEreference(ct.getName(), src.getType().getName());
			
			String error = this.evalPC(src, presenceCondition, mmReference, pfp);
			if (error!=null)
				ar.addError("["+ruleSide+"]: "+error);
		}
	}
	
	private String evalPC(	Node parent, Map<Node, String> presenceCondition, 
							EStructuralFeature sf, PartialFeatureProvider pfp) {
		
		EAnnotation an = MerlinAnnotationUtils.getClassMerlinAnnotation(sf);
		if (an==null) return null; // The PC is true
		String condition = an.getDetails().get(MerlinAnnotationStructure.PRESENCE_CONDITION);
		
		String sourceNodePC = presenceCondition.get(parent);
		if (sourceNodePC!=null && !sourceNodePC.equals("true"))
			condition = "("+sourceNodePC+") and ("+condition+")";
		ConditionParser cp = new ConditionParser(condition, sf, pfp);
		boolean res = cp.eval();
		System.out.println("[merlin] PC for "+sf.getName()+" is "+condition);
		String featureType = (sf instanceof EReference) ? "reference" : "attribute";
		if (!res) 
			return "The PC ("+condition+") of "+featureType+" "+sf.getName()+" of node "+parent.getName()+" is not true";
		else return null;		
	}
	
	private EReference getEreference(String refName, String className) {
		EClass cl = (EClass) this.ecore.getEClassifier(className);
		if (cl==null) return null;
		for (EReference r : cl.getEAllReferences()) 
			if (r.getName().equals(refName)) return r;		
		return null;
	}

	private void checkPreserve(AnalysedRule ar, Rule rule, Adapter ad) {
		List<String> positive = new ArrayList<>(ad.getCfgDiff().getDelta().getPosSet());
		positive.addAll(ad.getCfgDiff().getContext().getPosSet());
		positive.addAll(ad.getCfgDiff().getDelta().getNegSet()); // can also be in -+
		
		List<String> negative = new ArrayList<>(ad.getCfgDiff().getContext().getNegSet());
		//negative.addAll(ad.getCfgDiff().getContext().getNegSet());
				
		this.checkCompat(new PartialFeatureProvider(this.featureProvider, positive, negative), 
						 rule.getLhs(), ar, "preserve", (n -> false), (e -> false));
	}
	
	private void checkForbid(AnalysedRule ar, Rule rule, Adapter ad) {
		List<String> positive = new ArrayList<>(ad.getCfgDiff().getDelta().getPosSet());
		positive.addAll(ad.getCfgDiff().getContext().getPosSet());
		positive.addAll(ad.getCfgDiff().getDelta().getNegSet()); // can also be in -+
		
		List<String> negative = new ArrayList<>(ad.getCfgDiff().getContext().getNegSet());
		//negative.addAll(ad.getCfgDiff().getContext().getNegSet());
						
		Graph lhs = rule.getLhs();
		for (NestedCondition nc: lhs.getNACs()) {
			Graph nac = nc.getConclusion();
			this.checkCompat(new PartialFeatureProvider(this.featureProvider, positive, negative), 
							 nac, ar, "forbid", ( n -> rule.getLhs().getNode(n.getName())!=null ),
							 					( e -> rule.getMappings().getOrigin(e)!=null));
		}				
	}
	
	private void checkCreate(AnalysedRule ar, Rule rule, Adapter ad) {
		List<String> positive = new ArrayList<>(ad.getCfgDiff().getDelta().getNegSet());
		positive.addAll(ad.getCfgDiff().getContext().getPosSet());
		
		List<String> negative = new ArrayList<>(ad.getCfgDiff().getDelta().getPosSet());
		negative.addAll(ad.getCfgDiff().getContext().getNegSet());
		
		this.checkCompat(new PartialFeatureProvider(this.featureProvider, positive, negative), 
						 rule.getRhs(), ar, "create", 
						 ( n -> rule.getLhs().getNode(n.getName())!=null ),
						 ( e -> rule.getMappings().getOrigin(e)!=null));
	}

	private Rule getRule(String s) {
		for (Rule r : this.henshinModule.getAllRules()) 
			if (r.getName().equals(s)) return r;		
		return null;
	}

	public List<GenericIssue> getErrors() {
		List<GenericIssue> errors = new ArrayList<>();
		for (AnalysedRule ar: this.analysedRules) {
			for (String s : ar.getErrors()) {
				GenericIssue gi = new GenericIssue(s, IMarker.SEVERITY_WARNING, "rule "+ar.getName()+" (in "+ar.getAdapter()+")" );
				errors.add(gi);
			}
		}
		return errors;
	}
}
