package main.java.assertv;

import java.util.function.Supplier;

public class Assertions {

    public static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(
                "expected <" + expected + "> but was <" + actual + ">"
            );
        }
    }

    public static void assertThrow(Class<? extends Throwable> expected, Supplier<?> supplier) {
        try {
            supplier.get();
        } catch (Throwable actualError) {
            if (expected.getClass().equals(actualError.getClass())) {
                return;
            }
        }

        throw new AssertionError();
    }
}
