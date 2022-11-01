package lexicalAnalyzer;

import lexicalUnit.interfaces.IEntity;
import lexicalUnit.interfaces.ILexicalUnit;


public class Token {
    private final String strToken;
    private final IEntity entity;
    private final Class classToken;
    private final int lineNumber;

    public <T extends ILexicalUnit> Token(int nLine, T token) {
        this.strToken = token.getStrToken();
        this.entity = token.getClass().getAnnotation(IEntity.class);
        this.classToken = this.entity.typeModel();
        this.lineNumber = nLine;
    }

    public String getStrToken() {
        return strToken;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public Class getClassToken() {
        return classToken;
    }

    public IEntity getEntity() {
        return entity;
    }

}
