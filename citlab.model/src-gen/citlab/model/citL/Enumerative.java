/**
 */
package citlab.model.citL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumerative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.Enumerative#getNamedType <em>Named Type</em>}</li>
 *   <li>{@link citlab.model.citL.Enumerative#getAtype <em>Atype</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getEnumerative()
 * @model
 * @generated
 */
public interface Enumerative extends Parameter
{
  /**
   * Returns the value of the '<em><b>Named Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Named Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Named Type</em>' reference.
   * @see #setNamedType(NamedType)
   * @see citlab.model.citL.CitLPackage#getEnumerative_NamedType()
   * @model
   * @generated
   */
  NamedType getNamedType();

  /**
   * Sets the value of the '{@link citlab.model.citL.Enumerative#getNamedType <em>Named Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Named Type</em>' reference.
   * @see #getNamedType()
   * @generated
   */
  void setNamedType(NamedType value);

  /**
   * Returns the value of the '<em><b>Atype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Atype</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Atype</em>' containment reference.
   * @see #setAtype(AnonymousType)
   * @see citlab.model.citL.CitLPackage#getEnumerative_Atype()
   * @model containment="true"
   * @generated
   */
  AnonymousType getAtype();

  /**
   * Sets the value of the '{@link citlab.model.citL.Enumerative#getAtype <em>Atype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Atype</em>' containment reference.
   * @see #getAtype()
   * @generated
   */
  void setAtype(AnonymousType value);

} // Enumerative
