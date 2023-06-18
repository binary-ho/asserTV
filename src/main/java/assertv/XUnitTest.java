package main.java.assertv;

import main.java.assertv.assertions.Assertions;

public class XUnitTest {

    private static final String[] METHODS = {
        "runTemplateMethod", "collectTestResult", "formatTestFailedResult", "testFailedResult", "testSuite"
    };

    public static void main(String[] args) {

        TestSuite testSuite = new TestSuite();
        addAllMethods(testSuite);

        TestResult testResult = new TestResult();
        testSuite.run(testResult);
        System.out.println(testResult.getSummary());
    }

    private static void addAllMethods(TestSuite testSuite) {
        for (String METHOD : METHODS) {
            testSuite.add(new TestCaseTest(METHOD));
        }
    }
}
