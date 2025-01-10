package merlin.featureide.composer.configurations;

import java.util.*;
import de.ovgu.featureide.fm.core.configuration.Configuration;

public class FixedFeatureConfigurationIterator extends AbstractConfigurationIterator{
	protected List<Configuration> all = new ArrayList<>();
	protected int current = 0;
	
	public void init() {
		this.current = 0;
	}
	
	public void addConfiguration(Configuration cfg) {
		this.all.add(cfg);
	}
	
	@Override
	public Configuration next() {
		if (current < this.all.size())
			return this.all.get(current++);
		else
			return null;
	} 
}