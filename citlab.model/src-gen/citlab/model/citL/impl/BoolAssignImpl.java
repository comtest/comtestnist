/**
 */
package citlab.model.citL.impl;

import citlab.model.citL.BoolAssign;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.CitLPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bool Assign</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link citlab.model.citL.impl.BoolAssignImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link citlab.model.citL.impl.BoolAssignImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoolAssignImpl extends AtomicPredicateImpl implements BoolAssign
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected citlab.model.citL.Boolean left;

  /**
   * The default value of the '{@link #getRight() <em>Right</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected static final BooleanConst RIGHT_EDEFAULT = BooleanConst.FALSE;

  /**
   * The cached value of the '{@link #getRight() <em>Right</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRight()
   * @generated
   * @ordered
   */
  protected BooleanConst right = RIGHT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BoolAssignImpl()
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
    return CitLPackage.Literals.BOOL_ASSIGN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public citlab.model.citL.Boolean getLeft()
  {
    if (left != null && left.eIsProxy())
    {
      InternalEObject oldLeft = (InternalEObject)left;
      left = (citlab.model.citL.Boolean)eResolveProxy(oldLeft);
      if (left != oldLeft)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CitLPackage.BOOL_ASSIGN__LEFT, oldLeft, left));
      }
    }
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public citlab.model.citL.Boolean basicGetLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeft(citlab.model.citL.Boolean newLeft)
  {
    citlab.model.citL.Boolean oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.BOOL_ASSIGN__LEFT, oldLeft, left));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanConst getRight()
  {
    return right;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRight(BooleanConst newRight)
  {
    BooleanConst oldRight = right;
    right = newRight == null ? RIGHT_EDEFAULT : newRight;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.BOOL_ASSIGN__RIGHT, oldRight, right));
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
      case CitLPackage.BOOL_ASSIGN__LEFT:
        if (resolve) return getLeft();
        return basicGetLeft();
      case CitLPackage.BOOL_ASSIGN__RIGHT:
        return getRight();
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
      case CitLPackage.BOOL_ASSIGN__LEFT:
        setLeft((citlab.model.citL.Boolean)newValue);
        return;
      case CitLPackage.BOOL_ASSIGN__RIGHT:
        setRight((BooleanConst)newValue);
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
      case CitLPackage.BOOL_ASSIGN__LEFT:
        setLeft((citlab.model.citL.Boolean)null);
        return;
      case CitLPackage.BOOL_ASSIGN__RIGHT:
        setRight(RIGHT_EDEFAULT);
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
      case CitLPackage.BOOL_ASSIGN__LEFT:
        return left != null;
      case CitLPackage.BOOL_ASSIGN__RIGHT:
        return right != RIGHT_EDEFAULT;
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
    result.append(" (right: ");
    result.append(right);
    result.append(')');
    return result.toString();
  }

} //BoolAssignImpl
