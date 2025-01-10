/**
 */
package adapters.impl;

import adapters.Adapter;
import adapters.AdapterModel;
import adapters.AdaptersPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adapter Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link adapters.impl.AdapterModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link adapters.impl.AdapterModelImpl#getEcore <em>Ecore</em>}</li>
 *   <li>{@link adapters.impl.AdapterModelImpl#getAdapters <em>Adapters</em>}</li>
 *   <li>{@link adapters.impl.AdapterModelImpl#getTransformation <em>Transformation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdapterModelImpl extends MinimalEObjectImpl.Container implements AdapterModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEcore() <em>Ecore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcore()
	 * @generated
	 * @ordered
	 */
	protected static final String ECORE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEcore() <em>Ecore</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcore()
	 * @generated
	 * @ordered
	 */
	protected String ecore = ECORE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdapters() <em>Adapters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapters()
	 * @generated
	 * @ordered
	 */
	protected EList<Adapter> adapters;

	/**
	 * The default value of the '{@link #getTransformation() <em>Transformation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformation()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSFORMATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransformation() <em>Transformation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformation()
	 * @generated
	 * @ordered
	 */
	protected String transformation = TRANSFORMATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptersPackage.Literals.ADAPTER_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptersPackage.ADAPTER_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEcore() {
		return ecore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcore(String newEcore) {
		String oldEcore = ecore;
		ecore = newEcore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptersPackage.ADAPTER_MODEL__ECORE, oldEcore, ecore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Adapter> getAdapters() {
		if (adapters == null) {
			adapters = new EObjectContainmentEList<Adapter>(Adapter.class, this, AdaptersPackage.ADAPTER_MODEL__ADAPTERS);
		}
		return adapters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransformation() {
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(String newTransformation) {
		String oldTransformation = transformation;
		transformation = newTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptersPackage.ADAPTER_MODEL__TRANSFORMATION, oldTransformation, transformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AdaptersPackage.ADAPTER_MODEL__ADAPTERS:
				return ((InternalEList<?>)getAdapters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdaptersPackage.ADAPTER_MODEL__NAME:
				return getName();
			case AdaptersPackage.ADAPTER_MODEL__ECORE:
				return getEcore();
			case AdaptersPackage.ADAPTER_MODEL__ADAPTERS:
				return getAdapters();
			case AdaptersPackage.ADAPTER_MODEL__TRANSFORMATION:
				return getTransformation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AdaptersPackage.ADAPTER_MODEL__NAME:
				setName((String)newValue);
				return;
			case AdaptersPackage.ADAPTER_MODEL__ECORE:
				setEcore((String)newValue);
				return;
			case AdaptersPackage.ADAPTER_MODEL__ADAPTERS:
				getAdapters().clear();
				getAdapters().addAll((Collection<? extends Adapter>)newValue);
				return;
			case AdaptersPackage.ADAPTER_MODEL__TRANSFORMATION:
				setTransformation((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AdaptersPackage.ADAPTER_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AdaptersPackage.ADAPTER_MODEL__ECORE:
				setEcore(ECORE_EDEFAULT);
				return;
			case AdaptersPackage.ADAPTER_MODEL__ADAPTERS:
				getAdapters().clear();
				return;
			case AdaptersPackage.ADAPTER_MODEL__TRANSFORMATION:
				setTransformation(TRANSFORMATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AdaptersPackage.ADAPTER_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AdaptersPackage.ADAPTER_MODEL__ECORE:
				return ECORE_EDEFAULT == null ? ecore != null : !ECORE_EDEFAULT.equals(ecore);
			case AdaptersPackage.ADAPTER_MODEL__ADAPTERS:
				return adapters != null && !adapters.isEmpty();
			case AdaptersPackage.ADAPTER_MODEL__TRANSFORMATION:
				return TRANSFORMATION_EDEFAULT == null ? transformation != null : !TRANSFORMATION_EDEFAULT.equals(transformation);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", ecore: ");
		result.append(ecore);
		result.append(", transformation: ");
		result.append(transformation);
		result.append(')');
		return result.toString();
	}

} //AdapterModelImpl
