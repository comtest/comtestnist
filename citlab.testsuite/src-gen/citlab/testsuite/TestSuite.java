/**
 */
package citlab.testsuite;

import citlab.model.citL.CitModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.testsuite.TestSuite#getModel <em>Model</em>}</li>
 *   <li>{@link citlab.testsuite.TestSuite#getStrength <em>Strength</em>}</li>
 *   <li>{@link citlab.testsuite.TestSuite#getTests <em>Tests</em>}</li>
 *   <li>{@link citlab.testsuite.TestSuite#getGeneratorName <em>Generator Name</em>}</li>
 *   <li>{@link citlab.testsuite.TestSuite#getGeneratorTime <em>Generator Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.testsuite.TestsuitePackage#getTestSuite()
 * @model
 * @generated
 */
public interface TestSuite extends EObject {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(CitModel)
	 * @see citlab.testsuite.TestsuitePackage#getTestSuite_Model()
	 * @model required="true"
	 * @generated
	 */
	CitModel getModel();

	/**
	 * Sets the value of the '{@link citlab.testsuite.TestSuite#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(CitModel value);

	/**
	 * Returns the value of the '<em><b>Strength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strength</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strength</em>' attribute.
	 * @see #setStrength(int)
	 * @see citlab.testsuite.TestsuitePackage#getTestSuite_Strength()
	 * @model
	 * @generated
	 */
	int getStrength();

	/**
	 * Sets the value of the '{@link citlab.testsuite.TestSuite#getStrength <em>Strength</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strength</em>' attribute.
	 * @see #getStrength()
	 * @generated
	 */
	void setStrength(int value);

	/**
	 * Returns the value of the '<em><b>Tests</b></em>' reference list.
	 * The list contents are of type {@link citlab.testsuite.Test}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tests</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' reference list.
	 * @see citlab.testsuite.TestsuitePackage#getTestSuite_Tests()
	 * @model
	 * @generated
	 */
	EList<Test> getTests();

	/**
	 * Returns the value of the '<em><b>Generator Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generator Name</em>' attribute.
	 * @see #setGeneratorName(String)
	 * @see citlab.testsuite.TestsuitePackage#getTestSuite_GeneratorName()
	 * @model
	 * @generated
	 */
	String getGeneratorName();

	/**
	 * Sets the value of the '{@link citlab.testsuite.TestSuite#getGeneratorName <em>Generator Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generator Name</em>' attribute.
	 * @see #getGeneratorName()
	 * @generated
	 */
	void setGeneratorName(String value);

	/**
	 * Returns the value of the '<em><b>Generator Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generator Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generator Time</em>' attribute.
	 * @see #setGeneratorTime(float)
	 * @see citlab.testsuite.TestsuitePackage#getTestSuite_GeneratorTime()
	 * @model
	 * @generated
	 */
	float getGeneratorTime();

	/**
	 * Sets the value of the '{@link citlab.testsuite.TestSuite#getGeneratorTime <em>Generator Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generator Time</em>' attribute.
	 * @see #getGeneratorTime()
	 * @generated
	 */
	void setGeneratorTime(float value);

} // TestSuite
