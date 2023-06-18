package main.java.assertv;

public class XUnitTest {

    private static final String[] METHODS = {
        "runTemplateMethod", "collectTestResult"
    };

    public static void main(String[] args) {

        for (String METHOD : METHODS) {
            new TestCaseTest(METHOD).run();
        }
    }
}
