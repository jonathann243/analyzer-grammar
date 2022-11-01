package exceptionCustom;

import enums.LexicalAnalyzerExceptionEnums;

public class LexicalAnalyzerException extends Exception {

    public LexicalAnalyzerException(LexicalAnalyzerExceptionEnums typeEnum, int nLine){
        super(typeEnum.getMessage(nLine));
    }
}
