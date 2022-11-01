package lexicalUnit;

import enums.OperatorEnum;
import lexicalUnit.interfaces.IEntity;
import lexicalUnit.interfaces.ILexicalUnit;


@IEntity(typeModel = OperatorUnit.class)
public class OperatorUnit implements ILexicalUnit {

    private char operator;

    public OperatorUnit(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    @Override
    public String getStrToken() {
        return String.valueOf(operator);
    }

    /**
     * Methide qui vérifie si l'operator passé en paramètre est un opérateur
     * contenue dans l'Enum des opérateurs
     * 
     * @param operator opérateur à vérifier
     * @return true si l'opérateur est un opérateur, false sinon
     */
    public static boolean isOperator(char operator) {
        for (OperatorEnum op : OperatorEnum.values()) {
            if (op.getSymbole() == operator) {
                return true;
            }
        }
        return false;
    }

}
