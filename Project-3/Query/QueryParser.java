// Generated from src/parser/Query.g4 by ANTLR 4.7
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
public class QueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	public static final int
			T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9,
			T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17,
			T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24,
			T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31,
			T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, Null=38, Identifier=39,
			Varchar=40, Alpha=41, Integer=42, Digit=43, WS=44;
	public static final int
			RULE_query = 0, RULE_relation_name = 1, RULE_expr = 2, RULE_atomic_expr = 3,
			RULE_selection = 4, RULE_condition = 5, RULE_conjunction = 6, RULE_comparison = 7,
			RULE_op = 8, RULE_operand = 9, RULE_attribute_name = 10, RULE_literal = 11,
			RULE_projection = 12, RULE_attribute_list = 13, RULE_renaming = 14, RULE_union = 15,
			RULE_difference = 16, RULE_product = 17, RULE_natural_join = 18, RULE_command = 19,
			RULE_open_cmd = 20, RULE_close_cmd = 21, RULE_write_cmd = 22, RULE_exit_cmd = 23,
			RULE_show_cmd = 24, RULE_create_cmd = 25, RULE_update_cmd = 26, RULE_insert_cmd = 27,
			RULE_delete_cmd = 28, RULE_typed_attribute_list = 29, RULE_type = 30,
			RULE_program = 31;
	public static final String[] ruleNames = {
			"query", "relation_name", "expr", "atomic_expr", "selection", "condition",
			"conjunction", "comparison", "op", "operand", "attribute_name", "literal",
			"projection", "attribute_list", "renaming", "union", "difference", "product",
			"natural_join", "command", "open_cmd", "close_cmd", "write_cmd", "exit_cmd",
			"show_cmd", "create_cmd", "update_cmd", "insert_cmd", "delete_cmd", "typed_attribute_list",
			"type", "program"
	};

	private static final String[] _LITERAL_NAMES = {
			null, "'<-'", "';'", "'('", "')'", "'select'", "'||'", "'&&'", "'=='",
			"'!='", "'<'", "'>'", "'<='", "'>='", "'project'", "','", "'rename'",
			"'+'", "'-'", "'*'", "'&'", "'OPEN'", "'CLOSE'", "'WRITE'", "'EXIT'",
			"'SHOW'", "'CREATE TABLE'", "'PRIMARY KEY'", "'UPDATE'", "'SET'", "'='",
			"'WHERE'", "'INSERT INTO'", "'VALUES FROM'", "'VALUES FROM RELATION'",
			"'DELETE FROM'", "'VARCHAR'", "'INTEGER'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, "Null", "Identifier", "Varchar", "Alpha", "Integer", "Digit",
			"WS"
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
	public String getGrammarFileName() { return "Query.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(64);
				relation_name();
				setState(65);
				match(T__0);
				setState(66);
				expr();
				setState(67);
				match(T__1);
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

	public static class Relation_nameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QueryParser.Identifier, 0); }
		public Relation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitRelation_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relation_nameContext relation_name() throws RecognitionException {
		Relation_nameContext _localctx = new Relation_nameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_relation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(69);
				match(Identifier);
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

	public static class ExprContext extends ParserRuleContext {
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public ProjectionContext projection() {
			return getRuleContext(ProjectionContext.class,0);
		}
		public RenamingContext renaming() {
			return getRuleContext(RenamingContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public DifferenceContext difference() {
			return getRuleContext(DifferenceContext.class,0);
		}
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public Natural_joinContext natural_join() {
			return getRuleContext(Natural_joinContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(79);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
					{
						setState(71);
						atomic_expr();
					}
					break;
					case 2:
					{
						setState(72);
						selection();
					}
					break;
					case 3:
					{
						setState(73);
						projection();
					}
					break;
					case 4:
					{
						setState(74);
						renaming();
					}
					break;
					case 5:
					{
						setState(75);
						union();
					}
					break;
					case 6:
					{
						setState(76);
						difference();
					}
					break;
					case 7:
					{
						setState(77);
						product();
					}
					break;
					case 8:
					{
						setState(78);
						natural_join();
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

	public static class Atomic_exprContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Atomic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitAtomic_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atomic_exprContext atomic_expr() throws RecognitionException {
		Atomic_exprContext _localctx = new Atomic_exprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atomic_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(86);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
					case Identifier:
					{
						setState(81);
						relation_name();
					}
					break;
					case T__2:
					{
						setState(82);
						match(T__2);
						setState(83);
						expr();
						setState(84);
						match(T__3);
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

	public static class SelectionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(88);
				match(T__4);
				setState(89);
				match(T__2);
				setState(90);
				condition();
				setState(91);
				match(T__3);
				setState(92);
				atomic_expr();
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(94);
				conjunction();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
						{
							setState(95);
							match(T__5);
							setState(96);
							conjunction();
						}
					}
					setState(101);
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

	public static class ConjunctionContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(102);
				comparison();
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
						{
							setState(103);
							match(T__6);
							setState(104);
							comparison();
						}
					}
					setState(109);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(118);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
					case Null:
					case Identifier:
					case Varchar:
					case Integer:
					{
						setState(110);
						operand();
						setState(111);
						op();
						setState(112);
						operand();
					}
					break;
					case T__2:
					{
						setState(114);
						match(T__2);
						setState(115);
						condition();
						setState(116);
						match(T__3);
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

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(120);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
					_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
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

	public static class OperandContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QueryParser.Identifier, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(124);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
					case Identifier:
					{
						setState(122);
						match(Identifier);
					}
					break;
					case Null:
					case Varchar:
					case Integer:
					{
						setState(123);
						literal();
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

	public static class Attribute_nameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(QueryParser.Identifier, 0); }
		public Attribute_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitAttribute_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribute_nameContext attribute_name() throws RecognitionException {
		Attribute_nameContext _localctx = new Attribute_nameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attribute_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(126);
				match(Identifier);
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode Null() { return getToken(QueryParser.Null, 0); }
		public TerminalNode Integer() { return getToken(QueryParser.Integer, 0); }
		public TerminalNode Varchar() { return getToken(QueryParser.Varchar, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(128);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Varchar) | (1L << Integer))) != 0)) ) {
					_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
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

	public static class ProjectionContext extends ParserRuleContext {
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public ProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectionContext projection() throws RecognitionException {
		ProjectionContext _localctx = new ProjectionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(130);
				match(T__13);
				setState(131);
				match(T__2);
				setState(132);
				attribute_list();
				setState(133);
				match(T__3);
				setState(134);
				atomic_expr();
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

	public static class Attribute_listContext extends ParserRuleContext {
		public List<Attribute_nameContext> attribute_name() {
			return getRuleContexts(Attribute_nameContext.class);
		}
		public Attribute_nameContext attribute_name(int i) {
			return getRuleContext(Attribute_nameContext.class,i);
		}
		public Attribute_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitAttribute_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribute_listContext attribute_list() throws RecognitionException {
		Attribute_listContext _localctx = new Attribute_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_attribute_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(136);
				attribute_name();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
						{
							setState(137);
							match(T__14);
							setState(138);
							attribute_name();
						}
					}
					setState(143);
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

	public static class RenamingContext extends ParserRuleContext {
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public RenamingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renaming; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitRenaming(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenamingContext renaming() throws RecognitionException {
		RenamingContext _localctx = new RenamingContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_renaming);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(144);
				match(T__15);
				setState(145);
				match(T__2);
				setState(146);
				attribute_list();
				setState(147);
				match(T__3);
				setState(148);
				atomic_expr();
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

	public static class UnionContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(150);
				atomic_expr();
				setState(151);
				match(T__16);
				setState(152);
				atomic_expr();
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

	public static class DifferenceContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public DifferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DifferenceContext difference() throws RecognitionException {
		DifferenceContext _localctx = new DifferenceContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_difference);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(154);
				atomic_expr();
				setState(155);
				match(T__17);
				setState(156);
				atomic_expr();
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

	public static class ProductContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_product);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(158);
				atomic_expr();
				setState(159);
				match(T__18);
				setState(160);
				atomic_expr();
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

	public static class Natural_joinContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public Natural_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_natural_join; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitNatural_join(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Natural_joinContext natural_join() throws RecognitionException {
		Natural_joinContext _localctx = new Natural_joinContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_natural_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(162);
				atomic_expr();
				setState(163);
				match(T__19);
				setState(164);
				atomic_expr();
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

	public static class CommandContext extends ParserRuleContext {
		public Open_cmdContext open_cmd() {
			return getRuleContext(Open_cmdContext.class,0);
		}
		public Close_cmdContext close_cmd() {
			return getRuleContext(Close_cmdContext.class,0);
		}
		public Write_cmdContext write_cmd() {
			return getRuleContext(Write_cmdContext.class,0);
		}
		public Exit_cmdContext exit_cmd() {
			return getRuleContext(Exit_cmdContext.class,0);
		}
		public Show_cmdContext show_cmd() {
			return getRuleContext(Show_cmdContext.class,0);
		}
		public Create_cmdContext create_cmd() {
			return getRuleContext(Create_cmdContext.class,0);
		}
		public Update_cmdContext update_cmd() {
			return getRuleContext(Update_cmdContext.class,0);
		}
		public Insert_cmdContext insert_cmd() {
			return getRuleContext(Insert_cmdContext.class,0);
		}
		public Delete_cmdContext delete_cmd() {
			return getRuleContext(Delete_cmdContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(175);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
					case T__20:
					{
						setState(166);
						open_cmd();
					}
					break;
					case T__21:
					{
						setState(167);
						close_cmd();
					}
					break;
					case T__22:
					{
						setState(168);
						write_cmd();
					}
					break;
					case T__23:
					{
						setState(169);
						exit_cmd();
					}
					break;
					case T__24:
					{
						setState(170);
						show_cmd();
					}
					break;
					case T__25:
					{
						setState(171);
						create_cmd();
					}
					break;
					case T__27:
					{
						setState(172);
						update_cmd();
					}
					break;
					case T__31:
					{
						setState(173);
						insert_cmd();
					}
					break;
					case T__34:
					{
						setState(174);
						delete_cmd();
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

	public static class Open_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Open_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitOpen_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Open_cmdContext open_cmd() throws RecognitionException {
		Open_cmdContext _localctx = new Open_cmdContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_open_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(177);
				match(T__20);
				setState(178);
				relation_name();
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

	public static class Close_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Close_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_close_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitClose_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Close_cmdContext close_cmd() throws RecognitionException {
		Close_cmdContext _localctx = new Close_cmdContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_close_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(180);
				match(T__21);
				setState(181);
				relation_name();
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

	public static class Write_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Write_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitWrite_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Write_cmdContext write_cmd() throws RecognitionException {
		Write_cmdContext _localctx = new Write_cmdContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_write_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(183);
				match(T__22);
				setState(184);
				relation_name();
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

	public static class Exit_cmdContext extends ParserRuleContext {
		public Exit_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitExit_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exit_cmdContext exit_cmd() throws RecognitionException {
		Exit_cmdContext _localctx = new Exit_cmdContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_exit_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(186);
				match(T__23);
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

	public static class Show_cmdContext extends ParserRuleContext {
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public Show_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitShow_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_cmdContext show_cmd() throws RecognitionException {
		Show_cmdContext _localctx = new Show_cmdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_show_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(188);
				match(T__24);
				setState(189);
				atomic_expr();
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

	public static class Create_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Typed_attribute_listContext typed_attribute_list() {
			return getRuleContext(Typed_attribute_listContext.class,0);
		}
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Create_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitCreate_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_cmdContext create_cmd() throws RecognitionException {
		Create_cmdContext _localctx = new Create_cmdContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_create_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(191);
				match(T__25);
				setState(192);
				relation_name();
				setState(193);
				match(T__2);
				setState(194);
				typed_attribute_list();
				setState(195);
				match(T__3);
				setState(196);
				match(T__26);
				setState(197);
				match(T__2);
				setState(198);
				attribute_list();
				setState(199);
				match(T__3);
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

	public static class Update_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public List<Attribute_nameContext> attribute_name() {
			return getRuleContexts(Attribute_nameContext.class);
		}
		public Attribute_nameContext attribute_name(int i) {
			return getRuleContext(Attribute_nameContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Update_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitUpdate_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_cmdContext update_cmd() throws RecognitionException {
		Update_cmdContext _localctx = new Update_cmdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_update_cmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(201);
				match(T__27);
				setState(202);
				relation_name();
				setState(203);
				match(T__28);
				setState(204);
				attribute_name();
				setState(205);
				match(T__29);
				setState(206);
				literal();
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
						{
							setState(207);
							match(T__14);
							setState(208);
							attribute_name();
							setState(209);
							match(T__29);
							setState(210);
							literal();
						}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(217);
				match(T__30);
				setState(218);
				condition();
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

	public static class Insert_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Insert_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitInsert_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_cmdContext insert_cmd() throws RecognitionException {
		Insert_cmdContext _localctx = new Insert_cmdContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_insert_cmd);
		int _la;
		try {
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(220);
					match(T__31);
					setState(221);
					relation_name();
					setState(222);
					match(T__32);
					setState(223);
					match(T__2);
					setState(224);
					literal();
					setState(229);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__14) {
						{
							{
								setState(225);
								match(T__14);
								setState(226);
								literal();
							}
						}
						setState(231);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(232);
					match(T__3);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(234);
					match(T__31);
					setState(235);
					relation_name();
					setState(236);
					match(T__33);
					setState(237);
					expr();
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

	public static class Delete_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Delete_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_cmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitDelete_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_cmdContext delete_cmd() throws RecognitionException {
		Delete_cmdContext _localctx = new Delete_cmdContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_delete_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(241);
				match(T__34);
				setState(242);
				relation_name();
				setState(243);
				match(T__30);
				setState(244);
				condition();
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

	public static class Typed_attribute_listContext extends ParserRuleContext {
		public List<Attribute_nameContext> attribute_name() {
			return getRuleContexts(Attribute_nameContext.class);
		}
		public Attribute_nameContext attribute_name(int i) {
			return getRuleContext(Attribute_nameContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public Typed_attribute_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typed_attribute_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitTyped_attribute_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Typed_attribute_listContext typed_attribute_list() throws RecognitionException {
		Typed_attribute_listContext _localctx = new Typed_attribute_listContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_typed_attribute_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(246);
				attribute_name();
				setState(247);
				type();
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
						{
							setState(248);
							match(T__14);
							setState(249);
							attribute_name();
							setState(250);
							type();
						}
					}
					setState(256);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Integer() { return getToken(QueryParser.Integer, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_type);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__35:
					enterOuterAlt(_localctx, 1);
				{
					setState(257);
					match(T__35);
					setState(258);
					match(T__2);
					setState(259);
					match(Integer);
					setState(260);
					match(T__3);
				}
				break;
				case T__36:
					enterOuterAlt(_localctx, 2);
				{
					setState(261);
					match(T__36);
				}
				break;
				default:
					throw new NoViableAltException(this);
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

	public static class ProgramContext extends ParserRuleContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QueryVisitor ) return ((QueryVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__31) | (1L << T__34) | (1L << Identifier))) != 0)) {
					{
						setState(266);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
							case Identifier:
							{
								setState(264);
								query();
							}
							break;
							case T__20:
							case T__21:
							case T__22:
							case T__23:
							case T__24:
							case T__25:
							case T__27:
							case T__31:
							case T__34:
							{
								setState(265);
								command();
							}
							break;
							default:
								throw new NoViableAltException(this);
						}
					}
					setState(270);
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

	public static final String _serializedATN =
			"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0112\4\2\t\2\4"+
					"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
					"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
					"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
					"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
					"\t!\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4R\n"+
					"\4\3\5\3\5\3\5\3\5\3\5\5\5Y\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7"+
					"\7d\n\7\f\7\16\7g\13\7\3\b\3\b\3\b\7\bl\n\b\f\b\16\bo\13\b\3\t\3\t\3\t"+
					"\3\t\3\t\3\t\3\t\3\t\5\ty\n\t\3\n\3\n\3\13\3\13\5\13\177\n\13\3\f\3\f"+
					"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u008e\n\17"+
					"\f\17\16\17\u0091\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
					"\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3"+
					"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00b2\n\25\3\26\3\26\3\26"+
					"\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
					"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
					"\3\34\3\34\3\34\3\34\7\34\u00d7\n\34\f\34\16\34\u00da\13\34\3\34\3\34"+
					"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u00e6\n\35\f\35\16\35\u00e9"+
					"\13\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00f2\n\35\3\36\3\36\3"+
					"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u00ff\n\37\f\37\16\37"+
					"\u0102\13\37\3 \3 \3 \3 \3 \5 \u0109\n \3!\3!\7!\u010d\n!\f!\16!\u0110"+
					"\13!\3!\2\2\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
					"\668:<>@\2\4\3\2\n\17\5\2((**,,\2\u010d\2B\3\2\2\2\4G\3\2\2\2\6Q\3\2\2"+
					"\2\bX\3\2\2\2\nZ\3\2\2\2\f`\3\2\2\2\16h\3\2\2\2\20x\3\2\2\2\22z\3\2\2"+
					"\2\24~\3\2\2\2\26\u0080\3\2\2\2\30\u0082\3\2\2\2\32\u0084\3\2\2\2\34\u008a"+
					"\3\2\2\2\36\u0092\3\2\2\2 \u0098\3\2\2\2\"\u009c\3\2\2\2$\u00a0\3\2\2"+
					"\2&\u00a4\3\2\2\2(\u00b1\3\2\2\2*\u00b3\3\2\2\2,\u00b6\3\2\2\2.\u00b9"+
					"\3\2\2\2\60\u00bc\3\2\2\2\62\u00be\3\2\2\2\64\u00c1\3\2\2\2\66\u00cb\3"+
					"\2\2\28\u00f1\3\2\2\2:\u00f3\3\2\2\2<\u00f8\3\2\2\2>\u0108\3\2\2\2@\u010e"+
					"\3\2\2\2BC\5\4\3\2CD\7\3\2\2DE\5\6\4\2EF\7\4\2\2F\3\3\2\2\2GH\7)\2\2H"+
					"\5\3\2\2\2IR\5\b\5\2JR\5\n\6\2KR\5\32\16\2LR\5\36\20\2MR\5 \21\2NR\5\""+
					"\22\2OR\5$\23\2PR\5&\24\2QI\3\2\2\2QJ\3\2\2\2QK\3\2\2\2QL\3\2\2\2QM\3"+
					"\2\2\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\7\3\2\2\2SY\5\4\3\2TU\7\5\2\2UV"+
					"\5\6\4\2VW\7\6\2\2WY\3\2\2\2XS\3\2\2\2XT\3\2\2\2Y\t\3\2\2\2Z[\7\7\2\2"+
					"[\\\7\5\2\2\\]\5\f\7\2]^\7\6\2\2^_\5\b\5\2_\13\3\2\2\2`e\5\16\b\2ab\7"+
					"\b\2\2bd\5\16\b\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\r\3\2\2\2g"+
					"e\3\2\2\2hm\5\20\t\2ij\7\t\2\2jl\5\20\t\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2"+
					"\2mn\3\2\2\2n\17\3\2\2\2om\3\2\2\2pq\5\24\13\2qr\5\22\n\2rs\5\24\13\2"+
					"sy\3\2\2\2tu\7\5\2\2uv\5\f\7\2vw\7\6\2\2wy\3\2\2\2xp\3\2\2\2xt\3\2\2\2"+
					"y\21\3\2\2\2z{\t\2\2\2{\23\3\2\2\2|\177\7)\2\2}\177\5\30\r\2~|\3\2\2\2"+
					"~}\3\2\2\2\177\25\3\2\2\2\u0080\u0081\7)\2\2\u0081\27\3\2\2\2\u0082\u0083"+
					"\t\3\2\2\u0083\31\3\2\2\2\u0084\u0085\7\20\2\2\u0085\u0086\7\5\2\2\u0086"+
					"\u0087\5\34\17\2\u0087\u0088\7\6\2\2\u0088\u0089\5\b\5\2\u0089\33\3\2"+
					"\2\2\u008a\u008f\5\26\f\2\u008b\u008c\7\21\2\2\u008c\u008e\5\26\f\2\u008d"+
					"\u008b\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
					"\2\2\u0090\35\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\22\2\2\u0093\u0094"+
					"\7\5\2\2\u0094\u0095\5\34\17\2\u0095\u0096\7\6\2\2\u0096\u0097\5\b\5\2"+
					"\u0097\37\3\2\2\2\u0098\u0099\5\b\5\2\u0099\u009a\7\23\2\2\u009a\u009b"+
					"\5\b\5\2\u009b!\3\2\2\2\u009c\u009d\5\b\5\2\u009d\u009e\7\24\2\2\u009e"+
					"\u009f\5\b\5\2\u009f#\3\2\2\2\u00a0\u00a1\5\b\5\2\u00a1\u00a2\7\25\2\2"+
					"\u00a2\u00a3\5\b\5\2\u00a3%\3\2\2\2\u00a4\u00a5\5\b\5\2\u00a5\u00a6\7"+
					"\26\2\2\u00a6\u00a7\5\b\5\2\u00a7\'\3\2\2\2\u00a8\u00b2\5*\26\2\u00a9"+
					"\u00b2\5,\27\2\u00aa\u00b2\5.\30\2\u00ab\u00b2\5\60\31\2\u00ac\u00b2\5"+
					"\62\32\2\u00ad\u00b2\5\64\33\2\u00ae\u00b2\5\66\34\2\u00af\u00b2\58\35"+
					"\2\u00b0\u00b2\5:\36\2\u00b1\u00a8\3\2\2\2\u00b1\u00a9\3\2\2\2\u00b1\u00aa"+
					"\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1"+
					"\u00ae\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2)\3\2\2\2"+
					"\u00b3\u00b4\7\27\2\2\u00b4\u00b5\5\4\3\2\u00b5+\3\2\2\2\u00b6\u00b7\7"+
					"\30\2\2\u00b7\u00b8\5\4\3\2\u00b8-\3\2\2\2\u00b9\u00ba\7\31\2\2\u00ba"+
					"\u00bb\5\4\3\2\u00bb/\3\2\2\2\u00bc\u00bd\7\32\2\2\u00bd\61\3\2\2\2\u00be"+
					"\u00bf\7\33\2\2\u00bf\u00c0\5\b\5\2\u00c0\63\3\2\2\2\u00c1\u00c2\7\34"+
					"\2\2\u00c2\u00c3\5\4\3\2\u00c3\u00c4\7\5\2\2\u00c4\u00c5\5<\37\2\u00c5"+
					"\u00c6\7\6\2\2\u00c6\u00c7\7\35\2\2\u00c7\u00c8\7\5\2\2\u00c8\u00c9\5"+
					"\34\17\2\u00c9\u00ca\7\6\2\2\u00ca\65\3\2\2\2\u00cb\u00cc\7\36\2\2\u00cc"+
					"\u00cd\5\4\3\2\u00cd\u00ce\7\37\2\2\u00ce\u00cf\5\26\f\2\u00cf\u00d0\7"+
					" \2\2\u00d0\u00d8\5\30\r\2\u00d1\u00d2\7\21\2\2\u00d2\u00d3\5\26\f\2\u00d3"+
					"\u00d4\7 \2\2\u00d4\u00d5\5\30\r\2\u00d5\u00d7\3\2\2\2\u00d6\u00d1\3\2"+
					"\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
					"\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\7!\2\2\u00dc\u00dd\5\f"+
					"\7\2\u00dd\67\3\2\2\2\u00de\u00df\7\"\2\2\u00df\u00e0\5\4\3\2\u00e0\u00e1"+
					"\7#\2\2\u00e1\u00e2\7\5\2\2\u00e2\u00e7\5\30\r\2\u00e3\u00e4\7\21\2\2"+
					"\u00e4\u00e6\5\30\r\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5"+
					"\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea"+
					"\u00eb\7\6\2\2\u00eb\u00f2\3\2\2\2\u00ec\u00ed\7\"\2\2\u00ed\u00ee\5\4"+
					"\3\2\u00ee\u00ef\7$\2\2\u00ef\u00f0\5\6\4\2\u00f0\u00f2\3\2\2\2\u00f1"+
					"\u00de\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f29\3\2\2\2\u00f3\u00f4\7%\2\2\u00f4"+
					"\u00f5\5\4\3\2\u00f5\u00f6\7!\2\2\u00f6\u00f7\5\f\7\2\u00f7;\3\2\2\2\u00f8"+
					"\u00f9\5\26\f\2\u00f9\u0100\5> \2\u00fa\u00fb\7\21\2\2\u00fb\u00fc\5\26"+
					"\f\2\u00fc\u00fd\5> \2\u00fd\u00ff\3\2\2\2\u00fe\u00fa\3\2\2\2\u00ff\u0102"+
					"\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101=\3\2\2\2\u0102"+
					"\u0100\3\2\2\2\u0103\u0104\7&\2\2\u0104\u0105\7\5\2\2\u0105\u0106\7,\2"+
					"\2\u0106\u0109\7\6\2\2\u0107\u0109\7\'\2\2\u0108\u0103\3\2\2\2\u0108\u0107"+
					"\3\2\2\2\u0109?\3\2\2\2\u010a\u010d\5\2\2\2\u010b\u010d\5(\25\2\u010c"+
					"\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2"+
					"\2\2\u010e\u010f\3\2\2\2\u010fA\3\2\2\2\u0110\u010e\3\2\2\2\21QXemx~\u008f"+
					"\u00b1\u00d8\u00e7\u00f1\u0100\u0108\u010c\u010e";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}