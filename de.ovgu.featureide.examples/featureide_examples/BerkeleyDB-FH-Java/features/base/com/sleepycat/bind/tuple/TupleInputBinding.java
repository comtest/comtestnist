package com.sleepycat.bind.tuple;
import com.sleepycat.bind.EntryBinding;
import com.sleepycat.je.DatabaseEntry;
import de.ovgu.cide.jakutil.*;
/** 
 * A concrete <code>EntryBinding</code> that uses the <code>TupleInput</code>
 * object as the key or data object.
 * A concrete tuple binding for key or data entries which are {@link TupleInput}objects. This binding is used when tuples themselves are the objects, rather
 * than using application defined objects. A {@link TupleInput} must always be
 * used. To convert a {@link TupleOutput} to a {@link TupleInput}, use the{@link TupleInput#TupleInput(TupleOutput)} constructor.
 * @author Mark Hayes
 */
public class TupleInputBinding implements EntryBinding {
  /** 
 * Creates a tuple input binding.
 */
  public TupleInputBinding(){
  }
  public Object entryToObject(  DatabaseEntry entry){
    return TupleBinding.entryToInput(entry);
  }
  public void objectToEntry(  Object object,  DatabaseEntry entry){
    TupleBinding.inputToEntry((TupleInput)object,entry);
  }
}
