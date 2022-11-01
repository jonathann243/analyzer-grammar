package lexicalUnit;

import lexicalUnit.interfaces.IEntity;
import lexicalUnit.interfaces.ILexicalUnit;

@IEntity(typeModel = NumberUnit.class)
public class NumberUnit implements ILexicalUnit {

    private String value;

    public NumberUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getStrToken() {
        return value;
    }
    
}
