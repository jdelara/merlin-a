package merlin.adaptive.adapters;

import java.util.*;

import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import merlin.adaptive.analysis.RuleActionAnalyser;
import merlin.adaptive.trafos.MigrationTrafo;
import merlin.adaptive.trafos.Position;
import org.eclipse.emf.henshin.model.Module;

public abstract class AdapterSet {
	protected Set<AbstractAdapter> adapters = new LinkedHashSet<>();

	public MigrationTrafo composeTrafo(IFeatureModel fm, Configuration src, Configuration tar, RuleActionAnalyser raa) {
		ConfigDiff cd = ConfigDiff.diff(fm, src, tar);
		MigrationTrafo mgt = new MigrationTrafo(src, tar);
		for (AbstractAdapter ad : this.adapters) {
			for (Position p : Position.values()) {
				if (ad.getDiff().compatibleWith(cd, p)) { 
					if ( p==Position.INC ||
						 (p==Position.PRE && !raa.create(ad, cd)) ||
						 (p==Position.POST && !raa.delete(ad, cd)))
					mgt.addAdapter(ad, p);
					break;
				}
			}
		}		
		this.composeAdapters(cd, mgt);	
		return mgt;
	}

	public void composeAdapters(ConfigDiff cd, MigrationTrafo mgt) {
		List<String> uncoveredPos2Neg = cd.getUncovered(mgt.getAll(Diffs.POS2NEG), Diffs.POS2NEG);
		List<String> uncoveredNeg2Pos = cd.getUncovered(mgt.getAll(Diffs.NEG2POS), Diffs.NEG2POS);
		//System.out.println("Uncovered +-: "+uncoveredPos2Neg);
		//System.out.println("Uncovered -+: "+uncoveredNeg2Pos);

		if (uncoveredPos2Neg.isEmpty() && uncoveredNeg2Pos.isEmpty()) return;	// all covered, nothing to do

		for (AbstractAdapter ad : this.adapters) {
			if (mgt.containsAdapter(ad)) continue;
			if (applicableButPositiveContextFails(ad, cd, uncoveredPos2Neg, uncoveredNeg2Pos)) {
				System.out.println("Trying to fix positive context of: "+ad);
				AbstractAdapter b = this.getPositiveContextFixerFor(ad, cd);
				if (b!=null) {
					addContextFixer(cd, mgt, ad, b, uncoveredPos2Neg, uncoveredNeg2Pos, false);
					if (uncoveredPos2Neg.isEmpty() && uncoveredNeg2Pos.isEmpty()) return;
				}
			} 
			else if (applicableButNegativeContextFails(ad, cd, uncoveredPos2Neg, uncoveredNeg2Pos)) {
				System.out.println("Trying to fix negative context of: "+ad);
				AbstractAdapter b = this.getNegativeContextFixerFor(ad, cd);
				if (b!=null) {
					addContextFixer(cd, mgt, ad, b, uncoveredPos2Neg, uncoveredNeg2Pos, true);
					if (uncoveredPos2Neg.isEmpty() && uncoveredNeg2Pos.isEmpty()) return;
				}
			} 
		}

		for (AbstractAdapter ad : this.adapters) {
			if (mgt.containsAdapter(ad)) continue;
			if (ad.getDiff().get(Diffs.POS2NEG).isEmpty()) continue;
			if (applicableButNegToPosFails(ad, cd, uncoveredPos2Neg, uncoveredNeg2Pos)) {
				System.out.println("Trying to find a completer for: "+ad);
				AbstractAdapter b = this.getCompleterFor(ad, cd, true); // strict
				if (b!=null) {					
					this.addCompleter(cd, mgt, ad, b, uncoveredPos2Neg, uncoveredNeg2Pos);
					if (uncoveredPos2Neg.isEmpty() && uncoveredNeg2Pos.isEmpty()) return;
				}
			}
			else if (applicableButContextAndNegToPosFails(ad, cd, uncoveredPos2Neg, uncoveredNeg2Pos)) { 
				System.out.println("Trying to find a soft completer for: "+ad);
				AbstractAdapter	b = this.getCompleterFor(ad, cd, false);	// soft
				System.out.println("Soft completer found: "+b);
				if (b!=null) {
					AbstractAdapter adb = this.compose(ad, b);
					AbstractAdapter c = this.getPositiveContextFixerFor(adb, cd);
					if (c!=null) {
						this.addSoftCompleter(cd, mgt, adb, c, uncoveredPos2Neg, uncoveredNeg2Pos);
						if (uncoveredPos2Neg.isEmpty() && uncoveredNeg2Pos.isEmpty()) return;
					}
				}
			}						
		}
	}
	
	private AbstractAdapter compose(AbstractAdapter ad, AbstractAdapter b) {
		CompositeAdapter ca = new CompositeAdapter(ad.name+"-"+b.name,
				   								   ad.getDiff().compose(b.getDiff()));
		ca.addAdapter(ad);
		ca.addAdapter(b);
		return ca;
	}

	private void addSoftCompleter(ConfigDiff cd, MigrationTrafo mgt, AbstractAdapter ad, AbstractAdapter b,
								  List<String> uncoveredPos2Neg, List<String> uncoveredNeg2Pos) {
		System.out.println("Found context fixer: "+b);
		CompositeAdapter ca = new CompositeAdapter(ad.name+"-"+b.name,
												   ad.getDiff().compose(b.getDiff())); // TO-DO!!!
		ca.setKind(AdapterKind.SOFTCOMPLETER);
		updateMigration(mgt, ad, b, uncoveredPos2Neg, uncoveredNeg2Pos, ca);
	}

	private void addCompleter(ConfigDiff cd, MigrationTrafo mgt, AbstractAdapter ad, AbstractAdapter b,
							  List<String> uncoveredPos2Neg, List<String> uncoveredNeg2Pos) {
		System.out.println("Found completer: "+b);
		CompositeAdapter ca = new CompositeAdapter(ad.name+"-"+b.name,ad.getDiff().compose(b.getDiff()));
		ca.setKind(AdapterKind.COMPLETER);
		updateMigration(mgt, ad, b, uncoveredPos2Neg, uncoveredNeg2Pos, ca);
	}

	private void updateMigration(MigrationTrafo mgt, AbstractAdapter ad, AbstractAdapter b, List<String> uncoveredPos2Neg,
			List<String> uncoveredNeg2Pos, CompositeAdapter ca) {
		System.out.println("Resuting config diff: "+ca.getDiff());
		ca.addAdapter(ad);
		ca.addAdapter(b); // To-Do: generate layers...
		mgt.addAdapter(ca, Position.POST);
		uncoveredPos2Neg.removeAll(ca.getDiff().get(Diffs.POS2NEG));
		uncoveredNeg2Pos.removeAll(ca.getDiff().get(Diffs.NEG2POS));
		System.out.println("Uncovered +-: "+uncoveredPos2Neg);
		System.out.println("Uncovered -+: "+uncoveredNeg2Pos);
	}

	private void addContextFixer (ConfigDiff cd, MigrationTrafo mgt, AbstractAdapter ad, AbstractAdapter b,
							      List<String> uncoveredPos2Neg, List<String> uncoveredNeg2Pos, boolean negative) {
		System.out.println("Found context fixer: "+b);
		ConfigDiff injector = this.createInjectorDiff(ad, b, cd);
		CompositeAdapter ca = new CompositeAdapter(ad.name+"-"+b.name, 															   							
												   injector.compose(ad.getDiff()).compose(b.getDiff()));
		ca.setKind(AdapterKind.CONTEXTFIXER);
		if (negative) ca.setNegative(true);
		updateMigration(mgt, ad, b, uncoveredPos2Neg, uncoveredNeg2Pos, ca);
	}

	/*	private Set<AbstractAdapter> compositionStep() {
		Set<AbstractAdapter> newAdapters = new HashSet<>();
		for (AbstractAdapter a1 : adapters) {
			for (AbstractAdapter a2 : adapters) {
				if (a1!=a2 && a1.canCompose(a2) && a1.dependent(a2) && this.isNewAdapter(a1, a2)) {
					ConfigDiff cfgd = a1.getDiff().compose(a2.getDiff());
					CompositeAdapter na = new CompositeAdapter (a1.name()+a2.name(), cfgd);
					na.addAdapter(a1);
					na.addAdapter(a2);
					if (!na.getDiff().wff()) {						
						System.out.println("Not well formed!");
						System.out.println("   a1="+a1.name+"="+a1.getDiff());
						System.out.println("   a2="+a2.name+"="+a2.getDiff());
					}
					//na.getRules().addAll(a1.getRules());
					//na.getRules().addAll(a2.getRules());
					else newAdapters.add(na);
				}
			}
		}			
		return newAdapters;
	}*/

	private ConfigDiff createInjectorDiff(AbstractAdapter a, AbstractAdapter b, ConfigDiff cd) {
		ConfigDiff injector = new ConfigDiff(cd.getFeatureModel());
		for (String s : b.getDiff().get(Diffs.NEG2POS))
			injector.add(Diffs.POS2NEG, s);

		Set<String> aPos = new LinkedHashSet<>(a.getDiff().get(Diffs.POS));
		aPos.removeAll(cd.get(Diffs.POS));

		for (String s : aPos)
			injector.add(Diffs.NEG2POS, s);

		return injector;
	}

	protected AbstractAdapter getPositiveContextFixerFor(AbstractAdapter ad, ConfigDiff cd) {
		Set<String> aPositiveContext = new LinkedHashSet<>(ad.getDiff().get(Diffs.POS));
		aPositiveContext.removeAll(cd.get(Diffs.POS));

		for (AbstractAdapter b : this.adapters) {
			if (! this.independentActions(ad, b)) continue;
			Set<String> bPos2Neg = b.getDiff().get(Diffs.POS2NEG);
			Set<String> bNeg2Pos = b.getDiff().get(Diffs.NEG2POS);
			Set<String> bPos 	 = b.getDiff().get(Diffs.POS);
			Set<String> bNeg 	 = b.getDiff().get(Diffs.NEG);
			if (bPos2Neg.containsAll(aPositiveContext) && 
				cd.get(Diffs.NEG).containsAll(bPos2Neg) &&				
				cd.get(Diffs.POS).containsAll(bNeg2Pos) && 
				cd.get(Diffs.POS).containsAll(bPos) &&
				cd.get(Diffs.NEG).containsAll(bNeg)) 
			{
				if (ad.canCompose(b)) {	// TO-DO: need to check the featutr model compatibility!
						return b;
				}
			}
		}
		return null;
	}
	
	protected AbstractAdapter getNegativeContextFixerFor(AbstractAdapter ad, ConfigDiff cd) {
		Set<String> aNegativeContext = new LinkedHashSet<>(ad.getDiff().get(Diffs.NEG));
		aNegativeContext.removeAll(cd.get(Diffs.NEG));

		for (AbstractAdapter b : this.adapters) {
			if (! this.independentActions(ad, b)) continue;
			Set<String> bPos2Neg = b.getDiff().get(Diffs.POS2NEG);
			Set<String> bNeg2Pos = b.getDiff().get(Diffs.NEG2POS);
			Set<String> bPos 	 = b.getDiff().get(Diffs.POS);
			Set<String> bNeg 	 = b.getDiff().get(Diffs.NEG);
			if (bNeg2Pos.containsAll(aNegativeContext) &&
				cd.get(Diffs.POS).containsAll(bNeg2Pos) && 
				cd.get(Diffs.NEG).containsAll(bPos2Neg) && 
				cd.get(Diffs.POS).containsAll(bPos) &&
				cd.get(Diffs.NEG).containsAll(bNeg)) 
			{
				if (ad.canCompose(b)) {	// TO-DO: need to check the featutr model compatibility!
						return b;
				}
			}
		}
		return null;
	}
	
	private boolean independentActions(AbstractAdapter a, AbstractAdapter b) {
		Set<String> aActions = a.getDiff().getDelta();
		Set<String> bActions = b.getDiff().getDelta();
				
		return Collections.disjoint(aActions, bActions);
	}
	
// -----------------------------------------------------------------------------------	
// OLD VERSION	
/*	protected AbstractAdapter getPositiveContextFixerFor(AbstractAdapter ad, ConfigDiff cd) {
		Set<String> aPositiveContext = new LinkedHashSet<>(ad.getDiff().get(Diffs.POS));
		aPositiveContext.removeAll(cd.get(Diffs.POS));

		Set<String> configPositiveContext = new LinkedHashSet<>(cd.get(Diffs.POS));
		configPositiveContext.addAll(cd.get(Diffs.NEG2POS));	// OJO!!!
		configPositiveContext.removeAll(ad.getDiff().get(Diffs.POS));		

		for (AbstractAdapter b : this.adapters) {
			Set<String> bPos2Neg = b.getDiff().get(Diffs.POS2NEG);
			Set<String> bNeg2Pos = b.getDiff().get(Diffs.NEG2POS);
			if (aPositiveContext.containsAll(bPos2Neg) && bPos2Neg.containsAll(aPositiveContext)) {				
				if (configPositiveContext.containsAll(bNeg2Pos)) {
					if (cd.get(Diffs.NEG).containsAll(b.getDiff().get(Diffs.NEG)) &&
							cd.get(Diffs.POS).containsAll(b.getDiff().get(Diffs.POS))) {
						if (ad.canCompose(b)) {	// TO-DO: need to check the featutr model compatibility!
							return b;
						}
					}
				}
			}

		}
		return null;
	}
		
// OLD VERSION
	protected AbstractAdapter getNegativeContextFixerFor(AbstractAdapter ad, ConfigDiff cd) {
		Set<String> aNegativeContext = new LinkedHashSet<>(ad.getDiff().get(Diffs.NEG));
		aNegativeContext.removeAll(cd.get(Diffs.NEG));

		Set<String> configNegativeContext = new LinkedHashSet<>(cd.get(Diffs.NEG));
		configNegativeContext.removeAll(ad.getDiff().get(Diffs.NEG));

		for (AbstractAdapter b : this.adapters) {
			if (! this.independentActions(ad, b)) continue;
			Set<String> bPos2Neg = b.getDiff().get(Diffs.POS2NEG);
			Set<String> bNeg2Pos = b.getDiff().get(Diffs.NEG2POS);
			if (aNegativeContext.containsAll(bNeg2Pos) && bNeg2Pos.containsAll(aNegativeContext)) {				
				if (configNegativeContext.containsAll(bPos2Neg)) {
					if (cd.get(Diffs.NEG).containsAll(b.getDiff().get(Diffs.NEG)) &&
							cd.get(Diffs.POS).containsAll(b.getDiff().get(Diffs.POS))) {
						if (ad.canCompose(b)) {	// TO-DO: need to check the featutr model compatibility!
							return b;
						}
					}
				}
			}

		}
		return null;
	}*/

	private AbstractAdapter getCompleterFor(AbstractAdapter ad, ConfigDiff cd, boolean strict) {

		List<String> negToPos = new ArrayList<>(ad.getDiff().get(Diffs.NEG2POS));
		negToPos.removeAll(cd.get(Diffs.NEG2POS));

		for (AbstractAdapter b : this.adapters) {
			Set<String> bPos2Neg = b.getDiff().get(Diffs.POS2NEG);
			Set<String> bNeg2Pos = b.getDiff().get(Diffs.NEG2POS);
			if (bPos2Neg.containsAll(negToPos) && negToPos.containsAll(bPos2Neg)) {
				if (cd.get(Diffs.NEG2POS).containsAll(bNeg2Pos)) {
					if (!strict ||
						(strict && cd.get(Diffs.POS).containsAll(b.getDiff().get(Diffs.POS)) && // This is for strict completer
						cd.get(Diffs.NEG).containsAll(b.getDiff().get(Diffs.NEG)))) {	
						if (ad.canCompose(b)) { // TO-DO: need to check the featutr model compatibility!
							return b;
						}
					}
				}
			}
		}
		return null;
	}

	private boolean applicableButPositiveContextFails(AbstractAdapter ad, ConfigDiff cd,
														List<String> uPos, List<String> uNeg) {
		ConfigDiff diff = ad.getDiff();
		return 	uPos.containsAll(diff.get(Diffs.POS2NEG)) &&
				uNeg.containsAll(diff.get(Diffs.NEG2POS)) &&
				cd.get(Diffs.NEG).containsAll(diff.get(Diffs.NEG));
	}
	
	private boolean applicableButNegativeContextFails (	AbstractAdapter ad, ConfigDiff cd,
														List<String> uPos, List<String> uNeg) {
		ConfigDiff diff = ad.getDiff();
		return 	uPos.containsAll(diff.get(Diffs.POS2NEG)) &&
				uNeg.containsAll(diff.get(Diffs.NEG2POS)) &&
				cd.get(Diffs.POS).containsAll(diff.get(Diffs.POS));
	}

	private boolean applicableButNegToPosFails( AbstractAdapter ad, ConfigDiff cd, 
												List<String> uPos, List<String> uNeg) {
		
		return applicableButContextAndNegToPosFails(ad, cd, uPos, uNeg) &&
			   cd.get(Diffs.POS).containsAll(ad.getDiff().get(Diffs.POS));		
	}

	private boolean applicableButContextAndNegToPosFails(AbstractAdapter ad, ConfigDiff cd,
														 List<String> uPos, 
														 List<String> uNeg) {
		ConfigDiff diff = ad.getDiff();
		return  uPos.containsAll(diff.get(Diffs.POS2NEG)) &&				
				cd.get(Diffs.NEG).containsAll(diff.get(Diffs.NEG)) &&
				!uNeg.containsAll(diff.get(Diffs.NEG2POS));			
	}
}
