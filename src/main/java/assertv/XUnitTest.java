package main.java.assertv;

public class XUnitTest {

    private static final String[] METHODS = {
        "runTemplateMethod", "collectTestResult", "formatTestFailedResult", "testFailedResult", "testSuite"
    };

    public static void main(String[] args) {

        TestSuite testSuite = new TestSuite();
        addAllMethods(testSuite);

        TestResult testResult = new TestResult();
        testSuite.test(testResult);
        System.out.println(testResult.getSummary());

        TestSuite testSuite1 = new TestSuite();
        testSuite1.add(new TestCaseTest("runTemplateMethod"));
        testSuite1.add(testSuite);
        testSuite1.add(testSuite);
        testSuite1.add(testSuite);
        TestResult testResult1 = new TestResult();
        testSuite1.test(testResult1);
        System.out.println(testResult1.getSummary());
    }

    private static void addAllMethods(TestSuite testSuite) {
        for (String METHOD : METHODS) {
            testSuite.add(new TestCaseTest(METHOD));
        }
    }
}
