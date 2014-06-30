/**
 */
package citlab.model.citL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see citlab.model.citL.CitLFactory
 * @model kind="package"
 * @generated
 */
public interface CitLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "citL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.model.citlab/CitL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "citL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CitLPackage eINSTANCE = citlab.model.citL.impl.CitLPackageImpl.init();

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.CitModelImpl <em>Cit Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.CitModelImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getCitModel()
   * @generated
   */
  int CIT_MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CIT_MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CIT_MODEL__DEFINITIONS = 1;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CIT_MODEL__TYPES = 2;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CIT_MODEL__PARAMETERS = 3;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CIT_MODEL__CONSTRAINTS = 4;

  /**
   * The feature id for the '<em><b>Seeds</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CIT_MODEL__SEEDS = 5;

  /**
   * The feature id for the '<em><b>Test Goals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CIT_MODEL__TEST_GOALS = 6;

  /**
   * The number of structural features of the '<em>Cit Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CIT_MODEL_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.ConstantImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 1;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.ConstantNumberImpl <em>Constant Number</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.ConstantNumberImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getConstantNumber()
   * @generated
   */
  int CONSTANT_NUMBER = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_NUMBER__NAME = CONSTANT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_NUMBER__VALUE = CONSTANT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Constant Number</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_NUMBER_FEATURE_COUNT = CONSTANT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.ParametersExImpl <em>Parameters Ex</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.ParametersExImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getParametersEx()
   * @generated
   */
  int PARAMETERS_EX = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETERS_EX__NAME = 0;

  /**
   * The number of structural features of the '<em>Parameters Ex</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETERS_EX_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.ParameterImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = PARAMETERS_EX__NAME;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = PARAMETERS_EX_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.NumericalExImpl <em>Numerical Ex</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.NumericalExImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getNumericalEx()
   * @generated
   */
  int NUMERICAL_EX = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_EX__NAME = PARAMETERS_EX__NAME;

  /**
   * The number of structural features of the '<em>Numerical Ex</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_EX_FEATURE_COUNT = PARAMETERS_EX_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.NumericalImpl <em>Numerical</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.NumericalImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getNumerical()
   * @generated
   */
  int NUMERICAL = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL__NAME = PARAMETER__NAME;

  /**
   * The number of structural features of the '<em>Numerical</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.EnumerativeTypeImpl <em>Enumerative Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.EnumerativeTypeImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getEnumerativeType()
   * @generated
   */
  int ENUMERATIVE_TYPE = 7;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATIVE_TYPE__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Enumerative Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATIVE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.NamedTypeImpl <em>Named Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.NamedTypeImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getNamedType()
   * @generated
   */
  int NAMED_TYPE = 8;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE__ELEMENTS = ENUMERATIVE_TYPE__ELEMENTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE__NAME = ENUMERATIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_FEATURE_COUNT = ENUMERATIVE_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.AnonymousTypeImpl <em>Anonymous Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.AnonymousTypeImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getAnonymousType()
   * @generated
   */
  int ANONYMOUS_TYPE = 9;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TYPE__ELEMENTS = ENUMERATIVE_TYPE__ELEMENTS;

  /**
   * The number of structural features of the '<em>Anonymous Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TYPE_FEATURE_COUNT = ENUMERATIVE_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.EnumerativeImpl <em>Enumerative</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.EnumerativeImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getEnumerative()
   * @generated
   */
  int ENUMERATIVE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATIVE__NAME = PARAMETER__NAME;

  /**
   * The feature id for the '<em><b>Named Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATIVE__NAMED_TYPE = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Atype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATIVE__ATYPE = PARAMETER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enumerative</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATIVE_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.ElementImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.BooleanImpl <em>Boolean</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.BooleanImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getBoolean()
   * @generated
   */
  int BOOLEAN = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN__NAME = PARAMETER__NAME;

  /**
   * The number of structural features of the '<em>Boolean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.NumbersImpl <em>Numbers</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.NumbersImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getNumbers()
   * @generated
   */
  int NUMBERS = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBERS__NAME = NUMERICAL__NAME;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBERS__VALUES = NUMERICAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Numbers</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBERS_FEATURE_COUNT = NUMERICAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.RangeImpl <em>Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.RangeImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getRange()
   * @generated
   */
  int RANGE = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__NAME = NUMERICAL__NAME;

  /**
   * The feature id for the '<em><b>Begin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__BEGIN = NUMERICAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__END = NUMERICAL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Step</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__STEP = NUMERICAL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FEATURE_COUNT = NUMERICAL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.RuleImpl <em>Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.RuleImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getRule()
   * @generated
   */
  int RULE = 15;

  /**
   * The number of structural features of the '<em>Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.ExpressionImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 16;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = RULE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.AtomicPredicateImpl <em>Atomic Predicate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.AtomicPredicateImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getAtomicPredicate()
   * @generated
   */
  int ATOMIC_PREDICATE = 17;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_PREDICATE__OP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Atomic Predicate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATOMIC_PREDICATE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.BoolAssignImpl <em>Bool Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.BoolAssignImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getBoolAssign()
   * @generated
   */
  int BOOL_ASSIGN = 18;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_ASSIGN__OP = ATOMIC_PREDICATE__OP;

  /**
   * The feature id for the '<em><b>Left</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_ASSIGN__LEFT = ATOMIC_PREDICATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_ASSIGN__RIGHT = ATOMIC_PREDICATE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Bool Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_ASSIGN_FEATURE_COUNT = ATOMIC_PREDICATE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.EnumAssignImpl <em>Enum Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.EnumAssignImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getEnumAssign()
   * @generated
   */
  int ENUM_ASSIGN = 19;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_ASSIGN__OP = ATOMIC_PREDICATE__OP;

  /**
   * The feature id for the '<em><b>Left</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_ASSIGN__LEFT = ATOMIC_PREDICATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_ASSIGN__RIGHT = ATOMIC_PREDICATE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enum Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_ASSIGN_FEATURE_COUNT = ATOMIC_PREDICATE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.RelationalExpressionImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 20;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OP = ATOMIC_PREDICATE__OP;

  /**
   * The feature id for the '<em><b>Left</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__LEFT = ATOMIC_PREDICATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__RIGHT = ATOMIC_PREDICATE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = ATOMIC_PREDICATE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.NumberLiteralImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getNumberLiteral()
   * @generated
   */
  int NUMBER_LITERAL = 21;

  /**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__NUMBER = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Numerical</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__NUMERICAL = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Number Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.SeedImpl <em>Seed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.SeedImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getSeed()
   * @generated
   */
  int SEED = 22;

  /**
   * The feature id for the '<em><b>Assigment Seed List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEED__ASSIGMENT_SEED_LIST = 0;

  /**
   * The number of structural features of the '<em>Seed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.AseedImpl <em>Aseed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.AseedImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getAseed()
   * @generated
   */
  int ASEED = 23;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASEED__OP = 0;

  /**
   * The number of structural features of the '<em>Aseed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASEED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.SeedNumberLiteralImpl <em>Seed Number Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.SeedNumberLiteralImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getSeedNumberLiteral()
   * @generated
   */
  int SEED_NUMBER_LITERAL = 24;

  /**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEED_NUMBER_LITERAL__NUMBER = 0;

  /**
   * The feature id for the '<em><b>Constant</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEED_NUMBER_LITERAL__CONSTANT = 1;

  /**
   * The number of structural features of the '<em>Seed Number Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEED_NUMBER_LITERAL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.EnumSeedImpl <em>Enum Seed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.EnumSeedImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getEnumSeed()
   * @generated
   */
  int ENUM_SEED = 25;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_SEED__OP = ASEED__OP;

  /**
   * The feature id for the '<em><b>Left</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_SEED__LEFT = ASEED_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_SEED__RIGHT = ASEED_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enum Seed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_SEED_FEATURE_COUNT = ASEED_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.NumericalSeedImpl <em>Numerical Seed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.NumericalSeedImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getNumericalSeed()
   * @generated
   */
  int NUMERICAL_SEED = 26;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_SEED__OP = ASEED__OP;

  /**
   * The feature id for the '<em><b>Left</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_SEED__LEFT = ASEED_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_SEED__RIGHT = ASEED_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Numerical Seed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_SEED_FEATURE_COUNT = ASEED_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.BoolAssignSeedImpl <em>Bool Assign Seed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.BoolAssignSeedImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getBoolAssignSeed()
   * @generated
   */
  int BOOL_ASSIGN_SEED = 27;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_ASSIGN_SEED__OP = ASEED__OP;

  /**
   * The feature id for the '<em><b>Left</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_ASSIGN_SEED__LEFT = ASEED_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_ASSIGN_SEED__RIGHT = ASEED_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Bool Assign Seed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_ASSIGN_SEED_FEATURE_COUNT = ASEED_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.OrExpressionImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 28;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.AndExpressionImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 29;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.ImpliesExpressionImpl <em>Implies Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.ImpliesExpressionImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getImpliesExpression()
   * @generated
   */
  int IMPLIES_EXPRESSION = 30;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES_EXPRESSION__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Implies Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.NotExpressionImpl <em>Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.NotExpressionImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getNotExpression()
   * @generated
   */
  int NOT_EXPRESSION = 31;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION__PREDICATE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Not Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.PlusMinusImpl <em>Plus Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.PlusMinusImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getPlusMinus()
   * @generated
   */
  int PLUS_MINUS = 32;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_MINUS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_MINUS__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_MINUS__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Plus Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_MINUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link citlab.model.citL.impl.ModMultDivImpl <em>Mod Mult Div</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.impl.ModMultDivImpl
   * @see citlab.model.citL.impl.CitLPackageImpl#getModMultDiv()
   * @generated
   */
  int MOD_MULT_DIV = 33;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_MULT_DIV__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_MULT_DIV__OP = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_MULT_DIV__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Mod Mult Div</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_MULT_DIV_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link citlab.model.citL.Operators <em>Operators</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.Operators
   * @see citlab.model.citL.impl.CitLPackageImpl#getOperators()
   * @generated
   */
  int OPERATORS = 34;

  /**
   * The meta object id for the '{@link citlab.model.citL.AndOperators <em>And Operators</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.AndOperators
   * @see citlab.model.citL.impl.CitLPackageImpl#getAndOperators()
   * @generated
   */
  int AND_OPERATORS = 35;

  /**
   * The meta object id for the '{@link citlab.model.citL.OrOperators <em>Or Operators</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.OrOperators
   * @see citlab.model.citL.impl.CitLPackageImpl#getOrOperators()
   * @generated
   */
  int OR_OPERATORS = 36;

  /**
   * The meta object id for the '{@link citlab.model.citL.PlusMinusOperators <em>Plus Minus Operators</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.PlusMinusOperators
   * @see citlab.model.citL.impl.CitLPackageImpl#getPlusMinusOperators()
   * @generated
   */
  int PLUS_MINUS_OPERATORS = 37;

  /**
   * The meta object id for the '{@link citlab.model.citL.ModMultDivOperators <em>Mod Mult Div Operators</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.ModMultDivOperators
   * @see citlab.model.citL.impl.CitLPackageImpl#getModMultDivOperators()
   * @generated
   */
  int MOD_MULT_DIV_OPERATORS = 38;

  /**
   * The meta object id for the '{@link citlab.model.citL.ImpliesOperator <em>Implies Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.ImpliesOperator
   * @see citlab.model.citL.impl.CitLPackageImpl#getImpliesOperator()
   * @generated
   */
  int IMPLIES_OPERATOR = 39;

  /**
   * The meta object id for the '{@link citlab.model.citL.BooleanConst <em>Boolean Const</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see citlab.model.citL.BooleanConst
   * @see citlab.model.citL.impl.CitLPackageImpl#getBooleanConst()
   * @generated
   */
  int BOOLEAN_CONST = 40;


  /**
   * Returns the meta object for class '{@link citlab.model.citL.CitModel <em>Cit Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cit Model</em>'.
   * @see citlab.model.citL.CitModel
   * @generated
   */
  EClass getCitModel();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.CitModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see citlab.model.citL.CitModel#getName()
   * @see #getCitModel()
   * @generated
   */
  EAttribute getCitModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link citlab.model.citL.CitModel#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see citlab.model.citL.CitModel#getDefinitions()
   * @see #getCitModel()
   * @generated
   */
  EReference getCitModel_Definitions();

  /**
   * Returns the meta object for the containment reference list '{@link citlab.model.citL.CitModel#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see citlab.model.citL.CitModel#getTypes()
   * @see #getCitModel()
   * @generated
   */
  EReference getCitModel_Types();

  /**
   * Returns the meta object for the containment reference list '{@link citlab.model.citL.CitModel#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see citlab.model.citL.CitModel#getParameters()
   * @see #getCitModel()
   * @generated
   */
  EReference getCitModel_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link citlab.model.citL.CitModel#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraints</em>'.
   * @see citlab.model.citL.CitModel#getConstraints()
   * @see #getCitModel()
   * @generated
   */
  EReference getCitModel_Constraints();

  /**
   * Returns the meta object for the containment reference list '{@link citlab.model.citL.CitModel#getSeeds <em>Seeds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Seeds</em>'.
   * @see citlab.model.citL.CitModel#getSeeds()
   * @see #getCitModel()
   * @generated
   */
  EReference getCitModel_Seeds();

  /**
   * Returns the meta object for the containment reference list '{@link citlab.model.citL.CitModel#getTestGoals <em>Test Goals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Test Goals</em>'.
   * @see citlab.model.citL.CitModel#getTestGoals()
   * @see #getCitModel()
   * @generated
   */
  EReference getCitModel_TestGoals();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see citlab.model.citL.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.ConstantNumber <em>Constant Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Number</em>'.
   * @see citlab.model.citL.ConstantNumber
   * @generated
   */
  EClass getConstantNumber();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.ConstantNumber#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see citlab.model.citL.ConstantNumber#getValue()
   * @see #getConstantNumber()
   * @generated
   */
  EAttribute getConstantNumber_Value();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see citlab.model.citL.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.ParametersEx <em>Parameters Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameters Ex</em>'.
   * @see citlab.model.citL.ParametersEx
   * @generated
   */
  EClass getParametersEx();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.ParametersEx#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see citlab.model.citL.ParametersEx#getName()
   * @see #getParametersEx()
   * @generated
   */
  EAttribute getParametersEx_Name();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.NumericalEx <em>Numerical Ex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Ex</em>'.
   * @see citlab.model.citL.NumericalEx
   * @generated
   */
  EClass getNumericalEx();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Numerical <em>Numerical</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical</em>'.
   * @see citlab.model.citL.Numerical
   * @generated
   */
  EClass getNumerical();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.EnumerativeType <em>Enumerative Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumerative Type</em>'.
   * @see citlab.model.citL.EnumerativeType
   * @generated
   */
  EClass getEnumerativeType();

  /**
   * Returns the meta object for the containment reference list '{@link citlab.model.citL.EnumerativeType#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see citlab.model.citL.EnumerativeType#getElements()
   * @see #getEnumerativeType()
   * @generated
   */
  EReference getEnumerativeType_Elements();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.NamedType <em>Named Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Type</em>'.
   * @see citlab.model.citL.NamedType
   * @generated
   */
  EClass getNamedType();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.NamedType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see citlab.model.citL.NamedType#getName()
   * @see #getNamedType()
   * @generated
   */
  EAttribute getNamedType_Name();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.AnonymousType <em>Anonymous Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous Type</em>'.
   * @see citlab.model.citL.AnonymousType
   * @generated
   */
  EClass getAnonymousType();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Enumerative <em>Enumerative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumerative</em>'.
   * @see citlab.model.citL.Enumerative
   * @generated
   */
  EClass getEnumerative();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.Enumerative#getNamedType <em>Named Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Named Type</em>'.
   * @see citlab.model.citL.Enumerative#getNamedType()
   * @see #getEnumerative()
   * @generated
   */
  EReference getEnumerative_NamedType();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.Enumerative#getAtype <em>Atype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Atype</em>'.
   * @see citlab.model.citL.Enumerative#getAtype()
   * @see #getEnumerative()
   * @generated
   */
  EReference getEnumerative_Atype();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see citlab.model.citL.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.Element#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see citlab.model.citL.Element#getName()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Name();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Boolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean</em>'.
   * @see citlab.model.citL.Boolean
   * @generated
   */
  EClass getBoolean();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Numbers <em>Numbers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numbers</em>'.
   * @see citlab.model.citL.Numbers
   * @generated
   */
  EClass getNumbers();

  /**
   * Returns the meta object for the attribute list '{@link citlab.model.citL.Numbers#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see citlab.model.citL.Numbers#getValues()
   * @see #getNumbers()
   * @generated
   */
  EAttribute getNumbers_Values();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range</em>'.
   * @see citlab.model.citL.Range
   * @generated
   */
  EClass getRange();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.Range#getBegin <em>Begin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Begin</em>'.
   * @see citlab.model.citL.Range#getBegin()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_Begin();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.Range#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End</em>'.
   * @see citlab.model.citL.Range#getEnd()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_End();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.Range#getStep <em>Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Step</em>'.
   * @see citlab.model.citL.Range#getStep()
   * @see #getRange()
   * @generated
   */
  EAttribute getRange_Step();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule</em>'.
   * @see citlab.model.citL.Rule
   * @generated
   */
  EClass getRule();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see citlab.model.citL.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.AtomicPredicate <em>Atomic Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Atomic Predicate</em>'.
   * @see citlab.model.citL.AtomicPredicate
   * @generated
   */
  EClass getAtomicPredicate();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.AtomicPredicate#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see citlab.model.citL.AtomicPredicate#getOp()
   * @see #getAtomicPredicate()
   * @generated
   */
  EAttribute getAtomicPredicate_Op();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.BoolAssign <em>Bool Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Assign</em>'.
   * @see citlab.model.citL.BoolAssign
   * @generated
   */
  EClass getBoolAssign();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.BoolAssign#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Left</em>'.
   * @see citlab.model.citL.BoolAssign#getLeft()
   * @see #getBoolAssign()
   * @generated
   */
  EReference getBoolAssign_Left();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.BoolAssign#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Right</em>'.
   * @see citlab.model.citL.BoolAssign#getRight()
   * @see #getBoolAssign()
   * @generated
   */
  EAttribute getBoolAssign_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.EnumAssign <em>Enum Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Assign</em>'.
   * @see citlab.model.citL.EnumAssign
   * @generated
   */
  EClass getEnumAssign();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.EnumAssign#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Left</em>'.
   * @see citlab.model.citL.EnumAssign#getLeft()
   * @see #getEnumAssign()
   * @generated
   */
  EReference getEnumAssign_Left();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.EnumAssign#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right</em>'.
   * @see citlab.model.citL.EnumAssign#getRight()
   * @see #getEnumAssign()
   * @generated
   */
  EReference getEnumAssign_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see citlab.model.citL.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.RelationalExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Left</em>'.
   * @see citlab.model.citL.RelationalExpression#getLeft()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.RelationalExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see citlab.model.citL.RelationalExpression#getRight()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.NumberLiteral <em>Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal</em>'.
   * @see citlab.model.citL.NumberLiteral
   * @generated
   */
  EClass getNumberLiteral();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.NumberLiteral#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see citlab.model.citL.NumberLiteral#getNumber()
   * @see #getNumberLiteral()
   * @generated
   */
  EAttribute getNumberLiteral_Number();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.NumberLiteral#getNumerical <em>Numerical</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Numerical</em>'.
   * @see citlab.model.citL.NumberLiteral#getNumerical()
   * @see #getNumberLiteral()
   * @generated
   */
  EReference getNumberLiteral_Numerical();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Seed <em>Seed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Seed</em>'.
   * @see citlab.model.citL.Seed
   * @generated
   */
  EClass getSeed();

  /**
   * Returns the meta object for the containment reference list '{@link citlab.model.citL.Seed#getAssigmentSeedList <em>Assigment Seed List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assigment Seed List</em>'.
   * @see citlab.model.citL.Seed#getAssigmentSeedList()
   * @see #getSeed()
   * @generated
   */
  EReference getSeed_AssigmentSeedList();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.Aseed <em>Aseed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aseed</em>'.
   * @see citlab.model.citL.Aseed
   * @generated
   */
  EClass getAseed();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.Aseed#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see citlab.model.citL.Aseed#getOp()
   * @see #getAseed()
   * @generated
   */
  EAttribute getAseed_Op();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.SeedNumberLiteral <em>Seed Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Seed Number Literal</em>'.
   * @see citlab.model.citL.SeedNumberLiteral
   * @generated
   */
  EClass getSeedNumberLiteral();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.SeedNumberLiteral#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see citlab.model.citL.SeedNumberLiteral#getNumber()
   * @see #getSeedNumberLiteral()
   * @generated
   */
  EAttribute getSeedNumberLiteral_Number();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.SeedNumberLiteral#getConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Constant</em>'.
   * @see citlab.model.citL.SeedNumberLiteral#getConstant()
   * @see #getSeedNumberLiteral()
   * @generated
   */
  EReference getSeedNumberLiteral_Constant();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.EnumSeed <em>Enum Seed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Seed</em>'.
   * @see citlab.model.citL.EnumSeed
   * @generated
   */
  EClass getEnumSeed();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.EnumSeed#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Left</em>'.
   * @see citlab.model.citL.EnumSeed#getLeft()
   * @see #getEnumSeed()
   * @generated
   */
  EReference getEnumSeed_Left();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.EnumSeed#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right</em>'.
   * @see citlab.model.citL.EnumSeed#getRight()
   * @see #getEnumSeed()
   * @generated
   */
  EReference getEnumSeed_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.NumericalSeed <em>Numerical Seed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Seed</em>'.
   * @see citlab.model.citL.NumericalSeed
   * @generated
   */
  EClass getNumericalSeed();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.NumericalSeed#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Left</em>'.
   * @see citlab.model.citL.NumericalSeed#getLeft()
   * @see #getNumericalSeed()
   * @generated
   */
  EReference getNumericalSeed_Left();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.NumericalSeed#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see citlab.model.citL.NumericalSeed#getRight()
   * @see #getNumericalSeed()
   * @generated
   */
  EReference getNumericalSeed_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.BoolAssignSeed <em>Bool Assign Seed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Assign Seed</em>'.
   * @see citlab.model.citL.BoolAssignSeed
   * @generated
   */
  EClass getBoolAssignSeed();

  /**
   * Returns the meta object for the reference '{@link citlab.model.citL.BoolAssignSeed#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Left</em>'.
   * @see citlab.model.citL.BoolAssignSeed#getLeft()
   * @see #getBoolAssignSeed()
   * @generated
   */
  EReference getBoolAssignSeed_Left();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.BoolAssignSeed#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Right</em>'.
   * @see citlab.model.citL.BoolAssignSeed#getRight()
   * @see #getBoolAssignSeed()
   * @generated
   */
  EAttribute getBoolAssignSeed_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see citlab.model.citL.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.OrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see citlab.model.citL.OrExpression#getLeft()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.OrExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see citlab.model.citL.OrExpression#getOp()
   * @see #getOrExpression()
   * @generated
   */
  EAttribute getOrExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.OrExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see citlab.model.citL.OrExpression#getRight()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see citlab.model.citL.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.AndExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see citlab.model.citL.AndExpression#getLeft()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.AndExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see citlab.model.citL.AndExpression#getOp()
   * @see #getAndExpression()
   * @generated
   */
  EAttribute getAndExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.AndExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see citlab.model.citL.AndExpression#getRight()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.ImpliesExpression <em>Implies Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implies Expression</em>'.
   * @see citlab.model.citL.ImpliesExpression
   * @generated
   */
  EClass getImpliesExpression();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.ImpliesExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see citlab.model.citL.ImpliesExpression#getLeft()
   * @see #getImpliesExpression()
   * @generated
   */
  EReference getImpliesExpression_Left();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.ImpliesExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see citlab.model.citL.ImpliesExpression#getOp()
   * @see #getImpliesExpression()
   * @generated
   */
  EAttribute getImpliesExpression_Op();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.ImpliesExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see citlab.model.citL.ImpliesExpression#getRight()
   * @see #getImpliesExpression()
   * @generated
   */
  EReference getImpliesExpression_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.NotExpression <em>Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Expression</em>'.
   * @see citlab.model.citL.NotExpression
   * @generated
   */
  EClass getNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.NotExpression#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see citlab.model.citL.NotExpression#getPredicate()
   * @see #getNotExpression()
   * @generated
   */
  EReference getNotExpression_Predicate();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.PlusMinus <em>Plus Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plus Minus</em>'.
   * @see citlab.model.citL.PlusMinus
   * @generated
   */
  EClass getPlusMinus();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.PlusMinus#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see citlab.model.citL.PlusMinus#getLeft()
   * @see #getPlusMinus()
   * @generated
   */
  EReference getPlusMinus_Left();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.PlusMinus#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see citlab.model.citL.PlusMinus#getOp()
   * @see #getPlusMinus()
   * @generated
   */
  EAttribute getPlusMinus_Op();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.PlusMinus#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see citlab.model.citL.PlusMinus#getRight()
   * @see #getPlusMinus()
   * @generated
   */
  EReference getPlusMinus_Right();

  /**
   * Returns the meta object for class '{@link citlab.model.citL.ModMultDiv <em>Mod Mult Div</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mod Mult Div</em>'.
   * @see citlab.model.citL.ModMultDiv
   * @generated
   */
  EClass getModMultDiv();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.ModMultDiv#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see citlab.model.citL.ModMultDiv#getLeft()
   * @see #getModMultDiv()
   * @generated
   */
  EReference getModMultDiv_Left();

  /**
   * Returns the meta object for the attribute '{@link citlab.model.citL.ModMultDiv#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see citlab.model.citL.ModMultDiv#getOp()
   * @see #getModMultDiv()
   * @generated
   */
  EAttribute getModMultDiv_Op();

  /**
   * Returns the meta object for the containment reference '{@link citlab.model.citL.ModMultDiv#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see citlab.model.citL.ModMultDiv#getRight()
   * @see #getModMultDiv()
   * @generated
   */
  EReference getModMultDiv_Right();

  /**
   * Returns the meta object for enum '{@link citlab.model.citL.Operators <em>Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Operators</em>'.
   * @see citlab.model.citL.Operators
   * @generated
   */
  EEnum getOperators();

  /**
   * Returns the meta object for enum '{@link citlab.model.citL.AndOperators <em>And Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>And Operators</em>'.
   * @see citlab.model.citL.AndOperators
   * @generated
   */
  EEnum getAndOperators();

  /**
   * Returns the meta object for enum '{@link citlab.model.citL.OrOperators <em>Or Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Or Operators</em>'.
   * @see citlab.model.citL.OrOperators
   * @generated
   */
  EEnum getOrOperators();

  /**
   * Returns the meta object for enum '{@link citlab.model.citL.PlusMinusOperators <em>Plus Minus Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Plus Minus Operators</em>'.
   * @see citlab.model.citL.PlusMinusOperators
   * @generated
   */
  EEnum getPlusMinusOperators();

  /**
   * Returns the meta object for enum '{@link citlab.model.citL.ModMultDivOperators <em>Mod Mult Div Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Mod Mult Div Operators</em>'.
   * @see citlab.model.citL.ModMultDivOperators
   * @generated
   */
  EEnum getModMultDivOperators();

  /**
   * Returns the meta object for enum '{@link citlab.model.citL.ImpliesOperator <em>Implies Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Implies Operator</em>'.
   * @see citlab.model.citL.ImpliesOperator
   * @generated
   */
  EEnum getImpliesOperator();

  /**
   * Returns the meta object for enum '{@link citlab.model.citL.BooleanConst <em>Boolean Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Boolean Const</em>'.
   * @see citlab.model.citL.BooleanConst
   * @generated
   */
  EEnum getBooleanConst();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CitLFactory getCitLFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.CitModelImpl <em>Cit Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.CitModelImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getCitModel()
     * @generated
     */
    EClass CIT_MODEL = eINSTANCE.getCitModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CIT_MODEL__NAME = eINSTANCE.getCitModel_Name();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CIT_MODEL__DEFINITIONS = eINSTANCE.getCitModel_Definitions();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CIT_MODEL__TYPES = eINSTANCE.getCitModel_Types();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CIT_MODEL__PARAMETERS = eINSTANCE.getCitModel_Parameters();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CIT_MODEL__CONSTRAINTS = eINSTANCE.getCitModel_Constraints();

    /**
     * The meta object literal for the '<em><b>Seeds</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CIT_MODEL__SEEDS = eINSTANCE.getCitModel_Seeds();

    /**
     * The meta object literal for the '<em><b>Test Goals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CIT_MODEL__TEST_GOALS = eINSTANCE.getCitModel_TestGoals();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.ConstantImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.ConstantNumberImpl <em>Constant Number</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.ConstantNumberImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getConstantNumber()
     * @generated
     */
    EClass CONSTANT_NUMBER = eINSTANCE.getConstantNumber();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT_NUMBER__VALUE = eINSTANCE.getConstantNumber_Value();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.ParameterImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.ParametersExImpl <em>Parameters Ex</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.ParametersExImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getParametersEx()
     * @generated
     */
    EClass PARAMETERS_EX = eINSTANCE.getParametersEx();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETERS_EX__NAME = eINSTANCE.getParametersEx_Name();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.NumericalExImpl <em>Numerical Ex</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.NumericalExImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getNumericalEx()
     * @generated
     */
    EClass NUMERICAL_EX = eINSTANCE.getNumericalEx();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.NumericalImpl <em>Numerical</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.NumericalImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getNumerical()
     * @generated
     */
    EClass NUMERICAL = eINSTANCE.getNumerical();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.EnumerativeTypeImpl <em>Enumerative Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.EnumerativeTypeImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getEnumerativeType()
     * @generated
     */
    EClass ENUMERATIVE_TYPE = eINSTANCE.getEnumerativeType();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATIVE_TYPE__ELEMENTS = eINSTANCE.getEnumerativeType_Elements();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.NamedTypeImpl <em>Named Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.NamedTypeImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getNamedType()
     * @generated
     */
    EClass NAMED_TYPE = eINSTANCE.getNamedType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_TYPE__NAME = eINSTANCE.getNamedType_Name();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.AnonymousTypeImpl <em>Anonymous Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.AnonymousTypeImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getAnonymousType()
     * @generated
     */
    EClass ANONYMOUS_TYPE = eINSTANCE.getAnonymousType();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.EnumerativeImpl <em>Enumerative</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.EnumerativeImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getEnumerative()
     * @generated
     */
    EClass ENUMERATIVE = eINSTANCE.getEnumerative();

    /**
     * The meta object literal for the '<em><b>Named Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATIVE__NAMED_TYPE = eINSTANCE.getEnumerative_NamedType();

    /**
     * The meta object literal for the '<em><b>Atype</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATIVE__ATYPE = eINSTANCE.getEnumerative_Atype();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.ElementImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.BooleanImpl <em>Boolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.BooleanImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getBoolean()
     * @generated
     */
    EClass BOOLEAN = eINSTANCE.getBoolean();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.NumbersImpl <em>Numbers</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.NumbersImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getNumbers()
     * @generated
     */
    EClass NUMBERS = eINSTANCE.getNumbers();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBERS__VALUES = eINSTANCE.getNumbers_Values();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.RangeImpl <em>Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.RangeImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getRange()
     * @generated
     */
    EClass RANGE = eINSTANCE.getRange();

    /**
     * The meta object literal for the '<em><b>Begin</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__BEGIN = eINSTANCE.getRange_Begin();

    /**
     * The meta object literal for the '<em><b>End</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__END = eINSTANCE.getRange_End();

    /**
     * The meta object literal for the '<em><b>Step</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE__STEP = eINSTANCE.getRange_Step();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.RuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.RuleImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getRule()
     * @generated
     */
    EClass RULE = eINSTANCE.getRule();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.ExpressionImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.AtomicPredicateImpl <em>Atomic Predicate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.AtomicPredicateImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getAtomicPredicate()
     * @generated
     */
    EClass ATOMIC_PREDICATE = eINSTANCE.getAtomicPredicate();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATOMIC_PREDICATE__OP = eINSTANCE.getAtomicPredicate_Op();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.BoolAssignImpl <em>Bool Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.BoolAssignImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getBoolAssign()
     * @generated
     */
    EClass BOOL_ASSIGN = eINSTANCE.getBoolAssign();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOL_ASSIGN__LEFT = eINSTANCE.getBoolAssign_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_ASSIGN__RIGHT = eINSTANCE.getBoolAssign_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.EnumAssignImpl <em>Enum Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.EnumAssignImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getEnumAssign()
     * @generated
     */
    EClass ENUM_ASSIGN = eINSTANCE.getEnumAssign();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_ASSIGN__LEFT = eINSTANCE.getEnumAssign_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_ASSIGN__RIGHT = eINSTANCE.getEnumAssign_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.RelationalExpressionImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__LEFT = eINSTANCE.getRelationalExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__RIGHT = eINSTANCE.getRelationalExpression_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.NumberLiteralImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getNumberLiteral()
     * @generated
     */
    EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

    /**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBER_LITERAL__NUMBER = eINSTANCE.getNumberLiteral_Number();

    /**
     * The meta object literal for the '<em><b>Numerical</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMBER_LITERAL__NUMERICAL = eINSTANCE.getNumberLiteral_Numerical();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.SeedImpl <em>Seed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.SeedImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getSeed()
     * @generated
     */
    EClass SEED = eINSTANCE.getSeed();

    /**
     * The meta object literal for the '<em><b>Assigment Seed List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEED__ASSIGMENT_SEED_LIST = eINSTANCE.getSeed_AssigmentSeedList();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.AseedImpl <em>Aseed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.AseedImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getAseed()
     * @generated
     */
    EClass ASEED = eINSTANCE.getAseed();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASEED__OP = eINSTANCE.getAseed_Op();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.SeedNumberLiteralImpl <em>Seed Number Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.SeedNumberLiteralImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getSeedNumberLiteral()
     * @generated
     */
    EClass SEED_NUMBER_LITERAL = eINSTANCE.getSeedNumberLiteral();

    /**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SEED_NUMBER_LITERAL__NUMBER = eINSTANCE.getSeedNumberLiteral_Number();

    /**
     * The meta object literal for the '<em><b>Constant</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEED_NUMBER_LITERAL__CONSTANT = eINSTANCE.getSeedNumberLiteral_Constant();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.EnumSeedImpl <em>Enum Seed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.EnumSeedImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getEnumSeed()
     * @generated
     */
    EClass ENUM_SEED = eINSTANCE.getEnumSeed();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_SEED__LEFT = eINSTANCE.getEnumSeed_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_SEED__RIGHT = eINSTANCE.getEnumSeed_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.NumericalSeedImpl <em>Numerical Seed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.NumericalSeedImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getNumericalSeed()
     * @generated
     */
    EClass NUMERICAL_SEED = eINSTANCE.getNumericalSeed();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_SEED__LEFT = eINSTANCE.getNumericalSeed_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_SEED__RIGHT = eINSTANCE.getNumericalSeed_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.BoolAssignSeedImpl <em>Bool Assign Seed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.BoolAssignSeedImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getBoolAssignSeed()
     * @generated
     */
    EClass BOOL_ASSIGN_SEED = eINSTANCE.getBoolAssignSeed();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOL_ASSIGN_SEED__LEFT = eINSTANCE.getBoolAssignSeed_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_ASSIGN_SEED__RIGHT = eINSTANCE.getBoolAssignSeed_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.OrExpressionImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__LEFT = eINSTANCE.getOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OR_EXPRESSION__OP = eINSTANCE.getOrExpression_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__RIGHT = eINSTANCE.getOrExpression_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.AndExpressionImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__LEFT = eINSTANCE.getAndExpression_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AND_EXPRESSION__OP = eINSTANCE.getAndExpression_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__RIGHT = eINSTANCE.getAndExpression_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.ImpliesExpressionImpl <em>Implies Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.ImpliesExpressionImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getImpliesExpression()
     * @generated
     */
    EClass IMPLIES_EXPRESSION = eINSTANCE.getImpliesExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLIES_EXPRESSION__LEFT = eINSTANCE.getImpliesExpression_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPLIES_EXPRESSION__OP = eINSTANCE.getImpliesExpression_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMPLIES_EXPRESSION__RIGHT = eINSTANCE.getImpliesExpression_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.NotExpressionImpl <em>Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.NotExpressionImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getNotExpression()
     * @generated
     */
    EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_EXPRESSION__PREDICATE = eINSTANCE.getNotExpression_Predicate();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.PlusMinusImpl <em>Plus Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.PlusMinusImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getPlusMinus()
     * @generated
     */
    EClass PLUS_MINUS = eINSTANCE.getPlusMinus();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS_MINUS__LEFT = eINSTANCE.getPlusMinus_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PLUS_MINUS__OP = eINSTANCE.getPlusMinus_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS_MINUS__RIGHT = eINSTANCE.getPlusMinus_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.impl.ModMultDivImpl <em>Mod Mult Div</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.impl.ModMultDivImpl
     * @see citlab.model.citL.impl.CitLPackageImpl#getModMultDiv()
     * @generated
     */
    EClass MOD_MULT_DIV = eINSTANCE.getModMultDiv();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOD_MULT_DIV__LEFT = eINSTANCE.getModMultDiv_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOD_MULT_DIV__OP = eINSTANCE.getModMultDiv_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOD_MULT_DIV__RIGHT = eINSTANCE.getModMultDiv_Right();

    /**
     * The meta object literal for the '{@link citlab.model.citL.Operators <em>Operators</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.Operators
     * @see citlab.model.citL.impl.CitLPackageImpl#getOperators()
     * @generated
     */
    EEnum OPERATORS = eINSTANCE.getOperators();

    /**
     * The meta object literal for the '{@link citlab.model.citL.AndOperators <em>And Operators</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.AndOperators
     * @see citlab.model.citL.impl.CitLPackageImpl#getAndOperators()
     * @generated
     */
    EEnum AND_OPERATORS = eINSTANCE.getAndOperators();

    /**
     * The meta object literal for the '{@link citlab.model.citL.OrOperators <em>Or Operators</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.OrOperators
     * @see citlab.model.citL.impl.CitLPackageImpl#getOrOperators()
     * @generated
     */
    EEnum OR_OPERATORS = eINSTANCE.getOrOperators();

    /**
     * The meta object literal for the '{@link citlab.model.citL.PlusMinusOperators <em>Plus Minus Operators</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.PlusMinusOperators
     * @see citlab.model.citL.impl.CitLPackageImpl#getPlusMinusOperators()
     * @generated
     */
    EEnum PLUS_MINUS_OPERATORS = eINSTANCE.getPlusMinusOperators();

    /**
     * The meta object literal for the '{@link citlab.model.citL.ModMultDivOperators <em>Mod Mult Div Operators</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.ModMultDivOperators
     * @see citlab.model.citL.impl.CitLPackageImpl#getModMultDivOperators()
     * @generated
     */
    EEnum MOD_MULT_DIV_OPERATORS = eINSTANCE.getModMultDivOperators();

    /**
     * The meta object literal for the '{@link citlab.model.citL.ImpliesOperator <em>Implies Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.ImpliesOperator
     * @see citlab.model.citL.impl.CitLPackageImpl#getImpliesOperator()
     * @generated
     */
    EEnum IMPLIES_OPERATOR = eINSTANCE.getImpliesOperator();

    /**
     * The meta object literal for the '{@link citlab.model.citL.BooleanConst <em>Boolean Const</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see citlab.model.citL.BooleanConst
     * @see citlab.model.citL.impl.CitLPackageImpl#getBooleanConst()
     * @generated
     */
    EEnum BOOLEAN_CONST = eINSTANCE.getBooleanConst();

  }

} //CitLPackage
