package merlin.adaptive.adapters;

import java.util.*;

import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.LoopUnit;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.henshin.model.Unit;

public class CompositeAdapter extends AbstractAdapter{
	private Set<AbstractAdapter> adapters = new LinkedHashSet<>();
	private SequentialUnit sunit;

	public CompositeAdapter(String n, ConfigDiff cd) {
		super(n, cd);		
	}

	public boolean addAdapter(AbstractAdapter a) {
		return this.adapters.add(a);
	}

	@Override public boolean equals(Object o) {
		if (o==this) return true;
		if (!(o instanceof CompositeAdapter)) return false;
		CompositeAdapter ca = (CompositeAdapter) o;
		return ca.adapters.equals(this.adapters);
	}

	@Override public int hashCode() {
		return this.adapters.hashCode();
	}
	
	@Override
	public List<String> getSimpleAdapters() {
		ArrayList<String> sa = new ArrayList<>();
		for (AbstractAdapter a : this.adapters) 
			sa.addAll(a.getSimpleAdapters());
		return sa;
	}
	
	@Override public boolean contains(AbstractAdapter aa) {
		boolean isSame = super.contains(aa);		
		if (isSame) return true;
		List<String> simAdapt = this.getSimpleAdapters();
		List<String> aaAdapts = aa.getSimpleAdapters();
		return simAdapt.containsAll(aaAdapts);
		/*for (AbstractAdapter a : this.adapters)
			if (a.contains(aa)) return true;*/
		//return false;
	}

	@Override
	public List<String> getRules() {
		List<String> rules = new ArrayList<>();
		for (AbstractAdapter aa : this.adapters) 
			rules.addAll(aa.getRules());
		
		return rules;
	}
	
	@Override
	public void genHenshin(Module hm) {
		if (this.sunit!=null) return;
		this.sunit = HenshinFactory.eINSTANCE.createSequentialUnit();
		this.sunit.setName(this.name);
		
		for (AbstractAdapter aa: this.adapters)
			aa.genLoopUnit(hm);
		
		for (LoopUnit lu : this.getLoop()) 
			sunit.getSubUnits().add(lu);
		
		hm.getUnits().add(sunit);
	}

	@Override
	public void genLoopUnit(Module hm) {
		for (AbstractAdapter aa : this.adapters)
			aa.genLoopUnit(hm);
	}

	@Override
	public List<LoopUnit> getLoop() {
		List<LoopUnit> entryRules = new ArrayList<>();
		for (AbstractAdapter aa : this.adapters) 
			entryRules.addAll(aa.getLoop());
		
		return entryRules;
	}

	@Override
	public List<Unit> getMainUnits(Module m) {
		return List.of(this.sunit);
	}
}
