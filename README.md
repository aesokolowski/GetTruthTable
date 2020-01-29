## GetTruthTable
Andrew E. Sokolowski      Jan. 2020

command-line tool to parse a canonical boolean algebra expression in minterms and print out a truth table

doesn't even do that yet because it's in delta or epsilon, nevermind beta. run if you like debug logs, I guess

to compile:

javac GetTruthTable.java

to run, for example:

java GetTruthTable 'x^y^z^+x^y^z'

to get a truth table for F = SIGMA[m](0, 1) out of 8 states

carat is used instead of the prime symbol (apostrophe) because I don't want users to have to worry about escaping the single-quote character. I specifically didn't want to use asterisk to avoid confusion with boolean AND nor ~ because it's associated with prefix notation and I prefer postfix.
