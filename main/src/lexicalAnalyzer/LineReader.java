package lexicalAnalyzer;


public class LineReader {
    private String line;
    private int cursor;
    private boolean eol;

    public LineReader() {
        cursor = 0;
        eol = false;
    }

    /**
     * Méthode qui permet de setter une nouvelle ligne à traiter
     * 
     * @param line la nouvelle ligne à traiter
     */
    public void setLine(String line) {
        this.line = line;
        cursor = 0;
        eol = false;
    }

    /**
     * Getter de la ligne
     */
    public String getLine() {
        return line;
    }

    /**
     * Méthode qui permet de récupérer le caractère suivant
     * 
     * @return Char - le caractère suivant
     */
    public char nextChar() {
        if (isEOL()) {
            eol = true;
            return '\0';
        }
        return line.charAt(++cursor);
    }

    /**
     * Méthode qui permet de récupérer le caractère précédent
     * 
     * @return Char - le caractère précédent
     */
    public char prevChar() {
        if (cursor <= 0) {
            return '\0';
        }
        return line.charAt(--cursor);
    }

    /**
     * Méthode qui donne le caractère courant
     * 
     * @return Char - le caractère courant
     */
    public char currentChar() {
        if (isEOL()) {
            return '\0';
        }
        return line.charAt(cursor);
    }

    /**
     * Méthode qui permet de bouger le curseur en avant et signale la fin de la
     * ligne
     * 
     */
    public void nextCharForward() {
        if (isEOL()) {
            eol = true;
        } else {
            cursor++;
        }
    }

    /**
     * Méthode qui permet de revenir un pas en arrière avec le curseur
     * 
     */
    public void moveCursorBack() {
        if (cursor <= 0) {
            return;
        }
        cursor--;
    }

    /**
     * Méthode qui permet de savoir si on est à la fin de la ligne
     * 
     * @return boolean - true si on est à la fin de la ligne, false sinon
     */
    public boolean isEOL() {
        return cursor >= line.length();
    }

    /**
     * Méthode qui permet de savoir si on est au début de la ligne
     * 
     * @return boolean - true si on est au début de la ligne, false sinon
     */
    public boolean isBOL() {
        return cursor == 0;
    }

}
