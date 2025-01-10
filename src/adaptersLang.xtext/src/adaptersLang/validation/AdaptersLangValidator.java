package adaptersLang.validation;

import java.util.*;

import merlin.common.analysis.FeatureSolver;
import merlin.common.features.DefaultFeatureProvider;
import merlin.common.features.PartialFeatureProvider;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.xtext.validation.Check;

import adapters.Adapter;
import adapters.AdapterModel;
import adapters.AdaptersPackage;
import adapters.ConfigDiff;
import adapters.ConfigTuple;
import adaptersLang.utils.HenshinUtils;

public class AdaptersLangValidator extends AbstractAdaptersLangValidator{
	public static String INVALID_ECORE = "invalidEcore";
	public static String INVALID_ECORE_EXTENSION = "invalidEcoreExtension";
	public static String INVALID_TRANSFORMATION = "invalidTransformation";
	public static String INVALID_TRANSFORMATION_EXTENSION = "invalidTransformationExtension";
	public static String INVALID_DIFF = "invalidDiff";
	public static String INVALID_POSSET = "invalidPosSet";
	public static String INVALID_NEGSET = "invalidNegSet";
	public static String INVALID_RULES = "invalidRules";
	
	private DefaultFeatureProvider fp;
	
	@Check
	public void checkFilesExists(AdapterModel adpModel) {
		if (HenshinUtils.getFile(adpModel.getEcore())==null)
			error("Ecore model "+adpModel.getEcore()+" does not exist", 
				  AdaptersPackage.eINSTANCE.getAdapterModel_Ecore(), 
				  INVALID_ECORE);
		if (HenshinUtils.getFile(adpModel.getTransformation())==null)
			error("Henshin transformation "+adpModel.getTransformation()+" does not exist", 
				  AdaptersPackage.eINSTANCE.getAdapterModel_Transformation(), 
				  INVALID_TRANSFORMATION);
	}	
	
	@Check
	public void checkFileExtensions(AdapterModel adpModel) {
		if (!adpModel.getEcore().endsWith(".ecore"))
			warning("Model "+adpModel.getEcore()+" should be an .ecore file", 
					  AdaptersPackage.eINSTANCE.getAdapterModel_Ecore(), 
					  INVALID_ECORE_EXTENSION);
		if (!adpModel.getTransformation().endsWith(".henshin"))
			warning("Model "+adpModel.getEcore()+" should be a .henshin file", 
					  AdaptersPackage.eINSTANCE.getAdapterModel_Transformation(), 
					  INVALID_TRANSFORMATION_EXTENSION);
	}
	
	@Check
	public void wffDiff (ConfigDiff cd) {
		boolean prewff = this.preStateWff(cd);
		if (!prewff) {
			error("Configuration diff not well formed (pre-state)",
				  AdaptersPackage.eINSTANCE.getConfigDiff_Delta(),
				  INVALID_DIFF);			
		}
		boolean postff = this.postStateWff(cd);
		if (!postff) {
			error("Configuration diff not well formed (post-state)",
				  AdaptersPackage.eINSTANCE.getConfigDiff_Delta(),
				  INVALID_DIFF);			
		}
	}
	
	@Check
	public void disjointFeatures(ConfigTuple ct) {
		ConfigDiff cd = (ConfigDiff) ct.eContainer();		
		ConfigTuple ct2 = cd.getDelta() == ct ? cd.getContext() : cd.getDelta();
		
		Map<EStructuralFeature, List<String>> dups = this.getDups(ct, ct2);
		
		for (EStructuralFeature esf : dups.keySet()) {
			List<String> features = dups.get(esf); 
			if (!features.isEmpty()) 
				error("Duplicated features in Diff: "+features, esf, INVALID_DIFF );			
		}
	}
		
	private Map<EStructuralFeature, List<String>> getDups(ConfigTuple ct, ConfigTuple other) {
		Set<String> all = new HashSet<>();
		Map<EStructuralFeature, List<String>> dups = new LinkedHashMap<>();
		
		all.addAll(ct.getNegSet());
		all.addAll(other.getPosSet());
		all.addAll(other.getNegSet());
		
		dups.put(AdaptersPackage.Literals.CONFIG_TUPLE__POS_SET, 
				 duplicates(all, ct.getPosSet()));
		
		all.clear();
		
		all.addAll(ct.getPosSet());
		all.addAll(other.getPosSet());
		all.addAll(other.getNegSet());	
		
		dups.put(AdaptersPackage.Literals.CONFIG_TUPLE__NEG_SET,
				 duplicates(all, ct.getNegSet()));

		return dups;
	}

	private List<String> duplicates(Set<String> allFeats, List<String> feats) {
		List<String> dups = new ArrayList<>();
		for (String s : feats) 
			if (!allFeats.add(s)) dups.add(s);		
		return dups;
	}

	@Check
	public void existsFeature(ConfigTuple ct) {
		getFeatureProvider();
		if (this.fp==null) {
			error("Feature model file not found!",
					  AdaptersPackage.eINSTANCE.getConfigTuple_NegSet(),
					  INVALID_NEGSET);
			return;
		}
		List<String> invalid = new ArrayList<>();
		for (String f : ct.getPosSet()) 
			if (!this.isValidFeature(f)) invalid.add(f);
		if (!invalid.isEmpty())
			error("Invalid features: "+invalid,
				  AdaptersPackage.eINSTANCE.getConfigTuple_PosSet(),
				  INVALID_POSSET);
		invalid.clear();
		for (String f : ct.getNegSet()) 
			if (!this.isValidFeature(f)) invalid.add(f);
		if (!invalid.isEmpty()) 
			error("Invalid features: "+invalid,
				  AdaptersPackage.eINSTANCE.getConfigTuple_NegSet(),
				  INVALID_NEGSET);
	}
	
	@Check
	public void existRules(Adapter adp) {
		AdapterModel adpm = (AdapterModel) adp.eContainer();
		IFile f = HenshinUtils.getFile(adpm.getTransformation());
		if (!f.exists()) return;
		Module m = HenshinUtils.load(f);
		
		List<String> invalidRules = new ArrayList<>();
		
		for (String rule : adp.getRules()) {
			if (!this.hasRule(m, rule)) invalidRules.add(rule);			
		}
		
		if (!invalidRules.isEmpty()) {
			error("Invalid rules: "+invalidRules,
					  AdaptersPackage.eINSTANCE.getAdapter_Rules(),
					  INVALID_RULES);
		}
	}
	
	private boolean hasRule(Module m, String rule) {
		for (Rule r : m.getAllRules()) 			
			if (r.getName().equals(rule)) return true;
		
		return false;
	}
	

	private boolean isValidFeature(String f) {	
		this.getFeatureProvider();	// so innefficient!
		return this.fp.getFeature(f)!=null;		
	}
	
	private DefaultFeatureProvider getFeatureProvider() {
		if (this.fp==null) {
			IFile fmFile = HenshinUtils.getFile("model.xml");
			this.fp = new DefaultFeatureProvider(fmFile);
		}
		return this.fp;
	}
	
	public boolean preStateWff(ConfigDiff cfg) {
		List<String> positive = new ArrayList<>();
		List<String> negative = new ArrayList<>();
		positive.addAll(cfg.getDelta().getPosSet());
		positive.addAll(cfg.getContext().getPosSet());
		
		negative.addAll(cfg.getDelta().getNegSet());
		negative.addAll(cfg.getContext().getNegSet());
		
		DefaultFeatureProvider dfp = this.getFeatureProvider();
		PartialFeatureProvider pdf = new PartialFeatureProvider(dfp, positive, negative);
		
		FeatureSolver fs = new FeatureSolver(pdf, this.fp.getFeatureModel());
		fs.addConstraints(positive, negative);
		
		boolean ret = fs.isSat();
		
		return ret;
	}
	
	public boolean postStateWff(ConfigDiff cfg) {
		List<String> positive = new ArrayList<>();
		List<String> negative = new ArrayList<>();
		positive.addAll(cfg.getDelta().getNegSet());
		positive.addAll(cfg.getContext().getPosSet());
		
		negative.addAll(cfg.getDelta().getPosSet());
		negative.addAll(cfg.getContext().getNegSet());
		
		DefaultFeatureProvider dfp = this.getFeatureProvider();
		PartialFeatureProvider pdf = new PartialFeatureProvider(dfp, positive, negative);
		
		FeatureSolver fs = new FeatureSolver(pdf, this.fp.getFeatureModel());
		fs.addConstraints(positive, negative);
		
		boolean ret = fs.isSat();
		
		return ret;
	}
}
