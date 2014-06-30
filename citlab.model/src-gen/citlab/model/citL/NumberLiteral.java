/**
 */
package citlab.model.citL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.NumberLiteral#getNumber <em>Number</em>}</li>
 *   <li>{@link citlab.model.citL.NumberLiteral#getNumerical <em>Numerical</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getNumberLiteral()
 * @model
 * @generated
 */
public interface NumberLiteral extends Expression
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
   * @see citlab.model.citL.CitLPackage#getNumberLiteral_Number()
   * @model
   * @generated
   */
  Integer getNumber();

  /**
   * Sets the value of the '{@link citlab.model.citL.NumberLiteral#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #getNumber()
   * @generated
   */
  void setNumber(Integer value);

  /**
   * Returns the value of the '<em><b>Numerical</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Numerical</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Numerical</em>' reference.
   * @see #setNumerical(NumericalEx)
   * @see citlab.model.citL.CitLPackage#getNumberLiteral_Numerical()
   * @model
   * @generated
   */
  NumericalEx getNumerical();

  /**
   * Sets the value of the '{@link citlab.model.citL.NumberLiteral#getNumerical <em>Numerical</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Numerical</em>' reference.
   * @see #getNumerical()
   * @generated
   */
  void setNumerical(NumericalEx value);

} // NumberLiteral
