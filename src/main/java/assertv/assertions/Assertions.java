package main.java.assertv.assertions;

public class Assertions {

    public static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(
                "expected <" + expected + "> but was <" + actual + ">"
            );
        }
    }

    public static void assertThrow(Class<? extends Throwable> expected, ThrowingCallable callable) {
        try {
            callable.call();
        } catch (Throwable actualError) {
            if (expected.getClass().equals(actualError.getClass())) {
                return;
            }
        }

        throw new AssertionError();
    }
}
