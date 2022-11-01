package utilitaire;

import lexicalUnit.IdentificatorUnit;
import lexicalUnit.KeyWordUnit;
import lexicalUnit.OperatorUnit;
import lexicalUnit.SeparatorUnit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Utils {
    static Scanner scanner = new Scanner(System.in);
    /**
     * Methode qui permet de récupérer les inputs en chaine de caractère entrés par
     * l'utilisateur
     */
    public static String getInput(String message) {
        System.out.print(message);
        System.out.print("\n\t $> ");
        return scanner.nextLine();
    }

    /**
     * Methode qui permet de récupérer les inputs en entier entrés par l'utilisateur
     * N'accepte que les entiers (chiffres)
     */
    public static int getInputOnlyDigit(String message) {
        String response;
        do {
            System.out.print(message);
            System.out.print("\n\t $> ");
            response = scanner.nextLine();
        } while (!isDigit(response, true));
        return Integer.parseInt(response);
    }

    /**
     * Methode qui permet de récupérer l'input en char entré par l'utilisateur
     * N'accepte que le char (le caractère)
     */
    public static char getInputOnlyChar(String message) {
        char ch;
        do {
            System.out.print(message);
            ch =  scanner.nextLine().toLowerCase().charAt(0);
        } while (!isLetter(ch));
        return ch;
    }

    /**
     * Methode qui vérifie si chaque character de la chaine de caractère passé en
     * paramètre est un chiffre
     */
    public static boolean isDigit(String str, boolean opt) {
        if(opt){
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        else{
            // regex pour vérifier si c'et un entier ou reel
            return str.matches("[0-9]{1,13}(\\.[0-9]+)?");
        }
    }

    /**
     * Methode qui vérifie si le character passé en paramètre est un chiffre
     */
    public static boolean isDigit(char ch){
        return Character.isDigit(ch);
    }

    /**
     * Methode qui vérifie si le character passé en paramètre est une lettre
     */
    public static boolean isLetter(char ch){
        return Character.isLetter(ch);
    }

    /**
     * Methode qui vérifie si le character passé en paramètre est un opérateur
     */
    public static boolean isOperator(char ch){
        return OperatorUnit.isOperator(ch);
    }

    /**
     * Methode qui vérifie si la chaine des caractères passée en paramètre est un mot clé
     */
    public static boolean isKeyWord(String str){
        return KeyWordUnit.isKeyWord(str);
    }

    /**
     * Methode qui vérifie si la chaine des caractères passée en paramètre est un identificator
     */
    public static boolean isIdentificator(String str){
        return IdentificatorUnit.isIdentificator(str);
    }

    /**
     * Methode qui vérifie si la chaine des caractères passée en paramètre contient un '_' underscore
     */
    public static boolean isContainsUndescore(String str){
        return IdentificatorUnit.containsUnderscore(str);
    }

    /**
     * Methode qui vérifie si le character passé en paramètre est un separator
     */
    public static boolean isSeparator(char ch){
        return SeparatorUnit.isSeparator(ch);
    }

    /* Copyright */
    public static void copyright() {
        System.out.println("\t╔═════════════════════════════════════════════════════════════╗");
        System.out.println("\t║ \t    Copyright 2021 - Toute Reproduction Interdite ©       ║");
        System.out.println("\t║ @Authors : Anonymous coder ║");
        System.out.println("\t╚═════════════════════════════════════════════════════════════╝");
        Utils.closeScanner();
    }

    public static List<String> readFile(String fileName) {
        String path = null;

        if(Character.isDigit(fileName.charAt(0))){
            path = "main/src/testsFiles/testFile" + fileName.charAt(0);
        }
        else if(Character.isLetter(fileName.charAt(0))){
            path = "main/src/testsFiles/" + fileName;
        }

        List<String> lines = new ArrayList<>();
        try {
            assert path != null;
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("ANALYSE LEXICALE : Le fichier \""
                    + fileName + "\" est introuvable, assurez-vous de l'avoir placé dans le dossier "
                    + "'./src/testsFiles/'");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
