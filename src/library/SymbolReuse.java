package library;

import java.io.Serializable;

public enum SymbolReuse implements Serializable {
    FORBIDDEN(),
    FREE(),
    TAKEN()
}
