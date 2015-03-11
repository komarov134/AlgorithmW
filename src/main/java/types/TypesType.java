package types;

import type.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class TypesType {
    public static Set<String> ftvOk(Type type) {
        if (type.getClass() == TVar.class) {
            return new HashSet<>(Arrays.asList(((TVar)type).getVar()));     // {var}
        }
        if ((type.getClass() == TInt.class) || (type.getClass() == TBool.class)) {
            return new HashSet<>();                                         // {}
        }
        if (type.getClass() == TFun.class) {
            Set<String> s1 = ftvOk(((TFun) type).getT1());
            Set<String> s2 = ftvOk(((TFun) type).getT2());
            s1.addAll(s2);
            return s1;
        }
        throw new RuntimeException("ftvOk");
    }

    public static Type applyOk(Map<String, Type> subst, Type type) {
        if (type.getClass() == TVar.class) {
            if (subst.containsKey(((TVar) type).getVar())) {
                return subst.get(((TVar) type).getVar());
            } else {
                return type;
            }
        }
        if (type.getClass() == TFun.class) {
            TFun tFun = (TFun)type;
            return new TFun(applyOk(subst, tFun.getT1()), applyOk(subst, tFun.getT2()));
        }
        return type;
    }
}
