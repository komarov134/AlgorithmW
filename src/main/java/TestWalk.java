import expression.Expression;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import type.Scheme;
import types.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by neron on 12.03.15.
 */
public class TestWalk {
    public static void main(String[] args) throws Exception{

//        System.err.println(expression);
        List<String> files = new ArrayList<>();
        files.add("hw8/00.in");
//        files.add("hw8/01.in");     // ok Int
//        files.add("hw8/02.in");     // ok Int
//        files.add("hw8/03.in"); // no additional f // (a31 -> a31) -> a31 -> a31
//        files.add("hw8/04.in"); // no additional f  // (a31 -> a31) -> a31 -> a31
//        files.add("hw8/05.in"); // no additional f  // (a124 -> a123) -> a124 -> a123
//        files.add("hw8/06.in"); // no additional f  // (a13 -> a13) -> a13 -> a13
//        files.add("hw8/07.in");     // ok <Int, Bool>
//        files.add("hw8/08.in"); // no additional f  // occurs check fails a7 vs. a7 -> a8
//        files.add("hw8/09.in");   // ok Int
//        files.add("hw8/10.in");     // ok Bool
//        files.add("hw8/11.in");     // ok Bool
//        files.add("hw8/12.in");     // ok Int
//        files.add("hw8/13.in"); // no additional f  // a110
//        files.add("hw8/14.in");     // ok Int
//        files.add("hw8/15.in"); // no additional f  // (a166 -> a167) -> a166 -> a167

        for (String file : files) {
            HMLexer lexer = new HMLexer( new ANTLRFileStream(file));
            CommonTokenStream tokens = new CommonTokenStream( lexer );
            HMParser parser = new HMParser( tokens );
            ParseTree tree = parser.expr();
            Expression expression = TreeBuilder.treeBuild(tree);

            System.out.println(Types.typeInference(new HashMap<String, Scheme>(), expression));
        }
    }
}
