DB : OS BufferMsgr Storage [DebugLogging] :: _DB ;

OS : NutOS
	| Win ;

BufferMsgr : MemAlloc PageRepl :: Persistent
	| InMemory ;

MemAlloc : Static
	| Dynamic ;

PageRepl : LFU
	| RFU ;

Storage : ApI+ indexing :: _Storage ;

ApI : get
	| put
	| delete ;

indexing : BTree
	| Unindexed ;

