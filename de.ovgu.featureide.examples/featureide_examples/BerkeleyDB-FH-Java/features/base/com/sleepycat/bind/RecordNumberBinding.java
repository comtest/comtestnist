package com.sleepycat.bind;
import com.sleepycat.compat.DbCompat;
import com.sleepycat.je.DatabaseEntry;
import de.ovgu.cide.jakutil.*;
/** 
 * An <code>EntryBinding</code> that treats a record number key entry as a
 * <code>Long</code> key object.
 * <p>
 * Record numbers are returned as <code>Long</code> objects, although on input
 * any <code>Number</code> object may be used.
 * </p>
 * @author Mark Hayes
 */
public class RecordNumberBinding implements EntryBinding {
  /** 
 * Creates a byte array binding.
 */
  public RecordNumberBinding(){
  }
  public Object entryToObject(  DatabaseEntry entry){
    return new Long(entryToRecordNumber(entry));
  }
  public void objectToEntry(  Object object,  DatabaseEntry entry){
    recordNumberToEntry(((Number)object).longValue(),entry);
  }
  /** 
 * Utility method for use by bindings to translate a entry buffer to an
 * record number integer.
 * @param entrythe entry buffer.
 * @return the record number.
 */
  public static long entryToRecordNumber(  DatabaseEntry entry){
    return DbCompat.getRecordNumber(entry) & 0xFFFFFFFFL;
  }
  /** 
 * Utility method for use by bindings to translate a record number integer
 * to a entry buffer.
 * @param recordNumberthe record number.
 * @param entrythe entry buffer to hold the record number.
 */
  public static void recordNumberToEntry(  long recordNumber,  DatabaseEntry entry){
    entry.setData(new byte[4],0,4);
    DbCompat.setRecordNumber(entry,(int)recordNumber);
  }
}
