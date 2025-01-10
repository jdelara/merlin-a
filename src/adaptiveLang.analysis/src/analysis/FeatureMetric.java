package analysis;

import java.util.*;

import merlin.adaptive.adapters.Diffs;

public class FeatureMetric {
	private String name;
	private Map<Diffs, List<String>> adapters = new LinkedHashMap<>();
	
	public FeatureMetric(String name) {
		this.name = name;
		for (Diffs d : Diffs.values()) 
			this.adapters.put(d,  new ArrayList<>());		
	}
	
	public boolean hasEmptyAdapters() {
		for (Diffs d: this.adapters.keySet()) 
			if (!this.adapters.get(d).isEmpty())
				return false;
		return true;
	}
	
	public void add(Diffs d, List<String> adapters) {
		this.adapters.get(d).addAll(adapters);
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return this.name;
	}

	public List<String> getAdapter(Diffs d) {	
		return this.adapters.get(d);
	}
	
	public String getAdapterAsString(Diffs d) {
		String str = "";
		boolean first = true;
		for (String s : this.adapters.get(d)) {
			if (first) str += s;
			else str += ", "+s;
			first = false;
		}
		return str;
	}
	
	public boolean isEmpty() {
		return this.adapters.isEmpty();
	}
	
}
