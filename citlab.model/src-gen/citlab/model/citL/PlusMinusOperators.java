/**
 */
package citlab.model.citL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Plus Minus Operators</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see citlab.model.citL.CitLPackage#getPlusMinusOperators()
 * @model
 * @generated
 */
public enum PlusMinusOperators implements Enumerator
{
  /**
   * The '<em><b>Plus</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PLUS_VALUE
   * @generated
   * @ordered
   */
  PLUS(0, "Plus", "+"),

  /**
   * The '<em><b>Minus</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MINUS_VALUE
   * @generated
   * @ordered
   */
  MINUS(1, "Minus", "-");

  /**
   * The '<em><b>Plus</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Plus</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PLUS
   * @model name="Plus" literal="+"
   * @generated
   * @ordered
   */
  public static final int PLUS_VALUE = 0;

  /**
   * The '<em><b>Minus</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Minus</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MINUS
   * @model name="Minus" literal="-"
   * @generated
   * @ordered
   */
  public static final int MINUS_VALUE = 1;

  /**
   * An array of all the '<em><b>Plus Minus Operators</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final PlusMinusOperators[] VALUES_ARRAY =
    new PlusMinusOperators[]
    {
      PLUS,
      MINUS,
    };

  /**
   * A public read-only list of all the '<em><b>Plus Minus Operators</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<PlusMinusOperators> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Plus Minus Operators</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PlusMinusOperators get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PlusMinusOperators result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Plus Minus Operators</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PlusMinusOperators getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PlusMinusOperators result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Plus Minus Operators</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PlusMinusOperators get(int value)
  {
    switch (value)
    {
      case PLUS_VALUE: return PLUS;
      case MINUS_VALUE: return MINUS;
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
  private PlusMinusOperators(int value, String name, String literal)
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
  
} //PlusMinusOperators
