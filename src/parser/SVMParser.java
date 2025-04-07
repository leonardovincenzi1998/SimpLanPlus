// Generated from SVM.g4 by ANTLR 4.4
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
public class SVMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, PUSH=5, POP=6, TOP=7, LI=8, MOVE=9, LW=10, 
		SW=11, LB=12, SB=13, ADD=14, ADDI=15, SUB=16, SUBI=17, MULT=18, MULTI=19, 
		DIV=20, DIVI=21, BGT=22, BGEQ=23, BLEQ=24, BLT=25, BNE=26, AND=27, OR=28, 
		NOT=29, NEG=30, PRINT=31, RET=32, BEQ=33, LABEL_INSTRUCTION=34, JAL=35, 
		BRANCH=36, JR=37, HALT=38, UNDERSCORE=39, NUMBER=40, LABEL=41, REG=42, 
		WHITESP=43, LINECOMMENTS=44, ERR=45;
	public static final String[] tokenNames = {
		"<INVALID>", "'<-'", "'('", "')'", "':'", "'push'", "'pop'", "'top'", 
		"'li'", "'move'", "'lw'", "'sw'", "'lb'", "'sb'", "'add'", "'addi'", "'sub'", 
		"'subi'", "'mult'", "'multi'", "'div'", "'divi'", "'bgt'", "'bgeq'", "'bleq'", 
		"'blt'", "'bne'", "'and'", "'or'", "'not'", "'neg'", "'print'", "'ret'", 
		"'beq'", "'label'", "'jal'", "'branch'", "'jr'", "'halt'", "'_'", "NUMBER", 
		"LABEL", "REG", "WHITESP", "LINECOMMENTS", "ERR"
	};
	public static final int
		RULE_assembly = 0, RULE_instruction = 1, RULE_push = 2, RULE_pop = 3, 
		RULE_top = 4, RULE_li = 5, RULE_move = 6, RULE_lw = 7, RULE_sw = 8, RULE_lb = 9, 
		RULE_sb = 10, RULE_add = 11, RULE_addi = 12, RULE_sub = 13, RULE_subi = 14, 
		RULE_mult = 15, RULE_multi = 16, RULE_div = 17, RULE_divi = 18, RULE_bgt = 19, 
		RULE_bgeq = 20, RULE_bleq = 21, RULE_blt = 22, RULE_bne = 23, RULE_and = 24, 
		RULE_or = 25, RULE_not = 26, RULE_neg = 27, RULE_print = 28, RULE_ret = 29, 
		RULE_beq = 30, RULE_label = 31, RULE_jal = 32, RULE_branch = 33, RULE_jr = 34, 
		RULE_halt = 35;
	public static final String[] ruleNames = {
		"assembly", "instruction", "push", "pop", "top", "li", "move", "lw", "sw", 
		"lb", "sb", "add", "addi", "sub", "subi", "mult", "multi", "div", "divi", 
		"bgt", "bgeq", "bleq", "blt", "bne", "and", "or", "not", "neg", "print", 
		"ret", "beq", "label", "jal", "branch", "jr", "halt"
	};

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AssemblyContext extends ParserRuleContext {
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_assembly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSH) | (1L << POP) | (1L << LI) | (1L << MOVE) | (1L << LW) | (1L << SW) | (1L << LB) | (1L << SB) | (1L << ADD) | (1L << ADDI) | (1L << SUB) | (1L << SUBI) | (1L << MULT) | (1L << MULTI) | (1L << DIV) | (1L << DIVI) | (1L << BGT) | (1L << BGEQ) | (1L << BLEQ) | (1L << BLT) | (1L << BNE) | (1L << AND) | (1L << OR) | (1L << NOT) | (1L << NEG) | (1L << PRINT) | (1L << RET) | (1L << BEQ) | (1L << LABEL_INSTRUCTION) | (1L << JAL) | (1L << BRANCH) | (1L << JR) | (1L << HALT) | (1L << REG))) != 0)) {
				{
				{
				setState(72); instruction();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class InstructionContext extends ParserRuleContext {
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public PushContext push() {
			return getRuleContext(PushContext.class,0);
		}
		public TopContext top() {
			return getRuleContext(TopContext.class,0);
		}
		public LiContext li() {
			return getRuleContext(LiContext.class,0);
		}
		public LbContext lb() {
			return getRuleContext(LbContext.class,0);
		}
		public JalContext jal() {
			return getRuleContext(JalContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public BltContext blt() {
			return getRuleContext(BltContext.class,0);
		}
		public BeqContext beq() {
			return getRuleContext(BeqContext.class,0);
		}
		public MultiContext multi() {
			return getRuleContext(MultiContext.class,0);
		}
		public SubiContext subi() {
			return getRuleContext(SubiContext.class,0);
		}
		public SubContext sub() {
			return getRuleContext(SubContext.class,0);
		}
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public BneContext bne() {
			return getRuleContext(BneContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public SwContext sw() {
			return getRuleContext(SwContext.class,0);
		}
		public BleqContext bleq() {
			return getRuleContext(BleqContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public DiviContext divi() {
			return getRuleContext(DiviContext.class,0);
		}
		public BgtContext bgt() {
			return getRuleContext(BgtContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public JrContext jr() {
			return getRuleContext(JrContext.class,0);
		}
		public BgeqContext bgeq() {
			return getRuleContext(BgeqContext.class,0);
		}
		public SbContext sb() {
			return getRuleContext(SbContext.class,0);
		}
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public PopContext pop() {
			return getRuleContext(PopContext.class,0);
		}
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public HaltContext halt() {
			return getRuleContext(HaltContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public DivContext div() {
			return getRuleContext(DivContext.class,0);
		}
		public LwContext lw() {
			return getRuleContext(LwContext.class,0);
		}
		public AddiContext addi() {
			return getRuleContext(AddiContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			switch (_input.LA(1)) {
			case PUSH:
				{
				setState(78); push();
				}
				break;
			case POP:
				{
				setState(79); pop();
				}
				break;
			case REG:
				{
				setState(80); top();
				}
				break;
			case LI:
				{
				setState(81); li();
				}
				break;
			case MOVE:
				{
				setState(82); move();
				}
				break;
			case LW:
				{
				setState(83); lw();
				}
				break;
			case SW:
				{
				setState(84); sw();
				}
				break;
			case LB:
				{
				setState(85); lb();
				}
				break;
			case SB:
				{
				setState(86); sb();
				}
				break;
			case ADD:
				{
				setState(87); add();
				}
				break;
			case ADDI:
				{
				setState(88); addi();
				}
				break;
			case SUB:
				{
				setState(89); sub();
				}
				break;
			case SUBI:
				{
				setState(90); subi();
				}
				break;
			case MULT:
				{
				setState(91); mult();
				}
				break;
			case MULTI:
				{
				setState(92); multi();
				}
				break;
			case DIV:
				{
				setState(93); div();
				}
				break;
			case DIVI:
				{
				setState(94); divi();
				}
				break;
			case BGT:
				{
				setState(95); bgt();
				}
				break;
			case BGEQ:
				{
				setState(96); bgeq();
				}
				break;
			case BLEQ:
				{
				setState(97); bleq();
				}
				break;
			case BLT:
				{
				setState(98); blt();
				}
				break;
			case BNE:
				{
				setState(99); bne();
				}
				break;
			case AND:
				{
				setState(100); and();
				}
				break;
			case OR:
				{
				setState(101); or();
				}
				break;
			case NOT:
				{
				setState(102); not();
				}
				break;
			case NEG:
				{
				setState(103); neg();
				}
				break;
			case PRINT:
				{
				setState(104); print();
				}
				break;
			case RET:
				{
				setState(105); ret();
				}
				break;
			case BEQ:
				{
				setState(106); beq();
				}
				break;
			case LABEL_INSTRUCTION:
				{
				setState(107); label();
				}
				break;
			case JAL:
				{
				setState(108); jal();
				}
				break;
			case BRANCH:
				{
				setState(109); branch();
				}
				break;
			case JR:
				{
				setState(110); jr();
				}
				break;
			case HALT:
				{
				setState(111); halt();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PushContext extends ParserRuleContext {
		public Token src;
		public TerminalNode PUSH() { return getToken(SVMParser.PUSH, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PushContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_push; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPush(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PushContext push() throws RecognitionException {
		PushContext _localctx = new PushContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_push);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); match(PUSH);
			setState(115); ((PushContext)_localctx).src = match(REG);
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

	public static class PopContext extends ParserRuleContext {
		public TerminalNode POP() { return getToken(SVMParser.POP, 0); }
		public PopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PopContext pop() throws RecognitionException {
		PopContext _localctx = new PopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(POP);
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

	public static class TopContext extends ParserRuleContext {
		public Token destination;
		public TerminalNode TOP() { return getToken(SVMParser.TOP, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public TopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitTop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopContext top() throws RecognitionException {
		TopContext _localctx = new TopContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_top);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); ((TopContext)_localctx).destination = match(REG);
			setState(120); match(T__3);
			setState(121); match(TOP);
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

	public static class LiContext extends ParserRuleContext {
		public Token destination;
		public Token numbers;
		public TerminalNode LI() { return getToken(SVMParser.LI, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public LiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_li; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiContext li() throws RecognitionException {
		LiContext _localctx = new LiContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_li);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(LI);
			setState(124); ((LiContext)_localctx).destination = match(REG);
			setState(125); ((LiContext)_localctx).numbers = match(NUMBER);
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

	public static class MoveContext extends ParserRuleContext {
		public Token destination;
		public Token departure;
		public TerminalNode MOVE() { return getToken(SVMParser.MOVE, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public MoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_move; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoveContext move() throws RecognitionException {
		MoveContext _localctx = new MoveContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_move);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127); match(MOVE);
			setState(128); ((MoveContext)_localctx).destination = match(REG);
			setState(129); ((MoveContext)_localctx).departure = match(REG);
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

	public static class LwContext extends ParserRuleContext {
		public Token register1;
		public Token offset;
		public Token register2;
		public TerminalNode LW() { return getToken(SVMParser.LW, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public LwContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lw; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LwContext lw() throws RecognitionException {
		LwContext _localctx = new LwContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); match(LW);
			setState(132); ((LwContext)_localctx).register1 = match(REG);
			setState(133); ((LwContext)_localctx).offset = match(NUMBER);
			setState(134); match(T__2);
			setState(135); ((LwContext)_localctx).register2 = match(REG);
			setState(136); match(T__1);
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

	public static class SwContext extends ParserRuleContext {
		public Token register1;
		public Token offset;
		public Token register2;
		public TerminalNode SW() { return getToken(SVMParser.SW, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public SwContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sw; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitSw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwContext sw() throws RecognitionException {
		SwContext _localctx = new SwContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(SW);
			setState(139); ((SwContext)_localctx).register1 = match(REG);
			setState(140); ((SwContext)_localctx).offset = match(NUMBER);
			setState(141); match(T__2);
			setState(142); ((SwContext)_localctx).register2 = match(REG);
			setState(143); match(T__1);
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

	public static class LbContext extends ParserRuleContext {
		public Token register1;
		public Token offset;
		public Token register2;
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public TerminalNode LB() { return getToken(SVMParser.LB, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public LbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lb; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LbContext lb() throws RecognitionException {
		LbContext _localctx = new LbContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(LB);
			setState(146); ((LbContext)_localctx).register1 = match(REG);
			setState(147); ((LbContext)_localctx).offset = match(NUMBER);
			setState(148); match(T__2);
			setState(149); ((LbContext)_localctx).register2 = match(REG);
			setState(150); match(T__1);
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

	public static class SbContext extends ParserRuleContext {
		public Token register1;
		public Token offset;
		public Token register2;
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public TerminalNode SB() { return getToken(SVMParser.SB, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public SbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sb; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitSb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SbContext sb() throws RecognitionException {
		SbContext _localctx = new SbContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); match(SB);
			setState(153); ((SbContext)_localctx).register1 = match(REG);
			setState(154); ((SbContext)_localctx).offset = match(NUMBER);
			setState(155); match(T__2);
			setState(156); ((SbContext)_localctx).register2 = match(REG);
			setState(157); match(T__1);
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

	public static class AddContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token register2;
		public TerminalNode ADD() { return getToken(SVMParser.ADD, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(ADD);
			setState(160); ((AddContext)_localctx).destination = match(REG);
			setState(161); ((AddContext)_localctx).register1 = match(REG);
			setState(162); ((AddContext)_localctx).register2 = match(REG);
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

	public static class AddiContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token value;
		public TerminalNode ADDI() { return getToken(SVMParser.ADDI, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public AddiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addi; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAddi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddiContext addi() throws RecognitionException {
		AddiContext _localctx = new AddiContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_addi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); match(ADDI);
			setState(165); ((AddiContext)_localctx).destination = match(REG);
			setState(166); ((AddiContext)_localctx).register1 = match(REG);
			setState(167); ((AddiContext)_localctx).value = match(NUMBER);
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

	public static class SubContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token register2;
		public TerminalNode SUB() { return getToken(SVMParser.SUB, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public SubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubContext sub() throws RecognitionException {
		SubContext _localctx = new SubContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); match(SUB);
			setState(170); ((SubContext)_localctx).destination = match(REG);
			setState(171); ((SubContext)_localctx).register1 = match(REG);
			setState(172); ((SubContext)_localctx).register2 = match(REG);
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

	public static class SubiContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token value;
		public TerminalNode SUBI() { return getToken(SVMParser.SUBI, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public SubiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subi; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitSubi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubiContext subi() throws RecognitionException {
		SubiContext _localctx = new SubiContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_subi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(SUBI);
			setState(175); ((SubiContext)_localctx).destination = match(REG);
			setState(176); ((SubiContext)_localctx).register1 = match(REG);
			setState(177); ((SubiContext)_localctx).value = match(NUMBER);
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

	public static class MultContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token register2;
		public TerminalNode MULT() { return getToken(SVMParser.MULT, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mult);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); match(MULT);
			setState(180); ((MultContext)_localctx).destination = match(REG);
			setState(181); ((MultContext)_localctx).register1 = match(REG);
			setState(182); ((MultContext)_localctx).register2 = match(REG);
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

	public static class MultiContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token value;
		public TerminalNode MULTI() { return getToken(SVMParser.MULTI, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public MultiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitMulti(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiContext multi() throws RecognitionException {
		MultiContext _localctx = new MultiContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_multi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(MULTI);
			setState(185); ((MultiContext)_localctx).destination = match(REG);
			setState(186); ((MultiContext)_localctx).register1 = match(REG);
			setState(187); ((MultiContext)_localctx).value = match(NUMBER);
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

	public static class DivContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token register2;
		public TerminalNode DIV() { return getToken(SVMParser.DIV, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public DivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_div; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivContext div() throws RecognitionException {
		DivContext _localctx = new DivContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_div);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(DIV);
			setState(190); ((DivContext)_localctx).destination = match(REG);
			setState(191); ((DivContext)_localctx).register1 = match(REG);
			setState(192); ((DivContext)_localctx).register2 = match(REG);
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

	public static class DiviContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token value;
		public TerminalNode DIVI() { return getToken(SVMParser.DIVI, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public DiviContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divi; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitDivi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DiviContext divi() throws RecognitionException {
		DiviContext _localctx = new DiviContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_divi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194); match(DIVI);
			setState(195); ((DiviContext)_localctx).destination = match(REG);
			setState(196); ((DiviContext)_localctx).register1 = match(REG);
			setState(197); ((DiviContext)_localctx).value = match(NUMBER);
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

	public static class BgtContext extends ParserRuleContext {
		public Token register1;
		public Token register2;
		public Token namelab;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode BGT() { return getToken(SVMParser.BGT, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public BgtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bgt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBgt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BgtContext bgt() throws RecognitionException {
		BgtContext _localctx = new BgtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_bgt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(BGT);
			setState(200); ((BgtContext)_localctx).register1 = match(REG);
			setState(201); ((BgtContext)_localctx).register2 = match(REG);
			setState(202); ((BgtContext)_localctx).namelab = match(LABEL);
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

	public static class BgeqContext extends ParserRuleContext {
		public Token register1;
		public Token register2;
		public Token namelab;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode BGEQ() { return getToken(SVMParser.BGEQ, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public BgeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bgeq; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBgeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BgeqContext bgeq() throws RecognitionException {
		BgeqContext _localctx = new BgeqContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_bgeq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); match(BGEQ);
			setState(205); ((BgeqContext)_localctx).register1 = match(REG);
			setState(206); ((BgeqContext)_localctx).register2 = match(REG);
			setState(207); ((BgeqContext)_localctx).namelab = match(LABEL);
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

	public static class BleqContext extends ParserRuleContext {
		public Token register1;
		public Token register2;
		public Token namelab;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode BLEQ() { return getToken(SVMParser.BLEQ, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public BleqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bleq; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBleq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BleqContext bleq() throws RecognitionException {
		BleqContext _localctx = new BleqContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bleq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); match(BLEQ);
			setState(210); ((BleqContext)_localctx).register1 = match(REG);
			setState(211); ((BleqContext)_localctx).register2 = match(REG);
			setState(212); ((BleqContext)_localctx).namelab = match(LABEL);
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

	public static class BltContext extends ParserRuleContext {
		public Token register1;
		public Token register2;
		public Token namelab;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode BLT() { return getToken(SVMParser.BLT, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public BltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBlt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BltContext blt() throws RecognitionException {
		BltContext _localctx = new BltContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_blt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); match(BLT);
			setState(215); ((BltContext)_localctx).register1 = match(REG);
			setState(216); ((BltContext)_localctx).register2 = match(REG);
			setState(217); ((BltContext)_localctx).namelab = match(LABEL);
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

	public static class BneContext extends ParserRuleContext {
		public Token register1;
		public Token register2;
		public Token namelab;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode BNE() { return getToken(SVMParser.BNE, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public BneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bne; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BneContext bne() throws RecognitionException {
		BneContext _localctx = new BneContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_bne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); match(BNE);
			setState(220); ((BneContext)_localctx).register1 = match(REG);
			setState(221); ((BneContext)_localctx).register2 = match(REG);
			setState(222); ((BneContext)_localctx).namelab = match(LABEL);
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

	public static class AndContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token register2;
		public TerminalNode AND() { return getToken(SVMParser.AND, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); match(AND);
			setState(225); ((AndContext)_localctx).destination = match(REG);
			setState(226); ((AndContext)_localctx).register1 = match(REG);
			setState(227); ((AndContext)_localctx).register2 = match(REG);
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

	public static class OrContext extends ParserRuleContext {
		public Token destination;
		public Token register1;
		public Token register2;
		public TerminalNode OR() { return getToken(SVMParser.OR, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); match(OR);
			setState(230); ((OrContext)_localctx).destination = match(REG);
			setState(231); ((OrContext)_localctx).register1 = match(REG);
			setState(232); ((OrContext)_localctx).register2 = match(REG);
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

	public static class NotContext extends ParserRuleContext {
		public Token destination;
		public Token src;
		public TerminalNode NOT() { return getToken(SVMParser.NOT, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(NOT);
			setState(235); ((NotContext)_localctx).destination = match(REG);
			setState(236); ((NotContext)_localctx).src = match(REG);
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

	public static class NegContext extends ParserRuleContext {
		public Token destination;
		public Token src;
		public TerminalNode NEG() { return getToken(SVMParser.NEG, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public NegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitNeg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegContext neg() throws RecognitionException {
		NegContext _localctx = new NegContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_neg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); match(NEG);
			setState(239); ((NegContext)_localctx).destination = match(REG);
			setState(240); ((NegContext)_localctx).src = match(REG);
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
		public Token src;
		public TerminalNode PRINT() { return getToken(SVMParser.PRINT, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242); match(PRINT);
			setState(243); ((PrintContext)_localctx).src = match(REG);
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
		public Token src;
		public TerminalNode RET() { return getToken(SVMParser.RET, 0); }
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245); match(RET);
			setState(246); ((RetContext)_localctx).src = match(REG);
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

	public static class BeqContext extends ParserRuleContext {
		public Token register1;
		public Token register2;
		public Token namelab;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode BEQ() { return getToken(SVMParser.BEQ, 0); }
		public List<TerminalNode> REG() { return getTokens(SVMParser.REG); }
		public TerminalNode REG(int i) {
			return getToken(SVMParser.REG, i);
		}
		public BeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beq; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeqContext beq() throws RecognitionException {
		BeqContext _localctx = new BeqContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_beq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248); match(BEQ);
			setState(249); ((BeqContext)_localctx).register1 = match(REG);
			setState(250); ((BeqContext)_localctx).register2 = match(REG);
			setState(251); ((BeqContext)_localctx).namelab = match(LABEL);
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

	public static class LabelContext extends ParserRuleContext {
		public Token namelab;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode LABEL_INSTRUCTION() { return getToken(SVMParser.LABEL_INSTRUCTION, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); match(LABEL_INSTRUCTION);
			setState(254); ((LabelContext)_localctx).namelab = match(LABEL);
			setState(255); match(T__0);
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

	public static class JalContext extends ParserRuleContext {
		public Token namelab;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode JAL() { return getToken(SVMParser.JAL, 0); }
		public JalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitJal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JalContext jal() throws RecognitionException {
		JalContext _localctx = new JalContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_jal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(JAL);
			setState(258); ((JalContext)_localctx).namelab = match(LABEL);
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

	public static class BranchContext extends ParserRuleContext {
		public Token namelab;
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode BRANCH() { return getToken(SVMParser.BRANCH, 0); }
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_branch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); match(BRANCH);
			setState(261); ((BranchContext)_localctx).namelab = match(LABEL);
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

	public static class JrContext extends ParserRuleContext {
		public Token destination;
		public TerminalNode REG() { return getToken(SVMParser.REG, 0); }
		public TerminalNode JR() { return getToken(SVMParser.JR, 0); }
		public JrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitJr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JrContext jr() throws RecognitionException {
		JrContext _localctx = new JrContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_jr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); match(JR);
			setState(264); ((JrContext)_localctx).destination = match(REG);
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

	public static class HaltContext extends ParserRuleContext {
		public TerminalNode HALT() { return getToken(SVMParser.HALT, 0); }
		public HaltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_halt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitHalt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HaltContext halt() throws RecognitionException {
		HaltContext _localctx = new HaltContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_halt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(HALT);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u010f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\7\2L\n\2\f\2\16\2O\13\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3s\n\3\3\4\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\2\2&\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\2\u010c"+
		"\2M\3\2\2\2\4r\3\2\2\2\6t\3\2\2\2\bw\3\2\2\2\ny\3\2\2\2\f}\3\2\2\2\16"+
		"\u0081\3\2\2\2\20\u0085\3\2\2\2\22\u008c\3\2\2\2\24\u0093\3\2\2\2\26\u009a"+
		"\3\2\2\2\30\u00a1\3\2\2\2\32\u00a6\3\2\2\2\34\u00ab\3\2\2\2\36\u00b0\3"+
		"\2\2\2 \u00b5\3\2\2\2\"\u00ba\3\2\2\2$\u00bf\3\2\2\2&\u00c4\3\2\2\2(\u00c9"+
		"\3\2\2\2*\u00ce\3\2\2\2,\u00d3\3\2\2\2.\u00d8\3\2\2\2\60\u00dd\3\2\2\2"+
		"\62\u00e2\3\2\2\2\64\u00e7\3\2\2\2\66\u00ec\3\2\2\28\u00f0\3\2\2\2:\u00f4"+
		"\3\2\2\2<\u00f7\3\2\2\2>\u00fa\3\2\2\2@\u00ff\3\2\2\2B\u0103\3\2\2\2D"+
		"\u0106\3\2\2\2F\u0109\3\2\2\2H\u010c\3\2\2\2JL\5\4\3\2KJ\3\2\2\2LO\3\2"+
		"\2\2MK\3\2\2\2MN\3\2\2\2N\3\3\2\2\2OM\3\2\2\2Ps\5\6\4\2Qs\5\b\5\2Rs\5"+
		"\n\6\2Ss\5\f\7\2Ts\5\16\b\2Us\5\20\t\2Vs\5\22\n\2Ws\5\24\13\2Xs\5\26\f"+
		"\2Ys\5\30\r\2Zs\5\32\16\2[s\5\34\17\2\\s\5\36\20\2]s\5 \21\2^s\5\"\22"+
		"\2_s\5$\23\2`s\5&\24\2as\5(\25\2bs\5*\26\2cs\5,\27\2ds\5.\30\2es\5\60"+
		"\31\2fs\5\62\32\2gs\5\64\33\2hs\5\66\34\2is\58\35\2js\5:\36\2ks\5<\37"+
		"\2ls\5> \2ms\5@!\2ns\5B\"\2os\5D#\2ps\5F$\2qs\5H%\2rP\3\2\2\2rQ\3\2\2"+
		"\2rR\3\2\2\2rS\3\2\2\2rT\3\2\2\2rU\3\2\2\2rV\3\2\2\2rW\3\2\2\2rX\3\2\2"+
		"\2rY\3\2\2\2rZ\3\2\2\2r[\3\2\2\2r\\\3\2\2\2r]\3\2\2\2r^\3\2\2\2r_\3\2"+
		"\2\2r`\3\2\2\2ra\3\2\2\2rb\3\2\2\2rc\3\2\2\2rd\3\2\2\2re\3\2\2\2rf\3\2"+
		"\2\2rg\3\2\2\2rh\3\2\2\2ri\3\2\2\2rj\3\2\2\2rk\3\2\2\2rl\3\2\2\2rm\3\2"+
		"\2\2rn\3\2\2\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2s\5\3\2\2\2tu\7\7\2\2uv\7"+
		",\2\2v\7\3\2\2\2wx\7\b\2\2x\t\3\2\2\2yz\7,\2\2z{\7\3\2\2{|\7\t\2\2|\13"+
		"\3\2\2\2}~\7\n\2\2~\177\7,\2\2\177\u0080\7*\2\2\u0080\r\3\2\2\2\u0081"+
		"\u0082\7\13\2\2\u0082\u0083\7,\2\2\u0083\u0084\7,\2\2\u0084\17\3\2\2\2"+
		"\u0085\u0086\7\f\2\2\u0086\u0087\7,\2\2\u0087\u0088\7*\2\2\u0088\u0089"+
		"\7\4\2\2\u0089\u008a\7,\2\2\u008a\u008b\7\5\2\2\u008b\21\3\2\2\2\u008c"+
		"\u008d\7\r\2\2\u008d\u008e\7,\2\2\u008e\u008f\7*\2\2\u008f\u0090\7\4\2"+
		"\2\u0090\u0091\7,\2\2\u0091\u0092\7\5\2\2\u0092\23\3\2\2\2\u0093\u0094"+
		"\7\16\2\2\u0094\u0095\7,\2\2\u0095\u0096\7*\2\2\u0096\u0097\7\4\2\2\u0097"+
		"\u0098\7,\2\2\u0098\u0099\7\5\2\2\u0099\25\3\2\2\2\u009a\u009b\7\17\2"+
		"\2\u009b\u009c\7,\2\2\u009c\u009d\7*\2\2\u009d\u009e\7\4\2\2\u009e\u009f"+
		"\7,\2\2\u009f\u00a0\7\5\2\2\u00a0\27\3\2\2\2\u00a1\u00a2\7\20\2\2\u00a2"+
		"\u00a3\7,\2\2\u00a3\u00a4\7,\2\2\u00a4\u00a5\7,\2\2\u00a5\31\3\2\2\2\u00a6"+
		"\u00a7\7\21\2\2\u00a7\u00a8\7,\2\2\u00a8\u00a9\7,\2\2\u00a9\u00aa\7*\2"+
		"\2\u00aa\33\3\2\2\2\u00ab\u00ac\7\22\2\2\u00ac\u00ad\7,\2\2\u00ad\u00ae"+
		"\7,\2\2\u00ae\u00af\7,\2\2\u00af\35\3\2\2\2\u00b0\u00b1\7\23\2\2\u00b1"+
		"\u00b2\7,\2\2\u00b2\u00b3\7,\2\2\u00b3\u00b4\7*\2\2\u00b4\37\3\2\2\2\u00b5"+
		"\u00b6\7\24\2\2\u00b6\u00b7\7,\2\2\u00b7\u00b8\7,\2\2\u00b8\u00b9\7,\2"+
		"\2\u00b9!\3\2\2\2\u00ba\u00bb\7\25\2\2\u00bb\u00bc\7,\2\2\u00bc\u00bd"+
		"\7,\2\2\u00bd\u00be\7*\2\2\u00be#\3\2\2\2\u00bf\u00c0\7\26\2\2\u00c0\u00c1"+
		"\7,\2\2\u00c1\u00c2\7,\2\2\u00c2\u00c3\7,\2\2\u00c3%\3\2\2\2\u00c4\u00c5"+
		"\7\27\2\2\u00c5\u00c6\7,\2\2\u00c6\u00c7\7,\2\2\u00c7\u00c8\7*\2\2\u00c8"+
		"\'\3\2\2\2\u00c9\u00ca\7\30\2\2\u00ca\u00cb\7,\2\2\u00cb\u00cc\7,\2\2"+
		"\u00cc\u00cd\7+\2\2\u00cd)\3\2\2\2\u00ce\u00cf\7\31\2\2\u00cf\u00d0\7"+
		",\2\2\u00d0\u00d1\7,\2\2\u00d1\u00d2\7+\2\2\u00d2+\3\2\2\2\u00d3\u00d4"+
		"\7\32\2\2\u00d4\u00d5\7,\2\2\u00d5\u00d6\7,\2\2\u00d6\u00d7\7+\2\2\u00d7"+
		"-\3\2\2\2\u00d8\u00d9\7\33\2\2\u00d9\u00da\7,\2\2\u00da\u00db\7,\2\2\u00db"+
		"\u00dc\7+\2\2\u00dc/\3\2\2\2\u00dd\u00de\7\34\2\2\u00de\u00df\7,\2\2\u00df"+
		"\u00e0\7,\2\2\u00e0\u00e1\7+\2\2\u00e1\61\3\2\2\2\u00e2\u00e3\7\35\2\2"+
		"\u00e3\u00e4\7,\2\2\u00e4\u00e5\7,\2\2\u00e5\u00e6\7,\2\2\u00e6\63\3\2"+
		"\2\2\u00e7\u00e8\7\36\2\2\u00e8\u00e9\7,\2\2\u00e9\u00ea\7,\2\2\u00ea"+
		"\u00eb\7,\2\2\u00eb\65\3\2\2\2\u00ec\u00ed\7\37\2\2\u00ed\u00ee\7,\2\2"+
		"\u00ee\u00ef\7,\2\2\u00ef\67\3\2\2\2\u00f0\u00f1\7 \2\2\u00f1\u00f2\7"+
		",\2\2\u00f2\u00f3\7,\2\2\u00f39\3\2\2\2\u00f4\u00f5\7!\2\2\u00f5\u00f6"+
		"\7,\2\2\u00f6;\3\2\2\2\u00f7\u00f8\7\"\2\2\u00f8\u00f9\7,\2\2\u00f9=\3"+
		"\2\2\2\u00fa\u00fb\7#\2\2\u00fb\u00fc\7,\2\2\u00fc\u00fd\7,\2\2\u00fd"+
		"\u00fe\7+\2\2\u00fe?\3\2\2\2\u00ff\u0100\7$\2\2\u0100\u0101\7+\2\2\u0101"+
		"\u0102\7\6\2\2\u0102A\3\2\2\2\u0103\u0104\7%\2\2\u0104\u0105\7+\2\2\u0105"+
		"C\3\2\2\2\u0106\u0107\7&\2\2\u0107\u0108\7+\2\2\u0108E\3\2\2\2\u0109\u010a"+
		"\7\'\2\2\u010a\u010b\7,\2\2\u010bG\3\2\2\2\u010c\u010d\7(\2\2\u010dI\3"+
		"\2\2\2\4Mr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}