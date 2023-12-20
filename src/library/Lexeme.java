package library;

public enum Lexeme {
    MULTIPLY("*", "операция умножения", LexemeType.HIGH_PRIORITY_OPERATOR),
    SUBTRACT("-", "операция вычитания", LexemeType.LOW_PRIORITY_OPERATOR),
    ADD("+", "операция сложения", LexemeType.LOW_PRIORITY_OPERATOR),
    DIVIDE("/", "операция деления", LexemeType.HIGH_PRIORITY_OPERATOR),
    OPEN_BRACE("(", "открывающая скобка", LexemeType.BRACE),
    CLOSE_BRACE(")", "закрывающая скобка", LexemeType.BRACE),
    ID("id", "идентификатор", LexemeType.ID),
    INT_CONST("константа целого типа", LexemeType.CONST),
    FLOAT_CONST("константа вещественного типа", LexemeType.CONST);
    private String value;
    private final String description;
    private final LexemeType lexemeType;

    public LexemeType getLexemeType() {
        return lexemeType;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }


    Lexeme(String value, String description, LexemeType lexemeType) {
        this.value = value;
        this.description = description;
        this.lexemeType = lexemeType;
    }

    Lexeme(String description, LexemeType lexemeType) {
        this.description = description;
        this.lexemeType = lexemeType;
    }


}
