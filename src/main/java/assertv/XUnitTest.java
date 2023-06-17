package main.java.assertv;

public class XUnitTest {

    private static final String[] METHODS = {
        "runTest"
    };

    public static void main(String[] args) {

        for (String METHOD : METHODS) {
            new TestCaseTest(METHOD).run();
        }
    }
}
