package views;

public class Menu {
    /**
     * Methode qui permet de lire le menu principal de l'Application
     */
    public static void showMenu() {
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t╔═════════════════════╗");
        System.out.println("\t\t\t\t\t\t║    MENU PRINCIPAL   ║");
        System.out.println("\t\t\t\t\t\t╚═════════════════════╝" );
        System.out.println("\tTous les fichiers se trouvent sur le path (\"src/testsFiles\")"
                + "\n\t Entrer le numero correspondant au fichier à ouvrir");
        System.out.println("\t 1. Test [correct]");
        System.out.println("\t 2. Test [incorrect] (une variable ne doit pas commencer avec un chiffre)");
        System.out.println("\t 3. Test (Entrer le nom de votre fichier)");
        System.out.println("\t 0. Quitter");
    }
}
