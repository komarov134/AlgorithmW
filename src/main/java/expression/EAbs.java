package expression;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class EAbs implements Expression {
    public EAbs(String var, Expression lambdaBody) {
        this.var = var;
        this.lambdaBody = lambdaBody;
    }

    private String var;
    private Expression lambdaBody;

    public String getVar() {
        return var;
    }

    public Expression getLambdaBody() {
        return lambdaBody;
    }
}
