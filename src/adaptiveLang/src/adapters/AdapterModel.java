/**
 */
package adapters;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adapter Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link adapters.AdapterModel#getName <em>Name</em>}</li>
 *   <li>{@link adapters.AdapterModel#getEcore <em>Ecore</em>}</li>
 *   <li>{@link adapters.AdapterModel#getAdapters <em>Adapters</em>}</li>
 *   <li>{@link adapters.AdapterModel#getTransformation <em>Transformation</em>}</li>
 * </ul>
 *
 * @see adapters.AdaptersPackage#getAdapterModel()
 * @model
 * @generated
 */
public interface AdapterModel extends EObject {
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
	 * @see adapters.AdaptersPackage#getAdapterModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link adapters.AdapterModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ecore</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecore</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecore</em>' attribute.
	 * @see #setEcore(String)
	 * @see adapters.AdaptersPackage#getAdapterModel_Ecore()
	 * @model
	 * @generated
	 */
	String getEcore();

	/**
	 * Sets the value of the '{@link adapters.AdapterModel#getEcore <em>Ecore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecore</em>' attribute.
	 * @see #getEcore()
	 * @generated
	 */
	void setEcore(String value);

	/**
	 * Returns the value of the '<em><b>Adapters</b></em>' containment reference list.
	 * The list contents are of type {@link adapters.Adapter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapters</em>' containment reference list.
	 * @see adapters.AdaptersPackage#getAdapterModel_Adapters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Adapter> getAdapters();

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' attribute.
	 * @see #setTransformation(String)
	 * @see adapters.AdaptersPackage#getAdapterModel_Transformation()
	 * @model required="true"
	 * @generated
	 */
	String getTransformation();

	/**
	 * Sets the value of the '{@link adapters.AdapterModel#getTransformation <em>Transformation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' attribute.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(String value);

} // AdapterModel
