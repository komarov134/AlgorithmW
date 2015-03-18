package type;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class Type {
    @Override
    public String toString() {
        if (this.getClass() == TPair.class) {
            return "<" + ((TPair)this).getT1() + ", " + ((TPair)this).getT2() + ">";
        }
        if (this.getClass() == TBool.class) {
            return "Bool";
        }
        if (this.getClass() == TInt.class) {
            return "Int";
        }
        if (this.getClass() == TVar.class) {
            return ((TVar)this).getVar();
        }
        if (this.getClass() == TFun.class) {
            if (((TFun)this).getT1().getClass() == TVar.class
                    || ((TFun)this).getT1().getClass() == TBool.class
                    || ((TFun)this).getT1().getClass() == TInt.class) {
                return ((TFun)this).getT1() + " -> " + ((TFun)this).getT2();
            }
        }
        return "(" + ((TFun)this).getT1() + ") -> " + ((TFun)this).getT2();
    }
}
