package expression.functions;

import expression.Expression;

/**
 * Created by neron on 17.03.15.
 */
public class EY implements Expression {
    public EY(Expression f) {
        this.f = f;
    }

    private Expression f;

    public Expression getF() {
        return f;
    }
}
