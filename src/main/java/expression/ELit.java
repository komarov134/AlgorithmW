package expression;

import type.TBool;
import type.TInt;
import type.Type;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 05.03.2015
 */
public class ELit implements Expression {
    public ELit(Primitive primitive) {
        this.primitive = primitive;
    }

    private Primitive primitive;

    public enum Primitive {
        LInt,
        LBool;
    }

    public static Type tiLit(ELit eLit) {
        switch (eLit.primitive) {
            case LInt:
                return new TInt();
            case LBool:
                return new TBool();
        }
        throw new RuntimeException("no such literal");
    }
}
