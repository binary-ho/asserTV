package main.java.assertv;

public class Assertions {

    public static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(
                "expected <" + expected + "> but was <" + actual + ">"
            );
        }
    }
}
