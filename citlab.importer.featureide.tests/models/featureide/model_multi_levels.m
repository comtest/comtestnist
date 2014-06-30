model : A* [B] C+ D [E] F :: _model ;

A : [a11] [a12] :: a1
	| a2+ :: a2_
	| a3 ;

a2 : a21
	| a22 ;

a3 : a31
	| a32 ;

B : b1
	| bn ;

C : c1
	| cn ;

D : d1
	| dn ;

