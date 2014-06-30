

abstract class Test$$CK {
	static Exp e;
	public static void main(String args[]){
		
	}
}

abstract class Test$$CE extends  Test$$CK  {
	public static void main(String args[]) {
     Test$$CK.main(args);
     Test.evaltest();
   }

   static void evaltest(){}
}

abstract class Test$$CP extends  Test$$CE  {
	
	public static void main(String args[]) {
     Test.printtest();
     Test$$CE.main(args);
   }

   static void printtest(){}

}

abstract class Test$$BE extends  Test$$CP  {
	 public static void evaltest() {
	 	Test$$CP.evaltest();
	 	e = new Num(1);
	 	System.out.println( "eval(1) = " + e.eval());
	 }

}

abstract class Test$$BP extends  Test$$BE  {
	public static void printtest() {
		Test$$BE.printtest();
		e = new Num(3);
		System.out.println( "print(3) = " + e );
	}
}

abstract class Test$$NE extends  Test$$BP  {
	public static void evaltest() {
		Test$$BP.evaltest();      
		e = new Neg( new Num(1));      
		System.out.println( "eval(Neg(1)) = " + e.eval());
	}

}

abstract class Test$$NP extends  Test$$NE  {
	public static void printtest() {      
		Test$$NE.printtest();      
		e  = new Neg( new Num(5) );      
		System.out.println( "print(Neg(5)) = " + e );   
	}

}

abstract class Test$$PE extends  Test$$NP  {
	public static void evaltest() {      
		Test$$NP.evaltest();      
		e = new Plus( new Num(1), new Num(2));      
		System.out.println("eval(1+2)="+ e.eval());   
	}

}

public class Test extends  Test$$PE  {
	public static void printtest() {
      Test$$PE.printtest();
      e  = new Plus( new Num(5), new Num(7));
      System.out.println( "print(5+7) = " + e );
   }
}