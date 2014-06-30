

abstract interface Exp$$CK {

}

abstract interface Exp$$CE extends Exp$$CK {
	
	int eval();

}

public interface Exp extends Exp$$CE {
	String toString();

}