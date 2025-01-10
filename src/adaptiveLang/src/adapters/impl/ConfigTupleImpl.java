/**
 */
package adapters.impl;

import adapters.AdaptersPackage;
import adapters.ConfigTuple;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link adapters.impl.ConfigTupleImpl#getPosSet <em>Pos Set</em>}</li>
 *   <li>{@link adapters.impl.ConfigTupleImpl#getNegSet <em>Neg Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConfigTupleImpl extends MinimalEObjectImpl.Container implements ConfigTuple {
	/**
	 * The cached value of the '{@link #getPosSet() <em>Pos Set</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosSet()
	 * @generated
	 * @ordered
	 */
	protected EList<String> posSet;

	/**
	 * The cached value of the '{@link #getNegSet() <em>Neg Set</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNegSet()
	 * @generated
	 * @ordered
	 */
	protected EList<String> negSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigTupleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptersPackage.Literals.CONFIG_TUPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPosSet() {
		if (posSet == null) {
			posSet = new EDataTypeUniqueEList<String>(String.class, this, AdaptersPackage.CONFIG_TUPLE__POS_SET);
		}
		return posSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getNegSet() {
		if (negSet == null) {
			negSet = new EDataTypeUniqueEList<String>(String.class, this, AdaptersPackage.CONFIG_TUPLE__NEG_SET);
		}
		return negSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdaptersPackage.CONFIG_TUPLE__POS_SET:
				return getPosSet();
			case AdaptersPackage.CONFIG_TUPLE__NEG_SET:
				return getNegSet();
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
			case AdaptersPackage.CONFIG_TUPLE__POS_SET:
				getPosSet().clear();
				getPosSet().addAll((Collection<? extends String>)newValue);
				return;
			case AdaptersPackage.CONFIG_TUPLE__NEG_SET:
				getNegSet().clear();
				getNegSet().addAll((Collection<? extends String>)newValue);
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
			case AdaptersPackage.CONFIG_TUPLE__POS_SET:
				getPosSet().clear();
				return;
			case AdaptersPackage.CONFIG_TUPLE__NEG_SET:
				getNegSet().clear();
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
			case AdaptersPackage.CONFIG_TUPLE__POS_SET:
				return posSet != null && !posSet.isEmpty();
			case AdaptersPackage.CONFIG_TUPLE__NEG_SET:
				return negSet != null && !negSet.isEmpty();
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
		result.append(" (posSet: ");
		result.append(posSet);
		result.append(", negSet: ");
		result.append(negSet);
		result.append(')');
		return result.toString();
	}

} //ConfigTupleImpl
