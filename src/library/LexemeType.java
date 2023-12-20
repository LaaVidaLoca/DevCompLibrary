package library;

public enum LexemeType {
    CONST(),
    HIGH_PRIORITY_OPERATOR(),
    LOW_PRIORITY_OPERATOR(),
    BRACE(),
    ID();
    public boolean isOperator() {
        return this == HIGH_PRIORITY_OPERATOR || this == LOW_PRIORITY_OPERATOR;
    }
}
