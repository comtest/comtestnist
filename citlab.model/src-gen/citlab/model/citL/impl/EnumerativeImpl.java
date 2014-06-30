/**
 */
package citlab.model.citL.impl;

import citlab.model.citL.AnonymousType;
import citlab.model.citL.CitLPackage;
import citlab.model.citL.Enumerative;
import citlab.model.citL.NamedType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumerative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link citlab.model.citL.impl.EnumerativeImpl#getNamedType <em>Named Type</em>}</li>
 *   <li>{@link citlab.model.citL.impl.EnumerativeImpl#getAtype <em>Atype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerativeImpl extends ParameterImpl implements Enumerative
{
  /**
   * The cached value of the '{@link #getNamedType() <em>Named Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNamedType()
   * @generated
   * @ordered
   */
  protected NamedType namedType;

  /**
   * The cached value of the '{@link #getAtype() <em>Atype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAtype()
   * @generated
   * @ordered
   */
  protected AnonymousType atype;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumerativeImpl()
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
    return CitLPackage.Literals.ENUMERATIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedType getNamedType()
  {
    if (namedType != null && namedType.eIsProxy())
    {
      InternalEObject oldNamedType = (InternalEObject)namedType;
      namedType = (NamedType)eResolveProxy(oldNamedType);
      if (namedType != oldNamedType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CitLPackage.ENUMERATIVE__NAMED_TYPE, oldNamedType, namedType));
      }
    }
    return namedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedType basicGetNamedType()
  {
    return namedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNamedType(NamedType newNamedType)
  {
    NamedType oldNamedType = namedType;
    namedType = newNamedType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.ENUMERATIVE__NAMED_TYPE, oldNamedType, namedType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnonymousType getAtype()
  {
    return atype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAtype(AnonymousType newAtype, NotificationChain msgs)
  {
    AnonymousType oldAtype = atype;
    atype = newAtype;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CitLPackage.ENUMERATIVE__ATYPE, oldAtype, newAtype);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAtype(AnonymousType newAtype)
  {
    if (newAtype != atype)
    {
      NotificationChain msgs = null;
      if (atype != null)
        msgs = ((InternalEObject)atype).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CitLPackage.ENUMERATIVE__ATYPE, null, msgs);
      if (newAtype != null)
        msgs = ((InternalEObject)newAtype).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CitLPackage.ENUMERATIVE__ATYPE, null, msgs);
      msgs = basicSetAtype(newAtype, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.ENUMERATIVE__ATYPE, newAtype, newAtype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CitLPackage.ENUMERATIVE__ATYPE:
        return basicSetAtype(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case CitLPackage.ENUMERATIVE__NAMED_TYPE:
        if (resolve) return getNamedType();
        return basicGetNamedType();
      case CitLPackage.ENUMERATIVE__ATYPE:
        return getAtype();
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
      case CitLPackage.ENUMERATIVE__NAMED_TYPE:
        setNamedType((NamedType)newValue);
        return;
      case CitLPackage.ENUMERATIVE__ATYPE:
        setAtype((AnonymousType)newValue);
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
      case CitLPackage.ENUMERATIVE__NAMED_TYPE:
        setNamedType((NamedType)null);
        return;
      case CitLPackage.ENUMERATIVE__ATYPE:
        setAtype((AnonymousType)null);
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
      case CitLPackage.ENUMERATIVE__NAMED_TYPE:
        return namedType != null;
      case CitLPackage.ENUMERATIVE__ATYPE:
        return atype != null;
    }
    return super.eIsSet(featureID);
  }

} //EnumerativeImpl
