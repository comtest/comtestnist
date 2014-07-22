/**
 */
package citlab.testsuite.impl;

import citlab.model.citL.CitModel;

import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import citlab.testsuite.TestsuitePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link citlab.testsuite.impl.TestSuiteImpl#getModel <em>Model</em>}</li>
 *   <li>{@link citlab.testsuite.impl.TestSuiteImpl#getStrength <em>Strength</em>}</li>
 *   <li>{@link citlab.testsuite.impl.TestSuiteImpl#getTests <em>Tests</em>}</li>
 *   <li>{@link citlab.testsuite.impl.TestSuiteImpl#getGeneratorName <em>Generator Name</em>}</li>
 *   <li>{@link citlab.testsuite.impl.TestSuiteImpl#getGeneratorTime <em>Generator Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestSuiteImpl extends EObjectImpl implements TestSuite {
	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected CitModel model;

	/**
	 * The default value of the '{@link #getStrength() <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrength()
	 * @generated
	 * @ordered
	 */
	protected static final int STRENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStrength() <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrength()
	 * @generated
	 * @ordered
	 */
	protected int strength = STRENGTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTests() <em>Tests</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTests()
	 * @generated
	 * @ordered
	 */
	protected EList<Test> tests;

	/**
	 * The default value of the '{@link #getGeneratorName() <em>Generator Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratorName()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGeneratorName() <em>Generator Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratorName()
	 * @generated
	 * @ordered
	 */
	protected String generatorName = GENERATOR_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeneratorTime() <em>Generator Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratorTime()
	 * @generated
	 * @ordered
	 */
	protected static final float GENERATOR_TIME_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getGeneratorTime() <em>Generator Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratorTime()
	 * @generated
	 * @ordered
	 */
	protected float generatorTime = GENERATOR_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSuiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestsuitePackage.Literals.TEST_SUITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CitModel getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = (CitModel)eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestsuitePackage.TEST_SUITE__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CitModel basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(CitModel newModel) {
		CitModel oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestsuitePackage.TEST_SUITE__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrength(int newStrength) {
		int oldStrength = strength;
		strength = newStrength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestsuitePackage.TEST_SUITE__STRENGTH, oldStrength, strength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Test> getTests() {
		if (tests == null) {
			tests = new EObjectResolvingEList<Test>(Test.class, this, TestsuitePackage.TEST_SUITE__TESTS);
		}
		return tests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGeneratorName() {
		return generatorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratorName(String newGeneratorName) {
		String oldGeneratorName = generatorName;
		generatorName = newGeneratorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestsuitePackage.TEST_SUITE__GENERATOR_NAME, oldGeneratorName, generatorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getGeneratorTime() {
		return generatorTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratorTime(float newGeneratorTime) {
		float oldGeneratorTime = generatorTime;
		generatorTime = newGeneratorTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestsuitePackage.TEST_SUITE__GENERATOR_TIME, oldGeneratorTime, generatorTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestsuitePackage.TEST_SUITE__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case TestsuitePackage.TEST_SUITE__STRENGTH:
				return getStrength();
			case TestsuitePackage.TEST_SUITE__TESTS:
				return getTests();
			case TestsuitePackage.TEST_SUITE__GENERATOR_NAME:
				return getGeneratorName();
			case TestsuitePackage.TEST_SUITE__GENERATOR_TIME:
				return getGeneratorTime();
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
			case TestsuitePackage.TEST_SUITE__MODEL:
				setModel((CitModel)newValue);
				return;
			case TestsuitePackage.TEST_SUITE__STRENGTH:
				setStrength((Integer)newValue);
				return;
			case TestsuitePackage.TEST_SUITE__TESTS:
				getTests().clear();
				getTests().addAll((Collection<? extends Test>)newValue);
				return;
			case TestsuitePackage.TEST_SUITE__GENERATOR_NAME:
				setGeneratorName((String)newValue);
				return;
			case TestsuitePackage.TEST_SUITE__GENERATOR_TIME:
				setGeneratorTime((Float)newValue);
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
			case TestsuitePackage.TEST_SUITE__MODEL:
				setModel((CitModel)null);
				return;
			case TestsuitePackage.TEST_SUITE__STRENGTH:
				setStrength(STRENGTH_EDEFAULT);
				return;
			case TestsuitePackage.TEST_SUITE__TESTS:
				getTests().clear();
				return;
			case TestsuitePackage.TEST_SUITE__GENERATOR_NAME:
				setGeneratorName(GENERATOR_NAME_EDEFAULT);
				return;
			case TestsuitePackage.TEST_SUITE__GENERATOR_TIME:
				setGeneratorTime(GENERATOR_TIME_EDEFAULT);
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
			case TestsuitePackage.TEST_SUITE__MODEL:
				return model != null;
			case TestsuitePackage.TEST_SUITE__STRENGTH:
				return strength != STRENGTH_EDEFAULT;
			case TestsuitePackage.TEST_SUITE__TESTS:
				return tests != null && !tests.isEmpty();
			case TestsuitePackage.TEST_SUITE__GENERATOR_NAME:
				return GENERATOR_NAME_EDEFAULT == null ? generatorName != null : !GENERATOR_NAME_EDEFAULT.equals(generatorName);
			case TestsuitePackage.TEST_SUITE__GENERATOR_TIME:
				return generatorTime != GENERATOR_TIME_EDEFAULT;
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
		result.append(" (strength: ");
		result.append(strength);
		result.append(", generatorName: ");
		result.append(generatorName);
		result.append(", generatorTime: ");
		result.append(generatorTime);
		result.append(')');
		return result.toString();
	}

} //TestSuiteImpl
