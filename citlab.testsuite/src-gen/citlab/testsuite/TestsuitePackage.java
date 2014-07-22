/**
 */
package citlab.testsuite;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see citlab.testsuite.TestsuiteFactory
 * @model kind="package"
 * @generated
 */
public interface TestsuitePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testsuite";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://citlab.org/testsuite";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testsuite";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestsuitePackage eINSTANCE = citlab.testsuite.impl.TestsuitePackageImpl.init();

	/**
	 * The meta object id for the '{@link citlab.testsuite.impl.TestSuiteImpl <em>Test Suite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see citlab.testsuite.impl.TestSuiteImpl
	 * @see citlab.testsuite.impl.TestsuitePackageImpl#getTestSuite()
	 * @generated
	 */
	int TEST_SUITE = 0;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__MODEL = 0;

	/**
	 * The feature id for the '<em><b>Strength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__STRENGTH = 1;

	/**
	 * The feature id for the '<em><b>Tests</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__TESTS = 2;

	/**
	 * The feature id for the '<em><b>Generator Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__GENERATOR_NAME = 3;

	/**
	 * The feature id for the '<em><b>Generator Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE__GENERATOR_TIME = 4;

	/**
	 * The number of structural features of the '<em>Test Suite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link citlab.testsuite.impl.TestImpl <em>Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see citlab.testsuite.impl.TestImpl
	 * @see citlab.testsuite.impl.TestsuitePackageImpl#getTest()
	 * @generated
	 */
	int TEST = 1;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__ASSIGNMENTS = 0;

	/**
	 * The number of structural features of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link citlab.testsuite.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see citlab.testsuite.impl.AssignmentImpl
	 * @see citlab.testsuite.impl.TestsuitePackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 2;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link citlab.testsuite.TestSuite <em>Test Suite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Suite</em>'.
	 * @see citlab.testsuite.TestSuite
	 * @generated
	 */
	EClass getTestSuite();

	/**
	 * Returns the meta object for the reference '{@link citlab.testsuite.TestSuite#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see citlab.testsuite.TestSuite#getModel()
	 * @see #getTestSuite()
	 * @generated
	 */
	EReference getTestSuite_Model();

	/**
	 * Returns the meta object for the attribute '{@link citlab.testsuite.TestSuite#getStrength <em>Strength</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strength</em>'.
	 * @see citlab.testsuite.TestSuite#getStrength()
	 * @see #getTestSuite()
	 * @generated
	 */
	EAttribute getTestSuite_Strength();

	/**
	 * Returns the meta object for the reference list '{@link citlab.testsuite.TestSuite#getTests <em>Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tests</em>'.
	 * @see citlab.testsuite.TestSuite#getTests()
	 * @see #getTestSuite()
	 * @generated
	 */
	EReference getTestSuite_Tests();

	/**
	 * Returns the meta object for the attribute '{@link citlab.testsuite.TestSuite#getGeneratorName <em>Generator Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generator Name</em>'.
	 * @see citlab.testsuite.TestSuite#getGeneratorName()
	 * @see #getTestSuite()
	 * @generated
	 */
	EAttribute getTestSuite_GeneratorName();

	/**
	 * Returns the meta object for the attribute '{@link citlab.testsuite.TestSuite#getGeneratorTime <em>Generator Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generator Time</em>'.
	 * @see citlab.testsuite.TestSuite#getGeneratorTime()
	 * @see #getTestSuite()
	 * @generated
	 */
	EAttribute getTestSuite_GeneratorTime();

	/**
	 * Returns the meta object for class '{@link citlab.testsuite.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test</em>'.
	 * @see citlab.testsuite.Test
	 * @generated
	 */
	EClass getTest();

	/**
	 * Returns the meta object for the reference list '{@link citlab.testsuite.Test#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assignments</em>'.
	 * @see citlab.testsuite.Test#getAssignments()
	 * @see #getTest()
	 * @generated
	 */
	EReference getTest_Assignments();

	/**
	 * Returns the meta object for class '{@link citlab.testsuite.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see citlab.testsuite.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the reference '{@link citlab.testsuite.Assignment#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see citlab.testsuite.Assignment#getParameter()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link citlab.testsuite.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see citlab.testsuite.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	EAttribute getAssignment_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestsuiteFactory getTestsuiteFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link citlab.testsuite.impl.TestSuiteImpl <em>Test Suite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see citlab.testsuite.impl.TestSuiteImpl
		 * @see citlab.testsuite.impl.TestsuitePackageImpl#getTestSuite()
		 * @generated
		 */
		EClass TEST_SUITE = eINSTANCE.getTestSuite();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SUITE__MODEL = eINSTANCE.getTestSuite_Model();

		/**
		 * The meta object literal for the '<em><b>Strength</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SUITE__STRENGTH = eINSTANCE.getTestSuite_Strength();

		/**
		 * The meta object literal for the '<em><b>Tests</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SUITE__TESTS = eINSTANCE.getTestSuite_Tests();

		/**
		 * The meta object literal for the '<em><b>Generator Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SUITE__GENERATOR_NAME = eINSTANCE.getTestSuite_GeneratorName();

		/**
		 * The meta object literal for the '<em><b>Generator Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SUITE__GENERATOR_TIME = eINSTANCE.getTestSuite_GeneratorTime();

		/**
		 * The meta object literal for the '{@link citlab.testsuite.impl.TestImpl <em>Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see citlab.testsuite.impl.TestImpl
		 * @see citlab.testsuite.impl.TestsuitePackageImpl#getTest()
		 * @generated
		 */
		EClass TEST = eINSTANCE.getTest();

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST__ASSIGNMENTS = eINSTANCE.getTest_Assignments();

		/**
		 * The meta object literal for the '{@link citlab.testsuite.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see citlab.testsuite.impl.AssignmentImpl
		 * @see citlab.testsuite.impl.TestsuitePackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__PARAMETER = eINSTANCE.getAssignment_Parameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

	}

} //TestsuitePackage
