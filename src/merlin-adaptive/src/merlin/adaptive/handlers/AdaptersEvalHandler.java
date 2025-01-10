package merlin.adaptive.handlers;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;

import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import merlin.adaptive.adapters.AbstractAdapter;
import merlin.adaptive.adapters.Adapter;
import merlin.adaptive.adapters.AdapterKind;
import merlin.adaptive.adapters.Transformation;
import merlin.adaptive.analysis.RuleActionAnalyser;
import merlin.adaptive.trafos.AdapterModelInjector;
import merlin.adaptive.trafos.MigrationTrafo;
import merlin.adaptive.utils.HandlerUtils;
import merlin.common.features.DefaultFeatureProvider;
import merlin.common.utils.FileUtils;
import merlin.featureide.composer.configurations.FeatureConfigurationIterator;

public class AdaptersEvalHandler extends AbstractHandler {
	private IFile selectedFile;
	private DefaultFeatureProvider provider;
	private IFeatureModel fm; 

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[Merlin] Evaluating!!");
		this.selectedFile = HandlerUtils.getSelectedFile(event);
		AdaptersFile adaptersFile = new AdaptersFile(selectedFile);
		IFile featureModelFile = FileUtils.getIFile(selectedFile.getProject(), "model.xml"); 		// to-do: read this from eccore annotation
		this.provider = new DefaultFeatureProvider(featureModelFile);
		this.fm = this.provider.getFeatureModel();
		AdapterModelInjector injector = new AdapterModelInjector(adaptersFile.getAdapterModel(),this.fm);
		
		Transformation trafo = new Transformation(this.fm);
		for (Adapter a : injector.getAdapters())
			trafo.addAdapter(a);
				
		RuleActionAnalyser raa = new RuleActionAnalyser(adaptersFile.getAdapterModel(), this.selectedFile.getProject());
		
		this.doEval(adaptersFile, trafo, raa);
		return Status.OK_STATUS;
	}

	private void doEval(AdaptersFile adaptersFile, Transformation trafo, RuleActionAnalyser raa) {				
		FeatureConfigurationIterator it1 = new FeatureConfigurationIterator(this.provider.getFeatureModel());
		
		Configuration srcCfg = null, tarCfg = null;
		
		while ((srcCfg = it1.next()) != null) {
			System.out.print(".");
		}
		System.out.println("["+it1.getConfigs().size()+" configs ]");
		
		Set<String> trafos = new LinkedHashSet<>();
		Set<MigrationTrafo> migs = new LinkedHashSet<>();
		long numRules = 0;
		long numConfigs = 0;
		long numAdapters = 0;
		long sizeConfigs = it1.getConfigs().size();
		long totalSize = sizeConfigs * (sizeConfigs-1); 
		for (int i = 0; i < sizeConfigs; i++) {
			for (int j = 0; j< sizeConfigs; j++ ) {
				if (i==j) continue;
				srcCfg = it1.getConfigs().get(i);
				tarCfg = it1.getConfigs().get(j);
				numConfigs++;
				/*System.out.println(numConfigs+	" src="+srcCfg.getSelectedFeatureNames()+
										  		" tar="+tarCfg.getSelectedFeatureNames());*/
				System.out.println(numConfigs+" of "+totalSize);
				MigrationTrafo mt = trafo.composeTrafo(this.fm, srcCfg, tarCfg, raa);
				
				if (trafos.add(mt.allAdapters().toString())) {
					migs.add(mt);
					numAdapters += mt.allAdapters().size();
					numRules += mt.getAllRules().size();
				}
				//System.out.println(" trf: "+mt.allAdapters());
			}		
		}
		
		System.out.println("Different trafos: "+trafos.size());
		System.out.println("Average adapters: "+1.0*numAdapters/trafos.size());
		System.out.println("Average rules: "+1.0*numRules/trafos.size());		
		System.out.println("Total context fixers: "+this.getAllCount(migs, AdapterKind.CONTEXTFIXER));
		System.out.println("Negative context fixers: "+this.getAllCount(migs, AdapterKind.CONTEXTFIXER, a -> a.isNegative()));
		System.out.println("Total completers: "+this.getAllCount(migs, AdapterKind.COMPLETER));
		System.out.println("Total soft completers: "+this.getAllCount(migs, AdapterKind.SOFTCOMPLETER));
		System.out.println("Unique context fixers: "+this.getUniqueCount(migs, AdapterKind.CONTEXTFIXER));
		System.out.println("   ::"+this.getUniqueNames(migs, AdapterKind.CONTEXTFIXER));
		System.out.println("Unique completers: "+this.getUniqueCount(migs, AdapterKind.COMPLETER));
		System.out.println("   ::"+this.getUniqueNames(migs, AdapterKind.COMPLETER));
		System.out.println("Unique soft completers: "+this.getUniqueCount(migs, AdapterKind.SOFTCOMPLETER));
		System.out.println("   ::"+this.getUniqueNames(migs, AdapterKind.SOFTCOMPLETER));
	}

	private long getAllCount(Set<MigrationTrafo> migs, AdapterKind kind) {
		return this.getAllCount(migs, kind, a -> true);
	}
	
	private long getAllCount(Set<MigrationTrafo> migs, AdapterKind kind, Predicate<AbstractAdapter> filter) {
		long total = 0;
		for (MigrationTrafo mt: migs) {
			total += mt.allAdapters(kind).stream().filter(filter).count();
		}
		return total;
	}
	
	private long getUniqueCount(Set<MigrationTrafo> migs, AdapterKind kind) {
		Set<String> res = new LinkedHashSet<>();
		for (MigrationTrafo mt: migs) {
			for (AbstractAdapter aa : mt.allAdapters(kind)) 
				res.add(aa.getName());
		}
		return res.size();
	}
	
	private Set<String> getUniqueNames(Set<MigrationTrafo> migs, AdapterKind kind) {
		Set<String> res = new LinkedHashSet<>();
		for (MigrationTrafo mt: migs) {
			for (AbstractAdapter aa : mt.allAdapters(kind)) 
				res.add(aa.getName()+(aa.isNegative()?"(negative)":""));
		}
		return res;
	}
}