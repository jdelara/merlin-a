package merlin.adaptive.adapters;

import java.util.*;

import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.IndependentUnit;
import org.eclipse.emf.henshin.model.LoopUnit;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;

public class Adapter extends AbstractAdapter {	
	private List<String> rules = new ArrayList<>();
	protected LoopUnit entryRule;
	
	public Adapter(String name, ConfigDiff cfg, String... rules) {
		super(name, cfg);
		this.rules.addAll(Arrays.asList(rules));
	}
	
	@Override public String toString() {
		return this.name+" "+this.diff+" rules: "+this.rules;
	}
	
	public List<String> getRules() {
		return this.rules;
	}
	
	@Override public boolean equals(Object o) {
		if (o==this) return true;
		if (!(o instanceof Adapter)) return false;
		Adapter a = (Adapter) o;
		return this.diff.equals(a.diff) && rules.equals(a.rules);
	}
	
	@Override public int hashCode() {
		return this.diff.hashCode() + rules.hashCode();
	}

	@Override
	public List<String> getSimpleAdapters() {
		ArrayList<String> adp = new ArrayList<>(Arrays.asList(this.name));
		return adp;
	}

	@Override
	public void genLoopUnit(Module hm) {
		if (this.entryRule!= null) return;	// done already
		
		Unit entryUnit = null;
		if (this.rules.size()>1) {		
			IndependentUnit iunit = HenshinFactory.eINSTANCE.createIndependentUnit();
			iunit.setName("all-rules-"+this.name);
			iunit.setActivated(true);
			for (String rule : this.rules) {
				Rule r = this.getHenshinRule(hm, rule);
				iunit.getSubUnits().add(r);
			}
			hm.getUnits().add(iunit);
			entryUnit = iunit;
		}
		else  // just one rule
			entryUnit = this.getHenshinRule(hm, this.rules.get(0));		
		
		this.entryRule = HenshinFactory.eINSTANCE.createLoopUnit();
		this.entryRule.setName("loop-"+this.name);
		this.entryRule.setActivated(true);
		this.entryRule.setSubUnit(entryUnit);
		hm.getUnits().add(this.entryRule);			
	}

	@Override
	public List<LoopUnit> getLoop() {
		return List.of(this.entryRule);
	}

	@Override
	public List<Unit> getMainUnits(Module m) {
		List<Unit> unt = new ArrayList<>();
		for (Rule r : m.getAllRules()) 
			if (this.rules.contains(r.getName())) unt.add(r);		

		return unt;
	}	
}
