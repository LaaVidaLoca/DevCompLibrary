package library;

import java.io.Serializable;

public enum Operation implements Serializable {

    MUL("mul"),
    DIV("div"),
    ADD("add"),
    SUB("sub"),
    I2F("i2f");

    private final String name;
    Operation(String name) {
        this.name = name;
    }

    public static Operation get(BinaryTreeNode node) {
        Nodal value = node.getValue();
        if (value.getClass() == Token.class) return switch (((Token) value).getLexeme()) {
            case MULTIPLY -> MUL;
            case SUBTRACT -> SUB;
            case ADD -> ADD;
            case DIVIDE -> DIV;
            case OPEN_BRACE, FLOAT_CONST, CLOSE_BRACE, ID, INT_CONST -> null;
        }; else return I2F;
    }

    @Override
    public String toString() {
        return name;
    }
}
