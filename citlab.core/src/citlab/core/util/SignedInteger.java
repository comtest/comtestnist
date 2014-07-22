package citlab.core.util;


/** represents an integer with a sign
 * 
 * @author garganti
 *
 */
final public class SignedInteger{
	Integer value;
	Boolean negative; // true if it is to be intended negative  
	private SignedInteger(boolean neg, Integer val){
		// cannot be negative, can be 0
		assert val >= 0;
		value = val;
		negative = neg;
		
	}
	static SignedInteger mkPos(int val){ return new SignedInteger(false, val);}
	static SignedInteger mkNeg(int val){ return new SignedInteger(true, val);}	
	
	public boolean isNegative(){return negative;}
	public Integer getValue() {return value;}
	
	@Override
	public String toString() {
		throw new RuntimeException("do not use this");
	}
}