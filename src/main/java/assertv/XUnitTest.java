package main.java.assertv;

public class XUnitTest {

    private static final String[] METHODS = {
        "runTemplateMethod", "collectTestResult", "formatTestFailedResult", "testFailedResult"
    };

    public static void main(String[] args) {

        for (String METHOD : METHODS) {
            System.out.println(METHOD);
            new TestCaseTest(METHOD).run();
        }
    }
}
