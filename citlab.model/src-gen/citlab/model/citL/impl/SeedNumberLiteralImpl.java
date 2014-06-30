/**
 */
package citlab.model.citL.impl;

import citlab.model.citL.CitLPackage;
import citlab.model.citL.ConstantNumber;
import citlab.model.citL.SeedNumberLiteral;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Seed Number Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link citlab.model.citL.impl.SeedNumberLiteralImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link citlab.model.citL.impl.SeedNumberLiteralImpl#getConstant <em>Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeedNumberLiteralImpl extends MinimalEObjectImpl.Container implements SeedNumberLiteral
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
   * The cached value of the '{@link #getConstant() <em>Constant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstant()
   * @generated
   * @ordered
   */
  protected ConstantNumber constant;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SeedNumberLiteralImpl()
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
    return CitLPackage.Literals.SEED_NUMBER_LITERAL;
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
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.SEED_NUMBER_LITERAL__NUMBER, oldNumber, number));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantNumber getConstant()
  {
    if (constant != null && constant.eIsProxy())
    {
      InternalEObject oldConstant = (InternalEObject)constant;
      constant = (ConstantNumber)eResolveProxy(oldConstant);
      if (constant != oldConstant)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CitLPackage.SEED_NUMBER_LITERAL__CONSTANT, oldConstant, constant));
      }
    }
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantNumber basicGetConstant()
  {
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstant(ConstantNumber newConstant)
  {
    ConstantNumber oldConstant = constant;
    constant = newConstant;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.SEED_NUMBER_LITERAL__CONSTANT, oldConstant, constant));
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
      case CitLPackage.SEED_NUMBER_LITERAL__NUMBER:
        return getNumber();
      case CitLPackage.SEED_NUMBER_LITERAL__CONSTANT:
        if (resolve) return getConstant();
        return basicGetConstant();
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
      case CitLPackage.SEED_NUMBER_LITERAL__NUMBER:
        setNumber((Integer)newValue);
        return;
      case CitLPackage.SEED_NUMBER_LITERAL__CONSTANT:
        setConstant((ConstantNumber)newValue);
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
      case CitLPackage.SEED_NUMBER_LITERAL__NUMBER:
        setNumber(NUMBER_EDEFAULT);
        return;
      case CitLPackage.SEED_NUMBER_LITERAL__CONSTANT:
        setConstant((ConstantNumber)null);
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
      case CitLPackage.SEED_NUMBER_LITERAL__NUMBER:
        return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
      case CitLPackage.SEED_NUMBER_LITERAL__CONSTANT:
        return constant != null;
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

} //SeedNumberLiteralImpl
