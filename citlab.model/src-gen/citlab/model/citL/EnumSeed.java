/**
 */
package citlab.model.citL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Seed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.EnumSeed#getLeft <em>Left</em>}</li>
 *   <li>{@link citlab.model.citL.EnumSeed#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getEnumSeed()
 * @model
 * @generated
 */
public interface EnumSeed extends Aseed
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
   * @see #setLeft(Enumerative)
   * @see citlab.model.citL.CitLPackage#getEnumSeed_Left()
   * @model
   * @generated
   */
  Enumerative getLeft();

  /**
   * Sets the value of the '{@link citlab.model.citL.EnumSeed#getLeft <em>Left</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Enumerative value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' reference.
   * @see #setRight(Element)
   * @see citlab.model.citL.CitLPackage#getEnumSeed_Right()
   * @model
   * @generated
   */
  Element getRight();

  /**
   * Sets the value of the '{@link citlab.model.citL.EnumSeed#getRight <em>Right</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Element value);

} // EnumSeed
