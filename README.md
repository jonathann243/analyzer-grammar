# J3-Analyzer <img src="https://wakatime.com/badge/user/020278ff-8c14-4ca6-92d3-7730ea5f4dd7/project/d4b3c42b-9998-4561-a97a-cdc38b0b6259.svg">
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

<!-- 
public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}
-->
<h2>Menu</h2>
<img src="https://github.com/josue-lubaki/J3-Analyzer/blob/main/screen/menu.png" width="640px" height="480px" alt="menu"/>

<h2>Example correct program</h2>
<img src="https://github.com/josue-lubaki/J3-Analyzer/blob/main/screen/correct.png" height="420px" alt="correct"/>

<h2>Example error program</h2>
<img src="https://github.com/josue-lubaki/J3-Analyzer/blob/main/screen/error.png" height="420px" alt="menu"/>

