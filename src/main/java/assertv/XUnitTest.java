package main.java.assertv;

public class XUnitTest {

    private static final String[] METHODS = {
        "runTemplateMethod", "collectTestResult", "formatTestFailedResult", "testFailedResult", "testSuite"
    };

    public static void main(String[] args) {

        TestResult testResult = new TestResult();

        for (String METHOD : METHODS) {
            new TestCaseTest(METHOD).run(testResult);
        }

        System.out.println(testResult.getSummary());
    }
}
