package typeenv;

import type.Scheme;
import type.Type;
import types.TypesType;
import types.TypesTypeEnv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class TypeEnv {

    public static Scheme generalizeOk(Map<String, Scheme> ctx, Type type) {
        System.err.println("generalize");
        List<String> vars = new ArrayList<>(TypesType.ftvOk(type));
        vars.removeAll(TypesTypeEnv.ftvOk(ctx));
        return new Scheme(vars, type);
    }
}
