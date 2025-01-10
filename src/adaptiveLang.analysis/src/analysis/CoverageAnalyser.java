package analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;

import adapters.Adapter;
import adapters.AdapterModel;
import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import handlers.utils.AdaptersUtil;
import merlin.adaptive.adapters.ConfigDiff;
import merlin.adaptive.adapters.Diffs;
import merlin.common.features.DefaultFeatureProvider;
import merlin.common.utils.FileUtils;

public class CoverageAnalyser {
	
	//private Map<String,Map<Diffs,List<String>>> coverage = new LinkedHashMap<>();
	private List<FeatureMetric> metrics = new ArrayList<>();
	private IFeatureModel fm;
	
	public CoverageAnalyser(IFile iFile) {
		AdapterModel am = AdaptersUtil.load(iFile);	
		
		//IFile featureModelFile = FileUtils.getIFile("AdaptiveClassDiagrams//model.xml"); 		// to-do: read this from eccore annotation
		IFile featureModelFile = FileUtils.getIFile(iFile.getProject(), "model.xml"); 		// to-do: read this from eccore annotation
		
		DefaultFeatureProvider provider = new DefaultFeatureProvider(featureModelFile);
		this.fm = provider.getFeatureModel();		
				
		for (IFeature f : this.fm.getFeatures()) {

			if (f.getStructure().getChildren().isEmpty() ||
				!f.getStructure().isMandatory()) {
				
				FeatureMetric m = this.createMetric(f.getName(), this.findAdaptersFor(f, this.fm, am.getAdapters()));
				
				System.out.println(m);
			}
		}
	}
	
	public List<String> allFeatures() {		
		return this.featuresWith(t -> true);
	}
	
	public List<String> getUncoveredFeatures() {
		return this.featuresWith(t -> t.hasEmptyAdapters());
	}
	
	public List<String> getCoveredFeatures() {
		return this.featuresWith(t -> !t.hasEmptyAdapters());
	}
	
	private List<String> featuresWith(Predicate<FeatureMetric> condition) {
		List<String> features = new ArrayList<>();
		for (FeatureMetric fm: this.metrics) 
			if (condition.test(fm)) features.add(fm.getName());		
		return features;
	}

	private FeatureMetric createMetric(String name, Map<Diffs, List<String>> adapters) {
		FeatureMetric metric = new FeatureMetric(name);
		
		for (Diffs d : adapters.keySet()) 
			metric.add(d, adapters.get(d));
		
		this.metrics.add(metric);
		
		return metric;
	}


	public List<FeatureMetric> getCoverage() {
		return this.metrics;
	}

	private Map<Diffs,List<String>> findAdaptersFor(IFeature f, IFeatureModel fm, List<Adapter> adapters) {
		Map<Diffs,List<String>> featureCoverage = new LinkedHashMap<>();
								
		for (Diffs df : Diffs.values()) 
			featureCoverage.put(df, this.compatibleAdapters(fm, f.getName(), df, adapters));	
		
		return featureCoverage;
	}

/*	private List<String> compatiblePositiveContextAdapters(ConfigDiff diff, IFeatureModel fm, List<Adapter> adapters) {
		List<String> compAdap = new ArrayList<>();
		for (Adapter adp : adapters) {
			ConfigDiff aDiff = ConfigDiff.fromAdapter(fm, adp);
			if (!aDiff.get(Diffs.POS).isEmpty() && 
				aDiff.get(Diffs.POS).containsAll(diff.get(Diffs.POS))) 
				compAdap.add(adp.getName());						
		}
		return compAdap;
	}
	
	private List<String> compatibleNegativeContextAdapters(ConfigDiff diff, IFeatureModel fm, List<Adapter> adapters) {
		List<String> compAdap = new ArrayList<>();
		for (Adapter adp : adapters) {
			ConfigDiff aDiff = ConfigDiff.fromAdapter(fm, adp);
			if (!aDiff.get(Diffs.NEG).isEmpty() && aDiff.get(Diffs.NEG).containsAll(diff.get(Diffs.NEG))) 
				compAdap.add(adp.getName());						
		}
		return compAdap;
	}*/

	private List<String> compatibleAdapters(IFeatureModel fm,
											String f, Diffs d,
											List<Adapter> adapters) {
		List<String> compAdap = new ArrayList<>();
		for (Adapter adp : adapters) {
			ConfigDiff aDiff = ConfigDiff.fromAdapter(fm, adp);
			if (aDiff.get(d).contains(f)) 
				compAdap.add(adp.getName());						
		}
		return compAdap;
	}
	
	public List<FeatureMetric> getFeatures() {
		return Collections.unmodifiableList(this.metrics);
	}
}
