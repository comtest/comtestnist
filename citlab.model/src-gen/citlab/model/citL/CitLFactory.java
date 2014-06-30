/**
 */
package citlab.model.citL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see citlab.model.citL.CitLPackage
 * @generated
 */
public interface CitLFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CitLFactory eINSTANCE = citlab.model.citL.impl.CitLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Cit Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cit Model</em>'.
   * @generated
   */
  CitModel createCitModel();

  /**
   * Returns a new object of class '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant</em>'.
   * @generated
   */
  Constant createConstant();

  /**
   * Returns a new object of class '<em>Constant Number</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Number</em>'.
   * @generated
   */
  ConstantNumber createConstantNumber();

  /**
   * Returns a new object of class '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter</em>'.
   * @generated
   */
  Parameter createParameter();

  /**
   * Returns a new object of class '<em>Parameters Ex</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameters Ex</em>'.
   * @generated
   */
  ParametersEx createParametersEx();

  /**
   * Returns a new object of class '<em>Numerical Ex</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Ex</em>'.
   * @generated
   */
  NumericalEx createNumericalEx();

  /**
   * Returns a new object of class '<em>Numerical</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical</em>'.
   * @generated
   */
  Numerical createNumerical();

  /**
   * Returns a new object of class '<em>Enumerative Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumerative Type</em>'.
   * @generated
   */
  EnumerativeType createEnumerativeType();

  /**
   * Returns a new object of class '<em>Named Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Type</em>'.
   * @generated
   */
  NamedType createNamedType();

  /**
   * Returns a new object of class '<em>Anonymous Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous Type</em>'.
   * @generated
   */
  AnonymousType createAnonymousType();

  /**
   * Returns a new object of class '<em>Enumerative</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumerative</em>'.
   * @generated
   */
  Enumerative createEnumerative();

  /**
   * Returns a new object of class '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element</em>'.
   * @generated
   */
  Element createElement();

  /**
   * Returns a new object of class '<em>Boolean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean</em>'.
   * @generated
   */
  Boolean createBoolean();

  /**
   * Returns a new object of class '<em>Numbers</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numbers</em>'.
   * @generated
   */
  Numbers createNumbers();

  /**
   * Returns a new object of class '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range</em>'.
   * @generated
   */
  Range createRange();

  /**
   * Returns a new object of class '<em>Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule</em>'.
   * @generated
   */
  Rule createRule();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Atomic Predicate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Atomic Predicate</em>'.
   * @generated
   */
  AtomicPredicate createAtomicPredicate();

  /**
   * Returns a new object of class '<em>Bool Assign</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Assign</em>'.
   * @generated
   */
  BoolAssign createBoolAssign();

  /**
   * Returns a new object of class '<em>Enum Assign</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Assign</em>'.
   * @generated
   */
  EnumAssign createEnumAssign();

  /**
   * Returns a new object of class '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression</em>'.
   * @generated
   */
  RelationalExpression createRelationalExpression();

  /**
   * Returns a new object of class '<em>Number Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number Literal</em>'.
   * @generated
   */
  NumberLiteral createNumberLiteral();

  /**
   * Returns a new object of class '<em>Seed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Seed</em>'.
   * @generated
   */
  Seed createSeed();

  /**
   * Returns a new object of class '<em>Aseed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Aseed</em>'.
   * @generated
   */
  Aseed createAseed();

  /**
   * Returns a new object of class '<em>Seed Number Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Seed Number Literal</em>'.
   * @generated
   */
  SeedNumberLiteral createSeedNumberLiteral();

  /**
   * Returns a new object of class '<em>Enum Seed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Seed</em>'.
   * @generated
   */
  EnumSeed createEnumSeed();

  /**
   * Returns a new object of class '<em>Numerical Seed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Seed</em>'.
   * @generated
   */
  NumericalSeed createNumericalSeed();

  /**
   * Returns a new object of class '<em>Bool Assign Seed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Assign Seed</em>'.
   * @generated
   */
  BoolAssignSeed createBoolAssignSeed();

  /**
   * Returns a new object of class '<em>Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Or Expression</em>'.
   * @generated
   */
  OrExpression createOrExpression();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>Implies Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Implies Expression</em>'.
   * @generated
   */
  ImpliesExpression createImpliesExpression();

  /**
   * Returns a new object of class '<em>Not Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Not Expression</em>'.
   * @generated
   */
  NotExpression createNotExpression();

  /**
   * Returns a new object of class '<em>Plus Minus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plus Minus</em>'.
   * @generated
   */
  PlusMinus createPlusMinus();

  /**
   * Returns a new object of class '<em>Mod Mult Div</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mod Mult Div</em>'.
   * @generated
   */
  ModMultDiv createModMultDiv();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CitLPackage getCitLPackage();

} //CitLFactory
