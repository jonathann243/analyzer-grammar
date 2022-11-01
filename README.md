# J3-Analyzer 
<!-- Analyseur syntaxique  et lexical d'un programme P du langage L décrit par la grammaire G   -->
Syntax and lexical analyzer of a program P of the language L described by the grammar G.<br>
According to a given grammar, we must analyze the entered program (TestFile) to detect any errors and display the errors that occurred during this analysis.<br>
We first perform the lexical analysis, which consists consists of breaking down the syntaxes into a series of tokens, removing any spaces or comments in the source code. 
Then we perform the syntactic analysis, which consists to parse the syntax structure and checks whether the given entry is in the correct syntax of the programming language or not.

<h2>Grammar Definition :</h2>
<p> 
<b>procedure</b> ::= Procedure &emsp;identificateur° <br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;déclarations &emsp;instructions_affectation <br>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Fin_Procedure &emsp;identificateur
</p>
<b>déclarations</b> ::= déclaration&emsp; déclarations | déclaration <br>
<b>déclaration</b> ::= declare&emsp; variable : type ;<br>
<b>variable</b> ::= identificateur <br>
<b>type</b> ::= entier | reel <br>
<b>instructions_affectation</b> ::= instruction_affectation {; instruction_affectation } <br>
<b>instruction_affectation</b> ::= variable = expression_arithmétique <br>
<b>expression_arithmétique</b> ::= terme {(+ | -) terme} <br>
<b>terme</b> ::= facteur {(* | /) facteur} <br>
<b>facteur</b> ::= variable | nombre | (expression_arithmétique) <br>




