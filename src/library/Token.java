package library;

;import java.io.Serializable;

public class Token implements Nodal, Serializable {
    private final Lexeme lexeme;
    private Number attribute;


    public Token(Lexeme name, Number attribute) {
        this(name);
        this.attribute = attribute;
    }

    public Token(Lexeme name) {
        this.lexeme = name;
    }

    public Lexeme getLexeme() {
        return lexeme;
    }

    public Number getAttribute() {
        return attribute;
    }

    @Override
    public String toString() {
        return "<" + switch (lexeme) {
            case ID -> lexeme.getValue() + "," + this.attribute;
            case INT_CONST, FLOAT_CONST -> String.valueOf(this.attribute);
            default -> lexeme.getValue();
        } + ">";
    }

    public String out() {
        return this + " - " + lexeme.getDescription();
    }
}
