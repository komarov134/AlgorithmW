package types;

import type.Scheme;
import type.Type;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class TypesTypeEnv {
    public static Set<String> ftvOk(Map<String, Scheme> ctx) {
        Set<String> set = new HashSet<>();
        for (Scheme scheme : ctx.values()) {
            set.addAll(TypesScheme.ftvOk(scheme));
        }
        return set;
    }

    public static Map<String, Scheme> applyOk(Map<String, Type> subst, Map<String, Scheme> ctx) {
        Map<String, Scheme> ctx1 = new HashMap<>();
        for (String key : ctx.keySet()) {
            ctx1.put(key, TypesScheme.applyOk(subst, ctx.get(key)));
        }
        return ctx1;
    }
}
