package library;

import java.io.Serializable;

public enum Type implements Serializable {
    FLOAT(" [вещественный]"),
    INT(" [целый]");
    public final String description;

    Type(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
