

abstract class Plus$$PK implements Exp {   
	Exp x;   
	Exp y;   
	Plus$$PK( Exp x, Exp y ) { 
		this.x = x; 
		this.y = y; 
	}

}

abstract class Plus$$PE extends  Plus$$PK  {
	public int eval() { 
		return x.eval() + y.eval(); 
	}
      // inherited constructors

   
	Plus$$PE (  Exp x, Exp y ) { super(x, y); }

}

public class Plus extends  Plus$$PE  {
	public String toString() { 
		return x + " + " + y ; 
	}
      // inherited constructors

   
	Plus (  Exp x, Exp y ) { super(x, y); }
}