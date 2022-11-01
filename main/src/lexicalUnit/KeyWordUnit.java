package lexicalUnit;

import enums.KeyWordEnum;
import lexicalUnit.interfaces.IEntity;
import lexicalUnit.interfaces.ILexicalUnit;


@IEntity(typeModel = KeyWordUnit.class)
public class KeyWordUnit implements ILexicalUnit {

    private String keyWord;

    public KeyWordUnit(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getMotCle() {
        return keyWord;
    }

    @Override
    public String getStrToken() {
        return keyWord;
    }

    public static Boolean isKeyWord(String str) {

        for (KeyWordEnum keyWord : KeyWordEnum.values()) {
            if (keyWord.getKeyWord().equals(str))
                return true;
        }

        return false;
    }

}
