package analysis;

import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.xml.namespace.SpaceType;

import adapters.ConfigDiff;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.IFeatureStructure;
import de.ovgu.featureide.fm.core.base.impl.ConfigFormatManager;
import merlin.adaptive.adapters.Adapter;
import merlin.adaptive.adapters.Transformation;
import merlin.adaptive.analysis.RuleActionAnalyser;
import merlin.adaptive.handlers.AdaptersFile;
import merlin.adaptive.trafos.AdapterModelInjector;
import merlin.adaptive.trafos.MigrationTrafo;
import merlin.common.features.DefaultFeatureProvider;
import merlin.common.utils.FileUtils;
import merlin.featureide.composer.configurations.FeatureConfigurationIterator;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.configuration.SelectableFeature;
import de.ovgu.featureide.fm.core.io.ProblemList;
import de.ovgu.featureide.fm.core.io.manager.SimpleFileHandler;

public class ConfigReachabilityAnalyser {

	public enum CoverabilityType {
		FULL, PARTIAL, EMPTY
	}

	private DefaultFeatureProvider provider;
	private IFeatureModel fm;
	private Transformation trafo;
	private RuleActionAnalyser raa;
	private Map<Configuration, Map<Configuration, MigrationTrafo>> reachSpace = new LinkedHashMap<>();
	private Map<Configuration, Map<Configuration, CoverabilityType>> spaceKind = new LinkedHashMap<>();
	private IFile file;

	public ConfigReachabilityAnalyser(IFile adaptFile) {
		this.file = adaptFile;
		AdaptersFile adaptersFile = new AdaptersFile(adaptFile);
		IFile featureModelFile = FileUtils.getIFile(adaptFile.getProject(), "model.xml"); 		// to-do: read this from eccore annotation
		this.provider = new DefaultFeatureProvider(featureModelFile);
		this.fm = this.provider.getFeatureModel();
		AdapterModelInjector injector = new AdapterModelInjector(adaptersFile.getAdapterModel(),this.fm);

		this.trafo = new Transformation(this.fm);
		for (Adapter a : injector.getAdapters())
			trafo.addAdapter(a);

		this.raa = new RuleActionAnalyser(adaptersFile.getAdapterModel(), adaptFile.getProject());
	}

	public void doAnalysis() {
		FeatureConfigurationIterator it1 = new FeatureConfigurationIterator(this.provider.getFeatureModel());
		Configuration cfg = it1.next();
		while (cfg!=null) {
			System.out.print(".");
			cfg = it1.next();
		}		
		int sizeConfigs = it1.getConfigs().size();
		System.out.println("Analysing "+it1.getConfigs().size()+" configs");

		for (int i = 0; i < sizeConfigs ; i++) {
			Configuration srcCfg = it1.getConfigs().get(i);
			this.reachSpace.putIfAbsent(srcCfg, new LinkedHashMap<>());
			Map<Configuration, MigrationTrafo> map = this.reachSpace.get(srcCfg);
			for (int j = 0; j< sizeConfigs; j++ ) {
				if (i==j) continue;				
				Configuration tarCfg = it1.getConfigs().get(j);				
				MigrationTrafo mt = trafo.composeTrafo(this.fm, srcCfg, tarCfg, raa);
				map.put(tarCfg, mt);
			}
		}
		System.out.println("Analysed: "+this.reachSpace.size()+" configs");
		this.analyseResults();
	}

	public void analyseResults() {
		int empty = 0, partial = 0, total = 0;
		for (Configuration cfg1 : this.reachSpace.keySet()) {
			this.spaceKind.putIfAbsent(cfg1, new LinkedHashMap<>());
			Map<Configuration, MigrationTrafo> map = this.reachSpace.get(cfg1);
			Map<Configuration, CoverabilityType> mapKind = this.spaceKind.get(cfg1);
			for (Configuration cfg2: map.keySet()) {
				MigrationTrafo mtf = map.get(cfg2);
				if (mtf.getAllRules()==null || mtf.getAllRules().size()==0) { 
					mapKind.put(cfg2, CoverabilityType.EMPTY);
					empty++;
					System.out.println((empty+total+partial)+" - Empty="+empty);
				}
				else {
					List<String> consideredFeatures = mtf.getAllFeatures();
					merlin.adaptive.adapters.ConfigDiff cfgd = 
							merlin.adaptive.adapters.ConfigDiff.diff(fm, cfg2, cfg1);
					Set<String> diffFeatures = cfgd.getDelta();
					if (consideredFeatures.containsAll(diffFeatures)) {
						mapKind.put(cfg2, CoverabilityType.FULL);
						total++;
						System.out.println((empty+total+partial)+" - Total="+total);
					}
					else {
						mapKind.put(cfg2, CoverabilityType.PARTIAL);
						partial++;
						System.out.println((empty+total+partial)+" - Partial="+partial);
					}					
				}
			}
		}
		System.out.println("---------------------------------------------");
		System.out.println("Total="+total+", partial = "+partial+", empty= "+empty);
		analyseRechableConfigs();
	}

	private void analyseRechableConfigs() {
		List<String> posAnalysis = List.of("Multi", "FullAssoc", "Decorations", "Card");
		List<String> negAnalysis = List.of("Comp", "Aggr", "Navig", "Methods", "Interfaces");

		List<String> posDesign = List.of("Methods", "Multi", "FullAssoc", "Decorations", "Comp", "Aggr", "Navig", "Card");
		List<String> negDesign = List.of("Interfaces");

		List<String> posJava = List.of("Methods", "Single", "Ref", "Interfaces", "Decorations", "Comp", "Aggr", "Navig", "Card");
		List<String> negJava = List.of();

		List<String> posCpp = List.of("Methods", "Multi", "Ref", "Interfaces", "Decorations", "Comp", "Aggr", "Navig", "Card");
		List<String> negCpp = List.of();

		System.out.println("Reachable Design from Analysis: "+this.isReachable(posAnalysis, negAnalysis, posDesign, negDesign));
		System.out.println("===================================================================================");
		System.out.println("Reachable Java from Design: "+this.isReachable(posDesign, negDesign, posJava, negJava));
		System.out.println("===================================================================================");
		System.out.println("Reachable C++ from Design: "+this.isReachable(posDesign, negDesign, posCpp, negCpp));
		System.out.println("===================================================================================");
		System.out.println("Reachable Java from C++: "+this.isReachable(posCpp, negCpp, posJava, negJava));
		System.out.println("===================================================================================");
		System.out.println("Reachable C++ from Java: "+this.isReachable(posJava, negJava, posCpp, negCpp));
	}

	public Map<Configuration, Map<Configuration, CoverabilityType>> isReachable(List<String> posCf1,
			List<String> negCf1,
			List<String> posCf2,
			List<String> negCf2) {
		Map<Configuration, Map<Configuration, CoverabilityType>> map = new LinkedHashMap<>();
		for (Configuration config1 : this.spaceKind.keySet()) {			
			if (isCompatibleConfig(posCf1, negCf1, config1)) {				
				map.put(config1, new LinkedHashMap<>());
				Map<Configuration, CoverabilityType> newMap = map.get(config1);
				for (Configuration config2: this.spaceKind.get(config1).keySet()) {
					if (isCompatibleConfig(posCf2, negCf2, config2)) 
						newMap.put(config2, this.spaceKind.get(config1).get(config2));					
				}
			}
		}
		return map;
	}

	private boolean isCompatibleConfig(List<String> posCf1, List<String> negCf1, Configuration config1) {
		if (!config1.getSelectedFeatureNames().containsAll(posCf1)) return false;
		Set<String> unselected = config1.getUndefinedFeatureNames();
		return unselected.containsAll(negCf1);
	}

	public CoverabilityType isReachable(Configuration c1, Configuration c2) {
		/*System.out.println("c1="+c1);
		System.out.println("-----------------");
		System.out.println("c2="+c2);
		Map<Configuration, CoverabilityType> map = this.spaceKind.get(c1);
		if (c1==null) return null;
		return map.get(c2);*/
		List<String> posCf1 = new ArrayList<>(c1.getSelectedFeatureNames());
		List<String> negCf1 = new ArrayList<>(c1.getUnselectedFeatureNames());
		List<String> posCf2 = new ArrayList<>(c2.getSelectedFeatureNames());
		List<String> negCf2 = new ArrayList<>(c2.getUnselectedFeatureNames());
		Map<Configuration, Map<Configuration, CoverabilityType>> map = this.isReachable(posCf1, negCf1, posCf2, negCf2);
		for (Configuration cs : map.keySet()) {
			for (Configuration ct: map.get(cs).keySet()) {
				return map.get(cs).get(ct);
			}
		}
		return null;
	}

	public IFile getFile() {
		return this.file;
	}

	public CoverabilityType isReachable(String srcFile, String tarFile) {
		Configuration src = this.getConfiguration(this.provider, this.file.getProject(), srcFile);
		Configuration tar = this.getConfiguration(this.provider, this.file.getProject(), tarFile);
		return this.isReachable(src, tar);
	}
	
	// this method is a clone of one in AdaptersFile
	private Configuration getConfiguration(DefaultFeatureProvider dfp, IProject prj, String configFileName) {
		Configuration c = new Configuration(new FeatureModelFormula(dfp.getFeatureModel()));
		IFile src = prj.getFile(configFileName);
		Path path = new File(src.getLocation().toOSString()).toPath();
		ProblemList pl = SimpleFileHandler.load(path, c, ConfigFormatManager.getInstance());
		if (!pl.isEmpty()) return null;
		return c;
	}
}
