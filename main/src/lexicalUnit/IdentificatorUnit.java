package lexicalUnit;

import lexicalUnit.interfaces.IEntity;
import lexicalUnit.interfaces.ILexicalUnit;


@IEntity(typeModel = IdentificatorUnit.class)
public class IdentificatorUnit implements ILexicalUnit {

    private String identificator;

    public IdentificatorUnit(String identificator) {
        this.identificator = identificator;
    }

    public String getIdentificator() {
        return identificator;
    }

    @Override
    public String getStrToken() {
        return identificator;
    }

    /**
     * Methode qui perme de vérifier que le mot passé en pamaètre a une taille
     * inférieure ou égale à 8 caractères
     */
    public static boolean isIdentificator(String identificator) {
        return identificator.trim().length() <= 8;
    }

    /**
     * Methode qui permet de vérifier que si le mot passé en paramètre contient '_'
     * underscore
     */
    public static boolean containsUnderscore(String identificator) {
        return identificator.contains("_");
    }

}
