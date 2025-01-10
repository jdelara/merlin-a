package merlin.adaptive.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;

import adapters.AdapterModel;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import merlin.adaptive.adapters.AbstractAdapter;
import merlin.adaptive.adapters.ConfigDiff;
import merlin.adaptive.adapters.Diffs;
import merlin.adaptive.utils.HenshinUtils;
import merlin.common.annotations.MerlinAnnotationStructure;
import merlin.common.annotations.presenceCondition.ConditionParser;
import merlin.common.features.DefaultFeatureProvider;
import merlin.common.features.PartialFeatureProvider;
import merlin.common.utils.EMFUtils;
import merlin.common.utils.FileUtils;
import merlin.common.utils.MerlinAnnotationUtils;

public class RuleActionAnalyser {
	private AdapterModel adapterModel;
	private EPackage ecore;
	private Module henshinModule;
	private DefaultFeatureProvider featureProvider;
	private IFeatureModel fm;
	
	public RuleActionAnalyser (AdapterModel am, IProject prj) {
		this.adapterModel = am;	
		
		String ecore = this.adapterModel.getEcore();		
		IFile ecoreFile = FileUtils.getIFile(prj, ecore); 		// to-do: read this from eccore annotation
		List<EPackage> packages = EMFUtils.readEcore(ecoreFile);
		this.ecore = packages.get(0);
		
		String henshin = this.adapterModel.getTransformation();
		IFile henshinFile = FileUtils.getIFile(prj, henshin);	
		this.henshinModule = HenshinUtils.load(henshinFile);
		
		IFile featureModelFile = FileUtils.getIFile(prj, "model.xml"); 		// to-do: read this from eccore annotation
		DefaultFeatureProvider provider = new DefaultFeatureProvider(featureModelFile);
		this.featureProvider = provider;
		
		this.fm = provider.getFeatureModel();
		
	}
		
	private boolean check (AbstractAdapter ad, ConfigDiff cd, Function<Rule, Graph> graph) {
		List<String> positive = new ArrayList<>(ad.getDiff().get(Diffs.POS));
		positive.removeAll(cd.get(Diffs.POS));
		
		List<String> negative = new ArrayList<>(ad.getDiff().get(Diffs.NEG));
		negative.removeAll(cd.get(Diffs.NEG));
		
		for (String rname : ad.getRules() ) {
			Unit u = this.henshinModule.getUnit(rname);
			if (u instanceof Rule) {
				Rule r = (Rule)u;
				Graph g = graph.apply(r);
				for (Node n : g.getNodes()) {
					if (r.getMappings().getOrigin(n)!=null) continue;	// this one is preserved
					EClass ct = n.getType();
					EClass mmClass = (EClass)this.ecore.getEClassifier(ct.getName());	
					
					String presenceCondition = isTermOf(mmClass, positive, negative);
					if (presenceCondition == null) continue; 
					if (isActiveType(presenceCondition, mmClass, positive, negative)) return true;
				}
				for (Edge e : g.getEdges()) {
					if (r.getMappings().getOrigin(e)!=null) continue;	// this one is preserved
					Node src = e.getSource();
					EReference ct = e.getType();
					EReference mmReference = this.getEreference(ct.getName(), src.getType().getName());
					
					String presenceCondition = isTermOf(mmReference, positive, negative);
					if (presenceCondition == null) continue; 
					if (isActiveType(presenceCondition, mmReference, positive, negative)) return true;
				}
			}
		}
		return false;
	}
	
	public boolean create(AbstractAdapter ad, ConfigDiff cd) {
		return this.check(ad, cd, r -> r.getRhs());
	}
	
	public boolean delete(AbstractAdapter ad, ConfigDiff cd) {
		return this.check(ad, cd, r -> r.getLhs());	
	}

	private EReference getEreference(String refName, String className) {
		EClass cl = (EClass) this.ecore.getEClassifier(className);
		if (cl==null) return null;
		for (EReference r : cl.getEAllReferences()) 
			if (r.getName().equals(refName)) return r;		
		return null;
	}

	private boolean isActiveType(String presenceCondition, ENamedElement ctx, List<String> positive, List<String> negative) {
		
		PartialFeatureProvider pfp = new PartialFeatureProvider(this.featureProvider, positive, negative);
		
		ConditionParser cp = new ConditionParser(presenceCondition, ctx, pfp);
		return cp.eval();
	}

	private String isTermOf(ENamedElement namedEl, List<String> posFeats, List<String> negFeats) {		
		EAnnotation an = MerlinAnnotationUtils.getClassMerlinAnnotation(namedEl);
		if (an!=null) {
			String condition = an.getDetails().get(MerlinAnnotationStructure.PRESENCE_CONDITION);
			String[] splitted = condition.split("\\s+");
			for (String lit : splitted) {
				if (posFeats.contains(lit) || negFeats.contains(lit)) return condition;
			}
		}
		return null;
	}
}
