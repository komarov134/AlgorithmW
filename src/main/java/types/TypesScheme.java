package types;

import type.Scheme;
import type.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class TypesScheme {
    public static Set<String> ftvOk(Scheme scheme) {
        Set<String> s1 = TypesType.ftvOk(scheme.getType());
        s1.removeAll(scheme.getVars());
        return s1;
    }

    public static Scheme applyOk(Map<String, Type> subst, Scheme scheme) {
        Map<String, Type> s1 = new HashMap<>(subst);
        for (String var : scheme.getVars()) {
            s1.remove(var);
        }
        return new Scheme(scheme.getVars(), TypesType.applyOk(s1, scheme.getType()));
    }

}
