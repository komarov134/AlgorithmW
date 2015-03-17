package type;

/**
 * Created by neron on 17.03.15.
 */
public class TPair extends Type {
    public TPair(Type t1, Type t2) {
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
}
