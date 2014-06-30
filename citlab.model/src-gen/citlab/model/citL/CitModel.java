/**
 */
package citlab.model.citL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cit Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.CitModel#getName <em>Name</em>}</li>
 *   <li>{@link citlab.model.citL.CitModel#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link citlab.model.citL.CitModel#getTypes <em>Types</em>}</li>
 *   <li>{@link citlab.model.citL.CitModel#getParameters <em>Parameters</em>}</li>
 *   <li>{@link citlab.model.citL.CitModel#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link citlab.model.citL.CitModel#getSeeds <em>Seeds</em>}</li>
 *   <li>{@link citlab.model.citL.CitModel#getTestGoals <em>Test Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getCitModel()
 * @model
 * @generated
 */
public interface CitModel extends EObject
{
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
   * @see citlab.model.citL.CitLPackage#getCitModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link citlab.model.citL.CitModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
   * The list contents are of type {@link citlab.model.citL.Constant}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definitions</em>' containment reference list.
   * @see citlab.model.citL.CitLPackage#getCitModel_Definitions()
   * @model containment="true"
   * @generated
   */
  EList<Constant> getDefinitions();

  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link citlab.model.citL.NamedType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see citlab.model.citL.CitLPackage#getCitModel_Types()
   * @model containment="true"
   * @generated
   */
  EList<NamedType> getTypes();

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link citlab.model.citL.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see citlab.model.citL.CitLPackage#getCitModel_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

  /**
   * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
   * The list contents are of type {@link citlab.model.citL.Rule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' containment reference list.
   * @see citlab.model.citL.CitLPackage#getCitModel_Constraints()
   * @model containment="true"
   * @generated
   */
  EList<Rule> getConstraints();

  /**
   * Returns the value of the '<em><b>Seeds</b></em>' containment reference list.
   * The list contents are of type {@link citlab.model.citL.Seed}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Seeds</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Seeds</em>' containment reference list.
   * @see citlab.model.citL.CitLPackage#getCitModel_Seeds()
   * @model containment="true"
   * @generated
   */
  EList<Seed> getSeeds();

  /**
   * Returns the value of the '<em><b>Test Goals</b></em>' containment reference list.
   * The list contents are of type {@link citlab.model.citL.Rule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Test Goals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Test Goals</em>' containment reference list.
   * @see citlab.model.citL.CitLPackage#getCitModel_TestGoals()
   * @model containment="true"
   * @generated
   */
  EList<Rule> getTestGoals();

} // CitModel
