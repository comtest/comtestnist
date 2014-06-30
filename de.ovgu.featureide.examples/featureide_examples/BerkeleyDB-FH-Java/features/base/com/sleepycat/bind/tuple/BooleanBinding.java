package com.sleepycat.bind.tuple;
import com.sleepycat.je.DatabaseEntry;
import de.ovgu.cide.jakutil.*;
/** 
 * A concrete <code>TupleBinding</code> for a <code>Boolean</code> primitive
 * wrapper or a <code>boolean</code> primitive.
 * <p>
 * There are two ways to use this class:
 * </p>
 * <ol>
 * <li>When using the {@link com.sleepycat.je} package directly, the static
 * methods in this class can be used to convert between primitive values and{@link DatabaseEntry} objects.</li>
 * <li>When using the {@link com.sleepycat.collections} package, an instance of
 * this class can be used with any stored collection. The easiest way to obtain
 * a binding instance is with the {@link TupleBinding#getPrimitiveBinding}method.</li>
 * </ol>
 */
public class BooleanBinding extends TupleBinding {
  private static final int BOOLEAN_SIZE=1;
  public Object entryToObject(  TupleInput input){
    return input.readBoolean() ? Boolean.TRUE : Boolean.FALSE;
  }
  public void objectToEntry(  Object object,  TupleOutput output){
    output.writeBoolean(((Boolean)object).booleanValue());
  }
  protected TupleOutput getTupleOutput(  Object object){
    return sizedOutput();
  }
  /** 
 * Converts an entry buffer into a simple <code>boolean</code> value.
 * @param entryis the source entry buffer.
 * @return the resulting value.
 */
  public static boolean entryToBoolean(  DatabaseEntry entry){
    return entryToInput(entry).readBoolean();
  }
  /** 
 * Converts a simple <code>boolean</code> value into an entry buffer.
 * @param valis the source value.
 * @param entryis the destination entry buffer.
 */
  public static void booleanToEntry(  boolean val,  DatabaseEntry entry){
    outputToEntry(sizedOutput().writeBoolean(val),entry);
  }
  /** 
 * Returns a tuple output object of the exact size needed, to avoid wasting
 * space when a single primitive is output.
 */
  private static TupleOutput sizedOutput(){
    return new TupleOutput(new byte[BOOLEAN_SIZE]);
  }
}
