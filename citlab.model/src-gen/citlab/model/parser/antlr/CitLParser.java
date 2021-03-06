/*
* generated by Xtext
*/
package citlab.model.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import citlab.model.services.CitLGrammarAccess;

public class CitLParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private CitLGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected citlab.model.parser.antlr.internal.InternalCitLParser createParser(XtextTokenStream stream) {
		return new citlab.model.parser.antlr.internal.InternalCitLParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "CitModel";
	}
	
	public CitLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CitLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
