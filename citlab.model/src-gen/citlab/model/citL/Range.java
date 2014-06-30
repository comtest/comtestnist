/**
 */
package citlab.model.citL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.Range#getBegin <em>Begin</em>}</li>
 *   <li>{@link citlab.model.citL.Range#getEnd <em>End</em>}</li>
 *   <li>{@link citlab.model.citL.Range#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getRange()
 * @model
 * @generated
 */
public interface Range extends Numerical
{
  /**
   * Returns the value of the '<em><b>Begin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Begin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Begin</em>' attribute.
   * @see #setBegin(Integer)
   * @see citlab.model.citL.CitLPackage#getRange_Begin()
   * @model
   * @generated
   */
  Integer getBegin();

  /**
   * Sets the value of the '{@link citlab.model.citL.Range#getBegin <em>Begin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Begin</em>' attribute.
   * @see #getBegin()
   * @generated
   */
  void setBegin(Integer value);

  /**
   * Returns the value of the '<em><b>End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' attribute.
   * @see #setEnd(Integer)
   * @see citlab.model.citL.CitLPackage#getRange_End()
   * @model
   * @generated
   */
  Integer getEnd();

  /**
   * Sets the value of the '{@link citlab.model.citL.Range#getEnd <em>End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' attribute.
   * @see #getEnd()
   * @generated
   */
  void setEnd(Integer value);

  /**
   * Returns the value of the '<em><b>Step</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Step</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Step</em>' attribute.
   * @see #setStep(int)
   * @see citlab.model.citL.CitLPackage#getRange_Step()
   * @model
   * @generated
   */
  int getStep();

  /**
   * Sets the value of the '{@link citlab.model.citL.Range#getStep <em>Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Step</em>' attribute.
   * @see #getStep()
   * @generated
   */
  void setStep(int value);

} // Range
