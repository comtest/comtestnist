package com.sleepycat.bind.tuple;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.ForeignKeyNullifier;
import com.sleepycat.je.SecondaryDatabase;
import com.sleepycat.je.SecondaryKeyCreator;
import de.ovgu.cide.jakutil.*;
/** 
 * An abstract key creator that uses a tuple key and a tuple data entry. This
 * class takes care of converting the key and data entry to/from {@link TupleInput} and {@link TupleOutput} objects. The following abstract method
 * must be implemented by a concrete subclass to create the index key using
 * these objects
 * <ul>
 * <li> {@link #createSecondaryKey(TupleInput,TupleInput,TupleOutput)} </li>
 * </ul>
 * <!-- begin JE only -->
 * <p>
 * If {@link com.sleepycat.je.ForeignKeyDeleteAction#NULLIFY} was specified when
 * opening the secondary database, the following method must be overridden to
 * nullify the foreign index key. If NULLIFY was not specified, this method need
 * not be overridden.
 * </p>
 * <ul>
 * <li> {@link #nullifyForeignKey(TupleInput,TupleOutput)} </li>
 * </ul>
 * <p>
 * If {@link com.sleepycat.je.ForeignKeyDeleteAction#NULLIFY} was specified when
 * creating the secondary, this method is called when the entity for this
 * foreign key is deleted. If NULLIFY was not specified, this method will not be
 * called and may always return false.
 * </p>
 * <!-- end JE only -->
 * @author Mark Hayes
 */
public abstract class TupleTupleKeyCreator extends TupleBase implements SecondaryKeyCreator, ForeignKeyNullifier {
  /** 
 * Creates a tuple-tuple key creator.
 */
  public TupleTupleKeyCreator(){
  }
  public boolean createSecondaryKey(  SecondaryDatabase db,  DatabaseEntry primaryKeyEntry,  DatabaseEntry dataEntry,  DatabaseEntry indexKeyEntry) throws DatabaseException {
    TupleOutput output=getTupleOutput(null);
    TupleInput primaryKeyInput=entryToInput(primaryKeyEntry);
    TupleInput dataInput=entryToInput(dataEntry);
    if (createSecondaryKey(primaryKeyInput,dataInput,output)) {
      outputToEntry(output,indexKeyEntry);
      return true;
    }
 else {
      return false;
    }
  }
  public boolean nullifyForeignKey(  SecondaryDatabase db,  DatabaseEntry dataEntry) throws DatabaseException {
    TupleOutput output=getTupleOutput(null);
    if (nullifyForeignKey(entryToInput(dataEntry),output)) {
      outputToEntry(output,dataEntry);
      return true;
    }
 else {
      return false;
    }
  }
  /** 
 * Creates the index key from primary key tuple and data tuple.
 * @param primaryKeyInputis the {@link TupleInput} for the primary key entry.
 * @param dataInputis the {@link TupleInput} for the data entry.
 * @param indexKeyOutputis the destination index key tuple.
 * @return true if a key was created, or false to indicate that the key is
 * not present.
 */
  public abstract boolean createSecondaryKey(  TupleInput primaryKeyInput,  TupleInput dataInput,  TupleOutput indexKeyOutput);
  /** 
 * Clears the index key in the tuple data entry. The dataInput should be
 * read and then written to the dataOutput, clearing the index key in the
 * process.
 * <p>
 * The secondary key should be output or removed by this method such that{@link #createSecondaryKey} will return false. Other fields in the data
 * object should remain unchanged.
 * </p>
 * @param dataInputis the {@link TupleInput} for the data entry.
 * @param dataOutputis the destination {@link TupleOutput}.
 * @return true if the key was cleared, or false to indicate that the key is
 * not present and no change is necessary.
 */
  public boolean nullifyForeignKey(  TupleInput dataInput,  TupleOutput dataOutput){
    return false;
  }
}
