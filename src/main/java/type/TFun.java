package type;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class TFun extends Type {

    public TFun(Type t1, Type t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    private Type t1;
    private Type t2;

    public Type getT1() {
        return t1;
    }

    public Type getT2() {
        return t2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TFun tFun = (TFun) o;

        if (t1 != null ? !t1.equals(tFun.t1) : tFun.t1 != null) return false;
        return !(t2 != null ? !t2.equals(tFun.t2) : tFun.t2 != null);

    }

    @Override
    public int hashCode() {
        int result = t1 != null ? t1.hashCode() : 0;
        result = 31 * result + (t2 != null ? t2.hashCode() : 0);
        return result;
    }

//    @Override
//    public String toString() {
//        return "TFun{" +
//                "t1=" + t1 +
//                ", t2=" + t2 +
//                '}';
//    }
}
