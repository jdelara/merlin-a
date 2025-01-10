package adaptersLang.utils;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.henshin.model.Module;

public class HenshinUtils {
	public static Module load(IFile f) {
		ResourceSet resourceSet = new ResourceSetImpl();

        // register UML
        EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
        packageRegistry.put(HenshinPackage.eNS_URI, HenshinPackage.eINSTANCE);

        // Register XML resource as UMLResource.Factory.Instance
        Map<String,Object> extensionFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
        extensionFactoryMap.put("xmi", new XMIResourceFactoryImpl());

        
        Resource resource = (Resource) resourceSet.createResource(URI.createFileURI(f.getFullPath().toOSString()));

        // try to load the file into resource
        try {
			resource.load(null);
		} catch (IOException e) {			
			return null;
		}
        Module m = (Module) resource.getContents().get(0);
		return m;
	}
	
	public static IFile getFile(String fname) {		
		for (IProject p : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (!p.isOpen()) continue;
			IFile fl = p.getFile(fname);
			if (fl.exists()) {
				//System.out.println("Ecore file "+fname+" found in "+p.getLocation().toOSString());
				return fl;
			}
		}
		return null;
	}


}
