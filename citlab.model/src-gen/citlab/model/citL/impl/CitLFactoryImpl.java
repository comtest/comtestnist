/**
 */
package citlab.model.citL.impl;

import citlab.model.citL.AndExpression;
import citlab.model.citL.AndOperators;
import citlab.model.citL.AnonymousType;
import citlab.model.citL.Aseed;
import citlab.model.citL.AtomicPredicate;
import citlab.model.citL.BoolAssign;
import citlab.model.citL.BoolAssignSeed;
import citlab.model.citL.BooleanConst;
import citlab.model.citL.CitLFactory;
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
import citlab.model.citL.ImpliesOperator;
import citlab.model.citL.ModMultDiv;
import citlab.model.citL.ModMultDivOperators;
import citlab.model.citL.NamedType;
import citlab.model.citL.NotExpression;
import citlab.model.citL.NumberLiteral;
import citlab.model.citL.Numbers;
import citlab.model.citL.Numerical;
import citlab.model.citL.NumericalEx;
import citlab.model.citL.NumericalSeed;
import citlab.model.citL.Operators;
import citlab.model.citL.OrExpression;
import citlab.model.citL.OrOperators;
import citlab.model.citL.Parameter;
import citlab.model.citL.ParametersEx;
import citlab.model.citL.PlusMinus;
import citlab.model.citL.PlusMinusOperators;
import citlab.model.citL.Range;
import citlab.model.citL.RelationalExpression;
import citlab.model.citL.Rule;
import citlab.model.citL.Seed;
import citlab.model.citL.SeedNumberLiteral;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CitLFactoryImpl extends EFactoryImpl implements CitLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CitLFactory init()
  {
    try
    {
      CitLFactory theCitLFactory = (CitLFactory)EPackage.Registry.INSTANCE.getEFactory(CitLPackage.eNS_URI);
      if (theCitLFactory != null)
      {
        return theCitLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CitLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CitLFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case CitLPackage.CIT_MODEL: return createCitModel();
      case CitLPackage.CONSTANT: return createConstant();
      case CitLPackage.CONSTANT_NUMBER: return createConstantNumber();
      case CitLPackage.PARAMETER: return createParameter();
      case CitLPackage.PARAMETERS_EX: return createParametersEx();
      case CitLPackage.NUMERICAL_EX: return createNumericalEx();
      case CitLPackage.NUMERICAL: return createNumerical();
      case CitLPackage.ENUMERATIVE_TYPE: return createEnumerativeType();
      case CitLPackage.NAMED_TYPE: return createNamedType();
      case CitLPackage.ANONYMOUS_TYPE: return createAnonymousType();
      case CitLPackage.ENUMERATIVE: return createEnumerative();
      case CitLPackage.ELEMENT: return createElement();
      case CitLPackage.BOOLEAN: return createBoolean();
      case CitLPackage.NUMBERS: return createNumbers();
      case CitLPackage.RANGE: return createRange();
      case CitLPackage.RULE: return createRule();
      case CitLPackage.EXPRESSION: return createExpression();
      case CitLPackage.ATOMIC_PREDICATE: return createAtomicPredicate();
      case CitLPackage.BOOL_ASSIGN: return createBoolAssign();
      case CitLPackage.ENUM_ASSIGN: return createEnumAssign();
      case CitLPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case CitLPackage.NUMBER_LITERAL: return createNumberLiteral();
      case CitLPackage.SEED: return createSeed();
      case CitLPackage.ASEED: return createAseed();
      case CitLPackage.SEED_NUMBER_LITERAL: return createSeedNumberLiteral();
      case CitLPackage.ENUM_SEED: return createEnumSeed();
      case CitLPackage.NUMERICAL_SEED: return createNumericalSeed();
      case CitLPackage.BOOL_ASSIGN_SEED: return createBoolAssignSeed();
      case CitLPackage.OR_EXPRESSION: return createOrExpression();
      case CitLPackage.AND_EXPRESSION: return createAndExpression();
      case CitLPackage.IMPLIES_EXPRESSION: return createImpliesExpression();
      case CitLPackage.NOT_EXPRESSION: return createNotExpression();
      case CitLPackage.PLUS_MINUS: return createPlusMinus();
      case CitLPackage.MOD_MULT_DIV: return createModMultDiv();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case CitLPackage.OPERATORS:
        return createOperatorsFromString(eDataType, initialValue);
      case CitLPackage.AND_OPERATORS:
        return createAndOperatorsFromString(eDataType, initialValue);
      case CitLPackage.OR_OPERATORS:
        return createOrOperatorsFromString(eDataType, initialValue);
      case CitLPackage.PLUS_MINUS_OPERATORS:
        return createPlusMinusOperatorsFromString(eDataType, initialValue);
      case CitLPackage.MOD_MULT_DIV_OPERATORS:
        return createModMultDivOperatorsFromString(eDataType, initialValue);
      case CitLPackage.IMPLIES_OPERATOR:
        return createImpliesOperatorFromString(eDataType, initialValue);
      case CitLPackage.BOOLEAN_CONST:
        return createBooleanConstFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case CitLPackage.OPERATORS:
        return convertOperatorsToString(eDataType, instanceValue);
      case CitLPackage.AND_OPERATORS:
        return convertAndOperatorsToString(eDataType, instanceValue);
      case CitLPackage.OR_OPERATORS:
        return convertOrOperatorsToString(eDataType, instanceValue);
      case CitLPackage.PLUS_MINUS_OPERATORS:
        return convertPlusMinusOperatorsToString(eDataType, instanceValue);
      case CitLPackage.MOD_MULT_DIV_OPERATORS:
        return convertModMultDivOperatorsToString(eDataType, instanceValue);
      case CitLPackage.IMPLIES_OPERATOR:
        return convertImpliesOperatorToString(eDataType, instanceValue);
      case CitLPackage.BOOLEAN_CONST:
        return convertBooleanConstToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CitModel createCitModel()
  {
    CitModelImpl citModel = new CitModelImpl();
    return citModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constant createConstant()
  {
    ConstantImpl constant = new ConstantImpl();
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantNumber createConstantNumber()
  {
    ConstantNumberImpl constantNumber = new ConstantNumberImpl();
    return constantNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParametersEx createParametersEx()
  {
    ParametersExImpl parametersEx = new ParametersExImpl();
    return parametersEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericalEx createNumericalEx()
  {
    NumericalExImpl numericalEx = new NumericalExImpl();
    return numericalEx;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Numerical createNumerical()
  {
    NumericalImpl numerical = new NumericalImpl();
    return numerical;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerativeType createEnumerativeType()
  {
    EnumerativeTypeImpl enumerativeType = new EnumerativeTypeImpl();
    return enumerativeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedType createNamedType()
  {
    NamedTypeImpl namedType = new NamedTypeImpl();
    return namedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnonymousType createAnonymousType()
  {
    AnonymousTypeImpl anonymousType = new AnonymousTypeImpl();
    return anonymousType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Enumerative createEnumerative()
  {
    EnumerativeImpl enumerative = new EnumerativeImpl();
    return enumerative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element createElement()
  {
    ElementImpl element = new ElementImpl();
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public citlab.model.citL.Boolean createBoolean()
  {
    BooleanImpl boolean_ = new BooleanImpl();
    return boolean_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Numbers createNumbers()
  {
    NumbersImpl numbers = new NumbersImpl();
    return numbers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Range createRange()
  {
    RangeImpl range = new RangeImpl();
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule createRule()
  {
    RuleImpl rule = new RuleImpl();
    return rule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtomicPredicate createAtomicPredicate()
  {
    AtomicPredicateImpl atomicPredicate = new AtomicPredicateImpl();
    return atomicPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolAssign createBoolAssign()
  {
    BoolAssignImpl boolAssign = new BoolAssignImpl();
    return boolAssign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumAssign createEnumAssign()
  {
    EnumAssignImpl enumAssign = new EnumAssignImpl();
    return enumAssign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberLiteral createNumberLiteral()
  {
    NumberLiteralImpl numberLiteral = new NumberLiteralImpl();
    return numberLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Seed createSeed()
  {
    SeedImpl seed = new SeedImpl();
    return seed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Aseed createAseed()
  {
    AseedImpl aseed = new AseedImpl();
    return aseed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SeedNumberLiteral createSeedNumberLiteral()
  {
    SeedNumberLiteralImpl seedNumberLiteral = new SeedNumberLiteralImpl();
    return seedNumberLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumSeed createEnumSeed()
  {
    EnumSeedImpl enumSeed = new EnumSeedImpl();
    return enumSeed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericalSeed createNumericalSeed()
  {
    NumericalSeedImpl numericalSeed = new NumericalSeedImpl();
    return numericalSeed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolAssignSeed createBoolAssignSeed()
  {
    BoolAssignSeedImpl boolAssignSeed = new BoolAssignSeedImpl();
    return boolAssignSeed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrExpression createOrExpression()
  {
    OrExpressionImpl orExpression = new OrExpressionImpl();
    return orExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpression createAndExpression()
  {
    AndExpressionImpl andExpression = new AndExpressionImpl();
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImpliesExpression createImpliesExpression()
  {
    ImpliesExpressionImpl impliesExpression = new ImpliesExpressionImpl();
    return impliesExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotExpression createNotExpression()
  {
    NotExpressionImpl notExpression = new NotExpressionImpl();
    return notExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PlusMinus createPlusMinus()
  {
    PlusMinusImpl plusMinus = new PlusMinusImpl();
    return plusMinus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModMultDiv createModMultDiv()
  {
    ModMultDivImpl modMultDiv = new ModMultDivImpl();
    return modMultDiv;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operators createOperatorsFromString(EDataType eDataType, String initialValue)
  {
    Operators result = Operators.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOperatorsToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndOperators createAndOperatorsFromString(EDataType eDataType, String initialValue)
  {
    AndOperators result = AndOperators.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAndOperatorsToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrOperators createOrOperatorsFromString(EDataType eDataType, String initialValue)
  {
    OrOperators result = OrOperators.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOrOperatorsToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PlusMinusOperators createPlusMinusOperatorsFromString(EDataType eDataType, String initialValue)
  {
    PlusMinusOperators result = PlusMinusOperators.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPlusMinusOperatorsToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModMultDivOperators createModMultDivOperatorsFromString(EDataType eDataType, String initialValue)
  {
    ModMultDivOperators result = ModMultDivOperators.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertModMultDivOperatorsToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImpliesOperator createImpliesOperatorFromString(EDataType eDataType, String initialValue)
  {
    ImpliesOperator result = ImpliesOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImpliesOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanConst createBooleanConstFromString(EDataType eDataType, String initialValue)
  {
    BooleanConst result = BooleanConst.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBooleanConstToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CitLPackage getCitLPackage()
  {
    return (CitLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CitLPackage getPackage()
  {
    return CitLPackage.eINSTANCE;
  }

} //CitLFactoryImpl
