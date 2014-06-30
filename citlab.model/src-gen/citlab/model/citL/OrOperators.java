/**
 */
package citlab.model.citL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Or Operators</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see citlab.model.citL.CitLPackage#getOrOperators()
 * @model
 * @generated
 */
public enum OrOperators implements Enumerator
{
  /**
   * The '<em><b>Or</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OR_VALUE
   * @generated
   * @ordered
   */
  OR(0, "or", "||"),

  /**
   * The '<em><b>Ormi</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ORMI_VALUE
   * @generated
   * @ordered
   */
  ORMI(1, "ormi", "or"),

  /**
   * The '<em><b>ORma</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ORMA_VALUE
   * @generated
   * @ordered
   */
  ORMA(2, "ORma", "OR");

  /**
   * The '<em><b>Or</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Or</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OR
   * @model name="or" literal="||"
   * @generated
   * @ordered
   */
  public static final int OR_VALUE = 0;

  /**
   * The '<em><b>Ormi</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Ormi</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ORMI
   * @model name="ormi" literal="or"
   * @generated
   * @ordered
   */
  public static final int ORMI_VALUE = 1;

  /**
   * The '<em><b>ORma</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ORma</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ORMA
   * @model name="ORma" literal="OR"
   * @generated
   * @ordered
   */
  public static final int ORMA_VALUE = 2;

  /**
   * An array of all the '<em><b>Or Operators</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final OrOperators[] VALUES_ARRAY =
    new OrOperators[]
    {
      OR,
      ORMI,
      ORMA,
    };

  /**
   * A public read-only list of all the '<em><b>Or Operators</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<OrOperators> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Or Operators</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static OrOperators get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      OrOperators result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Or Operators</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static OrOperators getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      OrOperators result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Or Operators</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static OrOperators get(int value)
  {
    switch (value)
    {
      case OR_VALUE: return OR;
      case ORMI_VALUE: return ORMI;
      case ORMA_VALUE: return ORMA;
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
  private OrOperators(int value, String name, String literal)
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
  
} //OrOperators
