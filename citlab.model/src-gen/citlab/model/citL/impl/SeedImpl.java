/**
 */
package citlab.model.citL.impl;

import citlab.model.citL.Aseed;
import citlab.model.citL.CitLPackage;
import citlab.model.citL.Seed;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Seed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link citlab.model.citL.impl.SeedImpl#getAssigmentSeedList <em>Assigment Seed List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeedImpl extends MinimalEObjectImpl.Container implements Seed
{
  /**
   * The cached value of the '{@link #getAssigmentSeedList() <em>Assigment Seed List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssigmentSeedList()
   * @generated
   * @ordered
   */
  protected EList<Aseed> assigmentSeedList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SeedImpl()
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
    return CitLPackage.Literals.SEED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Aseed> getAssigmentSeedList()
  {
    if (assigmentSeedList == null)
    {
      assigmentSeedList = new EObjectContainmentEList<Aseed>(Aseed.class, this, CitLPackage.SEED__ASSIGMENT_SEED_LIST);
    }
    return assigmentSeedList;
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
      case CitLPackage.SEED__ASSIGMENT_SEED_LIST:
        return ((InternalEList<?>)getAssigmentSeedList()).basicRemove(otherEnd, msgs);
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
      case CitLPackage.SEED__ASSIGMENT_SEED_LIST:
        return getAssigmentSeedList();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CitLPackage.SEED__ASSIGMENT_SEED_LIST:
        getAssigmentSeedList().clear();
        getAssigmentSeedList().addAll((Collection<? extends Aseed>)newValue);
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
      case CitLPackage.SEED__ASSIGMENT_SEED_LIST:
        getAssigmentSeedList().clear();
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
      case CitLPackage.SEED__ASSIGMENT_SEED_LIST:
        return assigmentSeedList != null && !assigmentSeedList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SeedImpl
