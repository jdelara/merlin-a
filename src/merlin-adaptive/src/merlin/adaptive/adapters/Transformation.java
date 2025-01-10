package merlin.adaptive.adapters;

import de.ovgu.featureide.fm.core.base.IFeatureModel;

public class Transformation extends AdapterSet{
	private IFeatureModel fm;
	
	public Transformation(IFeatureModel fm) {
		this.fm = fm;
	}
	
	public void addAdapter(Adapter a) {
		this.adapters.add(a);
	}
}
