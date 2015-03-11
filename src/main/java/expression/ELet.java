package expression;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class ELet implements Expression {
    public ELet(String var, Expression defExpr, Expression inExpr) {
        this.var = var;
        this.defExpr = defExpr;
        this.inExpr = inExpr;
    }

    private String var;
    private Expression defExpr;
    private Expression inExpr;

    public String getVar() {
        return var;
    }

    public Expression getDefExpr() {
        return defExpr;
    }

    public Expression getInExpr() {
        return inExpr;
    }
}
