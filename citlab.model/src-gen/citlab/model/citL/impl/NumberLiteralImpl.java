/**
 */
package citlab.model.citL.impl;

import citlab.model.citL.CitLPackage;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.NumericalEx;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link citlab.model.citL.impl.NumberLiteralImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link citlab.model.citL.impl.NumberLiteralImpl#getNumerical <em>Numerical</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumberLiteralImpl extends ExpressionImpl implements NumberLiteral
{
  /**
   * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected static final Integer NUMBER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumber()
   * @generated
   * @ordered
   */
  protected Integer number = NUMBER_EDEFAULT;

  /**
   * The cached value of the '{@link #getNumerical() <em>Numerical</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumerical()
   * @generated
   * @ordered
   */
  protected NumericalEx numerical;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NumberLiteralImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CitLPackage.Literals.NUMBER_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Integer getNumber()
  {
    return number;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumber(Integer newNumber)
  {
    Integer oldNumber = number;
    number = newNumber;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.NUMBER_LITERAL__NUMBER, oldNumber, number));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericalEx getNumerical()
  {
    if (numerical != null && numerical.eIsProxy())
    {
      InternalEObject oldNumerical = (InternalEObject)numerical;
      numerical = (NumericalEx)eResolveProxy(oldNumerical);
      if (numerical != oldNumerical)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CitLPackage.NUMBER_LITERAL__NUMERICAL, oldNumerical, numerical));
      }
    }
    return numerical;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericalEx basicGetNumerical()
  {
    return numerical;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumerical(NumericalEx newNumerical)
  {
    NumericalEx oldNumerical = numerical;
    numerical = newNumerical;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.NUMBER_LITERAL__NUMERICAL, oldNumerical, numerical));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CitLPackage.NUMBER_LITERAL__NUMBER:
        return getNumber();
      case CitLPackage.NUMBER_LITERAL__NUMERICAL:
        if (resolve) return getNumerical();
        return basicGetNumerical();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CitLPackage.NUMBER_LITERAL__NUMBER:
        setNumber((Integer)newValue);
        return;
      case CitLPackage.NUMBER_LITERAL__NUMERICAL:
        setNumerical((NumericalEx)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CitLPackage.NUMBER_LITERAL__NUMBER:
        setNumber(NUMBER_EDEFAULT);
        return;
      case CitLPackage.NUMBER_LITERAL__NUMERICAL:
        setNumerical((NumericalEx)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CitLPackage.NUMBER_LITERAL__NUMBER:
        return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
      case CitLPackage.NUMBER_LITERAL__NUMERICAL:
        return numerical != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (number: ");
    result.append(number);
    result.append(')');
    return result.toString();
  }

} //NumberLiteralImpl
