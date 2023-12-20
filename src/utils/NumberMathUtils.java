package utils;

public class NumberMathUtils {
    public static Number add(Number a, Number b) {
        if (a instanceof Integer) {
            return a.intValue() + b.intValue();
        } else {
            return a.doubleValue() + b.doubleValue();
        }
    }

    public static Number subtract(Number a, Number b) {
        if (a instanceof Integer) {
            return a.intValue() - b.intValue();
        } else {
            return a.doubleValue() - b.doubleValue();
        }
    }

    public static Number multiply(Number a, Number b) {
        if (a instanceof Integer) {
            return a.intValue() * b.intValue();
        } else {
            return a.doubleValue() * b.doubleValue();
        }
    }

    public static Number divide(Number a, Number b) {
        if (a instanceof Integer) {
            return a.intValue() / b.intValue();
        } else {
            return a.doubleValue() / b.doubleValue();
        }
    }
}
