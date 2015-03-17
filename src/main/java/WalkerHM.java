import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by neron on 12.03.15.
 */
public class WalkerHM extends HMBaseListener {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterApp(HMParser.AppContext ctx) {
//        System.err.println(ctx.expr());
//        System.err.println(ctx.getRuleIndex());
        System.err.println(ctx.getChild(HMParser.VarContext.class, 0).ID());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitApp(HMParser.AppContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterLet(HMParser.LetContext ctx) {
//        System.err.println(ctx.expr());
//        System.err.println(ctx.getRuleIndex());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitLet(HMParser.LetContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterAbs(HMParser.AbsContext ctx) {
//        System.err.println(ctx.expr());
//        System.err.println(ctx.getRuleIndex());

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitAbs(HMParser.AbsContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterVar(HMParser.VarContext ctx) {
        System.err.println("enter var " + ctx.ID());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitVar(HMParser.VarContext ctx) {
        System.err.println("exit var " + ctx.ID());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParenthesis(HMParser.ParenthesisContext ctx) {
//        System.err.println(ctx.expr());
//        System.err.println(ctx.getRuleIndex());

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParenthesis(HMParser.ParenthesisContext ctx) { }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) { }
}
