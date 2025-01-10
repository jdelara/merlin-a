package merlin.adaptive.trafos;

import java.util.List;
import java.util.ArrayList;

import adapters.AdapterModel;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import merlin.adaptive.adapters.Adapter;
import merlin.adaptive.adapters.ConfigDiff;
import merlin.adaptive.adapters.Diffs;

public class AdapterModelInjector {
	private AdapterModel adm;
	private IFeatureModel fm;
	
	public AdapterModelInjector(AdapterModel adm, IFeatureModel fm) {
		this.adm = adm;
		this.fm = fm;
	}
	
	public List<Adapter> getAdapters() {
		List<Adapter> adps = new ArrayList<>();
		for (adapters.Adapter a : this.adm.getAdapters()) {
			ConfigDiff cfd = new ConfigDiff(this.fm);
			cfd.add(Diffs.POS2NEG, a.getCfgDiff().getDelta().getPosSet().toArray(new String[0]));
			cfd.add(Diffs.NEG2POS, a.getCfgDiff().getDelta().getNegSet().toArray(new String[0]));
			cfd.add(Diffs.POS,     a.getCfgDiff().getContext().getPosSet().toArray(new String[0]));
			cfd.add(Diffs.NEG,     a.getCfgDiff().getContext().getNegSet().toArray(new String[0]));
			
			Adapter adp = new Adapter(a.getName(), cfd, a.getRules().toArray(new String[0]));
			adps.add(adp);
		}
		return adps;
	}
}
