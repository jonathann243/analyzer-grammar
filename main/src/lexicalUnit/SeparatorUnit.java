package lexicalUnit;

import enums.SeparatorEnum;
import lexicalUnit.interfaces.IEntity;
import lexicalUnit.interfaces.ILexicalUnit;


@IEntity(typeModel = SeparatorUnit.class)
public class SeparatorUnit implements ILexicalUnit {

    private char separator;

    public SeparatorUnit(char separator) {
        this.separator = separator;
    }

    public char getSeparator() {
        return separator;
    }

    @Override
    public String getStrToken() {
        return String.valueOf(separator);
    }

    /**
     * Methode qui permet de vérifier si le separateur est un séparateur définie
     * dans l'enum SeparatorEnum
     * 
     * @param separatorValue séparateur à vérifier
     * @return true si le séparateur est un séparateur définie dans l'enum
     *         SeparatorEnum, false sinon
     */
    public static Boolean isSeparator(char separatorValue) {
        for (SeparatorEnum separator : SeparatorEnum.values()) {
            if (separator.getSeparator() == separatorValue) {
                return true;
            }
        }
        return false;
    }

}
