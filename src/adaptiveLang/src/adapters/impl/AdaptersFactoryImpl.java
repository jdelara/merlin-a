/**
 */
package adapters.impl;

import adapters.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AdaptersFactoryImpl extends EFactoryImpl implements AdaptersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AdaptersFactory init() {
		try {
			AdaptersFactory theAdaptersFactory = (AdaptersFactory)EPackage.Registry.INSTANCE.getEFactory(AdaptersPackage.eNS_URI);
			if (theAdaptersFactory != null) {
				return theAdaptersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AdaptersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdaptersFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AdaptersPackage.ADAPTER_MODEL: return createAdapterModel();
			case AdaptersPackage.ADAPTER: return createAdapter();
			case AdaptersPackage.CONFIG_DIFF: return createConfigDiff();
			case AdaptersPackage.CONFIG_DELTA: return createConfigDelta();
			case AdaptersPackage.CONFIG_CONTEXT: return createConfigContext();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdapterModel createAdapterModel() {
		AdapterModelImpl adapterModel = new AdapterModelImpl();
		return adapterModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createAdapter() {
		AdapterImpl adapter = new AdapterImpl();
		return adapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigDiff createConfigDiff() {
		ConfigDiffImpl configDiff = new ConfigDiffImpl();
		return configDiff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigDelta createConfigDelta() {
		ConfigDeltaImpl configDelta = new ConfigDeltaImpl();
		return configDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigContext createConfigContext() {
		ConfigContextImpl configContext = new ConfigContextImpl();
		return configContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdaptersPackage getAdaptersPackage() {
		return (AdaptersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AdaptersPackage getPackage() {
		return AdaptersPackage.eINSTANCE;
	}

} //AdaptersFactoryImpl
