package types;

import expression.*;
import subst.Subst;
import type.*;
import typeenv.TypeEnv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: neron
 * Date: 06.03.2015
 */
public class Types {

    public static int count = 0;
    public static int level = 0;

    public static String indent(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }

    public static Map<String, Type> mguOk(Type t1, Type t2) {
        System.err.print("mgu " + t1 + " and " + t2 + " ==> ");
//        count++;
        if (t1.getClass() == TFun.class && t2.getClass() == TFun.class) {
            TFun tFun1 = (TFun)t1;
            TFun tFun2 = (TFun)t2;
            Map<String, Type> s1 = mguOk(tFun1.getT1(), tFun2.getT1());
            Map<String, Type> s2 = mguOk(TypesType.applyOk(s1, tFun1.getT2()), TypesType.applyOk(s1, tFun2.getT2()));
            return Subst.composeOk(s1, s2);
        }
        if (t1.getClass() == TVar.class) {
            return varBindOk(((TVar) t1).getVar(), t2);
        }
        if (t2.getClass() == TVar.class) {
            return varBindOk(((TVar) t2).getVar(), t1);
        }
        if (t1.getClass() == TInt.class && t2.getClass() == TInt.class) {
            return new HashMap<>();
        }
        if (t1.getClass() == TBool.class && t2.getClass() == TBool.class) {
            return new HashMap<>();
        }
        throw new RuntimeException("types do not unify");
    }

    public static Map<String, Type> varBindOk(String var, Type type) {
        System.err.print("var bind ");
        if (type.getClass() == TVar.class) {
            TVar tVar = (TVar)type;
            if (tVar.getVar().equals(var)) {
                return new HashMap<>();
            }
        }
        if (TypesType.ftvOk(type).contains(var)) {
            throw new RuntimeException("occurs check fails " + var + " vs. " + type);
        }
        Map<String, Type> map = new HashMap<>();
        map.put(var, type);
        System.err.println(map);
        return map;
    }

    public static Pair ti(Map<String, Scheme> envGet, Expression expr) {
        Map<String, Scheme> env = new HashMap<>(envGet);
        if (expr.getClass() == EVar.class) {
            level++;
            System.err.println(indent(level) + "expr is EVar");
            EVar eVar = (EVar) expr;
            if (env.containsKey(eVar.getVar())) {
                Map<String, Type> s = new HashMap<>();
                for (String var : env.get(eVar.getVar()).getVars()) {
                    s.put(var, new TVar("a"));
                }
                level--;
                return new Pair(new HashMap<>(), TypesType.applyOk(s, env.get(eVar.getVar()).getType()));
            } else {
                throw new RuntimeException("unbound variable " + eVar.getVar());
            }
        }
        if (expr.getClass() == ELit.class) {
            return new Pair(new HashMap<>(), ELit.tiLit((ELit) expr));
        }
        if (expr.getClass() == EAbs.class) {
            level++;
            System.err.println(indent(level) + "expr is EAbs");
            EAbs eAbs = (EAbs) expr;
            TVar tv = new TVar("a");
            env.put(eAbs.getVar(), new Scheme(new ArrayList<>(), tv));
            Pair pair = ti(env, eAbs.getLambdaBody());
            level--;
            return new Pair(pair.getSubst(), new TFun(TypesType.applyOk(pair.getSubst(), tv), pair.getType()));
        }
        if (expr.getClass() == EApp.class) {
            level++;
            System.err.println(indent(level) + "expr is EApp");
            EApp eApp = (EApp) expr;
            TVar tv = new TVar("a");
            Pair pair1 = ti(env, eApp.getE1());
            Pair pair2 = ti(TypesTypeEnv.applyOk(pair1.getSubst(), env), eApp.getE2());
            Map<String, Type> s3 = mguOk(TypesType.applyOk(pair2.getSubst(), pair1.getType()), new TFun(pair2.getType(), tv));
            level--;
            return new Pair(Subst.composeOk(s3, Subst.composeOk(pair2.getSubst(), pair1.getSubst())), TypesType.applyOk(s3, tv));
        }
        if (expr.getClass() == ELet.class) {
            level++;
            System.err.println(indent(level) + "expr is Elet");
            ELet eLet = (ELet) expr;
            Pair pair1 = ti(env, eLet.getDefExpr());
            Map<String, Scheme> env1 = new HashMap<>(env);
            env1.remove(eLet.getVar());
            Scheme scheme = TypeEnv.generalizeOk(TypesTypeEnv.applyOk(pair1.getSubst(), env), pair1.getType());
            Map<String, Scheme> env2 = new HashMap<>(env1);
            env2.put(eLet.getVar(), scheme);
            Pair pair2 = ti(TypesTypeEnv.applyOk(pair1.getSubst(), env2), eLet.getInExpr());
            level--;
            return new Pair(Subst.composeOk(pair1.getSubst(), pair2.getSubst()), pair2.getType());
        }
        throw new RuntimeException("ti");
    }

    public static Type typeInference(Map<String, Scheme> env, Expression expr) {
        Pair pair = ti(env, expr);
//        System.err.println(Types.count);
        return TypesType.applyOk(pair.getSubst(), pair.getType());
    }
}
