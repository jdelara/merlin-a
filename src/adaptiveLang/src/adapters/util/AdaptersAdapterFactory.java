/**
 */
package adapters.util;

import adapters.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see adapters.AdaptersPackage
 * @generated
 */
public class AdaptersAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AdaptersPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdaptersAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AdaptersPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdaptersSwitch<Adapter> modelSwitch =
		new AdaptersSwitch<Adapter>() {
			@Override
			public Adapter caseAdapterModel(AdapterModel object) {
				return createAdapterModelAdapter();
			}
			@Override
			public Adapter caseAdapter(adapters.Adapter object) {
				return createAdapterAdapter();
			}
			@Override
			public Adapter caseConfigDiff(ConfigDiff object) {
				return createConfigDiffAdapter();
			}
			@Override
			public Adapter caseConfigTuple(ConfigTuple object) {
				return createConfigTupleAdapter();
			}
			@Override
			public Adapter caseConfigDelta(ConfigDelta object) {
				return createConfigDeltaAdapter();
			}
			@Override
			public Adapter caseConfigContext(ConfigContext object) {
				return createConfigContextAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link adapters.AdapterModel <em>Adapter Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see adapters.AdapterModel
	 * @generated
	 */
	public Adapter createAdapterModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link adapters.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see adapters.Adapter
	 * @generated
	 */
	public Adapter createAdapterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link adapters.ConfigDiff <em>Config Diff</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see adapters.ConfigDiff
	 * @generated
	 */
	public Adapter createConfigDiffAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link adapters.ConfigTuple <em>Config Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see adapters.ConfigTuple
	 * @generated
	 */
	public Adapter createConfigTupleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link adapters.ConfigDelta <em>Config Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see adapters.ConfigDelta
	 * @generated
	 */
	public Adapter createConfigDeltaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link adapters.ConfigContext <em>Config Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see adapters.ConfigContext
	 * @generated
	 */
	public Adapter createConfigContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AdaptersAdapterFactory
