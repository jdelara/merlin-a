package merlin.analysis.use;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.tzi.kodkod.model.config.impl.ModelConfigurator;
import org.tzi.kodkod.model.iface.IModel;
import org.tzi.kodkod.model.type.TypeConstants;
import org.tzi.use.api.UseApiException;
import org.tzi.use.kodkod.UseKodkodModelValidator;
import org.tzi.use.kodkod.solution.ObjectDiagramCreator;
import org.tzi.use.kodkod.solution.ObjectDiagramCreator.ErrorType;
import org.tzi.use.main.Session;
import org.tzi.use.uml.mm.MAttribute;
import org.tzi.use.uml.ocl.value.Value;
import org.tzi.use.uml.sys.MObject;
import org.tzi.use.uml.sys.MSystemState;

import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.IFeatureStructure;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.configuration.ConfigurationAnalyzer;
import de.ovgu.featureide.fm.core.configuration.SelectableFeature;
import de.ovgu.featureide.fm.core.configuration.Selection;
import kodkod.ast.Relation;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;
import merlin.analysis.validate.properties.SemanticCompiler;
import merlin.common.utils.EMFUtils;

public class UseFMScrollingValidator extends UseValidator {
	
	// result of validation (feature selections)
	protected List<Configuration> resultConfigurations = null;
	
	// flag to generate one/all solutions
	protected boolean allSolutions = true;
	
	// flag to generate only non-partial feature configurations
	protected boolean onlyNonpartialConfigs = true;
	
	// feature model
	protected IFeatureModel featureModel = null;
	
	// name of invariants to guide the search towards partial configurations
	protected List<String> heuristics = new ArrayList<>();
	
	// features ordered by descending number of children
	protected List<String> orderedFeatures = new ArrayList<>();
	
	// log writer
	protected PrintWriter logWriter;
	
	/**	configurations generated by use */
	public List<Configuration> getConfigurations() { return resultConfigurations; }

	/**
	 * @param metamodel
	 * @param allSolutions true to generate all valid solutions; false to generate just one  
	 * @param withStrategy true to perform an optimized guided search (requires allSolutions=true and featureModel!=null); false to perform a non-optimized random search
	 * @param onlyConcreteConfigs true to return only concrete feature configurations; false to allow returning also partial ones
	 * @param featureModel
	 * @param globalConstraints
	 */
	public UseFMScrollingValidator(List<EPackage> metamodel, boolean allSolutions, boolean withStrategy, boolean onlyNonpartialConfigs, IFeatureModel featureModel, String... globalConstraints) {
		super(metamodel, globalConstraints);
		this.allSolutions          = allSolutions;
		this.onlyNonpartialConfigs = onlyNonpartialConfigs;
		this.featureModel          = featureModel;
		
		// if searching for all solutions, guide the search to obtain partial solutions first 
		if (this.allSolutions && this.featureModel!=null && withStrategy) {
			EClass fmClass = EMFUtils.getEClass(metamodel, SemanticCompiler.FEATURE_MODEL_CLASS);
			if (fmClass!=null) {
				String nameInvariant, bodyInvariant;
				EAnnotation fmOcl = EMFUtils.getOCLAnnotation(fmClass);

				// order parent features by descending number of children
				TreeMap<Integer, List<String>> features = new TreeMap<>();
				List<String> mandatoryFeatures = new ArrayList<>();
				for (IFeature feature : this.featureModel.getFeatures()) {
					int children = children(feature);
					if (children > 0) {
						if (!features.containsKey(children)) 
							features.put(children, new ArrayList<String>());
						features.get(children).add(feature.getName());
					}
					if (mandatory(feature)) mandatoryFeatures.add(feature.getName());
				}
				for (Integer children : features.descendingKeySet()) 
					orderedFeatures.addAll(features.get(children));

				// search heuristics: making a parent feature defined at a time, starting with those with lower number of children features
				IFeatureStructure root = this.featureModel.getStructure().getRoot();
				List<IFeatureStructure> undef = new ArrayList<>();
				List<IFeatureStructure> def   = new ArrayList<>();
				undef.add(root);
				for (int i=0; !undef.isEmpty(); i++) {
					// create invariant
					nameInvariant = "strategy_" + i;						
					bodyInvariant = "true";
					for (IFeatureStructure feature : undef) bodyInvariant += " and "     + feature.getFeature().getName() + ".oclIsUndefined()";
					for (IFeatureStructure feature : def)   bodyInvariant += " and not " + feature.getFeature().getName() + ".oclIsUndefined()";
					fmOcl.getDetails().put(nameInvariant, bodyInvariant);
					heuristics.add(nameInvariant);
					// select undefined feature with more children, and move it to def
					IFeatureStructure process = featureWithMoreChildren(undef);
					def.add(process);
					undef.remove(process);					
					// if the selected feature has only 1 child, set child to def and process child's children
					while (process.getChildrenCount()==1) {
						process = process.getFirstChild();
						def.add(process);
					}
					// add child (with descendants) of selected features with less children to def, and the rest (with descendants) to undef							
					List<IFeatureStructure> children = process.getChildren().stream().filter(c -> c.getChildrenCount()>0).collect(Collectors.toList());
					IFeatureStructure childWithLessChildren = featureWithLessChildren(children);
					for (IFeatureStructure child : children) {
						if (child == childWithLessChildren)
							 def.add  (child);
						else if (child.getChildrenCount()>0) // only features with children 
							undef.add(child); 
					}
				}
			}	
		}
	}	
	
	// returns feature with less children
	private IFeatureStructure featureWithLessChildren (List<IFeatureStructure> features) { 
		IFeatureStructure lessChildren = null;
		for (IFeatureStructure feature : features) 
			if (lessChildren == null || children(feature.getFeature()) < children(lessChildren.getFeature()))
				lessChildren = feature;
		return lessChildren;
	}
	
	// returns feature with more children
	private IFeatureStructure featureWithMoreChildren (List<IFeatureStructure> features) { 
		IFeatureStructure lessChildren = null;
		for (IFeatureStructure feature : features) 
			if (lessChildren == null || children(feature.getFeature()) > children(lessChildren.getFeature()))
				lessChildren = feature;
		return lessChildren;
	}
	
	// number of direct and indirect children of a feature
	private int children (IFeature feature) { int children = 0; for (IFeatureStructure child : feature.getStructure().getChildren()) children += 1 + children(child.getFeature()); return children; }
	
	// checks whether a feature and all its direct and indirect ancestors are mandatory
	private boolean mandatory (IFeature feature) {
		IFeatureStructure parent = feature.getStructure().getParent();
		return feature.getStructure().isMandatory() && (parent == null || (parent.isAnd() && mandatory(parent.getFeature())));
	}
	
	@Override
	public boolean validate (boolean loadMetamodel) {
		OutputStream logStream    = new ByteArrayOutputStream();
		PrintWriter  logWriter    = new PrintWriter(logStream);
		this.logWriter            = logWriter;
		this.result               = new ArrayList<Resource>();
		this.resultConfigurations = new ArrayList<>();		
		this.errors               = "";

		synchronized (globalLock) {
			// load metamodel
			if (!this.load(loadMetamodel)) return false;
			
			// find instance  
			InternalValidator internalValidator = (InternalValidator)this.internalValidator;
			if (this.allSolutions && !heuristics.isEmpty()) {
				// if searching all solutions with the strategy, activate only 1 invariant of the strategy at a time
				for (String invariant : heuristics) deactivateInvariant(SemanticCompiler.FEATURE_MODEL_CLASS, invariant);
				for (int i=0; i<heuristics.size(); i++) {
					if (i>0) deactivateInvariant(SemanticCompiler.FEATURE_MODEL_CLASS, heuristics.get(i-1));
					activateInvariant (SemanticCompiler.FEATURE_MODEL_CLASS, heuristics.get(i));
					if (i==0) 
						// special case for root=undefined: validate must return after the first search 
						allSolutions = false;
					internalValidator.validate(internalKodkodModel);
					allSolutions = true;
					// finish if the search with root=undefined has solutions
					if (i==0 && internalValidator.numSolutions()>0) break;
				}				
				// if there was no solution, seek again without any strategy
				if (internalValidator.numSolutions()==0) {
					deactivateInvariant(SemanticCompiler.FEATURE_MODEL_CLASS, heuristics.get(heuristics.size()-1));
					internalValidator.validate(internalKodkodModel);
				}
			}			
			else
				// otherwise, if searching one solution or not using the strategy, invoke "validate" once
				internalValidator.validate(internalKodkodModel);

			// store result
			if (internalValidator.numSolutions()>0) {
				int solutions = allSolutions? internalValidator.numSolutions() : 1;
				for (int i=0; i<solutions; i++) {
					Resource model = internalValidator.getModel(i);
					if (model != null) {
						this.result.add(model);
						this.resultConfigurations.add(internalValidator.getConfiguration(i));					
					}
					else {
						errors = "error";
						return false;
					}
				}
			}
		}

		return true;
	}	
	
	// -------------------------------------------------------------------------------------------
	// PRIVATE / PROTECTED METHODS
	// -------------------------------------------------------------------------------------------

	protected class InternalValidator extends UseKodkodModelValidator implements UseInternalValidator {
		
		protected List<MSystemState>  systemStates   = new ArrayList<>();
		protected List<Resource>      models         = new ArrayList<>();
		protected List<Configuration> configurations = new ArrayList<>(); // complete configurations with no undefined features
		protected List<Configuration> forbidden      = new ArrayList<>(); // forbidden configurations, only usedinternally
		protected int solvings = 0;

		public InternalValidator(Session session) { super(session); }
		
		// solutions[i], with i starting at 0
		public MSystemState getSolution (int i) {
			return i>=0 && i<systemStates.size()? systemStates.get(i) : null;
		}
		
		// models[i], with i starting at 0
		public Resource getModel (int i) {
			return i>=0 && i<models.size()? models.get(i) : null;
		}
		
		// feature-selection[i], with i starting at 0
		public Configuration getConfiguration (int i) {
			return i>=0 && i<configurations.size()? configurations.get(i) : null;
		}
		
		// solutions.size
		public int numSolutions() {
			return models.size();
		}

		// invocations to solver
		public int numSolvings() {
			return solvings;
		}
		
		protected boolean createObjectDiagram(Map<Relation, TupleSet> relationTuples) {
			session.reset();
			ObjectDiagramCreator diagramCreator = new ObjectDiagramCreator(model, session);
			try {
				diagramCreator.create(relationTuples);				
				return (diagramCreator.hasDiagramErrors() == ErrorType.STRUCTURE  || 
						diagramCreator.hasDiagramErrors() == ErrorType.INVARIANT);
			} 
			catch (UseApiException ex) {
				ex.printStackTrace();
				return false;
			}
		}
		
		@Override
		public void validate(IModel model) {
			solvings++; 
			super.validate(model);
		}
		
		// handles a satisfiable solution
		protected void handleSolution() {
			ModelConfigurator modelConfigurator = (ModelConfigurator)super.model.getConfigurator();
			
			if (createObjectDiagram(solution.instance().relationTuples())) {	
				System.out.println("problem in solution, trying again...");
				session.reset();
				forbid_mdl(solution.instance().relationTuples(), modelConfigurator);
				solution = null;
				validate(super.model);
				return;
			}
			
			// model and configuration
			MSystemState  model  = internalSession.system().state();
			Configuration config = configuration(model);
//			print(config);
			final FeatureModelFormula fmf = new FeatureModelFormula(featureModel);						

			// translate model into a resource
			Resource resourceModel = null;
			if (model != null && UseFMScrollingValidator.this.isValid(model, logWriter))
				resourceModel = translate2emf(model);

			if (!onlyNonpartialConfigs) 
				addResult(config, model, resourceModel);	
			
			// expand undefined features in configuration
			else {
				List<Configuration> toProcess = new ArrayList<>();
				toProcess.add(clone(config)); // copy of configuration
				Configuration cfg = toProcess.get(0);
				final ConfigurationAnalyzer configAnalyzer = new ConfigurationAnalyzer(fmf, cfg);
				for (int i=0, max_i=toProcess.size(); i<max_i; i++) {
					cfg = toProcess.get(i);
					configAnalyzer.update();
				
					// -> valid non-partial configuration: add one solution 
					if (cfg.getUndefinedSelectedFeatures().isEmpty() &&					
						configAnalyzer.isValid() && isNew(cfg, configurations))		// TODO: migrated 
							addResult(cfg, model, resourceModel);
//							System.out.print(configurations.size()+": "); print(cfg);
				
					// -> partial configuration that may be valid: concretize undefined feature with more children  
					else if (configAnalyzer.canBeValid()) {		// TODO: migrated
						SelectableFeature undefinedFeature = null;
						for (SelectableFeature feature : cfg.getFeatures()) {
							if (feature.getManual() == Selection.UNDEFINED) {
								if (undefinedFeature == null ||
										(orderedFeatures.contains(feature.getName()) &&	orderedFeatures.indexOf(feature.getName()) < orderedFeatures.indexOf(undefinedFeature.getName())))
									undefinedFeature = feature;
							}
						}
						if (undefinedFeature!=null) {
							Configuration cfg2 = clone(cfg);
							cfg.setManual (undefinedFeature, Selection.SELECTED);
							cfg2.setManual(undefinedFeature.getName(), Selection.UNSELECTED);
							i--;                 // process this configuration again
							toProcess.add(cfg2); // process the new one
							max_i++;
						}
					}
				}
			}
			
			if (!allSolutions) return;
			
			// forbid configuration
			forbid_cfg(config, modelConfigurator);
			
			// (optimization) if this configuration and some previous one only differ 
			// in a feature value, make feature undefined and forbid it
			List<Configuration> newconfigs = new ArrayList<>(); 
			newconfigs.add(config);
			for (int j=0, max_j=newconfigs.size(); j<max_j; j++) {
				for (int i=0, max_i=forbidden.size(); i<max_i; i++) {
					String feat = singleDifference(newconfigs.get(j), forbidden.get(i));
					if (feat!=null) {
						Configuration cfg = clone(newconfigs.get(j)); 
						cfg.setManual(feat, Selection.UNDEFINED);
						if (isNew(cfg, forbidden)) {
							forbid_cfg(cfg, modelConfigurator);
							newconfigs.add(cfg);
							max_i++;
							max_j++;
						}
					}
				}
			}	

			// find new solution
//			if (clock.timeInMinutes()<300) 
			validate(super.model);
		}
		
		// if the configurations differ in a single feature, it returns the name of this feature
		protected String singleDifference (Configuration config, Configuration oldconfig) {
			int    diff = 0;
			String feat = null;
			for (SelectableFeature feature : config.getFeatures()) {
				// old-new: tf, ft, tu, fu
				Selection oldvalue = oldconfig.getSelectableFeature(feature.getName()).getManual();
				Selection newvalue = feature.getManual();
				if ((oldvalue==Selection.SELECTED   && newvalue!=Selection.SELECTED) ||
					(oldvalue==Selection.UNSELECTED && newvalue!=Selection.UNSELECTED)) { 				
					diff++;
					if (diff>1) break;
					feat = feature.getName(); 					 
				}
			}
			return diff==1? feat : null;
		}
		
		// checks whether the configuration is in the list
		protected boolean isNew (Configuration configuration, List<Configuration> list) {
			for (Configuration lconfiguration : list) {
				boolean same = true;
				for (SelectableFeature feature : configuration.getFeatures()) {		
					if (feature.getManual() != lconfiguration.getSelectableFeature(feature.getName()).getManual()) { 
						 same = false;
						 break;
					}
				}
				if (same) return false;
			}
			return true;
		}
		
		// extract configuration from model
		private Configuration configuration (MSystemState model) {
			Configuration config = null;
			if (featureModel != null) {
				//config = new Configuration(featureModel, false/*do not propagate values*/);
				// TODO: migrated from old version
				config = new Configuration(new FeatureModelFormula(featureModel)); 
				for (MObject useObject : model.allObjects()) {
					if (useObject.cls().name().equals(SemanticCompiler.FEATURE_MODEL_CLASS)) {
						Map<MAttribute, Value> attributes = useObject.state(model).attributeValueMap();
						for (MAttribute attribute : attributes.keySet()) {
							String field = adapter.emfName(attribute.name()); 
							String value = attributes.get(attribute).toString();							
							if (value.equals(TypeConstants.UNDEFINED)) 
								 config.setManual(field, Selection.UNDEFINED);
							else if (value.equals(TypeConstants.TRUE))
								 config.setManual(field, Selection.SELECTED);
							else config.setManual(field, Selection.UNSELECTED);
						}
						break;
					}
				}				
			}
			return config;
		}	

		// stores result
		protected void addResult (Configuration config, MSystemState model, Resource resourceModel) {
			configurations.add(config); 
			systemStates.add(model);
			models.add(resourceModel);	
			//
		}
		
//		// list of non-partial configurations that can be built from the received configuration
//		private List<Configuration> concretize (Configuration configuration) {
//			List<Configuration> configs    = new ArrayList<>();
//			List<Configuration> newconfigs = new ArrayList<>();
//			configs.add(clone(configuration)); // copy of configuration
//			for (SelectableFeature feat : configuration.getFeatures()) {
//				if (feat.getManual() == Selection.UNDEFINED) {
//					newconfigs.clear();
//					for (Configuration cfg : configs) {
//						Configuration newcfg = clone(cfg);
//						cfg.setManual   (cfg.getSelectablefeature(feat.getName()),    Selection.SELECTED);
//						newcfg.setManual(newcfg.getSelectablefeature(feat.getName()), Selection.UNSELECTED);
//						newconfigs.add(newcfg);
//					}
//					configs.addAll(newconfigs);
//				}
//			}
//			return configs;
//		}

		// create clone of configuration
		private Configuration clone(Configuration configuration) {
			//Configuration clone = new Configuration(featureModel, false/*do not propagate values*/);
			//TODO: migrated from old FeatureIDE
			Configuration clone = new Configuration(new FeatureModelFormula(featureModel));
			configuration.getFeatures().forEach(f -> clone.setManual(f.getName(), f.getManual()));
			return clone;
		}
		
		// forbid feature configuration in solution
		private void forbid_cfg (Configuration configuration, ModelConfigurator configurator) {
			// build tupleset with non-undefined feature values
			Map<Relation,TupleSet> forbid = new HashMap<>();
			TupleFactory factory  = solution.instance().universe().factory();
			Set<String>  features = new HashSet<>();
			configuration.getSelectedFeatureNames().forEach(f -> features.add(SemanticCompiler.FEATURE_MODEL_CLASS + "_" + f));
			configuration.getUnSelectedFeatures().forEach  (f -> features.add(SemanticCompiler.FEATURE_MODEL_CLASS + "_" + f.getName()));
			for (Relation rel : solution.instance().relationTuples().keySet()) {
				TupleSet tupleset = solution.instance().relationTuples().get(rel);
				if (rel.name().equals(SemanticCompiler.FEATURE_MODEL_CLASS) || features.contains(rel.name()))
					 forbid.put(rel, tupleset);
				else forbid.put(rel, factory.noneOf(tupleset.arity()));					
			}
			// forbid tupleset
			configurator.forbid(forbid);
			forbidden.add(configuration);
		}
		
		// forbid model in solution
		private void forbid_mdl (Map<Relation, TupleSet> solution, ModelConfigurator configurator) {
			configurator.forbid(solution);
//			Map<Relation,TupleSet> forbid = new HashMap<>();
//			// 1st: extract links and attribute values
//			List<String> retain = new ArrayList<>();
//			for (Relation rel : solution.keySet()) {
//				if (rel.arity() > 1) {
//					TupleSet tupleset = solution.get(rel);
//					forbid.put(rel, tupleset);
//					Iterator<Tuple> it = tupleset.iterator();
//					while (it.hasNext()) {
//						Tuple t = it.next();
//						for (int i=0; i<t.arity(); i++) {
//							retain.add(t.atom(i).toString());
//						}
//					}
//				}						
//			}
//			// 2nd: extract objects with links or attributes	
//			for (Relation rel : solution.keySet()) {
//				if (!forbid.containsKey(rel)) {
//					TupleSet tupleset = solution.get(rel);					
//					TupleSet ts = tupleset.clone();
//					Iterator<Tuple> it = tupleset.iterator();
//					List<Tuple> delete = new ArrayList<>();
//					while (it.hasNext()) {
//						Tuple t = it.next();
//						for (int i=0; i<t.arity(); i++) 
//							if (!retain.contains(t.atom(i))) 
//								delete.add(t);
//					}
//					ts.removeAll(delete);
//					forbid.put(rel, ts);
//				}
//			}
//			configurator.forbid(forbid);
		}
		
		// print configuration
		private void print (Configuration configuration) {
			for (SelectableFeature feature : configuration.getFeatures())
				System.out.print(feature.getName() + "=" + feature.getManual() + "; ");
			System.out.println();
		}
	}

	@Override
	protected UseInternalValidator newUseInternalValidator(Session session) {
		return new InternalValidator(session);
	}
	
	//---------------------------------------------------------
	
	private InternalClock clock = new InternalClock();
	
	public class InternalClock {
		private long init=0;
		private long current()       { return System.nanoTime(); }
		private void start()         { this.init = current();    }		
		public InternalClock()       { this.start();             }
		public long timeInMinutes()  { return TimeUnit.MINUTES.convert     (current() - this.init, TimeUnit.NANOSECONDS); }
		public long timeInSeconds()  { return TimeUnit.SECONDS.convert     (current() - this.init, TimeUnit.NANOSECONDS); }
		public long timeInMseconds() { return TimeUnit.MILLISECONDS.convert(current() - this.init, TimeUnit.NANOSECONDS); }
	}
}
