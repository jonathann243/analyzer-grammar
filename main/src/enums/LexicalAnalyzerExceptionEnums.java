package enums;

public enum LexicalAnalyzerExceptionEnums {

    IDENTIFIANT_UNDERSCORE_ERROR(
            "Erreur Lexical (IDENTIFACATEUR-UNDERSCORE-ERROR) : L'Identifiant n'est pas correct, " +
                    "car il contient le caractère '_'"
    ),
    IDENTIFIANT_ERROR(
            "Erreur Lexical (IDENTIFICATEUR-ERROR) : L'Identifiant n'est pas correct, " +
                    "car il ne respecte pas les normes de nomenclature définis, voir dans votre fichier"
    ),
    DIGIT_ERROR(
            "Erreur Lexical (DIGIT-ERROR) : L'entier saisit n'est pas correct, " +
                    "car il ne respecte pas les normes de nomenclature définis, voir dans votre fichier"
    );;

    private final String message;

    LexicalAnalyzerExceptionEnums(String message) {
        this.message = message;
    }

    public String getMessage(int nLine) {
        return message + " (ligne " + nLine + ")";
    }
}
