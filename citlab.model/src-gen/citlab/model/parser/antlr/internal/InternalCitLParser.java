package citlab.model.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import citlab.model.services.CitLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalCitLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_NUMID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Model'", "'Definitions:'", "'end'", "'Types:'", "'Parameters:'", "'Constraints:'", "'Seeds:'", "'TestGoals:'", "'Number'", "'='", "';'", "'EnumerativeType'", "'{'", "'}'", "'Enumerative'", "':'", "'Boolean'", "'Numbers'", "'Range'", "'['", "'..'", "']'", "'step'", "'#'", "'('", "')'", "'!'", "'not'", "','", "'.'", "'-'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'and'", "'AND'", "'||'", "'or'", "'OR'", "'+'", "'%'", "'*'", "'/'", "'=>'", "'<=>'", "'false'", "'true'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int RULE_NUMID=6;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=7;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalCitLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCitLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCitLParser.tokenNames; }
    public String getGrammarFileName() { return "../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g"; }



     	private CitLGrammarAccess grammarAccess;
     	
        public InternalCitLParser(TokenStream input, CitLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "CitModel";	
       	}
       	
       	@Override
       	protected CitLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleCitModel"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:68:1: entryRuleCitModel returns [EObject current=null] : iv_ruleCitModel= ruleCitModel EOF ;
    public final EObject entryRuleCitModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCitModel = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:69:2: (iv_ruleCitModel= ruleCitModel EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:70:2: iv_ruleCitModel= ruleCitModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCitModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCitModel_in_entryRuleCitModel75);
            iv_ruleCitModel=ruleCitModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCitModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCitModel85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCitModel"


    // $ANTLR start "ruleCitModel"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:77:1: ruleCitModel returns [EObject current=null] : ( () otherlv_1= 'Model' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'Definitions:' ( (lv_definitions_4_0= ruleConstant ) )+ otherlv_5= 'end' )? (otherlv_6= 'Types:' ( (lv_Types_7_0= ruleNamedType ) )+ otherlv_8= 'end' )? otherlv_9= 'Parameters:' ( (lv_parameters_10_0= ruleParameter ) )+ otherlv_11= 'end' (otherlv_12= 'Constraints:' ( (lv_constraints_13_0= ruleRule ) )+ otherlv_14= 'end' )? (otherlv_15= 'Seeds:' ( (lv_seeds_16_0= ruleSeed ) )+ otherlv_17= 'end' )? (otherlv_18= 'TestGoals:' ( (lv_testGoals_19_0= ruleRule ) )+ otherlv_20= 'end' )? ) ;
    public final EObject ruleCitModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_definitions_4_0 = null;

        EObject lv_Types_7_0 = null;

        EObject lv_parameters_10_0 = null;

        EObject lv_constraints_13_0 = null;

        EObject lv_seeds_16_0 = null;

        EObject lv_testGoals_19_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:80:28: ( ( () otherlv_1= 'Model' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'Definitions:' ( (lv_definitions_4_0= ruleConstant ) )+ otherlv_5= 'end' )? (otherlv_6= 'Types:' ( (lv_Types_7_0= ruleNamedType ) )+ otherlv_8= 'end' )? otherlv_9= 'Parameters:' ( (lv_parameters_10_0= ruleParameter ) )+ otherlv_11= 'end' (otherlv_12= 'Constraints:' ( (lv_constraints_13_0= ruleRule ) )+ otherlv_14= 'end' )? (otherlv_15= 'Seeds:' ( (lv_seeds_16_0= ruleSeed ) )+ otherlv_17= 'end' )? (otherlv_18= 'TestGoals:' ( (lv_testGoals_19_0= ruleRule ) )+ otherlv_20= 'end' )? ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:81:1: ( () otherlv_1= 'Model' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'Definitions:' ( (lv_definitions_4_0= ruleConstant ) )+ otherlv_5= 'end' )? (otherlv_6= 'Types:' ( (lv_Types_7_0= ruleNamedType ) )+ otherlv_8= 'end' )? otherlv_9= 'Parameters:' ( (lv_parameters_10_0= ruleParameter ) )+ otherlv_11= 'end' (otherlv_12= 'Constraints:' ( (lv_constraints_13_0= ruleRule ) )+ otherlv_14= 'end' )? (otherlv_15= 'Seeds:' ( (lv_seeds_16_0= ruleSeed ) )+ otherlv_17= 'end' )? (otherlv_18= 'TestGoals:' ( (lv_testGoals_19_0= ruleRule ) )+ otherlv_20= 'end' )? )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:81:1: ( () otherlv_1= 'Model' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'Definitions:' ( (lv_definitions_4_0= ruleConstant ) )+ otherlv_5= 'end' )? (otherlv_6= 'Types:' ( (lv_Types_7_0= ruleNamedType ) )+ otherlv_8= 'end' )? otherlv_9= 'Parameters:' ( (lv_parameters_10_0= ruleParameter ) )+ otherlv_11= 'end' (otherlv_12= 'Constraints:' ( (lv_constraints_13_0= ruleRule ) )+ otherlv_14= 'end' )? (otherlv_15= 'Seeds:' ( (lv_seeds_16_0= ruleSeed ) )+ otherlv_17= 'end' )? (otherlv_18= 'TestGoals:' ( (lv_testGoals_19_0= ruleRule ) )+ otherlv_20= 'end' )? )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:81:2: () otherlv_1= 'Model' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'Definitions:' ( (lv_definitions_4_0= ruleConstant ) )+ otherlv_5= 'end' )? (otherlv_6= 'Types:' ( (lv_Types_7_0= ruleNamedType ) )+ otherlv_8= 'end' )? otherlv_9= 'Parameters:' ( (lv_parameters_10_0= ruleParameter ) )+ otherlv_11= 'end' (otherlv_12= 'Constraints:' ( (lv_constraints_13_0= ruleRule ) )+ otherlv_14= 'end' )? (otherlv_15= 'Seeds:' ( (lv_seeds_16_0= ruleSeed ) )+ otherlv_17= 'end' )? (otherlv_18= 'TestGoals:' ( (lv_testGoals_19_0= ruleRule ) )+ otherlv_20= 'end' )?
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:81:2: ()
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:82:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCitModelAccess().getCitModelAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCitModel131); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCitModelAccess().getModelKeyword_1());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:91:1: ( (lv_name_2_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:92:1: (lv_name_2_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:92:1: (lv_name_2_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:93:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCitModel148); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getCitModelAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCitModelRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:109:2: (otherlv_3= 'Definitions:' ( (lv_definitions_4_0= ruleConstant ) )+ otherlv_5= 'end' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:109:4: otherlv_3= 'Definitions:' ( (lv_definitions_4_0= ruleConstant ) )+ otherlv_5= 'end'
                    {
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCitModel166); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCitModelAccess().getDefinitionsKeyword_3_0());
                          
                    }
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:113:1: ( (lv_definitions_4_0= ruleConstant ) )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==20) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:114:1: (lv_definitions_4_0= ruleConstant )
                    	    {
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:114:1: (lv_definitions_4_0= ruleConstant )
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:115:3: lv_definitions_4_0= ruleConstant
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCitModelAccess().getDefinitionsConstantParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleConstant_in_ruleCitModel187);
                    	    lv_definitions_4_0=ruleConstant();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCitModelRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"definitions",
                    	              		lv_definitions_4_0, 
                    	              		"Constant");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);

                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCitModel200); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCitModelAccess().getEndKeyword_3_2());
                          
                    }

                    }
                    break;

            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:135:3: (otherlv_6= 'Types:' ( (lv_Types_7_0= ruleNamedType ) )+ otherlv_8= 'end' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:135:5: otherlv_6= 'Types:' ( (lv_Types_7_0= ruleNamedType ) )+ otherlv_8= 'end'
                    {
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleCitModel215); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCitModelAccess().getTypesKeyword_4_0());
                          
                    }
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:139:1: ( (lv_Types_7_0= ruleNamedType ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==23) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:140:1: (lv_Types_7_0= ruleNamedType )
                    	    {
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:140:1: (lv_Types_7_0= ruleNamedType )
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:141:3: lv_Types_7_0= ruleNamedType
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCitModelAccess().getTypesNamedTypeParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNamedType_in_ruleCitModel236);
                    	    lv_Types_7_0=ruleNamedType();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCitModelRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"Types",
                    	              		lv_Types_7_0, 
                    	              		"NamedType");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCitModel249); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getCitModelAccess().getEndKeyword_4_2());
                          
                    }

                    }
                    break;

            }

            otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleCitModel263); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getCitModelAccess().getParametersKeyword_5());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:165:1: ( (lv_parameters_10_0= ruleParameter ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==26||(LA5_0>=28 && LA5_0<=30)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:166:1: (lv_parameters_10_0= ruleParameter )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:166:1: (lv_parameters_10_0= ruleParameter )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:167:3: lv_parameters_10_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCitModelAccess().getParametersParameterParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleCitModel284);
            	    lv_parameters_10_0=ruleParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCitModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parameters",
            	              		lv_parameters_10_0, 
            	              		"Parameter");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCitModel297); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getCitModelAccess().getEndKeyword_7());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:187:1: (otherlv_12= 'Constraints:' ( (lv_constraints_13_0= ruleRule ) )+ otherlv_14= 'end' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:187:3: otherlv_12= 'Constraints:' ( (lv_constraints_13_0= ruleRule ) )+ otherlv_14= 'end'
                    {
                    otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleCitModel310); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getCitModelAccess().getConstraintsKeyword_8_0());
                          
                    }
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:191:1: ( (lv_constraints_13_0= ruleRule ) )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==35) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:192:1: (lv_constraints_13_0= ruleRule )
                    	    {
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:192:1: (lv_constraints_13_0= ruleRule )
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:193:3: lv_constraints_13_0= ruleRule
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCitModelAccess().getConstraintsRuleParserRuleCall_8_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleRule_in_ruleCitModel331);
                    	    lv_constraints_13_0=ruleRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCitModelRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"constraints",
                    	              		lv_constraints_13_0, 
                    	              		"Rule");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    otherlv_14=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCitModel344); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getCitModelAccess().getEndKeyword_8_2());
                          
                    }

                    }
                    break;

            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:213:3: (otherlv_15= 'Seeds:' ( (lv_seeds_16_0= ruleSeed ) )+ otherlv_17= 'end' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:213:5: otherlv_15= 'Seeds:' ( (lv_seeds_16_0= ruleSeed ) )+ otherlv_17= 'end'
                    {
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCitModel359); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getCitModelAccess().getSeedsKeyword_9_0());
                          
                    }
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:217:1: ( (lv_seeds_16_0= ruleSeed ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==35) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:218:1: (lv_seeds_16_0= ruleSeed )
                    	    {
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:218:1: (lv_seeds_16_0= ruleSeed )
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:219:3: lv_seeds_16_0= ruleSeed
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCitModelAccess().getSeedsSeedParserRuleCall_9_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSeed_in_ruleCitModel380);
                    	    lv_seeds_16_0=ruleSeed();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCitModelRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"seeds",
                    	              		lv_seeds_16_0, 
                    	              		"Seed");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCitModel393); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getCitModelAccess().getEndKeyword_9_2());
                          
                    }

                    }
                    break;

            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:239:3: (otherlv_18= 'TestGoals:' ( (lv_testGoals_19_0= ruleRule ) )+ otherlv_20= 'end' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:239:5: otherlv_18= 'TestGoals:' ( (lv_testGoals_19_0= ruleRule ) )+ otherlv_20= 'end'
                    {
                    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCitModel408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getCitModelAccess().getTestGoalsKeyword_10_0());
                          
                    }
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:243:1: ( (lv_testGoals_19_0= ruleRule ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==35) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:244:1: (lv_testGoals_19_0= ruleRule )
                    	    {
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:244:1: (lv_testGoals_19_0= ruleRule )
                    	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:245:3: lv_testGoals_19_0= ruleRule
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCitModelAccess().getTestGoalsRuleParserRuleCall_10_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleRule_in_ruleCitModel429);
                    	    lv_testGoals_19_0=ruleRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCitModelRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"testGoals",
                    	              		lv_testGoals_19_0, 
                    	              		"Rule");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    otherlv_20=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCitModel442); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getCitModelAccess().getEndKeyword_10_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCitModel"


    // $ANTLR start "entryRuleConstant"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:273:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:274:2: (iv_ruleConstant= ruleConstant EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:275:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstant_in_entryRuleConstant480);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstant490); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:282:1: ruleConstant returns [EObject current=null] : this_ConstantNumber_0= ruleConstantNumber ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        EObject this_ConstantNumber_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:285:28: (this_ConstantNumber_0= ruleConstantNumber )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:287:5: this_ConstantNumber_0= ruleConstantNumber
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConstantAccess().getConstantNumberParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstantNumber_in_ruleConstant536);
            this_ConstantNumber_0=ruleConstantNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ConstantNumber_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleConstantNumber"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:303:1: entryRuleConstantNumber returns [EObject current=null] : iv_ruleConstantNumber= ruleConstantNumber EOF ;
    public final EObject entryRuleConstantNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantNumber = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:304:2: (iv_ruleConstantNumber= ruleConstantNumber EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:305:2: iv_ruleConstantNumber= ruleConstantNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantNumberRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstantNumber_in_entryRuleConstantNumber570);
            iv_ruleConstantNumber=ruleConstantNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantNumber; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstantNumber580); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantNumber"


    // $ANTLR start "ruleConstantNumber"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:312:1: ruleConstantNumber returns [EObject current=null] : (otherlv_0= 'Number' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ';' ) ;
    public final EObject ruleConstantNumber() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:315:28: ( (otherlv_0= 'Number' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ';' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:316:1: (otherlv_0= 'Number' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ';' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:316:1: (otherlv_0= 'Number' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ';' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:316:3: otherlv_0= 'Number' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleConstantNumber617); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConstantNumberAccess().getNumberKeyword_0());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:320:1: ( (lv_name_1_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:321:1: (lv_name_1_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:321:1: (lv_name_1_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:322:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConstantNumber634); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getConstantNumberAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getConstantNumberRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleConstantNumber651); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstantNumberAccess().getEqualsSignKeyword_2());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:342:1: ( (lv_value_3_0= RULE_INT ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:343:1: (lv_value_3_0= RULE_INT )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:343:1: (lv_value_3_0= RULE_INT )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:344:3: lv_value_3_0= RULE_INT
            {
            lv_value_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleConstantNumber668); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_3_0, grammarAccess.getConstantNumberAccess().getValueINTTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getConstantNumberRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_3_0, 
                      		"INT");
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleConstantNumber685); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstantNumberAccess().getSemicolonKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantNumber"


    // $ANTLR start "entryRuleParameter"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:372:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:373:2: (iv_ruleParameter= ruleParameter EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:374:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter721);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter731); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:381:1: ruleParameter returns [EObject current=null] : (this_Enumerative_0= ruleEnumerative | this_Boolean_1= ruleBoolean | this_Numerical_2= ruleNumerical ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject this_Enumerative_0 = null;

        EObject this_Boolean_1 = null;

        EObject this_Numerical_2 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:384:28: ( (this_Enumerative_0= ruleEnumerative | this_Boolean_1= ruleBoolean | this_Numerical_2= ruleNumerical ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:385:1: (this_Enumerative_0= ruleEnumerative | this_Boolean_1= ruleBoolean | this_Numerical_2= ruleNumerical )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:385:1: (this_Enumerative_0= ruleEnumerative | this_Boolean_1= ruleBoolean | this_Numerical_2= ruleNumerical )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt12=1;
                }
                break;
            case 28:
                {
                alt12=2;
                }
                break;
            case 29:
            case 30:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:386:5: this_Enumerative_0= ruleEnumerative
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getParameterAccess().getEnumerativeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEnumerative_in_ruleParameter778);
                    this_Enumerative_0=ruleEnumerative();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Enumerative_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:396:5: this_Boolean_1= ruleBoolean
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getParameterAccess().getBooleanParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_ruleParameter805);
                    this_Boolean_1=ruleBoolean();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Boolean_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:406:5: this_Numerical_2= ruleNumerical
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getParameterAccess().getNumericalParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumerical_in_ruleParameter832);
                    this_Numerical_2=ruleNumerical();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Numerical_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleNumericalEx"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:424:1: entryRuleNumericalEx returns [EObject current=null] : iv_ruleNumericalEx= ruleNumericalEx EOF ;
    public final EObject entryRuleNumericalEx() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalEx = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:425:2: (iv_ruleNumericalEx= ruleNumericalEx EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:426:2: iv_ruleNumericalEx= ruleNumericalEx EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalExRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumericalEx_in_entryRuleNumericalEx869);
            iv_ruleNumericalEx=ruleNumericalEx();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalEx; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumericalEx879); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericalEx"


    // $ANTLR start "ruleNumericalEx"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:433:1: ruleNumericalEx returns [EObject current=null] : (this_Numerical_0= ruleNumerical | this_ConstantNumber_1= ruleConstantNumber ) ;
    public final EObject ruleNumericalEx() throws RecognitionException {
        EObject current = null;

        EObject this_Numerical_0 = null;

        EObject this_ConstantNumber_1 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:436:28: ( (this_Numerical_0= ruleNumerical | this_ConstantNumber_1= ruleConstantNumber ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:437:1: (this_Numerical_0= ruleNumerical | this_ConstantNumber_1= ruleConstantNumber )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:437:1: (this_Numerical_0= ruleNumerical | this_ConstantNumber_1= ruleConstantNumber )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=29 && LA13_0<=30)) ) {
                alt13=1;
            }
            else if ( (LA13_0==20) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:438:5: this_Numerical_0= ruleNumerical
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericalExAccess().getNumericalParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumerical_in_ruleNumericalEx926);
                    this_Numerical_0=ruleNumerical();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Numerical_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:448:5: this_ConstantNumber_1= ruleConstantNumber
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericalExAccess().getConstantNumberParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConstantNumber_in_ruleNumericalEx953);
                    this_ConstantNumber_1=ruleConstantNumber();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ConstantNumber_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericalEx"


    // $ANTLR start "entryRuleNumerical"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:464:1: entryRuleNumerical returns [EObject current=null] : iv_ruleNumerical= ruleNumerical EOF ;
    public final EObject entryRuleNumerical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumerical = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:465:2: (iv_ruleNumerical= ruleNumerical EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:466:2: iv_ruleNumerical= ruleNumerical EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumerical_in_entryRuleNumerical988);
            iv_ruleNumerical=ruleNumerical();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumerical; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumerical998); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumerical"


    // $ANTLR start "ruleNumerical"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:473:1: ruleNumerical returns [EObject current=null] : (this_Numbers_0= ruleNumbers | this_Range_1= ruleRange ) ;
    public final EObject ruleNumerical() throws RecognitionException {
        EObject current = null;

        EObject this_Numbers_0 = null;

        EObject this_Range_1 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:476:28: ( (this_Numbers_0= ruleNumbers | this_Range_1= ruleRange ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:477:1: (this_Numbers_0= ruleNumbers | this_Range_1= ruleRange )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:477:1: (this_Numbers_0= ruleNumbers | this_Range_1= ruleRange )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==29) ) {
                alt14=1;
            }
            else if ( (LA14_0==30) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:478:5: this_Numbers_0= ruleNumbers
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericalAccess().getNumbersParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumbers_in_ruleNumerical1045);
                    this_Numbers_0=ruleNumbers();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Numbers_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:488:5: this_Range_1= ruleRange
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericalAccess().getRangeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRange_in_ruleNumerical1072);
                    this_Range_1=ruleRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Range_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumerical"


    // $ANTLR start "entryRuleNamedType"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:506:1: entryRuleNamedType returns [EObject current=null] : iv_ruleNamedType= ruleNamedType EOF ;
    public final EObject entryRuleNamedType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedType = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:507:2: (iv_ruleNamedType= ruleNamedType EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:508:2: iv_ruleNamedType= ruleNamedType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNamedType_in_entryRuleNamedType1109);
            iv_ruleNamedType=ruleNamedType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedType1119); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedType"


    // $ANTLR start "ruleNamedType"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:515:1: ruleNamedType returns [EObject current=null] : (otherlv_0= 'EnumerativeType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' otherlv_5= ';' ) ;
    public final EObject ruleNamedType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:518:28: ( (otherlv_0= 'EnumerativeType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' otherlv_5= ';' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:519:1: (otherlv_0= 'EnumerativeType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' otherlv_5= ';' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:519:1: (otherlv_0= 'EnumerativeType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' otherlv_5= ';' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:519:3: otherlv_0= 'EnumerativeType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNamedType1156); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNamedTypeAccess().getEnumerativeTypeKeyword_0());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:523:1: ( (lv_name_1_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:524:1: (lv_name_1_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:524:1: (lv_name_1_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:525:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamedType1173); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getNamedTypeAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNamedTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleNamedType1190); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getNamedTypeAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:545:1: ( (lv_elements_3_0= ruleElement ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID||LA15_0==RULE_NUMID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:546:1: (lv_elements_3_0= ruleElement )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:546:1: (lv_elements_3_0= ruleElement )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:547:3: lv_elements_3_0= ruleElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNamedTypeAccess().getElementsElementParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleNamedType1211);
            	    lv_elements_3_0=ruleElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNamedTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_3_0, 
            	              		"Element");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNamedType1224); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getNamedTypeAccess().getRightCurlyBracketKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNamedType1236); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getNamedTypeAccess().getSemicolonKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedType"


    // $ANTLR start "entryRuleAnonymousType"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:579:1: entryRuleAnonymousType returns [EObject current=null] : iv_ruleAnonymousType= ruleAnonymousType EOF ;
    public final EObject entryRuleAnonymousType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnonymousType = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:580:2: (iv_ruleAnonymousType= ruleAnonymousType EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:581:2: iv_ruleAnonymousType= ruleAnonymousType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnonymousTypeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAnonymousType_in_entryRuleAnonymousType1272);
            iv_ruleAnonymousType=ruleAnonymousType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnonymousType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnonymousType1282); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnonymousType"


    // $ANTLR start "ruleAnonymousType"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:588:1: ruleAnonymousType returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )+ ;
    public final EObject ruleAnonymousType() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:591:28: ( ( (lv_elements_0_0= ruleElement ) )+ )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:592:1: ( (lv_elements_0_0= ruleElement ) )+
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:592:1: ( (lv_elements_0_0= ruleElement ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID||LA16_0==RULE_NUMID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:593:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:593:1: (lv_elements_0_0= ruleElement )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:594:3: lv_elements_0_0= ruleElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAnonymousTypeAccess().getElementsElementParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleAnonymousType1327);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAnonymousTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"elements",
            	              		lv_elements_0_0, 
            	              		"Element");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnonymousType"


    // $ANTLR start "entryRuleEnumerative"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:618:1: entryRuleEnumerative returns [EObject current=null] : iv_ruleEnumerative= ruleEnumerative EOF ;
    public final EObject entryRuleEnumerative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerative = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:619:2: (iv_ruleEnumerative= ruleEnumerative EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:620:2: iv_ruleEnumerative= ruleEnumerative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumerativeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumerative_in_entryRuleEnumerative1363);
            iv_ruleEnumerative=ruleEnumerative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumerative; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumerative1373); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerative"


    // $ANTLR start "ruleEnumerative"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:627:1: ruleEnumerative returns [EObject current=null] : (otherlv_0= 'Enumerative' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= '{' ( (lv_atype_5_0= ruleAnonymousType ) ) otherlv_6= '}' ) ) otherlv_7= ';' ) ;
    public final EObject ruleEnumerative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_atype_5_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:630:28: ( (otherlv_0= 'Enumerative' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= '{' ( (lv_atype_5_0= ruleAnonymousType ) ) otherlv_6= '}' ) ) otherlv_7= ';' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:631:1: (otherlv_0= 'Enumerative' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= '{' ( (lv_atype_5_0= ruleAnonymousType ) ) otherlv_6= '}' ) ) otherlv_7= ';' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:631:1: (otherlv_0= 'Enumerative' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= '{' ( (lv_atype_5_0= ruleAnonymousType ) ) otherlv_6= '}' ) ) otherlv_7= ';' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:631:3: otherlv_0= 'Enumerative' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= '{' ( (lv_atype_5_0= ruleAnonymousType ) ) otherlv_6= '}' ) ) otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleEnumerative1410); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEnumerativeAccess().getEnumerativeKeyword_0());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:635:1: ( (lv_name_1_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:636:1: (lv_name_1_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:636:1: (lv_name_1_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:637:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumerative1427); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getEnumerativeAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumerativeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:653:2: ( (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ) | (otherlv_4= '{' ( (lv_atype_5_0= ruleAnonymousType ) ) otherlv_6= '}' ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            else if ( (LA17_0==24) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:653:3: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:653:3: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:653:5: otherlv_2= ':' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleEnumerative1446); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEnumerativeAccess().getColonKeyword_2_0_0());
                          
                    }
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:657:1: ( (otherlv_3= RULE_ID ) )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:658:1: (otherlv_3= RULE_ID )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:658:1: (otherlv_3= RULE_ID )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:659:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getEnumerativeRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumerative1466); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getEnumerativeAccess().getNamedTypeNamedTypeCrossReference_2_0_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:671:6: (otherlv_4= '{' ( (lv_atype_5_0= ruleAnonymousType ) ) otherlv_6= '}' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:671:6: (otherlv_4= '{' ( (lv_atype_5_0= ruleAnonymousType ) ) otherlv_6= '}' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:671:8: otherlv_4= '{' ( (lv_atype_5_0= ruleAnonymousType ) ) otherlv_6= '}'
                    {
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleEnumerative1486); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getEnumerativeAccess().getLeftCurlyBracketKeyword_2_1_0());
                          
                    }
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:675:1: ( (lv_atype_5_0= ruleAnonymousType ) )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:676:1: (lv_atype_5_0= ruleAnonymousType )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:676:1: (lv_atype_5_0= ruleAnonymousType )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:677:3: lv_atype_5_0= ruleAnonymousType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEnumerativeAccess().getAtypeAnonymousTypeParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAnonymousType_in_ruleEnumerative1507);
                    lv_atype_5_0=ruleAnonymousType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEnumerativeRule());
                      	        }
                             		set(
                             			current, 
                             			"atype",
                              		lv_atype_5_0, 
                              		"AnonymousType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleEnumerative1519); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getEnumerativeAccess().getRightCurlyBracketKeyword_2_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleEnumerative1533); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getEnumerativeAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerative"


    // $ANTLR start "entryRuleElement"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:709:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:710:2: (iv_ruleElement= ruleElement EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:711:2: iv_ruleElement= ruleElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement1569);
            iv_ruleElement=ruleElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement1579); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:718:1: ruleElement returns [EObject current=null] : ( (lv_name_0_0= ruleelementID ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:721:28: ( ( (lv_name_0_0= ruleelementID ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:722:1: ( (lv_name_0_0= ruleelementID ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:722:1: ( (lv_name_0_0= ruleelementID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:723:1: (lv_name_0_0= ruleelementID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:723:1: (lv_name_0_0= ruleelementID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:724:3: lv_name_0_0= ruleelementID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElementAccess().getNameElementIDParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleelementID_in_ruleElement1624);
            lv_name_0_0=ruleelementID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElementRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"elementID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleBoolean"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:748:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:749:2: (iv_ruleBoolean= ruleBoolean EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:750:2: iv_ruleBoolean= ruleBoolean EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_entryRuleBoolean1659);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolean; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoolean1669); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:757:1: ruleBoolean returns [EObject current=null] : (otherlv_0= 'Boolean' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:760:28: ( (otherlv_0= 'Boolean' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:761:1: (otherlv_0= 'Boolean' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:761:1: (otherlv_0= 'Boolean' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:761:3: otherlv_0= 'Boolean' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBoolean1706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBooleanAccess().getBooleanKeyword_0());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:765:1: ( (lv_name_1_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:766:1: (lv_name_1_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:766:1: (lv_name_1_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:767:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBoolean1723); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getBooleanAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBooleanRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleBoolean1740); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBooleanAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleNumbers"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:795:1: entryRuleNumbers returns [EObject current=null] : iv_ruleNumbers= ruleNumbers EOF ;
    public final EObject entryRuleNumbers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumbers = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:796:2: (iv_ruleNumbers= ruleNumbers EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:797:2: iv_ruleNumbers= ruleNumbers EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumbersRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumbers_in_entryRuleNumbers1776);
            iv_ruleNumbers=ruleNumbers();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumbers; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumbers1786); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumbers"


    // $ANTLR start "ruleNumbers"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:804:1: ruleNumbers returns [EObject current=null] : (otherlv_0= 'Numbers' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= rulePossiblySignedNumber ) )+ otherlv_4= '}' otherlv_5= ';' ) ;
    public final EObject ruleNumbers() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:807:28: ( (otherlv_0= 'Numbers' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= rulePossiblySignedNumber ) )+ otherlv_4= '}' otherlv_5= ';' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:808:1: (otherlv_0= 'Numbers' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= rulePossiblySignedNumber ) )+ otherlv_4= '}' otherlv_5= ';' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:808:1: (otherlv_0= 'Numbers' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= rulePossiblySignedNumber ) )+ otherlv_4= '}' otherlv_5= ';' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:808:3: otherlv_0= 'Numbers' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_values_3_0= rulePossiblySignedNumber ) )+ otherlv_4= '}' otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNumbers1823); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNumbersAccess().getNumbersKeyword_0());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:812:1: ( (lv_name_1_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:813:1: (lv_name_1_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:813:1: (lv_name_1_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:814:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNumbers1840); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getNumbersAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNumbersRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleNumbers1857); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getNumbersAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:834:1: ( (lv_values_3_0= rulePossiblySignedNumber ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_INT||LA18_0==42) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:835:1: (lv_values_3_0= rulePossiblySignedNumber )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:835:1: (lv_values_3_0= rulePossiblySignedNumber )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:836:3: lv_values_3_0= rulePossiblySignedNumber
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNumbersAccess().getValuesPossiblySignedNumberParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulePossiblySignedNumber_in_ruleNumbers1878);
            	    lv_values_3_0=rulePossiblySignedNumber();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNumbersRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"values",
            	              		lv_values_3_0, 
            	              		"PossiblySignedNumber");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            otherlv_4=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNumbers1891); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getNumbersAccess().getRightCurlyBracketKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNumbers1903); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getNumbersAccess().getSemicolonKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumbers"


    // $ANTLR start "entryRuleRange"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:868:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:869:2: (iv_ruleRange= ruleRange EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:870:2: iv_ruleRange= ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRange_in_entryRuleRange1939);
            iv_ruleRange=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRange; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRange1949); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:877:1: ruleRange returns [EObject current=null] : (otherlv_0= 'Range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( (lv_begin_3_0= rulePossiblySignedNumber ) ) otherlv_4= '..' ( (lv_end_5_0= rulePossiblySignedNumber ) ) otherlv_6= ']' (otherlv_7= 'step' ( (lv_step_8_0= RULE_INT ) ) )? otherlv_9= ';' ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_step_8_0=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_begin_3_0 = null;

        AntlrDatatypeRuleToken lv_end_5_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:880:28: ( (otherlv_0= 'Range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( (lv_begin_3_0= rulePossiblySignedNumber ) ) otherlv_4= '..' ( (lv_end_5_0= rulePossiblySignedNumber ) ) otherlv_6= ']' (otherlv_7= 'step' ( (lv_step_8_0= RULE_INT ) ) )? otherlv_9= ';' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:881:1: (otherlv_0= 'Range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( (lv_begin_3_0= rulePossiblySignedNumber ) ) otherlv_4= '..' ( (lv_end_5_0= rulePossiblySignedNumber ) ) otherlv_6= ']' (otherlv_7= 'step' ( (lv_step_8_0= RULE_INT ) ) )? otherlv_9= ';' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:881:1: (otherlv_0= 'Range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( (lv_begin_3_0= rulePossiblySignedNumber ) ) otherlv_4= '..' ( (lv_end_5_0= rulePossiblySignedNumber ) ) otherlv_6= ']' (otherlv_7= 'step' ( (lv_step_8_0= RULE_INT ) ) )? otherlv_9= ';' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:881:3: otherlv_0= 'Range' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( (lv_begin_3_0= rulePossiblySignedNumber ) ) otherlv_4= '..' ( (lv_end_5_0= rulePossiblySignedNumber ) ) otherlv_6= ']' (otherlv_7= 'step' ( (lv_step_8_0= RULE_INT ) ) )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleRange1986); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getRangeKeyword_0());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:885:1: ( (lv_name_1_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:886:1: (lv_name_1_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:886:1: (lv_name_1_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:887:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRange2003); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getRangeAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRangeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleRange2020); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRangeAccess().getLeftSquareBracketKeyword_2());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:907:1: ( (lv_begin_3_0= rulePossiblySignedNumber ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:908:1: (lv_begin_3_0= rulePossiblySignedNumber )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:908:1: (lv_begin_3_0= rulePossiblySignedNumber )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:909:3: lv_begin_3_0= rulePossiblySignedNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRangeAccess().getBeginPossiblySignedNumberParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePossiblySignedNumber_in_ruleRange2041);
            lv_begin_3_0=rulePossiblySignedNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRangeRule());
              	        }
                     		set(
                     			current, 
                     			"begin",
                      		lv_begin_3_0, 
                      		"PossiblySignedNumber");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleRange2053); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getRangeAccess().getFullStopFullStopKeyword_4());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:929:1: ( (lv_end_5_0= rulePossiblySignedNumber ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:930:1: (lv_end_5_0= rulePossiblySignedNumber )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:930:1: (lv_end_5_0= rulePossiblySignedNumber )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:931:3: lv_end_5_0= rulePossiblySignedNumber
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRangeAccess().getEndPossiblySignedNumberParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePossiblySignedNumber_in_ruleRange2074);
            lv_end_5_0=rulePossiblySignedNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRangeRule());
              	        }
                     		set(
                     			current, 
                     			"end",
                      		lv_end_5_0, 
                      		"PossiblySignedNumber");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleRange2086); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRangeAccess().getRightSquareBracketKeyword_6());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:951:1: (otherlv_7= 'step' ( (lv_step_8_0= RULE_INT ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==34) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:951:3: otherlv_7= 'step' ( (lv_step_8_0= RULE_INT ) )
                    {
                    otherlv_7=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRange2099); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getRangeAccess().getStepKeyword_7_0());
                          
                    }
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:955:1: ( (lv_step_8_0= RULE_INT ) )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:956:1: (lv_step_8_0= RULE_INT )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:956:1: (lv_step_8_0= RULE_INT )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:957:3: lv_step_8_0= RULE_INT
                    {
                    lv_step_8_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleRange2116); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_step_8_0, grammarAccess.getRangeAccess().getStepINTTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRangeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"step",
                              		lv_step_8_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRange2135); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getRangeAccess().getSemicolonKeyword_8());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleRule"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:985:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:986:2: (iv_ruleRule= ruleRule EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:987:2: iv_ruleRule= ruleRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRule_in_entryRuleRule2171);
            iv_ruleRule=ruleRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRule; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRule2181); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:994:1: ruleRule returns [EObject current=null] : (otherlv_0= '#' this_OrExpression_1= ruleOrExpression otherlv_2= '#' ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_OrExpression_1 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:997:28: ( (otherlv_0= '#' this_OrExpression_1= ruleOrExpression otherlv_2= '#' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:998:1: (otherlv_0= '#' this_OrExpression_1= ruleOrExpression otherlv_2= '#' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:998:1: (otherlv_0= '#' this_OrExpression_1= ruleOrExpression otherlv_2= '#' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:998:3: otherlv_0= '#' this_OrExpression_1= ruleOrExpression otherlv_2= '#'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleRule2218); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getNumberSignKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRuleAccess().getOrExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleOrExpression_in_ruleRule2240);
            this_OrExpression_1=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_OrExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleRule2251); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getNumberSignKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleOrExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1023:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1024:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1025:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOrExpression_in_entryRuleOrExpression2287);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOrExpression2297); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1032:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( ( ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleOrOperators ) ) ( (lv_right_3_0= ruleAndExpression ) ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1035:28: ( (this_AndExpression_0= ruleAndExpression ( ( ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleOrOperators ) ) ( (lv_right_3_0= ruleAndExpression ) ) ) )* ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1036:1: (this_AndExpression_0= ruleAndExpression ( ( ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleOrOperators ) ) ( (lv_right_3_0= ruleAndExpression ) ) ) )* )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1036:1: (this_AndExpression_0= ruleAndExpression ( ( ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleOrOperators ) ) ( (lv_right_3_0= ruleAndExpression ) ) ) )* )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1037:5: this_AndExpression_0= ruleAndExpression ( ( ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleOrOperators ) ) ( (lv_right_3_0= ruleAndExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndExpression_in_ruleOrExpression2344);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1045:1: ( ( ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleOrOperators ) ) ( (lv_right_3_0= ruleAndExpression ) ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==52) && (synpred1_InternalCitL())) {
                    alt20=1;
                }
                else if ( (LA20_0==53) && (synpred1_InternalCitL())) {
                    alt20=1;
                }
                else if ( (LA20_0==54) && (synpred1_InternalCitL())) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1045:2: ( ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleOrOperators ) ) ( (lv_right_3_0= ruleAndExpression ) ) )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1054:6: ( () ( (lv_op_2_0= ruleOrOperators ) ) ( (lv_right_3_0= ruleAndExpression ) ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1054:7: () ( (lv_op_2_0= ruleOrOperators ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1054:7: ()
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1055:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1060:2: ( (lv_op_2_0= ruleOrOperators ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1061:1: (lv_op_2_0= ruleOrOperators )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1061:1: (lv_op_2_0= ruleOrOperators )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1062:3: lv_op_2_0= ruleOrOperators
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExpressionAccess().getOpOrOperatorsEnumRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOrOperators_in_ruleOrExpression2401);
            	    lv_op_2_0=ruleOrOperators();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"op",
            	              		lv_op_2_0, 
            	              		"OrOperators");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1078:2: ( (lv_right_3_0= ruleAndExpression ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1079:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1079:1: (lv_right_3_0= ruleAndExpression )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1080:3: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAndExpression_in_ruleOrExpression2422);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"AndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1104:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1105:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1106:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndExpression_in_entryRuleAndExpression2461);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAndExpression2471); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1113:1: ruleAndExpression returns [EObject current=null] : (this_ImpliesExpression_0= ruleImpliesExpression ( ( ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleAndOperators ) ) ( (lv_right_3_0= ruleImpliesExpression ) ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ImpliesExpression_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1116:28: ( (this_ImpliesExpression_0= ruleImpliesExpression ( ( ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleAndOperators ) ) ( (lv_right_3_0= ruleImpliesExpression ) ) ) )* ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1117:1: (this_ImpliesExpression_0= ruleImpliesExpression ( ( ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleAndOperators ) ) ( (lv_right_3_0= ruleImpliesExpression ) ) ) )* )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1117:1: (this_ImpliesExpression_0= ruleImpliesExpression ( ( ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleAndOperators ) ) ( (lv_right_3_0= ruleImpliesExpression ) ) ) )* )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1118:5: this_ImpliesExpression_0= ruleImpliesExpression ( ( ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleAndOperators ) ) ( (lv_right_3_0= ruleImpliesExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExpressionAccess().getImpliesExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleImpliesExpression_in_ruleAndExpression2518);
            this_ImpliesExpression_0=ruleImpliesExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ImpliesExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1126:1: ( ( ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleAndOperators ) ) ( (lv_right_3_0= ruleImpliesExpression ) ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==49) && (synpred2_InternalCitL())) {
                    alt21=1;
                }
                else if ( (LA21_0==50) && (synpred2_InternalCitL())) {
                    alt21=1;
                }
                else if ( (LA21_0==51) && (synpred2_InternalCitL())) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1126:2: ( ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) ) )=> ( () ( (lv_op_2_0= ruleAndOperators ) ) ( (lv_right_3_0= ruleImpliesExpression ) ) )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1135:6: ( () ( (lv_op_2_0= ruleAndOperators ) ) ( (lv_right_3_0= ruleImpliesExpression ) ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1135:7: () ( (lv_op_2_0= ruleAndOperators ) ) ( (lv_right_3_0= ruleImpliesExpression ) )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1135:7: ()
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1136:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1141:2: ( (lv_op_2_0= ruleAndOperators ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1142:1: (lv_op_2_0= ruleAndOperators )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1142:1: (lv_op_2_0= ruleAndOperators )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1143:3: lv_op_2_0= ruleAndOperators
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOpAndOperatorsEnumRuleCall_1_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAndOperators_in_ruleAndExpression2575);
            	    lv_op_2_0=ruleAndOperators();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"op",
            	              		lv_op_2_0, 
            	              		"AndOperators");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1159:2: ( (lv_right_3_0= ruleImpliesExpression ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1160:1: (lv_right_3_0= ruleImpliesExpression )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1160:1: (lv_right_3_0= ruleImpliesExpression )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1161:3: lv_right_3_0= ruleImpliesExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getRightImpliesExpressionParserRuleCall_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleImpliesExpression_in_ruleAndExpression2596);
            	    lv_right_3_0=ruleImpliesExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"ImpliesExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleImpliesExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1185:1: entryRuleImpliesExpression returns [EObject current=null] : iv_ruleImpliesExpression= ruleImpliesExpression EOF ;
    public final EObject entryRuleImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpression = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1186:2: (iv_ruleImpliesExpression= ruleImpliesExpression EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1187:2: iv_ruleImpliesExpression= ruleImpliesExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImpliesExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImpliesExpression_in_entryRuleImpliesExpression2635);
            iv_ruleImpliesExpression=ruleImpliesExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImpliesExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImpliesExpression2645); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImpliesExpression"


    // $ANTLR start "ruleImpliesExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1194:1: ruleImpliesExpression returns [EObject current=null] : (this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleImpliesOperator ) ) ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Primary_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1197:28: ( (this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleImpliesOperator ) ) ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1198:1: (this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleImpliesOperator ) ) ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1198:1: (this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleImpliesOperator ) ) ( (lv_right_3_0= rulePrimary ) ) )* )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1199:5: this_Primary_0= rulePrimary ( () ( (lv_op_2_0= ruleImpliesOperator ) ) ( (lv_right_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getImpliesExpressionAccess().getPrimaryParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleImpliesExpression2692);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Primary_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1207:1: ( () ( (lv_op_2_0= ruleImpliesOperator ) ) ( (lv_right_3_0= rulePrimary ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=59 && LA22_0<=60)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1207:2: () ( (lv_op_2_0= ruleImpliesOperator ) ) ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1207:2: ()
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1208:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getImpliesExpressionAccess().getImpliesExpressionLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1213:2: ( (lv_op_2_0= ruleImpliesOperator ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1214:1: (lv_op_2_0= ruleImpliesOperator )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1214:1: (lv_op_2_0= ruleImpliesOperator )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1215:3: lv_op_2_0= ruleImpliesOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImpliesExpressionAccess().getOpImpliesOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleImpliesOperator_in_ruleImpliesExpression2722);
            	    lv_op_2_0=ruleImpliesOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getImpliesExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"op",
            	              		lv_op_2_0, 
            	              		"ImpliesOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1231:2: ( (lv_right_3_0= rulePrimary ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1232:1: (lv_right_3_0= rulePrimary )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1232:1: (lv_right_3_0= rulePrimary )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1233:3: lv_right_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImpliesExpressionAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleImpliesExpression2743);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getImpliesExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"Primary");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImpliesExpression"


    // $ANTLR start "entryRulePrimary"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1257:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1258:2: (iv_rulePrimary= rulePrimary EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1259:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_entryRulePrimary2781);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimary2791); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1266:1: rulePrimary returns [EObject current=null] : (this_NotExpression_0= ruleNotExpression | (otherlv_1= '(' this_OrExpression_2= ruleOrExpression otherlv_3= ')' ) | this_AtomicPredicate_4= ruleAtomicPredicate ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_NotExpression_0 = null;

        EObject this_OrExpression_2 = null;

        EObject this_AtomicPredicate_4 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1269:28: ( (this_NotExpression_0= ruleNotExpression | (otherlv_1= '(' this_OrExpression_2= ruleOrExpression otherlv_3= ')' ) | this_AtomicPredicate_4= ruleAtomicPredicate ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1270:1: (this_NotExpression_0= ruleNotExpression | (otherlv_1= '(' this_OrExpression_2= ruleOrExpression otherlv_3= ')' ) | this_AtomicPredicate_4= ruleAtomicPredicate )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1270:1: (this_NotExpression_0= ruleNotExpression | (otherlv_1= '(' this_OrExpression_2= ruleOrExpression otherlv_3= ')' ) | this_AtomicPredicate_4= ruleAtomicPredicate )
            int alt23=3;
            switch ( input.LA(1) ) {
            case 38:
            case 39:
                {
                alt23=1;
                }
                break;
            case 36:
                {
                alt23=2;
                }
                break;
            case RULE_ID:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1271:5: this_NotExpression_0= ruleNotExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getNotExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_rulePrimary2838);
                    this_NotExpression_0=ruleNotExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NotExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1280:6: (otherlv_1= '(' this_OrExpression_2= ruleOrExpression otherlv_3= ')' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1280:6: (otherlv_1= '(' this_OrExpression_2= ruleOrExpression otherlv_3= ')' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1280:8: otherlv_1= '(' this_OrExpression_2= ruleOrExpression otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_rulePrimary2856); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getOrExpressionParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleOrExpression_in_rulePrimary2878);
                    this_OrExpression_2=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OrExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_rulePrimary2889); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1299:5: this_AtomicPredicate_4= ruleAtomicPredicate
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getAtomicPredicateParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAtomicPredicate_in_rulePrimary2918);
                    this_AtomicPredicate_4=ruleAtomicPredicate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AtomicPredicate_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleNotExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1315:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1316:2: (iv_ruleNotExpression= ruleNotExpression EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1317:2: iv_ruleNotExpression= ruleNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNotExpression_in_entryRuleNotExpression2953);
            iv_ruleNotExpression=ruleNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNotExpression2963); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotExpression"


    // $ANTLR start "ruleNotExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1324:1: ruleNotExpression returns [EObject current=null] : ( (otherlv_0= '!' | otherlv_1= 'not' ) this_Primary_2= rulePrimary () ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_Primary_2 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1327:28: ( ( (otherlv_0= '!' | otherlv_1= 'not' ) this_Primary_2= rulePrimary () ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1328:1: ( (otherlv_0= '!' | otherlv_1= 'not' ) this_Primary_2= rulePrimary () )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1328:1: ( (otherlv_0= '!' | otherlv_1= 'not' ) this_Primary_2= rulePrimary () )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1328:2: (otherlv_0= '!' | otherlv_1= 'not' ) this_Primary_2= rulePrimary ()
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1328:2: (otherlv_0= '!' | otherlv_1= 'not' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                alt24=1;
            }
            else if ( (LA24_0==39) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1328:4: otherlv_0= '!'
                    {
                    otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleNotExpression3001); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getNotExpressionAccess().getExclamationMarkKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1333:7: otherlv_1= 'not'
                    {
                    otherlv_1=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleNotExpression3019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNotExpressionAccess().getNotKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNotExpressionAccess().getPrimaryParserRuleCall_1()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimary_in_ruleNotExpression3042);
            this_Primary_2=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Primary_2; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1346:1: ()
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1347:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElementAndSet(
                          grammarAccess.getNotExpressionAccess().getNotExpressionPredicateAction_2(),
                          current);
                  
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotExpression"


    // $ANTLR start "entryRuleAtomicPredicate"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1360:1: entryRuleAtomicPredicate returns [EObject current=null] : iv_ruleAtomicPredicate= ruleAtomicPredicate EOF ;
    public final EObject entryRuleAtomicPredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicPredicate = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1361:2: (iv_ruleAtomicPredicate= ruleAtomicPredicate EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1362:2: iv_ruleAtomicPredicate= ruleAtomicPredicate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicPredicateRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAtomicPredicate_in_entryRuleAtomicPredicate3086);
            iv_ruleAtomicPredicate=ruleAtomicPredicate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicPredicate; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtomicPredicate3096); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicPredicate"


    // $ANTLR start "ruleAtomicPredicate"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1369:1: ruleAtomicPredicate returns [EObject current=null] : ( ( ( ( RULE_ID ) )=>this_EnumAssign_0= ruleEnumAssign ) | ( ( ( RULE_ID ) )=>this_BoolAssign_1= ruleBoolAssign ) | this_RelationalExpression_2= ruleRelationalExpression ) ;
    public final EObject ruleAtomicPredicate() throws RecognitionException {
        EObject current = null;

        EObject this_EnumAssign_0 = null;

        EObject this_BoolAssign_1 = null;

        EObject this_RelationalExpression_2 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1372:28: ( ( ( ( ( RULE_ID ) )=>this_EnumAssign_0= ruleEnumAssign ) | ( ( ( RULE_ID ) )=>this_BoolAssign_1= ruleBoolAssign ) | this_RelationalExpression_2= ruleRelationalExpression ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1373:1: ( ( ( ( RULE_ID ) )=>this_EnumAssign_0= ruleEnumAssign ) | ( ( ( RULE_ID ) )=>this_BoolAssign_1= ruleBoolAssign ) | this_RelationalExpression_2= ruleRelationalExpression )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1373:1: ( ( ( ( RULE_ID ) )=>this_EnumAssign_0= ruleEnumAssign ) | ( ( ( RULE_ID ) )=>this_BoolAssign_1= ruleBoolAssign ) | this_RelationalExpression_2= ruleRelationalExpression )
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 47:
                    {
                    int LA25_2 = input.LA(3);

                    if ( (LA25_2==61) && (synpred4_InternalCitL())) {
                        alt25=2;
                    }
                    else if ( (LA25_2==62) && (synpred4_InternalCitL())) {
                        alt25=2;
                    }
                    else if ( (LA25_2==RULE_INT||LA25_2==36||LA25_2==42) ) {
                        alt25=3;
                    }
                    else if ( (LA25_2==RULE_ID) ) {
                        int LA25_7 = input.LA(4);

                        if ( (LA25_7==EOF||LA25_7==35||LA25_7==37||LA25_7==42||(LA25_7>=49 && LA25_7<=60)) ) {
                            alt25=3;
                        }
                        else if ( (LA25_7==41) && (synpred3_InternalCitL())) {
                            alt25=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 25, 7, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case 48:
                    {
                    int LA25_3 = input.LA(3);

                    if ( (LA25_3==61) && (synpred4_InternalCitL())) {
                        alt25=2;
                    }
                    else if ( (LA25_3==62) && (synpred4_InternalCitL())) {
                        alt25=2;
                    }
                    else if ( (LA25_3==RULE_INT||LA25_3==36||LA25_3==42) ) {
                        alt25=3;
                    }
                    else if ( (LA25_3==RULE_ID) ) {
                        int LA25_7 = input.LA(4);

                        if ( (LA25_7==EOF||LA25_7==35||LA25_7==37||LA25_7==42||(LA25_7>=49 && LA25_7<=60)) ) {
                            alt25=3;
                        }
                        else if ( (LA25_7==41) && (synpred3_InternalCitL())) {
                            alt25=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 25, 7, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 43:
                case 44:
                case 45:
                case 46:
                    {
                    alt25=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1373:2: ( ( ( RULE_ID ) )=>this_EnumAssign_0= ruleEnumAssign )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1373:2: ( ( ( RULE_ID ) )=>this_EnumAssign_0= ruleEnumAssign )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1373:3: ( ( RULE_ID ) )=>this_EnumAssign_0= ruleEnumAssign
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicPredicateAccess().getEnumAssignParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEnumAssign_in_ruleAtomicPredicate3156);
                    this_EnumAssign_0=ruleEnumAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EnumAssign_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1388:6: ( ( ( RULE_ID ) )=>this_BoolAssign_1= ruleBoolAssign )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1388:6: ( ( ( RULE_ID ) )=>this_BoolAssign_1= ruleBoolAssign )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1388:7: ( ( RULE_ID ) )=>this_BoolAssign_1= ruleBoolAssign
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicPredicateAccess().getBoolAssignParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBoolAssign_in_ruleAtomicPredicate3197);
                    this_BoolAssign_1=ruleBoolAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BoolAssign_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1404:5: this_RelationalExpression_2= ruleRelationalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicPredicateAccess().getRelationalExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRelationalExpression_in_ruleAtomicPredicate3225);
                    this_RelationalExpression_2=ruleRelationalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RelationalExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicPredicate"


    // $ANTLR start "entryRuleBoolAssign"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1420:1: entryRuleBoolAssign returns [EObject current=null] : iv_ruleBoolAssign= ruleBoolAssign EOF ;
    public final EObject entryRuleBoolAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolAssign = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1421:2: (iv_ruleBoolAssign= ruleBoolAssign EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1422:2: iv_ruleBoolAssign= ruleBoolAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolAssignRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBoolAssign_in_entryRuleBoolAssign3260);
            iv_ruleBoolAssign=ruleBoolAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolAssign; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoolAssign3270); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolAssign"


    // $ANTLR start "ruleBoolAssign"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1429:1: ruleBoolAssign returns [EObject current=null] : ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( (lv_right_2_0= ruleBooleanConst ) ) ) ;
    public final EObject ruleBoolAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_op_1_0 = null;

        Enumerator lv_right_2_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1432:28: ( ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( (lv_right_2_0= ruleBooleanConst ) ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1433:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( (lv_right_2_0= ruleBooleanConst ) ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1433:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( (lv_right_2_0= ruleBooleanConst ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1433:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( (lv_right_2_0= ruleBooleanConst ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1433:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1433:3: ( ( RULE_ID ) )=> (otherlv_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1439:1: (otherlv_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1440:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getBoolAssignRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBoolAssign3327); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getBoolAssignAccess().getLeftBooleanCrossReference_0_0()); 
              	
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1451:2: ( (lv_op_1_0= ruleAssignmentOperators ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1452:1: (lv_op_1_0= ruleAssignmentOperators )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1452:1: (lv_op_1_0= ruleAssignmentOperators )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1453:3: lv_op_1_0= ruleAssignmentOperators
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBoolAssignAccess().getOpAssignmentOperatorsEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentOperators_in_ruleBoolAssign3348);
            lv_op_1_0=ruleAssignmentOperators();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBoolAssignRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_1_0, 
                      		"AssignmentOperators");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1469:2: ( (lv_right_2_0= ruleBooleanConst ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1470:1: (lv_right_2_0= ruleBooleanConst )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1470:1: (lv_right_2_0= ruleBooleanConst )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1471:3: lv_right_2_0= ruleBooleanConst
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBoolAssignAccess().getRightBooleanConstEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanConst_in_ruleBoolAssign3369);
            lv_right_2_0=ruleBooleanConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBoolAssignRule());
              	        }
                     		set(
                     			current, 
                     			"right",
                      		lv_right_2_0, 
                      		"BooleanConst");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolAssign"


    // $ANTLR start "entryRuleEnumAssign"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1495:1: entryRuleEnumAssign returns [EObject current=null] : iv_ruleEnumAssign= ruleEnumAssign EOF ;
    public final EObject entryRuleEnumAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumAssign = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1496:2: (iv_ruleEnumAssign= ruleEnumAssign EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1497:2: iv_ruleEnumAssign= ruleEnumAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumAssignRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumAssign_in_entryRuleEnumAssign3405);
            iv_ruleEnumAssign=ruleEnumAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumAssign; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumAssign3415); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumAssign"


    // $ANTLR start "ruleEnumAssign"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1504:1: ruleEnumAssign returns [EObject current=null] : ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( ( ruleFQN ) ) ) ;
    public final EObject ruleEnumAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_op_1_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1507:28: ( ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( ( ruleFQN ) ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1508:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( ( ruleFQN ) ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1508:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( ( ruleFQN ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1508:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleAssignmentOperators ) ) ( ( ruleFQN ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1508:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1508:3: ( ( RULE_ID ) )=> (otherlv_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1514:1: (otherlv_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1515:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumAssignRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumAssign3472); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getEnumAssignAccess().getLeftEnumerativeCrossReference_0_0()); 
              	
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1526:2: ( (lv_op_1_0= ruleAssignmentOperators ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1527:1: (lv_op_1_0= ruleAssignmentOperators )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1527:1: (lv_op_1_0= ruleAssignmentOperators )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1528:3: lv_op_1_0= ruleAssignmentOperators
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEnumAssignAccess().getOpAssignmentOperatorsEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentOperators_in_ruleEnumAssign3493);
            lv_op_1_0=ruleAssignmentOperators();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEnumAssignRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_1_0, 
                      		"AssignmentOperators");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1544:2: ( ( ruleFQN ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1545:1: ( ruleFQN )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1545:1: ( ruleFQN )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1546:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumAssignRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEnumAssignAccess().getRightElementCrossReference_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleEnumAssign3516);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumAssign"


    // $ANTLR start "entryRuleRelationalExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1567:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1568:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1569:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression3552);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRelationalExpression3562); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1576:1: ruleRelationalExpression returns [EObject current=null] : ( ( ( ( ( RULE_ID ) ) ( ( ( ruleAssignmentOperators | ruleRelationalOperators ) ) ) ( ( rulePlusMinus ) ) ) )=> ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) ) ) ( (lv_right_2_0= rulePlusMinus ) ) ) ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_op_1_1 = null;

        Enumerator lv_op_1_2 = null;

        EObject lv_right_2_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1579:28: ( ( ( ( ( ( RULE_ID ) ) ( ( ( ruleAssignmentOperators | ruleRelationalOperators ) ) ) ( ( rulePlusMinus ) ) ) )=> ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) ) ) ( (lv_right_2_0= rulePlusMinus ) ) ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1580:1: ( ( ( ( ( RULE_ID ) ) ( ( ( ruleAssignmentOperators | ruleRelationalOperators ) ) ) ( ( rulePlusMinus ) ) ) )=> ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) ) ) ( (lv_right_2_0= rulePlusMinus ) ) ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1580:1: ( ( ( ( ( RULE_ID ) ) ( ( ( ruleAssignmentOperators | ruleRelationalOperators ) ) ) ( ( rulePlusMinus ) ) ) )=> ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) ) ) ( (lv_right_2_0= rulePlusMinus ) ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1580:2: ( ( ( ( RULE_ID ) ) ( ( ( ruleAssignmentOperators | ruleRelationalOperators ) ) ) ( ( rulePlusMinus ) ) ) )=> ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) ) ) ( (lv_right_2_0= rulePlusMinus ) ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1597:6: ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) ) ) ( (lv_right_2_0= rulePlusMinus ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1597:7: ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) ) ) ( (lv_right_2_0= rulePlusMinus ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1597:7: ( (otherlv_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1598:1: (otherlv_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1598:1: (otherlv_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1599:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRelationalExpression3654); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getRelationalExpressionAccess().getLeftNumericalCrossReference_0_0_0()); 
              	
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1610:2: ( ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1611:1: ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1611:1: ( (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1612:1: (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1612:1: (lv_op_1_1= ruleAssignmentOperators | lv_op_1_2= ruleRelationalOperators )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=47 && LA26_0<=48)) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=43 && LA26_0<=46)) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1613:3: lv_op_1_1= ruleAssignmentOperators
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpAssignmentOperatorsEnumRuleCall_0_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAssignmentOperators_in_ruleRelationalExpression3677);
                    lv_op_1_1=ruleAssignmentOperators();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"op",
                              		lv_op_1_1, 
                              		"AssignmentOperators");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1628:8: lv_op_1_2= ruleRelationalOperators
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorsEnumRuleCall_0_1_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRelationalOperators_in_ruleRelationalExpression3696);
                    lv_op_1_2=ruleRelationalOperators();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"op",
                              		lv_op_1_2, 
                              		"RelationalOperators");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1646:2: ( (lv_right_2_0= rulePlusMinus ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1647:1: (lv_right_2_0= rulePlusMinus )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1647:1: (lv_right_2_0= rulePlusMinus )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1648:3: lv_right_2_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightPlusMinusParserRuleCall_0_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePlusMinus_in_ruleRelationalExpression3720);
            lv_right_2_0=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"right",
                      		lv_right_2_0, 
                      		"PlusMinus");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRulePlusMinus"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1672:1: entryRulePlusMinus returns [EObject current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final EObject entryRulePlusMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusMinus = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1673:2: (iv_rulePlusMinus= rulePlusMinus EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1674:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusMinusRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePlusMinus_in_entryRulePlusMinus3757);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusMinus; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePlusMinus3767); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusMinus"


    // $ANTLR start "rulePlusMinus"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1681:1: rulePlusMinus returns [EObject current=null] : (this_ModMultDiv_0= ruleModMultDiv ( () ( (lv_op_2_0= rulePlusMinusOperators ) ) ( (lv_right_3_0= ruleModMultDiv ) ) )* ) ;
    public final EObject rulePlusMinus() throws RecognitionException {
        EObject current = null;

        EObject this_ModMultDiv_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1684:28: ( (this_ModMultDiv_0= ruleModMultDiv ( () ( (lv_op_2_0= rulePlusMinusOperators ) ) ( (lv_right_3_0= ruleModMultDiv ) ) )* ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1685:1: (this_ModMultDiv_0= ruleModMultDiv ( () ( (lv_op_2_0= rulePlusMinusOperators ) ) ( (lv_right_3_0= ruleModMultDiv ) ) )* )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1685:1: (this_ModMultDiv_0= ruleModMultDiv ( () ( (lv_op_2_0= rulePlusMinusOperators ) ) ( (lv_right_3_0= ruleModMultDiv ) ) )* )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1686:5: this_ModMultDiv_0= ruleModMultDiv ( () ( (lv_op_2_0= rulePlusMinusOperators ) ) ( (lv_right_3_0= ruleModMultDiv ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPlusMinusAccess().getModMultDivParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleModMultDiv_in_rulePlusMinus3814);
            this_ModMultDiv_0=ruleModMultDiv();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ModMultDiv_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1694:1: ( () ( (lv_op_2_0= rulePlusMinusOperators ) ) ( (lv_right_3_0= ruleModMultDiv ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==42||LA27_0==55) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1694:2: () ( (lv_op_2_0= rulePlusMinusOperators ) ) ( (lv_right_3_0= ruleModMultDiv ) )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1694:2: ()
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1695:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPlusMinusAccess().getPlusMinusLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1700:2: ( (lv_op_2_0= rulePlusMinusOperators ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1701:1: (lv_op_2_0= rulePlusMinusOperators )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1701:1: (lv_op_2_0= rulePlusMinusOperators )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1702:3: lv_op_2_0= rulePlusMinusOperators
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPlusMinusAccess().getOpPlusMinusOperatorsEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulePlusMinusOperators_in_rulePlusMinus3844);
            	    lv_op_2_0=rulePlusMinusOperators();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPlusMinusRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"op",
            	              		lv_op_2_0, 
            	              		"PlusMinusOperators");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1718:2: ( (lv_right_3_0= ruleModMultDiv ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1719:1: (lv_right_3_0= ruleModMultDiv )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1719:1: (lv_right_3_0= ruleModMultDiv )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1720:3: lv_right_3_0= ruleModMultDiv
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPlusMinusAccess().getRightModMultDivParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModMultDiv_in_rulePlusMinus3865);
            	    lv_right_3_0=ruleModMultDiv();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPlusMinusRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"ModMultDiv");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusMinus"


    // $ANTLR start "entryRuleModMultDiv"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1744:1: entryRuleModMultDiv returns [EObject current=null] : iv_ruleModMultDiv= ruleModMultDiv EOF ;
    public final EObject entryRuleModMultDiv() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModMultDiv = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1745:2: (iv_ruleModMultDiv= ruleModMultDiv EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1746:2: iv_ruleModMultDiv= ruleModMultDiv EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModMultDivRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModMultDiv_in_entryRuleModMultDiv3903);
            iv_ruleModMultDiv=ruleModMultDiv();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModMultDiv; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModMultDiv3913); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModMultDiv"


    // $ANTLR start "ruleModMultDiv"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1753:1: ruleModMultDiv returns [EObject current=null] : (this_Numeric_0= ruleNumeric ( () ( (lv_op_2_0= ruleModMultDivOperators ) ) ( (lv_right_3_0= ruleNumeric ) ) )* ) ;
    public final EObject ruleModMultDiv() throws RecognitionException {
        EObject current = null;

        EObject this_Numeric_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1756:28: ( (this_Numeric_0= ruleNumeric ( () ( (lv_op_2_0= ruleModMultDivOperators ) ) ( (lv_right_3_0= ruleNumeric ) ) )* ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1757:1: (this_Numeric_0= ruleNumeric ( () ( (lv_op_2_0= ruleModMultDivOperators ) ) ( (lv_right_3_0= ruleNumeric ) ) )* )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1757:1: (this_Numeric_0= ruleNumeric ( () ( (lv_op_2_0= ruleModMultDivOperators ) ) ( (lv_right_3_0= ruleNumeric ) ) )* )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1758:5: this_Numeric_0= ruleNumeric ( () ( (lv_op_2_0= ruleModMultDivOperators ) ) ( (lv_right_3_0= ruleNumeric ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getModMultDivAccess().getNumericParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumeric_in_ruleModMultDiv3960);
            this_Numeric_0=ruleNumeric();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Numeric_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1766:1: ( () ( (lv_op_2_0= ruleModMultDivOperators ) ) ( (lv_right_3_0= ruleNumeric ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=56 && LA28_0<=58)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1766:2: () ( (lv_op_2_0= ruleModMultDivOperators ) ) ( (lv_right_3_0= ruleNumeric ) )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1766:2: ()
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1767:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getModMultDivAccess().getModMultDivLeftAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1772:2: ( (lv_op_2_0= ruleModMultDivOperators ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1773:1: (lv_op_2_0= ruleModMultDivOperators )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1773:1: (lv_op_2_0= ruleModMultDivOperators )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1774:3: lv_op_2_0= ruleModMultDivOperators
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModMultDivAccess().getOpModMultDivOperatorsEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModMultDivOperators_in_ruleModMultDiv3990);
            	    lv_op_2_0=ruleModMultDivOperators();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModMultDivRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"op",
            	              		lv_op_2_0, 
            	              		"ModMultDivOperators");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1790:2: ( (lv_right_3_0= ruleNumeric ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1791:1: (lv_right_3_0= ruleNumeric )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1791:1: (lv_right_3_0= ruleNumeric )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1792:3: lv_right_3_0= ruleNumeric
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModMultDivAccess().getRightNumericParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNumeric_in_ruleModMultDiv4011);
            	    lv_right_3_0=ruleNumeric();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModMultDivRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"Numeric");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModMultDiv"


    // $ANTLR start "entryRuleNumeric"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1816:1: entryRuleNumeric returns [EObject current=null] : iv_ruleNumeric= ruleNumeric EOF ;
    public final EObject entryRuleNumeric() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumeric = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1817:2: (iv_ruleNumeric= ruleNumeric EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1818:2: iv_ruleNumeric= ruleNumeric EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumeric_in_entryRuleNumeric4049);
            iv_ruleNumeric=ruleNumeric();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumeric; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumeric4059); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumeric"


    // $ANTLR start "ruleNumeric"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1825:1: ruleNumeric returns [EObject current=null] : (this_NumberLiteral_0= ruleNumberLiteral | (otherlv_1= '(' this_PlusMinus_2= rulePlusMinus otherlv_3= ')' ) ) ;
    public final EObject ruleNumeric() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_NumberLiteral_0 = null;

        EObject this_PlusMinus_2 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1828:28: ( (this_NumberLiteral_0= ruleNumberLiteral | (otherlv_1= '(' this_PlusMinus_2= rulePlusMinus otherlv_3= ')' ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1829:1: (this_NumberLiteral_0= ruleNumberLiteral | (otherlv_1= '(' this_PlusMinus_2= rulePlusMinus otherlv_3= ')' ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1829:1: (this_NumberLiteral_0= ruleNumberLiteral | (otherlv_1= '(' this_PlusMinus_2= rulePlusMinus otherlv_3= ')' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_INT)||LA29_0==42) ) {
                alt29=1;
            }
            else if ( (LA29_0==36) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1830:5: this_NumberLiteral_0= ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericAccess().getNumberLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteral_in_ruleNumeric4106);
                    this_NumberLiteral_0=ruleNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NumberLiteral_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1839:6: (otherlv_1= '(' this_PlusMinus_2= rulePlusMinus otherlv_3= ')' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1839:6: (otherlv_1= '(' this_PlusMinus_2= rulePlusMinus otherlv_3= ')' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1839:8: otherlv_1= '(' this_PlusMinus_2= rulePlusMinus otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleNumeric4124); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getNumericAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumericAccess().getPlusMinusParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePlusMinus_in_ruleNumeric4146);
                    this_PlusMinus_2=rulePlusMinus();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PlusMinus_2; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleNumeric4157); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumericAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumeric"


    // $ANTLR start "entryRuleNumberLiteral"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1864:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1865:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1866:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral4194);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteral4204); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1873:1: ruleNumberLiteral returns [EObject current=null] : ( ( (lv_number_0_0= rulePossiblySignedNumber ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_number_0_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1876:28: ( ( ( (lv_number_0_0= rulePossiblySignedNumber ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1877:1: ( ( (lv_number_0_0= rulePossiblySignedNumber ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1877:1: ( ( (lv_number_0_0= rulePossiblySignedNumber ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_INT||LA30_0==42) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_ID) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1877:2: ( (lv_number_0_0= rulePossiblySignedNumber ) )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1877:2: ( (lv_number_0_0= rulePossiblySignedNumber ) )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1878:1: (lv_number_0_0= rulePossiblySignedNumber )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1878:1: (lv_number_0_0= rulePossiblySignedNumber )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1879:3: lv_number_0_0= rulePossiblySignedNumber
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumberLiteralAccess().getNumberPossiblySignedNumberParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePossiblySignedNumber_in_ruleNumberLiteral4250);
                    lv_number_0_0=rulePossiblySignedNumber();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumberLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"number",
                              		lv_number_0_0, 
                              		"PossiblySignedNumber");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1896:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1896:6: ( (otherlv_1= RULE_ID ) )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1897:1: (otherlv_1= RULE_ID )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1897:1: (otherlv_1= RULE_ID )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1898:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getNumberLiteralRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNumberLiteral4276); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getNumberLiteralAccess().getNumericalNumericalExCrossReference_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleSeed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1917:1: entryRuleSeed returns [EObject current=null] : iv_ruleSeed= ruleSeed EOF ;
    public final EObject entryRuleSeed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSeed = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1918:2: (iv_ruleSeed= ruleSeed EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1919:2: iv_ruleSeed= ruleSeed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSeedRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSeed_in_entryRuleSeed4312);
            iv_ruleSeed=ruleSeed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSeed; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSeed4322); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSeed"


    // $ANTLR start "ruleSeed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1926:1: ruleSeed returns [EObject current=null] : (otherlv_0= '#' ( (lv_AssigmentSeedList_1_0= ruleAseed ) ) (otherlv_2= ',' ( (lv_AssigmentSeedList_3_0= ruleAseed ) ) )* otherlv_4= '#' ) ;
    public final EObject ruleSeed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_AssigmentSeedList_1_0 = null;

        EObject lv_AssigmentSeedList_3_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1929:28: ( (otherlv_0= '#' ( (lv_AssigmentSeedList_1_0= ruleAseed ) ) (otherlv_2= ',' ( (lv_AssigmentSeedList_3_0= ruleAseed ) ) )* otherlv_4= '#' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1930:1: (otherlv_0= '#' ( (lv_AssigmentSeedList_1_0= ruleAseed ) ) (otherlv_2= ',' ( (lv_AssigmentSeedList_3_0= ruleAseed ) ) )* otherlv_4= '#' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1930:1: (otherlv_0= '#' ( (lv_AssigmentSeedList_1_0= ruleAseed ) ) (otherlv_2= ',' ( (lv_AssigmentSeedList_3_0= ruleAseed ) ) )* otherlv_4= '#' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1930:3: otherlv_0= '#' ( (lv_AssigmentSeedList_1_0= ruleAseed ) ) (otherlv_2= ',' ( (lv_AssigmentSeedList_3_0= ruleAseed ) ) )* otherlv_4= '#'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSeed4359); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSeedAccess().getNumberSignKeyword_0());
                  
            }
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1934:1: ( (lv_AssigmentSeedList_1_0= ruleAseed ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1935:1: (lv_AssigmentSeedList_1_0= ruleAseed )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1935:1: (lv_AssigmentSeedList_1_0= ruleAseed )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1936:3: lv_AssigmentSeedList_1_0= ruleAseed
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSeedAccess().getAssigmentSeedListAseedParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAseed_in_ruleSeed4380);
            lv_AssigmentSeedList_1_0=ruleAseed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSeedRule());
              	        }
                     		add(
                     			current, 
                     			"AssigmentSeedList",
                      		lv_AssigmentSeedList_1_0, 
                      		"Aseed");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1952:2: (otherlv_2= ',' ( (lv_AssigmentSeedList_3_0= ruleAseed ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==40) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1952:4: otherlv_2= ',' ( (lv_AssigmentSeedList_3_0= ruleAseed ) )
            	    {
            	    otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSeed4393); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSeedAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1956:1: ( (lv_AssigmentSeedList_3_0= ruleAseed ) )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1957:1: (lv_AssigmentSeedList_3_0= ruleAseed )
            	    {
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1957:1: (lv_AssigmentSeedList_3_0= ruleAseed )
            	    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1958:3: lv_AssigmentSeedList_3_0= ruleAseed
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSeedAccess().getAssigmentSeedListAseedParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAseed_in_ruleSeed4414);
            	    lv_AssigmentSeedList_3_0=ruleAseed();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSeedRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"AssigmentSeedList",
            	              		lv_AssigmentSeedList_3_0, 
            	              		"Aseed");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_4=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSeed4428); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSeedAccess().getNumberSignKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSeed"


    // $ANTLR start "entryRuleAseed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1986:1: entryRuleAseed returns [EObject current=null] : iv_ruleAseed= ruleAseed EOF ;
    public final EObject entryRuleAseed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAseed = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1987:2: (iv_ruleAseed= ruleAseed EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1988:2: iv_ruleAseed= ruleAseed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAseedRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAseed_in_entryRuleAseed4464);
            iv_ruleAseed=ruleAseed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAseed; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAseed4474); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAseed"


    // $ANTLR start "ruleAseed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1995:1: ruleAseed returns [EObject current=null] : ( ( ( ( RULE_ID ) )=>this_EnumSeed_0= ruleEnumSeed ) | ( ( ( RULE_ID ) )=>this_BoolAssignSeed_1= ruleBoolAssignSeed ) | ( ( ( RULE_ID ) )=>this_NumericalSeed_2= ruleNumericalSeed ) ) ;
    public final EObject ruleAseed() throws RecognitionException {
        EObject current = null;

        EObject this_EnumSeed_0 = null;

        EObject this_BoolAssignSeed_1 = null;

        EObject this_NumericalSeed_2 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1998:28: ( ( ( ( ( RULE_ID ) )=>this_EnumSeed_0= ruleEnumSeed ) | ( ( ( RULE_ID ) )=>this_BoolAssignSeed_1= ruleBoolAssignSeed ) | ( ( ( RULE_ID ) )=>this_NumericalSeed_2= ruleNumericalSeed ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1999:1: ( ( ( ( RULE_ID ) )=>this_EnumSeed_0= ruleEnumSeed ) | ( ( ( RULE_ID ) )=>this_BoolAssignSeed_1= ruleBoolAssignSeed ) | ( ( ( RULE_ID ) )=>this_NumericalSeed_2= ruleNumericalSeed ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1999:1: ( ( ( ( RULE_ID ) )=>this_EnumSeed_0= ruleEnumSeed ) | ( ( ( RULE_ID ) )=>this_BoolAssignSeed_1= ruleBoolAssignSeed ) | ( ( ( RULE_ID ) )=>this_NumericalSeed_2= ruleNumericalSeed ) )
            int alt32=3;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1999:2: ( ( ( RULE_ID ) )=>this_EnumSeed_0= ruleEnumSeed )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1999:2: ( ( ( RULE_ID ) )=>this_EnumSeed_0= ruleEnumSeed )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1999:3: ( ( RULE_ID ) )=>this_EnumSeed_0= ruleEnumSeed
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAseedAccess().getEnumSeedParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEnumSeed_in_ruleAseed4534);
                    this_EnumSeed_0=ruleEnumSeed();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EnumSeed_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2014:6: ( ( ( RULE_ID ) )=>this_BoolAssignSeed_1= ruleBoolAssignSeed )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2014:6: ( ( ( RULE_ID ) )=>this_BoolAssignSeed_1= ruleBoolAssignSeed )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2014:7: ( ( RULE_ID ) )=>this_BoolAssignSeed_1= ruleBoolAssignSeed
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAseedAccess().getBoolAssignSeedParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBoolAssignSeed_in_ruleAseed4575);
                    this_BoolAssignSeed_1=ruleBoolAssignSeed();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BoolAssignSeed_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2029:6: ( ( ( RULE_ID ) )=>this_NumericalSeed_2= ruleNumericalSeed )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2029:6: ( ( ( RULE_ID ) )=>this_NumericalSeed_2= ruleNumericalSeed )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2029:7: ( ( RULE_ID ) )=>this_NumericalSeed_2= ruleNumericalSeed
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAseedAccess().getNumericalSeedParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumericalSeed_in_ruleAseed4616);
                    this_NumericalSeed_2=ruleNumericalSeed();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NumericalSeed_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAseed"


    // $ANTLR start "entryRuleSeedNumberLiteral"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2051:1: entryRuleSeedNumberLiteral returns [EObject current=null] : iv_ruleSeedNumberLiteral= ruleSeedNumberLiteral EOF ;
    public final EObject entryRuleSeedNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSeedNumberLiteral = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2052:2: (iv_ruleSeedNumberLiteral= ruleSeedNumberLiteral EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2053:2: iv_ruleSeedNumberLiteral= ruleSeedNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSeedNumberLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSeedNumberLiteral_in_entryRuleSeedNumberLiteral4652);
            iv_ruleSeedNumberLiteral=ruleSeedNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSeedNumberLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSeedNumberLiteral4662); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSeedNumberLiteral"


    // $ANTLR start "ruleSeedNumberLiteral"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2060:1: ruleSeedNumberLiteral returns [EObject current=null] : ( ( (lv_number_0_0= rulePossiblySignedNumber ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleSeedNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_number_0_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2063:28: ( ( ( (lv_number_0_0= rulePossiblySignedNumber ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2064:1: ( ( (lv_number_0_0= rulePossiblySignedNumber ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2064:1: ( ( (lv_number_0_0= rulePossiblySignedNumber ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_INT||LA33_0==42) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_ID) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2064:2: ( (lv_number_0_0= rulePossiblySignedNumber ) )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2064:2: ( (lv_number_0_0= rulePossiblySignedNumber ) )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2065:1: (lv_number_0_0= rulePossiblySignedNumber )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2065:1: (lv_number_0_0= rulePossiblySignedNumber )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2066:3: lv_number_0_0= rulePossiblySignedNumber
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSeedNumberLiteralAccess().getNumberPossiblySignedNumberParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePossiblySignedNumber_in_ruleSeedNumberLiteral4708);
                    lv_number_0_0=rulePossiblySignedNumber();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSeedNumberLiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"number",
                              		lv_number_0_0, 
                              		"PossiblySignedNumber");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2083:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2083:6: ( (otherlv_1= RULE_ID ) )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2084:1: (otherlv_1= RULE_ID )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2084:1: (otherlv_1= RULE_ID )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2085:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getSeedNumberLiteralRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSeedNumberLiteral4734); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getSeedNumberLiteralAccess().getConstantConstantNumberCrossReference_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSeedNumberLiteral"


    // $ANTLR start "entryRuleEnumSeed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2104:1: entryRuleEnumSeed returns [EObject current=null] : iv_ruleEnumSeed= ruleEnumSeed EOF ;
    public final EObject entryRuleEnumSeed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumSeed = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2105:2: (iv_ruleEnumSeed= ruleEnumSeed EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2106:2: iv_ruleEnumSeed= ruleEnumSeed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumSeedRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEnumSeed_in_entryRuleEnumSeed4770);
            iv_ruleEnumSeed=ruleEnumSeed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumSeed; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumSeed4780); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumSeed"


    // $ANTLR start "ruleEnumSeed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2113:1: ruleEnumSeed returns [EObject current=null] : ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( ( ruleFQN ) ) ) ;
    public final EObject ruleEnumSeed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_op_1_0=null;

         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2116:28: ( ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( ( ruleFQN ) ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2117:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( ( ruleFQN ) ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2117:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( ( ruleFQN ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2117:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( ( ruleFQN ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2117:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2117:3: ( ( RULE_ID ) )=> (otherlv_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2123:1: (otherlv_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2124:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumSeedRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumSeed4837); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getEnumSeedAccess().getLeftEnumerativeCrossReference_0_0()); 
              	
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2135:2: ( (lv_op_1_0= '=' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2136:1: (lv_op_1_0= '=' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2136:1: (lv_op_1_0= '=' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2137:3: lv_op_1_0= '='
            {
            lv_op_1_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEnumSeed4855); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_op_1_0, grammarAccess.getEnumSeedAccess().getOpEqualsSignKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumSeedRule());
              	        }
                     		setWithLastConsumed(current, "op", lv_op_1_0, "=");
              	    
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2150:2: ( ( ruleFQN ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2151:1: ( ruleFQN )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2151:1: ( ruleFQN )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2152:3: ruleFQN
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumSeedRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEnumSeedAccess().getRightElementCrossReference_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleEnumSeed4891);
            ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumSeed"


    // $ANTLR start "entryRuleNumericalSeed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2173:1: entryRuleNumericalSeed returns [EObject current=null] : iv_ruleNumericalSeed= ruleNumericalSeed EOF ;
    public final EObject entryRuleNumericalSeed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalSeed = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2174:2: (iv_ruleNumericalSeed= ruleNumericalSeed EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2175:2: iv_ruleNumericalSeed= ruleNumericalSeed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalSeedRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumericalSeed_in_entryRuleNumericalSeed4927);
            iv_ruleNumericalSeed=ruleNumericalSeed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalSeed; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumericalSeed4937); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericalSeed"


    // $ANTLR start "ruleNumericalSeed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2182:1: ruleNumericalSeed returns [EObject current=null] : ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleSeedNumberLiteral ) ) ) ;
    public final EObject ruleNumericalSeed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_op_1_0=null;
        EObject lv_right_2_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2185:28: ( ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleSeedNumberLiteral ) ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2186:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleSeedNumberLiteral ) ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2186:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleSeedNumberLiteral ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2186:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleSeedNumberLiteral ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2186:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2186:3: ( ( RULE_ID ) )=> (otherlv_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2192:1: (otherlv_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2193:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getNumericalSeedRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNumericalSeed4994); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getNumericalSeedAccess().getLeftNumericalCrossReference_0_0()); 
              	
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2204:2: ( (lv_op_1_0= '=' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2205:1: (lv_op_1_0= '=' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2205:1: (lv_op_1_0= '=' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2206:3: lv_op_1_0= '='
            {
            lv_op_1_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleNumericalSeed5012); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_op_1_0, grammarAccess.getNumericalSeedAccess().getOpEqualsSignKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNumericalSeedRule());
              	        }
                     		setWithLastConsumed(current, "op", lv_op_1_0, "=");
              	    
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2219:2: ( (lv_right_2_0= ruleSeedNumberLiteral ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2220:1: (lv_right_2_0= ruleSeedNumberLiteral )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2220:1: (lv_right_2_0= ruleSeedNumberLiteral )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2221:3: lv_right_2_0= ruleSeedNumberLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumericalSeedAccess().getRightSeedNumberLiteralParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSeedNumberLiteral_in_ruleNumericalSeed5046);
            lv_right_2_0=ruleSeedNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumericalSeedRule());
              	        }
                     		set(
                     			current, 
                     			"right",
                      		lv_right_2_0, 
                      		"SeedNumberLiteral");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericalSeed"


    // $ANTLR start "entryRuleBoolAssignSeed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2245:1: entryRuleBoolAssignSeed returns [EObject current=null] : iv_ruleBoolAssignSeed= ruleBoolAssignSeed EOF ;
    public final EObject entryRuleBoolAssignSeed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolAssignSeed = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2246:2: (iv_ruleBoolAssignSeed= ruleBoolAssignSeed EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2247:2: iv_ruleBoolAssignSeed= ruleBoolAssignSeed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolAssignSeedRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBoolAssignSeed_in_entryRuleBoolAssignSeed5082);
            iv_ruleBoolAssignSeed=ruleBoolAssignSeed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolAssignSeed; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoolAssignSeed5092); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolAssignSeed"


    // $ANTLR start "ruleBoolAssignSeed"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2254:1: ruleBoolAssignSeed returns [EObject current=null] : ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleBooleanConst ) ) ) ;
    public final EObject ruleBoolAssignSeed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_op_1_0=null;
        Enumerator lv_right_2_0 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2257:28: ( ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleBooleanConst ) ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2258:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleBooleanConst ) ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2258:1: ( ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleBooleanConst ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2258:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= '=' ) ) ( (lv_right_2_0= ruleBooleanConst ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2258:2: ( ( ( RULE_ID ) )=> (otherlv_0= RULE_ID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2258:3: ( ( RULE_ID ) )=> (otherlv_0= RULE_ID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2264:1: (otherlv_0= RULE_ID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2265:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getBoolAssignSeedRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBoolAssignSeed5149); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getBoolAssignSeedAccess().getLeftBooleanCrossReference_0_0()); 
              	
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2276:2: ( (lv_op_1_0= '=' ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2277:1: (lv_op_1_0= '=' )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2277:1: (lv_op_1_0= '=' )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2278:3: lv_op_1_0= '='
            {
            lv_op_1_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleBoolAssignSeed5167); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_op_1_0, grammarAccess.getBoolAssignSeedAccess().getOpEqualsSignKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBoolAssignSeedRule());
              	        }
                     		setWithLastConsumed(current, "op", lv_op_1_0, "=");
              	    
            }

            }


            }

            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2291:2: ( (lv_right_2_0= ruleBooleanConst ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2292:1: (lv_right_2_0= ruleBooleanConst )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2292:1: (lv_right_2_0= ruleBooleanConst )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2293:3: lv_right_2_0= ruleBooleanConst
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBoolAssignSeedAccess().getRightBooleanConstEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanConst_in_ruleBoolAssignSeed5201);
            lv_right_2_0=ruleBooleanConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBoolAssignSeedRule());
              	        }
                     		set(
                     			current, 
                     			"right",
                      		lv_right_2_0, 
                      		"BooleanConst");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolAssignSeed"


    // $ANTLR start "entryRuleelementID"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2317:1: entryRuleelementID returns [String current=null] : iv_ruleelementID= ruleelementID EOF ;
    public final String entryRuleelementID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleelementID = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2318:2: (iv_ruleelementID= ruleelementID EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2319:2: iv_ruleelementID= ruleelementID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleelementID_in_entryRuleelementID5238);
            iv_ruleelementID=ruleelementID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleelementID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleelementID5249); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleelementID"


    // $ANTLR start "ruleelementID"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2326:1: ruleelementID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_NUMID_1= RULE_NUMID ) ;
    public final AntlrDatatypeRuleToken ruleelementID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_NUMID_1=null;

         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2329:28: ( (this_ID_0= RULE_ID | this_NUMID_1= RULE_NUMID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2330:1: (this_ID_0= RULE_ID | this_NUMID_1= RULE_NUMID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2330:1: (this_ID_0= RULE_ID | this_NUMID_1= RULE_NUMID )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_NUMID) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2330:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleelementID5289); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getElementIDAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2338:10: this_NUMID_1= RULE_NUMID
                    {
                    this_NUMID_1=(Token)match(input,RULE_NUMID,FollowSets000.FOLLOW_RULE_NUMID_in_ruleelementID5315); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NUMID_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NUMID_1, grammarAccess.getElementIDAccess().getNUMIDTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleelementID"


    // $ANTLR start "entryRuleFQN"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2353:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2354:2: (iv_ruleFQN= ruleFQN EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2355:2: iv_ruleFQN= ruleFQN EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFQNRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN5361);
            iv_ruleFQN=ruleFQN();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFQN.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN5372); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2362:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_elementID_2= ruleelementID ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_elementID_2 = null;


         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2365:28: ( (this_ID_0= RULE_ID kw= '.' this_elementID_2= ruleelementID ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2366:1: (this_ID_0= RULE_ID kw= '.' this_elementID_2= ruleelementID )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2366:1: (this_ID_0= RULE_ID kw= '.' this_elementID_2= ruleelementID )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2366:6: this_ID_0= RULE_ID kw= '.' this_elementID_2= ruleelementID
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN5412); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleFQN5430); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getFQNAccess().getElementIDParserRuleCall_2()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleelementID_in_ruleFQN5452);
            this_elementID_2=ruleelementID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_elementID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRulePossiblySignedNumber"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2398:1: entryRulePossiblySignedNumber returns [String current=null] : iv_rulePossiblySignedNumber= rulePossiblySignedNumber EOF ;
    public final String entryRulePossiblySignedNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePossiblySignedNumber = null;


        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2399:2: (iv_rulePossiblySignedNumber= rulePossiblySignedNumber EOF )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2400:2: iv_rulePossiblySignedNumber= rulePossiblySignedNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPossiblySignedNumberRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePossiblySignedNumber_in_entryRulePossiblySignedNumber5498);
            iv_rulePossiblySignedNumber=rulePossiblySignedNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePossiblySignedNumber.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePossiblySignedNumber5509); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePossiblySignedNumber"


    // $ANTLR start "rulePossiblySignedNumber"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2407:1: rulePossiblySignedNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken rulePossiblySignedNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2410:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2411:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2411:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2411:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2411:2: (kw= '-' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==42) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2412:2: kw= '-'
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_42_in_rulePossiblySignedNumber5548); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPossiblySignedNumberAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePossiblySignedNumber5565); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_1, grammarAccess.getPossiblySignedNumberAccess().getINTTerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePossiblySignedNumber"


    // $ANTLR start "ruleRelationalOperators"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2432:1: ruleRelationalOperators returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) ) ;
    public final Enumerator ruleRelationalOperators() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2434:28: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2435:1: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2435:1: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) )
            int alt36=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt36=1;
                }
                break;
            case 44:
                {
                alt36=2;
                }
                break;
            case 45:
                {
                alt36=3;
                }
                break;
            case 46:
                {
                alt36=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2435:2: (enumLiteral_0= '>' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2435:2: (enumLiteral_0= '>' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2435:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleRelationalOperators5624); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorsAccess().getGTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorsAccess().getGTEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2441:6: (enumLiteral_1= '<' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2441:6: (enumLiteral_1= '<' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2441:8: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleRelationalOperators5641); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorsAccess().getLTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorsAccess().getLTEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2447:6: (enumLiteral_2= '>=' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2447:6: (enumLiteral_2= '>=' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2447:8: enumLiteral_2= '>='
                    {
                    enumLiteral_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleRelationalOperators5658); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorsAccess().getGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorsAccess().getGEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2453:6: (enumLiteral_3= '<=' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2453:6: (enumLiteral_3= '<=' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2453:8: enumLiteral_3= '<='
                    {
                    enumLiteral_3=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleRelationalOperators5675); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorsAccess().getLEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorsAccess().getLEEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOperators"


    // $ANTLR start "ruleAssignmentOperators"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2463:1: ruleAssignmentOperators returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleAssignmentOperators() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2465:28: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2466:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2466:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==47) ) {
                alt37=1;
            }
            else if ( (LA37_0==48) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2466:2: (enumLiteral_0= '==' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2466:2: (enumLiteral_0= '==' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2466:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleAssignmentOperators5720); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorsAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAssignmentOperatorsAccess().getEQEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2472:6: (enumLiteral_1= '!=' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2472:6: (enumLiteral_1= '!=' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2472:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleAssignmentOperators5737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorsAccess().getNEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAssignmentOperatorsAccess().getNEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperators"


    // $ANTLR start "ruleAndOperators"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2482:1: ruleAndOperators returns [Enumerator current=null] : ( (enumLiteral_0= '&&' ) | (enumLiteral_1= 'and' ) | (enumLiteral_2= 'AND' ) ) ;
    public final Enumerator ruleAndOperators() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2484:28: ( ( (enumLiteral_0= '&&' ) | (enumLiteral_1= 'and' ) | (enumLiteral_2= 'AND' ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2485:1: ( (enumLiteral_0= '&&' ) | (enumLiteral_1= 'and' ) | (enumLiteral_2= 'AND' ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2485:1: ( (enumLiteral_0= '&&' ) | (enumLiteral_1= 'and' ) | (enumLiteral_2= 'AND' ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt38=1;
                }
                break;
            case 50:
                {
                alt38=2;
                }
                break;
            case 51:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2485:2: (enumLiteral_0= '&&' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2485:2: (enumLiteral_0= '&&' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2485:4: enumLiteral_0= '&&'
                    {
                    enumLiteral_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleAndOperators5782); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAndOperatorsAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAndOperatorsAccess().getAndEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2491:6: (enumLiteral_1= 'and' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2491:6: (enumLiteral_1= 'and' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2491:8: enumLiteral_1= 'and'
                    {
                    enumLiteral_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleAndOperators5799); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAndOperatorsAccess().getAndmiEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAndOperatorsAccess().getAndmiEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2497:6: (enumLiteral_2= 'AND' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2497:6: (enumLiteral_2= 'AND' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2497:8: enumLiteral_2= 'AND'
                    {
                    enumLiteral_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleAndOperators5816); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAndOperatorsAccess().getANDmaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAndOperatorsAccess().getANDmaEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndOperators"


    // $ANTLR start "ruleOrOperators"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2507:1: ruleOrOperators returns [Enumerator current=null] : ( (enumLiteral_0= '||' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'OR' ) ) ;
    public final Enumerator ruleOrOperators() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2509:28: ( ( (enumLiteral_0= '||' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'OR' ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2510:1: ( (enumLiteral_0= '||' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'OR' ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2510:1: ( (enumLiteral_0= '||' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'OR' ) )
            int alt39=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt39=1;
                }
                break;
            case 53:
                {
                alt39=2;
                }
                break;
            case 54:
                {
                alt39=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2510:2: (enumLiteral_0= '||' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2510:2: (enumLiteral_0= '||' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2510:4: enumLiteral_0= '||'
                    {
                    enumLiteral_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleOrOperators5861); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOrOperatorsAccess().getOrEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getOrOperatorsAccess().getOrEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2516:6: (enumLiteral_1= 'or' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2516:6: (enumLiteral_1= 'or' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2516:8: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleOrOperators5878); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOrOperatorsAccess().getOrmiEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getOrOperatorsAccess().getOrmiEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2522:6: (enumLiteral_2= 'OR' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2522:6: (enumLiteral_2= 'OR' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2522:8: enumLiteral_2= 'OR'
                    {
                    enumLiteral_2=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleOrOperators5895); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getOrOperatorsAccess().getORmaEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getOrOperatorsAccess().getORmaEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrOperators"


    // $ANTLR start "rulePlusMinusOperators"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2532:1: rulePlusMinusOperators returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator rulePlusMinusOperators() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2534:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2535:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2535:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==55) ) {
                alt40=1;
            }
            else if ( (LA40_0==42) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2535:2: (enumLiteral_0= '+' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2535:2: (enumLiteral_0= '+' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2535:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_rulePlusMinusOperators5940); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getPlusMinusOperatorsAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getPlusMinusOperatorsAccess().getPlusEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2541:6: (enumLiteral_1= '-' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2541:6: (enumLiteral_1= '-' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2541:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_rulePlusMinusOperators5957); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getPlusMinusOperatorsAccess().getMinusEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getPlusMinusOperatorsAccess().getMinusEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusMinusOperators"


    // $ANTLR start "ruleModMultDivOperators"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2551:1: ruleModMultDivOperators returns [Enumerator current=null] : ( (enumLiteral_0= '%' ) | (enumLiteral_1= '*' ) | (enumLiteral_2= '/' ) ) ;
    public final Enumerator ruleModMultDivOperators() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2553:28: ( ( (enumLiteral_0= '%' ) | (enumLiteral_1= '*' ) | (enumLiteral_2= '/' ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2554:1: ( (enumLiteral_0= '%' ) | (enumLiteral_1= '*' ) | (enumLiteral_2= '/' ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2554:1: ( (enumLiteral_0= '%' ) | (enumLiteral_1= '*' ) | (enumLiteral_2= '/' ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt41=1;
                }
                break;
            case 57:
                {
                alt41=2;
                }
                break;
            case 58:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2554:2: (enumLiteral_0= '%' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2554:2: (enumLiteral_0= '%' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2554:4: enumLiteral_0= '%'
                    {
                    enumLiteral_0=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleModMultDivOperators6002); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModMultDivOperatorsAccess().getModEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getModMultDivOperatorsAccess().getModEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2560:6: (enumLiteral_1= '*' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2560:6: (enumLiteral_1= '*' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2560:8: enumLiteral_1= '*'
                    {
                    enumLiteral_1=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleModMultDivOperators6019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModMultDivOperatorsAccess().getMultEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getModMultDivOperatorsAccess().getMultEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2566:6: (enumLiteral_2= '/' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2566:6: (enumLiteral_2= '/' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2566:8: enumLiteral_2= '/'
                    {
                    enumLiteral_2=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleModMultDivOperators6036); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModMultDivOperatorsAccess().getDivEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getModMultDivOperatorsAccess().getDivEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModMultDivOperators"


    // $ANTLR start "ruleImpliesOperator"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2576:1: ruleImpliesOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=>' ) | (enumLiteral_1= '<=>' ) ) ;
    public final Enumerator ruleImpliesOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2578:28: ( ( (enumLiteral_0= '=>' ) | (enumLiteral_1= '<=>' ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2579:1: ( (enumLiteral_0= '=>' ) | (enumLiteral_1= '<=>' ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2579:1: ( (enumLiteral_0= '=>' ) | (enumLiteral_1= '<=>' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==59) ) {
                alt42=1;
            }
            else if ( (LA42_0==60) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2579:2: (enumLiteral_0= '=>' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2579:2: (enumLiteral_0= '=>' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2579:4: enumLiteral_0= '=>'
                    {
                    enumLiteral_0=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleImpliesOperator6081); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImpliesOperatorAccess().getImplEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getImpliesOperatorAccess().getImplEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2585:6: (enumLiteral_1= '<=>' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2585:6: (enumLiteral_1= '<=>' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2585:8: enumLiteral_1= '<=>'
                    {
                    enumLiteral_1=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleImpliesOperator6098); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImpliesOperatorAccess().getIffEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getImpliesOperatorAccess().getIffEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImpliesOperator"


    // $ANTLR start "ruleBooleanConst"
    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2595:1: ruleBooleanConst returns [Enumerator current=null] : ( (enumLiteral_0= 'false' ) | (enumLiteral_1= 'true' ) ) ;
    public final Enumerator ruleBooleanConst() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2597:28: ( ( (enumLiteral_0= 'false' ) | (enumLiteral_1= 'true' ) ) )
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2598:1: ( (enumLiteral_0= 'false' ) | (enumLiteral_1= 'true' ) )
            {
            // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2598:1: ( (enumLiteral_0= 'false' ) | (enumLiteral_1= 'true' ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==61) ) {
                alt43=1;
            }
            else if ( (LA43_0==62) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2598:2: (enumLiteral_0= 'false' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2598:2: (enumLiteral_0= 'false' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2598:4: enumLiteral_0= 'false'
                    {
                    enumLiteral_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleBooleanConst6143); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getBooleanConstAccess().getFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getBooleanConstAccess().getFalseEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2604:6: (enumLiteral_1= 'true' )
                    {
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2604:6: (enumLiteral_1= 'true' )
                    // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2604:8: enumLiteral_1= 'true'
                    {
                    enumLiteral_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleBooleanConst6160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getBooleanConstAccess().getTrueEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getBooleanConstAccess().getTrueEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanConst"

    // $ANTLR start synpred1_InternalCitL
    public final void synpred1_InternalCitL_fragment() throws RecognitionException {   
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1045:2: ( ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1045:3: ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1045:3: ( () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1045:4: () ( ( ruleOrOperators ) ) ( ( ruleAndExpression ) )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1045:4: ()
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1046:1: 
        {
        }

        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1046:2: ( ( ruleOrOperators ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1047:1: ( ruleOrOperators )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1047:1: ( ruleOrOperators )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1048:1: ruleOrOperators
        {
        pushFollow(FollowSets000.FOLLOW_ruleOrOperators_in_synpred1_InternalCitL2362);
        ruleOrOperators();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1050:2: ( ( ruleAndExpression ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1051:1: ( ruleAndExpression )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1051:1: ( ruleAndExpression )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1052:1: ruleAndExpression
        {
        pushFollow(FollowSets000.FOLLOW_ruleAndExpression_in_synpred1_InternalCitL2371);
        ruleAndExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalCitL

    // $ANTLR start synpred2_InternalCitL
    public final void synpred2_InternalCitL_fragment() throws RecognitionException {   
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1126:2: ( ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1126:3: ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1126:3: ( () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1126:4: () ( ( ruleAndOperators ) ) ( ( ruleImpliesExpression ) )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1126:4: ()
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1127:1: 
        {
        }

        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1127:2: ( ( ruleAndOperators ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1128:1: ( ruleAndOperators )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1128:1: ( ruleAndOperators )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1129:1: ruleAndOperators
        {
        pushFollow(FollowSets000.FOLLOW_ruleAndOperators_in_synpred2_InternalCitL2536);
        ruleAndOperators();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1131:2: ( ( ruleImpliesExpression ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1132:1: ( ruleImpliesExpression )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1132:1: ( ruleImpliesExpression )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1133:1: ruleImpliesExpression
        {
        pushFollow(FollowSets000.FOLLOW_ruleImpliesExpression_in_synpred2_InternalCitL2545);
        ruleImpliesExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalCitL

    // $ANTLR start synpred3_InternalCitL
    public final void synpred3_InternalCitL_fragment() throws RecognitionException {   
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1373:3: ( ( RULE_ID ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1374:1: ( RULE_ID )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1374:1: ( RULE_ID )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1375:2: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred3_InternalCitL3136); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalCitL

    // $ANTLR start synpred4_InternalCitL
    public final void synpred4_InternalCitL_fragment() throws RecognitionException {   
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1388:7: ( ( RULE_ID ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1389:1: ( RULE_ID )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1389:1: ( RULE_ID )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1390:2: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred4_InternalCitL3177); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalCitL

    // $ANTLR start synpred8_InternalCitL
    public final void synpred8_InternalCitL_fragment() throws RecognitionException {   
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:1999:3: ( ( RULE_ID ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2000:1: ( RULE_ID )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2000:1: ( RULE_ID )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2001:2: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred8_InternalCitL4514); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalCitL

    // $ANTLR start synpred9_InternalCitL
    public final void synpred9_InternalCitL_fragment() throws RecognitionException {   
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2014:7: ( ( RULE_ID ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2015:1: ( RULE_ID )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2015:1: ( RULE_ID )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2016:2: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred9_InternalCitL4555); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred9_InternalCitL

    // $ANTLR start synpred10_InternalCitL
    public final void synpred10_InternalCitL_fragment() throws RecognitionException {   
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2029:7: ( ( RULE_ID ) )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2030:1: ( RULE_ID )
        {
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2030:1: ( RULE_ID )
        // ../citlab.model/src-gen/citlab/model/parser/antlr/internal/InternalCitL.g:2031:2: RULE_ID
        {
        match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_synpred10_InternalCitL4596); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalCitL

    // Delegated rules

    public final boolean synpred2_InternalCitL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalCitL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalCitL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalCitL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalCitL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalCitL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalCitL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalCitL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalCitL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalCitL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalCitL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalCitL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalCitL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalCitL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA32_eotS =
        "\14\uffff";
    static final String DFA32_eofS =
        "\5\uffff\1\12\6\uffff";
    static final String DFA32_minS =
        "\1\4\1\25\1\4\2\uffff\1\43\6\uffff";
    static final String DFA32_maxS =
        "\1\4\1\25\1\76\2\uffff\1\51\6\uffff";
    static final String DFA32_acceptS =
        "\3\uffff\2\3\1\uffff\2\2\3\3\1\1";
    static final String DFA32_specialS =
        "\2\uffff\1\1\2\uffff\1\0\6\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1",
            "\1\2",
            "\1\5\1\4\44\uffff\1\3\22\uffff\1\6\1\7",
            "",
            "",
            "\1\11\4\uffff\1\10\1\13",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1999:1: ( ( ( ( RULE_ID ) )=>this_EnumSeed_0= ruleEnumSeed ) | ( ( ( RULE_ID ) )=>this_BoolAssignSeed_1= ruleBoolAssignSeed ) | ( ( ( RULE_ID ) )=>this_NumericalSeed_2= ruleNumericalSeed ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_5==40) && (synpred10_InternalCitL())) {s = 8;}

                        else if ( (LA32_5==35) && (synpred10_InternalCitL())) {s = 9;}

                        else if ( (LA32_5==EOF) && (synpred10_InternalCitL())) {s = 10;}

                        else if ( (LA32_5==41) && (synpred8_InternalCitL())) {s = 11;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA32_2==42) && (synpred10_InternalCitL())) {s = 3;}

                        else if ( (LA32_2==RULE_INT) && (synpred10_InternalCitL())) {s = 4;}

                        else if ( (LA32_2==RULE_ID) ) {s = 5;}

                        else if ( (LA32_2==61) && (synpred9_InternalCitL())) {s = 6;}

                        else if ( (LA32_2==62) && (synpred9_InternalCitL())) {s = 7;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleCitModel_in_entryRuleCitModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCitModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleCitModel131 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCitModel148 = new BitSet(new long[]{0x000000000001A000L});
        public static final BitSet FOLLOW_13_in_ruleCitModel166 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_ruleConstant_in_ruleCitModel187 = new BitSet(new long[]{0x0000000000104000L});
        public static final BitSet FOLLOW_14_in_ruleCitModel200 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_15_in_ruleCitModel215 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_ruleNamedType_in_ruleCitModel236 = new BitSet(new long[]{0x0000000000804000L});
        public static final BitSet FOLLOW_14_in_ruleCitModel249 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleCitModel263 = new BitSet(new long[]{0x0000000074000000L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleCitModel284 = new BitSet(new long[]{0x0000000074004000L});
        public static final BitSet FOLLOW_14_in_ruleCitModel297 = new BitSet(new long[]{0x00000000000E0002L});
        public static final BitSet FOLLOW_17_in_ruleCitModel310 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_ruleRule_in_ruleCitModel331 = new BitSet(new long[]{0x0000000800004000L});
        public static final BitSet FOLLOW_14_in_ruleCitModel344 = new BitSet(new long[]{0x00000000000C0002L});
        public static final BitSet FOLLOW_18_in_ruleCitModel359 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_ruleSeed_in_ruleCitModel380 = new BitSet(new long[]{0x0000000800004000L});
        public static final BitSet FOLLOW_14_in_ruleCitModel393 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleCitModel408 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_ruleRule_in_ruleCitModel429 = new BitSet(new long[]{0x0000000800004000L});
        public static final BitSet FOLLOW_14_in_ruleCitModel442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant480 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstant490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantNumber_in_ruleConstant536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantNumber_in_entryRuleConstantNumber570 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstantNumber580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleConstantNumber617 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConstantNumber634 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleConstantNumber651 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleConstantNumber668 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleConstantNumber685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumerative_in_ruleParameter778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_ruleParameter805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumerical_in_ruleParameter832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericalEx_in_entryRuleNumericalEx869 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumericalEx879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumerical_in_ruleNumericalEx926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantNumber_in_ruleNumericalEx953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumerical_in_entryRuleNumerical988 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumerical998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumbers_in_ruleNumerical1045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRange_in_ruleNumerical1072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamedType_in_entryRuleNamedType1109 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedType1119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleNamedType1156 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamedType1173 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleNamedType1190 = new BitSet(new long[]{0x0000000002000050L});
        public static final BitSet FOLLOW_ruleElement_in_ruleNamedType1211 = new BitSet(new long[]{0x0000000002000050L});
        public static final BitSet FOLLOW_25_in_ruleNamedType1224 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleNamedType1236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnonymousType_in_entryRuleAnonymousType1272 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnonymousType1282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleAnonymousType1327 = new BitSet(new long[]{0x0000000000000052L});
        public static final BitSet FOLLOW_ruleEnumerative_in_entryRuleEnumerative1363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumerative1373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleEnumerative1410 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerative1427 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_27_in_ruleEnumerative1446 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerative1466 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_24_in_ruleEnumerative1486 = new BitSet(new long[]{0x0000000000000050L});
        public static final BitSet FOLLOW_ruleAnonymousType_in_ruleEnumerative1507 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleEnumerative1519 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleEnumerative1533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement1569 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement1579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleelementID_in_ruleElement1624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1659 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleBoolean1706 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBoolean1723 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleBoolean1740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumbers_in_entryRuleNumbers1776 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumbers1786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleNumbers1823 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNumbers1840 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleNumbers1857 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rulePossiblySignedNumber_in_ruleNumbers1878 = new BitSet(new long[]{0x0000040002000020L});
        public static final BitSet FOLLOW_25_in_ruleNumbers1891 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleNumbers1903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRange_in_entryRuleRange1939 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRange1949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleRange1986 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRange2003 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleRange2020 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rulePossiblySignedNumber_in_ruleRange2041 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleRange2053 = new BitSet(new long[]{0x0000040000000020L});
        public static final BitSet FOLLOW_rulePossiblySignedNumber_in_ruleRange2074 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleRange2086 = new BitSet(new long[]{0x0000000400400000L});
        public static final BitSet FOLLOW_34_in_ruleRange2099 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleRange2116 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRange2135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRule_in_entryRuleRule2171 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRule2181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleRule2218 = new BitSet(new long[]{0x000000D000000010L});
        public static final BitSet FOLLOW_ruleOrExpression_in_ruleRule2240 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleRule2251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression2287 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression2297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression2344 = new BitSet(new long[]{0x0070000000000002L});
        public static final BitSet FOLLOW_ruleOrOperators_in_ruleOrExpression2401 = new BitSet(new long[]{0x000000D000000010L});
        public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression2422 = new BitSet(new long[]{0x0070000000000002L});
        public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression2461 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression2471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleAndExpression2518 = new BitSet(new long[]{0x000E000000000002L});
        public static final BitSet FOLLOW_ruleAndOperators_in_ruleAndExpression2575 = new BitSet(new long[]{0x000000D000000010L});
        public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleAndExpression2596 = new BitSet(new long[]{0x000E000000000002L});
        public static final BitSet FOLLOW_ruleImpliesExpression_in_entryRuleImpliesExpression2635 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImpliesExpression2645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleImpliesExpression2692 = new BitSet(new long[]{0x1800000000000002L});
        public static final BitSet FOLLOW_ruleImpliesOperator_in_ruleImpliesExpression2722 = new BitSet(new long[]{0x000000D000000010L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleImpliesExpression2743 = new BitSet(new long[]{0x1800000000000002L});
        public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary2781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimary2791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotExpression_in_rulePrimary2838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rulePrimary2856 = new BitSet(new long[]{0x000000D000000010L});
        public static final BitSet FOLLOW_ruleOrExpression_in_rulePrimary2878 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_rulePrimary2889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtomicPredicate_in_rulePrimary2918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotExpression_in_entryRuleNotExpression2953 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNotExpression2963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleNotExpression3001 = new BitSet(new long[]{0x000000D000000010L});
        public static final BitSet FOLLOW_39_in_ruleNotExpression3019 = new BitSet(new long[]{0x000000D000000010L});
        public static final BitSet FOLLOW_rulePrimary_in_ruleNotExpression3042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtomicPredicate_in_entryRuleAtomicPredicate3086 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtomicPredicate3096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumAssign_in_ruleAtomicPredicate3156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolAssign_in_ruleAtomicPredicate3197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleAtomicPredicate3225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolAssign_in_entryRuleBoolAssign3260 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoolAssign3270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBoolAssign3327 = new BitSet(new long[]{0x0001800000000000L});
        public static final BitSet FOLLOW_ruleAssignmentOperators_in_ruleBoolAssign3348 = new BitSet(new long[]{0x6000000000000000L});
        public static final BitSet FOLLOW_ruleBooleanConst_in_ruleBoolAssign3369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumAssign_in_entryRuleEnumAssign3405 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumAssign3415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumAssign3472 = new BitSet(new long[]{0x0001800000000000L});
        public static final BitSet FOLLOW_ruleAssignmentOperators_in_ruleEnumAssign3493 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleEnumAssign3516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression3552 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression3562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRelationalExpression3654 = new BitSet(new long[]{0x0001F80000000000L});
        public static final BitSet FOLLOW_ruleAssignmentOperators_in_ruleRelationalExpression3677 = new BitSet(new long[]{0x0000041000000030L});
        public static final BitSet FOLLOW_ruleRelationalOperators_in_ruleRelationalExpression3696 = new BitSet(new long[]{0x0000041000000030L});
        public static final BitSet FOLLOW_rulePlusMinus_in_ruleRelationalExpression3720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePlusMinus_in_entryRulePlusMinus3757 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePlusMinus3767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModMultDiv_in_rulePlusMinus3814 = new BitSet(new long[]{0x0080040000000002L});
        public static final BitSet FOLLOW_rulePlusMinusOperators_in_rulePlusMinus3844 = new BitSet(new long[]{0x0000041000000030L});
        public static final BitSet FOLLOW_ruleModMultDiv_in_rulePlusMinus3865 = new BitSet(new long[]{0x0080040000000002L});
        public static final BitSet FOLLOW_ruleModMultDiv_in_entryRuleModMultDiv3903 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModMultDiv3913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumeric_in_ruleModMultDiv3960 = new BitSet(new long[]{0x0700000000000002L});
        public static final BitSet FOLLOW_ruleModMultDivOperators_in_ruleModMultDiv3990 = new BitSet(new long[]{0x0000041000000030L});
        public static final BitSet FOLLOW_ruleNumeric_in_ruleModMultDiv4011 = new BitSet(new long[]{0x0700000000000002L});
        public static final BitSet FOLLOW_ruleNumeric_in_entryRuleNumeric4049 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumeric4059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleNumeric4106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleNumeric4124 = new BitSet(new long[]{0x0000041000000030L});
        public static final BitSet FOLLOW_rulePlusMinus_in_ruleNumeric4146 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleNumeric4157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral4194 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral4204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePossiblySignedNumber_in_ruleNumberLiteral4250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNumberLiteral4276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSeed_in_entryRuleSeed4312 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSeed4322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleSeed4359 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAseed_in_ruleSeed4380 = new BitSet(new long[]{0x0000010800000000L});
        public static final BitSet FOLLOW_40_in_ruleSeed4393 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleAseed_in_ruleSeed4414 = new BitSet(new long[]{0x0000010800000000L});
        public static final BitSet FOLLOW_35_in_ruleSeed4428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAseed_in_entryRuleAseed4464 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAseed4474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumSeed_in_ruleAseed4534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolAssignSeed_in_ruleAseed4575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericalSeed_in_ruleAseed4616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSeedNumberLiteral_in_entryRuleSeedNumberLiteral4652 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSeedNumberLiteral4662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePossiblySignedNumber_in_ruleSeedNumberLiteral4708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSeedNumberLiteral4734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumSeed_in_entryRuleEnumSeed4770 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumSeed4780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumSeed4837 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleEnumSeed4855 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleEnumSeed4891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericalSeed_in_entryRuleNumericalSeed4927 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumericalSeed4937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNumericalSeed4994 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleNumericalSeed5012 = new BitSet(new long[]{0x0000040000000030L});
        public static final BitSet FOLLOW_ruleSeedNumberLiteral_in_ruleNumericalSeed5046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolAssignSeed_in_entryRuleBoolAssignSeed5082 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoolAssignSeed5092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBoolAssignSeed5149 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleBoolAssignSeed5167 = new BitSet(new long[]{0x6000000000000000L});
        public static final BitSet FOLLOW_ruleBooleanConst_in_ruleBoolAssignSeed5201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleelementID_in_entryRuleelementID5238 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleelementID5249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleelementID5289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_NUMID_in_ruleelementID5315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN5361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN5372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN5412 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleFQN5430 = new BitSet(new long[]{0x0000000000000050L});
        public static final BitSet FOLLOW_ruleelementID_in_ruleFQN5452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePossiblySignedNumber_in_entryRulePossiblySignedNumber5498 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePossiblySignedNumber5509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rulePossiblySignedNumber5548 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePossiblySignedNumber5565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleRelationalOperators5624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleRelationalOperators5641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleRelationalOperators5658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleRelationalOperators5675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleAssignmentOperators5720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleAssignmentOperators5737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleAndOperators5782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleAndOperators5799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleAndOperators5816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleOrOperators5861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleOrOperators5878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleOrOperators5895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rulePlusMinusOperators5940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_rulePlusMinusOperators5957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleModMultDivOperators6002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleModMultDivOperators6019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleModMultDivOperators6036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleImpliesOperator6081 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleImpliesOperator6098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleBooleanConst6143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleBooleanConst6160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrOperators_in_synpred1_InternalCitL2362 = new BitSet(new long[]{0x000000D000000010L});
        public static final BitSet FOLLOW_ruleAndExpression_in_synpred1_InternalCitL2371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndOperators_in_synpred2_InternalCitL2536 = new BitSet(new long[]{0x000000D000000010L});
        public static final BitSet FOLLOW_ruleImpliesExpression_in_synpred2_InternalCitL2545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred3_InternalCitL3136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred4_InternalCitL3177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred8_InternalCitL4514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred9_InternalCitL4555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_synpred10_InternalCitL4596 = new BitSet(new long[]{0x0000000000000002L});
    }


}