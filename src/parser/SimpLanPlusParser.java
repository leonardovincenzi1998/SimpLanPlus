// Generated from SimpLanPlus.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpLanPlusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__27=1, T__26=2, T__25=3, T__24=4, T__23=5, T__22=6, T__21=7, T__20=8, 
		T__19=9, T__18=10, T__17=11, T__16=12, T__15=13, T__14=14, T__13=15, T__12=16, 
		T__11=17, T__10=18, T__9=19, T__8=20, T__7=21, T__6=22, T__5=23, T__4=24, 
		T__3=25, T__2=26, T__1=27, T__0=28, BOOL=29, ID=30, NUMBER=31, WS=32, 
		LINECOMMENTS=33, BLOCKCOMMENTS=34;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'return'", "'!='", "'||'", "'void'", "';'", "'{'", 
		"'&&'", "'='", "'}'", "'if'", "'<='", "'int'", "'print'", "'('", "'*'", 
		"','", "'var'", "'>='", "'=='", "'<'", "'>'", "'bool'", "'!'", "'else'", 
		"')'", "'+'", "'-'", "BOOL", "ID", "NUMBER", "WS", "LINECOMMENTS", "BLOCKCOMMENTS"
	};
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_statement = 2, RULE_declaration = 3, 
		RULE_decFun = 4, RULE_decVar = 5, RULE_type = 6, RULE_arg = 7, RULE_assignment = 8, 
		RULE_print = 9, RULE_ret = 10, RULE_ite = 11, RULE_call = 12, RULE_exp = 13;
	public static final String[] ruleNames = {
		"program", "block", "statement", "declaration", "decFun", "decVar", "type", 
		"arg", "assignment", "print", "ret", "ite", "call", "exp"
	};

	@Override
	public String getGrammarFileName() { return "SimpLanPlus.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpLanPlusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimpLanPlusParser.EOF, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28); match(T__21);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__15) | (1L << T__5))) != 0)) {
				{
				{
				setState(29); declaration();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__21) | (1L << T__17) | (1L << T__14) | (1L << ID))) != 0)) {
				{
				{
				setState(35); statement();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41); match(T__18);
			setState(42); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public DecVarContext decVar(int i) {
			return getRuleContext(DecVarContext.class,i);
		}
		public List<DecVarContext> decVar() {
			return getRuleContexts(DecVarContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(T__21);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15 || _la==T__5) {
				{
				{
				setState(45); decVar();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__21) | (1L << T__17) | (1L << T__14) | (1L << ID))) != 0)) {
				{
				{
				setState(51); statement();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57); match(T__18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public IteContext ite() {
			return getRuleContext(IteContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(73);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59); assignment();
				setState(60); match(T__22);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62); print();
				setState(63); match(T__22);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65); ret();
				setState(66); match(T__22);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68); ite();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(69); call();
				setState(70); match(T__22);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(72); block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DecFunContext decFun() {
			return getRuleContext(DecFunContext.class,0);
		}
		public DecVarContext decVar() {
			return getRuleContext(DecVarContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		try {
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75); decFun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76); decVar();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecFunContext extends ParserRuleContext {
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public DecFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decFun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitDecFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecFunContext decFun() throws RecognitionException {
		DecFunContext _localctx = new DecFunContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decFun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			switch (_input.LA(1)) {
			case T__15:
			case T__5:
				{
				setState(79); type();
				}
				break;
			case T__23:
				{
				setState(80); match(T__23);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(83); match(ID);
			setState(84); match(T__13);
			setState(93);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__10) | (1L << T__5))) != 0)) {
				{
				setState(85); arg();
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(86); match(T__11);
					setState(87); arg();
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(95); match(T__2);
			setState(96); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecVarContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DecVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decVar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitDecVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecVarContext decVar() throws RecognitionException {
		DecVarContext _localctx = new DecVarContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); type();
			setState(99); match(ID);
			setState(102);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(100); match(T__19);
				setState(101); exp(0);
				}
			}

			setState(104); match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(108); match(T__10);
				}
			}

			setState(111); type();
			setState(112); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); match(ID);
			setState(115); match(T__19);
			setState(116); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); match(T__14);
			setState(119); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ret);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(T__26);
			setState(123);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__4) | (1L << T__0) | (1L << BOOL) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(122); exp(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IteContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public IteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ite; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitIte(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteContext ite() throws RecognitionException {
		IteContext _localctx = new IteContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); match(T__17);
			setState(126); match(T__13);
			setState(127); exp(0);
			setState(128); match(T__2);
			setState(129); statement();
			setState(132);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(130); match(T__3);
				setState(131); statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(ID);
			setState(135); match(T__13);
			setState(144);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__4) | (1L << T__0) | (1L << BOOL) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(136); exp(0);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(137); match(T__11);
					setState(138); exp(0);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(146); match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BaseExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBaseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinExpContext extends ExpContext {
		public ExpContext left;
		public Token op;
		public ExpContext right;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BinExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBinExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DerExpContext extends ExpContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public DerExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitDerExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValExpContext extends ExpContext {
		public TerminalNode NUMBER() { return getToken(SimpLanPlusParser.NUMBER, 0); }
		public ValExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitValExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NegExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitNegExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExpContext extends ExpContext {
		public TerminalNode BOOL() { return getToken(SimpLanPlusParser.BOOL, 0); }
		public BoolExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBoolExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallExpContext extends ExpContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public CallExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitCallExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NotExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitNotExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new NegExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(149); match(T__0);
				setState(150); exp(12);
				}
				break;
			case 2:
				{
				_localctx = new NotExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151); match(T__4);
				setState(152); exp(11);
				}
				break;
			case 3:
				{
				_localctx = new BaseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153); match(T__13);
				setState(154); exp(0);
				setState(155); match(T__2);
				}
				break;
			case 4:
				{
				_localctx = new DerExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157); match(ID);
				}
				break;
			case 5:
				{
				_localctx = new CallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(158); call();
				}
				break;
			case 6:
				{
				_localctx = new BoolExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159); match(BOOL);
				}
				break;
			case 7:
				{
				_localctx = new ValExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160); match(NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(181);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(163);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(164);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__12) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(165); ((BinExpContext)_localctx).right = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(166);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(167);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__0) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(168); ((BinExpContext)_localctx).right = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(169);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(170);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__9) | (1L << T__7) | (1L << T__6))) != 0)) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(171); ((BinExpContext)_localctx).right = exp(8);
						}
						break;
					case 4:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(172);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(173);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__8) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(174); ((BinExpContext)_localctx).right = exp(7);
						}
						break;
					case 5:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(175);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(176); ((BinExpContext)_localctx).op = match(T__20);
						setState(177); ((BinExpContext)_localctx).right = exp(6);
						}
						break;
					case 6:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(178);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(179); ((BinExpContext)_localctx).op = match(T__24);
						setState(180); ((BinExpContext)_localctx).right = exp(5);
						}
						break;
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		case 13: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 9);
		case 1: return precpred(_ctx, 8);
		case 2: return precpred(_ctx, 7);
		case 3: return precpred(_ctx, 6);
		case 4: return precpred(_ctx, 5);
		case 5: return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$\u00bd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\7\2!\n\2\f\2\16\2$\13"+
		"\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\2\3\3\3\3\7\3\61\n\3\f\3\16"+
		"\3\64\13\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4L\n\4\3\5\3\5\5\5P\n\5\3\6\3\6\5"+
		"\6T\n\6\3\6\3\6\3\6\3\6\3\6\7\6[\n\6\f\6\16\6^\13\6\5\6`\n\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\5\7i\n\7\3\7\3\7\3\b\3\b\3\t\5\tp\n\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\5\f~\n\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\r\u0087\n\r\3\16\3\16\3\16\3\16\3\16\7\16\u008e\n\16\f\16\16\16"+
		"\u0091\13\16\5\16\u0093\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a4\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\7\17\u00b8\n\17\f\17\16\17\u00bb\13\17\3\17\2\3\34\20\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\2\7\4\2\17\17\31\31\4\2\3\3\22\22\3\2\35\36\5\2"+
		"\16\16\25\25\27\30\4\2\5\5\26\26\u00cd\2\36\3\2\2\2\4.\3\2\2\2\6K\3\2"+
		"\2\2\bO\3\2\2\2\nS\3\2\2\2\fd\3\2\2\2\16l\3\2\2\2\20o\3\2\2\2\22t\3\2"+
		"\2\2\24x\3\2\2\2\26{\3\2\2\2\30\177\3\2\2\2\32\u0088\3\2\2\2\34\u00a3"+
		"\3\2\2\2\36\"\7\t\2\2\37!\5\b\5\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#"+
		"\3\2\2\2#(\3\2\2\2$\"\3\2\2\2%\'\5\6\4\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2"+
		"\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\f\2\2,-\7\2\2\3-\3\3\2\2\2.\62\7"+
		"\t\2\2/\61\5\f\7\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2"+
		"\2\638\3\2\2\2\64\62\3\2\2\2\65\67\5\6\4\2\66\65\3\2\2\2\67:\3\2\2\28"+
		"\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\f\2\2<\5\3\2\2\2=>\5\22"+
		"\n\2>?\7\b\2\2?L\3\2\2\2@A\5\24\13\2AB\7\b\2\2BL\3\2\2\2CD\5\26\f\2DE"+
		"\7\b\2\2EL\3\2\2\2FL\5\30\r\2GH\5\32\16\2HI\7\b\2\2IL\3\2\2\2JL\5\4\3"+
		"\2K=\3\2\2\2K@\3\2\2\2KC\3\2\2\2KF\3\2\2\2KG\3\2\2\2KJ\3\2\2\2L\7\3\2"+
		"\2\2MP\5\n\6\2NP\5\f\7\2OM\3\2\2\2ON\3\2\2\2P\t\3\2\2\2QT\5\16\b\2RT\7"+
		"\7\2\2SQ\3\2\2\2SR\3\2\2\2TU\3\2\2\2UV\7 \2\2V_\7\21\2\2W\\\5\20\t\2X"+
		"Y\7\23\2\2Y[\5\20\t\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]`\3\2"+
		"\2\2^\\\3\2\2\2_W\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\34\2\2bc\5\4\3\2c\13"+
		"\3\2\2\2de\5\16\b\2eh\7 \2\2fg\7\13\2\2gi\5\34\17\2hf\3\2\2\2hi\3\2\2"+
		"\2ij\3\2\2\2jk\7\b\2\2k\r\3\2\2\2lm\t\2\2\2m\17\3\2\2\2np\7\24\2\2on\3"+
		"\2\2\2op\3\2\2\2pq\3\2\2\2qr\5\16\b\2rs\7 \2\2s\21\3\2\2\2tu\7 \2\2uv"+
		"\7\13\2\2vw\5\34\17\2w\23\3\2\2\2xy\7\20\2\2yz\5\34\17\2z\25\3\2\2\2{"+
		"}\7\4\2\2|~\5\34\17\2}|\3\2\2\2}~\3\2\2\2~\27\3\2\2\2\177\u0080\7\r\2"+
		"\2\u0080\u0081\7\21\2\2\u0081\u0082\5\34\17\2\u0082\u0083\7\34\2\2\u0083"+
		"\u0086\5\6\4\2\u0084\u0085\7\33\2\2\u0085\u0087\5\6\4\2\u0086\u0084\3"+
		"\2\2\2\u0086\u0087\3\2\2\2\u0087\31\3\2\2\2\u0088\u0089\7 \2\2\u0089\u0092"+
		"\7\21\2\2\u008a\u008f\5\34\17\2\u008b\u008c\7\23\2\2\u008c\u008e\5\34"+
		"\17\2\u008d\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u008a\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7\34\2\2\u0095"+
		"\33\3\2\2\2\u0096\u0097\b\17\1\2\u0097\u0098\7\36\2\2\u0098\u00a4\5\34"+
		"\17\16\u0099\u009a\7\32\2\2\u009a\u00a4\5\34\17\r\u009b\u009c\7\21\2\2"+
		"\u009c\u009d\5\34\17\2\u009d\u009e\7\34\2\2\u009e\u00a4\3\2\2\2\u009f"+
		"\u00a4\7 \2\2\u00a0\u00a4\5\32\16\2\u00a1\u00a4\7\37\2\2\u00a2\u00a4\7"+
		"!\2\2\u00a3\u0096\3\2\2\2\u00a3\u0099\3\2\2\2\u00a3\u009b\3\2\2\2\u00a3"+
		"\u009f\3\2\2\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2"+
		"\2\2\u00a4\u00b9\3\2\2\2\u00a5\u00a6\f\13\2\2\u00a6\u00a7\t\3\2\2\u00a7"+
		"\u00b8\5\34\17\f\u00a8\u00a9\f\n\2\2\u00a9\u00aa\t\4\2\2\u00aa\u00b8\5"+
		"\34\17\13\u00ab\u00ac\f\t\2\2\u00ac\u00ad\t\5\2\2\u00ad\u00b8\5\34\17"+
		"\n\u00ae\u00af\f\b\2\2\u00af\u00b0\t\6\2\2\u00b0\u00b8\5\34\17\t\u00b1"+
		"\u00b2\f\7\2\2\u00b2\u00b3\7\n\2\2\u00b3\u00b8\5\34\17\b\u00b4\u00b5\f"+
		"\6\2\2\u00b5\u00b6\7\6\2\2\u00b6\u00b8\5\34\17\7\u00b7\u00a5\3\2\2\2\u00b7"+
		"\u00a8\3\2\2\2\u00b7\u00ab\3\2\2\2\u00b7\u00ae\3\2\2\2\u00b7\u00b1\3\2"+
		"\2\2\u00b7\u00b4\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\35\3\2\2\2\u00bb\u00b9\3\2\2\2\24\"(\628KOS\\_ho"+
		"}\u0086\u008f\u0092\u00a3\u00b7\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}