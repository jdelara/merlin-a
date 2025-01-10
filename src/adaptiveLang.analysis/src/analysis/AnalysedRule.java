package analysis;

import java.util.*;

public class AnalysedRule {
	private String name;
	private String adapter;
	private List<String> errors = new ArrayList<>();
	
	public AnalysedRule(String rName, String aName) {
		this.name = rName;
		this.adapter = aName;
	}

	public void addError(String error) {
		this.errors.add(error);
	}
	
	@Override
	public String toString() {
		return "rule "+this.name+" of adapter "+this.adapter+". Errors: "+this.errors;
	}
	
	public List<String> getErrors() {
		return this.errors;
	}

	public String getName() {
		return this.name;
	}

	public String getAdapter() {
		return this.adapter;
	}
}
