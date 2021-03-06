# Interpreter

The interpreter accepts a program file and input file as arguments. The program file consists of a program 
made up of grammar from the BNF language described below. The input file is a list of integer values that are 
assigned during execution of the read command. The interpreter parses, prints, and executes the program.

## To compile (linux)

Type the following command to compile:
```
javac */*.java *.java
```

## To run (linux)

Type the following command to run:
```
java Interpreter <program-file> <input-file>
```

Where program-file is the address of the program file and input-file is the address of
the input file.

## The files

Interpreter.java: Tokenizes program, parses it, prints it, and then executes it.

/data: Contains program and input files for testing.

/nonterminals: Each nonterminal contains a parse, print, and execute method.

/tokenizer: Token.java is a class to store token information. Tokenizer.java is responsible for tokenizing. 

## The language

```
<prog> ::= program <decl seq> begin <stmt seq> end
<decl seq> ::= <decl> | <decl> <decl seq>
<stmt seq> ::= <stmt> | <stmt> <stmt seq>
<decl> ::= int <id list>;
<id list> ::= <id> | <id>, <id list>
<stmt> ::= <assign>|<if>|<loop>|<input>|<output>
<assign> ::= <id> = <exp>;
<if> ::= if <cond> then <stmt seq> end; | if <cond> then <stmt seq> else <stmt seq> end;
<loop> ::= while <cond> loop <stmt seq> end;
<input> ::= read <id list>;
<output> ::= write <id list>;
<cond> ::= <comp> | !<cond> | [<cond> && <cond>] | [<cond> || <cond>]
<comp> ::= (<op> <comp op> <op>)
<exp> ::= <fac> | <fac>+<exp> | <fac>-<exp>
<fac> ::= <op> | <op> * <fac>
<op> ::= <int> | <id> | (<exp>)
<comp op> ::= != | == | < | > | <= | >= 
<id> ::= <let> | <let><id> | <let><int>
<let> ::= A | B | C | ... | X | Y | Z
<int> ::= <digit> | <digit><int>
<digit> ::= 0 | 1 | 2 | 3 | ... | 9
```

Reserved words (11 reserved words):
```
program, begin, end, int, if, then, else, while, loop, read, write
```
Special symbols (19 special symbols): 
```
; , = ! [ ] && || ( ) + - * != == < > <= >=
```
Integers 
```
unsigned
```
Identifiers: 
```
Start with upper case letter, followed by zero or more upper case letters
and ending with zero or more digits. Note that something like "ABCend" 
is illegal as an identifier because of the lower case letters; 
and it is not two tokens because of lack of whitespace.
```

Tokens are numbered 1 through 11 for the reserved words, 12 through 30 for the special symbols, 31 for integer, and 32 for identifier. EOF token
(for end-of-file) is token number 33.

## Error handling

The interpreter handles the following errors:

Violations of the BNF grammar, double declarations, missing declarations, uninitialized variables, and a nonexistent program/input file.

## Libraries used

For reading the core program source file:
BufferedReader, FileReader, IOException

For storing the tokens:
Queue, LinkedList

For separating the tokens:
regex.Matcher, regex.Pattern