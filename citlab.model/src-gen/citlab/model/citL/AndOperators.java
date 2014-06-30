/**
 */
package citlab.model.citL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>And Operators</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see citlab.model.citL.CitLPackage#getAndOperators()
 * @model
 * @generated
 */
public enum AndOperators implements Enumerator
{
  /**
   * The '<em><b>And</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AND_VALUE
   * @generated
   * @ordered
   */
  AND(0, "and", "&&"),

  /**
   * The '<em><b>Andmi</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ANDMI_VALUE
   * @generated
   * @ordered
   */
  ANDMI(1, "andmi", "and"),

  /**
   * The '<em><b>AN Dma</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AN_DMA_VALUE
   * @generated
   * @ordered
   */
  AN_DMA(2, "ANDma", "AND");

  /**
   * The '<em><b>And</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>And</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AND
   * @model name="and" literal="&&"
   * @generated
   * @ordered
   */
  public static final int AND_VALUE = 0;

  /**
   * The '<em><b>Andmi</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Andmi</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ANDMI
   * @model name="andmi" literal="and"
   * @generated
   * @ordered
   */
  public static final int ANDMI_VALUE = 1;

  /**
   * The '<em><b>AN Dma</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AN Dma</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AN_DMA
   * @model name="ANDma" literal="AND"
   * @generated
   * @ordered
   */
  public static final int AN_DMA_VALUE = 2;

  /**
   * An array of all the '<em><b>And Operators</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AndOperators[] VALUES_ARRAY =
    new AndOperators[]
    {
      AND,
      ANDMI,
      AN_DMA,
    };

  /**
   * A public read-only list of all the '<em><b>And Operators</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AndOperators> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>And Operators</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AndOperators get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AndOperators result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>And Operators</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AndOperators getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AndOperators result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>And Operators</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AndOperators get(int value)
  {
    switch (value)
    {
      case AND_VALUE: return AND;
      case ANDMI_VALUE: return ANDMI;
      case AN_DMA_VALUE: return AN_DMA;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private AndOperators(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
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
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //AndOperators
