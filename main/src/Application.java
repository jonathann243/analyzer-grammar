import java.util.List;

import exceptionCustom.LexicalAnalyzerException;
import lexicalAnalyzer.LexicalAnalyzer;
import utilitaire.Utils;
import views.Menu;

import static utilitaire.Utils.*;


public class Application {
    public static void start() throws LexicalAnalyzerException {
        // Récupération de la saisie utilisateur
        int indice = -1;
        String nameFile;
        boolean exit = false;

        while(!exit){
            // Affichage du menu
            Menu.showMenu();
            indice = Utils.getInputOnlyDigit("\n\tVeuillez choisir une option valide : ");
            if(indice == 0){
                Utils.copyright();
                exit = true;
            }
            else if(indice == 3){
                nameFile = Utils.getInput("\n\t " + "ANALYSE LEXICALE : " + "Veuillez saisir le nom de votre fichier " +
                        "(exemple : " + "testFile1" + ")");
                openTestFile(nameFile);
            }
            else
                openTestFile(String.valueOf(indice));
        }
        Utils.closeScanner();
    }

    /**
     * Méthode qui permet d'ouvrir le ficher test dont l'utilisateur aura choisi
     * @param nameFile le numéro correspondant au test dont l'utilisateur veut exécuter ou le nom du fichier.
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse lexicale, elle catégorise l'erreur selon son type
     */
    private static void openTestFile(String nameFile) throws LexicalAnalyzerException {
        List<String> allLinesFile = Utils.readFile(nameFile);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lancement de l'analyse Lexicale
        startLexicalAnalyzer(allLinesFile, nameFile);
    }

    /**
     * pré-lancement du lexical analyzer
     *
     * @param inputList la liste qui contient tous les contenues récupérées depuis le fichier
     * @throws LexicalAnalyzerException lorsqu'une erreur survient lors de l'analyse lexicale, elle catégorise l'erreur selon son type
     */
    private static void startLexicalAnalyzer(List<String> inputList, String nameFile) throws LexicalAnalyzerException {
        if(isDigit(nameFile.charAt(0))){
            nameFile = "testFile" + nameFile;
        }

        if (inputList.isEmpty()) {
            System.out.println("\tANALYSE LEXICALE $> Désolé, Le fichier est vide !");
        } else {
            System.out.println("=================== FILE " + nameFile + ".txt =================");
            for (int i = 0; i < inputList.size(); i++){
                System.out.println((i+1) + ".\t" + inputList.get(i));
            }
            System.out.println("==========================================================");

            // Début du traitement d'analyse lexicale
            LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(inputList);
            lexicalAnalyzer.start();
        }
    }
}
