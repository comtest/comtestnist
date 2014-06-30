/**
 */
package citlab.model.citL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bool Assign</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.BoolAssign#getLeft <em>Left</em>}</li>
 *   <li>{@link citlab.model.citL.BoolAssign#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getBoolAssign()
 * @model
 * @generated
 */
public interface BoolAssign extends AtomicPredicate
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
   * @see #setLeft(citlab.model.citL.Boolean)
   * @see citlab.model.citL.CitLPackage#getBoolAssign_Left()
   * @model
   * @generated
   */
  citlab.model.citL.Boolean getLeft();

  /**
   * Sets the value of the '{@link citlab.model.citL.BoolAssign#getLeft <em>Left</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(citlab.model.citL.Boolean value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' attribute.
   * The literals are from the enumeration {@link citlab.model.citL.BooleanConst}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' attribute.
   * @see citlab.model.citL.BooleanConst
   * @see #setRight(BooleanConst)
   * @see citlab.model.citL.CitLPackage#getBoolAssign_Right()
   * @model
   * @generated
   */
  BooleanConst getRight();

  /**
   * Sets the value of the '{@link citlab.model.citL.BoolAssign#getRight <em>Right</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' attribute.
   * @see citlab.model.citL.BooleanConst
   * @see #getRight()
   * @generated
   */
  void setRight(BooleanConst value);

} // BoolAssign
