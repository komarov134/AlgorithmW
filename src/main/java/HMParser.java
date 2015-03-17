// Generated from HM.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, INT=16, BOOL=17, 
		ID=18, WS=19;
	public static final int
		RULE_expr = 0;
	public static final String[] ruleNames = {
		"expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'let'", "'='", "'in'", "'\\'", "'.'", "'If'", "'Minus'", 
		"'Plus'", "'Eq'", "'Y'", "'<'", "','", "'>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "INT", "BOOL", "ID", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitEq(this);
		}
	}
	public static class PlusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PlusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitPlus(this);
		}
	}
	public static class MinusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitMinus(this);
		}
	}
	public static class AppContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AppContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitApp(this);
		}
	}
	public static class LetContext extends ExprContext {
		public TerminalNode ID() { return getToken(HMParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitLet(this);
		}
	}
	public static class PairContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PairContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitPair(this);
		}
	}
	public static class AbsContext extends ExprContext {
		public TerminalNode ID() { return getToken(HMParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AbsContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterAbs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitAbs(this);
		}
	}
	public static class IfContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitIf(this);
		}
	}
	public static class IntegerContext extends ExprContext {
		public TerminalNode INT() { return getToken(HMParser.INT, 0); }
		public IntegerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitInteger(this);
		}
	}
	public static class VarContext extends ExprContext {
		public TerminalNode ID() { return getToken(HMParser.ID, 0); }
		public VarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitVar(this);
		}
	}
	public static class YContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public YContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitY(this);
		}
	}
	public static class BooleanContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(HMParser.BOOL, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitBoolean(this);
		}
	}
	public static class ParenthesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HMListener ) ((HMListener)listener).exitParenthesis(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			switch (_input.LA(1)) {
			case T__5:
				{
				_localctx = new AbsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3);
				match(T__5);
				setState(4);
				match(ID);
				setState(5);
				match(T__6);
				setState(6);
				expr(9);
				}
				break;
			case T__11:
				{
				_localctx = new YContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(7);
				match(T__11);
				setState(8);
				expr(2);
				}
				break;
			case T__0:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(9);
				match(T__0);
				setState(10);
				expr(0);
				setState(11);
				match(T__1);
				}
				break;
			case T__2:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13);
				match(T__2);
				setState(14);
				match(ID);
				setState(15);
				match(T__3);
				setState(16);
				expr(0);
				setState(17);
				match(T__4);
				setState(18);
				expr(0);
				}
				break;
			case ID:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(ID);
				}
				break;
			case INT:
				{
				_localctx = new IntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(INT);
				}
				break;
			case BOOL:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(BOOL);
				}
				break;
			case T__7:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(T__7);
				setState(24);
				expr(0);
				setState(25);
				expr(0);
				setState(26);
				expr(0);
				}
				break;
			case T__8:
				{
				_localctx = new MinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(T__8);
				setState(29);
				expr(0);
				setState(30);
				expr(0);
				}
				break;
			case T__9:
				{
				_localctx = new PlusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32);
				match(T__9);
				setState(33);
				expr(0);
				setState(34);
				expr(0);
				}
				break;
			case T__10:
				{
				_localctx = new EqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				match(T__10);
				setState(37);
				expr(0);
				setState(38);
				expr(0);
				}
				break;
			case T__12:
				{
				_localctx = new PairContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(T__12);
				setState(41);
				expr(0);
				setState(42);
				match(T__13);
				setState(43);
				expr(0);
				setState(44);
				match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AppContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(48);
					if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
					setState(49);
					expr(12);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25:\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\61\n\2\3\2\3\2\7\2\65\n\2\f\2\16\2"+
		"8\13\2\3\2\2\3\2\3\2\2\2D\2\60\3\2\2\2\4\5\b\2\1\2\5\6\7\b\2\2\6\7\7\24"+
		"\2\2\7\b\7\t\2\2\b\61\5\2\2\13\t\n\7\16\2\2\n\61\5\2\2\4\13\f\7\3\2\2"+
		"\f\r\5\2\2\2\r\16\7\4\2\2\16\61\3\2\2\2\17\20\7\5\2\2\20\21\7\24\2\2\21"+
		"\22\7\6\2\2\22\23\5\2\2\2\23\24\7\7\2\2\24\25\5\2\2\2\25\61\3\2\2\2\26"+
		"\61\7\24\2\2\27\61\7\22\2\2\30\61\7\23\2\2\31\32\7\n\2\2\32\33\5\2\2\2"+
		"\33\34\5\2\2\2\34\35\5\2\2\2\35\61\3\2\2\2\36\37\7\13\2\2\37 \5\2\2\2"+
		" !\5\2\2\2!\61\3\2\2\2\"#\7\f\2\2#$\5\2\2\2$%\5\2\2\2%\61\3\2\2\2&\'\7"+
		"\r\2\2\'(\5\2\2\2()\5\2\2\2)\61\3\2\2\2*+\7\17\2\2+,\5\2\2\2,-\7\20\2"+
		"\2-.\5\2\2\2./\7\21\2\2/\61\3\2\2\2\60\4\3\2\2\2\60\t\3\2\2\2\60\13\3"+
		"\2\2\2\60\17\3\2\2\2\60\26\3\2\2\2\60\27\3\2\2\2\60\30\3\2\2\2\60\31\3"+
		"\2\2\2\60\36\3\2\2\2\60\"\3\2\2\2\60&\3\2\2\2\60*\3\2\2\2\61\66\3\2\2"+
		"\2\62\63\f\r\2\2\63\65\5\2\2\16\64\62\3\2\2\2\658\3\2\2\2\66\64\3\2\2"+
		"\2\66\67\3\2\2\2\67\3\3\2\2\28\66\3\2\2\2\4\60\66";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}