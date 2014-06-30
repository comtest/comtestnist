/**
 */
package citlab.model.citL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.AtomicPredicate#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getAtomicPredicate()
 * @model
 * @generated
 */
public interface AtomicPredicate extends Expression
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link citlab.model.citL.Operators}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see citlab.model.citL.Operators
   * @see #setOp(Operators)
   * @see citlab.model.citL.CitLPackage#getAtomicPredicate_Op()
   * @model
   * @generated
   */
  Operators getOp();

  /**
   * Sets the value of the '{@link citlab.model.citL.AtomicPredicate#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see citlab.model.citL.Operators
   * @see #getOp()
   * @generated
   */
  void setOp(Operators value);

} // AtomicPredicate
