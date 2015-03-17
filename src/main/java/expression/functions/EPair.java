package expression.functions;

import expression.Expression;

/**
 * Created by neron on 17.03.15.
 */
public class EPair implements Expression {
    public EPair(Expression e1, Expression e2) {
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
