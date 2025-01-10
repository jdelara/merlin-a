package merlin.adaptive.trafos;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.IndependentUnit;
import org.eclipse.emf.henshin.model.LoopUnit;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.henshin.model.Unit;

import de.ovgu.featureide.fm.core.configuration.Configuration;
import merlin.adaptive.adapters.AbstractAdapter;
import merlin.adaptive.adapters.Adapter;
import merlin.adaptive.adapters.AdapterKind;
import merlin.adaptive.adapters.Diffs;
import merlin.adaptive.utils.HenshinUtils;

public class MigrationTrafo {
	private Map<Position, Set<AbstractAdapter>> adapters = new LinkedHashMap<>();
	private Configuration src, tar;
	
	public MigrationTrafo(Configuration src, Configuration tar) {
		this.src = src;
		this.tar = tar;
		for (Position p : Position.values()) 
			this.adapters.put(p, new LinkedHashSet<>());		
	}
	
	public void addAdapter(AbstractAdapter adp, Position p) {
		this.adapters.get(p).add(adp);
	}
	
	@Override public String toString() {
		
		return  "from: "+ src.getSelectedFeatureNames().toString()+
				"to : "+ tar.getSelectedFeatureNames().toString()+
				"adapters: "+this.adapters.values();
	}
	
	@Override public boolean equals(Object obj) {
		if (obj==this) return true;
		if (!(obj instanceof MigrationTrafo)) return false;
		MigrationTrafo other = (MigrationTrafo) obj;
		return this.adapters.equals(other.adapters);
	}
	
	@Override public int hashCode() {
		return this.adapters.hashCode();
	}

	public void generate(IProject prj, String henshinFile) {
		generate(prj, henshinFile, null);
	}

	public void generate(IProject prj, String henshinFile, IFile outputTransformationFile) {
		// Extracts the corresponding rules from the henshin file
		IFile hf = prj.getFile(henshinFile);
		if (!hf.exists()) return;
		Module hm = HenshinUtils.load(hf);
		if (hm==null) return;
		this.filterModule(hm);	
		this.addEntryRule2Module(hm);
		this.saveModel(hm, outputTransformationFile!=null? outputTransformationFile : genFileName(prj, henshinFile));
	}

	private void saveModel(Module cloned, IFile hfc) {
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("henshin", new XMIResourceFactoryImpl());

        // Obtain a new resource set
        ResourceSet resSet = new ResourceSetImpl();

        // create a resource
        URI uri = URI.createURI("file:///"+hfc.getLocation().toOSString());
        Resource resource = resSet.createResource(uri);
        resource.getContents().add(cloned);

        // now save the content.
        try {
            resource.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	private IFile genFileName (IProject prj, String henshinFile) {
		String[] parts = henshinFile.split("\\.");
		String featNames = this.genNames();
		
		parts[parts.length-2]+=featNames;
		String result = "";
		for (int i = 0; i < parts.length; i++) {
			if (i>0) result += ".";
			result += parts[i];			
		}
		
		return prj.getFile(result);
	}
	
	private String genNames() {
		List<String> src = this.src.getSelectedFeatures().stream().map(f->f.getName()).collect(Collectors.toList());
		List<String> tar = this.tar.getSelectedFeatures().stream().map(f->f.getName()).collect(Collectors.toList());
		
		List<String> common = new ArrayList<>(src);
		common.retainAll(tar);
		
		src.removeAll(common);
		tar.removeAll(common);
		
		String res = "";
		for (String s : src)
			res += s;
		res+="2";
		for (String s : tar)
			res += s;
		return res;
	}

	private void filterModule(Module hm) {
		List<Unit> toDelete = new ArrayList<>();
		for (Unit f : hm.getUnits()) {
			 if (!this.containsRule(f.getName())) toDelete.add(f);
		}
		hm.getUnits().removeAll(toDelete);
	}
	
	private void addEntryRule2Module(Module hm) {
		List<AbstractAdapter> adapts = this.allAdapters(); 
				
		for (AbstractAdapter ad : adapts) 
			ad.genHenshin(hm);
		
		Unit entryUnit = null; 
		
		if (adapts.size()==1 && adapts.get(0).getMainUnits(hm).size()==1) {
			entryUnit = adapts.get(0).getMainUnits(hm).get(0);
		}
		else {
			IndependentUnit iunit = HenshinFactory.eINSTANCE.createIndependentUnit();
			iunit.setName("all-rules");
			iunit.setActivated(true);
			for (AbstractAdapter ad : this.allAdapters()) {
				for (Unit u : ad.getMainUnits(hm)) 
					iunit.getSubUnits().add(u);			
			}
			hm.getUnits().add(iunit);
			entryUnit = iunit;
		}
		
		LoopUnit unit = HenshinFactory.eINSTANCE.createLoopUnit();
		unit.setName("main");
		unit.setActivated(true);
		unit.setSubUnit(entryUnit);
		hm.getUnits().add(unit);	
			
			
		/*
		  Map<Position, LoopUnit> layers = new LinkedHashMap<>(); 
		  for (Position pos : Position.values()) {
			// add independent unit with all module rules
			List<Rule> allRulesAt = this.allRulesAt(hm, pos);
			if (allRulesAt.isEmpty()) continue;
			IndependentUnit iunit = HenshinFactory.eINSTANCE.createIndependentUnit();
			iunit.setName("all-rules-"+pos);
			iunit.setActivated(true);
			this.allRulesAt(hm, pos).forEach(rule -> iunit.getSubUnits().add(rule));
			hm.getUnits().add(iunit);

			// add loop unit which recursively calls the previous independent unit
			LoopUnit unit = HenshinFactory.eINSTANCE.createLoopUnit();
			layers.put(pos, unit);
			unit.setName("layer-"+pos);
			unit.setActivated(true);
			unit.setSubUnit(iunit);
			hm.getUnits().add(unit);
		}*/
		
		/*SequentialUnit lunit = HenshinFactory.eINSTANCE.createSequentialUnit();
		lunit.setName("main");
		lunit.setActivated(true);
		lunit.getSubUnits();
		// we need exactly this order
		if (layers.get(Position.PRE)!=null)
			lunit.getSubUnits().add(layers.get(Position.PRE));
		if (layers.get(Position.INC)!=null)
			lunit.getSubUnits().add(layers.get(Position.INC));
		if (layers.get(Position.POST)!=null)
			lunit.getSubUnits().add(layers.get(Position.POST));
		hm.getUnits().add(lunit);*/
	}
	
	public List<AbstractAdapter> allAdapters() {
		Set<AbstractAdapter> all = new LinkedHashSet<>();
		for (Position p : Position.values()) 
			all.addAll(this.adapters.get(p));		
		return new ArrayList<>(all);
	}

	private List<Rule> allRulesAt(Module hm, Position p) {
		List<Rule> rules = new ArrayList<>();
		for (Rule r : hm.getAllRules()) 
			if (this.isRuleOf(r, p)) rules.add(r);
		
		return rules;		
	}

	private boolean isRuleOf(Rule r, Position p) {
		for (AbstractAdapter adapter : this.adapters.get(p)) 
			if (adapter.getRules().contains(r.getName())) return true;		
		return false;
	}

	private boolean containsRule(String name) {
		for (Position p: Position.values()) {
			for (AbstractAdapter a : this.adapters.get(p)) 
				if (a.getRules().contains(name)) return true;
		}
		return false;
	}

	public List<String> getAll(Diffs df) {
		List<String> features = new ArrayList<>();
		for (Position p: Position.values()) {
			for (AbstractAdapter adp : this.adapters.get(p)) 
				features.addAll(adp.getDiff().get(df));
		}
		return features;
	}
	
	public List<String> getAllFeatures() {
		Set<String> features = new LinkedHashSet<>();
		for (Diffs d : Diffs.values())
			features.addAll(this.getAll(d));		
		return new ArrayList<>(features);
	}

	public boolean containsAdapter(AbstractAdapter ad) {
		return  this.adapters.get(Position.PRE).contains(ad) ||
				this.adapters.get(Position.INC).contains(ad) ||
				this.adapters.get(Position.POST).contains(ad);	// flat, we could inspect composite adapters...
	}

	public List<String> getAllRules() {
		List<String> rules = new ArrayList<>();
		for (AbstractAdapter aa : this.allAdapters()) {
			rules.addAll(aa.getRules());
		}
		return rules;
	}
	
	public List<AbstractAdapter> allAdapters(AdapterKind ak) {
		return this.allAdapters().stream().filter(a->a.getKind().equals(ak)).collect(Collectors.toList());
	}
}
