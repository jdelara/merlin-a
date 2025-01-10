package adaptiveLang.gentree.handler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;

import adaptiveLang.gentree.generation.GenLanguageVariants;
import de.ovgu.featureide.core.IFeatureProject;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.configuration.io.ConfigurationLoader;
import merlin.adaptive.handlers.AdaptersFile;
import merlin.common.utils.EMFUtils;
import merlin.featureide.composer.EcoreProductGenerator;
import merlin.featureide.composer.FeatureProjectWrapper;

public class MenuHandler extends AbstractHandler {
	
	private String LANGUAGE_VARIANTS_FOLDER = null;
	private String ADAPTERS_FILE = null;
	private Shell  shell = null;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.shell = HandlerUtil.getActiveWorkbenchWindowChecked(event).getShell();
		
		// obtain selected file
		IFile file = null;
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			Object first = ((IStructuredSelection)selection).getFirstElement();
			file = (IFile)Platform.getAdapterManager().getAdapter(first, IFile.class);
			if (file == null)
				if (first instanceof IAdaptable)
					file = (IFile)((IAdaptable)first).getAdapter(IFile.class);
		}
		
		// validate selected file
		IFeatureProject  ifproject = new FeatureProjectWrapper(file);
		FeatureModelFormula fmf    = new FeatureModelFormula(ifproject.getFeatureModel());
		if (fmf.getFeatureModel()==null) {
			MessageDialog.openError(shell, "Tree editor generator", "The ecore file does not specify a valid feature model.");
			return Status.ERROR;
		}
		
		// select adapters file and language configurations folder, and generate editor
		GentreeConfigDialog dialog = new GentreeConfigDialog(null, file.getProject());
		dialog.create();
		if (dialog.open()==Window.OK) {
			LANGUAGE_VARIANTS_FOLDER = dialog.getConfigurationsFolder();
			ADAPTERS_FILE            = dialog.getAdaptersFile();
			gentree(file);
		}
		
		return Status.OK;
	}

	/**
	 * Generates tree editor from ecore file.
	 */
	private void gentree (IFile ecorefile) {				
		try {
			new ProgressMonitorDialog(shell).run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException {
					IProject modelProject = null, editProject = null, editorProject = null;
					List<Integer> taskTime = Arrays.asList(1, 1, 41, 23, 25, 6, 2);
					int task = 0;
					SubMonitor       subMonitor  = SubMonitor.convert(progressMonitor, taskTime.stream().mapToInt(i->i).sum());
					IProgressMonitor nullMonitor = new NullProgressMonitor();
					
					try { 
						// ------------------------------------------------------------------------
						progressMonitor(subMonitor, "Loading ecore meta-model", taskTime.get(task++));

						// load ecore file 
						EPackage rootpackage = readEcore(ecorefile);
						
						// enable generation of a Validator Class
						enableValidatorClassGeneration(rootpackage);
						
						// ------------------------------------------------------------------------
						progressMonitor(subMonitor, "Creating generator model", taskTime.get(task++));

						// create genmodel file
						GenModel genmodel = createGenmodel(rootpackage.getName()); 
						genmodel.setComplianceLevel(GenJDKLevel.JDK80_LITERAL);
						genmodel.setModelPluginID (ecorefile.getProject().getName()+".model");
						genmodel.setModelDirectory(ecorefile.getProject().getName()+".model/src");		
						genmodel.setModelName(rootpackage.getName());
						genmodel.setRootExtendsInterface("org.eclipse.emf.ecore.EObject");
						genmodel.setRootExtendsClass("org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container");
						genmodel.setOperationReflection(true);			
						genmodel.initialize(Collections.singleton(rootpackage));
						genmodel.setForceOverwrite(true);
						
						genmodel.reconcile();
						genmodel.setCanGenerate(true);
						genmodel.setValidateModel(true);
						
//						// save genmodel
//						String filename = ecorefile.getRawLocationURI().toString();
//						filename = filename.substring(0, filename.lastIndexOf(".ecore")) + ".genmodel";
//						this.saveGenmodel(genmodel, filename);
					
						// select dynamic templates for code generation 
						Bundle bundle = Platform.getBundle("adaptiveLang.gentree");
						URL    url    = FileLocator.find(bundle, new Path("templates"), null);
						url = FileLocator.toFileURL(url);
						java.io.File file = URIUtil.toFile(URIUtil.toURI(url));
						genmodel.setDynamicTemplates(true);
						genmodel.setTemplateDirectory(file.toString());
						  
						// load genmodel in resource
						String filename = ecorefile.getRawLocationURI().toString();
						filename        = filename.substring(0, filename.lastIndexOf(".ecore")) + ".genmodel";
						loadGenmodel(genmodel, filename);			
					
						// ------------------------------------------------------------------------
						progressMonitor(subMonitor, "Generating editor (model code)", 0);

						// generate model code, edit code, editor code
						GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(GenModelPackage.eNS_URI, GenModelGeneratorAdapterFactory.DESCRIPTOR);
						Generator generator = new Generator();
						generator.requestInitialize();
						generator.setInput (genmodel);
						modelProject  = createModelProject (genmodel, nullMonitor);
						editProject   = createEditProject  (genmodel, nullMonitor);
						editorProject = createEditorProject(genmodel, nullMonitor);
						generateProject(generator, genmodel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, subMonitor, taskTime.get(task++));
						
						// ------------------------------------------------------------------------
						progressMonitor(subMonitor, "Generating editor (edit code)", 0);						
						generateProject(generator, genmodel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, subMonitor, taskTime.get(task++));
						
						// ------------------------------------------------------------------------
						progressMonitor(subMonitor, "Generating editor (editor code)", 0);
						generateProject(generator, genmodel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE, subMonitor, taskTime.get(task++));
						
						// ------------------------------------------------------------------------
						progressMonitor(subMonitor, "Generating information of language variants", 0); 
						task++;

						// collect data needed for the generation of language configurations
						GenLanguageVariants genclass = createGenLanguageConfiguration(ecorefile, rootpackage, genmodel.getModelPluginID());
						
						// generate non-predefined jet templates: LanguageVariants.java, LanguageVariantManager.java, IHook, OnSave.java, OnEdit.java
						executeJetTemplate("model",  rootpackage.getName() + "/variants", "LanguageVariants", bundle, genmodel.getModelPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("model",  rootpackage.getName() + "/variants", "ModelMigration", bundle, genmodel.getModelPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("edit",   rootpackage.getName() + "/variants", "LanguageVariantsManager", bundle, genmodel.getEditPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("editor", rootpackage.getName() + "/hooks", "IHook", bundle, genmodel.getEditorPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("editor", rootpackage.getName() + "/hooks", "OnSave", bundle, genmodel.getEditorPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("editor", rootpackage.getName() + "/hooks", "OnEdit", bundle, genmodel.getEditorPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("editor", rootpackage.getName() + "/presentation", "ExplorePropertiesHandler", bundle, genmodel.getEditorPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("editor", rootpackage.getName() + "/presentation", "ExplorePropertiesDialog", bundle, genmodel.getEditorPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("editor", rootpackage.getName() + "/presentation", "SelectVariantDialog", bundle, genmodel.getEditorPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("editor", rootpackage.getName() + "/variants", "VariantRecommender", bundle, genmodel.getEditorPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("editor", rootpackage.getName() + "/variants", "SmallestVariantRecommender", bundle, genmodel.getEditorPluginID(), genclass, subMonitor, 1);
						executeJetTemplate("editor", rootpackage.getName() + "/presentation", "SmallestVariantHandler", bundle, genmodel.getEditorPluginID(), genclass, subMonitor, 1);
						this.copyIcons(ecorefile.getProject().getName()+".model.editor");
						
						// ------------------------------------------------------------------------
						progressMonitor(subMonitor, "Generating model migration transformations", taskTime.get(task++));

						// generate migration transformations between language configurations
						genMigrationTransformations(ecorefile, genclass.getVariants(), modelProject);
					}
					catch (OperationCanceledException e) { // editor generation has been cancelled
						deleteProjects(modelProject, editProject, editorProject, nullMonitor);
						throw new InterruptedException();
					}
					catch (RuntimeException|       // error while generating model, edit or editor project
						   JETException|CoreException|IOException|URISyntaxException| // error while executing jet templates
						   ExecutionException e) { // error while generating migration transformations
						// e.printStackTrace();
						deleteProjects(modelProject, editProject, editorProject, nullMonitor);
						throw new InvocationTargetException(e);
					} 
					finally {
						progressMonitor.done();
					}
				}

				private void copyIcons(String projectPath) {
					String path = "templates/editor/";
					String[] icons = 	{"explore_properties.gif",
										 "small.gif"};
			        try {
			            // Get the bundle for the current plugin
			            Bundle bundle = Platform.getBundle("adaptiveLang.gentree"); 
			            
			            for (String icon: icons) {
				            // Resolve the file path within the plugin
				            InputStream fileStream = bundle.getEntry(path+icon).openStream();
	
				            copyIcon(icon, ecorefile, fileStream);
			            }

			        } catch (Exception e) {
			            e.printStackTrace();
			        }
				}

				private void copyIcon(String name, IFile ecorefile, InputStream fileStream) throws IOException {
					// Resolve the target path in the workspace
					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					IPath workspacePath = workspace.getRoot().getLocation().
							append(ecorefile.getProject().getName()+".model.editor").
							append("icons").append("full").append("obj16").append(name);

					// Ensure the target directory exists
					File targetFile = workspacePath.toFile();
					targetFile.getParentFile().mkdirs();

					// Copy the file
					try (OutputStream outStream = Files.newOutputStream(targetFile.toPath())) {
					    byte[] buffer = new byte[1024];
					    int bytesRead;
					    while ((bytesRead = fileStream.read(buffer)) != -1) {
					        outStream.write(buffer, 0, bytesRead);
					    }
					}

					System.out.println("File copied successfully to: " + targetFile.getAbsolutePath());
				}
			});			
			MessageDialog.openInformation(shell, "Tree editor generator", "Editor generation completed!");
		}
		catch (InterruptedException e) { e.printStackTrace(); }
		catch (InvocationTargetException e) { MessageDialog.openError(shell, "Tree editor generator", "Editor generation failed"); }
	}
	
	/**
	 * Deletes the received projects.
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param progressMonitor
	 */
	private void deleteProjects(IProject p1, IProject p2, IProject p3, IProgressMonitor progressMonitor) {
		if (p1.exists()) try { p1.delete(true, progressMonitor); } catch (CoreException e) {} 
		if (p2.exists()) try { p2.delete(true, progressMonitor); } catch (CoreException e) {}
		if (p3.exists()) try { p3.delete(true, progressMonitor); } catch (CoreException e) {}
	}
	
	/**
	 * Returns package inside ecore file.
	 * @throws IOException 
	 */
	private EPackage readEcore (IFile ecore) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI(ecore.getRawLocationURI().toString()));
		resource.load(null);
		EPackage rootpackage = (EPackage)(resource.getContents().get(0));
		// TODO: return all packages, instead of only the first one
		return rootpackage;
	}
	
	/**
	 * Forces the generation of a Validator Class for the metamodel. 
	 */
	public void enableValidatorClassGeneration (EPackage rootpackage) {
		// if the metamodel has OCL invariants, do nothing
		if (rootpackage.getEClassifiers().isEmpty() || 
			rootpackage.getEClassifiers().stream().anyMatch(eclassifier -> !EMFUtils.getInvariants(eclassifier).isEmpty()))
			return;
		
		// otherwise, add dummy invariant to metamodel to enable the generation of a Validator Class
		EAnnotation ann;
		if (!rootpackage.getEAnnotations().stream().anyMatch(eannotation -> eannotation.getSource().equals(EMFUtils.ECORE))) {					
			ann = EcoreFactory.eINSTANCE.createEAnnotation();
			ann.setSource(EMFUtils.ECORE);
			ann.getDetails().put("invocationDelegates", EMFUtils.OCLPIVOT);
			ann.getDetails().put("settingDelegates",    EMFUtils.OCLPIVOT);
			ann.getDetails().put("validationDelegates", EMFUtils.OCLPIVOT);			
			rootpackage.getEAnnotations().add(ann);
		}		
		EClassifier classifier = rootpackage.getEClassifiers().get(0);
		ann = EcoreFactory.eINSTANCE.createEAnnotation();
		ann.setSource(EMFUtils.ECORE);
		ann.getDetails().put("Constraints", "dummy");
		classifier.getEAnnotations().add(ann);
		ann = EcoreFactory.eINSTANCE.createEAnnotation();
		ann.setSource(EMFUtils.OCLPIVOT);
		ann.getDetails().put("dummy", "true");		
		classifier.getEAnnotations().add(ann);
	}	
	
	/**
	 * Loads genmodel in resource.
	 */
	private Resource loadGenmodel (GenModel genmodel, String filename) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI(filename));
		resource.getContents().add(genmodel);
        return resource;
	}
	
	/**
	 * Creates genmodel file.
	 */
	private GenModel createGenmodel (String basepackage) {
//		GenModel genmodel = GenModelFactory.eINSTANCE.createGenModel();
		GenModel genmodel = new GenModelImpl() {
			@Override
			public List<String> getModelRequiredPlugins () {
				List<String> requiredplugins = super.getModelRequiredPlugins(); 
				requiredplugins.add("org.eclipse.emf.henshin.interpreter");
				return requiredplugins;
			}
			@Override
			public List<String> getEditRequiredPlugins () {
				List<String> requiredplugins = super.getEditRequiredPlugins(); 
				requiredplugins.add("org.eclipse.ui");
				requiredplugins.add("org.eclipse.ui.ide");
				requiredplugins.add("org.eclipse.core.resources");
				return requiredplugins;
			}
			@Override 
			public List<String> getModelQualifiedPackageNames() {
				List<String> packages = super.getModelQualifiedPackageNames(); 
				packages.add(basepackage + ".variants");
				return packages;			
			}
			@Override 
			public List<String> getEditQualifiedPackageNames() {
				List<String> packages = super.getEditQualifiedPackageNames(); 
				packages.add(basepackage + ".variants");
				return packages;			
			}
		};
		return genmodel;
	}
	
	/**
	 * Saves genmodel file.
	 * @throws IOException 
	 */
	private void saveGenmodel (GenModel genmodel, String filename) throws IOException {
		URI genmodelURI = URI.createURI(filename);
        XMIResourceImpl genmodelrs = new XMIResourceImpl(genmodelURI);
        genmodelrs.getContents().add(genmodel);
        genmodelrs.save(Collections.EMPTY_MAP);
	}
	
	/**
	 * Creates a plugin project with the given name.
	 * @throws CoreException 
	 */
	private IProject createProject (String name, IProgressMonitor progressMonitor) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(name);
		if (!project.exists())
			project.create(progressMonitor);	
		project.open(progressMonitor);
		return project;
	}
	
	/**
	 * Creates model project with the given name.
	 * @throws CoreException 
	 */
	private IProject createModelProject (GenModel genmodel, IProgressMonitor progressMonitor) throws CoreException {
		IProject project = createProject(genmodel.getModelPluginID(), progressMonitor); 
		addNature(project, JavaCore.NATURE_ID, progressMonitor);
		addNature(project, "org.eclipse.pde.PluginNature", progressMonitor);
		IJavaProject jproject = JavaCore.create(project);
		List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
		classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER")));  // jre libraries
		classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));     // plugin libraries
		classpathEntries.add(0, JavaCore.newSourceEntry(project.getFolder("/src").getFullPath()));              // source folder
		jproject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]), progressMonitor);
		return project;
	}
	
	/**
	 * Creates edit project with the given name.
	 * @throws CoreException 
	 */
	private IProject createEditProject (GenModel genmodel, IProgressMonitor progressMonitor) throws CoreException {
		return createProject(genmodel.getEditPluginID(), progressMonitor);
	}
	
	/**
	 * Creates editor project with the given name.
	 * @throws CoreException 
	 */
	private IProject createEditorProject (GenModel genmodel, IProgressMonitor progressMonitor) throws CoreException {
		return createProject(genmodel.getEditorPluginID(), progressMonitor);
	}

	/**
	 * Generates project from genmodel file.
	 * @param generator
	 * @param genmodel
	 * @param projectType
	 * @param progressMonitor
	 * @param ticks
	 */
	private void generateProject(Generator generator, GenModel genmodel, String projectType, IProgressMonitor progressMonitor, int ticks) {
		Monitor    monitor    = new BasicMonitor.EclipseSubProgress(progressMonitor, ticks);
		Diagnostic diagnostic = generator.generate(genmodel, projectType, monitor);
		if (diagnostic.getSeverity() == Diagnostic.ERROR) { 
			for (Diagnostic d : diagnostic.getChildren()) {
				if (d.getSeverity() == Diagnostic.ERROR) {
					System.out.println(d.getMessage());
					System.out.println(d.getSource());
					System.out.println(d.getData());					
				}
			}					
			throw new RuntimeException("Problems generating project "+projectType);
		}		
		monitor.done();
	}

	/**
	 * Saves file with the given name in the given folder.
	 * @throws CoreException 
	 * @throws IOException 
	 */
	private void saveJavafile (String projectname, String foldername, String filename, String text) throws CoreException, IOException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectname);
		IFolder  folder  = project.getFolder(foldername);
		if (!folder.exists())
			folder.create(true, false, null);
		IFile file = folder.getFile(filename);
		InputStream stream = new ByteArrayInputStream(text.getBytes());
		if (file.exists()) 
		     file.setContents(stream, true, true, null);
		else file.create(stream, true, null);
		stream.close();		
	}
	
	/**
	 * Add nature to project.
	 * @throws CoreException 
	 */
	private void addNature (IProject project, String nature, IProgressMonitor progressMonitor) throws CoreException {
		IProjectDescription description = project.getDescription();			
		if (!description.hasNature(nature)) {
			String[] natureids  = description.getNatureIds();
			String[] natureids2 = new String[natureids.length+1];
			System.arraycopy(natureids, 0, natureids2, 0, natureids.length);
			natureids2[natureids.length] = nature;
			description.setNatureIds(natureids2);
			project.setDescription(description, progressMonitor);
		}
	}
	
	/**
	 * Creates an object with the needed data to generate the language variants.
	 * @param project
	 * @param rootpackage
	 * @param pluginID ID of plugin that will contain the migration transformations
	 * @throws CoreException 
	 * @throws IOException 
	 */
	private GenLanguageVariants createGenLanguageConfiguration (IFile ecore, EPackage rootpackage, String pluginID) throws CoreException, IOException {
		GenLanguageVariants genclass = new GenLanguageVariants();
		
		// java package names, plugin ids
		genclass.setRootPackageName(rootpackage.getName());
		genclass.setModelPluginID(pluginID);
		
		// 150 metamodel
		for (EClassifier classifier : rootpackage.getEClassifiers()) {
			genclass.addMetaelement(classifier.getName());
			if (classifier instanceof EClass) {
				for (EStructuralFeature feature : ((EClass)classifier).getEAllStructuralFeatures()) {
					genclass.addMetaelement(classifier.getName() + "." + feature.getName()); // feature
				}
				EMap<String, String> invariants = EMFUtils.getInvariants(classifier);
				for (String invariant : invariants.keySet()) {
					genclass.addMetaelement(classifier.getName() + "_" + invariant); // invariant
				}
			}
		}
		
		// configurations
		IFeatureProject  ifproject = new FeatureProjectWrapper(ecore);
		FeatureModelFormula fmf    = new FeatureModelFormula(ifproject.getFeatureModel());
		ConfigurationLoader loader = new ConfigurationLoader();
		EcoreProductGenerator epg  = null;
		List<Configuration> configs = null;
		String filename=null, variant=null;
		EPackage        epackage   = null;
		Resource        mmvariant  = null;
		IFolder         folder     = ecore.getProject().getFolder(LANGUAGE_VARIANTS_FOLDER);
		IResource[]     files      = folder.members();
		for (IResource file : files) {			
			if (file instanceof IFile && file.getName().endsWith(".xml")) {
				filename = file.getName();
				variant  = filename.substring(0, filename.lastIndexOf(".xml"));
				epackage = readEcore(ecore);
				configs  = loader.loadConfigurations(fmf, file/*folder*/.getLocation().toString());
				if (!configs.isEmpty()) {
					epg       = new EcoreProductGenerator(epackage.eResource(), ecore.getName().replace(".ecore", ""));
					mmvariant = epg.genProduct(configs.get(0), variant);
					epackage  = ((EPackage)mmvariant.getContents().get(0));
					for (EClassifier classifier : epackage.getEClassifiers()) {
						genclass.addVariant(variant, classifier.getName());
						if (classifier instanceof EClass) {
							for (EStructuralFeature feature : ((EClass)classifier).getEAllStructuralFeatures()) {
								genclass.addVariant(variant, classifier.getName() + "." + feature.getName());
							}
							EMap<String, String> invariants = EMFUtils.getInvariants(classifier);
							for (String invariant : invariants.keySet()) {
								genclass.addVariant(variant, classifier.getName() + "_" + invariant);
							}
						}
					}
				}
			}
		}
		
		return genclass;
	}
	
	/**
	 * Executes JEt template.
	 * @throws JETException 
	 * @throws IOException 
	 * @throws CoreException 
	 */
	private void executeJetTemplate (String pathTemplate, String pathOutput, String className, Bundle bundle, String pluginID, GenLanguageVariants genclass, IProgressMonitor progressMonitor, int ticks) throws JETException, CoreException, IOException {
		Monitor     monitor     = new BasicMonitor.EclipseSubProgress(progressMonitor, ticks);
		ClassLoader classloader = getClass().getClassLoader();
		String      template    = bundle.getEntry("/").toString() + "templates/" + pathTemplate + "/" + className + ".javajet";
		JETEmitter  emitter     = new JETEmitter(template, classloader);
		emitter.addVariable("SOME_NAME", bundle.getSymbolicName());
		String      text        = emitter.generate(monitor, new Object[] {genclass});
		saveJavafile(pluginID, "/src/" + pathOutput, className+".java", text);
		monitor.done();
	}

	/**
	 * Generates migration transformations between the received language variants.
	 * @throws ExecutionException 
	 */
	private void genMigrationTransformations (IFile ecorefile, List<String> variants, IProject outputProject) throws ExecutionException {
		IProject ecoreproject = ecorefile.getProject();
		IFile    adaptersfile = ecoreproject.getFile(ADAPTERS_FILE);
		String variant1File, variant2File;
		AdaptersFile adaptersfile2 = new AdaptersFile(adaptersfile);
		for (String variant1 : variants) 
			for (String variant2 : variants)
				if (!variant1.equals(variant2)) {
					variant1File = LANGUAGE_VARIANTS_FOLDER + java.io.File.separator + variant1 + ".xml";
					variant2File = LANGUAGE_VARIANTS_FOLDER + java.io.File.separator + variant2 + ".xml";
					adaptersfile2.generateTransformation(variant1File, variant2File, outputTransformationFile(outputProject, variant1, variant2));
				}
	}
	
	private IFile outputTransformationFile (IProject outputProject, String sourceVariant, String targetVariant) {
		return outputProject.getFile(java.io.File.separator + "trafos" + java.io.File.separator + sourceVariant + "-" + targetVariant + ".henshin"); 
	}
	
	private void progressMonitor (SubMonitor subMonitor, String taskName, int timePercentage) {
		if (subMonitor.isCanceled()) throw new OperationCanceledException();	
		subMonitor.setTaskName(taskName);
		subMonitor.split(timePercentage);		
	}
}
