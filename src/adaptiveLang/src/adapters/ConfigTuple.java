/**
 */
package adapters;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link adapters.ConfigTuple#getPosSet <em>Pos Set</em>}</li>
 *   <li>{@link adapters.ConfigTuple#getNegSet <em>Neg Set</em>}</li>
 * </ul>
 *
 * @see adapters.AdaptersPackage#getConfigTuple()
 * @model abstract="true"
 * @generated
 */
public interface ConfigTuple extends EObject {
	/**
	 * Returns the value of the '<em><b>Pos Set</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pos Set</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos Set</em>' attribute list.
	 * @see adapters.AdaptersPackage#getConfigTuple_PosSet()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<String> getPosSet();

	/**
	 * Returns the value of the '<em><b>Neg Set</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Neg Set</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Neg Set</em>' attribute list.
	 * @see adapters.AdaptersPackage#getConfigTuple_NegSet()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<String> getNegSet();

} // ConfigTuple
