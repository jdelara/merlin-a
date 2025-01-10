package adaptiveLang.gentree.generation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenLanguageVariants {
	private String rootPackageName;
	private String modelPluginID;
	private HashMap<String, List<String>> mmVariants = new HashMap<String, List<String>>();
	
	public void setRootPackageName (String name) { 
		this.rootPackageName = name; 
	} 
	
	public void setModelPluginID (String id) { 
		this.modelPluginID = id; 
	} 
	
	public String getRootPackageName () { 
		return this.rootPackageName; 
	} 
	
	public String getEcorePackageName () {
		System.out.println("EOO!: "+this.rootPackageName.substring(0,1).toUpperCase() + this.rootPackageName.substring(1) + "Package");
		return this.rootPackageName.substring(0,1).toUpperCase() + this.rootPackageName.substring(1) + "Package"; 
	} 
	
	public String getModelPluginID () { 
		return this.modelPluginID; 
	} 
	
	public void addMetaelement (String name) { 
		if (!mmVariants.containsKey(name)) 
			mmVariants.put(name, new ArrayList<String>()); 
	}
	
	public void addVariant (String variant, String metaelement) { 
		addMetaelement(metaelement);
		mmVariants.get(metaelement).add(variant);
	}
	
	public List<String> getVariants () {
		Set<String>  variantsSet  = new HashSet<String>();
		List<String> variantsList = new ArrayList<String>();
		for (Collection<String> values : mmVariants.values())
			variantsSet.addAll(values);
		variantsList.addAll(variantsSet);
		return variantsList;		
	}
	
	public Set<String> getMetaelements () {
		return mmVariants.keySet();
	}

	public List<String> getVariants (String metaelement) {
		return mmVariants.get(metaelement);
	}
}
