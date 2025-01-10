/**
 */
package adapters.impl;

import adapters.Adapter;
import adapters.AdaptersPackage;
import adapters.ConfigDiff;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Adapter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link adapters.impl.AdapterImpl#getName <em>Name</em>}</li>
 *   <li>{@link adapters.impl.AdapterImpl#getCfgDiff <em>Cfg Diff</em>}</li>
 *   <li>{@link adapters.impl.AdapterImpl#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdapterImpl extends MinimalEObjectImpl.Container implements Adapter {
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
	 * The cached value of the '{@link #getCfgDiff() <em>Cfg Diff</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCfgDiff()
	 * @generated
	 * @ordered
	 */
	protected ConfigDiff cfgDiff;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<String> rules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdapterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptersPackage.Literals.ADAPTER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptersPackage.ADAPTER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigDiff getCfgDiff() {
		return cfgDiff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCfgDiff(ConfigDiff newCfgDiff, NotificationChain msgs) {
		ConfigDiff oldCfgDiff = cfgDiff;
		cfgDiff = newCfgDiff;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AdaptersPackage.ADAPTER__CFG_DIFF, oldCfgDiff, newCfgDiff);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCfgDiff(ConfigDiff newCfgDiff) {
		if (newCfgDiff != cfgDiff) {
			NotificationChain msgs = null;
			if (cfgDiff != null)
				msgs = ((InternalEObject)cfgDiff).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AdaptersPackage.ADAPTER__CFG_DIFF, null, msgs);
			if (newCfgDiff != null)
				msgs = ((InternalEObject)newCfgDiff).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AdaptersPackage.ADAPTER__CFG_DIFF, null, msgs);
			msgs = basicSetCfgDiff(newCfgDiff, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptersPackage.ADAPTER__CFG_DIFF, newCfgDiff, newCfgDiff));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRules() {
		if (rules == null) {
			rules = new EDataTypeUniqueEList<String>(String.class, this, AdaptersPackage.ADAPTER__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AdaptersPackage.ADAPTER__CFG_DIFF:
				return basicSetCfgDiff(null, msgs);
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
			case AdaptersPackage.ADAPTER__NAME:
				return getName();
			case AdaptersPackage.ADAPTER__CFG_DIFF:
				return getCfgDiff();
			case AdaptersPackage.ADAPTER__RULES:
				return getRules();
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
			case AdaptersPackage.ADAPTER__NAME:
				setName((String)newValue);
				return;
			case AdaptersPackage.ADAPTER__CFG_DIFF:
				setCfgDiff((ConfigDiff)newValue);
				return;
			case AdaptersPackage.ADAPTER__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends String>)newValue);
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
			case AdaptersPackage.ADAPTER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AdaptersPackage.ADAPTER__CFG_DIFF:
				setCfgDiff((ConfigDiff)null);
				return;
			case AdaptersPackage.ADAPTER__RULES:
				getRules().clear();
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
			case AdaptersPackage.ADAPTER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AdaptersPackage.ADAPTER__CFG_DIFF:
				return cfgDiff != null;
			case AdaptersPackage.ADAPTER__RULES:
				return rules != null && !rules.isEmpty();
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
		result.append(", rules: ");
		result.append(rules);
		result.append(')');
		return result.toString();
	}

} //AdapterImpl
