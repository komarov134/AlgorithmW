package expression;

import type.*;

/**
 * Created by neron on 18.03.15.
 */
public class ETerm implements Expression {
    public ETerm(T t) {
        this.t = t;
    }

    private T t;
    public enum T {
        Y,
        Eq,
        If,
        Minus,
        Plus
    }

    public static Type tiTerm(ETerm eTerm) {
        TVar tVar = new TVar("t");
        TInt tInt = new TInt();
        TBool tBool = new TBool();
        switch (eTerm.t) {
            case Y:
                return new TFun(new TFun(tVar, tVar), tVar); // (a -> a) -> a
            case Eq:
                return new TFun(tInt, new TFun(tInt, tBool)); // int -> int -> bool
            case If:
                return new TFun(tBool, new TFun(tVar, new TFun(tVar, tVar))); // bool -> a -> a -> a
            case Minus:
                return new TFun(tInt, new TFun(tInt, tInt)); // int -> int -> int
            case Plus:
                return new TFun(tInt, new TFun(tInt, tInt)); // int -> int -> int
        }
        throw new RuntimeException("no such term type");
    }
}
