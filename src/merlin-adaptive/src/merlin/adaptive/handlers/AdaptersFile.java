/**
 * Wrapper for adapters files.
 */
package merlin.adaptive.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import adapters.AdapterModel;
import adaptersLang.AdaptersLangStandaloneSetupGenerated;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.base.impl.ConfigFormatManager;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.io.ProblemList;
import de.ovgu.featureide.fm.core.io.manager.SimpleFileHandler;
import merlin.adaptive.adapters.Adapter;
import merlin.adaptive.adapters.Transformation;
import merlin.adaptive.analysis.RuleActionAnalyser;
import merlin.adaptive.trafos.AdapterModelInjector;
import merlin.adaptive.trafos.MigrationTrafo;
import merlin.adaptive.utils.HenshinUtils;
import merlin.common.features.DefaultFeatureProvider;

public class AdaptersFile {
	private ResourceSet rs;
	private AdapterModel am;
	private IProject prj;
	private IFile fmf;
	
	public AdaptersFile (IFile adaptersFile) {
		registerXtext(adaptersFile);
		Resource ar = loadXtextModel(adaptersFile);
		am  = (AdapterModel) ar.getContents().get(0);
		prj = adaptersFile.getProject();
		fmf = prj.getFile("model.xml");
	}
	
	public boolean isValid () {
		return fmf.exists();
	}
	
	public void generateTransformation(String sourceConfigFile, String targetConfigFile) {
		generateTransformation(sourceConfigFile, targetConfigFile, null);
	}	

	public void generateTransformation(String sourceConfigFile, String targetConfigFile, IFile outputTransformationFile) {
		if (isValid()) {
			DefaultFeatureProvider dfp = new DefaultFeatureProvider(fmf);
			Configuration src = this.getConfiguration(dfp, prj, sourceConfigFile);
			Configuration tar = this.getConfiguration(dfp, prj, targetConfigFile);
//			System.out.println("Src selected features: "+src.getSelectedFeatures());
//			System.out.println("Tar selected features: "+tar.getSelectedFeatures());
			AdapterModelInjector injector = new AdapterModelInjector(am, dfp.getFeatureModel());
			Transformation trafo = new Transformation(dfp.getFeatureModel());
			for (Adapter a : injector.getAdapters())
				trafo.addAdapter(a);
					
			RuleActionAnalyser raa = new RuleActionAnalyser(am, prj);
			
			MigrationTrafo mt = trafo.composeTrafo(dfp.getFeatureModel(), src, tar, raa);
			mt.generate(prj, am.getTransformation(), outputTransformationFile);
//			System.out.println("Migration trafo: "+mt);
		}
	}	

	private Configuration getConfiguration(DefaultFeatureProvider dfp, IProject prj, String configFileName) {
		Configuration c = new Configuration(new FeatureModelFormula(dfp.getFeatureModel()));
		IFile src = prj.getFile(configFileName);
		Path path = new File(src.getLocation().toOSString()).toPath();
		ProblemList pl = SimpleFileHandler.load(path, c, ConfigFormatManager.getInstance());
		if (!pl.isEmpty()) return null;
		return c;
	}

	private void registerXtext(IFile adaptersFile) {
		System.out.println("Selected: "+adaptersFile.getFullPath().toOSString());
		Injector injector = new AdaptersLangStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		rs = injector.getInstance(XtextResourceSet.class);		
		((XtextResourceSet)rs).addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	}	
	
	private Resource loadXtextModel(IFile model) {
		Resource resource = rs.createResource(URI.createPlatformResourceURI(model.getFullPath().toOSString(), true));
		IPath    location = model.getLocation();
		File     modelf   = (location != null) ? location.toFile() : null;
		InputStream in;
		try {
			in = new FileInputStream(modelf);
			resource.load(in, rs.getLoadOptions());
		} 
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
		return resource;
	}

	public AdapterModel getAdapterModel() {
		return this.am;
	}	
}
