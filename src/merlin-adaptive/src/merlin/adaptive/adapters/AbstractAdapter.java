package merlin.adaptive.adapters;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.henshin.model.LoopUnit;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;

public abstract class AbstractAdapter {
	protected String name;
	protected ConfigDiff diff;	
	protected AdapterKind adapterKind = AdapterKind.ATOMIC;
	protected boolean isNegative = false;
	
	public AbstractAdapter(String n, ConfigDiff cd) {
		this.name = n;
		this.diff = cd;
	}
	
	public AdapterKind getKind() {
		return this.adapterKind;
	}
	
	public void setKind(AdapterKind ak) {
		this.adapterKind = ak;
	}
	
	@Override public String toString() {
		return this.name;
	}
	
	public String name() {
		return this.name;
	}

	public ConfigDiff getDiff() {
		return this.diff;
	}
	
//	public boolean canCompose(AbstractAdapter a) {
//		return this.getDiff().canCompose(a.getDiff());
//	}

	public boolean canCompose(AbstractAdapter a) {
		if (!this.getDiff().canCompose(a.getDiff())) return false;
		return !hasCommonAdapters(a);
	}

	
	public boolean hasCommonAdapters(AbstractAdapter a) {
		List<String> la = this.getSimpleAdapters();		
		//System.out.println(this.name+" simple adapters: "+la);
		List<String> lb = a.getSimpleAdapters();
		//System.out.println(a.name+" simple adapters: "+lb);
		//System.out.println("-----------------------------------");
		for (String s: lb)
			if (la.contains(s)) return true;
		return false;
	}
	
	public abstract List<String> getSimpleAdapters();

	public boolean contains(AbstractAdapter a1) {
		return this.equals(a1);
	}

	public abstract List<String> getRules();
	
	public boolean dependent(AbstractAdapter a2) {
		return containsSome(this.diff.get(Diffs.NEG2POS), a2.diff.get(Diffs.POS2NEG)) ||
			   containsSome(this.diff.get(Diffs.POS2NEG), a2.diff.get(Diffs.NEG2POS)) ||
			   containsSome(this.diff.get(Diffs.POS2NEG), a2.diff.get(Diffs.NEG))     ||
			   containsSome(this.diff.get(Diffs.NEG2POS), a2.diff.get(Diffs.POS));
	}

	private boolean containsSome(Set<String> set, Set<String> set2) {
		for (String s2 : set2)
			if (set.contains(s2)) return true;
		return false;
	}

	public void genHenshin(Module hm) {
		// NOP by default
	}
	
	public abstract void genLoopUnit(Module hm);
	
	protected Rule getHenshinRule(Module hm, String rule) {
		for (Rule r : hm.getAllRules()) {
			if (r.getName().equals(rule)) return r;
		}
		return null;
	}
	
	public abstract List<LoopUnit> getLoop();

	public abstract List<Unit> getMainUnits(Module m);

	public boolean isNegative() {
		return this.isNegative; 
	}
	
	public void setNegative(boolean b) {
		this.isNegative = b; 
	}
	
	public String getName() {
		return this.name;
	}

}
