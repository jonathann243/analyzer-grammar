package enums;

public enum OperatorEnum {
    PLUS('+'), MOINS('-'), MULTIPLY('*'), DIVISE('/');

    private char symbole;

    OperatorEnum(char symbole) {
        this.symbole = symbole;
    }

    public char getSymbole() {
        return symbole;
    }
}
