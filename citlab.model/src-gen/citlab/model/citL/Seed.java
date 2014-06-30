/**
 */
package citlab.model.citL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Seed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link citlab.model.citL.Seed#getAssigmentSeedList <em>Assigment Seed List</em>}</li>
 * </ul>
 * </p>
 *
 * @see citlab.model.citL.CitLPackage#getSeed()
 * @model
 * @generated
 */
public interface Seed extends EObject
{
  /**
   * Returns the value of the '<em><b>Assigment Seed List</b></em>' containment reference list.
   * The list contents are of type {@link citlab.model.citL.Aseed}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assigment Seed List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assigment Seed List</em>' containment reference list.
   * @see citlab.model.citL.CitLPackage#getSeed_AssigmentSeedList()
   * @model containment="true"
   * @generated
   */
  EList<Aseed> getAssigmentSeedList();

} // Seed
