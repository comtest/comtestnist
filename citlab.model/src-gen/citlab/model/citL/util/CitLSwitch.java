/**
 */
package citlab.model.citL.util;

import citlab.model.citL.AndExpression;
import citlab.model.citL.AnonymousType;
import citlab.model.citL.Aseed;
import citlab.model.citL.AtomicPredicate;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.BoolAssignSeed;
import citlab.model.citL.CitLPackage;
import citlab.model.citL.CitModel;
import citlab.model.citL.Constant;
import citlab.model.citL.ConstantNumber;
import citlab.model.citL.Element;
import citlab.model.citL.EnumAssign;
import citlab.model.citL.EnumSeed;
import citlab.model.citL.Enumerative;
import citlab.model.citL.EnumerativeType;
import citlab.model.citL.Expression;
import citlab.model.citL.ImpliesExpression;
import citlab.model.citL.ModMultDiv;
import citlab.model.citL.NamedType;
import citlab.model.citL.NotExpression;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.Numbers;
import citlab.model.citL.Numerical;
import citlab.model.citL.NumericalEx;
import citlab.model.citL.NumericalSeed;
import citlab.model.citL.OrExpression;
import citlab.model.citL.Parameter;
import citlab.model.citL.ParametersEx;
import citlab.model.citL.PlusMinus;
import citlab.model.citL.Range;
import citlab.model.citL.RelationalExpression;
import citlab.model.citL.Rule;
import citlab.model.citL.Seed;
import citlab.model.citL.SeedNumberLiteral;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see citlab.model.citL.CitLPackage
 * @generated
 */
public class CitLSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CitLPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CitLSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = CitLPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case CitLPackage.CIT_MODEL:
      {
        CitModel citModel = (CitModel)theEObject;
        T result = caseCitModel(citModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.CONSTANT:
      {
        Constant constant = (Constant)theEObject;
        T result = caseConstant(constant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.CONSTANT_NUMBER:
      {
        ConstantNumber constantNumber = (ConstantNumber)theEObject;
        T result = caseConstantNumber(constantNumber);
        if (result == null) result = caseConstant(constantNumber);
        if (result == null) result = caseNumericalEx(constantNumber);
        if (result == null) result = caseParametersEx(constantNumber);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.PARAMETER:
      {
        Parameter parameter = (Parameter)theEObject;
        T result = caseParameter(parameter);
        if (result == null) result = caseParametersEx(parameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.PARAMETERS_EX:
      {
        ParametersEx parametersEx = (ParametersEx)theEObject;
        T result = caseParametersEx(parametersEx);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.NUMERICAL_EX:
      {
        NumericalEx numericalEx = (NumericalEx)theEObject;
        T result = caseNumericalEx(numericalEx);
        if (result == null) result = caseParametersEx(numericalEx);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.NUMERICAL:
      {
        Numerical numerical = (Numerical)theEObject;
        T result = caseNumerical(numerical);
        if (result == null) result = caseParameter(numerical);
        if (result == null) result = caseNumericalEx(numerical);
        if (result == null) result = caseParametersEx(numerical);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.ENUMERATIVE_TYPE:
      {
        EnumerativeType enumerativeType = (EnumerativeType)theEObject;
        T result = caseEnumerativeType(enumerativeType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.NAMED_TYPE:
      {
        NamedType namedType = (NamedType)theEObject;
        T result = caseNamedType(namedType);
        if (result == null) result = caseEnumerativeType(namedType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.ANONYMOUS_TYPE:
      {
        AnonymousType anonymousType = (AnonymousType)theEObject;
        T result = caseAnonymousType(anonymousType);
        if (result == null) result = caseEnumerativeType(anonymousType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.ENUMERATIVE:
      {
        Enumerative enumerative = (Enumerative)theEObject;
        T result = caseEnumerative(enumerative);
        if (result == null) result = caseParameter(enumerative);
        if (result == null) result = caseParametersEx(enumerative);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.ELEMENT:
      {
        Element element = (Element)theEObject;
        T result = caseElement(element);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.BOOLEAN:
      {
        citlab.model.citL.Boolean boolean_ = (citlab.model.citL.Boolean)theEObject;
        T result = caseBoolean(boolean_);
        if (result == null) result = caseParameter(boolean_);
        if (result == null) result = caseParametersEx(boolean_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.NUMBERS:
      {
        Numbers numbers = (Numbers)theEObject;
        T result = caseNumbers(numbers);
        if (result == null) result = caseNumerical(numbers);
        if (result == null) result = caseParameter(numbers);
        if (result == null) result = caseNumericalEx(numbers);
        if (result == null) result = caseParametersEx(numbers);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.RANGE:
      {
        Range range = (Range)theEObject;
        T result = caseRange(range);
        if (result == null) result = caseNumerical(range);
        if (result == null) result = caseParameter(range);
        if (result == null) result = caseNumericalEx(range);
        if (result == null) result = caseParametersEx(range);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.RULE:
      {
        Rule rule = (Rule)theEObject;
        T result = caseRule(rule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseRule(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.ATOMIC_PREDICATE:
      {
        AtomicPredicate atomicPredicate = (AtomicPredicate)theEObject;
        T result = caseAtomicPredicate(atomicPredicate);
        if (result == null) result = caseExpression(atomicPredicate);
        if (result == null) result = caseRule(atomicPredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.BOOL_ASSIGN:
      {
        BoolAssign boolAssign = (BoolAssign)theEObject;
        T result = caseBoolAssign(boolAssign);
        if (result == null) result = caseAtomicPredicate(boolAssign);
        if (result == null) result = caseExpression(boolAssign);
        if (result == null) result = caseRule(boolAssign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.ENUM_ASSIGN:
      {
        EnumAssign enumAssign = (EnumAssign)theEObject;
        T result = caseEnumAssign(enumAssign);
        if (result == null) result = caseAtomicPredicate(enumAssign);
        if (result == null) result = caseExpression(enumAssign);
        if (result == null) result = caseRule(enumAssign);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.RELATIONAL_EXPRESSION:
      {
        RelationalExpression relationalExpression = (RelationalExpression)theEObject;
        T result = caseRelationalExpression(relationalExpression);
        if (result == null) result = caseAtomicPredicate(relationalExpression);
        if (result == null) result = caseExpression(relationalExpression);
        if (result == null) result = caseRule(relationalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.NUMBER_LITERAL:
      {
        NumberLiteral numberLiteral = (NumberLiteral)theEObject;
        T result = caseNumberLiteral(numberLiteral);
        if (result == null) result = caseExpression(numberLiteral);
        if (result == null) result = caseRule(numberLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.SEED:
      {
        Seed seed = (Seed)theEObject;
        T result = caseSeed(seed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.ASEED:
      {
        Aseed aseed = (Aseed)theEObject;
        T result = caseAseed(aseed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.SEED_NUMBER_LITERAL:
      {
        SeedNumberLiteral seedNumberLiteral = (SeedNumberLiteral)theEObject;
        T result = caseSeedNumberLiteral(seedNumberLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.ENUM_SEED:
      {
        EnumSeed enumSeed = (EnumSeed)theEObject;
        T result = caseEnumSeed(enumSeed);
        if (result == null) result = caseAseed(enumSeed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.NUMERICAL_SEED:
      {
        NumericalSeed numericalSeed = (NumericalSeed)theEObject;
        T result = caseNumericalSeed(numericalSeed);
        if (result == null) result = caseAseed(numericalSeed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.BOOL_ASSIGN_SEED:
      {
        BoolAssignSeed boolAssignSeed = (BoolAssignSeed)theEObject;
        T result = caseBoolAssignSeed(boolAssignSeed);
        if (result == null) result = caseAseed(boolAssignSeed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.OR_EXPRESSION:
      {
        OrExpression orExpression = (OrExpression)theEObject;
        T result = caseOrExpression(orExpression);
        if (result == null) result = caseExpression(orExpression);
        if (result == null) result = caseRule(orExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.AND_EXPRESSION:
      {
        AndExpression andExpression = (AndExpression)theEObject;
        T result = caseAndExpression(andExpression);
        if (result == null) result = caseExpression(andExpression);
        if (result == null) result = caseRule(andExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.IMPLIES_EXPRESSION:
      {
        ImpliesExpression impliesExpression = (ImpliesExpression)theEObject;
        T result = caseImpliesExpression(impliesExpression);
        if (result == null) result = caseExpression(impliesExpression);
        if (result == null) result = caseRule(impliesExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.NOT_EXPRESSION:
      {
        NotExpression notExpression = (NotExpression)theEObject;
        T result = caseNotExpression(notExpression);
        if (result == null) result = caseExpression(notExpression);
        if (result == null) result = caseRule(notExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.PLUS_MINUS:
      {
        PlusMinus plusMinus = (PlusMinus)theEObject;
        T result = casePlusMinus(plusMinus);
        if (result == null) result = caseExpression(plusMinus);
        if (result == null) result = caseRule(plusMinus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CitLPackage.MOD_MULT_DIV:
      {
        ModMultDiv modMultDiv = (ModMultDiv)theEObject;
        T result = caseModMultDiv(modMultDiv);
        if (result == null) result = caseExpression(modMultDiv);
        if (result == null) result = caseRule(modMultDiv);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cit Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cit Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCitModel(CitModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstant(Constant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant Number</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant Number</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantNumber(ConstantNumber object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameter(Parameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameters Ex</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameters Ex</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParametersEx(ParametersEx object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numerical Ex</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numerical Ex</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericalEx(NumericalEx object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numerical</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numerical</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumerical(Numerical object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumerative Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumerative Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerativeType(EnumerativeType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedType(NamedType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymousType(AnonymousType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumerative</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumerative</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerative(Enumerative object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolean(citlab.model.citL.Boolean object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numbers</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numbers</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumbers(Numbers object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRange(Range object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRule(Rule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Atomic Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atomic Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtomicPredicate(AtomicPredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool Assign</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool Assign</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolAssign(BoolAssign object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Assign</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Assign</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumAssign(EnumAssign object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationalExpression(RelationalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberLiteral(NumberLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Seed</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Seed</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSeed(Seed object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Aseed</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Aseed</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAseed(Aseed object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Seed Number Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Seed Number Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSeedNumberLiteral(SeedNumberLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Seed</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Seed</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumSeed(EnumSeed object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numerical Seed</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numerical Seed</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericalSeed(NumericalSeed object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool Assign Seed</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool Assign Seed</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolAssignSeed(BoolAssignSeed object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrExpression(OrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndExpression(AndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implies Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implies Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImpliesExpression(ImpliesExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Not Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Not Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNotExpression(NotExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Plus Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Plus Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePlusMinus(PlusMinus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mod Mult Div</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mod Mult Div</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModMultDiv(ModMultDiv object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //CitLSwitch
