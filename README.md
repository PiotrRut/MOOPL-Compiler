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

From the Part 1 briefing:

> _...(in part 2) you will be asked to code a compiler for a cut-down version of Moopl. The compiler will translate Moopl ASTs to Intermediate Representation (IR) code. A compiler from IR code to an executable instruction set will be provided, enabling you to compile and execute Moopl programs._
