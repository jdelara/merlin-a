/**
 */
package adapters;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see adapters.AdaptersPackage
 * @generated
 */
public interface AdaptersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AdaptersFactory eINSTANCE = adapters.impl.AdaptersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Adapter Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter Model</em>'.
	 * @generated
	 */
	AdapterModel createAdapterModel();

	/**
	 * Returns a new object of class '<em>Adapter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Adapter</em>'.
	 * @generated
	 */
	Adapter createAdapter();

	/**
	 * Returns a new object of class '<em>Config Diff</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Config Diff</em>'.
	 * @generated
	 */
	ConfigDiff createConfigDiff();

	/**
	 * Returns a new object of class '<em>Config Delta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Config Delta</em>'.
	 * @generated
	 */
	ConfigDelta createConfigDelta();

	/**
	 * Returns a new object of class '<em>Config Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Config Context</em>'.
	 * @generated
	 */
	ConfigContext createConfigContext();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AdaptersPackage getAdaptersPackage();

} //AdaptersFactory
