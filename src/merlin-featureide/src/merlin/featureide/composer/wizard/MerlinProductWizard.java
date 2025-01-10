package merlin.featureide.composer.wizard;

import java.util.List;
import java.io.File;
import java.lang.reflect.Field;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.ovgu.featureide.core.IFeatureProject;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.io.EclipseFileSystem;
import de.ovgu.featureide.ui.actions.generator.BuildProductsPage;
import de.ovgu.featureide.ui.actions.generator.BuildProductsWizard;
import merlin.common.concepts.ConfigurationFragmentPool;
import merlin.common.concepts.SelectedConcepts;
import merlin.common.exporter.PluginUtils;
import merlin.common.issues.IssueLevel;
import merlin.featureide.composer.EcoreComposer;
import merlin.featureide.composer.FeatureProjectWrapper;
import merlin.featureide.composer.configurations.AbstractConfigurationIterator;
import merlin.featureide.composer.configurations.FeatureConfigurationIterator;
import merlin.featureide.composer.configurations.FixedFeatureConfigurationIterator;

public class MerlinProductWizard extends BuildProductsWizard{
	private ConceptSelectorPage csp;
	private IFeatureProject fp;
	private IProject prj;
	private final IPath PRODUCTS_FOLDER = new Path(File.separator+"products"+File.separator);
		
	public MerlinProductWizard(IFeatureProject featureProject, boolean toggleState, IProject prj) {
		super(featureProject, toggleState);
		this.csp = new ConceptSelectorPage(prj);
		this.fp = featureProject;
		this.prj = prj;
	}

	public void addPages() {
		this.addPage(csp);
		super.addPages();				
	}
	
	public boolean isStructureSelected() {
		return this.csp.isStructureSelected();
	}
	
	public List<EPackage> getSelectedConcepts() {
		return this.csp.getSelectedConcepts();
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (csp.equals(page)) return super.getPage(this.fp.getProjectName());
		else return null;
	}
	
	@Override
	public boolean performFinish() {
		AbstractConfigurationIterator it;
		
		Configuration cfg ;
		if (this.isCurrentConfig()) {
			System.out.println("[CAPONE] Current configs");
			it = this.getCurrentConfigurationIterator();
		}
		else {
			System.out.println("[CAPONE] All configs");
			it = new FeatureConfigurationIterator(this.fp.getFeatureModel());			
		}
		
		//it = new FeatureConfigurationIterator(this.fp.getFeatureModel());
		
		EcoreComposer cc = (EcoreComposer) this.fp.getComposer();
		
		SelectedConcepts.clear();
		SelectedConcepts.set(this.csp.getSelectedConcepts());
		for (EPackage pck : SelectedConcepts.get()) {
			String techn = this.csp.getTrafoTechnologyOf(pck);		
			String trafo = this.csp.getTrafoNameOf(pck);
			SelectedConcepts.setConfigs(trafo, new ConfigurationFragmentPool(prj, 
																			 PluginUtils.getExtension(techn), 
																			 this.csp.getFolder(pck), 
																			 this.fp.getFeatureModel()));			
		}
		cfg = it.next();
		int idx = 0;
		this.createProductsFolder();
		this.cleanProductsFolder();
		//IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(project.getLocation());
		while (cfg != null){
			String number = String.format("%05d", idx);
			IPath path = PRODUCTS_FOLDER.append("product"+number+File.separator);
			IFolder fld = this.prj.getFolder(path);			
			cc.buildConfiguration(fld, cfg, "config"+number);
			cfg = it.next();
			idx++;
		}

		//this.showIssues();
		// No point in trying to show errors here, as the composer runs in a separate thread		
		return true;
	}
	
	private void createProductsFolder() {
		IFolder fld = this.prj.getFolder(PRODUCTS_FOLDER);
		if (!fld.exists()) {
			try {
				fld.create(true, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	private void cleanProductsFolder() {
		IFolder fld = this.prj.getFolder(PRODUCTS_FOLDER);
		new Job("Delete products folder") {	
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					fld.delete(true, monitor);
					fld.refreshLocal(2, monitor);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Status.OK_STATUS;
			}
		};		
	}

	private FixedFeatureConfigurationIterator getCurrentConfigurationIterator() {
		IFolder configFolder = this.prj.getFolder("configs");
		FixedFeatureConfigurationIterator fci = new FixedFeatureConfigurationIterator();
		try {
			for ( IResource res: configFolder.members() ) {
				if (res.getName().endsWith(".xml")) {
					java.nio.file.Path configPath = EclipseFileSystem.getPath(res);
					Configuration cfg = this.fp.loadConfiguration(configPath);
					if (cfg!=null)
						fci.addConfiguration(cfg);
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fci;
	}

	private boolean isCurrentConfig() {
		BuildProductsPage bpp = (BuildProductsPage) this.getPages()[1];		
		try {
			Class<BuildProductsPage> cls = (Class<BuildProductsPage>) bpp.getClass();
			Field combo = cls.getDeclaredField("comboGenerate");
			combo.setAccessible(true);
			Object comboValue = combo.get(bpp);
			Combo cmb = (Combo)comboValue;
			if (cmb.getText().equals("All current configurations"))
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private void showIssues() {
		EcoreComposer comp = (EcoreComposer)this.fp.getComposer();
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
		if (comp.getIssues().stream().anyMatch(issue -> issue.getLevel() == IssueLevel.ERROR)) 
			MessageDialog.openError       (window.getShell(), "Merlin", " Products generated with errors");
		else MessageDialog.openInformation(window.getShell(), "Merlin", " Products generated successfully!");
	}
}
