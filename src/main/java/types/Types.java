package types;

import expression.*;
import expression.functions.*;
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
//        System.err.print("mgu " + t1 + " and " + t2 + " ==> ");
//        count++;
        if (t1.getClass() == TFun.class && t2.getClass() == TFun.class) {
            TFun tFun1 = (TFun)t1;
            TFun tFun2 = (TFun)t2;
            Map<String, Type> s1 = mguOk(tFun1.getT1(), tFun2.getT1());
//            System.err.println("another m");
//            System.err.println(s1);
//            System.err.println(TypesType.applyOk(s1, tFun1.getT2()));
            Map<String, Type> s2 = mguOk(TypesType.applyOk(s1, tFun1.getT2()), TypesType.applyOk(s1, tFun2.getT2()));
//            System.err.println(Subst.composeOk(s1, s2));
            return Subst.composeOk(s2, s1);
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
        if (t1.getClass() == TPair.class && t2.getClass() == TPair.class) {
            return new HashMap<>();
        }
        throw new RuntimeException("types do not unify");
    }

    public static Map<String, Type> varBindOk(String var, Type type) {
//        System.err.print("var bind ");
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
//        System.err.println(map);
        return map;
    }

    public static Pair ti(Map<String, Scheme> envGet, Expression expr) {
        Map<String, Scheme> env = new HashMap<>(envGet);
        if (expr.getClass() == EVar.class) {
            level++;
//            System.err.println(indent(level) + "expr is EVar");
            EVar eVar = (EVar) expr;
            if (env.containsKey(eVar.getVar())) {
                Map<String, Type> s = new HashMap<>();
                for (String var : env.get(eVar.getVar()).getVars()) {
                    s.put(var, new TVar("a"));
                }
                level--;
                return new Pair(new HashMap<String, Type>(), TypesType.applyOk(s, env.get(eVar.getVar()).getType()));
            } else {
                throw new RuntimeException("unbound variable " + eVar.getVar());
            }
        }
        if (expr.getClass() == ELit.class) {
//            System.err.println("expr is ELit");
            return new Pair(new HashMap<String, Type>(), ELit.tiLit((ELit) expr));
        }
        if (expr.getClass() == ETerm.class) {
//            System.err.println("expr is ETerm");
            return new Pair(new HashMap<String, Type>(), ETerm.tiTerm((ETerm) expr));
        }
//        if (expr.getClass() == EEq.class) {
//            System.err.println(indent(++level) + "expr is EEq");
//
//            EEq eEq = (EEq)expr;
//
//            Pair pair1 = ti(env, eEq.getE1());
//            Map<String, Type> s1 = mguOk(pair1.getType(), new TInt());
//            Pair pair2 = ti(env, eEq.getE2());
//            Map<String, Type> s2 = mguOk(pair2.getType(), new TInt());
//            --level;
//            return new Pair(Subst.composeOk(Subst.composeOk(s1, pair1.getSubst()), Subst.composeOk(s2, pair2.getSubst())), new TBool());
//        }
//        if (expr.getClass() == EIf.class) {
//            System.err.println(indent(++level) + "expr is EIf");
//            EIf eIf = (EIf)expr;
//            TVar tVar = new TVar("a");
//
//            Pair pair1 = ti(env, eIf.getE1());
//            Map<String, Type> s1 = mguOk(pair1.getType(), new TBool());
//            Map<String, Type> compose1 = Subst.composeOk(pair1.getSubst(), s1);
//            Pair pair2 = ti(env, eIf.getE2());
//            Map<String, Type> s2 = mguOk(pair2.getType(), tVar);
//            Map<String, Type> compose2 = Subst.composeOk(pair2.getSubst(), s2);
//            Pair pair3 = ti(env, eIf.getE3());
//            Map<String, Type> s3 = mguOk(pair3.getType(), tVar);
//            Map<String, Type> compose3 = Subst.composeOk(pair3.getSubst(), s3);
//
//            Map<String, Type> s4 = mguOk(pair2.getType(), pair3.getType());
//            Map<String, Type> compose4 = Subst.composeOk(compose1, compose2);
//            Map<String, Type> compose5 = Subst.composeOk(compose4, compose3);
//            --level;
//            return new Pair(Subst.composeOk(Subst.composeOk(s4, compose5), Subst.composeOk(s2, pair2.getSubst())), tVar);
//        }
//        if (expr.getClass() == EPlus.class) {
//            System.err.println(indent(++level) + "expr is EPlus");
//            EPlus ePlus = (EPlus)expr;
//
//            Pair pair1 = ti(env, ePlus.getE1());
//            Map<String, Type> s1 = mguOk(pair1.getType(), new TInt());
//            Pair pair2 = ti(env, ePlus.getE2());
//            Map<String, Type> s2 = mguOk(pair2.getType(), new TInt());
//            --level;
//            return new Pair(Subst.composeOk(Subst.composeOk(s1, pair1.getSubst()), Subst.composeOk(s2, pair2.getSubst())), new TInt());
//        }
//        if (expr.getClass() == EMinus.class) {
//            System.err.println(indent(++level) + "expr is EMinus");
//            EMinus eMinus = (EMinus)expr;
//
//            Pair pair1 = ti(env, eMinus.getE1());
//            Map<String, Type> s1 = mguOk(pair1.getType(), new TInt());
//            Pair pair2 = ti(env, eMinus.getE2());
//            Map<String, Type> s2 = mguOk(pair2.getType(), new TInt());
//            --level;
//            return new Pair(Subst.composeOk(Subst.composeOk(s1, pair1.getSubst()), Subst.composeOk(s2, pair2.getSubst())), new TInt());
//        }
//        if (expr.getClass() == EY.class) {
//            System.err.println(indent(++level) + "expr is EY");
//            EY ey = (EY)expr;
//            TVar tVar = new TVar("a");
//
//            Pair pair1 = ti(env, ey.getF());
//            Map<String, Type> s1 = mguOk(pair1.getType(), new TFun(tVar, tVar));
//            --level;
//            return new Pair(Subst.composeOk(s1, pair1.getSubst()), pair1.getType());
//        }
        if (expr.getClass() == EPair.class) {
//            System.err.println(indent(++level) + "expr is EPair");
            EPair ePair = (EPair)expr;

            Pair pair1 = ti(env, ePair.getE1());
//            Map<String, Type> s1 = mguOk(pair1.getType(), new TInt());
            Pair pair2 = ti(env, ePair.getE2());
//            Map<String, Type> s2 = mguOk(pair2.getType(), new TInt());
            --level;
            return new Pair(Subst.composeOk(pair1.getSubst(), pair2.getSubst()), new TPair(pair1.getType(), pair2.getType()));
        }
        if (expr.getClass() == EAbs.class) {
            level++;
//            System.err.println(indent(level) + "expr is EAbs");
            EAbs eAbs = (EAbs) expr;
            TVar tv = new TVar("a");
            env.put(eAbs.getVar(), new Scheme(new ArrayList<String>(), tv));
            Pair pair = ti(env, eAbs.getLambdaBody());
            level--;
            return new Pair(pair.getSubst(), new TFun(TypesType.applyOk(pair.getSubst(), tv), pair.getType()));
        }
        if (expr.getClass() == EApp.class) {
            level++;
//            System.err.println(indent(level) + "expr is EApp");
            EApp eApp = (EApp) expr;
            TVar tv = new TVar("a");
            Pair pair1 = ti(env, eApp.getE1());
//            System.err.println("middle");
            Pair pair2 = ti(TypesTypeEnv.applyOk(pair1.getSubst(), env), eApp.getE2());
            Map<String, Type> s3 = mguOk(TypesType.applyOk(pair2.getSubst(), pair1.getType()), new TFun(pair2.getType(), tv));
            level--;
            return new Pair(Subst.composeOk(s3, Subst.composeOk(pair2.getSubst(), pair1.getSubst())), TypesType.applyOk(s3, tv));
        }
        if (expr.getClass() == ELet.class) {
            level++;
//            System.err.println(indent(level) + "expr is Elet");
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
