package types;

import type.Type;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 06.03.2015
 */
public class Pair {
    public Pair(Map<String, Type> subst, Type type) {
        this.subst = subst;
        this.type = type;
    }

    Map<String, Type> subst;
    Type type;

    public Map<String, Type> getSubst() {
        return subst;
    }

    public Type getType() {
        return type;
    }
}
