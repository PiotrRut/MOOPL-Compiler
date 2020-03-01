From the coursework brief:

**a) [25 marks] Syntax and Grammar. You should:**


1. Complete the `TOKEN` definitions in `Moopl-grammar.jj`. You can test your token definitions by writing a list of tokens in a text file (for example `tokens.txt`) and then running `java TestTokens tokens.txt`

2. Complete the grammar productions in `Moopl-grammar.jj`.
  * The grammar avoids ambiguity, but, as discussed in the lectures, there are
  still left-recursion and lookahead issues that you will need to resolve.
  * When implementing this grammar you should not include any semantic actions. The return type for each method should be void. Part b asks
  you to change this. You can test your parser by running `java Parse filename`

You are required to submit this version as a separate file (`Moopl-grammar.jj`) so make a copy and put it somewhere safe before moving on to part b.

**b) [25 marks] Abstract Syntax Tree. You should:**


1. Make a copy of your completed `Moopl-grammar.jj` file. Call this copy `Moopl-ast.jj`. Add semantic actions to `Moopl-ast.jj` so that each production returns an appropriate type of abstract syntax tree, using the AST classes provided in package `syntaxtree`. In order to do this you will need to specify an appropriate return type for each production. In most cases you will need to add local variable declarations at the start of your productions and you will need to assign appropriate values to those local variables within your semantic actions.

2. The pretty-printer that we have provided will take an abstract syntax tree and turn it back into well formatted source code. You should use this to check that the AST built by your parser is a faithful representation of its input. You can do this by running `java PrettyPrint filename`


You are required to submit this version as a separate file (`Moopl-ast.jj`).
