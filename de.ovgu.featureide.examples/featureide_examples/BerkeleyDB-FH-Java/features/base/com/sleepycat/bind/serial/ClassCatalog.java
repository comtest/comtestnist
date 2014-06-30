package com.sleepycat.bind.serial;
import java.io.ObjectStreamClass;
import com.sleepycat.je.DatabaseException;
import de.ovgu.cide.jakutil.*;
/** 
 * A catalog of class description information for use during object
 * serialization.
 * <p>
 * A catalog is used to store class descriptions separately from serialized
 * objects, to avoid redundantly stored information with each object. When
 * serialized objects are stored in a database, a {@link StoredClassCatalog}should be used.
 * </p>
 * <p>
 * This information is used for serialization of class descriptors or
 * java.io.ObjectStreamClass objects, each of which represents a unique class
 * format. For each unique format, a unique class ID is assigned by the catalog.
 * The class ID can then be used in the serialization stream in place of the
 * full class information. When used with {@link SerialInput} and{@link SerialOutput} or any of the serial bindings, the use of the catalog is
 * transparent to the application.
 * </p>
 * @author Mark Hayes
 */
public interface ClassCatalog {
  /** 
 * Close a catalog database and release any cached resources.
 */
  public void close() throws DatabaseException ;
  /** 
 * Return the class ID for the current version of the given class
 * description. This is used for storing in serialization streams in place
 * of a full class descriptor, since it is much more compact. To get back
 * the ObjectStreamClass for a class ID, call{@link #getClassFormat(byte[])}. This function causes a new class ID to
 * be assigned if the class description has changed.
 * @param classDescThe class description for which to return the class ID.
 * @return The class ID for the current version of the class.
 */
  public byte[] getClassID(  ObjectStreamClass classDesc) throws DatabaseException, ClassNotFoundException ;
  /** 
 * Return the ObjectStreamClass for the given class ID. This may or may not
 * be the current class format, depending on whether the class has changed
 * since the class ID was generated.
 * @param classIDThe class ID for which to return the class format.
 * @return The class format for the given class ID, which may or may not
 * represent the current version of the class.
 */
  public ObjectStreamClass getClassFormat(  byte[] classID) throws DatabaseException, ClassNotFoundException ;
}
