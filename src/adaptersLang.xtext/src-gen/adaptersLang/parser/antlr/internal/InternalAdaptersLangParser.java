package adaptersLang.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import adaptersLang.services.AdaptersLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class InternalAdaptersLangParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ANY_OTHER", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_STRING", "RULE_WS", "'('", "')'", "'++'", "'+-'", "','", "'-+'", "'--'", "'='", "'adapters'", "'context'", "'delta'", "'language'", "'on'", "'rules'", "'transformation'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int RULE_ANY_OTHER=4;
    public static final int RULE_ID=5;
    public static final int RULE_INT=6;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_STRING=9;
    public static final int RULE_WS=10;

    // delegates
    public AbstractInternalAntlrParser[] getDelegates() {
        return new AbstractInternalAntlrParser[] {};
    }

    // delegators


    public InternalAdaptersLangParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalAdaptersLangParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return InternalAdaptersLangParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAdaptersLang.g"; }



     	private AdaptersLangGrammarAccess grammarAccess;

        public InternalAdaptersLangParser(TokenStream input, AdaptersLangGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "AdapterModel";
       	}

       	@Override
       	protected AdaptersLangGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleAdapterModel"
    // InternalAdaptersLang.g:64:1: entryRuleAdapterModel returns [EObject current=null] :iv_ruleAdapterModel= ruleAdapterModel EOF ;
    public final EObject entryRuleAdapterModel() throws RecognitionException {
        EObject current = null;


        EObject iv_ruleAdapterModel =null;


        try {
            // InternalAdaptersLang.g:64:53: (iv_ruleAdapterModel= ruleAdapterModel EOF )
            // InternalAdaptersLang.g:65:2: iv_ruleAdapterModel= ruleAdapterModel EOF
            {
             newCompositeNode(grammarAccess.getAdapterModelRule()); 

            pushFollow(FOLLOW_1);
            iv_ruleAdapterModel=ruleAdapterModel();

            state._fsp--;


             current =iv_ruleAdapterModel; 

            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "entryRuleAdapterModel"



    // $ANTLR start "ruleAdapterModel"
    // InternalAdaptersLang.g:71:1: ruleAdapterModel returns [EObject current=null] : (otherlv_0= 'language' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'on' ( (lv_ecore_3_0= ruleEString ) ) otherlv_4= 'transformation' ( (lv_transformation_5_0= ruleEString ) ) otherlv_6= 'adapters' otherlv_7= '{' ( ( (lv_adapters_8_0= ruleAdapter ) ) (otherlv_9= ',' ( (lv_adapters_10_0= ruleAdapter ) ) )* )? otherlv_11= '}' ) ;
    public final EObject ruleAdapterModel() throws RecognitionException {
        EObject current = null;


        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 =null;

        AntlrDatatypeRuleToken lv_ecore_3_0 =null;

        AntlrDatatypeRuleToken lv_transformation_5_0 =null;

        EObject lv_adapters_8_0 =null;

        EObject lv_adapters_10_0 =null;



        	enterRule();

        try {
            // InternalAdaptersLang.g:77:2: ( (otherlv_0= 'language' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'on' ( (lv_ecore_3_0= ruleEString ) ) otherlv_4= 'transformation' ( (lv_transformation_5_0= ruleEString ) ) otherlv_6= 'adapters' otherlv_7= '{' ( ( (lv_adapters_8_0= ruleAdapter ) ) (otherlv_9= ',' ( (lv_adapters_10_0= ruleAdapter ) ) )* )? otherlv_11= '}' ) )
            // InternalAdaptersLang.g:78:2: (otherlv_0= 'language' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'on' ( (lv_ecore_3_0= ruleEString ) ) otherlv_4= 'transformation' ( (lv_transformation_5_0= ruleEString ) ) otherlv_6= 'adapters' otherlv_7= '{' ( ( (lv_adapters_8_0= ruleAdapter ) ) (otherlv_9= ',' ( (lv_adapters_10_0= ruleAdapter ) ) )* )? otherlv_11= '}' )
            {
            // InternalAdaptersLang.g:78:2: (otherlv_0= 'language' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'on' ( (lv_ecore_3_0= ruleEString ) ) otherlv_4= 'transformation' ( (lv_transformation_5_0= ruleEString ) ) otherlv_6= 'adapters' otherlv_7= '{' ( ( (lv_adapters_8_0= ruleAdapter ) ) (otherlv_9= ',' ( (lv_adapters_10_0= ruleAdapter ) ) )* )? otherlv_11= '}' )
            // InternalAdaptersLang.g:79:3: otherlv_0= 'language' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'on' ( (lv_ecore_3_0= ruleEString ) ) otherlv_4= 'transformation' ( (lv_transformation_5_0= ruleEString ) ) otherlv_6= 'adapters' otherlv_7= '{' ( ( (lv_adapters_8_0= ruleAdapter ) ) (otherlv_9= ',' ( (lv_adapters_10_0= ruleAdapter ) ) )* )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); 


            			newLeafNode(otherlv_0, grammarAccess.getAdapterModelAccess().getLanguageKeyword_0());
            		

            // InternalAdaptersLang.g:83:3: ( (lv_name_1_0= ruleEString ) )
            // InternalAdaptersLang.g:84:4: (lv_name_1_0= ruleEString )
            {
            // InternalAdaptersLang.g:84:4: (lv_name_1_0= ruleEString )
            // InternalAdaptersLang.g:85:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAdapterModelAccess().getNameEStringParserRuleCall_1_0());
            				

            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;



            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdapterModelRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"adaptersLang.AdaptersLang.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            otherlv_2=(Token)match(input,23,FOLLOW_3); 


            			newLeafNode(otherlv_2, grammarAccess.getAdapterModelAccess().getOnKeyword_2());
            		

            // InternalAdaptersLang.g:106:3: ( (lv_ecore_3_0= ruleEString ) )
            // InternalAdaptersLang.g:107:4: (lv_ecore_3_0= ruleEString )
            {
            // InternalAdaptersLang.g:107:4: (lv_ecore_3_0= ruleEString )
            // InternalAdaptersLang.g:108:5: lv_ecore_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAdapterModelAccess().getEcoreEStringParserRuleCall_3_0());
            				

            pushFollow(FOLLOW_5);
            lv_ecore_3_0=ruleEString();

            state._fsp--;



            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdapterModelRule());
            					}
            					set(
            						current,
            						"ecore",
            						lv_ecore_3_0,
            						"adaptersLang.AdaptersLang.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            otherlv_4=(Token)match(input,25,FOLLOW_3); 


            			newLeafNode(otherlv_4, grammarAccess.getAdapterModelAccess().getTransformationKeyword_4());
            		

            // InternalAdaptersLang.g:129:3: ( (lv_transformation_5_0= ruleEString ) )
            // InternalAdaptersLang.g:130:4: (lv_transformation_5_0= ruleEString )
            {
            // InternalAdaptersLang.g:130:4: (lv_transformation_5_0= ruleEString )
            // InternalAdaptersLang.g:131:5: lv_transformation_5_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAdapterModelAccess().getTransformationEStringParserRuleCall_5_0());
            				

            pushFollow(FOLLOW_6);
            lv_transformation_5_0=ruleEString();

            state._fsp--;



            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdapterModelRule());
            					}
            					set(
            						current,
            						"transformation",
            						lv_transformation_5_0,
            						"adaptersLang.AdaptersLang.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            otherlv_6=(Token)match(input,19,FOLLOW_7); 


            			newLeafNode(otherlv_6, grammarAccess.getAdapterModelAccess().getAdaptersKeyword_6());
            		

            otherlv_7=(Token)match(input,26,FOLLOW_8); 


            			newLeafNode(otherlv_7, grammarAccess.getAdapterModelAccess().getLeftCurlyBracketKeyword_7());
            		

            // InternalAdaptersLang.g:156:3: ( ( (lv_adapters_8_0= ruleAdapter ) ) (otherlv_9= ',' ( (lv_adapters_10_0= ruleAdapter ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalAdaptersLang.g:157:4: ( (lv_adapters_8_0= ruleAdapter ) ) (otherlv_9= ',' ( (lv_adapters_10_0= ruleAdapter ) ) )*
                    {
                    // InternalAdaptersLang.g:157:4: ( (lv_adapters_8_0= ruleAdapter ) )
                    // InternalAdaptersLang.g:158:5: (lv_adapters_8_0= ruleAdapter )
                    {
                    // InternalAdaptersLang.g:158:5: (lv_adapters_8_0= ruleAdapter )
                    // InternalAdaptersLang.g:159:6: lv_adapters_8_0= ruleAdapter
                    {

                    						newCompositeNode(grammarAccess.getAdapterModelAccess().getAdaptersAdapterParserRuleCall_8_0_0());
                    					

                    pushFollow(FOLLOW_9);
                    lv_adapters_8_0=ruleAdapter();

                    state._fsp--;



                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAdapterModelRule());
                    						}
                    						add(
                    							current,
                    							"adapters",
                    							lv_adapters_8_0,
                    							"adaptersLang.AdaptersLang.Adapter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    // InternalAdaptersLang.g:176:4: (otherlv_9= ',' ( (lv_adapters_10_0= ruleAdapter ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==15) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalAdaptersLang.g:177:5: otherlv_9= ',' ( (lv_adapters_10_0= ruleAdapter ) )
                    	    {
                    	    otherlv_9=(Token)match(input,15,FOLLOW_3); 


                    	    					newLeafNode(otherlv_9, grammarAccess.getAdapterModelAccess().getCommaKeyword_8_1_0());
                    	    				

                    	    // InternalAdaptersLang.g:181:5: ( (lv_adapters_10_0= ruleAdapter ) )
                    	    // InternalAdaptersLang.g:182:6: (lv_adapters_10_0= ruleAdapter )
                    	    {
                    	    // InternalAdaptersLang.g:182:6: (lv_adapters_10_0= ruleAdapter )
                    	    // InternalAdaptersLang.g:183:7: lv_adapters_10_0= ruleAdapter
                    	    {

                    	    							newCompositeNode(grammarAccess.getAdapterModelAccess().getAdaptersAdapterParserRuleCall_8_1_1_0());
                    	    						

                    	    pushFollow(FOLLOW_9);
                    	    lv_adapters_10_0=ruleAdapter();

                    	    state._fsp--;



                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAdapterModelRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"adapters",
                    	    								lv_adapters_10_0,
                    	    								"adaptersLang.AdaptersLang.Adapter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }


            otherlv_11=(Token)match(input,27,FOLLOW_2); 


            			newLeafNode(otherlv_11, grammarAccess.getAdapterModelAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "ruleAdapterModel"



    // $ANTLR start "entryRuleAdapter"
    // InternalAdaptersLang.g:210:1: entryRuleAdapter returns [EObject current=null] :iv_ruleAdapter= ruleAdapter EOF ;
    public final EObject entryRuleAdapter() throws RecognitionException {
        EObject current = null;


        EObject iv_ruleAdapter =null;


        try {
            // InternalAdaptersLang.g:210:48: (iv_ruleAdapter= ruleAdapter EOF )
            // InternalAdaptersLang.g:211:2: iv_ruleAdapter= ruleAdapter EOF
            {
             newCompositeNode(grammarAccess.getAdapterRule()); 

            pushFollow(FOLLOW_1);
            iv_ruleAdapter=ruleAdapter();

            state._fsp--;


             current =iv_ruleAdapter; 

            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "entryRuleAdapter"



    // $ANTLR start "ruleAdapter"
    // InternalAdaptersLang.g:217:1: ruleAdapter returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' otherlv_2= '(' ( (lv_cfgDiff_3_0= ruleConfigDiff ) ) otherlv_4= ',' otherlv_5= 'rules' otherlv_6= '{' ( (lv_rules_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_rules_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' ) ;
    public final EObject ruleAdapter() throws RecognitionException {
        EObject current = null;


        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_0_0 =null;

        EObject lv_cfgDiff_3_0 =null;

        AntlrDatatypeRuleToken lv_rules_7_0 =null;

        AntlrDatatypeRuleToken lv_rules_9_0 =null;



        	enterRule();

        try {
            // InternalAdaptersLang.g:223:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' otherlv_2= '(' ( (lv_cfgDiff_3_0= ruleConfigDiff ) ) otherlv_4= ',' otherlv_5= 'rules' otherlv_6= '{' ( (lv_rules_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_rules_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' ) )
            // InternalAdaptersLang.g:224:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' otherlv_2= '(' ( (lv_cfgDiff_3_0= ruleConfigDiff ) ) otherlv_4= ',' otherlv_5= 'rules' otherlv_6= '{' ( (lv_rules_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_rules_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' )
            {
            // InternalAdaptersLang.g:224:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' otherlv_2= '(' ( (lv_cfgDiff_3_0= ruleConfigDiff ) ) otherlv_4= ',' otherlv_5= 'rules' otherlv_6= '{' ( (lv_rules_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_rules_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' )
            // InternalAdaptersLang.g:225:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '=' otherlv_2= '(' ( (lv_cfgDiff_3_0= ruleConfigDiff ) ) otherlv_4= ',' otherlv_5= 'rules' otherlv_6= '{' ( (lv_rules_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_rules_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')'
            {
            // InternalAdaptersLang.g:225:3: ( (lv_name_0_0= ruleEString ) )
            // InternalAdaptersLang.g:226:4: (lv_name_0_0= ruleEString )
            {
            // InternalAdaptersLang.g:226:4: (lv_name_0_0= ruleEString )
            // InternalAdaptersLang.g:227:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAdapterAccess().getNameEStringParserRuleCall_0_0());
            				

            pushFollow(FOLLOW_10);
            lv_name_0_0=ruleEString();

            state._fsp--;



            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdapterRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"adaptersLang.AdaptersLang.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            otherlv_1=(Token)match(input,18,FOLLOW_11); 


            			newLeafNode(otherlv_1, grammarAccess.getAdapterAccess().getEqualsSignKeyword_1());
            		

            otherlv_2=(Token)match(input,11,FOLLOW_12); 


            			newLeafNode(otherlv_2, grammarAccess.getAdapterAccess().getLeftParenthesisKeyword_2());
            		

            // InternalAdaptersLang.g:252:3: ( (lv_cfgDiff_3_0= ruleConfigDiff ) )
            // InternalAdaptersLang.g:253:4: (lv_cfgDiff_3_0= ruleConfigDiff )
            {
            // InternalAdaptersLang.g:253:4: (lv_cfgDiff_3_0= ruleConfigDiff )
            // InternalAdaptersLang.g:254:5: lv_cfgDiff_3_0= ruleConfigDiff
            {

            					newCompositeNode(grammarAccess.getAdapterAccess().getCfgDiffConfigDiffParserRuleCall_3_0());
            				

            pushFollow(FOLLOW_13);
            lv_cfgDiff_3_0=ruleConfigDiff();

            state._fsp--;



            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdapterRule());
            					}
            					set(
            						current,
            						"cfgDiff",
            						lv_cfgDiff_3_0,
            						"adaptersLang.AdaptersLang.ConfigDiff");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            otherlv_4=(Token)match(input,15,FOLLOW_14); 


            			newLeafNode(otherlv_4, grammarAccess.getAdapterAccess().getCommaKeyword_4());
            		

            otherlv_5=(Token)match(input,24,FOLLOW_7); 


            			newLeafNode(otherlv_5, grammarAccess.getAdapterAccess().getRulesKeyword_5());
            		

            otherlv_6=(Token)match(input,26,FOLLOW_3); 


            			newLeafNode(otherlv_6, grammarAccess.getAdapterAccess().getLeftCurlyBracketKeyword_6());
            		

            // InternalAdaptersLang.g:283:3: ( (lv_rules_7_0= ruleEString ) )
            // InternalAdaptersLang.g:284:4: (lv_rules_7_0= ruleEString )
            {
            // InternalAdaptersLang.g:284:4: (lv_rules_7_0= ruleEString )
            // InternalAdaptersLang.g:285:5: lv_rules_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAdapterAccess().getRulesEStringParserRuleCall_7_0());
            				

            pushFollow(FOLLOW_9);
            lv_rules_7_0=ruleEString();

            state._fsp--;



            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdapterRule());
            					}
            					add(
            						current,
            						"rules",
            						lv_rules_7_0,
            						"adaptersLang.AdaptersLang.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            // InternalAdaptersLang.g:302:3: (otherlv_8= ',' ( (lv_rules_9_0= ruleEString ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAdaptersLang.g:303:4: otherlv_8= ',' ( (lv_rules_9_0= ruleEString ) )
            	    {
            	    otherlv_8=(Token)match(input,15,FOLLOW_3); 


            	    				newLeafNode(otherlv_8, grammarAccess.getAdapterAccess().getCommaKeyword_8_0());
            	    			

            	    // InternalAdaptersLang.g:307:4: ( (lv_rules_9_0= ruleEString ) )
            	    // InternalAdaptersLang.g:308:5: (lv_rules_9_0= ruleEString )
            	    {
            	    // InternalAdaptersLang.g:308:5: (lv_rules_9_0= ruleEString )
            	    // InternalAdaptersLang.g:309:6: lv_rules_9_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getAdapterAccess().getRulesEStringParserRuleCall_8_1_0());
            	    					

            	    pushFollow(FOLLOW_9);
            	    lv_rules_9_0=ruleEString();

            	    state._fsp--;



            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdapterRule());
            	    						}
            	    						add(
            	    							current,
            	    							"rules",
            	    							lv_rules_9_0,
            	    							"adaptersLang.AdaptersLang.EString");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            otherlv_10=(Token)match(input,27,FOLLOW_15); 


            			newLeafNode(otherlv_10, grammarAccess.getAdapterAccess().getRightCurlyBracketKeyword_9());
            		

            otherlv_11=(Token)match(input,12,FOLLOW_2); 


            			newLeafNode(otherlv_11, grammarAccess.getAdapterAccess().getRightParenthesisKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "ruleAdapter"



    // $ANTLR start "entryRuleEString"
    // InternalAdaptersLang.g:339:1: entryRuleEString returns [String current=null] :iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;


        AntlrDatatypeRuleToken iv_ruleEString =null;


        try {
            // InternalAdaptersLang.g:339:47: (iv_ruleEString= ruleEString EOF )
            // InternalAdaptersLang.g:340:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 

            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;


             current =iv_ruleEString.getText(); 

            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"



    // $ANTLR start "ruleEString"
    // InternalAdaptersLang.g:346:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalAdaptersLang.g:352:2: ( (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID ) )
            // InternalAdaptersLang.g:353:2: (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID )
            {
            // InternalAdaptersLang.g:353:2: (this_STRING_0= RULE_STRING |this_ID_1= RULE_ID )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // InternalAdaptersLang.g:354:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 


                    			current.merge(this_STRING_0);
                    		


                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalAdaptersLang.g:362:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 


                    			current.merge(this_ID_1);
                    		


                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "ruleEString"



    // $ANTLR start "entryRuleConfigDiff"
    // InternalAdaptersLang.g:373:1: entryRuleConfigDiff returns [EObject current=null] :iv_ruleConfigDiff= ruleConfigDiff EOF ;
    public final EObject entryRuleConfigDiff() throws RecognitionException {
        EObject current = null;


        EObject iv_ruleConfigDiff =null;


        try {
            // InternalAdaptersLang.g:373:51: (iv_ruleConfigDiff= ruleConfigDiff EOF )
            // InternalAdaptersLang.g:374:2: iv_ruleConfigDiff= ruleConfigDiff EOF
            {
             newCompositeNode(grammarAccess.getConfigDiffRule()); 

            pushFollow(FOLLOW_1);
            iv_ruleConfigDiff=ruleConfigDiff();

            state._fsp--;


             current =iv_ruleConfigDiff; 

            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "entryRuleConfigDiff"



    // $ANTLR start "ruleConfigDiff"
    // InternalAdaptersLang.g:380:1: ruleConfigDiff returns [EObject current=null] : (otherlv_0= 'delta' otherlv_1= '(' ( (lv_delta_2_0= ruleConfigDelta ) ) otherlv_3= ')' otherlv_4= ',' otherlv_5= 'context' otherlv_6= '(' ( (lv_context_7_0= ruleConfigContext ) ) otherlv_8= ')' ) ;
    public final EObject ruleConfigDiff() throws RecognitionException {
        EObject current = null;


        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_delta_2_0 =null;

        EObject lv_context_7_0 =null;



        	enterRule();

        try {
            // InternalAdaptersLang.g:386:2: ( (otherlv_0= 'delta' otherlv_1= '(' ( (lv_delta_2_0= ruleConfigDelta ) ) otherlv_3= ')' otherlv_4= ',' otherlv_5= 'context' otherlv_6= '(' ( (lv_context_7_0= ruleConfigContext ) ) otherlv_8= ')' ) )
            // InternalAdaptersLang.g:387:2: (otherlv_0= 'delta' otherlv_1= '(' ( (lv_delta_2_0= ruleConfigDelta ) ) otherlv_3= ')' otherlv_4= ',' otherlv_5= 'context' otherlv_6= '(' ( (lv_context_7_0= ruleConfigContext ) ) otherlv_8= ')' )
            {
            // InternalAdaptersLang.g:387:2: (otherlv_0= 'delta' otherlv_1= '(' ( (lv_delta_2_0= ruleConfigDelta ) ) otherlv_3= ')' otherlv_4= ',' otherlv_5= 'context' otherlv_6= '(' ( (lv_context_7_0= ruleConfigContext ) ) otherlv_8= ')' )
            // InternalAdaptersLang.g:388:3: otherlv_0= 'delta' otherlv_1= '(' ( (lv_delta_2_0= ruleConfigDelta ) ) otherlv_3= ')' otherlv_4= ',' otherlv_5= 'context' otherlv_6= '(' ( (lv_context_7_0= ruleConfigContext ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_11); 


            			newLeafNode(otherlv_0, grammarAccess.getConfigDiffAccess().getDeltaKeyword_0());
            		

            otherlv_1=(Token)match(input,11,FOLLOW_16); 


            			newLeafNode(otherlv_1, grammarAccess.getConfigDiffAccess().getLeftParenthesisKeyword_1());
            		

            // InternalAdaptersLang.g:396:3: ( (lv_delta_2_0= ruleConfigDelta ) )
            // InternalAdaptersLang.g:397:4: (lv_delta_2_0= ruleConfigDelta )
            {
            // InternalAdaptersLang.g:397:4: (lv_delta_2_0= ruleConfigDelta )
            // InternalAdaptersLang.g:398:5: lv_delta_2_0= ruleConfigDelta
            {

            					newCompositeNode(grammarAccess.getConfigDiffAccess().getDeltaConfigDeltaParserRuleCall_2_0());
            				

            pushFollow(FOLLOW_15);
            lv_delta_2_0=ruleConfigDelta();

            state._fsp--;



            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConfigDiffRule());
            					}
            					set(
            						current,
            						"delta",
            						lv_delta_2_0,
            						"adaptersLang.AdaptersLang.ConfigDelta");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            otherlv_3=(Token)match(input,12,FOLLOW_13); 


            			newLeafNode(otherlv_3, grammarAccess.getConfigDiffAccess().getRightParenthesisKeyword_3());
            		

            otherlv_4=(Token)match(input,15,FOLLOW_17); 


            			newLeafNode(otherlv_4, grammarAccess.getConfigDiffAccess().getCommaKeyword_4());
            		

            otherlv_5=(Token)match(input,20,FOLLOW_11); 


            			newLeafNode(otherlv_5, grammarAccess.getConfigDiffAccess().getContextKeyword_5());
            		

            otherlv_6=(Token)match(input,11,FOLLOW_18); 


            			newLeafNode(otherlv_6, grammarAccess.getConfigDiffAccess().getLeftParenthesisKeyword_6());
            		

            // InternalAdaptersLang.g:431:3: ( (lv_context_7_0= ruleConfigContext ) )
            // InternalAdaptersLang.g:432:4: (lv_context_7_0= ruleConfigContext )
            {
            // InternalAdaptersLang.g:432:4: (lv_context_7_0= ruleConfigContext )
            // InternalAdaptersLang.g:433:5: lv_context_7_0= ruleConfigContext
            {

            					newCompositeNode(grammarAccess.getConfigDiffAccess().getContextConfigContextParserRuleCall_7_0());
            				

            pushFollow(FOLLOW_15);
            lv_context_7_0=ruleConfigContext();

            state._fsp--;



            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConfigDiffRule());
            					}
            					set(
            						current,
            						"context",
            						lv_context_7_0,
            						"adaptersLang.AdaptersLang.ConfigContext");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            otherlv_8=(Token)match(input,12,FOLLOW_2); 


            			newLeafNode(otherlv_8, grammarAccess.getConfigDiffAccess().getRightParenthesisKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "ruleConfigDiff"



    // $ANTLR start "entryRuleConfigDelta"
    // InternalAdaptersLang.g:458:1: entryRuleConfigDelta returns [EObject current=null] :iv_ruleConfigDelta= ruleConfigDelta EOF ;
    public final EObject entryRuleConfigDelta() throws RecognitionException {
        EObject current = null;


        EObject iv_ruleConfigDelta =null;


        try {
            // InternalAdaptersLang.g:458:52: (iv_ruleConfigDelta= ruleConfigDelta EOF )
            // InternalAdaptersLang.g:459:2: iv_ruleConfigDelta= ruleConfigDelta EOF
            {
             newCompositeNode(grammarAccess.getConfigDeltaRule()); 

            pushFollow(FOLLOW_1);
            iv_ruleConfigDelta=ruleConfigDelta();

            state._fsp--;


             current =iv_ruleConfigDelta; 

            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "entryRuleConfigDelta"



    // $ANTLR start "ruleConfigDelta"
    // InternalAdaptersLang.g:465:1: ruleConfigDelta returns [EObject current=null] : ( () otherlv_1= '+-' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '-+' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}' ) ;
    public final EObject ruleConfigDelta() throws RecognitionException {
        EObject current = null;


        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_posSet_3_0 =null;

        AntlrDatatypeRuleToken lv_posSet_5_0 =null;

        AntlrDatatypeRuleToken lv_negSet_10_0 =null;

        AntlrDatatypeRuleToken lv_negSet_12_0 =null;



        	enterRule();

        try {
            // InternalAdaptersLang.g:471:2: ( ( () otherlv_1= '+-' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '-+' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}' ) )
            // InternalAdaptersLang.g:472:2: ( () otherlv_1= '+-' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '-+' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}' )
            {
            // InternalAdaptersLang.g:472:2: ( () otherlv_1= '+-' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '-+' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}' )
            // InternalAdaptersLang.g:473:3: () otherlv_1= '+-' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '-+' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}'
            {
            // InternalAdaptersLang.g:473:3: ()
            // InternalAdaptersLang.g:474:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConfigDeltaAccess().getConfigDeltaAction_0(),
            					current);
            			

            }


            otherlv_1=(Token)match(input,14,FOLLOW_7); 


            			newLeafNode(otherlv_1, grammarAccess.getConfigDeltaAccess().getPlusSignHyphenMinusKeyword_1());
            		

            otherlv_2=(Token)match(input,26,FOLLOW_8); 


            			newLeafNode(otherlv_2, grammarAccess.getConfigDeltaAccess().getLeftCurlyBracketKeyword_2());
            		

            // InternalAdaptersLang.g:488:3: ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAdaptersLang.g:489:4: ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )*
                    {
                    // InternalAdaptersLang.g:489:4: ( (lv_posSet_3_0= ruleEString ) )
                    // InternalAdaptersLang.g:490:5: (lv_posSet_3_0= ruleEString )
                    {
                    // InternalAdaptersLang.g:490:5: (lv_posSet_3_0= ruleEString )
                    // InternalAdaptersLang.g:491:6: lv_posSet_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getConfigDeltaAccess().getPosSetEStringParserRuleCall_3_0_0());
                    					

                    pushFollow(FOLLOW_9);
                    lv_posSet_3_0=ruleEString();

                    state._fsp--;



                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConfigDeltaRule());
                    						}
                    						add(
                    							current,
                    							"posSet",
                    							lv_posSet_3_0,
                    							"adaptersLang.AdaptersLang.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    // InternalAdaptersLang.g:508:4: (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==15) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalAdaptersLang.g:509:5: otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,15,FOLLOW_3); 


                    	    					newLeafNode(otherlv_4, grammarAccess.getConfigDeltaAccess().getCommaKeyword_3_1_0());
                    	    				

                    	    // InternalAdaptersLang.g:513:5: ( (lv_posSet_5_0= ruleEString ) )
                    	    // InternalAdaptersLang.g:514:6: (lv_posSet_5_0= ruleEString )
                    	    {
                    	    // InternalAdaptersLang.g:514:6: (lv_posSet_5_0= ruleEString )
                    	    // InternalAdaptersLang.g:515:7: lv_posSet_5_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getConfigDeltaAccess().getPosSetEStringParserRuleCall_3_1_1_0());
                    	    						

                    	    pushFollow(FOLLOW_9);
                    	    lv_posSet_5_0=ruleEString();

                    	    state._fsp--;



                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getConfigDeltaRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"posSet",
                    	    								lv_posSet_5_0,
                    	    								"adaptersLang.AdaptersLang.EString");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }


            otherlv_6=(Token)match(input,27,FOLLOW_13); 


            			newLeafNode(otherlv_6, grammarAccess.getConfigDeltaAccess().getRightCurlyBracketKeyword_4());
            		

            otherlv_7=(Token)match(input,15,FOLLOW_19); 


            			newLeafNode(otherlv_7, grammarAccess.getConfigDeltaAccess().getCommaKeyword_5());
            		

            otherlv_8=(Token)match(input,16,FOLLOW_7); 


            			newLeafNode(otherlv_8, grammarAccess.getConfigDeltaAccess().getHyphenMinusPlusSignKeyword_6());
            		

            otherlv_9=(Token)match(input,26,FOLLOW_8); 


            			newLeafNode(otherlv_9, grammarAccess.getConfigDeltaAccess().getLeftCurlyBracketKeyword_7());
            		

            // InternalAdaptersLang.g:550:3: ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||LA8_0==RULE_STRING) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalAdaptersLang.g:551:4: ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )*
                    {
                    // InternalAdaptersLang.g:551:4: ( (lv_negSet_10_0= ruleEString ) )
                    // InternalAdaptersLang.g:552:5: (lv_negSet_10_0= ruleEString )
                    {
                    // InternalAdaptersLang.g:552:5: (lv_negSet_10_0= ruleEString )
                    // InternalAdaptersLang.g:553:6: lv_negSet_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getConfigDeltaAccess().getNegSetEStringParserRuleCall_8_0_0());
                    					

                    pushFollow(FOLLOW_9);
                    lv_negSet_10_0=ruleEString();

                    state._fsp--;



                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConfigDeltaRule());
                    						}
                    						add(
                    							current,
                    							"negSet",
                    							lv_negSet_10_0,
                    							"adaptersLang.AdaptersLang.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    // InternalAdaptersLang.g:570:4: (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==15) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalAdaptersLang.g:571:5: otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) )
                    	    {
                    	    otherlv_11=(Token)match(input,15,FOLLOW_3); 


                    	    					newLeafNode(otherlv_11, grammarAccess.getConfigDeltaAccess().getCommaKeyword_8_1_0());
                    	    				

                    	    // InternalAdaptersLang.g:575:5: ( (lv_negSet_12_0= ruleEString ) )
                    	    // InternalAdaptersLang.g:576:6: (lv_negSet_12_0= ruleEString )
                    	    {
                    	    // InternalAdaptersLang.g:576:6: (lv_negSet_12_0= ruleEString )
                    	    // InternalAdaptersLang.g:577:7: lv_negSet_12_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getConfigDeltaAccess().getNegSetEStringParserRuleCall_8_1_1_0());
                    	    						

                    	    pushFollow(FOLLOW_9);
                    	    lv_negSet_12_0=ruleEString();

                    	    state._fsp--;



                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getConfigDeltaRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"negSet",
                    	    								lv_negSet_12_0,
                    	    								"adaptersLang.AdaptersLang.EString");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }


            otherlv_13=(Token)match(input,27,FOLLOW_2); 


            			newLeafNode(otherlv_13, grammarAccess.getConfigDeltaAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "ruleConfigDelta"



    // $ANTLR start "entryRuleConfigContext"
    // InternalAdaptersLang.g:604:1: entryRuleConfigContext returns [EObject current=null] :iv_ruleConfigContext= ruleConfigContext EOF ;
    public final EObject entryRuleConfigContext() throws RecognitionException {
        EObject current = null;


        EObject iv_ruleConfigContext =null;


        try {
            // InternalAdaptersLang.g:604:54: (iv_ruleConfigContext= ruleConfigContext EOF )
            // InternalAdaptersLang.g:605:2: iv_ruleConfigContext= ruleConfigContext EOF
            {
             newCompositeNode(grammarAccess.getConfigContextRule()); 

            pushFollow(FOLLOW_1);
            iv_ruleConfigContext=ruleConfigContext();

            state._fsp--;


             current =iv_ruleConfigContext; 

            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "entryRuleConfigContext"



    // $ANTLR start "ruleConfigContext"
    // InternalAdaptersLang.g:611:1: ruleConfigContext returns [EObject current=null] : ( () otherlv_1= '++' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '--' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}' ) ;
    public final EObject ruleConfigContext() throws RecognitionException {
        EObject current = null;


        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_posSet_3_0 =null;

        AntlrDatatypeRuleToken lv_posSet_5_0 =null;

        AntlrDatatypeRuleToken lv_negSet_10_0 =null;

        AntlrDatatypeRuleToken lv_negSet_12_0 =null;



        	enterRule();

        try {
            // InternalAdaptersLang.g:617:2: ( ( () otherlv_1= '++' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '--' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}' ) )
            // InternalAdaptersLang.g:618:2: ( () otherlv_1= '++' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '--' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}' )
            {
            // InternalAdaptersLang.g:618:2: ( () otherlv_1= '++' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '--' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}' )
            // InternalAdaptersLang.g:619:3: () otherlv_1= '++' otherlv_2= '{' ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )? otherlv_6= '}' otherlv_7= ',' otherlv_8= '--' otherlv_9= '{' ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )? otherlv_13= '}'
            {
            // InternalAdaptersLang.g:619:3: ()
            // InternalAdaptersLang.g:620:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConfigContextAccess().getConfigContextAction_0(),
            					current);
            			

            }


            otherlv_1=(Token)match(input,13,FOLLOW_7); 


            			newLeafNode(otherlv_1, grammarAccess.getConfigContextAccess().getPlusSignPlusSignKeyword_1());
            		

            otherlv_2=(Token)match(input,26,FOLLOW_8); 


            			newLeafNode(otherlv_2, grammarAccess.getConfigContextAccess().getLeftCurlyBracketKeyword_2());
            		

            // InternalAdaptersLang.g:634:3: ( ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||LA10_0==RULE_STRING) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAdaptersLang.g:635:4: ( (lv_posSet_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )*
                    {
                    // InternalAdaptersLang.g:635:4: ( (lv_posSet_3_0= ruleEString ) )
                    // InternalAdaptersLang.g:636:5: (lv_posSet_3_0= ruleEString )
                    {
                    // InternalAdaptersLang.g:636:5: (lv_posSet_3_0= ruleEString )
                    // InternalAdaptersLang.g:637:6: lv_posSet_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getConfigContextAccess().getPosSetEStringParserRuleCall_3_0_0());
                    					

                    pushFollow(FOLLOW_9);
                    lv_posSet_3_0=ruleEString();

                    state._fsp--;



                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConfigContextRule());
                    						}
                    						add(
                    							current,
                    							"posSet",
                    							lv_posSet_3_0,
                    							"adaptersLang.AdaptersLang.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    // InternalAdaptersLang.g:654:4: (otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==15) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalAdaptersLang.g:655:5: otherlv_4= ',' ( (lv_posSet_5_0= ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,15,FOLLOW_3); 


                    	    					newLeafNode(otherlv_4, grammarAccess.getConfigContextAccess().getCommaKeyword_3_1_0());
                    	    				

                    	    // InternalAdaptersLang.g:659:5: ( (lv_posSet_5_0= ruleEString ) )
                    	    // InternalAdaptersLang.g:660:6: (lv_posSet_5_0= ruleEString )
                    	    {
                    	    // InternalAdaptersLang.g:660:6: (lv_posSet_5_0= ruleEString )
                    	    // InternalAdaptersLang.g:661:7: lv_posSet_5_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getConfigContextAccess().getPosSetEStringParserRuleCall_3_1_1_0());
                    	    						

                    	    pushFollow(FOLLOW_9);
                    	    lv_posSet_5_0=ruleEString();

                    	    state._fsp--;



                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getConfigContextRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"posSet",
                    	    								lv_posSet_5_0,
                    	    								"adaptersLang.AdaptersLang.EString");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }


            otherlv_6=(Token)match(input,27,FOLLOW_13); 


            			newLeafNode(otherlv_6, grammarAccess.getConfigContextAccess().getRightCurlyBracketKeyword_4());
            		

            otherlv_7=(Token)match(input,15,FOLLOW_20); 


            			newLeafNode(otherlv_7, grammarAccess.getConfigContextAccess().getCommaKeyword_5());
            		

            otherlv_8=(Token)match(input,17,FOLLOW_7); 


            			newLeafNode(otherlv_8, grammarAccess.getConfigContextAccess().getHyphenMinusHyphenMinusKeyword_6());
            		

            otherlv_9=(Token)match(input,26,FOLLOW_8); 


            			newLeafNode(otherlv_9, grammarAccess.getConfigContextAccess().getLeftCurlyBracketKeyword_7());
            		

            // InternalAdaptersLang.g:696:3: ( ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalAdaptersLang.g:697:4: ( (lv_negSet_10_0= ruleEString ) ) (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )*
                    {
                    // InternalAdaptersLang.g:697:4: ( (lv_negSet_10_0= ruleEString ) )
                    // InternalAdaptersLang.g:698:5: (lv_negSet_10_0= ruleEString )
                    {
                    // InternalAdaptersLang.g:698:5: (lv_negSet_10_0= ruleEString )
                    // InternalAdaptersLang.g:699:6: lv_negSet_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getConfigContextAccess().getNegSetEStringParserRuleCall_8_0_0());
                    					

                    pushFollow(FOLLOW_9);
                    lv_negSet_10_0=ruleEString();

                    state._fsp--;



                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConfigContextRule());
                    						}
                    						add(
                    							current,
                    							"negSet",
                    							lv_negSet_10_0,
                    							"adaptersLang.AdaptersLang.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    // InternalAdaptersLang.g:716:4: (otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==15) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalAdaptersLang.g:717:5: otherlv_11= ',' ( (lv_negSet_12_0= ruleEString ) )
                    	    {
                    	    otherlv_11=(Token)match(input,15,FOLLOW_3); 


                    	    					newLeafNode(otherlv_11, grammarAccess.getConfigContextAccess().getCommaKeyword_8_1_0());
                    	    				

                    	    // InternalAdaptersLang.g:721:5: ( (lv_negSet_12_0= ruleEString ) )
                    	    // InternalAdaptersLang.g:722:6: (lv_negSet_12_0= ruleEString )
                    	    {
                    	    // InternalAdaptersLang.g:722:6: (lv_negSet_12_0= ruleEString )
                    	    // InternalAdaptersLang.g:723:7: lv_negSet_12_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getConfigContextAccess().getNegSetEStringParserRuleCall_8_1_1_0());
                    	    						

                    	    pushFollow(FOLLOW_9);
                    	    lv_negSet_12_0=ruleEString();

                    	    state._fsp--;



                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getConfigContextRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"negSet",
                    	    								lv_negSet_12_0,
                    	    								"adaptersLang.AdaptersLang.EString");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }


            otherlv_13=(Token)match(input,27,FOLLOW_2); 


            			newLeafNode(otherlv_13, grammarAccess.getConfigContextAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }

        finally {
        	// do for sure before leaving
        }
        return current;
    }
    // $ANTLR end "ruleConfigContext"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008000220L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});

}