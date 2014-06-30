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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CitLPackageImpl extends EPackageImpl implements CitLPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass citModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantNumberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parametersExEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericalExEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerativeTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymousTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerativeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numbersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rangeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomicPredicateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass boolAssignEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumAssignEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numberLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass seedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aseedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass seedNumberLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumSeedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericalSeedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass boolAssignSeedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass impliesExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass notExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plusMinusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modMultDivEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum operatorsEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum andOperatorsEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum orOperatorsEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum plusMinusOperatorsEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum modMultDivOperatorsEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum impliesOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum booleanConstEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see citlab.model.citL.CitLPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CitLPackageImpl()
  {
    super(eNS_URI, CitLFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link CitLPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static CitLPackage init()
  {
    if (isInited) return (CitLPackage)EPackage.Registry.INSTANCE.getEPackage(CitLPackage.eNS_URI);

    // Obtain or create and register package
    CitLPackageImpl theCitLPackage = (CitLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CitLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CitLPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theCitLPackage.createPackageContents();

    // Initialize created meta-data
    theCitLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCitLPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CitLPackage.eNS_URI, theCitLPackage);
    return theCitLPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCitModel()
  {
    return citModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCitModel_Name()
  {
    return (EAttribute)citModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCitModel_Definitions()
  {
    return (EReference)citModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCitModel_Types()
  {
    return (EReference)citModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCitModel_Parameters()
  {
    return (EReference)citModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCitModel_Constraints()
  {
    return (EReference)citModelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCitModel_Seeds()
  {
    return (EReference)citModelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCitModel_TestGoals()
  {
    return (EReference)citModelEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstant()
  {
    return constantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantNumber()
  {
    return constantNumberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstantNumber_Value()
  {
    return (EAttribute)constantNumberEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameter()
  {
    return parameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParametersEx()
  {
    return parametersExEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParametersEx_Name()
  {
    return (EAttribute)parametersExEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericalEx()
  {
    return numericalExEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumerical()
  {
    return numericalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerativeType()
  {
    return enumerativeTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerativeType_Elements()
  {
    return (EReference)enumerativeTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedType()
  {
    return namedTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedType_Name()
  {
    return (EAttribute)namedTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymousType()
  {
    return anonymousTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerative()
  {
    return enumerativeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerative_NamedType()
  {
    return (EReference)enumerativeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerative_Atype()
  {
    return (EReference)enumerativeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElement()
  {
    return elementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getElement_Name()
  {
    return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBoolean()
  {
    return booleanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumbers()
  {
    return numbersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumbers_Values()
  {
    return (EAttribute)numbersEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRange()
  {
    return rangeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRange_Begin()
  {
    return (EAttribute)rangeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRange_End()
  {
    return (EAttribute)rangeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRange_Step()
  {
    return (EAttribute)rangeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRule()
  {
    return ruleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtomicPredicate()
  {
    return atomicPredicateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAtomicPredicate_Op()
  {
    return (EAttribute)atomicPredicateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBoolAssign()
  {
    return boolAssignEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBoolAssign_Left()
  {
    return (EReference)boolAssignEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBoolAssign_Right()
  {
    return (EAttribute)boolAssignEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumAssign()
  {
    return enumAssignEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumAssign_Left()
  {
    return (EReference)enumAssignEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumAssign_Right()
  {
    return (EReference)enumAssignEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationalExpression()
  {
    return relationalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Left()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Right()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumberLiteral()
  {
    return numberLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumberLiteral_Number()
  {
    return (EAttribute)numberLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumberLiteral_Numerical()
  {
    return (EReference)numberLiteralEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSeed()
  {
    return seedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSeed_AssigmentSeedList()
  {
    return (EReference)seedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAseed()
  {
    return aseedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAseed_Op()
  {
    return (EAttribute)aseedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSeedNumberLiteral()
  {
    return seedNumberLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSeedNumberLiteral_Number()
  {
    return (EAttribute)seedNumberLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSeedNumberLiteral_Constant()
  {
    return (EReference)seedNumberLiteralEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumSeed()
  {
    return enumSeedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumSeed_Left()
  {
    return (EReference)enumSeedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumSeed_Right()
  {
    return (EReference)enumSeedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericalSeed()
  {
    return numericalSeedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalSeed_Left()
  {
    return (EReference)numericalSeedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalSeed_Right()
  {
    return (EReference)numericalSeedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBoolAssignSeed()
  {
    return boolAssignSeedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBoolAssignSeed_Left()
  {
    return (EReference)boolAssignSeedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBoolAssignSeed_Right()
  {
    return (EAttribute)boolAssignSeedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrExpression()
  {
    return orExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Left()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOrExpression_Op()
  {
    return (EAttribute)orExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Right()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpression()
  {
    return andExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Left()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAndExpression_Op()
  {
    return (EAttribute)andExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Right()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImpliesExpression()
  {
    return impliesExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImpliesExpression_Left()
  {
    return (EReference)impliesExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImpliesExpression_Op()
  {
    return (EAttribute)impliesExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImpliesExpression_Right()
  {
    return (EReference)impliesExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNotExpression()
  {
    return notExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNotExpression_Predicate()
  {
    return (EReference)notExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPlusMinus()
  {
    return plusMinusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPlusMinus_Left()
  {
    return (EReference)plusMinusEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPlusMinus_Op()
  {
    return (EAttribute)plusMinusEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPlusMinus_Right()
  {
    return (EReference)plusMinusEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModMultDiv()
  {
    return modMultDivEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModMultDiv_Left()
  {
    return (EReference)modMultDivEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModMultDiv_Op()
  {
    return (EAttribute)modMultDivEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModMultDiv_Right()
  {
    return (EReference)modMultDivEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOperators()
  {
    return operatorsEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAndOperators()
  {
    return andOperatorsEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOrOperators()
  {
    return orOperatorsEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getPlusMinusOperators()
  {
    return plusMinusOperatorsEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getModMultDivOperators()
  {
    return modMultDivOperatorsEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getImpliesOperator()
  {
    return impliesOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getBooleanConst()
  {
    return booleanConstEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CitLFactory getCitLFactory()
  {
    return (CitLFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    citModelEClass = createEClass(CIT_MODEL);
    createEAttribute(citModelEClass, CIT_MODEL__NAME);
    createEReference(citModelEClass, CIT_MODEL__DEFINITIONS);
    createEReference(citModelEClass, CIT_MODEL__TYPES);
    createEReference(citModelEClass, CIT_MODEL__PARAMETERS);
    createEReference(citModelEClass, CIT_MODEL__CONSTRAINTS);
    createEReference(citModelEClass, CIT_MODEL__SEEDS);
    createEReference(citModelEClass, CIT_MODEL__TEST_GOALS);

    constantEClass = createEClass(CONSTANT);

    constantNumberEClass = createEClass(CONSTANT_NUMBER);
    createEAttribute(constantNumberEClass, CONSTANT_NUMBER__VALUE);

    parameterEClass = createEClass(PARAMETER);

    parametersExEClass = createEClass(PARAMETERS_EX);
    createEAttribute(parametersExEClass, PARAMETERS_EX__NAME);

    numericalExEClass = createEClass(NUMERICAL_EX);

    numericalEClass = createEClass(NUMERICAL);

    enumerativeTypeEClass = createEClass(ENUMERATIVE_TYPE);
    createEReference(enumerativeTypeEClass, ENUMERATIVE_TYPE__ELEMENTS);

    namedTypeEClass = createEClass(NAMED_TYPE);
    createEAttribute(namedTypeEClass, NAMED_TYPE__NAME);

    anonymousTypeEClass = createEClass(ANONYMOUS_TYPE);

    enumerativeEClass = createEClass(ENUMERATIVE);
    createEReference(enumerativeEClass, ENUMERATIVE__NAMED_TYPE);
    createEReference(enumerativeEClass, ENUMERATIVE__ATYPE);

    elementEClass = createEClass(ELEMENT);
    createEAttribute(elementEClass, ELEMENT__NAME);

    booleanEClass = createEClass(BOOLEAN);

    numbersEClass = createEClass(NUMBERS);
    createEAttribute(numbersEClass, NUMBERS__VALUES);

    rangeEClass = createEClass(RANGE);
    createEAttribute(rangeEClass, RANGE__BEGIN);
    createEAttribute(rangeEClass, RANGE__END);
    createEAttribute(rangeEClass, RANGE__STEP);

    ruleEClass = createEClass(RULE);

    expressionEClass = createEClass(EXPRESSION);

    atomicPredicateEClass = createEClass(ATOMIC_PREDICATE);
    createEAttribute(atomicPredicateEClass, ATOMIC_PREDICATE__OP);

    boolAssignEClass = createEClass(BOOL_ASSIGN);
    createEReference(boolAssignEClass, BOOL_ASSIGN__LEFT);
    createEAttribute(boolAssignEClass, BOOL_ASSIGN__RIGHT);

    enumAssignEClass = createEClass(ENUM_ASSIGN);
    createEReference(enumAssignEClass, ENUM_ASSIGN__LEFT);
    createEReference(enumAssignEClass, ENUM_ASSIGN__RIGHT);

    relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__LEFT);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__RIGHT);

    numberLiteralEClass = createEClass(NUMBER_LITERAL);
    createEAttribute(numberLiteralEClass, NUMBER_LITERAL__NUMBER);
    createEReference(numberLiteralEClass, NUMBER_LITERAL__NUMERICAL);

    seedEClass = createEClass(SEED);
    createEReference(seedEClass, SEED__ASSIGMENT_SEED_LIST);

    aseedEClass = createEClass(ASEED);
    createEAttribute(aseedEClass, ASEED__OP);

    seedNumberLiteralEClass = createEClass(SEED_NUMBER_LITERAL);
    createEAttribute(seedNumberLiteralEClass, SEED_NUMBER_LITERAL__NUMBER);
    createEReference(seedNumberLiteralEClass, SEED_NUMBER_LITERAL__CONSTANT);

    enumSeedEClass = createEClass(ENUM_SEED);
    createEReference(enumSeedEClass, ENUM_SEED__LEFT);
    createEReference(enumSeedEClass, ENUM_SEED__RIGHT);

    numericalSeedEClass = createEClass(NUMERICAL_SEED);
    createEReference(numericalSeedEClass, NUMERICAL_SEED__LEFT);
    createEReference(numericalSeedEClass, NUMERICAL_SEED__RIGHT);

    boolAssignSeedEClass = createEClass(BOOL_ASSIGN_SEED);
    createEReference(boolAssignSeedEClass, BOOL_ASSIGN_SEED__LEFT);
    createEAttribute(boolAssignSeedEClass, BOOL_ASSIGN_SEED__RIGHT);

    orExpressionEClass = createEClass(OR_EXPRESSION);
    createEReference(orExpressionEClass, OR_EXPRESSION__LEFT);
    createEAttribute(orExpressionEClass, OR_EXPRESSION__OP);
    createEReference(orExpressionEClass, OR_EXPRESSION__RIGHT);

    andExpressionEClass = createEClass(AND_EXPRESSION);
    createEReference(andExpressionEClass, AND_EXPRESSION__LEFT);
    createEAttribute(andExpressionEClass, AND_EXPRESSION__OP);
    createEReference(andExpressionEClass, AND_EXPRESSION__RIGHT);

    impliesExpressionEClass = createEClass(IMPLIES_EXPRESSION);
    createEReference(impliesExpressionEClass, IMPLIES_EXPRESSION__LEFT);
    createEAttribute(impliesExpressionEClass, IMPLIES_EXPRESSION__OP);
    createEReference(impliesExpressionEClass, IMPLIES_EXPRESSION__RIGHT);

    notExpressionEClass = createEClass(NOT_EXPRESSION);
    createEReference(notExpressionEClass, NOT_EXPRESSION__PREDICATE);

    plusMinusEClass = createEClass(PLUS_MINUS);
    createEReference(plusMinusEClass, PLUS_MINUS__LEFT);
    createEAttribute(plusMinusEClass, PLUS_MINUS__OP);
    createEReference(plusMinusEClass, PLUS_MINUS__RIGHT);

    modMultDivEClass = createEClass(MOD_MULT_DIV);
    createEReference(modMultDivEClass, MOD_MULT_DIV__LEFT);
    createEAttribute(modMultDivEClass, MOD_MULT_DIV__OP);
    createEReference(modMultDivEClass, MOD_MULT_DIV__RIGHT);

    // Create enums
    operatorsEEnum = createEEnum(OPERATORS);
    andOperatorsEEnum = createEEnum(AND_OPERATORS);
    orOperatorsEEnum = createEEnum(OR_OPERATORS);
    plusMinusOperatorsEEnum = createEEnum(PLUS_MINUS_OPERATORS);
    modMultDivOperatorsEEnum = createEEnum(MOD_MULT_DIV_OPERATORS);
    impliesOperatorEEnum = createEEnum(IMPLIES_OPERATOR);
    booleanConstEEnum = createEEnum(BOOLEAN_CONST);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    constantNumberEClass.getESuperTypes().add(this.getConstant());
    constantNumberEClass.getESuperTypes().add(this.getNumericalEx());
    parameterEClass.getESuperTypes().add(this.getParametersEx());
    numericalExEClass.getESuperTypes().add(this.getParametersEx());
    numericalEClass.getESuperTypes().add(this.getParameter());
    numericalEClass.getESuperTypes().add(this.getNumericalEx());
    namedTypeEClass.getESuperTypes().add(this.getEnumerativeType());
    anonymousTypeEClass.getESuperTypes().add(this.getEnumerativeType());
    enumerativeEClass.getESuperTypes().add(this.getParameter());
    booleanEClass.getESuperTypes().add(this.getParameter());
    numbersEClass.getESuperTypes().add(this.getNumerical());
    rangeEClass.getESuperTypes().add(this.getNumerical());
    expressionEClass.getESuperTypes().add(this.getRule());
    atomicPredicateEClass.getESuperTypes().add(this.getExpression());
    boolAssignEClass.getESuperTypes().add(this.getAtomicPredicate());
    enumAssignEClass.getESuperTypes().add(this.getAtomicPredicate());
    relationalExpressionEClass.getESuperTypes().add(this.getAtomicPredicate());
    numberLiteralEClass.getESuperTypes().add(this.getExpression());
    enumSeedEClass.getESuperTypes().add(this.getAseed());
    numericalSeedEClass.getESuperTypes().add(this.getAseed());
    boolAssignSeedEClass.getESuperTypes().add(this.getAseed());
    orExpressionEClass.getESuperTypes().add(this.getExpression());
    andExpressionEClass.getESuperTypes().add(this.getExpression());
    impliesExpressionEClass.getESuperTypes().add(this.getExpression());
    notExpressionEClass.getESuperTypes().add(this.getExpression());
    plusMinusEClass.getESuperTypes().add(this.getExpression());
    modMultDivEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(citModelEClass, CitModel.class, "CitModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCitModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, CitModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCitModel_Definitions(), this.getConstant(), null, "definitions", null, 0, -1, CitModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCitModel_Types(), this.getNamedType(), null, "Types", null, 0, -1, CitModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCitModel_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, CitModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCitModel_Constraints(), this.getRule(), null, "constraints", null, 0, -1, CitModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCitModel_Seeds(), this.getSeed(), null, "seeds", null, 0, -1, CitModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCitModel_TestGoals(), this.getRule(), null, "testGoals", null, 0, -1, CitModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(constantNumberEClass, ConstantNumber.class, "ConstantNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstantNumber_Value(), ecorePackage.getEInt(), "value", null, 0, 1, ConstantNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parametersExEClass, ParametersEx.class, "ParametersEx", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParametersEx_Name(), ecorePackage.getEString(), "name", null, 0, 1, ParametersEx.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numericalExEClass, NumericalEx.class, "NumericalEx", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numericalEClass, Numerical.class, "Numerical", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumerativeTypeEClass, EnumerativeType.class, "EnumerativeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumerativeType_Elements(), this.getElement(), null, "elements", null, 0, -1, EnumerativeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedTypeEClass, NamedType.class, "NamedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedType_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(anonymousTypeEClass, AnonymousType.class, "AnonymousType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumerativeEClass, Enumerative.class, "Enumerative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumerative_NamedType(), this.getNamedType(), null, "namedType", null, 0, 1, Enumerative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumerative_Atype(), this.getAnonymousType(), null, "atype", null, 0, 1, Enumerative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanEClass, citlab.model.citL.Boolean.class, "Boolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numbersEClass, Numbers.class, "Numbers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumbers_Values(), ecorePackage.getEIntegerObject(), "values", null, 0, -1, Numbers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rangeEClass, Range.class, "Range", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRange_Begin(), ecorePackage.getEIntegerObject(), "begin", null, 0, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRange_End(), ecorePackage.getEIntegerObject(), "end", null, 0, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRange_Step(), ecorePackage.getEInt(), "step", null, 0, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(atomicPredicateEClass, AtomicPredicate.class, "AtomicPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAtomicPredicate_Op(), this.getOperators(), "op", null, 0, 1, AtomicPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(boolAssignEClass, BoolAssign.class, "BoolAssign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBoolAssign_Left(), this.getBoolean(), null, "left", null, 0, 1, BoolAssign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBoolAssign_Right(), this.getBooleanConst(), "right", null, 0, 1, BoolAssign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumAssignEClass, EnumAssign.class, "EnumAssign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumAssign_Left(), this.getEnumerative(), null, "left", null, 0, 1, EnumAssign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumAssign_Right(), this.getElement(), null, "right", null, 0, 1, EnumAssign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelationalExpression_Left(), this.getNumerical(), null, "left", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelationalExpression_Right(), this.getExpression(), null, "right", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numberLiteralEClass, NumberLiteral.class, "NumberLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumberLiteral_Number(), ecorePackage.getEIntegerObject(), "number", null, 0, 1, NumberLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNumberLiteral_Numerical(), this.getNumericalEx(), null, "numerical", null, 0, 1, NumberLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(seedEClass, Seed.class, "Seed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSeed_AssigmentSeedList(), this.getAseed(), null, "AssigmentSeedList", null, 0, -1, Seed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(aseedEClass, Aseed.class, "Aseed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAseed_Op(), ecorePackage.getEString(), "op", null, 0, 1, Aseed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(seedNumberLiteralEClass, SeedNumberLiteral.class, "SeedNumberLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSeedNumberLiteral_Number(), ecorePackage.getEIntegerObject(), "number", null, 0, 1, SeedNumberLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSeedNumberLiteral_Constant(), this.getConstantNumber(), null, "constant", null, 0, 1, SeedNumberLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumSeedEClass, EnumSeed.class, "EnumSeed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumSeed_Left(), this.getEnumerative(), null, "left", null, 0, 1, EnumSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumSeed_Right(), this.getElement(), null, "right", null, 0, 1, EnumSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numericalSeedEClass, NumericalSeed.class, "NumericalSeed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNumericalSeed_Left(), this.getNumerical(), null, "left", null, 0, 1, NumericalSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNumericalSeed_Right(), this.getSeedNumberLiteral(), null, "right", null, 0, 1, NumericalSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(boolAssignSeedEClass, BoolAssignSeed.class, "BoolAssignSeed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBoolAssignSeed_Left(), this.getBoolean(), null, "left", null, 0, 1, BoolAssignSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBoolAssignSeed_Right(), this.getBooleanConst(), "right", null, 0, 1, BoolAssignSeed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrExpression_Left(), this.getExpression(), null, "left", null, 0, 1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOrExpression_Op(), this.getOrOperators(), "op", null, 0, 1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrExpression_Right(), this.getExpression(), null, "right", null, 0, 1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpression_Left(), this.getExpression(), null, "left", null, 0, 1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAndExpression_Op(), this.getAndOperators(), "op", null, 0, 1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAndExpression_Right(), this.getExpression(), null, "right", null, 0, 1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(impliesExpressionEClass, ImpliesExpression.class, "ImpliesExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getImpliesExpression_Left(), this.getExpression(), null, "left", null, 0, 1, ImpliesExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getImpliesExpression_Op(), this.getImpliesOperator(), "op", null, 0, 1, ImpliesExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getImpliesExpression_Right(), this.getExpression(), null, "right", null, 0, 1, ImpliesExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(notExpressionEClass, NotExpression.class, "NotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNotExpression_Predicate(), this.getExpression(), null, "predicate", null, 0, 1, NotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(plusMinusEClass, PlusMinus.class, "PlusMinus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPlusMinus_Left(), this.getExpression(), null, "left", null, 0, 1, PlusMinus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPlusMinus_Op(), this.getPlusMinusOperators(), "op", null, 0, 1, PlusMinus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPlusMinus_Right(), this.getExpression(), null, "right", null, 0, 1, PlusMinus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modMultDivEClass, ModMultDiv.class, "ModMultDiv", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModMultDiv_Left(), this.getExpression(), null, "left", null, 0, 1, ModMultDiv.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModMultDiv_Op(), this.getModMultDivOperators(), "op", null, 0, 1, ModMultDiv.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModMultDiv_Right(), this.getExpression(), null, "right", null, 0, 1, ModMultDiv.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(operatorsEEnum, Operators.class, "Operators");
    addEEnumLiteral(operatorsEEnum, Operators.GT);
    addEEnumLiteral(operatorsEEnum, Operators.LT);
    addEEnumLiteral(operatorsEEnum, Operators.GE);
    addEEnumLiteral(operatorsEEnum, Operators.LE);
    addEEnumLiteral(operatorsEEnum, Operators.EQ);
    addEEnumLiteral(operatorsEEnum, Operators.NE);

    initEEnum(andOperatorsEEnum, AndOperators.class, "AndOperators");
    addEEnumLiteral(andOperatorsEEnum, AndOperators.AND);
    addEEnumLiteral(andOperatorsEEnum, AndOperators.ANDMI);
    addEEnumLiteral(andOperatorsEEnum, AndOperators.AN_DMA);

    initEEnum(orOperatorsEEnum, OrOperators.class, "OrOperators");
    addEEnumLiteral(orOperatorsEEnum, OrOperators.OR);
    addEEnumLiteral(orOperatorsEEnum, OrOperators.ORMI);
    addEEnumLiteral(orOperatorsEEnum, OrOperators.ORMA);

    initEEnum(plusMinusOperatorsEEnum, PlusMinusOperators.class, "PlusMinusOperators");
    addEEnumLiteral(plusMinusOperatorsEEnum, PlusMinusOperators.PLUS);
    addEEnumLiteral(plusMinusOperatorsEEnum, PlusMinusOperators.MINUS);

    initEEnum(modMultDivOperatorsEEnum, ModMultDivOperators.class, "ModMultDivOperators");
    addEEnumLiteral(modMultDivOperatorsEEnum, ModMultDivOperators.MOD);
    addEEnumLiteral(modMultDivOperatorsEEnum, ModMultDivOperators.MULT);
    addEEnumLiteral(modMultDivOperatorsEEnum, ModMultDivOperators.DIV);

    initEEnum(impliesOperatorEEnum, ImpliesOperator.class, "ImpliesOperator");
    addEEnumLiteral(impliesOperatorEEnum, ImpliesOperator.IMPL);
    addEEnumLiteral(impliesOperatorEEnum, ImpliesOperator.IFF);

    initEEnum(booleanConstEEnum, BooleanConst.class, "BooleanConst");
    addEEnumLiteral(booleanConstEEnum, BooleanConst.FALSE);
    addEEnumLiteral(booleanConstEEnum, BooleanConst.TRUE);

    // Create resource
    createResource(eNS_URI);
  }

} //CitLPackageImpl
