package library;

import java.io.Serializable;
import java.util.StringJoiner;

public class CodeInstruction implements Serializable {
    Operation operation;
    Token result;
    Token firstArg;
    Token secondArg;

    public CodeInstruction(Operation operation, Token firstArg) {
        this.operation = operation;
        this.firstArg = firstArg;
    }

    public Operation getOperation() {
        return operation;
    }

    public Token getResult() {
        return result;
    }

    public Token getFirstArg() {
        return firstArg;
    }

    public Token getSecondArg() {
        return secondArg;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setResult(Token result) {
        this.result = result;
    }

    public void setFirstArg(Token firstArg) {
        this.firstArg = firstArg;
    }

    public void setSecondArg(Token secondArg) {
        this.secondArg = secondArg;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add(operation.toString());
        sj.add(result.toString());
        sj.add(firstArg.toString());
        if (secondArg != null) sj.add(secondArg.toString());
        return sj.toString();
    }
}
