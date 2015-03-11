import expression.*;
import types.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Expression expressionSimple = new EAbs("x", new EVar("x"));

        Expression expression0 = new ELet("id",
                new EAbs("x", new EVar("x")),
                new EVar("id"));

        // let a=\x.xx...x in
        // let b=\a.aa...a in
        // let y=\b.bb...b
        // yy...y
        Expression expression1 = new ELet("x",
                new EAbs("y", new EVar("y")),
                new ELet("a",
                        new EAbs("x", new EVar("x")),
                        new EApp(new EVar("a"),
                                new EApp(new EVar("a"),
                                        new EApp(new EVar("a"),
                                                new EApp(new EVar("a"),
                                                        new EVar("a")))))));
        //
        Expression expressionLet = new ELet("x",
                new EAbs("y", new EVar("y")),
                new ELet("a",
                        new EAbs("x", new EVar("x")),
                        nTimesApp("a", 4)));
        // let id=\x. (let y=x in y) in
        // (id)(id)
        Expression expression2 = new ELet("id",
                new EAbs("x",
                        new ELet("y",
                                new EVar("x"),
                                new EVar("y"))),
                new EApp(new EVar("id"),
                        new EVar("id")));
        //
        Expression expression3 = new EAbs("x",
                new EAbs("y", new EVar("x")));
        //
        Expression expression4 = new EAbs("x", new EVar("x"));

        Expression expression5 = new ELet("id",
                new EAbs("x",
                        new ELet("y",
                                new EVar("x"),
                                new EVar("y"))),
                new EApp(new EVar("id"),
                        new EVar("id")));
        List<Expression> expressionList = new ArrayList<>();
//        expressionList.add(expressionSimple);
//        expressionList.add(expression0);
//        expressionList.add(expression1);
//        expressionList.add(expressionLet);
//        expressionList.add(expression2);
        expressionList.add(expression3);
//        expressionList.add(expression4);
//        expressionList.add(expression5);

        for (Expression expression : expressionList) {
            System.out.println(Types.typeInference(new HashMap<>(), expression));
        }
        // write your code here
    }

    public static EApp nTimesApp(String var, int n) {
        EApp eApp = new EApp(new EVar(var), new EVar(var));
        for (int i = 0; i < n - 2; i++) {
            eApp = new EApp(new EVar(var), eApp);
        }
        return eApp;
//        if (n == 2) {
//            return new EApp(new EVar(var), new EVar(var));
//        }
//        return new EApp(new EVar(var), nTimesApp(var, n - 1));
    }
}
