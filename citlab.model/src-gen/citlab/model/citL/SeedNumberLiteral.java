/**
 */
package citlab.model.citL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Seed Number Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.SeedNumberLiteral#getNumber <em>Number</em>}</li>
 *   <li>{@link citlab.model.citL.SeedNumberLiteral#getConstant <em>Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getSeedNumberLiteral()
 * @model
 * @generated
 */
public interface SeedNumberLiteral extends EObject
{
  /**
   * Returns the value of the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' attribute.
   * @see #setNumber(Integer)
   * @see citlab.model.citL.CitLPackage#getSeedNumberLiteral_Number()
   * @model
   * @generated
   */
  Integer getNumber();

  /**
   * Sets the value of the '{@link citlab.model.citL.SeedNumberLiteral#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #getNumber()
   * @generated
   */
  void setNumber(Integer value);

  /**
   * Returns the value of the '<em><b>Constant</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constant</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constant</em>' reference.
   * @see #setConstant(ConstantNumber)
   * @see citlab.model.citL.CitLPackage#getSeedNumberLiteral_Constant()
   * @model
   * @generated
   */
  ConstantNumber getConstant();

  /**
   * Sets the value of the '{@link citlab.model.citL.SeedNumberLiteral#getConstant <em>Constant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constant</em>' reference.
   * @see #getConstant()
   * @generated
   */
  void setConstant(ConstantNumber value);

} // SeedNumberLiteral
