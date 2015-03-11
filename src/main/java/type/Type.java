package type;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class Type {
    @Override
    public String toString() {
//        if (this.getClass() == TBool.class || this.getClass() == TInt.class) {
//            return "*";
//        }
        if (this.getClass() == TVar.class) {
            return ((TVar)this).getVar();
        }
        if (this.getClass() == TFun.class) {
            if (((TFun)this).getT1().getClass() == TVar.class) {
                return ((TVar)((TFun)this).getT1()).getVar() + " -> " + (((TFun)this).getT2());
            }
        }
        return "(" + ((TFun)this).getT1() + ") -> " + ((TFun)this).getT2();
    }
}
