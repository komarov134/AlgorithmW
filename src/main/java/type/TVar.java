package type;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class TVar extends Type {
    private static int n = 0;
    private String var;

    public TVar(String var) {
        this.var = var + n++;
    }

    public String getVar() {
        return var;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TVar tVar = (TVar) o;

        return !(var != null ? !var.equals(tVar.var) : tVar.var != null);

    }

    @Override
    public int hashCode() {
        return var != null ? var.hashCode() : 0;
    }

//    @Override
//    public String toString() {
//        return "TVar{" +
//                "var='" + var + '\'' +
//                '}';
//    }
}
