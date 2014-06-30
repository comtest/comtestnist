/**
 */
package citlab.model.citL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Assign</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.EnumAssign#getLeft <em>Left</em>}</li>
 *   <li>{@link citlab.model.citL.EnumAssign#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getEnumAssign()
 * @model
 * @generated
 */
public interface EnumAssign extends AtomicPredicate
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
   * @see citlab.model.citL.CitLPackage#getEnumAssign_Left()
   * @model
   * @generated
   */
  Enumerative getLeft();

  /**
   * Sets the value of the '{@link citlab.model.citL.EnumAssign#getLeft <em>Left</em>}' reference.
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
   * @see citlab.model.citL.CitLPackage#getEnumAssign_Right()
   * @model
   * @generated
   */
  Element getRight();

  /**
   * Sets the value of the '{@link citlab.model.citL.EnumAssign#getRight <em>Right</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Element value);

} // EnumAssign
