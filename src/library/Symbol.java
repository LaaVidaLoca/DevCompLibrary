package library;

import java.io.Serializable;
import java.util.Objects;

public class Symbol implements Serializable {
    private final String name;
    private final Type type;
    private SymbolReuse symbolReuse;

    public Symbol(String name, Type type, SymbolReuse symbolReuse) {
        this.name = name;
        this.type = type;
        this.symbolReuse = symbolReuse;
    }

    public SymbolReuse getSymbolReuse() {
        return symbolReuse;
    }

    public Symbol setSymbolReuse(SymbolReuse symbolReuse) {
        this.symbolReuse = symbolReuse;
        return this;
    }

    public String getName() {
        return name;
    }

    public Type getSymbolType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        boolean isEquals = Objects.equals(name, symbol.name);
        if (isEquals && symbol.type != type)
            throw new RuntimeException("Идентификатор " + name + " уже объявлен с другим типом");
        return isEquals;
    }

    @Override
    public String toString() {
        return name + type;
    }
}
