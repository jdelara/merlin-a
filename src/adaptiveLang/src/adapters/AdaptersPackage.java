/**
 */
package adapters;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see adapters.AdaptersFactory
 * @model kind="package"
 * @generated
 */
public interface AdaptersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "adapters";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://adapters.org/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "adp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AdaptersPackage eINSTANCE = adapters.impl.AdaptersPackageImpl.init();

	/**
	 * The meta object id for the '{@link adapters.impl.AdapterModelImpl <em>Adapter Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adapters.impl.AdapterModelImpl
	 * @see adapters.impl.AdaptersPackageImpl#getAdapterModel()
	 * @generated
	 */
	int ADAPTER_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Ecore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MODEL__ECORE = 1;

	/**
	 * The feature id for the '<em><b>Adapters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MODEL__ADAPTERS = 2;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MODEL__TRANSFORMATION = 3;

	/**
	 * The number of structural features of the '<em>Adapter Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MODEL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Adapter Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link adapters.impl.AdapterImpl <em>Adapter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adapters.impl.AdapterImpl
	 * @see adapters.impl.AdaptersPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Cfg Diff</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__CFG_DIFF = 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER__RULES = 2;

	/**
	 * The number of structural features of the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Adapter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link adapters.impl.ConfigDiffImpl <em>Config Diff</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adapters.impl.ConfigDiffImpl
	 * @see adapters.impl.AdaptersPackageImpl#getConfigDiff()
	 * @generated
	 */
	int CONFIG_DIFF = 2;

	/**
	 * The feature id for the '<em><b>Delta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_DIFF__DELTA = 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_DIFF__CONTEXT = 1;

	/**
	 * The number of structural features of the '<em>Config Diff</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_DIFF_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Config Diff</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_DIFF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link adapters.impl.ConfigTupleImpl <em>Config Tuple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adapters.impl.ConfigTupleImpl
	 * @see adapters.impl.AdaptersPackageImpl#getConfigTuple()
	 * @generated
	 */
	int CONFIG_TUPLE = 3;

	/**
	 * The feature id for the '<em><b>Pos Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_TUPLE__POS_SET = 0;

	/**
	 * The feature id for the '<em><b>Neg Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_TUPLE__NEG_SET = 1;

	/**
	 * The number of structural features of the '<em>Config Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_TUPLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Config Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_TUPLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link adapters.impl.ConfigDeltaImpl <em>Config Delta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adapters.impl.ConfigDeltaImpl
	 * @see adapters.impl.AdaptersPackageImpl#getConfigDelta()
	 * @generated
	 */
	int CONFIG_DELTA = 4;

	/**
	 * The feature id for the '<em><b>Pos Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_DELTA__POS_SET = CONFIG_TUPLE__POS_SET;

	/**
	 * The feature id for the '<em><b>Neg Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_DELTA__NEG_SET = CONFIG_TUPLE__NEG_SET;

	/**
	 * The number of structural features of the '<em>Config Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_DELTA_FEATURE_COUNT = CONFIG_TUPLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Config Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_DELTA_OPERATION_COUNT = CONFIG_TUPLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link adapters.impl.ConfigContextImpl <em>Config Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see adapters.impl.ConfigContextImpl
	 * @see adapters.impl.AdaptersPackageImpl#getConfigContext()
	 * @generated
	 */
	int CONFIG_CONTEXT = 5;

	/**
	 * The feature id for the '<em><b>Pos Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_CONTEXT__POS_SET = CONFIG_TUPLE__POS_SET;

	/**
	 * The feature id for the '<em><b>Neg Set</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_CONTEXT__NEG_SET = CONFIG_TUPLE__NEG_SET;

	/**
	 * The number of structural features of the '<em>Config Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_CONTEXT_FEATURE_COUNT = CONFIG_TUPLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Config Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_CONTEXT_OPERATION_COUNT = CONFIG_TUPLE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link adapters.AdapterModel <em>Adapter Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter Model</em>'.
	 * @see adapters.AdapterModel
	 * @generated
	 */
	EClass getAdapterModel();

	/**
	 * Returns the meta object for the attribute '{@link adapters.AdapterModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see adapters.AdapterModel#getName()
	 * @see #getAdapterModel()
	 * @generated
	 */
	EAttribute getAdapterModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link adapters.AdapterModel#getEcore <em>Ecore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ecore</em>'.
	 * @see adapters.AdapterModel#getEcore()
	 * @see #getAdapterModel()
	 * @generated
	 */
	EAttribute getAdapterModel_Ecore();

	/**
	 * Returns the meta object for the containment reference list '{@link adapters.AdapterModel#getAdapters <em>Adapters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Adapters</em>'.
	 * @see adapters.AdapterModel#getAdapters()
	 * @see #getAdapterModel()
	 * @generated
	 */
	EReference getAdapterModel_Adapters();

	/**
	 * Returns the meta object for the attribute '{@link adapters.AdapterModel#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transformation</em>'.
	 * @see adapters.AdapterModel#getTransformation()
	 * @see #getAdapterModel()
	 * @generated
	 */
	EAttribute getAdapterModel_Transformation();

	/**
	 * Returns the meta object for class '{@link adapters.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adapter</em>'.
	 * @see adapters.Adapter
	 * @generated
	 */
	EClass getAdapter();

	/**
	 * Returns the meta object for the attribute '{@link adapters.Adapter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see adapters.Adapter#getName()
	 * @see #getAdapter()
	 * @generated
	 */
	EAttribute getAdapter_Name();

	/**
	 * Returns the meta object for the containment reference '{@link adapters.Adapter#getCfgDiff <em>Cfg Diff</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cfg Diff</em>'.
	 * @see adapters.Adapter#getCfgDiff()
	 * @see #getAdapter()
	 * @generated
	 */
	EReference getAdapter_CfgDiff();

	/**
	 * Returns the meta object for the attribute list '{@link adapters.Adapter#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Rules</em>'.
	 * @see adapters.Adapter#getRules()
	 * @see #getAdapter()
	 * @generated
	 */
	EAttribute getAdapter_Rules();

	/**
	 * Returns the meta object for class '{@link adapters.ConfigDiff <em>Config Diff</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Diff</em>'.
	 * @see adapters.ConfigDiff
	 * @generated
	 */
	EClass getConfigDiff();

	/**
	 * Returns the meta object for the containment reference '{@link adapters.ConfigDiff#getDelta <em>Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Delta</em>'.
	 * @see adapters.ConfigDiff#getDelta()
	 * @see #getConfigDiff()
	 * @generated
	 */
	EReference getConfigDiff_Delta();

	/**
	 * Returns the meta object for the containment reference '{@link adapters.ConfigDiff#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see adapters.ConfigDiff#getContext()
	 * @see #getConfigDiff()
	 * @generated
	 */
	EReference getConfigDiff_Context();

	/**
	 * Returns the meta object for class '{@link adapters.ConfigTuple <em>Config Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Tuple</em>'.
	 * @see adapters.ConfigTuple
	 * @generated
	 */
	EClass getConfigTuple();

	/**
	 * Returns the meta object for the attribute list '{@link adapters.ConfigTuple#getPosSet <em>Pos Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pos Set</em>'.
	 * @see adapters.ConfigTuple#getPosSet()
	 * @see #getConfigTuple()
	 * @generated
	 */
	EAttribute getConfigTuple_PosSet();

	/**
	 * Returns the meta object for the attribute list '{@link adapters.ConfigTuple#getNegSet <em>Neg Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Neg Set</em>'.
	 * @see adapters.ConfigTuple#getNegSet()
	 * @see #getConfigTuple()
	 * @generated
	 */
	EAttribute getConfigTuple_NegSet();

	/**
	 * Returns the meta object for class '{@link adapters.ConfigDelta <em>Config Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Delta</em>'.
	 * @see adapters.ConfigDelta
	 * @generated
	 */
	EClass getConfigDelta();

	/**
	 * Returns the meta object for class '{@link adapters.ConfigContext <em>Config Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Context</em>'.
	 * @see adapters.ConfigContext
	 * @generated
	 */
	EClass getConfigContext();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AdaptersFactory getAdaptersFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link adapters.impl.AdapterModelImpl <em>Adapter Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adapters.impl.AdapterModelImpl
		 * @see adapters.impl.AdaptersPackageImpl#getAdapterModel()
		 * @generated
		 */
		EClass ADAPTER_MODEL = eINSTANCE.getAdapterModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER_MODEL__NAME = eINSTANCE.getAdapterModel_Name();

		/**
		 * The meta object literal for the '<em><b>Ecore</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER_MODEL__ECORE = eINSTANCE.getAdapterModel_Ecore();

		/**
		 * The meta object literal for the '<em><b>Adapters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER_MODEL__ADAPTERS = eINSTANCE.getAdapterModel_Adapters();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER_MODEL__TRANSFORMATION = eINSTANCE.getAdapterModel_Transformation();

		/**
		 * The meta object literal for the '{@link adapters.impl.AdapterImpl <em>Adapter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adapters.impl.AdapterImpl
		 * @see adapters.impl.AdaptersPackageImpl#getAdapter()
		 * @generated
		 */
		EClass ADAPTER = eINSTANCE.getAdapter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER__NAME = eINSTANCE.getAdapter_Name();

		/**
		 * The meta object literal for the '<em><b>Cfg Diff</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADAPTER__CFG_DIFF = eINSTANCE.getAdapter_CfgDiff();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADAPTER__RULES = eINSTANCE.getAdapter_Rules();

		/**
		 * The meta object literal for the '{@link adapters.impl.ConfigDiffImpl <em>Config Diff</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adapters.impl.ConfigDiffImpl
		 * @see adapters.impl.AdaptersPackageImpl#getConfigDiff()
		 * @generated
		 */
		EClass CONFIG_DIFF = eINSTANCE.getConfigDiff();

		/**
		 * The meta object literal for the '<em><b>Delta</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG_DIFF__DELTA = eINSTANCE.getConfigDiff_Delta();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG_DIFF__CONTEXT = eINSTANCE.getConfigDiff_Context();

		/**
		 * The meta object literal for the '{@link adapters.impl.ConfigTupleImpl <em>Config Tuple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adapters.impl.ConfigTupleImpl
		 * @see adapters.impl.AdaptersPackageImpl#getConfigTuple()
		 * @generated
		 */
		EClass CONFIG_TUPLE = eINSTANCE.getConfigTuple();

		/**
		 * The meta object literal for the '<em><b>Pos Set</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG_TUPLE__POS_SET = eINSTANCE.getConfigTuple_PosSet();

		/**
		 * The meta object literal for the '<em><b>Neg Set</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIG_TUPLE__NEG_SET = eINSTANCE.getConfigTuple_NegSet();

		/**
		 * The meta object literal for the '{@link adapters.impl.ConfigDeltaImpl <em>Config Delta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adapters.impl.ConfigDeltaImpl
		 * @see adapters.impl.AdaptersPackageImpl#getConfigDelta()
		 * @generated
		 */
		EClass CONFIG_DELTA = eINSTANCE.getConfigDelta();

		/**
		 * The meta object literal for the '{@link adapters.impl.ConfigContextImpl <em>Config Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see adapters.impl.ConfigContextImpl
		 * @see adapters.impl.AdaptersPackageImpl#getConfigContext()
		 * @generated
		 */
		EClass CONFIG_CONTEXT = eINSTANCE.getConfigContext();

	}

} //AdaptersPackage
