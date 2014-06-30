

abstract class Neg$$NK implements Exp {
	Exp x;
	Neg$$NK( Exp x ) { 
		this.x = x; 
	}

}

abstract class Neg$$NE extends  Neg$$NK  {
	public int eval() { 
		return - x.eval(); 
	}
      // inherited constructors


	Neg$$NE (  Exp x ) { super(x); }
}

public class Neg extends  Neg$$NE  {
	public String toString() {  
		return  " -(" + x + ") "; 
	}
      // inherited constructors


	Neg (  Exp x ) { super(x); }

}