

abstract class Num$$BK implements Exp {
   int value;
   Num$$BK(int val) { 
   	value =  val; 
   }

}

abstract class Num$$BE extends  Num$$BK  {
	public int eval() { 
		return value; 
	}
      // inherited constructors


   Num$$BE ( int val ) { super(val); }
}

public class Num extends  Num$$BE  {
	
	public String toString() { 
		return ""+ value; 
	}
      // inherited constructors


   Num ( int val ) { super(val); }

}