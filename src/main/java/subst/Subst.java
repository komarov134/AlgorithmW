package subst;

import type.Type;
import types.TypesType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class Subst {

    public static Map<String, Type> unionOk(Map<String, Type> s1, Map<String, Type> s2) {
        Map<String, Type> map = new HashMap<>(s1);
        for (String key : s2.keySet()) {
            if (!map.containsKey(key)) {
                map.put(key, s2.get(key));
            }
        }
        return map;
    }

    public static Map<String, Type> composeOk(Map<String, Type> s1, Map<String, Type> s2) {
//        System.err.println("compose " + s1 + "  " + s2);
        Map<String, Type> map = new HashMap<>();
        for (String key : s2.keySet()) {
            map.put(key, TypesType.applyOk(s1, s2.get(key)));
        }
        return unionOk(map, s1);
    }
}
