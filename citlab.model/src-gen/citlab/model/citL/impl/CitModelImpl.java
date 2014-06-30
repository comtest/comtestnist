/**
 */
package citlab.model.citL.impl;

import citlab.model.citL.CitLPackage;
import citlab.model.citL.CitModel;
import citlab.model.citL.Constant;
import citlab.model.citL.NamedType;
import citlab.model.citL.Parameter;
import citlab.model.citL.Rule;
import citlab.model.citL.Seed;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cit Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link citlab.model.citL.impl.CitModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link citlab.model.citL.impl.CitModelImpl#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link citlab.model.citL.impl.CitModelImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link citlab.model.citL.impl.CitModelImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link citlab.model.citL.impl.CitModelImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link citlab.model.citL.impl.CitModelImpl#getSeeds <em>Seeds</em>}</li>
 *   <li>{@link citlab.model.citL.impl.CitModelImpl#getTestGoals <em>Test Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CitModelImpl extends MinimalEObjectImpl.Container implements CitModel
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getDefinitions() <em>Definitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinitions()
   * @generated
   * @ordered
   */
  protected EList<Constant> definitions;

  /**
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<NamedType> types;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<Parameter> parameters;

  /**
   * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected EList<Rule> constraints;

  /**
   * The cached value of the '{@link #getSeeds() <em>Seeds</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSeeds()
   * @generated
   * @ordered
   */
  protected EList<Seed> seeds;

  /**
   * The cached value of the '{@link #getTestGoals() <em>Test Goals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestGoals()
   * @generated
   * @ordered
   */
  protected EList<Rule> testGoals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CitModelImpl()
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
    return CitLPackage.Literals.CIT_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CitLPackage.CIT_MODEL__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Constant> getDefinitions()
  {
    if (definitions == null)
    {
      definitions = new EObjectContainmentEList<Constant>(Constant.class, this, CitLPackage.CIT_MODEL__DEFINITIONS);
    }
    return definitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NamedType> getTypes()
  {
    if (types == null)
    {
      types = new EObjectContainmentEList<NamedType>(NamedType.class, this, CitLPackage.CIT_MODEL__TYPES);
    }
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Parameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, CitLPackage.CIT_MODEL__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Rule> getConstraints()
  {
    if (constraints == null)
    {
      constraints = new EObjectContainmentEList<Rule>(Rule.class, this, CitLPackage.CIT_MODEL__CONSTRAINTS);
    }
    return constraints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Seed> getSeeds()
  {
    if (seeds == null)
    {
      seeds = new EObjectContainmentEList<Seed>(Seed.class, this, CitLPackage.CIT_MODEL__SEEDS);
    }
    return seeds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Rule> getTestGoals()
  {
    if (testGoals == null)
    {
      testGoals = new EObjectContainmentEList<Rule>(Rule.class, this, CitLPackage.CIT_MODEL__TEST_GOALS);
    }
    return testGoals;
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
      case CitLPackage.CIT_MODEL__DEFINITIONS:
        return ((InternalEList<?>)getDefinitions()).basicRemove(otherEnd, msgs);
      case CitLPackage.CIT_MODEL__TYPES:
        return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
      case CitLPackage.CIT_MODEL__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case CitLPackage.CIT_MODEL__CONSTRAINTS:
        return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
      case CitLPackage.CIT_MODEL__SEEDS:
        return ((InternalEList<?>)getSeeds()).basicRemove(otherEnd, msgs);
      case CitLPackage.CIT_MODEL__TEST_GOALS:
        return ((InternalEList<?>)getTestGoals()).basicRemove(otherEnd, msgs);
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
      case CitLPackage.CIT_MODEL__NAME:
        return getName();
      case CitLPackage.CIT_MODEL__DEFINITIONS:
        return getDefinitions();
      case CitLPackage.CIT_MODEL__TYPES:
        return getTypes();
      case CitLPackage.CIT_MODEL__PARAMETERS:
        return getParameters();
      case CitLPackage.CIT_MODEL__CONSTRAINTS:
        return getConstraints();
      case CitLPackage.CIT_MODEL__SEEDS:
        return getSeeds();
      case CitLPackage.CIT_MODEL__TEST_GOALS:
        return getTestGoals();
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
      case CitLPackage.CIT_MODEL__NAME:
        setName((String)newValue);
        return;
      case CitLPackage.CIT_MODEL__DEFINITIONS:
        getDefinitions().clear();
        getDefinitions().addAll((Collection<? extends Constant>)newValue);
        return;
      case CitLPackage.CIT_MODEL__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends NamedType>)newValue);
        return;
      case CitLPackage.CIT_MODEL__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Parameter>)newValue);
        return;
      case CitLPackage.CIT_MODEL__CONSTRAINTS:
        getConstraints().clear();
        getConstraints().addAll((Collection<? extends Rule>)newValue);
        return;
      case CitLPackage.CIT_MODEL__SEEDS:
        getSeeds().clear();
        getSeeds().addAll((Collection<? extends Seed>)newValue);
        return;
      case CitLPackage.CIT_MODEL__TEST_GOALS:
        getTestGoals().clear();
        getTestGoals().addAll((Collection<? extends Rule>)newValue);
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
      case CitLPackage.CIT_MODEL__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CitLPackage.CIT_MODEL__DEFINITIONS:
        getDefinitions().clear();
        return;
      case CitLPackage.CIT_MODEL__TYPES:
        getTypes().clear();
        return;
      case CitLPackage.CIT_MODEL__PARAMETERS:
        getParameters().clear();
        return;
      case CitLPackage.CIT_MODEL__CONSTRAINTS:
        getConstraints().clear();
        return;
      case CitLPackage.CIT_MODEL__SEEDS:
        getSeeds().clear();
        return;
      case CitLPackage.CIT_MODEL__TEST_GOALS:
        getTestGoals().clear();
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
      case CitLPackage.CIT_MODEL__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CitLPackage.CIT_MODEL__DEFINITIONS:
        return definitions != null && !definitions.isEmpty();
      case CitLPackage.CIT_MODEL__TYPES:
        return types != null && !types.isEmpty();
      case CitLPackage.CIT_MODEL__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case CitLPackage.CIT_MODEL__CONSTRAINTS:
        return constraints != null && !constraints.isEmpty();
      case CitLPackage.CIT_MODEL__SEEDS:
        return seeds != null && !seeds.isEmpty();
      case CitLPackage.CIT_MODEL__TEST_GOALS:
        return testGoals != null && !testGoals.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //CitModelImpl
