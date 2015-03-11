package type;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class Scheme {
    public Scheme(List<String> vars, Type type) {
        this.vars = vars;
        this.type = type;
    }

    private List<String> vars;
    private Type type;

    public List<String> getVars() {
        return vars;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Scheme{" +
                "vars=" + vars +
                ", type=" + type +
                '}';
    }
}
