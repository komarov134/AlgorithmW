package expression;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class EApp implements Expression {
    public EApp(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    private Expression e1;
    private Expression e2;

    public Expression getE1() {
        return e1;
    }

    public Expression getE2() {
        return e2;
    }
}
