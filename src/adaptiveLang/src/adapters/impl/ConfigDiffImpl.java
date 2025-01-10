/**
 */
package adapters.impl;

import adapters.AdaptersPackage;
import adapters.ConfigContext;
import adapters.ConfigDelta;
import adapters.ConfigDiff;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Diff</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link adapters.impl.ConfigDiffImpl#getDelta <em>Delta</em>}</li>
 *   <li>{@link adapters.impl.ConfigDiffImpl#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigDiffImpl extends MinimalEObjectImpl.Container implements ConfigDiff {
	/**
	 * The cached value of the '{@link #getDelta() <em>Delta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelta()
	 * @generated
	 * @ordered
	 */
	protected ConfigDelta delta;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected ConfigContext context;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigDiffImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptersPackage.Literals.CONFIG_DIFF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigDelta getDelta() {
		return delta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDelta(ConfigDelta newDelta, NotificationChain msgs) {
		ConfigDelta oldDelta = delta;
		delta = newDelta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AdaptersPackage.CONFIG_DIFF__DELTA, oldDelta, newDelta);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelta(ConfigDelta newDelta) {
		if (newDelta != delta) {
			NotificationChain msgs = null;
			if (delta != null)
				msgs = ((InternalEObject)delta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AdaptersPackage.CONFIG_DIFF__DELTA, null, msgs);
			if (newDelta != null)
				msgs = ((InternalEObject)newDelta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AdaptersPackage.CONFIG_DIFF__DELTA, null, msgs);
			msgs = basicSetDelta(newDelta, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptersPackage.CONFIG_DIFF__DELTA, newDelta, newDelta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigContext getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(ConfigContext newContext, NotificationChain msgs) {
		ConfigContext oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AdaptersPackage.CONFIG_DIFF__CONTEXT, oldContext, newContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(ConfigContext newContext) {
		if (newContext != context) {
			NotificationChain msgs = null;
			if (context != null)
				msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AdaptersPackage.CONFIG_DIFF__CONTEXT, null, msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AdaptersPackage.CONFIG_DIFF__CONTEXT, null, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptersPackage.CONFIG_DIFF__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AdaptersPackage.CONFIG_DIFF__DELTA:
				return basicSetDelta(null, msgs);
			case AdaptersPackage.CONFIG_DIFF__CONTEXT:
				return basicSetContext(null, msgs);
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
			case AdaptersPackage.CONFIG_DIFF__DELTA:
				return getDelta();
			case AdaptersPackage.CONFIG_DIFF__CONTEXT:
				return getContext();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AdaptersPackage.CONFIG_DIFF__DELTA:
				setDelta((ConfigDelta)newValue);
				return;
			case AdaptersPackage.CONFIG_DIFF__CONTEXT:
				setContext((ConfigContext)newValue);
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
			case AdaptersPackage.CONFIG_DIFF__DELTA:
				setDelta((ConfigDelta)null);
				return;
			case AdaptersPackage.CONFIG_DIFF__CONTEXT:
				setContext((ConfigContext)null);
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
			case AdaptersPackage.CONFIG_DIFF__DELTA:
				return delta != null;
			case AdaptersPackage.CONFIG_DIFF__CONTEXT:
				return context != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public List<String> getFeatures() {
		List<String> features = new ArrayList<>();
		features.addAll(this.getContext().getPosSet());
		features.addAll(this.getContext().getNegSet());
		features.addAll(this.getDelta().getPosSet());
		features.addAll(this.getDelta().getNegSet());
		return features;
	}

} //ConfigDiffImpl
