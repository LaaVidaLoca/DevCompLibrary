package library;

import java.io.Serializable;
import java.util.List;

public class PostCodeDTO implements Serializable {
    private final List<Symbol> symbolList;
    private final List<CodeInstruction> instructionList;

    public PostCodeDTO(List<Symbol> symbolList, List<CodeInstruction> instructionList) {
        this.symbolList = symbolList;
        this.instructionList = instructionList;
    }

    public List<Symbol> getSymbolList() {
        return symbolList;
    }

    public List<CodeInstruction> getInstructionList() {
        return instructionList;
    }
}
