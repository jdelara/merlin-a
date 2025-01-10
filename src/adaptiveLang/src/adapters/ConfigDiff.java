/**
 */
package adapters;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config Diff</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link adapters.ConfigDiff#getDelta <em>Delta</em>}</li>
 *   <li>{@link adapters.ConfigDiff#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @see adapters.AdaptersPackage#getConfigDiff()
 * @model
 * @generated
 */
public interface ConfigDiff extends EObject {
	/**
	 * Returns the value of the '<em><b>Delta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delta</em>' containment reference.
	 * @see #setDelta(ConfigDelta)
	 * @see adapters.AdaptersPackage#getConfigDiff_Delta()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConfigDelta getDelta();

	/**
	 * Sets the value of the '{@link adapters.ConfigDiff#getDelta <em>Delta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta</em>' containment reference.
	 * @see #getDelta()
	 * @generated
	 */
	void setDelta(ConfigDelta value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference.
	 * @see #setContext(ConfigContext)
	 * @see adapters.AdaptersPackage#getConfigDiff_Context()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConfigContext getContext();

	/**
	 * Sets the value of the '{@link adapters.ConfigDiff#getContext <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' containment reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(ConfigContext value);

	
	/**
	 * 
	 * @return the list of features of the delta and the context
	 * @generated NOT
	 */
	List<String> getFeatures();
} // ConfigDiff
