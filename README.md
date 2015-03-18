to generate antlr4 java files and classes from grammar HM.g4
=====
$ cd /usr/local/lib
$ sudo curl -O http://www.antlr.org/download/antlr-4.5-complete.jar
$ export CLASSPATH=".:/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH"
$ alias antlr4='java -jar /usr/local/lib/antlr-4.5-complete.jar'

$ antlr4 HM.g4
$ javac HM*.java

Then put expression in hw8/00.in file and run TestWalk.java. see console
