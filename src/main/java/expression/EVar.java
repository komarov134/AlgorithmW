package expression;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class EVar implements Expression {

    public EVar(String var) {
        this.var = var;
    }

    private String var;

    public String getVar() {
        return var;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EVar eVar = (EVar) o;

        return !(var != null ? !var.equals(eVar.var) : eVar.var != null);

    }

    @Override
    public int hashCode() {
        return var != null ? var.hashCode() : 0;
    }
}
