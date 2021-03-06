// Generated from HM.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HMParser}.
 */
public interface HMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code App}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterApp(HMParser.AppContext ctx);
	/**
	 * Exit a parse tree produced by the {@code App}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitApp(HMParser.AppContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Let}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLet(HMParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Let}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLet(HMParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Pair}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPair(HMParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Pair}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPair(HMParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Abs}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAbs(HMParser.AbsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Abs}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAbs(HMParser.AbsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(HMParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(HMParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInteger(HMParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInteger(HMParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(HMParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(HMParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(HMParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link HMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(HMParser.ParenthesisContext ctx);
}