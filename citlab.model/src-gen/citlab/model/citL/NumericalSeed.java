/**
 */
package citlab.model.citL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Seed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.NumericalSeed#getLeft <em>Left</em>}</li>
 *   <li>{@link citlab.model.citL.NumericalSeed#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getNumericalSeed()
 * @model
 * @generated
 */
public interface NumericalSeed extends Aseed
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' reference.
   * @see #setLeft(Numerical)
   * @see citlab.model.citL.CitLPackage#getNumericalSeed_Left()
   * @model
   * @generated
   */
  Numerical getLeft();

  /**
   * Sets the value of the '{@link citlab.model.citL.NumericalSeed#getLeft <em>Left</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Numerical value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(SeedNumberLiteral)
   * @see citlab.model.citL.CitLPackage#getNumericalSeed_Right()
   * @model containment="true"
   * @generated
   */
  SeedNumberLiteral getRight();

  /**
   * Sets the value of the '{@link citlab.model.citL.NumericalSeed#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(SeedNumberLiteral value);

} // NumericalSeed
