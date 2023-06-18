package main.java.assertv;

public class XUnitTest {

    private static final String[] METHODS = {
        "runTemplateMethod", "collectTestResult", "formatTestFailedResult"
    };

    public static void main(String[] args) {

        for (String METHOD : METHODS) {
            new TestCaseTest(METHOD).run();
        }
    }
}
