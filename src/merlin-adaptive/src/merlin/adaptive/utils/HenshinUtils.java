package merlin.adaptive.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.resource.HenshinResourceFactory;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

public class HenshinUtils {
	
	public static Module load (IFile f) {
		Module m = null;
		try {
			// load transformation module
			HenshinResourceSet resourceSet = new HenshinResourceSet();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("henshin", new HenshinResourceFactory());
			m = resourceSet.getModule(URI.createFileURI(f.getLocation().toOSString()), true);
			
			// map URI of local ecore files into registered URIs 
			Map<URI, URI> epackages = new HashMap<URI, URI>();
			for (EPackage imp : m.getImports()) {
				// if (imp.eIsProxy()) { ... }
				URI registeredURI = URI.createURI(imp.getNsURI());
				epackages.put(imp.eResource().getURI(), registeredURI);
				imp.eResource().setURI(registeredURI);
			}

			// update URI of module resources
			for (Resource resource : resourceSet.getResources()) {
				if (epackages.containsKey(resource.getURI())) {
					resource.setURI(epackages.get(resource.getURI()));
				}
			}

			// update URI of rule nodes, edges and attributes
			for (EPackage epackage : m.getImports()) {
				Iterator<EObject> it = m.eAllContents();
				while (it.hasNext()) {
					EObject henshinobj = it.next();
					if      (henshinobj instanceof Node)      updateCrossReference((Node)henshinobj, epackage);
					else if (henshinobj instanceof Edge)      updateCrossReference((Edge)henshinobj, epackage);
					else if (henshinobj instanceof Attribute) updateCrossReference((Attribute)henshinobj, epackage);
				}				
			}
		}
		catch (Exception e) { e.printStackTrace(); }
		return m;
	}
	
	private static void updateCrossReference (Node node, EPackage epackage) {
		EClass eclass = (EClass)epackage.getEClassifier(node.getType().getName());
		node.setType(eclass);
	}

	private static void updateCrossReference (Attribute attribute, EPackage epackage) {
		EClass eclassold = attribute.getNode().getType();
		EClass eclassnew = (EClass)epackage.getEClassifier(eclassold.getName());
		for (EAttribute attributenew : eclassnew.getEAllAttributes()) 
			if (attributenew.getName().equals(attribute.getType().getName())) {
				attribute.setType(attributenew);
				break;
			}
	}

	private static void updateCrossReference (Edge edge, EPackage epackage) {
		EClass eclassold = edge.getSource().getType();
		EClass eclassnew = (EClass)epackage.getEClassifier(eclassold.getName());
		for (EReference referencenew : eclassnew.getEAllReferences()) 
			if (referencenew.getName().equals(edge.getType().getName())) {
				edge.setType(referencenew);
				break;
			}
	}
}
