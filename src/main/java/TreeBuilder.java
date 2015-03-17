import expression.*;
import expression.functions.*;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by neron on 13.03.15.
 */
public class TreeBuilder {

    public static Expression treeBuild(ParseTree ctx) {

        if (ctx.getClass() == HMParser.ParenthesisContext.class) {
            HMParser.ParenthesisContext parenthesisContext = (HMParser.ParenthesisContext)ctx;
            return treeBuild(parenthesisContext.getChild(1));
        }
        if (ctx.getClass() == HMParser.VarContext.class) {
            HMParser.VarContext varContext = (HMParser.VarContext)ctx;
            return new EVar(varContext.ID().toString());
        }
        if (ctx.getClass() == HMParser.AppContext.class) {
            HMParser.AppContext appContext = (HMParser.AppContext)ctx;
            return new EApp(treeBuild(appContext.getChild(0)), treeBuild(appContext.getChild(1)));
        }
        if (ctx.getClass() == HMParser.AbsContext.class) {
            HMParser.AbsContext absContext = (HMParser.AbsContext)ctx;
            String var = absContext.getChild(1).toString();
            return new EAbs(var, treeBuild(absContext.getChild(3)));
        }
        if (ctx.getClass() == HMParser.LetContext.class) {
            HMParser.LetContext letContext = (HMParser.LetContext)ctx;
            String var = letContext.getChild(1).toString();
            return new ELet(var, treeBuild(letContext.getChild(3)), treeBuild(letContext.getChild(5)));
        }
        if (ctx.getClass() == HMParser.IntegerContext.class) {
//            HMParser.IntegerContext integerContext = (HMParser.IntegerContext)ctx;
            return new ELit(ELit.Primitive.LInt);
        }
        if (ctx.getClass() == HMParser.BooleanContext.class) {
//            HMParser.BooleanContext booleanContext = (HMParser.BooleanContext)ctx;
            return new ELit(ELit.Primitive.LBool);
        }
        if (ctx.getClass() == HMParser.EqContext.class) {
            HMParser.EqContext eqContext = (HMParser.EqContext)ctx;
            return new EEq(treeBuild(eqContext.getChild(1)), treeBuild(eqContext.getChild(2)));
        }
        if (ctx.getClass() == HMParser.IfContext.class) {
            HMParser.IfContext ifContext = (HMParser.IfContext)ctx;
            return new EIf(treeBuild(ifContext.getChild(1)), treeBuild(ifContext.getChild(2)), treeBuild(ifContext.getChild(3)));
        }
        if (ctx.getClass() == HMParser.PlusContext.class) {
            HMParser.PlusContext plusContext = (HMParser.PlusContext)ctx;
            return new EPlus(treeBuild(plusContext.getChild(1)), treeBuild(plusContext.getChild(2)));
        }
        if (ctx.getClass() == HMParser.MinusContext.class) {
            HMParser.MinusContext minusContext = (HMParser.MinusContext)ctx;
            return new EMinus(treeBuild(minusContext.getChild(1)), treeBuild(minusContext.getChild(2)));
        }
        if (ctx.getClass() == HMParser.YContext.class) {
            HMParser.YContext yContext = (HMParser.YContext)ctx;
            return new EY(treeBuild(yContext.getChild(1)));
        }
        if (ctx.getClass() == HMParser.PairContext.class) {
            HMParser.PairContext pairContext = (HMParser.PairContext)ctx;
            return new EPair(treeBuild(pairContext.getChild(1)), treeBuild(pairContext.getChild(3)));
        }

        throw new RuntimeException("no rule");
    }
}
