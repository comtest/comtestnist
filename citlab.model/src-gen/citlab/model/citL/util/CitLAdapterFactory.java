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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see citlab.model.citL.CitLPackage
 * @generated
 */
public class CitLAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CitLPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CitLAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = CitLPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CitLSwitch<Adapter> modelSwitch =
    new CitLSwitch<Adapter>()
    {
      @Override
      public Adapter caseCitModel(CitModel object)
      {
        return createCitModelAdapter();
      }
      @Override
      public Adapter caseConstant(Constant object)
      {
        return createConstantAdapter();
      }
      @Override
      public Adapter caseConstantNumber(ConstantNumber object)
      {
        return createConstantNumberAdapter();
      }
      @Override
      public Adapter caseParameter(Parameter object)
      {
        return createParameterAdapter();
      }
      @Override
      public Adapter caseParametersEx(ParametersEx object)
      {
        return createParametersExAdapter();
      }
      @Override
      public Adapter caseNumericalEx(NumericalEx object)
      {
        return createNumericalExAdapter();
      }
      @Override
      public Adapter caseNumerical(Numerical object)
      {
        return createNumericalAdapter();
      }
      @Override
      public Adapter caseEnumerativeType(EnumerativeType object)
      {
        return createEnumerativeTypeAdapter();
      }
      @Override
      public Adapter caseNamedType(NamedType object)
      {
        return createNamedTypeAdapter();
      }
      @Override
      public Adapter caseAnonymousType(AnonymousType object)
      {
        return createAnonymousTypeAdapter();
      }
      @Override
      public Adapter caseEnumerative(Enumerative object)
      {
        return createEnumerativeAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseBoolean(citlab.model.citL.Boolean object)
      {
        return createBooleanAdapter();
      }
      @Override
      public Adapter caseNumbers(Numbers object)
      {
        return createNumbersAdapter();
      }
      @Override
      public Adapter caseRange(Range object)
      {
        return createRangeAdapter();
      }
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseAtomicPredicate(AtomicPredicate object)
      {
        return createAtomicPredicateAdapter();
      }
      @Override
      public Adapter caseBoolAssign(BoolAssign object)
      {
        return createBoolAssignAdapter();
      }
      @Override
      public Adapter caseEnumAssign(EnumAssign object)
      {
        return createEnumAssignAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseNumberLiteral(NumberLiteral object)
      {
        return createNumberLiteralAdapter();
      }
      @Override
      public Adapter caseSeed(Seed object)
      {
        return createSeedAdapter();
      }
      @Override
      public Adapter caseAseed(Aseed object)
      {
        return createAseedAdapter();
      }
      @Override
      public Adapter caseSeedNumberLiteral(SeedNumberLiteral object)
      {
        return createSeedNumberLiteralAdapter();
      }
      @Override
      public Adapter caseEnumSeed(EnumSeed object)
      {
        return createEnumSeedAdapter();
      }
      @Override
      public Adapter caseNumericalSeed(NumericalSeed object)
      {
        return createNumericalSeedAdapter();
      }
      @Override
      public Adapter caseBoolAssignSeed(BoolAssignSeed object)
      {
        return createBoolAssignSeedAdapter();
      }
      @Override
      public Adapter caseOrExpression(OrExpression object)
      {
        return createOrExpressionAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseImpliesExpression(ImpliesExpression object)
      {
        return createImpliesExpressionAdapter();
      }
      @Override
      public Adapter caseNotExpression(NotExpression object)
      {
        return createNotExpressionAdapter();
      }
      @Override
      public Adapter casePlusMinus(PlusMinus object)
      {
        return createPlusMinusAdapter();
      }
      @Override
      public Adapter caseModMultDiv(ModMultDiv object)
      {
        return createModMultDivAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.CitModel <em>Cit Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.CitModel
   * @generated
   */
  public Adapter createCitModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Constant
   * @generated
   */
  public Adapter createConstantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.ConstantNumber <em>Constant Number</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.ConstantNumber
   * @generated
   */
  public Adapter createConstantNumberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Parameter
   * @generated
   */
  public Adapter createParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.ParametersEx <em>Parameters Ex</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.ParametersEx
   * @generated
   */
  public Adapter createParametersExAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.NumericalEx <em>Numerical Ex</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.NumericalEx
   * @generated
   */
  public Adapter createNumericalExAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Numerical <em>Numerical</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Numerical
   * @generated
   */
  public Adapter createNumericalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.EnumerativeType <em>Enumerative Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.EnumerativeType
   * @generated
   */
  public Adapter createEnumerativeTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.NamedType <em>Named Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.NamedType
   * @generated
   */
  public Adapter createNamedTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.AnonymousType <em>Anonymous Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.AnonymousType
   * @generated
   */
  public Adapter createAnonymousTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Enumerative <em>Enumerative</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Enumerative
   * @generated
   */
  public Adapter createEnumerativeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Boolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Boolean
   * @generated
   */
  public Adapter createBooleanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Numbers <em>Numbers</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Numbers
   * @generated
   */
  public Adapter createNumbersAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Range
   * @generated
   */
  public Adapter createRangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Rule
   * @generated
   */
  public Adapter createRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.AtomicPredicate <em>Atomic Predicate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.AtomicPredicate
   * @generated
   */
  public Adapter createAtomicPredicateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.BoolAssign <em>Bool Assign</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.BoolAssign
   * @generated
   */
  public Adapter createBoolAssignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.EnumAssign <em>Enum Assign</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.EnumAssign
   * @generated
   */
  public Adapter createEnumAssignAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.NumberLiteral <em>Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.NumberLiteral
   * @generated
   */
  public Adapter createNumberLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Seed <em>Seed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Seed
   * @generated
   */
  public Adapter createSeedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.Aseed <em>Aseed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.Aseed
   * @generated
   */
  public Adapter createAseedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.SeedNumberLiteral <em>Seed Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.SeedNumberLiteral
   * @generated
   */
  public Adapter createSeedNumberLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.EnumSeed <em>Enum Seed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.EnumSeed
   * @generated
   */
  public Adapter createEnumSeedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.NumericalSeed <em>Numerical Seed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.NumericalSeed
   * @generated
   */
  public Adapter createNumericalSeedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.BoolAssignSeed <em>Bool Assign Seed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.BoolAssignSeed
   * @generated
   */
  public Adapter createBoolAssignSeedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.OrExpression
   * @generated
   */
  public Adapter createOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.ImpliesExpression <em>Implies Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.ImpliesExpression
   * @generated
   */
  public Adapter createImpliesExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.NotExpression <em>Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.NotExpression
   * @generated
   */
  public Adapter createNotExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.PlusMinus <em>Plus Minus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.PlusMinus
   * @generated
   */
  public Adapter createPlusMinusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link citlab.model.citL.ModMultDiv <em>Mod Mult Div</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see citlab.model.citL.ModMultDiv
   * @generated
   */
  public Adapter createModMultDivAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //CitLAdapterFactory
