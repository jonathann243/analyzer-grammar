package enums;

public enum KeyWordEnum {

    PROCEDURE("Procedure"), FIN_PROCEDURE("Fin_Procedure"), DECLARE("declare"), ENTIER("entier"), REEL("reel");

    private final String keyWord;

    KeyWordEnum(String str) {
        this.keyWord = str;
    }

    public String getKeyWord() {
        return keyWord;
    }

}
