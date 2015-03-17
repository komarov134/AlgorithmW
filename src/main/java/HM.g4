// Define a grammar called HM
grammar HM;
expr : '(' expr ')' # Parenthesis
     | 'let' ID '=' expr 'in' expr  # Let
     | expr expr    # App
     | ID   # Var
     | '\\' ID '.' expr    # Abs
     | INT    # Integer
     | BOOL    # Boolean
     | 'If' expr expr expr    # If
     | 'Minus' expr expr # Minus
     | 'Plus' expr expr # Plus
     | 'Eq' expr expr # Eq
     | 'Y' expr # Y
     | '<' expr ',' expr '>' # Pair
     ;
INT : DIGIT+;
BOOL : 'T'
     | 'F'
     ;
ID : ID_LETTER (ID_LETTER | DIGIT)* ;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

fragment DIGIT : [0-9] ;
fragment ID_LETTER : [a-zA-Z] ;