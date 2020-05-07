# Language Processors Coursework
This coursework is divided in two parts, each with different tasks and submission deadlines.

- Part 1 - Building a parser (lexical analysis)
- Part 2 - Building a compiler

Both parts implement the MOOPL language (Mini Object Oriented Programming Language), which is a cut-down version of Java.

## Part 1
The first part of the coursework focuses on syntax & grammar, and abstract syntax trees. My submitted solution to this part can be found in the directory marked [__COURSEWORK PART 1__](https://github.com/PiotrRut/CompilerCW/tree/master/COURSEWORK%20PART%201%20(PARSER)).

The tasks given to us were adding the `TOKEN` definitions in the *Moopl-grammar.jj* file, completing the grammar productions for all non-terminals and removing any left recursion present in the grammar, and adding semantic actions in a copy of the main *.jj* file (called Moopl-ast.jj) that would return an appropriate type of AST. We were also asked to checked whether the ASTs built by our parser were correct by using the pretty-printer.

Status - __ALL TESTS PASSED__

## Part 2
The second part of the coursework focuses on building a compiler. My submitted solution to this part can be found in the directory marked [__COURSEWORK PART 2__](https://github.com/PiotrRut/MOOPL-Compiler/tree/master/COURSEWORK%20PART%202%20(COMPILER)).

Our task was to edit the `Compiler.java` file, and implement the required declarations.

From the Part 2 briefing: 

> _This is the 2nd and final part of the coursework. In Part 1 you created a parser for the Moopl grammar which, given a syntactically correct Moopl program as input, builds an AST representation of the program. In Part 2 you will develop a compiler_
_For this part of the coursework we provide functional code for parsing, building a symbol table, type checking and variable allocation. The language, Mapl, is a simplified version of Moopl which supports arrays but not classes or objects._
