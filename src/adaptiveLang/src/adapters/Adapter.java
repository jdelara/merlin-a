/**
 */
package adapters;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adapter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link adapters.Adapter#getName <em>Name</em>}</li>
 *   <li>{@link adapters.Adapter#getCfgDiff <em>Cfg Diff</em>}</li>
 *   <li>{@link adapters.Adapter#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see adapters.AdaptersPackage#getAdapter()
 * @model
 * @generated
 */
public interface Adapter extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see adapters.AdaptersPackage#getAdapter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link adapters.Adapter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Cfg Diff</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cfg Diff</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cfg Diff</em>' containment reference.
	 * @see #setCfgDiff(ConfigDiff)
	 * @see adapters.AdaptersPackage#getAdapter_CfgDiff()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConfigDiff getCfgDiff();

	/**
	 * Sets the value of the '{@link adapters.Adapter#getCfgDiff <em>Cfg Diff</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cfg Diff</em>' containment reference.
	 * @see #getCfgDiff()
	 * @generated
	 */
	void setCfgDiff(ConfigDiff value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' attribute list.
	 * @see adapters.AdaptersPackage#getAdapter_Rules()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<String> getRules();

} // Adapter
