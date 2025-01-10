package merlin.adaptive.adapters;

import java.util.*;

import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import merlin.adaptive.trafos.Position;
import merlin.common.analysis.FeatureSolver;
import merlin.common.features.DefaultFeatureProvider;
import merlin.common.features.PartialFeatureProvider;

public class ConfigDiff {
	private Map<Diffs, Set<String>> diff = new LinkedHashMap<>();
	private IFeatureModel ifm;
	
	public ConfigDiff(IFeatureModel ifm) {
		for (Diffs d : Diffs.values())
			this.diff.put(d, new TreeSet<>());
		this.ifm = ifm;
	}
	
	public static ConfigDiff fromAdapter (IFeatureModel ifm, adapters.Adapter adp) {
		if (adp.getCfgDiff()==null) return null;
		ConfigDiff diff = new ConfigDiff(ifm);		
		adapters.ConfigDelta delta = adp.getCfgDiff().getDelta();
		adapters.ConfigContext ctx = adp.getCfgDiff().getContext();
		
		diff.add(Diffs.POS2NEG, (String [])delta.getPosSet().toArray());
		diff.add(Diffs.NEG2POS, (String [])delta.getNegSet().toArray());
		diff.add(Diffs.POS, (String [])ctx.getPosSet().toArray());
		diff.add(Diffs.NEG, (String [])ctx.getNegSet().toArray());
		
		return diff;
	}
	
	public Set<String> get(Diffs df) {
		return this.diff.get(df);
	}
	
	public Set<String> getDelta() {
		Set<String> delta = new LinkedHashSet<>(this.diff.get(Diffs.POS2NEG));
		delta.addAll(this.diff.get(Diffs.NEG2POS));
		return delta;
	}
	
	public Set<String> getContext() {
		Set<String> context = new LinkedHashSet<>(this.diff.get(Diffs.POS));
		context.addAll(this.diff.get(Diffs.NEG));
		return context;
	}
	
	public boolean stateWff() {
		return this.preStateWff() && this.postStateWff();
	}
	
	private boolean postStateWff() {
		return true;
	}

	public boolean preStateWff() {
		List<String> positive = new ArrayList<>();
		List<String> negative = new ArrayList<>();
		positive.addAll(this.diff.get(Diffs.POS2NEG));
		positive.addAll(this.diff.get(Diffs.POS));
		
		negative.addAll(this.diff.get(Diffs.NEG2POS));
		negative.addAll(this.diff.get(Diffs.NEG));
		
		DefaultFeatureProvider dfp = new DefaultFeatureProvider(this.ifm);
		PartialFeatureProvider pdf = new PartialFeatureProvider(dfp, positive, negative);
		
		FeatureSolver fs = new FeatureSolver(pdf, ifm);
		boolean ret = fs.isSat();
		
		return ret;
	}

	/**
	 * Checks whether ConfigDiff is well formed (just check disjointness)
	 * @return
	 */
	public boolean wff() {
		for (Diffs d1 : Diffs.values())
			for (Diffs d2 : Diffs.values())
				if (d1!=d2 && containsSome(this.diff.get(d1), this.diff.get(d2))) {
					System.out.println("not wff ("+d1+", "+d2+") : "+this);
					return false;			
				}
		return true;
	}
	
	private boolean containsSome(Set<String> set, Set<String> set2) {
		for (String s : set2)
			if (set.contains(s)) return true;
		return false;
	}

	public ConfigDiff add(Diffs df, String...feats) {
		if (!this.ifm.getFeatureOrderList().containsAll(Arrays.asList(feats))) return null;		
		this.diff.get(df).addAll(Arrays.asList(feats));
		if (!this.wff()) {
			this.diff.get(df).removeAll(Arrays.asList(feats));
			return null;
		}
		return this;
	}
	
	@Override public String toString() {
		return diff.toString();
	}
	
//	public boolean compatibleWith(ConfigDiff tar) {  // TO-DO: distinguish between pre and post!!!
//		if (!tar.diff.get(Diffs.POS2NEG).containsAll(this.diff.get(Diffs.POS2NEG))) return false;
//		if (!tar.diff.get(Diffs.NEG2POS).containsAll(this.diff.get(Diffs.NEG2POS))) return false;
//		
//		Set<String> tarPosContext = new LinkedHashSet<>(tar.diff.get(Diffs.POS));
//		tarPosContext.addAll(tar.diff.get(Diffs.NEG2POS));		// for post-consistency
//		tarPosContext.addAll(tar.diff.get(Diffs.POS2NEG));		// for pre-consistency
//		if (!tarPosContext.containsAll(this.diff.get(Diffs.POS))) return false;
//		
//		Set<String> tarNegContext = new LinkedHashSet<>(tar.diff.get(Diffs.NEG));
//		tarNegContext.addAll(tar.diff.get(Diffs.POS2NEG));	// for post-consistency	
//		tarNegContext.addAll(tar.diff.get(Diffs.NEG2POS));	// for pre-consistency
//		if (!tarNegContext.containsAll(this.diff.get(Diffs.NEG))) return false;
//		
//		return true;
//	}
	
	public boolean compatibleWith(ConfigDiff tar, Position p) {  // TO-DO: distinguish between pre and post!!!
		if (!tar.diff.get(Diffs.POS2NEG).containsAll(this.diff.get(Diffs.POS2NEG))) return false;
		if (!tar.diff.get(Diffs.NEG2POS).containsAll(this.diff.get(Diffs.NEG2POS))) return false;
		
		Set<String> tarPosContext = new LinkedHashSet<>(tar.diff.get(Diffs.POS));
		if (Position.POST.equals(p)) tarPosContext.addAll(tar.diff.get(Diffs.NEG2POS));		// for post-consistency
		else if (Position.PRE.equals(p)) tarPosContext.addAll(tar.diff.get(Diffs.POS2NEG));		// for pre-consistency
		if (!tarPosContext.containsAll(this.diff.get(Diffs.POS))) return false;
		
		Set<String> tarNegContext = new LinkedHashSet<>(tar.diff.get(Diffs.NEG));
		if (Position.POST.equals(p)) tarNegContext.addAll(tar.diff.get(Diffs.POS2NEG));	// for post-consistency	
		else if (Position.PRE.equals(p)) tarNegContext.addAll(tar.diff.get(Diffs.NEG2POS));	// for pre-consistency
		if (!tarNegContext.containsAll(this.diff.get(Diffs.NEG))) return false;
		
		return true;
	}
	
//	public boolean includedIn(ConfigDiff tar) {  
//		return tar.diff.get(Diffs.POS2NEG).containsAll(this.diff.get(Diffs.POS2NEG)) &&
//			   tar.diff.get(Diffs.NEG2POS).containsAll(this.diff.get(Diffs.NEG2POS)) &&
//			   tar.diff.get(Diffs.POS).containsAll(this.diff.get(Diffs.POS)) &&
//			   tar.diff.get(Diffs.NEG).containsAll(this.diff.get(Diffs.NEG));
//	}
	
	public static ConfigDiff diff(IFeatureModel fm, Configuration src, Configuration tar) {
		ConfigDiff df = new ConfigDiff(fm);
		
		df.computePositiveContext(src, tar);
		df.computeNegativeContext(fm, src, tar);
		df.computePos2NegDelta(fm, src, tar);
		df.computeNeg2PosDelta(fm, src, tar);
		
		return df;
	}

	private void computePos2NegDelta(IFeatureModel fm, Configuration src, Configuration tar) {
		Set<String> sourceSelected = new LinkedHashSet<>(src.getSelectedFeatureNames());
		
		Set<String> targetUnselected = new TreeSet<>(fm.getFeatureOrderList());
		targetUnselected.removeAll(tar.getSelectedFeatureNames());
		
		sourceSelected.retainAll(targetUnselected);
		this.diff.put(Diffs.POS2NEG, sourceSelected);
	}
	
	private void computeNeg2PosDelta(IFeatureModel fm, Configuration src, Configuration tar) {
		Set<String> sourceUnselected = new TreeSet<>(fm.getFeatureOrderList());
		sourceUnselected.removeAll(src.getSelectedFeatureNames());
		
		Set<String> targetSelected = new LinkedHashSet<>(tar.getSelectedFeatureNames());
		
		sourceUnselected.retainAll(targetSelected);
		this.diff.put(Diffs.NEG2POS, sourceUnselected);
	}

	private void computeNegativeContext(IFeatureModel fm, Configuration src, Configuration tar) {
		Set<String> sourceUnselected = new TreeSet<>(fm.getFeatureOrderList());
		sourceUnselected.removeAll(src.getSelectedFeatureNames());
		
		Set<String> targetUnselected = new TreeSet<>(fm.getFeatureOrderList());
		targetUnselected.removeAll(tar.getSelectedFeatureNames());
		
		sourceUnselected.retainAll(targetUnselected);
		
		this.diff.put(Diffs.NEG, sourceUnselected);
	}

	private void computePositiveContext(Configuration src, Configuration tar) {
		Set<String> sourceSelected = new LinkedHashSet<>(src.getSelectedFeatureNames());
		sourceSelected.retainAll(tar.getSelectedFeatureNames()); // F_src^+ \cup F_tar^+
		
		this.diff.put(Diffs.POS, sourceSelected);
	}
	
	public boolean canCompose(ConfigDiff c2) {
		/*Set<String> pos2neg = new LinkedHashSet<>(this.diff.get(Diffs.POS2NEG));
		pos2neg.retainAll(c2.diff.get(Diffs.POS2NEG));
		
		if (!pos2neg.isEmpty()) return false;
		
		Set<String> neg2pos = new LinkedHashSet<>(this.diff.get(Diffs.NEG2POS));
		neg2pos.retainAll(c2.diff.get(Diffs.NEG2POS));
		
		if (!neg2pos.isEmpty()) return false;*/
		
		Set<String> neg = new LinkedHashSet<>(this.diff.get(Diffs.NEG));
		neg.addAll(this.diff.get(Diffs.POS2NEG));
		//if (neg.removeAll(this.diff.get(Diffs.NEG2POS))) System.out.println("Changed!!"); // OJO
		
		Set<String> pos2 = new LinkedHashSet<>(c2.diff.get(Diffs.POS));
		pos2.addAll(c2.diff.get(Diffs.POS2NEG));
		neg.retainAll(pos2);
		//neg.retainAll(c2.diff.get(Diffs.POS));
		
		if (!neg.isEmpty()) return false;
		
		Set<String> pos = new LinkedHashSet<>(this.diff.get(Diffs.POS));
		pos.addAll(this.diff.get(Diffs.NEG2POS));
		//if (pos.removeAll(this.diff.get(Diffs.POS2NEG))) System.out.println("Changed!!");
		
		Set<String> neg2 = new LinkedHashSet<>(c2.diff.get(Diffs.NEG));
		neg2.addAll(c2.diff.get(Diffs.NEG2POS));
		pos.retainAll(neg2);
		
		//pos.retainAll(c2.diff.get(Diffs.NEG));
		
		
		if (!pos.isEmpty()) return false;
		
		return true;
	}
	
	public ConfigDiff compose(ConfigDiff c2) {
		if (!this.canCompose(c2)) return null;
		ConfigDiff result = new ConfigDiff(this.ifm);
		Set<String> pos2neg = new LinkedHashSet<>(this.diff.get(Diffs.POS2NEG));
		pos2neg.removeAll(c2.diff.get(Diffs.NEG2POS));
		pos2neg.addAll(c2.diff.get(Diffs.POS2NEG));
		pos2neg.removeAll(this.diff.get(Diffs.NEG2POS));
		
		Set<String> neg2pos = new LinkedHashSet<>(this.diff.get(Diffs.NEG2POS));
		neg2pos.removeAll(c2.diff.get(Diffs.POS2NEG));
		neg2pos.addAll(c2.diff.get(Diffs.NEG2POS));
		neg2pos.removeAll(this.diff.get(Diffs.POS2NEG));
		
		Set<String> pos = new LinkedHashSet<String>(this.diff.get(Diffs.POS));
		pos.removeAll(c2.diff.get(Diffs.POS2NEG)); /// OJO!
		pos.addAll(c2.diff.get(Diffs.POS));
		pos.removeAll(this.diff.get(Diffs.NEG2POS));
		
		Set<String> neg = new LinkedHashSet<String>(this.diff.get(Diffs.NEG));
		neg.removeAll(c2.diff.get(Diffs.NEG2POS));  /// OJO!
		neg.addAll(c2.diff.get(Diffs.NEG));
		neg.removeAll(this.diff.get(Diffs.POS2NEG));
		
		result.diff.put(Diffs.POS2NEG, pos2neg);
		result.diff.put(Diffs.NEG2POS, neg2pos);
		result.diff.put(Diffs.POS, pos);
		result.diff.put(Diffs.NEG, neg);
		return result;
	}
	
	@Override public boolean equals(Object o) {
		if (o==this) return true;
		if (!(o instanceof ConfigDiff)) return false;
		ConfigDiff c = (ConfigDiff) o;
		return this.diff.equals(c.diff);
	}
	
	@Override public int hashCode() {
		return this.diff.hashCode();
	}

	public List<String> getUncovered(List<String> features, Diffs df) {
		List<String> uncovered = new ArrayList<>(this.diff.get(df));
		uncovered.removeAll(features);
		return uncovered;
	}
	
	public IFeatureModel getFeatureModel() {
		return this.ifm;
	}
}
