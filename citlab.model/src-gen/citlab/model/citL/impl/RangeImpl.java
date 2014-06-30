/**
 */
package citlab.model.citL.impl;

import citlab.model.citL.CitLPackage;
import citlab.model.citL.Range;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link citlab.model.citL.impl.RangeImpl#getBegin <em>Begin</em>}</li>
 *   <li>{@link citlab.model.citL.impl.RangeImpl#getEnd <em>End</em>}</li>
 *   <li>{@link citlab.model.citL.impl.RangeImpl#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RangeImpl extends NumericalImpl implements Range
{
  /**
   * The default value of the '{@link #getBegin() <em>Begin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBegin()
   * @generated
   * @ordered
   */
  protected static final Integer BEGIN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBegin() <em>Begin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBegin()
   * @generated
   * @ordered
   */
  protected Integer begin = BEGIN_EDEFAULT;

  /**
   * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd()
   * @generated
   * @ordered
   */
  protected static final Integer END_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd()
   * @generated
   * @ordered
   */
  protected Integer end = END_EDEFAULT;

  /**
   * The default value of the '{@link #getStep() <em>Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStep()
   * @generated
   * @ordered
   */
  protected static final int STEP_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getStep() <em>Step</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStep()
   * @generated
   * @ordered
   */
  protected int step = STEP_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RangeImpl()
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
    return CitLPackage.Literals.RANGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Integer getBegin()
  {
    return begin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBegin(Integer newBegin)
  {
    Integer oldBegin = begin;
    begin = newBegin;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.RANGE__BEGIN, oldBegin, begin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Integer getEnd()
  {
    return end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnd(Integer newEnd)
  {
    Integer oldEnd = end;
    end = newEnd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.RANGE__END, oldEnd, end));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getStep()
  {
    return step;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStep(int newStep)
  {
    int oldStep = step;
    step = newStep;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.RANGE__STEP, oldStep, step));
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
      case CitLPackage.RANGE__BEGIN:
        return getBegin();
      case CitLPackage.RANGE__END:
        return getEnd();
      case CitLPackage.RANGE__STEP:
        return getStep();
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
      case CitLPackage.RANGE__BEGIN:
        setBegin((Integer)newValue);
        return;
      case CitLPackage.RANGE__END:
        setEnd((Integer)newValue);
        return;
      case CitLPackage.RANGE__STEP:
        setStep((Integer)newValue);
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
      case CitLPackage.RANGE__BEGIN:
        setBegin(BEGIN_EDEFAULT);
        return;
      case CitLPackage.RANGE__END:
        setEnd(END_EDEFAULT);
        return;
      case CitLPackage.RANGE__STEP:
        setStep(STEP_EDEFAULT);
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
      case CitLPackage.RANGE__BEGIN:
        return BEGIN_EDEFAULT == null ? begin != null : !BEGIN_EDEFAULT.equals(begin);
      case CitLPackage.RANGE__END:
        return END_EDEFAULT == null ? end != null : !END_EDEFAULT.equals(end);
      case CitLPackage.RANGE__STEP:
        return step != STEP_EDEFAULT;
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
    result.append(" (begin: ");
    result.append(begin);
    result.append(", end: ");
    result.append(end);
    result.append(", step: ");
    result.append(step);
    result.append(')');
    return result.toString();
  }

} //RangeImpl
