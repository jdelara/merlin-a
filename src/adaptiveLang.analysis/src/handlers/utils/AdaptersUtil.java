package handlers.utils;

import adapters.AdapterModel;
import adapters.AdaptersPackage;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class AdaptersUtil {
	public static AdapterModel load(IFile f) {
		ResourceSet resourceSet = new ResourceSetImpl();

        // register UML
        EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
        packageRegistry.put(AdaptersPackage.eNS_URI, AdaptersPackage.eINSTANCE);

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
        AdapterModel m = (AdapterModel) resource.getContents().get(0);
		return m;
	}
}
