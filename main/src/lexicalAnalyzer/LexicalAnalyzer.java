package lexicalAnalyzer;

import enums.LexicalAnalyzerExceptionEnums;
import exceptionCustom.LexicalAnalyzerException;
import lexicalUnit.IdentificatorUnit;
import lexicalUnit.KeyWordUnit;
import lexicalUnit.NumberUnit;
import lexicalUnit.OperatorUnit;
import lexicalUnit.SeparatorUnit;
import utilitaire.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static utilitaire.Utils.*;

public class LexicalAnalyzer {
    private final List<String> inputList;
    private final ArrayList<Token> tokens;
    private final LineReader reader;
    private final HashSet<String> repeatExecution;
    private int lineNumber = 0; // numéro de ligne de chaque instruction

    public LexicalAnalyzer(List<String> inputList) {
        this.inputList = inputList;
        this.tokens = new ArrayList<>();
        this.reader = new LineReader();
        this.repeatExecution = new HashSet<>();
    }

    public void start() throws LexicalAnalyzerException {
        String lineCurrent;
        char charCurrent;

        for (String lineFile : inputList) {
            lineNumber++;
            lineCurrent = lineFile.trim();

            if (lineCurrent.isEmpty())
                continue;

            // passer la ligne au lecteur
            reader.setLine(lineCurrent);
           
            do {
                charCurrent = reader.currentChar();
                if (charCurrent == ' ' || charCurrent == '\t') {
                    // bouger le cursor vers l'avant
                    reader.nextCharForward();
                } else if (isLetter(charCurrent)) {
                    // le cas où le character courant est une lettre
                    caseCharIsLetter(charCurrent);
                } else if (isDigit(charCurrent)) {
                    // le cas où le character courant est un chiffre
                    caseCharIsDigit(charCurrent);
                } else if (isOperator(charCurrent)) {
                    // le cas où le character courant est un operator
                    caseCharIsOperator(charCurrent);
                } else if (isSeparator(charCurrent)) {
                    // le cas où le character courant est un separateur
                    caseCharIsSeparator(charCurrent);
                }
            } while (!reader.isEOL());
        }

        System.out.print("ANALYSE LEXICALE : { ");
        tokens.forEach(m -> System.out.print(m.getStrToken() + " "));
        System.out.println(" }");
    }

    /**
     * Méthode à exécuter dans le cas où le caractère courant est une lettre
     */
    private void caseCharIsLetter(char currentChar) throws LexicalAnalyzerException {
        StringBuilder token = new StringBuilder();

        token.append(currentChar);
        reader.nextCharForward();

        // Si on est pas à la fin de la ligne et que le caractère courant est une suite
        // de lettre chiffre ou le caractère '_' underscore
        while (!reader.isEOL()
                && (isLetter(reader.currentChar()) || isDigit(reader.currentChar()) || reader.currentChar() == '_')) {
            token.append(reader.currentChar());
            reader.nextCharForward();
        }

        // Vérifier si le token construit est un mot clé
        if (isKeyWord(token.toString())) {
            KeyWordUnit keyWord = new KeyWordUnit(token.toString());
            Token sToken = new Token(lineNumber, keyWord);
            tokens.add(sToken);
        }
        // token n'est pas un mot clé et il contient underscore "_"
        else if (isContainsUndescore(token.toString())) {
            throw new LexicalAnalyzerException(LexicalAnalyzerExceptionEnums.IDENTIFIANT_UNDERSCORE_ERROR, lineNumber);
        }

        else if (isIdentificator(token.toString())) {
            IdentificatorUnit identificator = new IdentificatorUnit(token.toString());
            Token sToken = new Token(lineNumber, identificator);
            tokens.add(sToken);
        } else {
            if(!recoverPasswords(token.toString()))
                throw new LexicalAnalyzerException(LexicalAnalyzerExceptionEnums.IDENTIFIANT_ERROR, lineNumber);
        }

    }

    /**
     * Methode qui permet de récupérer l'erreur, au cas où le nombre de caractère est supériieur à 8
     * @param identificator l'identifiant à évaluer
     * @return true si l'utilisateur decide de continuer le programme
     */
    private boolean recoverPasswords(String identificator) {

        if(repeatExecution.isEmpty()){
            System.out.println("ANALYSE LEXICALE : Vous avez un identificateur ("
                    + identificator + ") qui a plus de 8 caractères");
            System.out.println("ANALYSE LEXICALE : " + "Voulez-vous continuer l'analyse ? L'identificateur sera réduit à 8 caractères max ("
                    + "O/N");
        }

        if(repeatExecution.contains(identificator)){
            troncIdentificator(identificator);
            return true;
        }
        else if(optionChosenByUser()){
            troncIdentificator(identificator);
            return true;
        }
        return false;
    }

    /**
     * Methode qui permet de couper l'identificateur passé en paramètre sur 8 caractères maximum
     * @param identificator identificateur à réduire
     */
    private void troncIdentificator(String identificator) {
        repeatExecution.add(identificator);
        identificator = identificator.substring(0,8);
        IdentificatorUnit identificatorUnit = new IdentificatorUnit(identificator);
        Token token = new Token(lineNumber, identificatorUnit);
        tokens.add(token);
    }

    /**
     * Méthode à éxecuter dans le cas où le caractère courant est un chiffre
     * 
     * @param currentChar le caractère courant à analyser
     */
    private void caseCharIsDigit(char currentChar) throws LexicalAnalyzerException {
        StringBuilder token = new StringBuilder();

        token.append(currentChar);
        reader.nextCharForward();

        // Si on est pas à la fin de la ligne et que le caractère courant est une suite
        // de chiffre
        while (!reader.isEOL() && ( isDigit(reader.currentChar()) || reader.currentChar() == '.' || isLetter(reader.currentChar())  )  ) {
            if (isLetter(reader.currentChar() )){
                throw new LexicalAnalyzerException(LexicalAnalyzerExceptionEnums.DIGIT_ERROR, lineNumber);
             }
            token.append(reader.currentChar());
            reader.nextCharForward();
        }

        // Vérifier si le token construit est un entier
        if (isDigit(token.toString(), false)) {
            NumberUnit integer = new NumberUnit(token.toString());
            Token sToken = new Token(lineNumber, integer);
            tokens.add(sToken);
        } else {
            // TODO Tenter de récupérer l'erreur, sinon
            if(!recoverNumber(token.toString()))
                throw new LexicalAnalyzerException(LexicalAnalyzerExceptionEnums.DIGIT_ERROR, lineNumber);
        }
    }

    private boolean optionChosenByUser(){
        String ch;

        while(true){
            ch = String.valueOf(Utils.getInputOnlyChar(  "ANALYSE LEXICALE : $> "));

            if(ch.equalsIgnoreCase("o")) {
                return true;
            }
            else if(ch.equalsIgnoreCase("n")){
                return false;
            }
        }
    }

    /**
     * Methode qui permet de récupérer l'erreur, au cas où le nombre fournit par l'utilisateur n'est ni un entier ni un reel
     * @param number le nombre à évaluer
     * @return true si l'utilisateur decide de continuer le programme
     */
    private boolean recoverNumber(String number) {
        if(repeatExecution.isEmpty()){
            System.out.println( "ANALYSE LEXICALE :  Vous avez saisit un nombre (" + number + ") qui n'est pas reconnue comme un entier ou reel");
            System.out.println("ANALYSE LEXICALE : Voulez-vous continuer l'analyse ? On ne considèrera que la partie entière ("
                    + "O/N");
        }

        if(repeatExecution.contains(number)){
            takeNumberManage(number);
            return true;
        }
        else if(optionChosenByUser()){
            takeNumberManage(number);
            return true;
        }

        return false;
    }

    /**
     * Méthode qui permet de convertir le nombre passé en paramètre en entier valide
     * @param number le nombre à convertir
     */
    private void takeNumberManage(String number) {
        repeatExecution.add(number);
        number = number.split("\\.")[0];
        NumberUnit numberUnit = new NumberUnit(number);
        Token token = new Token(lineNumber, numberUnit);
        tokens.add(token);
    }

    /**
     * Méthode à éxecuter dans le cas où le caractère courant est un opérator
     * 
     * @param currentChar le caractère courant à analyser
     */
    private void caseCharIsOperator(char currentChar) {
        OperatorUnit operator = new OperatorUnit(currentChar);
        Token sToken = new Token(lineNumber, operator);
        tokens.add(sToken);

        // bouger le curseur sur le caractère suivant
        reader.nextCharForward();
    }

    /**
     * Méthode à éxecuter dans le cas où le caractère courant est un opérator
     * 
     * @param currentChar le caractère courant à analyser
     */
    private void caseCharIsSeparator(char currentChar) {
        SeparatorUnit separator = new SeparatorUnit(currentChar);
        Token sToken = new Token(lineNumber, separator);
        tokens.add(sToken);

        // bouger le curseur sur le caractère suivant
        reader.nextCharForward();
    }

    // getter de la liste de Token traité
    public ArrayList<Token> getTokens() {
        return tokens;
    }

}
