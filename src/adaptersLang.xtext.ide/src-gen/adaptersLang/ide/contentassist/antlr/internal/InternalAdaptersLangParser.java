package adaptersLang.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import adaptersLang.services.AdaptersLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class InternalAdaptersLangParser extends AbstractInternalContentAssistParser {
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
    public AbstractInternalContentAssistParser[] getDelegates() {
        return new AbstractInternalContentAssistParser[] {};
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

    	public void setGrammarAccess(AdaptersLangGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleAdapterModel"
    // InternalAdaptersLang.g:53:1: entryRuleAdapterModel : ruleAdapterModel EOF ;
    public final void entryRuleAdapterModel() throws RecognitionException {
        try {
            // InternalAdaptersLang.g:54:1: ( ruleAdapterModel EOF )
            // InternalAdaptersLang.g:55:1: ruleAdapterModel EOF
            {
             before(grammarAccess.getAdapterModelRule()); 

            pushFollow(FOLLOW_1);
            ruleAdapterModel();

            state._fsp--;


             after(grammarAccess.getAdapterModelRule()); 

            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "entryRuleAdapterModel"



    // $ANTLR start "ruleAdapterModel"
    // InternalAdaptersLang.g:62:1: ruleAdapterModel : ( ( rule__AdapterModel__Group__0 ) ) ;
    public final void ruleAdapterModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:66:2: ( ( ( rule__AdapterModel__Group__0 ) ) )
            // InternalAdaptersLang.g:67:2: ( ( rule__AdapterModel__Group__0 ) )
            {
            // InternalAdaptersLang.g:67:2: ( ( rule__AdapterModel__Group__0 ) )
            // InternalAdaptersLang.g:68:3: ( rule__AdapterModel__Group__0 )
            {
             before(grammarAccess.getAdapterModelAccess().getGroup()); 

            // InternalAdaptersLang.g:69:3: ( rule__AdapterModel__Group__0 )
            // InternalAdaptersLang.g:69:4: rule__AdapterModel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__0();

            state._fsp--;


            }


             after(grammarAccess.getAdapterModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdapterModel"



    // $ANTLR start "entryRuleAdapter"
    // InternalAdaptersLang.g:78:1: entryRuleAdapter : ruleAdapter EOF ;
    public final void entryRuleAdapter() throws RecognitionException {
        try {
            // InternalAdaptersLang.g:79:1: ( ruleAdapter EOF )
            // InternalAdaptersLang.g:80:1: ruleAdapter EOF
            {
             before(grammarAccess.getAdapterRule()); 

            pushFollow(FOLLOW_1);
            ruleAdapter();

            state._fsp--;


             after(grammarAccess.getAdapterRule()); 

            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "entryRuleAdapter"



    // $ANTLR start "ruleAdapter"
    // InternalAdaptersLang.g:87:1: ruleAdapter : ( ( rule__Adapter__Group__0 ) ) ;
    public final void ruleAdapter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:91:2: ( ( ( rule__Adapter__Group__0 ) ) )
            // InternalAdaptersLang.g:92:2: ( ( rule__Adapter__Group__0 ) )
            {
            // InternalAdaptersLang.g:92:2: ( ( rule__Adapter__Group__0 ) )
            // InternalAdaptersLang.g:93:3: ( rule__Adapter__Group__0 )
            {
             before(grammarAccess.getAdapterAccess().getGroup()); 

            // InternalAdaptersLang.g:94:3: ( rule__Adapter__Group__0 )
            // InternalAdaptersLang.g:94:4: rule__Adapter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Adapter__Group__0();

            state._fsp--;


            }


             after(grammarAccess.getAdapterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdapter"



    // $ANTLR start "entryRuleEString"
    // InternalAdaptersLang.g:103:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalAdaptersLang.g:104:1: ( ruleEString EOF )
            // InternalAdaptersLang.g:105:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 

            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getEStringRule()); 

            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"



    // $ANTLR start "ruleEString"
    // InternalAdaptersLang.g:112:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:116:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalAdaptersLang.g:117:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalAdaptersLang.g:117:2: ( ( rule__EString__Alternatives ) )
            // InternalAdaptersLang.g:118:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 

            // InternalAdaptersLang.g:119:3: ( rule__EString__Alternatives )
            // InternalAdaptersLang.g:119:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }


             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"



    // $ANTLR start "entryRuleConfigDiff"
    // InternalAdaptersLang.g:128:1: entryRuleConfigDiff : ruleConfigDiff EOF ;
    public final void entryRuleConfigDiff() throws RecognitionException {
        try {
            // InternalAdaptersLang.g:129:1: ( ruleConfigDiff EOF )
            // InternalAdaptersLang.g:130:1: ruleConfigDiff EOF
            {
             before(grammarAccess.getConfigDiffRule()); 

            pushFollow(FOLLOW_1);
            ruleConfigDiff();

            state._fsp--;


             after(grammarAccess.getConfigDiffRule()); 

            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "entryRuleConfigDiff"



    // $ANTLR start "ruleConfigDiff"
    // InternalAdaptersLang.g:137:1: ruleConfigDiff : ( ( rule__ConfigDiff__Group__0 ) ) ;
    public final void ruleConfigDiff() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:141:2: ( ( ( rule__ConfigDiff__Group__0 ) ) )
            // InternalAdaptersLang.g:142:2: ( ( rule__ConfigDiff__Group__0 ) )
            {
            // InternalAdaptersLang.g:142:2: ( ( rule__ConfigDiff__Group__0 ) )
            // InternalAdaptersLang.g:143:3: ( rule__ConfigDiff__Group__0 )
            {
             before(grammarAccess.getConfigDiffAccess().getGroup()); 

            // InternalAdaptersLang.g:144:3: ( rule__ConfigDiff__Group__0 )
            // InternalAdaptersLang.g:144:4: rule__ConfigDiff__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__0();

            state._fsp--;


            }


             after(grammarAccess.getConfigDiffAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfigDiff"



    // $ANTLR start "entryRuleConfigDelta"
    // InternalAdaptersLang.g:153:1: entryRuleConfigDelta : ruleConfigDelta EOF ;
    public final void entryRuleConfigDelta() throws RecognitionException {
        try {
            // InternalAdaptersLang.g:154:1: ( ruleConfigDelta EOF )
            // InternalAdaptersLang.g:155:1: ruleConfigDelta EOF
            {
             before(grammarAccess.getConfigDeltaRule()); 

            pushFollow(FOLLOW_1);
            ruleConfigDelta();

            state._fsp--;


             after(grammarAccess.getConfigDeltaRule()); 

            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "entryRuleConfigDelta"



    // $ANTLR start "ruleConfigDelta"
    // InternalAdaptersLang.g:162:1: ruleConfigDelta : ( ( rule__ConfigDelta__Group__0 ) ) ;
    public final void ruleConfigDelta() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:166:2: ( ( ( rule__ConfigDelta__Group__0 ) ) )
            // InternalAdaptersLang.g:167:2: ( ( rule__ConfigDelta__Group__0 ) )
            {
            // InternalAdaptersLang.g:167:2: ( ( rule__ConfigDelta__Group__0 ) )
            // InternalAdaptersLang.g:168:3: ( rule__ConfigDelta__Group__0 )
            {
             before(grammarAccess.getConfigDeltaAccess().getGroup()); 

            // InternalAdaptersLang.g:169:3: ( rule__ConfigDelta__Group__0 )
            // InternalAdaptersLang.g:169:4: rule__ConfigDelta__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__0();

            state._fsp--;


            }


             after(grammarAccess.getConfigDeltaAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfigDelta"



    // $ANTLR start "entryRuleConfigContext"
    // InternalAdaptersLang.g:178:1: entryRuleConfigContext : ruleConfigContext EOF ;
    public final void entryRuleConfigContext() throws RecognitionException {
        try {
            // InternalAdaptersLang.g:179:1: ( ruleConfigContext EOF )
            // InternalAdaptersLang.g:180:1: ruleConfigContext EOF
            {
             before(grammarAccess.getConfigContextRule()); 

            pushFollow(FOLLOW_1);
            ruleConfigContext();

            state._fsp--;


             after(grammarAccess.getConfigContextRule()); 

            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "entryRuleConfigContext"



    // $ANTLR start "ruleConfigContext"
    // InternalAdaptersLang.g:187:1: ruleConfigContext : ( ( rule__ConfigContext__Group__0 ) ) ;
    public final void ruleConfigContext() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:191:2: ( ( ( rule__ConfigContext__Group__0 ) ) )
            // InternalAdaptersLang.g:192:2: ( ( rule__ConfigContext__Group__0 ) )
            {
            // InternalAdaptersLang.g:192:2: ( ( rule__ConfigContext__Group__0 ) )
            // InternalAdaptersLang.g:193:3: ( rule__ConfigContext__Group__0 )
            {
             before(grammarAccess.getConfigContextAccess().getGroup()); 

            // InternalAdaptersLang.g:194:3: ( rule__ConfigContext__Group__0 )
            // InternalAdaptersLang.g:194:4: rule__ConfigContext__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__0();

            state._fsp--;


            }


             after(grammarAccess.getConfigContextAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConfigContext"



    // $ANTLR start "rule__EString__Alternatives"
    // InternalAdaptersLang.g:202:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:206:2: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // InternalAdaptersLang.g:207:2: ( RULE_STRING )
                    {
                    // InternalAdaptersLang.g:207:2: ( RULE_STRING )
                    // InternalAdaptersLang.g:208:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    match(input,RULE_STRING,FOLLOW_2); 

                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAdaptersLang.g:213:2: ( RULE_ID )
                    {
                    // InternalAdaptersLang.g:213:2: ( RULE_ID )
                    // InternalAdaptersLang.g:214:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    match(input,RULE_ID,FOLLOW_2); 

                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"



    // $ANTLR start "rule__AdapterModel__Group__0"
    // InternalAdaptersLang.g:223:1: rule__AdapterModel__Group__0 : rule__AdapterModel__Group__0__Impl rule__AdapterModel__Group__1 ;
    public final void rule__AdapterModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:227:2: ( rule__AdapterModel__Group__0__Impl rule__AdapterModel__Group__1 )
            // InternalAdaptersLang.g:228:2: rule__AdapterModel__Group__0__Impl rule__AdapterModel__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__AdapterModel__Group__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__0"



    // $ANTLR start "rule__AdapterModel__Group__0__Impl"
    // InternalAdaptersLang.g:235:1: rule__AdapterModel__Group__0__Impl : ( 'language' ) ;
    public final void rule__AdapterModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:239:2: ( ( 'language' ) )
            // InternalAdaptersLang.g:240:2: ( 'language' )
            {
            // InternalAdaptersLang.g:240:2: ( 'language' )
            // InternalAdaptersLang.g:241:2: 'language'
            {
             before(grammarAccess.getAdapterModelAccess().getLanguageKeyword_0()); 

            match(input,22,FOLLOW_2); 

             after(grammarAccess.getAdapterModelAccess().getLanguageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__0__Impl"



    // $ANTLR start "rule__AdapterModel__Group__1"
    // InternalAdaptersLang.g:250:1: rule__AdapterModel__Group__1 : rule__AdapterModel__Group__1__Impl rule__AdapterModel__Group__2 ;
    public final void rule__AdapterModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:254:2: ( rule__AdapterModel__Group__1__Impl rule__AdapterModel__Group__2 )
            // InternalAdaptersLang.g:255:2: rule__AdapterModel__Group__1__Impl rule__AdapterModel__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__AdapterModel__Group__1__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__1"



    // $ANTLR start "rule__AdapterModel__Group__1__Impl"
    // InternalAdaptersLang.g:262:1: rule__AdapterModel__Group__1__Impl : ( ( rule__AdapterModel__NameAssignment_1 ) ) ;
    public final void rule__AdapterModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:266:2: ( ( ( rule__AdapterModel__NameAssignment_1 ) ) )
            // InternalAdaptersLang.g:267:2: ( ( rule__AdapterModel__NameAssignment_1 ) )
            {
            // InternalAdaptersLang.g:267:2: ( ( rule__AdapterModel__NameAssignment_1 ) )
            // InternalAdaptersLang.g:268:2: ( rule__AdapterModel__NameAssignment_1 )
            {
             before(grammarAccess.getAdapterModelAccess().getNameAssignment_1()); 

            // InternalAdaptersLang.g:269:2: ( rule__AdapterModel__NameAssignment_1 )
            // InternalAdaptersLang.g:269:3: rule__AdapterModel__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AdapterModel__NameAssignment_1();

            state._fsp--;


            }


             after(grammarAccess.getAdapterModelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__1__Impl"



    // $ANTLR start "rule__AdapterModel__Group__2"
    // InternalAdaptersLang.g:277:1: rule__AdapterModel__Group__2 : rule__AdapterModel__Group__2__Impl rule__AdapterModel__Group__3 ;
    public final void rule__AdapterModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:281:2: ( rule__AdapterModel__Group__2__Impl rule__AdapterModel__Group__3 )
            // InternalAdaptersLang.g:282:2: rule__AdapterModel__Group__2__Impl rule__AdapterModel__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__AdapterModel__Group__2__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__2"



    // $ANTLR start "rule__AdapterModel__Group__2__Impl"
    // InternalAdaptersLang.g:289:1: rule__AdapterModel__Group__2__Impl : ( 'on' ) ;
    public final void rule__AdapterModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:293:2: ( ( 'on' ) )
            // InternalAdaptersLang.g:294:2: ( 'on' )
            {
            // InternalAdaptersLang.g:294:2: ( 'on' )
            // InternalAdaptersLang.g:295:2: 'on'
            {
             before(grammarAccess.getAdapterModelAccess().getOnKeyword_2()); 

            match(input,23,FOLLOW_2); 

             after(grammarAccess.getAdapterModelAccess().getOnKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__2__Impl"



    // $ANTLR start "rule__AdapterModel__Group__3"
    // InternalAdaptersLang.g:304:1: rule__AdapterModel__Group__3 : rule__AdapterModel__Group__3__Impl rule__AdapterModel__Group__4 ;
    public final void rule__AdapterModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:308:2: ( rule__AdapterModel__Group__3__Impl rule__AdapterModel__Group__4 )
            // InternalAdaptersLang.g:309:2: rule__AdapterModel__Group__3__Impl rule__AdapterModel__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__AdapterModel__Group__3__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__3"



    // $ANTLR start "rule__AdapterModel__Group__3__Impl"
    // InternalAdaptersLang.g:316:1: rule__AdapterModel__Group__3__Impl : ( ( rule__AdapterModel__EcoreAssignment_3 ) ) ;
    public final void rule__AdapterModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:320:2: ( ( ( rule__AdapterModel__EcoreAssignment_3 ) ) )
            // InternalAdaptersLang.g:321:2: ( ( rule__AdapterModel__EcoreAssignment_3 ) )
            {
            // InternalAdaptersLang.g:321:2: ( ( rule__AdapterModel__EcoreAssignment_3 ) )
            // InternalAdaptersLang.g:322:2: ( rule__AdapterModel__EcoreAssignment_3 )
            {
             before(grammarAccess.getAdapterModelAccess().getEcoreAssignment_3()); 

            // InternalAdaptersLang.g:323:2: ( rule__AdapterModel__EcoreAssignment_3 )
            // InternalAdaptersLang.g:323:3: rule__AdapterModel__EcoreAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__AdapterModel__EcoreAssignment_3();

            state._fsp--;


            }


             after(grammarAccess.getAdapterModelAccess().getEcoreAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__3__Impl"



    // $ANTLR start "rule__AdapterModel__Group__4"
    // InternalAdaptersLang.g:331:1: rule__AdapterModel__Group__4 : rule__AdapterModel__Group__4__Impl rule__AdapterModel__Group__5 ;
    public final void rule__AdapterModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:335:2: ( rule__AdapterModel__Group__4__Impl rule__AdapterModel__Group__5 )
            // InternalAdaptersLang.g:336:2: rule__AdapterModel__Group__4__Impl rule__AdapterModel__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__AdapterModel__Group__4__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__4"



    // $ANTLR start "rule__AdapterModel__Group__4__Impl"
    // InternalAdaptersLang.g:343:1: rule__AdapterModel__Group__4__Impl : ( 'transformation' ) ;
    public final void rule__AdapterModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:347:2: ( ( 'transformation' ) )
            // InternalAdaptersLang.g:348:2: ( 'transformation' )
            {
            // InternalAdaptersLang.g:348:2: ( 'transformation' )
            // InternalAdaptersLang.g:349:2: 'transformation'
            {
             before(grammarAccess.getAdapterModelAccess().getTransformationKeyword_4()); 

            match(input,25,FOLLOW_2); 

             after(grammarAccess.getAdapterModelAccess().getTransformationKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__4__Impl"



    // $ANTLR start "rule__AdapterModel__Group__5"
    // InternalAdaptersLang.g:358:1: rule__AdapterModel__Group__5 : rule__AdapterModel__Group__5__Impl rule__AdapterModel__Group__6 ;
    public final void rule__AdapterModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:362:2: ( rule__AdapterModel__Group__5__Impl rule__AdapterModel__Group__6 )
            // InternalAdaptersLang.g:363:2: rule__AdapterModel__Group__5__Impl rule__AdapterModel__Group__6
            {
            pushFollow(FOLLOW_6);
            rule__AdapterModel__Group__5__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__5"



    // $ANTLR start "rule__AdapterModel__Group__5__Impl"
    // InternalAdaptersLang.g:370:1: rule__AdapterModel__Group__5__Impl : ( ( rule__AdapterModel__TransformationAssignment_5 ) ) ;
    public final void rule__AdapterModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:374:2: ( ( ( rule__AdapterModel__TransformationAssignment_5 ) ) )
            // InternalAdaptersLang.g:375:2: ( ( rule__AdapterModel__TransformationAssignment_5 ) )
            {
            // InternalAdaptersLang.g:375:2: ( ( rule__AdapterModel__TransformationAssignment_5 ) )
            // InternalAdaptersLang.g:376:2: ( rule__AdapterModel__TransformationAssignment_5 )
            {
             before(grammarAccess.getAdapterModelAccess().getTransformationAssignment_5()); 

            // InternalAdaptersLang.g:377:2: ( rule__AdapterModel__TransformationAssignment_5 )
            // InternalAdaptersLang.g:377:3: rule__AdapterModel__TransformationAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__AdapterModel__TransformationAssignment_5();

            state._fsp--;


            }


             after(grammarAccess.getAdapterModelAccess().getTransformationAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__5__Impl"



    // $ANTLR start "rule__AdapterModel__Group__6"
    // InternalAdaptersLang.g:385:1: rule__AdapterModel__Group__6 : rule__AdapterModel__Group__6__Impl rule__AdapterModel__Group__7 ;
    public final void rule__AdapterModel__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:389:2: ( rule__AdapterModel__Group__6__Impl rule__AdapterModel__Group__7 )
            // InternalAdaptersLang.g:390:2: rule__AdapterModel__Group__6__Impl rule__AdapterModel__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__AdapterModel__Group__6__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__6"



    // $ANTLR start "rule__AdapterModel__Group__6__Impl"
    // InternalAdaptersLang.g:397:1: rule__AdapterModel__Group__6__Impl : ( 'adapters' ) ;
    public final void rule__AdapterModel__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:401:2: ( ( 'adapters' ) )
            // InternalAdaptersLang.g:402:2: ( 'adapters' )
            {
            // InternalAdaptersLang.g:402:2: ( 'adapters' )
            // InternalAdaptersLang.g:403:2: 'adapters'
            {
             before(grammarAccess.getAdapterModelAccess().getAdaptersKeyword_6()); 

            match(input,19,FOLLOW_2); 

             after(grammarAccess.getAdapterModelAccess().getAdaptersKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__6__Impl"



    // $ANTLR start "rule__AdapterModel__Group__7"
    // InternalAdaptersLang.g:412:1: rule__AdapterModel__Group__7 : rule__AdapterModel__Group__7__Impl rule__AdapterModel__Group__8 ;
    public final void rule__AdapterModel__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:416:2: ( rule__AdapterModel__Group__7__Impl rule__AdapterModel__Group__8 )
            // InternalAdaptersLang.g:417:2: rule__AdapterModel__Group__7__Impl rule__AdapterModel__Group__8
            {
            pushFollow(FOLLOW_8);
            rule__AdapterModel__Group__7__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__7"



    // $ANTLR start "rule__AdapterModel__Group__7__Impl"
    // InternalAdaptersLang.g:424:1: rule__AdapterModel__Group__7__Impl : ( '{' ) ;
    public final void rule__AdapterModel__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:428:2: ( ( '{' ) )
            // InternalAdaptersLang.g:429:2: ( '{' )
            {
            // InternalAdaptersLang.g:429:2: ( '{' )
            // InternalAdaptersLang.g:430:2: '{'
            {
             before(grammarAccess.getAdapterModelAccess().getLeftCurlyBracketKeyword_7()); 

            match(input,26,FOLLOW_2); 

             after(grammarAccess.getAdapterModelAccess().getLeftCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__7__Impl"



    // $ANTLR start "rule__AdapterModel__Group__8"
    // InternalAdaptersLang.g:439:1: rule__AdapterModel__Group__8 : rule__AdapterModel__Group__8__Impl rule__AdapterModel__Group__9 ;
    public final void rule__AdapterModel__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:443:2: ( rule__AdapterModel__Group__8__Impl rule__AdapterModel__Group__9 )
            // InternalAdaptersLang.g:444:2: rule__AdapterModel__Group__8__Impl rule__AdapterModel__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__AdapterModel__Group__8__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__8"



    // $ANTLR start "rule__AdapterModel__Group__8__Impl"
    // InternalAdaptersLang.g:451:1: rule__AdapterModel__Group__8__Impl : ( ( rule__AdapterModel__Group_8__0 )? ) ;
    public final void rule__AdapterModel__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:455:2: ( ( ( rule__AdapterModel__Group_8__0 )? ) )
            // InternalAdaptersLang.g:456:2: ( ( rule__AdapterModel__Group_8__0 )? )
            {
            // InternalAdaptersLang.g:456:2: ( ( rule__AdapterModel__Group_8__0 )? )
            // InternalAdaptersLang.g:457:2: ( rule__AdapterModel__Group_8__0 )?
            {
             before(grammarAccess.getAdapterModelAccess().getGroup_8()); 

            // InternalAdaptersLang.g:458:2: ( rule__AdapterModel__Group_8__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalAdaptersLang.g:458:3: rule__AdapterModel__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AdapterModel__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }


             after(grammarAccess.getAdapterModelAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__8__Impl"



    // $ANTLR start "rule__AdapterModel__Group__9"
    // InternalAdaptersLang.g:466:1: rule__AdapterModel__Group__9 : rule__AdapterModel__Group__9__Impl ;
    public final void rule__AdapterModel__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:470:2: ( rule__AdapterModel__Group__9__Impl )
            // InternalAdaptersLang.g:471:2: rule__AdapterModel__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__9"



    // $ANTLR start "rule__AdapterModel__Group__9__Impl"
    // InternalAdaptersLang.g:477:1: rule__AdapterModel__Group__9__Impl : ( '}' ) ;
    public final void rule__AdapterModel__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:481:2: ( ( '}' ) )
            // InternalAdaptersLang.g:482:2: ( '}' )
            {
            // InternalAdaptersLang.g:482:2: ( '}' )
            // InternalAdaptersLang.g:483:2: '}'
            {
             before(grammarAccess.getAdapterModelAccess().getRightCurlyBracketKeyword_9()); 

            match(input,27,FOLLOW_2); 

             after(grammarAccess.getAdapterModelAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group__9__Impl"



    // $ANTLR start "rule__AdapterModel__Group_8__0"
    // InternalAdaptersLang.g:493:1: rule__AdapterModel__Group_8__0 : rule__AdapterModel__Group_8__0__Impl rule__AdapterModel__Group_8__1 ;
    public final void rule__AdapterModel__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:497:2: ( rule__AdapterModel__Group_8__0__Impl rule__AdapterModel__Group_8__1 )
            // InternalAdaptersLang.g:498:2: rule__AdapterModel__Group_8__0__Impl rule__AdapterModel__Group_8__1
            {
            pushFollow(FOLLOW_10);
            rule__AdapterModel__Group_8__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group_8__0"



    // $ANTLR start "rule__AdapterModel__Group_8__0__Impl"
    // InternalAdaptersLang.g:505:1: rule__AdapterModel__Group_8__0__Impl : ( ( rule__AdapterModel__AdaptersAssignment_8_0 ) ) ;
    public final void rule__AdapterModel__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:509:2: ( ( ( rule__AdapterModel__AdaptersAssignment_8_0 ) ) )
            // InternalAdaptersLang.g:510:2: ( ( rule__AdapterModel__AdaptersAssignment_8_0 ) )
            {
            // InternalAdaptersLang.g:510:2: ( ( rule__AdapterModel__AdaptersAssignment_8_0 ) )
            // InternalAdaptersLang.g:511:2: ( rule__AdapterModel__AdaptersAssignment_8_0 )
            {
             before(grammarAccess.getAdapterModelAccess().getAdaptersAssignment_8_0()); 

            // InternalAdaptersLang.g:512:2: ( rule__AdapterModel__AdaptersAssignment_8_0 )
            // InternalAdaptersLang.g:512:3: rule__AdapterModel__AdaptersAssignment_8_0
            {
            pushFollow(FOLLOW_2);
            rule__AdapterModel__AdaptersAssignment_8_0();

            state._fsp--;


            }


             after(grammarAccess.getAdapterModelAccess().getAdaptersAssignment_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group_8__0__Impl"



    // $ANTLR start "rule__AdapterModel__Group_8__1"
    // InternalAdaptersLang.g:520:1: rule__AdapterModel__Group_8__1 : rule__AdapterModel__Group_8__1__Impl ;
    public final void rule__AdapterModel__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:524:2: ( rule__AdapterModel__Group_8__1__Impl )
            // InternalAdaptersLang.g:525:2: rule__AdapterModel__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group_8__1"



    // $ANTLR start "rule__AdapterModel__Group_8__1__Impl"
    // InternalAdaptersLang.g:531:1: rule__AdapterModel__Group_8__1__Impl : ( ( rule__AdapterModel__Group_8_1__0 )* ) ;
    public final void rule__AdapterModel__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:535:2: ( ( ( rule__AdapterModel__Group_8_1__0 )* ) )
            // InternalAdaptersLang.g:536:2: ( ( rule__AdapterModel__Group_8_1__0 )* )
            {
            // InternalAdaptersLang.g:536:2: ( ( rule__AdapterModel__Group_8_1__0 )* )
            // InternalAdaptersLang.g:537:2: ( rule__AdapterModel__Group_8_1__0 )*
            {
             before(grammarAccess.getAdapterModelAccess().getGroup_8_1()); 

            // InternalAdaptersLang.g:538:2: ( rule__AdapterModel__Group_8_1__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalAdaptersLang.g:538:3: rule__AdapterModel__Group_8_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__AdapterModel__Group_8_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


             after(grammarAccess.getAdapterModelAccess().getGroup_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group_8__1__Impl"



    // $ANTLR start "rule__AdapterModel__Group_8_1__0"
    // InternalAdaptersLang.g:547:1: rule__AdapterModel__Group_8_1__0 : rule__AdapterModel__Group_8_1__0__Impl rule__AdapterModel__Group_8_1__1 ;
    public final void rule__AdapterModel__Group_8_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:551:2: ( rule__AdapterModel__Group_8_1__0__Impl rule__AdapterModel__Group_8_1__1 )
            // InternalAdaptersLang.g:552:2: rule__AdapterModel__Group_8_1__0__Impl rule__AdapterModel__Group_8_1__1
            {
            pushFollow(FOLLOW_3);
            rule__AdapterModel__Group_8_1__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group_8_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group_8_1__0"



    // $ANTLR start "rule__AdapterModel__Group_8_1__0__Impl"
    // InternalAdaptersLang.g:559:1: rule__AdapterModel__Group_8_1__0__Impl : ( ',' ) ;
    public final void rule__AdapterModel__Group_8_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:563:2: ( ( ',' ) )
            // InternalAdaptersLang.g:564:2: ( ',' )
            {
            // InternalAdaptersLang.g:564:2: ( ',' )
            // InternalAdaptersLang.g:565:2: ','
            {
             before(grammarAccess.getAdapterModelAccess().getCommaKeyword_8_1_0()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getAdapterModelAccess().getCommaKeyword_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group_8_1__0__Impl"



    // $ANTLR start "rule__AdapterModel__Group_8_1__1"
    // InternalAdaptersLang.g:574:1: rule__AdapterModel__Group_8_1__1 : rule__AdapterModel__Group_8_1__1__Impl ;
    public final void rule__AdapterModel__Group_8_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:578:2: ( rule__AdapterModel__Group_8_1__1__Impl )
            // InternalAdaptersLang.g:579:2: rule__AdapterModel__Group_8_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdapterModel__Group_8_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group_8_1__1"



    // $ANTLR start "rule__AdapterModel__Group_8_1__1__Impl"
    // InternalAdaptersLang.g:585:1: rule__AdapterModel__Group_8_1__1__Impl : ( ( rule__AdapterModel__AdaptersAssignment_8_1_1 ) ) ;
    public final void rule__AdapterModel__Group_8_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:589:2: ( ( ( rule__AdapterModel__AdaptersAssignment_8_1_1 ) ) )
            // InternalAdaptersLang.g:590:2: ( ( rule__AdapterModel__AdaptersAssignment_8_1_1 ) )
            {
            // InternalAdaptersLang.g:590:2: ( ( rule__AdapterModel__AdaptersAssignment_8_1_1 ) )
            // InternalAdaptersLang.g:591:2: ( rule__AdapterModel__AdaptersAssignment_8_1_1 )
            {
             before(grammarAccess.getAdapterModelAccess().getAdaptersAssignment_8_1_1()); 

            // InternalAdaptersLang.g:592:2: ( rule__AdapterModel__AdaptersAssignment_8_1_1 )
            // InternalAdaptersLang.g:592:3: rule__AdapterModel__AdaptersAssignment_8_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AdapterModel__AdaptersAssignment_8_1_1();

            state._fsp--;


            }


             after(grammarAccess.getAdapterModelAccess().getAdaptersAssignment_8_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__Group_8_1__1__Impl"



    // $ANTLR start "rule__Adapter__Group__0"
    // InternalAdaptersLang.g:601:1: rule__Adapter__Group__0 : rule__Adapter__Group__0__Impl rule__Adapter__Group__1 ;
    public final void rule__Adapter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:605:2: ( rule__Adapter__Group__0__Impl rule__Adapter__Group__1 )
            // InternalAdaptersLang.g:606:2: rule__Adapter__Group__0__Impl rule__Adapter__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Adapter__Group__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__0"



    // $ANTLR start "rule__Adapter__Group__0__Impl"
    // InternalAdaptersLang.g:613:1: rule__Adapter__Group__0__Impl : ( ( rule__Adapter__NameAssignment_0 ) ) ;
    public final void rule__Adapter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:617:2: ( ( ( rule__Adapter__NameAssignment_0 ) ) )
            // InternalAdaptersLang.g:618:2: ( ( rule__Adapter__NameAssignment_0 ) )
            {
            // InternalAdaptersLang.g:618:2: ( ( rule__Adapter__NameAssignment_0 ) )
            // InternalAdaptersLang.g:619:2: ( rule__Adapter__NameAssignment_0 )
            {
             before(grammarAccess.getAdapterAccess().getNameAssignment_0()); 

            // InternalAdaptersLang.g:620:2: ( rule__Adapter__NameAssignment_0 )
            // InternalAdaptersLang.g:620:3: rule__Adapter__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Adapter__NameAssignment_0();

            state._fsp--;


            }


             after(grammarAccess.getAdapterAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__0__Impl"



    // $ANTLR start "rule__Adapter__Group__1"
    // InternalAdaptersLang.g:628:1: rule__Adapter__Group__1 : rule__Adapter__Group__1__Impl rule__Adapter__Group__2 ;
    public final void rule__Adapter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:632:2: ( rule__Adapter__Group__1__Impl rule__Adapter__Group__2 )
            // InternalAdaptersLang.g:633:2: rule__Adapter__Group__1__Impl rule__Adapter__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__Adapter__Group__1__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__1"



    // $ANTLR start "rule__Adapter__Group__1__Impl"
    // InternalAdaptersLang.g:640:1: rule__Adapter__Group__1__Impl : ( '=' ) ;
    public final void rule__Adapter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:644:2: ( ( '=' ) )
            // InternalAdaptersLang.g:645:2: ( '=' )
            {
            // InternalAdaptersLang.g:645:2: ( '=' )
            // InternalAdaptersLang.g:646:2: '='
            {
             before(grammarAccess.getAdapterAccess().getEqualsSignKeyword_1()); 

            match(input,18,FOLLOW_2); 

             after(grammarAccess.getAdapterAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__1__Impl"



    // $ANTLR start "rule__Adapter__Group__2"
    // InternalAdaptersLang.g:655:1: rule__Adapter__Group__2 : rule__Adapter__Group__2__Impl rule__Adapter__Group__3 ;
    public final void rule__Adapter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:659:2: ( rule__Adapter__Group__2__Impl rule__Adapter__Group__3 )
            // InternalAdaptersLang.g:660:2: rule__Adapter__Group__2__Impl rule__Adapter__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__Adapter__Group__2__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__2"



    // $ANTLR start "rule__Adapter__Group__2__Impl"
    // InternalAdaptersLang.g:667:1: rule__Adapter__Group__2__Impl : ( '(' ) ;
    public final void rule__Adapter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:671:2: ( ( '(' ) )
            // InternalAdaptersLang.g:672:2: ( '(' )
            {
            // InternalAdaptersLang.g:672:2: ( '(' )
            // InternalAdaptersLang.g:673:2: '('
            {
             before(grammarAccess.getAdapterAccess().getLeftParenthesisKeyword_2()); 

            match(input,11,FOLLOW_2); 

             after(grammarAccess.getAdapterAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__2__Impl"



    // $ANTLR start "rule__Adapter__Group__3"
    // InternalAdaptersLang.g:682:1: rule__Adapter__Group__3 : rule__Adapter__Group__3__Impl rule__Adapter__Group__4 ;
    public final void rule__Adapter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:686:2: ( rule__Adapter__Group__3__Impl rule__Adapter__Group__4 )
            // InternalAdaptersLang.g:687:2: rule__Adapter__Group__3__Impl rule__Adapter__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__Adapter__Group__3__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__3"



    // $ANTLR start "rule__Adapter__Group__3__Impl"
    // InternalAdaptersLang.g:694:1: rule__Adapter__Group__3__Impl : ( ( rule__Adapter__CfgDiffAssignment_3 ) ) ;
    public final void rule__Adapter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:698:2: ( ( ( rule__Adapter__CfgDiffAssignment_3 ) ) )
            // InternalAdaptersLang.g:699:2: ( ( rule__Adapter__CfgDiffAssignment_3 ) )
            {
            // InternalAdaptersLang.g:699:2: ( ( rule__Adapter__CfgDiffAssignment_3 ) )
            // InternalAdaptersLang.g:700:2: ( rule__Adapter__CfgDiffAssignment_3 )
            {
             before(grammarAccess.getAdapterAccess().getCfgDiffAssignment_3()); 

            // InternalAdaptersLang.g:701:2: ( rule__Adapter__CfgDiffAssignment_3 )
            // InternalAdaptersLang.g:701:3: rule__Adapter__CfgDiffAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Adapter__CfgDiffAssignment_3();

            state._fsp--;


            }


             after(grammarAccess.getAdapterAccess().getCfgDiffAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__3__Impl"



    // $ANTLR start "rule__Adapter__Group__4"
    // InternalAdaptersLang.g:709:1: rule__Adapter__Group__4 : rule__Adapter__Group__4__Impl rule__Adapter__Group__5 ;
    public final void rule__Adapter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:713:2: ( rule__Adapter__Group__4__Impl rule__Adapter__Group__5 )
            // InternalAdaptersLang.g:714:2: rule__Adapter__Group__4__Impl rule__Adapter__Group__5
            {
            pushFollow(FOLLOW_15);
            rule__Adapter__Group__4__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__4"



    // $ANTLR start "rule__Adapter__Group__4__Impl"
    // InternalAdaptersLang.g:721:1: rule__Adapter__Group__4__Impl : ( ',' ) ;
    public final void rule__Adapter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:725:2: ( ( ',' ) )
            // InternalAdaptersLang.g:726:2: ( ',' )
            {
            // InternalAdaptersLang.g:726:2: ( ',' )
            // InternalAdaptersLang.g:727:2: ','
            {
             before(grammarAccess.getAdapterAccess().getCommaKeyword_4()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getAdapterAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__4__Impl"



    // $ANTLR start "rule__Adapter__Group__5"
    // InternalAdaptersLang.g:736:1: rule__Adapter__Group__5 : rule__Adapter__Group__5__Impl rule__Adapter__Group__6 ;
    public final void rule__Adapter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:740:2: ( rule__Adapter__Group__5__Impl rule__Adapter__Group__6 )
            // InternalAdaptersLang.g:741:2: rule__Adapter__Group__5__Impl rule__Adapter__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__Adapter__Group__5__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__5"



    // $ANTLR start "rule__Adapter__Group__5__Impl"
    // InternalAdaptersLang.g:748:1: rule__Adapter__Group__5__Impl : ( 'rules' ) ;
    public final void rule__Adapter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:752:2: ( ( 'rules' ) )
            // InternalAdaptersLang.g:753:2: ( 'rules' )
            {
            // InternalAdaptersLang.g:753:2: ( 'rules' )
            // InternalAdaptersLang.g:754:2: 'rules'
            {
             before(grammarAccess.getAdapterAccess().getRulesKeyword_5()); 

            match(input,24,FOLLOW_2); 

             after(grammarAccess.getAdapterAccess().getRulesKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__5__Impl"



    // $ANTLR start "rule__Adapter__Group__6"
    // InternalAdaptersLang.g:763:1: rule__Adapter__Group__6 : rule__Adapter__Group__6__Impl rule__Adapter__Group__7 ;
    public final void rule__Adapter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:767:2: ( rule__Adapter__Group__6__Impl rule__Adapter__Group__7 )
            // InternalAdaptersLang.g:768:2: rule__Adapter__Group__6__Impl rule__Adapter__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Adapter__Group__6__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__6"



    // $ANTLR start "rule__Adapter__Group__6__Impl"
    // InternalAdaptersLang.g:775:1: rule__Adapter__Group__6__Impl : ( '{' ) ;
    public final void rule__Adapter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:779:2: ( ( '{' ) )
            // InternalAdaptersLang.g:780:2: ( '{' )
            {
            // InternalAdaptersLang.g:780:2: ( '{' )
            // InternalAdaptersLang.g:781:2: '{'
            {
             before(grammarAccess.getAdapterAccess().getLeftCurlyBracketKeyword_6()); 

            match(input,26,FOLLOW_2); 

             after(grammarAccess.getAdapterAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__6__Impl"



    // $ANTLR start "rule__Adapter__Group__7"
    // InternalAdaptersLang.g:790:1: rule__Adapter__Group__7 : rule__Adapter__Group__7__Impl rule__Adapter__Group__8 ;
    public final void rule__Adapter__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:794:2: ( rule__Adapter__Group__7__Impl rule__Adapter__Group__8 )
            // InternalAdaptersLang.g:795:2: rule__Adapter__Group__7__Impl rule__Adapter__Group__8
            {
            pushFollow(FOLLOW_16);
            rule__Adapter__Group__7__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__7"



    // $ANTLR start "rule__Adapter__Group__7__Impl"
    // InternalAdaptersLang.g:802:1: rule__Adapter__Group__7__Impl : ( ( rule__Adapter__RulesAssignment_7 ) ) ;
    public final void rule__Adapter__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:806:2: ( ( ( rule__Adapter__RulesAssignment_7 ) ) )
            // InternalAdaptersLang.g:807:2: ( ( rule__Adapter__RulesAssignment_7 ) )
            {
            // InternalAdaptersLang.g:807:2: ( ( rule__Adapter__RulesAssignment_7 ) )
            // InternalAdaptersLang.g:808:2: ( rule__Adapter__RulesAssignment_7 )
            {
             before(grammarAccess.getAdapterAccess().getRulesAssignment_7()); 

            // InternalAdaptersLang.g:809:2: ( rule__Adapter__RulesAssignment_7 )
            // InternalAdaptersLang.g:809:3: rule__Adapter__RulesAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Adapter__RulesAssignment_7();

            state._fsp--;


            }


             after(grammarAccess.getAdapterAccess().getRulesAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__7__Impl"



    // $ANTLR start "rule__Adapter__Group__8"
    // InternalAdaptersLang.g:817:1: rule__Adapter__Group__8 : rule__Adapter__Group__8__Impl rule__Adapter__Group__9 ;
    public final void rule__Adapter__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:821:2: ( rule__Adapter__Group__8__Impl rule__Adapter__Group__9 )
            // InternalAdaptersLang.g:822:2: rule__Adapter__Group__8__Impl rule__Adapter__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__Adapter__Group__8__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__8"



    // $ANTLR start "rule__Adapter__Group__8__Impl"
    // InternalAdaptersLang.g:829:1: rule__Adapter__Group__8__Impl : ( ( rule__Adapter__Group_8__0 )* ) ;
    public final void rule__Adapter__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:833:2: ( ( ( rule__Adapter__Group_8__0 )* ) )
            // InternalAdaptersLang.g:834:2: ( ( rule__Adapter__Group_8__0 )* )
            {
            // InternalAdaptersLang.g:834:2: ( ( rule__Adapter__Group_8__0 )* )
            // InternalAdaptersLang.g:835:2: ( rule__Adapter__Group_8__0 )*
            {
             before(grammarAccess.getAdapterAccess().getGroup_8()); 

            // InternalAdaptersLang.g:836:2: ( rule__Adapter__Group_8__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalAdaptersLang.g:836:3: rule__Adapter__Group_8__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Adapter__Group_8__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


             after(grammarAccess.getAdapterAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__8__Impl"



    // $ANTLR start "rule__Adapter__Group__9"
    // InternalAdaptersLang.g:844:1: rule__Adapter__Group__9 : rule__Adapter__Group__9__Impl rule__Adapter__Group__10 ;
    public final void rule__Adapter__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:848:2: ( rule__Adapter__Group__9__Impl rule__Adapter__Group__10 )
            // InternalAdaptersLang.g:849:2: rule__Adapter__Group__9__Impl rule__Adapter__Group__10
            {
            pushFollow(FOLLOW_17);
            rule__Adapter__Group__9__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__9"



    // $ANTLR start "rule__Adapter__Group__9__Impl"
    // InternalAdaptersLang.g:856:1: rule__Adapter__Group__9__Impl : ( '}' ) ;
    public final void rule__Adapter__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:860:2: ( ( '}' ) )
            // InternalAdaptersLang.g:861:2: ( '}' )
            {
            // InternalAdaptersLang.g:861:2: ( '}' )
            // InternalAdaptersLang.g:862:2: '}'
            {
             before(grammarAccess.getAdapterAccess().getRightCurlyBracketKeyword_9()); 

            match(input,27,FOLLOW_2); 

             after(grammarAccess.getAdapterAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__9__Impl"



    // $ANTLR start "rule__Adapter__Group__10"
    // InternalAdaptersLang.g:871:1: rule__Adapter__Group__10 : rule__Adapter__Group__10__Impl ;
    public final void rule__Adapter__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:875:2: ( rule__Adapter__Group__10__Impl )
            // InternalAdaptersLang.g:876:2: rule__Adapter__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Adapter__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__10"



    // $ANTLR start "rule__Adapter__Group__10__Impl"
    // InternalAdaptersLang.g:882:1: rule__Adapter__Group__10__Impl : ( ')' ) ;
    public final void rule__Adapter__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:886:2: ( ( ')' ) )
            // InternalAdaptersLang.g:887:2: ( ')' )
            {
            // InternalAdaptersLang.g:887:2: ( ')' )
            // InternalAdaptersLang.g:888:2: ')'
            {
             before(grammarAccess.getAdapterAccess().getRightParenthesisKeyword_10()); 

            match(input,12,FOLLOW_2); 

             after(grammarAccess.getAdapterAccess().getRightParenthesisKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group__10__Impl"



    // $ANTLR start "rule__Adapter__Group_8__0"
    // InternalAdaptersLang.g:898:1: rule__Adapter__Group_8__0 : rule__Adapter__Group_8__0__Impl rule__Adapter__Group_8__1 ;
    public final void rule__Adapter__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:902:2: ( rule__Adapter__Group_8__0__Impl rule__Adapter__Group_8__1 )
            // InternalAdaptersLang.g:903:2: rule__Adapter__Group_8__0__Impl rule__Adapter__Group_8__1
            {
            pushFollow(FOLLOW_3);
            rule__Adapter__Group_8__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__Adapter__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group_8__0"



    // $ANTLR start "rule__Adapter__Group_8__0__Impl"
    // InternalAdaptersLang.g:910:1: rule__Adapter__Group_8__0__Impl : ( ',' ) ;
    public final void rule__Adapter__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:914:2: ( ( ',' ) )
            // InternalAdaptersLang.g:915:2: ( ',' )
            {
            // InternalAdaptersLang.g:915:2: ( ',' )
            // InternalAdaptersLang.g:916:2: ','
            {
             before(grammarAccess.getAdapterAccess().getCommaKeyword_8_0()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getAdapterAccess().getCommaKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group_8__0__Impl"



    // $ANTLR start "rule__Adapter__Group_8__1"
    // InternalAdaptersLang.g:925:1: rule__Adapter__Group_8__1 : rule__Adapter__Group_8__1__Impl ;
    public final void rule__Adapter__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:929:2: ( rule__Adapter__Group_8__1__Impl )
            // InternalAdaptersLang.g:930:2: rule__Adapter__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Adapter__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group_8__1"



    // $ANTLR start "rule__Adapter__Group_8__1__Impl"
    // InternalAdaptersLang.g:936:1: rule__Adapter__Group_8__1__Impl : ( ( rule__Adapter__RulesAssignment_8_1 ) ) ;
    public final void rule__Adapter__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:940:2: ( ( ( rule__Adapter__RulesAssignment_8_1 ) ) )
            // InternalAdaptersLang.g:941:2: ( ( rule__Adapter__RulesAssignment_8_1 ) )
            {
            // InternalAdaptersLang.g:941:2: ( ( rule__Adapter__RulesAssignment_8_1 ) )
            // InternalAdaptersLang.g:942:2: ( rule__Adapter__RulesAssignment_8_1 )
            {
             before(grammarAccess.getAdapterAccess().getRulesAssignment_8_1()); 

            // InternalAdaptersLang.g:943:2: ( rule__Adapter__RulesAssignment_8_1 )
            // InternalAdaptersLang.g:943:3: rule__Adapter__RulesAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Adapter__RulesAssignment_8_1();

            state._fsp--;


            }


             after(grammarAccess.getAdapterAccess().getRulesAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__Group_8__1__Impl"



    // $ANTLR start "rule__ConfigDiff__Group__0"
    // InternalAdaptersLang.g:952:1: rule__ConfigDiff__Group__0 : rule__ConfigDiff__Group__0__Impl rule__ConfigDiff__Group__1 ;
    public final void rule__ConfigDiff__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:956:2: ( rule__ConfigDiff__Group__0__Impl rule__ConfigDiff__Group__1 )
            // InternalAdaptersLang.g:957:2: rule__ConfigDiff__Group__0__Impl rule__ConfigDiff__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__ConfigDiff__Group__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__0"



    // $ANTLR start "rule__ConfigDiff__Group__0__Impl"
    // InternalAdaptersLang.g:964:1: rule__ConfigDiff__Group__0__Impl : ( 'delta' ) ;
    public final void rule__ConfigDiff__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:968:2: ( ( 'delta' ) )
            // InternalAdaptersLang.g:969:2: ( 'delta' )
            {
            // InternalAdaptersLang.g:969:2: ( 'delta' )
            // InternalAdaptersLang.g:970:2: 'delta'
            {
             before(grammarAccess.getConfigDiffAccess().getDeltaKeyword_0()); 

            match(input,21,FOLLOW_2); 

             after(grammarAccess.getConfigDiffAccess().getDeltaKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__0__Impl"



    // $ANTLR start "rule__ConfigDiff__Group__1"
    // InternalAdaptersLang.g:979:1: rule__ConfigDiff__Group__1 : rule__ConfigDiff__Group__1__Impl rule__ConfigDiff__Group__2 ;
    public final void rule__ConfigDiff__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:983:2: ( rule__ConfigDiff__Group__1__Impl rule__ConfigDiff__Group__2 )
            // InternalAdaptersLang.g:984:2: rule__ConfigDiff__Group__1__Impl rule__ConfigDiff__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__ConfigDiff__Group__1__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__1"



    // $ANTLR start "rule__ConfigDiff__Group__1__Impl"
    // InternalAdaptersLang.g:991:1: rule__ConfigDiff__Group__1__Impl : ( '(' ) ;
    public final void rule__ConfigDiff__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:995:2: ( ( '(' ) )
            // InternalAdaptersLang.g:996:2: ( '(' )
            {
            // InternalAdaptersLang.g:996:2: ( '(' )
            // InternalAdaptersLang.g:997:2: '('
            {
             before(grammarAccess.getConfigDiffAccess().getLeftParenthesisKeyword_1()); 

            match(input,11,FOLLOW_2); 

             after(grammarAccess.getConfigDiffAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__1__Impl"



    // $ANTLR start "rule__ConfigDiff__Group__2"
    // InternalAdaptersLang.g:1006:1: rule__ConfigDiff__Group__2 : rule__ConfigDiff__Group__2__Impl rule__ConfigDiff__Group__3 ;
    public final void rule__ConfigDiff__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1010:2: ( rule__ConfigDiff__Group__2__Impl rule__ConfigDiff__Group__3 )
            // InternalAdaptersLang.g:1011:2: rule__ConfigDiff__Group__2__Impl rule__ConfigDiff__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__ConfigDiff__Group__2__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__2"



    // $ANTLR start "rule__ConfigDiff__Group__2__Impl"
    // InternalAdaptersLang.g:1018:1: rule__ConfigDiff__Group__2__Impl : ( ( rule__ConfigDiff__DeltaAssignment_2 ) ) ;
    public final void rule__ConfigDiff__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1022:2: ( ( ( rule__ConfigDiff__DeltaAssignment_2 ) ) )
            // InternalAdaptersLang.g:1023:2: ( ( rule__ConfigDiff__DeltaAssignment_2 ) )
            {
            // InternalAdaptersLang.g:1023:2: ( ( rule__ConfigDiff__DeltaAssignment_2 ) )
            // InternalAdaptersLang.g:1024:2: ( rule__ConfigDiff__DeltaAssignment_2 )
            {
             before(grammarAccess.getConfigDiffAccess().getDeltaAssignment_2()); 

            // InternalAdaptersLang.g:1025:2: ( rule__ConfigDiff__DeltaAssignment_2 )
            // InternalAdaptersLang.g:1025:3: rule__ConfigDiff__DeltaAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDiff__DeltaAssignment_2();

            state._fsp--;


            }


             after(grammarAccess.getConfigDiffAccess().getDeltaAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__2__Impl"



    // $ANTLR start "rule__ConfigDiff__Group__3"
    // InternalAdaptersLang.g:1033:1: rule__ConfigDiff__Group__3 : rule__ConfigDiff__Group__3__Impl rule__ConfigDiff__Group__4 ;
    public final void rule__ConfigDiff__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1037:2: ( rule__ConfigDiff__Group__3__Impl rule__ConfigDiff__Group__4 )
            // InternalAdaptersLang.g:1038:2: rule__ConfigDiff__Group__3__Impl rule__ConfigDiff__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__ConfigDiff__Group__3__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__3"



    // $ANTLR start "rule__ConfigDiff__Group__3__Impl"
    // InternalAdaptersLang.g:1045:1: rule__ConfigDiff__Group__3__Impl : ( ')' ) ;
    public final void rule__ConfigDiff__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1049:2: ( ( ')' ) )
            // InternalAdaptersLang.g:1050:2: ( ')' )
            {
            // InternalAdaptersLang.g:1050:2: ( ')' )
            // InternalAdaptersLang.g:1051:2: ')'
            {
             before(grammarAccess.getConfigDiffAccess().getRightParenthesisKeyword_3()); 

            match(input,12,FOLLOW_2); 

             after(grammarAccess.getConfigDiffAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__3__Impl"



    // $ANTLR start "rule__ConfigDiff__Group__4"
    // InternalAdaptersLang.g:1060:1: rule__ConfigDiff__Group__4 : rule__ConfigDiff__Group__4__Impl rule__ConfigDiff__Group__5 ;
    public final void rule__ConfigDiff__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1064:2: ( rule__ConfigDiff__Group__4__Impl rule__ConfigDiff__Group__5 )
            // InternalAdaptersLang.g:1065:2: rule__ConfigDiff__Group__4__Impl rule__ConfigDiff__Group__5
            {
            pushFollow(FOLLOW_19);
            rule__ConfigDiff__Group__4__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__4"



    // $ANTLR start "rule__ConfigDiff__Group__4__Impl"
    // InternalAdaptersLang.g:1072:1: rule__ConfigDiff__Group__4__Impl : ( ',' ) ;
    public final void rule__ConfigDiff__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1076:2: ( ( ',' ) )
            // InternalAdaptersLang.g:1077:2: ( ',' )
            {
            // InternalAdaptersLang.g:1077:2: ( ',' )
            // InternalAdaptersLang.g:1078:2: ','
            {
             before(grammarAccess.getConfigDiffAccess().getCommaKeyword_4()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getConfigDiffAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__4__Impl"



    // $ANTLR start "rule__ConfigDiff__Group__5"
    // InternalAdaptersLang.g:1087:1: rule__ConfigDiff__Group__5 : rule__ConfigDiff__Group__5__Impl rule__ConfigDiff__Group__6 ;
    public final void rule__ConfigDiff__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1091:2: ( rule__ConfigDiff__Group__5__Impl rule__ConfigDiff__Group__6 )
            // InternalAdaptersLang.g:1092:2: rule__ConfigDiff__Group__5__Impl rule__ConfigDiff__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__ConfigDiff__Group__5__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__5"



    // $ANTLR start "rule__ConfigDiff__Group__5__Impl"
    // InternalAdaptersLang.g:1099:1: rule__ConfigDiff__Group__5__Impl : ( 'context' ) ;
    public final void rule__ConfigDiff__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1103:2: ( ( 'context' ) )
            // InternalAdaptersLang.g:1104:2: ( 'context' )
            {
            // InternalAdaptersLang.g:1104:2: ( 'context' )
            // InternalAdaptersLang.g:1105:2: 'context'
            {
             before(grammarAccess.getConfigDiffAccess().getContextKeyword_5()); 

            match(input,20,FOLLOW_2); 

             after(grammarAccess.getConfigDiffAccess().getContextKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__5__Impl"



    // $ANTLR start "rule__ConfigDiff__Group__6"
    // InternalAdaptersLang.g:1114:1: rule__ConfigDiff__Group__6 : rule__ConfigDiff__Group__6__Impl rule__ConfigDiff__Group__7 ;
    public final void rule__ConfigDiff__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1118:2: ( rule__ConfigDiff__Group__6__Impl rule__ConfigDiff__Group__7 )
            // InternalAdaptersLang.g:1119:2: rule__ConfigDiff__Group__6__Impl rule__ConfigDiff__Group__7
            {
            pushFollow(FOLLOW_20);
            rule__ConfigDiff__Group__6__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__6"



    // $ANTLR start "rule__ConfigDiff__Group__6__Impl"
    // InternalAdaptersLang.g:1126:1: rule__ConfigDiff__Group__6__Impl : ( '(' ) ;
    public final void rule__ConfigDiff__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1130:2: ( ( '(' ) )
            // InternalAdaptersLang.g:1131:2: ( '(' )
            {
            // InternalAdaptersLang.g:1131:2: ( '(' )
            // InternalAdaptersLang.g:1132:2: '('
            {
             before(grammarAccess.getConfigDiffAccess().getLeftParenthesisKeyword_6()); 

            match(input,11,FOLLOW_2); 

             after(grammarAccess.getConfigDiffAccess().getLeftParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__6__Impl"



    // $ANTLR start "rule__ConfigDiff__Group__7"
    // InternalAdaptersLang.g:1141:1: rule__ConfigDiff__Group__7 : rule__ConfigDiff__Group__7__Impl rule__ConfigDiff__Group__8 ;
    public final void rule__ConfigDiff__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1145:2: ( rule__ConfigDiff__Group__7__Impl rule__ConfigDiff__Group__8 )
            // InternalAdaptersLang.g:1146:2: rule__ConfigDiff__Group__7__Impl rule__ConfigDiff__Group__8
            {
            pushFollow(FOLLOW_17);
            rule__ConfigDiff__Group__7__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__7"



    // $ANTLR start "rule__ConfigDiff__Group__7__Impl"
    // InternalAdaptersLang.g:1153:1: rule__ConfigDiff__Group__7__Impl : ( ( rule__ConfigDiff__ContextAssignment_7 ) ) ;
    public final void rule__ConfigDiff__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1157:2: ( ( ( rule__ConfigDiff__ContextAssignment_7 ) ) )
            // InternalAdaptersLang.g:1158:2: ( ( rule__ConfigDiff__ContextAssignment_7 ) )
            {
            // InternalAdaptersLang.g:1158:2: ( ( rule__ConfigDiff__ContextAssignment_7 ) )
            // InternalAdaptersLang.g:1159:2: ( rule__ConfigDiff__ContextAssignment_7 )
            {
             before(grammarAccess.getConfigDiffAccess().getContextAssignment_7()); 

            // InternalAdaptersLang.g:1160:2: ( rule__ConfigDiff__ContextAssignment_7 )
            // InternalAdaptersLang.g:1160:3: rule__ConfigDiff__ContextAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDiff__ContextAssignment_7();

            state._fsp--;


            }


             after(grammarAccess.getConfigDiffAccess().getContextAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__7__Impl"



    // $ANTLR start "rule__ConfigDiff__Group__8"
    // InternalAdaptersLang.g:1168:1: rule__ConfigDiff__Group__8 : rule__ConfigDiff__Group__8__Impl ;
    public final void rule__ConfigDiff__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1172:2: ( rule__ConfigDiff__Group__8__Impl )
            // InternalAdaptersLang.g:1173:2: rule__ConfigDiff__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDiff__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__8"



    // $ANTLR start "rule__ConfigDiff__Group__8__Impl"
    // InternalAdaptersLang.g:1179:1: rule__ConfigDiff__Group__8__Impl : ( ')' ) ;
    public final void rule__ConfigDiff__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1183:2: ( ( ')' ) )
            // InternalAdaptersLang.g:1184:2: ( ')' )
            {
            // InternalAdaptersLang.g:1184:2: ( ')' )
            // InternalAdaptersLang.g:1185:2: ')'
            {
             before(grammarAccess.getConfigDiffAccess().getRightParenthesisKeyword_8()); 

            match(input,12,FOLLOW_2); 

             after(grammarAccess.getConfigDiffAccess().getRightParenthesisKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__Group__8__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__0"
    // InternalAdaptersLang.g:1195:1: rule__ConfigDelta__Group__0 : rule__ConfigDelta__Group__0__Impl rule__ConfigDelta__Group__1 ;
    public final void rule__ConfigDelta__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1199:2: ( rule__ConfigDelta__Group__0__Impl rule__ConfigDelta__Group__1 )
            // InternalAdaptersLang.g:1200:2: rule__ConfigDelta__Group__0__Impl rule__ConfigDelta__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__ConfigDelta__Group__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__0"



    // $ANTLR start "rule__ConfigDelta__Group__0__Impl"
    // InternalAdaptersLang.g:1207:1: rule__ConfigDelta__Group__0__Impl : ( () ) ;
    public final void rule__ConfigDelta__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1211:2: ( ( () ) )
            // InternalAdaptersLang.g:1212:2: ( () )
            {
            // InternalAdaptersLang.g:1212:2: ( () )
            // InternalAdaptersLang.g:1213:2: ()
            {
             before(grammarAccess.getConfigDeltaAccess().getConfigDeltaAction_0()); 

            // InternalAdaptersLang.g:1214:2: ()
            // InternalAdaptersLang.g:1214:3: 
            {
            }


             after(grammarAccess.getConfigDeltaAccess().getConfigDeltaAction_0()); 

            }


            }

        }
        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__0__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__1"
    // InternalAdaptersLang.g:1222:1: rule__ConfigDelta__Group__1 : rule__ConfigDelta__Group__1__Impl rule__ConfigDelta__Group__2 ;
    public final void rule__ConfigDelta__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1226:2: ( rule__ConfigDelta__Group__1__Impl rule__ConfigDelta__Group__2 )
            // InternalAdaptersLang.g:1227:2: rule__ConfigDelta__Group__1__Impl rule__ConfigDelta__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__ConfigDelta__Group__1__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__1"



    // $ANTLR start "rule__ConfigDelta__Group__1__Impl"
    // InternalAdaptersLang.g:1234:1: rule__ConfigDelta__Group__1__Impl : ( '+-' ) ;
    public final void rule__ConfigDelta__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1238:2: ( ( '+-' ) )
            // InternalAdaptersLang.g:1239:2: ( '+-' )
            {
            // InternalAdaptersLang.g:1239:2: ( '+-' )
            // InternalAdaptersLang.g:1240:2: '+-'
            {
             before(grammarAccess.getConfigDeltaAccess().getPlusSignHyphenMinusKeyword_1()); 

            match(input,14,FOLLOW_2); 

             after(grammarAccess.getConfigDeltaAccess().getPlusSignHyphenMinusKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__1__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__2"
    // InternalAdaptersLang.g:1249:1: rule__ConfigDelta__Group__2 : rule__ConfigDelta__Group__2__Impl rule__ConfigDelta__Group__3 ;
    public final void rule__ConfigDelta__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1253:2: ( rule__ConfigDelta__Group__2__Impl rule__ConfigDelta__Group__3 )
            // InternalAdaptersLang.g:1254:2: rule__ConfigDelta__Group__2__Impl rule__ConfigDelta__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__ConfigDelta__Group__2__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__2"



    // $ANTLR start "rule__ConfigDelta__Group__2__Impl"
    // InternalAdaptersLang.g:1261:1: rule__ConfigDelta__Group__2__Impl : ( '{' ) ;
    public final void rule__ConfigDelta__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1265:2: ( ( '{' ) )
            // InternalAdaptersLang.g:1266:2: ( '{' )
            {
            // InternalAdaptersLang.g:1266:2: ( '{' )
            // InternalAdaptersLang.g:1267:2: '{'
            {
             before(grammarAccess.getConfigDeltaAccess().getLeftCurlyBracketKeyword_2()); 

            match(input,26,FOLLOW_2); 

             after(grammarAccess.getConfigDeltaAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__2__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__3"
    // InternalAdaptersLang.g:1276:1: rule__ConfigDelta__Group__3 : rule__ConfigDelta__Group__3__Impl rule__ConfigDelta__Group__4 ;
    public final void rule__ConfigDelta__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1280:2: ( rule__ConfigDelta__Group__3__Impl rule__ConfigDelta__Group__4 )
            // InternalAdaptersLang.g:1281:2: rule__ConfigDelta__Group__3__Impl rule__ConfigDelta__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__ConfigDelta__Group__3__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__3"



    // $ANTLR start "rule__ConfigDelta__Group__3__Impl"
    // InternalAdaptersLang.g:1288:1: rule__ConfigDelta__Group__3__Impl : ( ( rule__ConfigDelta__Group_3__0 )? ) ;
    public final void rule__ConfigDelta__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1292:2: ( ( ( rule__ConfigDelta__Group_3__0 )? ) )
            // InternalAdaptersLang.g:1293:2: ( ( rule__ConfigDelta__Group_3__0 )? )
            {
            // InternalAdaptersLang.g:1293:2: ( ( rule__ConfigDelta__Group_3__0 )? )
            // InternalAdaptersLang.g:1294:2: ( rule__ConfigDelta__Group_3__0 )?
            {
             before(grammarAccess.getConfigDeltaAccess().getGroup_3()); 

            // InternalAdaptersLang.g:1295:2: ( rule__ConfigDelta__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID||LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalAdaptersLang.g:1295:3: rule__ConfigDelta__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ConfigDelta__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }


             after(grammarAccess.getConfigDeltaAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__3__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__4"
    // InternalAdaptersLang.g:1303:1: rule__ConfigDelta__Group__4 : rule__ConfigDelta__Group__4__Impl rule__ConfigDelta__Group__5 ;
    public final void rule__ConfigDelta__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1307:2: ( rule__ConfigDelta__Group__4__Impl rule__ConfigDelta__Group__5 )
            // InternalAdaptersLang.g:1308:2: rule__ConfigDelta__Group__4__Impl rule__ConfigDelta__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__ConfigDelta__Group__4__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__4"



    // $ANTLR start "rule__ConfigDelta__Group__4__Impl"
    // InternalAdaptersLang.g:1315:1: rule__ConfigDelta__Group__4__Impl : ( '}' ) ;
    public final void rule__ConfigDelta__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1319:2: ( ( '}' ) )
            // InternalAdaptersLang.g:1320:2: ( '}' )
            {
            // InternalAdaptersLang.g:1320:2: ( '}' )
            // InternalAdaptersLang.g:1321:2: '}'
            {
             before(grammarAccess.getConfigDeltaAccess().getRightCurlyBracketKeyword_4()); 

            match(input,27,FOLLOW_2); 

             after(grammarAccess.getConfigDeltaAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__4__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__5"
    // InternalAdaptersLang.g:1330:1: rule__ConfigDelta__Group__5 : rule__ConfigDelta__Group__5__Impl rule__ConfigDelta__Group__6 ;
    public final void rule__ConfigDelta__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1334:2: ( rule__ConfigDelta__Group__5__Impl rule__ConfigDelta__Group__6 )
            // InternalAdaptersLang.g:1335:2: rule__ConfigDelta__Group__5__Impl rule__ConfigDelta__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__ConfigDelta__Group__5__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__5"



    // $ANTLR start "rule__ConfigDelta__Group__5__Impl"
    // InternalAdaptersLang.g:1342:1: rule__ConfigDelta__Group__5__Impl : ( ',' ) ;
    public final void rule__ConfigDelta__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1346:2: ( ( ',' ) )
            // InternalAdaptersLang.g:1347:2: ( ',' )
            {
            // InternalAdaptersLang.g:1347:2: ( ',' )
            // InternalAdaptersLang.g:1348:2: ','
            {
             before(grammarAccess.getConfigDeltaAccess().getCommaKeyword_5()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getConfigDeltaAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__5__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__6"
    // InternalAdaptersLang.g:1357:1: rule__ConfigDelta__Group__6 : rule__ConfigDelta__Group__6__Impl rule__ConfigDelta__Group__7 ;
    public final void rule__ConfigDelta__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1361:2: ( rule__ConfigDelta__Group__6__Impl rule__ConfigDelta__Group__7 )
            // InternalAdaptersLang.g:1362:2: rule__ConfigDelta__Group__6__Impl rule__ConfigDelta__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__ConfigDelta__Group__6__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__6"



    // $ANTLR start "rule__ConfigDelta__Group__6__Impl"
    // InternalAdaptersLang.g:1369:1: rule__ConfigDelta__Group__6__Impl : ( '-+' ) ;
    public final void rule__ConfigDelta__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1373:2: ( ( '-+' ) )
            // InternalAdaptersLang.g:1374:2: ( '-+' )
            {
            // InternalAdaptersLang.g:1374:2: ( '-+' )
            // InternalAdaptersLang.g:1375:2: '-+'
            {
             before(grammarAccess.getConfigDeltaAccess().getHyphenMinusPlusSignKeyword_6()); 

            match(input,16,FOLLOW_2); 

             after(grammarAccess.getConfigDeltaAccess().getHyphenMinusPlusSignKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__6__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__7"
    // InternalAdaptersLang.g:1384:1: rule__ConfigDelta__Group__7 : rule__ConfigDelta__Group__7__Impl rule__ConfigDelta__Group__8 ;
    public final void rule__ConfigDelta__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1388:2: ( rule__ConfigDelta__Group__7__Impl rule__ConfigDelta__Group__8 )
            // InternalAdaptersLang.g:1389:2: rule__ConfigDelta__Group__7__Impl rule__ConfigDelta__Group__8
            {
            pushFollow(FOLLOW_8);
            rule__ConfigDelta__Group__7__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__7"



    // $ANTLR start "rule__ConfigDelta__Group__7__Impl"
    // InternalAdaptersLang.g:1396:1: rule__ConfigDelta__Group__7__Impl : ( '{' ) ;
    public final void rule__ConfigDelta__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1400:2: ( ( '{' ) )
            // InternalAdaptersLang.g:1401:2: ( '{' )
            {
            // InternalAdaptersLang.g:1401:2: ( '{' )
            // InternalAdaptersLang.g:1402:2: '{'
            {
             before(grammarAccess.getConfigDeltaAccess().getLeftCurlyBracketKeyword_7()); 

            match(input,26,FOLLOW_2); 

             after(grammarAccess.getConfigDeltaAccess().getLeftCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__7__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__8"
    // InternalAdaptersLang.g:1411:1: rule__ConfigDelta__Group__8 : rule__ConfigDelta__Group__8__Impl rule__ConfigDelta__Group__9 ;
    public final void rule__ConfigDelta__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1415:2: ( rule__ConfigDelta__Group__8__Impl rule__ConfigDelta__Group__9 )
            // InternalAdaptersLang.g:1416:2: rule__ConfigDelta__Group__8__Impl rule__ConfigDelta__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__ConfigDelta__Group__8__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__8"



    // $ANTLR start "rule__ConfigDelta__Group__8__Impl"
    // InternalAdaptersLang.g:1423:1: rule__ConfigDelta__Group__8__Impl : ( ( rule__ConfigDelta__Group_8__0 )? ) ;
    public final void rule__ConfigDelta__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1427:2: ( ( ( rule__ConfigDelta__Group_8__0 )? ) )
            // InternalAdaptersLang.g:1428:2: ( ( rule__ConfigDelta__Group_8__0 )? )
            {
            // InternalAdaptersLang.g:1428:2: ( ( rule__ConfigDelta__Group_8__0 )? )
            // InternalAdaptersLang.g:1429:2: ( rule__ConfigDelta__Group_8__0 )?
            {
             before(grammarAccess.getConfigDeltaAccess().getGroup_8()); 

            // InternalAdaptersLang.g:1430:2: ( rule__ConfigDelta__Group_8__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalAdaptersLang.g:1430:3: rule__ConfigDelta__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ConfigDelta__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }


             after(grammarAccess.getConfigDeltaAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__8__Impl"



    // $ANTLR start "rule__ConfigDelta__Group__9"
    // InternalAdaptersLang.g:1438:1: rule__ConfigDelta__Group__9 : rule__ConfigDelta__Group__9__Impl ;
    public final void rule__ConfigDelta__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1442:2: ( rule__ConfigDelta__Group__9__Impl )
            // InternalAdaptersLang.g:1443:2: rule__ConfigDelta__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__9"



    // $ANTLR start "rule__ConfigDelta__Group__9__Impl"
    // InternalAdaptersLang.g:1449:1: rule__ConfigDelta__Group__9__Impl : ( '}' ) ;
    public final void rule__ConfigDelta__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1453:2: ( ( '}' ) )
            // InternalAdaptersLang.g:1454:2: ( '}' )
            {
            // InternalAdaptersLang.g:1454:2: ( '}' )
            // InternalAdaptersLang.g:1455:2: '}'
            {
             before(grammarAccess.getConfigDeltaAccess().getRightCurlyBracketKeyword_9()); 

            match(input,27,FOLLOW_2); 

             after(grammarAccess.getConfigDeltaAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group__9__Impl"



    // $ANTLR start "rule__ConfigDelta__Group_3__0"
    // InternalAdaptersLang.g:1465:1: rule__ConfigDelta__Group_3__0 : rule__ConfigDelta__Group_3__0__Impl rule__ConfigDelta__Group_3__1 ;
    public final void rule__ConfigDelta__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1469:2: ( rule__ConfigDelta__Group_3__0__Impl rule__ConfigDelta__Group_3__1 )
            // InternalAdaptersLang.g:1470:2: rule__ConfigDelta__Group_3__0__Impl rule__ConfigDelta__Group_3__1
            {
            pushFollow(FOLLOW_10);
            rule__ConfigDelta__Group_3__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_3__0"



    // $ANTLR start "rule__ConfigDelta__Group_3__0__Impl"
    // InternalAdaptersLang.g:1477:1: rule__ConfigDelta__Group_3__0__Impl : ( ( rule__ConfigDelta__PosSetAssignment_3_0 ) ) ;
    public final void rule__ConfigDelta__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1481:2: ( ( ( rule__ConfigDelta__PosSetAssignment_3_0 ) ) )
            // InternalAdaptersLang.g:1482:2: ( ( rule__ConfigDelta__PosSetAssignment_3_0 ) )
            {
            // InternalAdaptersLang.g:1482:2: ( ( rule__ConfigDelta__PosSetAssignment_3_0 ) )
            // InternalAdaptersLang.g:1483:2: ( rule__ConfigDelta__PosSetAssignment_3_0 )
            {
             before(grammarAccess.getConfigDeltaAccess().getPosSetAssignment_3_0()); 

            // InternalAdaptersLang.g:1484:2: ( rule__ConfigDelta__PosSetAssignment_3_0 )
            // InternalAdaptersLang.g:1484:3: rule__ConfigDelta__PosSetAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__PosSetAssignment_3_0();

            state._fsp--;


            }


             after(grammarAccess.getConfigDeltaAccess().getPosSetAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_3__0__Impl"



    // $ANTLR start "rule__ConfigDelta__Group_3__1"
    // InternalAdaptersLang.g:1492:1: rule__ConfigDelta__Group_3__1 : rule__ConfigDelta__Group_3__1__Impl ;
    public final void rule__ConfigDelta__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1496:2: ( rule__ConfigDelta__Group_3__1__Impl )
            // InternalAdaptersLang.g:1497:2: rule__ConfigDelta__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_3__1"



    // $ANTLR start "rule__ConfigDelta__Group_3__1__Impl"
    // InternalAdaptersLang.g:1503:1: rule__ConfigDelta__Group_3__1__Impl : ( ( rule__ConfigDelta__Group_3_1__0 )* ) ;
    public final void rule__ConfigDelta__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1507:2: ( ( ( rule__ConfigDelta__Group_3_1__0 )* ) )
            // InternalAdaptersLang.g:1508:2: ( ( rule__ConfigDelta__Group_3_1__0 )* )
            {
            // InternalAdaptersLang.g:1508:2: ( ( rule__ConfigDelta__Group_3_1__0 )* )
            // InternalAdaptersLang.g:1509:2: ( rule__ConfigDelta__Group_3_1__0 )*
            {
             before(grammarAccess.getConfigDeltaAccess().getGroup_3_1()); 

            // InternalAdaptersLang.g:1510:2: ( rule__ConfigDelta__Group_3_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==15) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalAdaptersLang.g:1510:3: rule__ConfigDelta__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ConfigDelta__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


             after(grammarAccess.getConfigDeltaAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_3__1__Impl"



    // $ANTLR start "rule__ConfigDelta__Group_3_1__0"
    // InternalAdaptersLang.g:1519:1: rule__ConfigDelta__Group_3_1__0 : rule__ConfigDelta__Group_3_1__0__Impl rule__ConfigDelta__Group_3_1__1 ;
    public final void rule__ConfigDelta__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1523:2: ( rule__ConfigDelta__Group_3_1__0__Impl rule__ConfigDelta__Group_3_1__1 )
            // InternalAdaptersLang.g:1524:2: rule__ConfigDelta__Group_3_1__0__Impl rule__ConfigDelta__Group_3_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ConfigDelta__Group_3_1__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_3_1__0"



    // $ANTLR start "rule__ConfigDelta__Group_3_1__0__Impl"
    // InternalAdaptersLang.g:1531:1: rule__ConfigDelta__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__ConfigDelta__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1535:2: ( ( ',' ) )
            // InternalAdaptersLang.g:1536:2: ( ',' )
            {
            // InternalAdaptersLang.g:1536:2: ( ',' )
            // InternalAdaptersLang.g:1537:2: ','
            {
             before(grammarAccess.getConfigDeltaAccess().getCommaKeyword_3_1_0()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getConfigDeltaAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_3_1__0__Impl"



    // $ANTLR start "rule__ConfigDelta__Group_3_1__1"
    // InternalAdaptersLang.g:1546:1: rule__ConfigDelta__Group_3_1__1 : rule__ConfigDelta__Group_3_1__1__Impl ;
    public final void rule__ConfigDelta__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1550:2: ( rule__ConfigDelta__Group_3_1__1__Impl )
            // InternalAdaptersLang.g:1551:2: rule__ConfigDelta__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_3_1__1"



    // $ANTLR start "rule__ConfigDelta__Group_3_1__1__Impl"
    // InternalAdaptersLang.g:1557:1: rule__ConfigDelta__Group_3_1__1__Impl : ( ( rule__ConfigDelta__PosSetAssignment_3_1_1 ) ) ;
    public final void rule__ConfigDelta__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1561:2: ( ( ( rule__ConfigDelta__PosSetAssignment_3_1_1 ) ) )
            // InternalAdaptersLang.g:1562:2: ( ( rule__ConfigDelta__PosSetAssignment_3_1_1 ) )
            {
            // InternalAdaptersLang.g:1562:2: ( ( rule__ConfigDelta__PosSetAssignment_3_1_1 ) )
            // InternalAdaptersLang.g:1563:2: ( rule__ConfigDelta__PosSetAssignment_3_1_1 )
            {
             before(grammarAccess.getConfigDeltaAccess().getPosSetAssignment_3_1_1()); 

            // InternalAdaptersLang.g:1564:2: ( rule__ConfigDelta__PosSetAssignment_3_1_1 )
            // InternalAdaptersLang.g:1564:3: rule__ConfigDelta__PosSetAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__PosSetAssignment_3_1_1();

            state._fsp--;


            }


             after(grammarAccess.getConfigDeltaAccess().getPosSetAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_3_1__1__Impl"



    // $ANTLR start "rule__ConfigDelta__Group_8__0"
    // InternalAdaptersLang.g:1573:1: rule__ConfigDelta__Group_8__0 : rule__ConfigDelta__Group_8__0__Impl rule__ConfigDelta__Group_8__1 ;
    public final void rule__ConfigDelta__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1577:2: ( rule__ConfigDelta__Group_8__0__Impl rule__ConfigDelta__Group_8__1 )
            // InternalAdaptersLang.g:1578:2: rule__ConfigDelta__Group_8__0__Impl rule__ConfigDelta__Group_8__1
            {
            pushFollow(FOLLOW_10);
            rule__ConfigDelta__Group_8__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_8__0"



    // $ANTLR start "rule__ConfigDelta__Group_8__0__Impl"
    // InternalAdaptersLang.g:1585:1: rule__ConfigDelta__Group_8__0__Impl : ( ( rule__ConfigDelta__NegSetAssignment_8_0 ) ) ;
    public final void rule__ConfigDelta__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1589:2: ( ( ( rule__ConfigDelta__NegSetAssignment_8_0 ) ) )
            // InternalAdaptersLang.g:1590:2: ( ( rule__ConfigDelta__NegSetAssignment_8_0 ) )
            {
            // InternalAdaptersLang.g:1590:2: ( ( rule__ConfigDelta__NegSetAssignment_8_0 ) )
            // InternalAdaptersLang.g:1591:2: ( rule__ConfigDelta__NegSetAssignment_8_0 )
            {
             before(grammarAccess.getConfigDeltaAccess().getNegSetAssignment_8_0()); 

            // InternalAdaptersLang.g:1592:2: ( rule__ConfigDelta__NegSetAssignment_8_0 )
            // InternalAdaptersLang.g:1592:3: rule__ConfigDelta__NegSetAssignment_8_0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__NegSetAssignment_8_0();

            state._fsp--;


            }


             after(grammarAccess.getConfigDeltaAccess().getNegSetAssignment_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_8__0__Impl"



    // $ANTLR start "rule__ConfigDelta__Group_8__1"
    // InternalAdaptersLang.g:1600:1: rule__ConfigDelta__Group_8__1 : rule__ConfigDelta__Group_8__1__Impl ;
    public final void rule__ConfigDelta__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1604:2: ( rule__ConfigDelta__Group_8__1__Impl )
            // InternalAdaptersLang.g:1605:2: rule__ConfigDelta__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_8__1"



    // $ANTLR start "rule__ConfigDelta__Group_8__1__Impl"
    // InternalAdaptersLang.g:1611:1: rule__ConfigDelta__Group_8__1__Impl : ( ( rule__ConfigDelta__Group_8_1__0 )* ) ;
    public final void rule__ConfigDelta__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1615:2: ( ( ( rule__ConfigDelta__Group_8_1__0 )* ) )
            // InternalAdaptersLang.g:1616:2: ( ( rule__ConfigDelta__Group_8_1__0 )* )
            {
            // InternalAdaptersLang.g:1616:2: ( ( rule__ConfigDelta__Group_8_1__0 )* )
            // InternalAdaptersLang.g:1617:2: ( rule__ConfigDelta__Group_8_1__0 )*
            {
             before(grammarAccess.getConfigDeltaAccess().getGroup_8_1()); 

            // InternalAdaptersLang.g:1618:2: ( rule__ConfigDelta__Group_8_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalAdaptersLang.g:1618:3: rule__ConfigDelta__Group_8_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ConfigDelta__Group_8_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


             after(grammarAccess.getConfigDeltaAccess().getGroup_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_8__1__Impl"



    // $ANTLR start "rule__ConfigDelta__Group_8_1__0"
    // InternalAdaptersLang.g:1627:1: rule__ConfigDelta__Group_8_1__0 : rule__ConfigDelta__Group_8_1__0__Impl rule__ConfigDelta__Group_8_1__1 ;
    public final void rule__ConfigDelta__Group_8_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1631:2: ( rule__ConfigDelta__Group_8_1__0__Impl rule__ConfigDelta__Group_8_1__1 )
            // InternalAdaptersLang.g:1632:2: rule__ConfigDelta__Group_8_1__0__Impl rule__ConfigDelta__Group_8_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ConfigDelta__Group_8_1__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group_8_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_8_1__0"



    // $ANTLR start "rule__ConfigDelta__Group_8_1__0__Impl"
    // InternalAdaptersLang.g:1639:1: rule__ConfigDelta__Group_8_1__0__Impl : ( ',' ) ;
    public final void rule__ConfigDelta__Group_8_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1643:2: ( ( ',' ) )
            // InternalAdaptersLang.g:1644:2: ( ',' )
            {
            // InternalAdaptersLang.g:1644:2: ( ',' )
            // InternalAdaptersLang.g:1645:2: ','
            {
             before(grammarAccess.getConfigDeltaAccess().getCommaKeyword_8_1_0()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getConfigDeltaAccess().getCommaKeyword_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_8_1__0__Impl"



    // $ANTLR start "rule__ConfigDelta__Group_8_1__1"
    // InternalAdaptersLang.g:1654:1: rule__ConfigDelta__Group_8_1__1 : rule__ConfigDelta__Group_8_1__1__Impl ;
    public final void rule__ConfigDelta__Group_8_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1658:2: ( rule__ConfigDelta__Group_8_1__1__Impl )
            // InternalAdaptersLang.g:1659:2: rule__ConfigDelta__Group_8_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__Group_8_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_8_1__1"



    // $ANTLR start "rule__ConfigDelta__Group_8_1__1__Impl"
    // InternalAdaptersLang.g:1665:1: rule__ConfigDelta__Group_8_1__1__Impl : ( ( rule__ConfigDelta__NegSetAssignment_8_1_1 ) ) ;
    public final void rule__ConfigDelta__Group_8_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1669:2: ( ( ( rule__ConfigDelta__NegSetAssignment_8_1_1 ) ) )
            // InternalAdaptersLang.g:1670:2: ( ( rule__ConfigDelta__NegSetAssignment_8_1_1 ) )
            {
            // InternalAdaptersLang.g:1670:2: ( ( rule__ConfigDelta__NegSetAssignment_8_1_1 ) )
            // InternalAdaptersLang.g:1671:2: ( rule__ConfigDelta__NegSetAssignment_8_1_1 )
            {
             before(grammarAccess.getConfigDeltaAccess().getNegSetAssignment_8_1_1()); 

            // InternalAdaptersLang.g:1672:2: ( rule__ConfigDelta__NegSetAssignment_8_1_1 )
            // InternalAdaptersLang.g:1672:3: rule__ConfigDelta__NegSetAssignment_8_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ConfigDelta__NegSetAssignment_8_1_1();

            state._fsp--;


            }


             after(grammarAccess.getConfigDeltaAccess().getNegSetAssignment_8_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__Group_8_1__1__Impl"



    // $ANTLR start "rule__ConfigContext__Group__0"
    // InternalAdaptersLang.g:1681:1: rule__ConfigContext__Group__0 : rule__ConfigContext__Group__0__Impl rule__ConfigContext__Group__1 ;
    public final void rule__ConfigContext__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1685:2: ( rule__ConfigContext__Group__0__Impl rule__ConfigContext__Group__1 )
            // InternalAdaptersLang.g:1686:2: rule__ConfigContext__Group__0__Impl rule__ConfigContext__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__ConfigContext__Group__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__0"



    // $ANTLR start "rule__ConfigContext__Group__0__Impl"
    // InternalAdaptersLang.g:1693:1: rule__ConfigContext__Group__0__Impl : ( () ) ;
    public final void rule__ConfigContext__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1697:2: ( ( () ) )
            // InternalAdaptersLang.g:1698:2: ( () )
            {
            // InternalAdaptersLang.g:1698:2: ( () )
            // InternalAdaptersLang.g:1699:2: ()
            {
             before(grammarAccess.getConfigContextAccess().getConfigContextAction_0()); 

            // InternalAdaptersLang.g:1700:2: ()
            // InternalAdaptersLang.g:1700:3: 
            {
            }


             after(grammarAccess.getConfigContextAccess().getConfigContextAction_0()); 

            }


            }

        }
        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__0__Impl"



    // $ANTLR start "rule__ConfigContext__Group__1"
    // InternalAdaptersLang.g:1708:1: rule__ConfigContext__Group__1 : rule__ConfigContext__Group__1__Impl rule__ConfigContext__Group__2 ;
    public final void rule__ConfigContext__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1712:2: ( rule__ConfigContext__Group__1__Impl rule__ConfigContext__Group__2 )
            // InternalAdaptersLang.g:1713:2: rule__ConfigContext__Group__1__Impl rule__ConfigContext__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__ConfigContext__Group__1__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__1"



    // $ANTLR start "rule__ConfigContext__Group__1__Impl"
    // InternalAdaptersLang.g:1720:1: rule__ConfigContext__Group__1__Impl : ( '++' ) ;
    public final void rule__ConfigContext__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1724:2: ( ( '++' ) )
            // InternalAdaptersLang.g:1725:2: ( '++' )
            {
            // InternalAdaptersLang.g:1725:2: ( '++' )
            // InternalAdaptersLang.g:1726:2: '++'
            {
             before(grammarAccess.getConfigContextAccess().getPlusSignPlusSignKeyword_1()); 

            match(input,13,FOLLOW_2); 

             after(grammarAccess.getConfigContextAccess().getPlusSignPlusSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__1__Impl"



    // $ANTLR start "rule__ConfigContext__Group__2"
    // InternalAdaptersLang.g:1735:1: rule__ConfigContext__Group__2 : rule__ConfigContext__Group__2__Impl rule__ConfigContext__Group__3 ;
    public final void rule__ConfigContext__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1739:2: ( rule__ConfigContext__Group__2__Impl rule__ConfigContext__Group__3 )
            // InternalAdaptersLang.g:1740:2: rule__ConfigContext__Group__2__Impl rule__ConfigContext__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__ConfigContext__Group__2__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__2"



    // $ANTLR start "rule__ConfigContext__Group__2__Impl"
    // InternalAdaptersLang.g:1747:1: rule__ConfigContext__Group__2__Impl : ( '{' ) ;
    public final void rule__ConfigContext__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1751:2: ( ( '{' ) )
            // InternalAdaptersLang.g:1752:2: ( '{' )
            {
            // InternalAdaptersLang.g:1752:2: ( '{' )
            // InternalAdaptersLang.g:1753:2: '{'
            {
             before(grammarAccess.getConfigContextAccess().getLeftCurlyBracketKeyword_2()); 

            match(input,26,FOLLOW_2); 

             after(grammarAccess.getConfigContextAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__2__Impl"



    // $ANTLR start "rule__ConfigContext__Group__3"
    // InternalAdaptersLang.g:1762:1: rule__ConfigContext__Group__3 : rule__ConfigContext__Group__3__Impl rule__ConfigContext__Group__4 ;
    public final void rule__ConfigContext__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1766:2: ( rule__ConfigContext__Group__3__Impl rule__ConfigContext__Group__4 )
            // InternalAdaptersLang.g:1767:2: rule__ConfigContext__Group__3__Impl rule__ConfigContext__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__ConfigContext__Group__3__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__3"



    // $ANTLR start "rule__ConfigContext__Group__3__Impl"
    // InternalAdaptersLang.g:1774:1: rule__ConfigContext__Group__3__Impl : ( ( rule__ConfigContext__Group_3__0 )? ) ;
    public final void rule__ConfigContext__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1778:2: ( ( ( rule__ConfigContext__Group_3__0 )? ) )
            // InternalAdaptersLang.g:1779:2: ( ( rule__ConfigContext__Group_3__0 )? )
            {
            // InternalAdaptersLang.g:1779:2: ( ( rule__ConfigContext__Group_3__0 )? )
            // InternalAdaptersLang.g:1780:2: ( rule__ConfigContext__Group_3__0 )?
            {
             before(grammarAccess.getConfigContextAccess().getGroup_3()); 

            // InternalAdaptersLang.g:1781:2: ( rule__ConfigContext__Group_3__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalAdaptersLang.g:1781:3: rule__ConfigContext__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ConfigContext__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }


             after(grammarAccess.getConfigContextAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__3__Impl"



    // $ANTLR start "rule__ConfigContext__Group__4"
    // InternalAdaptersLang.g:1789:1: rule__ConfigContext__Group__4 : rule__ConfigContext__Group__4__Impl rule__ConfigContext__Group__5 ;
    public final void rule__ConfigContext__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1793:2: ( rule__ConfigContext__Group__4__Impl rule__ConfigContext__Group__5 )
            // InternalAdaptersLang.g:1794:2: rule__ConfigContext__Group__4__Impl rule__ConfigContext__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__ConfigContext__Group__4__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__4"



    // $ANTLR start "rule__ConfigContext__Group__4__Impl"
    // InternalAdaptersLang.g:1801:1: rule__ConfigContext__Group__4__Impl : ( '}' ) ;
    public final void rule__ConfigContext__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1805:2: ( ( '}' ) )
            // InternalAdaptersLang.g:1806:2: ( '}' )
            {
            // InternalAdaptersLang.g:1806:2: ( '}' )
            // InternalAdaptersLang.g:1807:2: '}'
            {
             before(grammarAccess.getConfigContextAccess().getRightCurlyBracketKeyword_4()); 

            match(input,27,FOLLOW_2); 

             after(grammarAccess.getConfigContextAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__4__Impl"



    // $ANTLR start "rule__ConfigContext__Group__5"
    // InternalAdaptersLang.g:1816:1: rule__ConfigContext__Group__5 : rule__ConfigContext__Group__5__Impl rule__ConfigContext__Group__6 ;
    public final void rule__ConfigContext__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1820:2: ( rule__ConfigContext__Group__5__Impl rule__ConfigContext__Group__6 )
            // InternalAdaptersLang.g:1821:2: rule__ConfigContext__Group__5__Impl rule__ConfigContext__Group__6
            {
            pushFollow(FOLLOW_22);
            rule__ConfigContext__Group__5__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__5"



    // $ANTLR start "rule__ConfigContext__Group__5__Impl"
    // InternalAdaptersLang.g:1828:1: rule__ConfigContext__Group__5__Impl : ( ',' ) ;
    public final void rule__ConfigContext__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1832:2: ( ( ',' ) )
            // InternalAdaptersLang.g:1833:2: ( ',' )
            {
            // InternalAdaptersLang.g:1833:2: ( ',' )
            // InternalAdaptersLang.g:1834:2: ','
            {
             before(grammarAccess.getConfigContextAccess().getCommaKeyword_5()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getConfigContextAccess().getCommaKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__5__Impl"



    // $ANTLR start "rule__ConfigContext__Group__6"
    // InternalAdaptersLang.g:1843:1: rule__ConfigContext__Group__6 : rule__ConfigContext__Group__6__Impl rule__ConfigContext__Group__7 ;
    public final void rule__ConfigContext__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1847:2: ( rule__ConfigContext__Group__6__Impl rule__ConfigContext__Group__7 )
            // InternalAdaptersLang.g:1848:2: rule__ConfigContext__Group__6__Impl rule__ConfigContext__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__ConfigContext__Group__6__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__6"



    // $ANTLR start "rule__ConfigContext__Group__6__Impl"
    // InternalAdaptersLang.g:1855:1: rule__ConfigContext__Group__6__Impl : ( '--' ) ;
    public final void rule__ConfigContext__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1859:2: ( ( '--' ) )
            // InternalAdaptersLang.g:1860:2: ( '--' )
            {
            // InternalAdaptersLang.g:1860:2: ( '--' )
            // InternalAdaptersLang.g:1861:2: '--'
            {
             before(grammarAccess.getConfigContextAccess().getHyphenMinusHyphenMinusKeyword_6()); 

            match(input,17,FOLLOW_2); 

             after(grammarAccess.getConfigContextAccess().getHyphenMinusHyphenMinusKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__6__Impl"



    // $ANTLR start "rule__ConfigContext__Group__7"
    // InternalAdaptersLang.g:1870:1: rule__ConfigContext__Group__7 : rule__ConfigContext__Group__7__Impl rule__ConfigContext__Group__8 ;
    public final void rule__ConfigContext__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1874:2: ( rule__ConfigContext__Group__7__Impl rule__ConfigContext__Group__8 )
            // InternalAdaptersLang.g:1875:2: rule__ConfigContext__Group__7__Impl rule__ConfigContext__Group__8
            {
            pushFollow(FOLLOW_8);
            rule__ConfigContext__Group__7__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__7"



    // $ANTLR start "rule__ConfigContext__Group__7__Impl"
    // InternalAdaptersLang.g:1882:1: rule__ConfigContext__Group__7__Impl : ( '{' ) ;
    public final void rule__ConfigContext__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1886:2: ( ( '{' ) )
            // InternalAdaptersLang.g:1887:2: ( '{' )
            {
            // InternalAdaptersLang.g:1887:2: ( '{' )
            // InternalAdaptersLang.g:1888:2: '{'
            {
             before(grammarAccess.getConfigContextAccess().getLeftCurlyBracketKeyword_7()); 

            match(input,26,FOLLOW_2); 

             after(grammarAccess.getConfigContextAccess().getLeftCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__7__Impl"



    // $ANTLR start "rule__ConfigContext__Group__8"
    // InternalAdaptersLang.g:1897:1: rule__ConfigContext__Group__8 : rule__ConfigContext__Group__8__Impl rule__ConfigContext__Group__9 ;
    public final void rule__ConfigContext__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1901:2: ( rule__ConfigContext__Group__8__Impl rule__ConfigContext__Group__9 )
            // InternalAdaptersLang.g:1902:2: rule__ConfigContext__Group__8__Impl rule__ConfigContext__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__ConfigContext__Group__8__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__8"



    // $ANTLR start "rule__ConfigContext__Group__8__Impl"
    // InternalAdaptersLang.g:1909:1: rule__ConfigContext__Group__8__Impl : ( ( rule__ConfigContext__Group_8__0 )? ) ;
    public final void rule__ConfigContext__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1913:2: ( ( ( rule__ConfigContext__Group_8__0 )? ) )
            // InternalAdaptersLang.g:1914:2: ( ( rule__ConfigContext__Group_8__0 )? )
            {
            // InternalAdaptersLang.g:1914:2: ( ( rule__ConfigContext__Group_8__0 )? )
            // InternalAdaptersLang.g:1915:2: ( rule__ConfigContext__Group_8__0 )?
            {
             before(grammarAccess.getConfigContextAccess().getGroup_8()); 

            // InternalAdaptersLang.g:1916:2: ( rule__ConfigContext__Group_8__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||LA10_0==RULE_STRING) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalAdaptersLang.g:1916:3: rule__ConfigContext__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ConfigContext__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }


             after(grammarAccess.getConfigContextAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__8__Impl"



    // $ANTLR start "rule__ConfigContext__Group__9"
    // InternalAdaptersLang.g:1924:1: rule__ConfigContext__Group__9 : rule__ConfigContext__Group__9__Impl ;
    public final void rule__ConfigContext__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1928:2: ( rule__ConfigContext__Group__9__Impl )
            // InternalAdaptersLang.g:1929:2: rule__ConfigContext__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__9"



    // $ANTLR start "rule__ConfigContext__Group__9__Impl"
    // InternalAdaptersLang.g:1935:1: rule__ConfigContext__Group__9__Impl : ( '}' ) ;
    public final void rule__ConfigContext__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1939:2: ( ( '}' ) )
            // InternalAdaptersLang.g:1940:2: ( '}' )
            {
            // InternalAdaptersLang.g:1940:2: ( '}' )
            // InternalAdaptersLang.g:1941:2: '}'
            {
             before(grammarAccess.getConfigContextAccess().getRightCurlyBracketKeyword_9()); 

            match(input,27,FOLLOW_2); 

             after(grammarAccess.getConfigContextAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group__9__Impl"



    // $ANTLR start "rule__ConfigContext__Group_3__0"
    // InternalAdaptersLang.g:1951:1: rule__ConfigContext__Group_3__0 : rule__ConfigContext__Group_3__0__Impl rule__ConfigContext__Group_3__1 ;
    public final void rule__ConfigContext__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1955:2: ( rule__ConfigContext__Group_3__0__Impl rule__ConfigContext__Group_3__1 )
            // InternalAdaptersLang.g:1956:2: rule__ConfigContext__Group_3__0__Impl rule__ConfigContext__Group_3__1
            {
            pushFollow(FOLLOW_10);
            rule__ConfigContext__Group_3__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_3__0"



    // $ANTLR start "rule__ConfigContext__Group_3__0__Impl"
    // InternalAdaptersLang.g:1963:1: rule__ConfigContext__Group_3__0__Impl : ( ( rule__ConfigContext__PosSetAssignment_3_0 ) ) ;
    public final void rule__ConfigContext__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1967:2: ( ( ( rule__ConfigContext__PosSetAssignment_3_0 ) ) )
            // InternalAdaptersLang.g:1968:2: ( ( rule__ConfigContext__PosSetAssignment_3_0 ) )
            {
            // InternalAdaptersLang.g:1968:2: ( ( rule__ConfigContext__PosSetAssignment_3_0 ) )
            // InternalAdaptersLang.g:1969:2: ( rule__ConfigContext__PosSetAssignment_3_0 )
            {
             before(grammarAccess.getConfigContextAccess().getPosSetAssignment_3_0()); 

            // InternalAdaptersLang.g:1970:2: ( rule__ConfigContext__PosSetAssignment_3_0 )
            // InternalAdaptersLang.g:1970:3: rule__ConfigContext__PosSetAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__PosSetAssignment_3_0();

            state._fsp--;


            }


             after(grammarAccess.getConfigContextAccess().getPosSetAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_3__0__Impl"



    // $ANTLR start "rule__ConfigContext__Group_3__1"
    // InternalAdaptersLang.g:1978:1: rule__ConfigContext__Group_3__1 : rule__ConfigContext__Group_3__1__Impl ;
    public final void rule__ConfigContext__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1982:2: ( rule__ConfigContext__Group_3__1__Impl )
            // InternalAdaptersLang.g:1983:2: rule__ConfigContext__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_3__1"



    // $ANTLR start "rule__ConfigContext__Group_3__1__Impl"
    // InternalAdaptersLang.g:1989:1: rule__ConfigContext__Group_3__1__Impl : ( ( rule__ConfigContext__Group_3_1__0 )* ) ;
    public final void rule__ConfigContext__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:1993:2: ( ( ( rule__ConfigContext__Group_3_1__0 )* ) )
            // InternalAdaptersLang.g:1994:2: ( ( rule__ConfigContext__Group_3_1__0 )* )
            {
            // InternalAdaptersLang.g:1994:2: ( ( rule__ConfigContext__Group_3_1__0 )* )
            // InternalAdaptersLang.g:1995:2: ( rule__ConfigContext__Group_3_1__0 )*
            {
             before(grammarAccess.getConfigContextAccess().getGroup_3_1()); 

            // InternalAdaptersLang.g:1996:2: ( rule__ConfigContext__Group_3_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAdaptersLang.g:1996:3: rule__ConfigContext__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ConfigContext__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


             after(grammarAccess.getConfigContextAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_3__1__Impl"



    // $ANTLR start "rule__ConfigContext__Group_3_1__0"
    // InternalAdaptersLang.g:2005:1: rule__ConfigContext__Group_3_1__0 : rule__ConfigContext__Group_3_1__0__Impl rule__ConfigContext__Group_3_1__1 ;
    public final void rule__ConfigContext__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2009:2: ( rule__ConfigContext__Group_3_1__0__Impl rule__ConfigContext__Group_3_1__1 )
            // InternalAdaptersLang.g:2010:2: rule__ConfigContext__Group_3_1__0__Impl rule__ConfigContext__Group_3_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ConfigContext__Group_3_1__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_3_1__0"



    // $ANTLR start "rule__ConfigContext__Group_3_1__0__Impl"
    // InternalAdaptersLang.g:2017:1: rule__ConfigContext__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__ConfigContext__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2021:2: ( ( ',' ) )
            // InternalAdaptersLang.g:2022:2: ( ',' )
            {
            // InternalAdaptersLang.g:2022:2: ( ',' )
            // InternalAdaptersLang.g:2023:2: ','
            {
             before(grammarAccess.getConfigContextAccess().getCommaKeyword_3_1_0()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getConfigContextAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_3_1__0__Impl"



    // $ANTLR start "rule__ConfigContext__Group_3_1__1"
    // InternalAdaptersLang.g:2032:1: rule__ConfigContext__Group_3_1__1 : rule__ConfigContext__Group_3_1__1__Impl ;
    public final void rule__ConfigContext__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2036:2: ( rule__ConfigContext__Group_3_1__1__Impl )
            // InternalAdaptersLang.g:2037:2: rule__ConfigContext__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_3_1__1"



    // $ANTLR start "rule__ConfigContext__Group_3_1__1__Impl"
    // InternalAdaptersLang.g:2043:1: rule__ConfigContext__Group_3_1__1__Impl : ( ( rule__ConfigContext__PosSetAssignment_3_1_1 ) ) ;
    public final void rule__ConfigContext__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2047:2: ( ( ( rule__ConfigContext__PosSetAssignment_3_1_1 ) ) )
            // InternalAdaptersLang.g:2048:2: ( ( rule__ConfigContext__PosSetAssignment_3_1_1 ) )
            {
            // InternalAdaptersLang.g:2048:2: ( ( rule__ConfigContext__PosSetAssignment_3_1_1 ) )
            // InternalAdaptersLang.g:2049:2: ( rule__ConfigContext__PosSetAssignment_3_1_1 )
            {
             before(grammarAccess.getConfigContextAccess().getPosSetAssignment_3_1_1()); 

            // InternalAdaptersLang.g:2050:2: ( rule__ConfigContext__PosSetAssignment_3_1_1 )
            // InternalAdaptersLang.g:2050:3: rule__ConfigContext__PosSetAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__PosSetAssignment_3_1_1();

            state._fsp--;


            }


             after(grammarAccess.getConfigContextAccess().getPosSetAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_3_1__1__Impl"



    // $ANTLR start "rule__ConfigContext__Group_8__0"
    // InternalAdaptersLang.g:2059:1: rule__ConfigContext__Group_8__0 : rule__ConfigContext__Group_8__0__Impl rule__ConfigContext__Group_8__1 ;
    public final void rule__ConfigContext__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2063:2: ( rule__ConfigContext__Group_8__0__Impl rule__ConfigContext__Group_8__1 )
            // InternalAdaptersLang.g:2064:2: rule__ConfigContext__Group_8__0__Impl rule__ConfigContext__Group_8__1
            {
            pushFollow(FOLLOW_10);
            rule__ConfigContext__Group_8__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_8__0"



    // $ANTLR start "rule__ConfigContext__Group_8__0__Impl"
    // InternalAdaptersLang.g:2071:1: rule__ConfigContext__Group_8__0__Impl : ( ( rule__ConfigContext__NegSetAssignment_8_0 ) ) ;
    public final void rule__ConfigContext__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2075:2: ( ( ( rule__ConfigContext__NegSetAssignment_8_0 ) ) )
            // InternalAdaptersLang.g:2076:2: ( ( rule__ConfigContext__NegSetAssignment_8_0 ) )
            {
            // InternalAdaptersLang.g:2076:2: ( ( rule__ConfigContext__NegSetAssignment_8_0 ) )
            // InternalAdaptersLang.g:2077:2: ( rule__ConfigContext__NegSetAssignment_8_0 )
            {
             before(grammarAccess.getConfigContextAccess().getNegSetAssignment_8_0()); 

            // InternalAdaptersLang.g:2078:2: ( rule__ConfigContext__NegSetAssignment_8_0 )
            // InternalAdaptersLang.g:2078:3: rule__ConfigContext__NegSetAssignment_8_0
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__NegSetAssignment_8_0();

            state._fsp--;


            }


             after(grammarAccess.getConfigContextAccess().getNegSetAssignment_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_8__0__Impl"



    // $ANTLR start "rule__ConfigContext__Group_8__1"
    // InternalAdaptersLang.g:2086:1: rule__ConfigContext__Group_8__1 : rule__ConfigContext__Group_8__1__Impl ;
    public final void rule__ConfigContext__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2090:2: ( rule__ConfigContext__Group_8__1__Impl )
            // InternalAdaptersLang.g:2091:2: rule__ConfigContext__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_8__1"



    // $ANTLR start "rule__ConfigContext__Group_8__1__Impl"
    // InternalAdaptersLang.g:2097:1: rule__ConfigContext__Group_8__1__Impl : ( ( rule__ConfigContext__Group_8_1__0 )* ) ;
    public final void rule__ConfigContext__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2101:2: ( ( ( rule__ConfigContext__Group_8_1__0 )* ) )
            // InternalAdaptersLang.g:2102:2: ( ( rule__ConfigContext__Group_8_1__0 )* )
            {
            // InternalAdaptersLang.g:2102:2: ( ( rule__ConfigContext__Group_8_1__0 )* )
            // InternalAdaptersLang.g:2103:2: ( rule__ConfigContext__Group_8_1__0 )*
            {
             before(grammarAccess.getConfigContextAccess().getGroup_8_1()); 

            // InternalAdaptersLang.g:2104:2: ( rule__ConfigContext__Group_8_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==15) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAdaptersLang.g:2104:3: rule__ConfigContext__Group_8_1__0
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ConfigContext__Group_8_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


             after(grammarAccess.getConfigContextAccess().getGroup_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_8__1__Impl"



    // $ANTLR start "rule__ConfigContext__Group_8_1__0"
    // InternalAdaptersLang.g:2113:1: rule__ConfigContext__Group_8_1__0 : rule__ConfigContext__Group_8_1__0__Impl rule__ConfigContext__Group_8_1__1 ;
    public final void rule__ConfigContext__Group_8_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2117:2: ( rule__ConfigContext__Group_8_1__0__Impl rule__ConfigContext__Group_8_1__1 )
            // InternalAdaptersLang.g:2118:2: rule__ConfigContext__Group_8_1__0__Impl rule__ConfigContext__Group_8_1__1
            {
            pushFollow(FOLLOW_3);
            rule__ConfigContext__Group_8_1__0__Impl();

            state._fsp--;


            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group_8_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_8_1__0"



    // $ANTLR start "rule__ConfigContext__Group_8_1__0__Impl"
    // InternalAdaptersLang.g:2125:1: rule__ConfigContext__Group_8_1__0__Impl : ( ',' ) ;
    public final void rule__ConfigContext__Group_8_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2129:2: ( ( ',' ) )
            // InternalAdaptersLang.g:2130:2: ( ',' )
            {
            // InternalAdaptersLang.g:2130:2: ( ',' )
            // InternalAdaptersLang.g:2131:2: ','
            {
             before(grammarAccess.getConfigContextAccess().getCommaKeyword_8_1_0()); 

            match(input,15,FOLLOW_2); 

             after(grammarAccess.getConfigContextAccess().getCommaKeyword_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_8_1__0__Impl"



    // $ANTLR start "rule__ConfigContext__Group_8_1__1"
    // InternalAdaptersLang.g:2140:1: rule__ConfigContext__Group_8_1__1 : rule__ConfigContext__Group_8_1__1__Impl ;
    public final void rule__ConfigContext__Group_8_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2144:2: ( rule__ConfigContext__Group_8_1__1__Impl )
            // InternalAdaptersLang.g:2145:2: rule__ConfigContext__Group_8_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__Group_8_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_8_1__1"



    // $ANTLR start "rule__ConfigContext__Group_8_1__1__Impl"
    // InternalAdaptersLang.g:2151:1: rule__ConfigContext__Group_8_1__1__Impl : ( ( rule__ConfigContext__NegSetAssignment_8_1_1 ) ) ;
    public final void rule__ConfigContext__Group_8_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2155:2: ( ( ( rule__ConfigContext__NegSetAssignment_8_1_1 ) ) )
            // InternalAdaptersLang.g:2156:2: ( ( rule__ConfigContext__NegSetAssignment_8_1_1 ) )
            {
            // InternalAdaptersLang.g:2156:2: ( ( rule__ConfigContext__NegSetAssignment_8_1_1 ) )
            // InternalAdaptersLang.g:2157:2: ( rule__ConfigContext__NegSetAssignment_8_1_1 )
            {
             before(grammarAccess.getConfigContextAccess().getNegSetAssignment_8_1_1()); 

            // InternalAdaptersLang.g:2158:2: ( rule__ConfigContext__NegSetAssignment_8_1_1 )
            // InternalAdaptersLang.g:2158:3: rule__ConfigContext__NegSetAssignment_8_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ConfigContext__NegSetAssignment_8_1_1();

            state._fsp--;


            }


             after(grammarAccess.getConfigContextAccess().getNegSetAssignment_8_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__Group_8_1__1__Impl"



    // $ANTLR start "rule__AdapterModel__NameAssignment_1"
    // InternalAdaptersLang.g:2167:1: rule__AdapterModel__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__AdapterModel__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2171:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2172:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2172:2: ( ruleEString )
            // InternalAdaptersLang.g:2173:3: ruleEString
            {
             before(grammarAccess.getAdapterModelAccess().getNameEStringParserRuleCall_1_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getAdapterModelAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__NameAssignment_1"



    // $ANTLR start "rule__AdapterModel__EcoreAssignment_3"
    // InternalAdaptersLang.g:2182:1: rule__AdapterModel__EcoreAssignment_3 : ( ruleEString ) ;
    public final void rule__AdapterModel__EcoreAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2186:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2187:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2187:2: ( ruleEString )
            // InternalAdaptersLang.g:2188:3: ruleEString
            {
             before(grammarAccess.getAdapterModelAccess().getEcoreEStringParserRuleCall_3_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getAdapterModelAccess().getEcoreEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__EcoreAssignment_3"



    // $ANTLR start "rule__AdapterModel__TransformationAssignment_5"
    // InternalAdaptersLang.g:2197:1: rule__AdapterModel__TransformationAssignment_5 : ( ruleEString ) ;
    public final void rule__AdapterModel__TransformationAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2201:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2202:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2202:2: ( ruleEString )
            // InternalAdaptersLang.g:2203:3: ruleEString
            {
             before(grammarAccess.getAdapterModelAccess().getTransformationEStringParserRuleCall_5_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getAdapterModelAccess().getTransformationEStringParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__TransformationAssignment_5"



    // $ANTLR start "rule__AdapterModel__AdaptersAssignment_8_0"
    // InternalAdaptersLang.g:2212:1: rule__AdapterModel__AdaptersAssignment_8_0 : ( ruleAdapter ) ;
    public final void rule__AdapterModel__AdaptersAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2216:2: ( ( ruleAdapter ) )
            // InternalAdaptersLang.g:2217:2: ( ruleAdapter )
            {
            // InternalAdaptersLang.g:2217:2: ( ruleAdapter )
            // InternalAdaptersLang.g:2218:3: ruleAdapter
            {
             before(grammarAccess.getAdapterModelAccess().getAdaptersAdapterParserRuleCall_8_0_0()); 

            pushFollow(FOLLOW_2);
            ruleAdapter();

            state._fsp--;


             after(grammarAccess.getAdapterModelAccess().getAdaptersAdapterParserRuleCall_8_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__AdaptersAssignment_8_0"



    // $ANTLR start "rule__AdapterModel__AdaptersAssignment_8_1_1"
    // InternalAdaptersLang.g:2227:1: rule__AdapterModel__AdaptersAssignment_8_1_1 : ( ruleAdapter ) ;
    public final void rule__AdapterModel__AdaptersAssignment_8_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2231:2: ( ( ruleAdapter ) )
            // InternalAdaptersLang.g:2232:2: ( ruleAdapter )
            {
            // InternalAdaptersLang.g:2232:2: ( ruleAdapter )
            // InternalAdaptersLang.g:2233:3: ruleAdapter
            {
             before(grammarAccess.getAdapterModelAccess().getAdaptersAdapterParserRuleCall_8_1_1_0()); 

            pushFollow(FOLLOW_2);
            ruleAdapter();

            state._fsp--;


             after(grammarAccess.getAdapterModelAccess().getAdaptersAdapterParserRuleCall_8_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdapterModel__AdaptersAssignment_8_1_1"



    // $ANTLR start "rule__Adapter__NameAssignment_0"
    // InternalAdaptersLang.g:2242:1: rule__Adapter__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Adapter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2246:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2247:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2247:2: ( ruleEString )
            // InternalAdaptersLang.g:2248:3: ruleEString
            {
             before(grammarAccess.getAdapterAccess().getNameEStringParserRuleCall_0_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getAdapterAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__NameAssignment_0"



    // $ANTLR start "rule__Adapter__CfgDiffAssignment_3"
    // InternalAdaptersLang.g:2257:1: rule__Adapter__CfgDiffAssignment_3 : ( ruleConfigDiff ) ;
    public final void rule__Adapter__CfgDiffAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2261:2: ( ( ruleConfigDiff ) )
            // InternalAdaptersLang.g:2262:2: ( ruleConfigDiff )
            {
            // InternalAdaptersLang.g:2262:2: ( ruleConfigDiff )
            // InternalAdaptersLang.g:2263:3: ruleConfigDiff
            {
             before(grammarAccess.getAdapterAccess().getCfgDiffConfigDiffParserRuleCall_3_0()); 

            pushFollow(FOLLOW_2);
            ruleConfigDiff();

            state._fsp--;


             after(grammarAccess.getAdapterAccess().getCfgDiffConfigDiffParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__CfgDiffAssignment_3"



    // $ANTLR start "rule__Adapter__RulesAssignment_7"
    // InternalAdaptersLang.g:2272:1: rule__Adapter__RulesAssignment_7 : ( ruleEString ) ;
    public final void rule__Adapter__RulesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2276:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2277:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2277:2: ( ruleEString )
            // InternalAdaptersLang.g:2278:3: ruleEString
            {
             before(grammarAccess.getAdapterAccess().getRulesEStringParserRuleCall_7_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getAdapterAccess().getRulesEStringParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__RulesAssignment_7"



    // $ANTLR start "rule__Adapter__RulesAssignment_8_1"
    // InternalAdaptersLang.g:2287:1: rule__Adapter__RulesAssignment_8_1 : ( ruleEString ) ;
    public final void rule__Adapter__RulesAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2291:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2292:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2292:2: ( ruleEString )
            // InternalAdaptersLang.g:2293:3: ruleEString
            {
             before(grammarAccess.getAdapterAccess().getRulesEStringParserRuleCall_8_1_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getAdapterAccess().getRulesEStringParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adapter__RulesAssignment_8_1"



    // $ANTLR start "rule__ConfigDiff__DeltaAssignment_2"
    // InternalAdaptersLang.g:2302:1: rule__ConfigDiff__DeltaAssignment_2 : ( ruleConfigDelta ) ;
    public final void rule__ConfigDiff__DeltaAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2306:2: ( ( ruleConfigDelta ) )
            // InternalAdaptersLang.g:2307:2: ( ruleConfigDelta )
            {
            // InternalAdaptersLang.g:2307:2: ( ruleConfigDelta )
            // InternalAdaptersLang.g:2308:3: ruleConfigDelta
            {
             before(grammarAccess.getConfigDiffAccess().getDeltaConfigDeltaParserRuleCall_2_0()); 

            pushFollow(FOLLOW_2);
            ruleConfigDelta();

            state._fsp--;


             after(grammarAccess.getConfigDiffAccess().getDeltaConfigDeltaParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__DeltaAssignment_2"



    // $ANTLR start "rule__ConfigDiff__ContextAssignment_7"
    // InternalAdaptersLang.g:2317:1: rule__ConfigDiff__ContextAssignment_7 : ( ruleConfigContext ) ;
    public final void rule__ConfigDiff__ContextAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2321:2: ( ( ruleConfigContext ) )
            // InternalAdaptersLang.g:2322:2: ( ruleConfigContext )
            {
            // InternalAdaptersLang.g:2322:2: ( ruleConfigContext )
            // InternalAdaptersLang.g:2323:3: ruleConfigContext
            {
             before(grammarAccess.getConfigDiffAccess().getContextConfigContextParserRuleCall_7_0()); 

            pushFollow(FOLLOW_2);
            ruleConfigContext();

            state._fsp--;


             after(grammarAccess.getConfigDiffAccess().getContextConfigContextParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDiff__ContextAssignment_7"



    // $ANTLR start "rule__ConfigDelta__PosSetAssignment_3_0"
    // InternalAdaptersLang.g:2332:1: rule__ConfigDelta__PosSetAssignment_3_0 : ( ruleEString ) ;
    public final void rule__ConfigDelta__PosSetAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2336:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2337:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2337:2: ( ruleEString )
            // InternalAdaptersLang.g:2338:3: ruleEString
            {
             before(grammarAccess.getConfigDeltaAccess().getPosSetEStringParserRuleCall_3_0_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getConfigDeltaAccess().getPosSetEStringParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__PosSetAssignment_3_0"



    // $ANTLR start "rule__ConfigDelta__PosSetAssignment_3_1_1"
    // InternalAdaptersLang.g:2347:1: rule__ConfigDelta__PosSetAssignment_3_1_1 : ( ruleEString ) ;
    public final void rule__ConfigDelta__PosSetAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2351:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2352:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2352:2: ( ruleEString )
            // InternalAdaptersLang.g:2353:3: ruleEString
            {
             before(grammarAccess.getConfigDeltaAccess().getPosSetEStringParserRuleCall_3_1_1_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getConfigDeltaAccess().getPosSetEStringParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__PosSetAssignment_3_1_1"



    // $ANTLR start "rule__ConfigDelta__NegSetAssignment_8_0"
    // InternalAdaptersLang.g:2362:1: rule__ConfigDelta__NegSetAssignment_8_0 : ( ruleEString ) ;
    public final void rule__ConfigDelta__NegSetAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2366:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2367:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2367:2: ( ruleEString )
            // InternalAdaptersLang.g:2368:3: ruleEString
            {
             before(grammarAccess.getConfigDeltaAccess().getNegSetEStringParserRuleCall_8_0_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getConfigDeltaAccess().getNegSetEStringParserRuleCall_8_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__NegSetAssignment_8_0"



    // $ANTLR start "rule__ConfigDelta__NegSetAssignment_8_1_1"
    // InternalAdaptersLang.g:2377:1: rule__ConfigDelta__NegSetAssignment_8_1_1 : ( ruleEString ) ;
    public final void rule__ConfigDelta__NegSetAssignment_8_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2381:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2382:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2382:2: ( ruleEString )
            // InternalAdaptersLang.g:2383:3: ruleEString
            {
             before(grammarAccess.getConfigDeltaAccess().getNegSetEStringParserRuleCall_8_1_1_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getConfigDeltaAccess().getNegSetEStringParserRuleCall_8_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigDelta__NegSetAssignment_8_1_1"



    // $ANTLR start "rule__ConfigContext__PosSetAssignment_3_0"
    // InternalAdaptersLang.g:2392:1: rule__ConfigContext__PosSetAssignment_3_0 : ( ruleEString ) ;
    public final void rule__ConfigContext__PosSetAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2396:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2397:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2397:2: ( ruleEString )
            // InternalAdaptersLang.g:2398:3: ruleEString
            {
             before(grammarAccess.getConfigContextAccess().getPosSetEStringParserRuleCall_3_0_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getConfigContextAccess().getPosSetEStringParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__PosSetAssignment_3_0"



    // $ANTLR start "rule__ConfigContext__PosSetAssignment_3_1_1"
    // InternalAdaptersLang.g:2407:1: rule__ConfigContext__PosSetAssignment_3_1_1 : ( ruleEString ) ;
    public final void rule__ConfigContext__PosSetAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2411:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2412:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2412:2: ( ruleEString )
            // InternalAdaptersLang.g:2413:3: ruleEString
            {
             before(grammarAccess.getConfigContextAccess().getPosSetEStringParserRuleCall_3_1_1_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getConfigContextAccess().getPosSetEStringParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__PosSetAssignment_3_1_1"



    // $ANTLR start "rule__ConfigContext__NegSetAssignment_8_0"
    // InternalAdaptersLang.g:2422:1: rule__ConfigContext__NegSetAssignment_8_0 : ( ruleEString ) ;
    public final void rule__ConfigContext__NegSetAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2426:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2427:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2427:2: ( ruleEString )
            // InternalAdaptersLang.g:2428:3: ruleEString
            {
             before(grammarAccess.getConfigContextAccess().getNegSetEStringParserRuleCall_8_0_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getConfigContextAccess().getNegSetEStringParserRuleCall_8_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__NegSetAssignment_8_0"



    // $ANTLR start "rule__ConfigContext__NegSetAssignment_8_1_1"
    // InternalAdaptersLang.g:2437:1: rule__ConfigContext__NegSetAssignment_8_1_1 : ( ruleEString ) ;
    public final void rule__ConfigContext__NegSetAssignment_8_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAdaptersLang.g:2441:2: ( ( ruleEString ) )
            // InternalAdaptersLang.g:2442:2: ( ruleEString )
            {
            // InternalAdaptersLang.g:2442:2: ( ruleEString )
            // InternalAdaptersLang.g:2443:3: ruleEString
            {
             before(grammarAccess.getConfigContextAccess().getNegSetEStringParserRuleCall_8_1_1_0()); 

            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


             after(grammarAccess.getConfigContextAccess().getNegSetEStringParserRuleCall_8_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConfigContext__NegSetAssignment_8_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008000220L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000020000L});

}