package main.java.assertv;

import java.util.List;
import main.java.assertv.assertions.Assertions;

public class TestCaseTest extends TestCase {

    private WasRun wasRun;

    public TestCaseTest(String methodName) {
        super(methodName);
    }

    @Override
    public void setUp() {
        wasRun = new WasRun("setWasRunTrue");
    }

    @Override
    public void tearDown() {
        validateMethodCallLogs();
    }

    public void runTemplateMethod() {
        TestResult testResult = new TestResult();
        wasRun.test(testResult);
    }

    public void collectTestResult() {
        TestResult testResult = new TestResult();
        wasRun.test(testResult);

        Assertions.assertEquals(
            renderExpectedResultString(1, 0), testResult.getSummary()
        );
    }

    public void formatTestFailedResult() {
        TestResult testResult = new TestResult();
        testResult.startTest();
        testResult.fail();

        Assertions.assertEquals(
            renderExpectedResultString(1, 1), testResult.getSummary()
        );
    }

    public void testFailedResult() {
        wasRun = new WasRun("testBrokenMethod");
        TestResult testResult = new TestResult();
        wasRun.test(testResult);
        Assertions.assertEquals(renderExpectedResultString(1, 1), testResult.getSummary());
//        Assertions.assertThrow(AssertionError.class, () -> wasRun.run(new TestResult()));
    }

    public void testSuite() {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new WasRun("setWasRunTrue"));
        testSuite.add(new WasRun("testBrokenMethod"));

        TestResult testResult = new TestResult();
        testSuite.test(testResult);

        Assertions.assertEquals(
            renderExpectedResultString(2, 1), testResult.getSummary()
        );
    }

    private void validateMethodCallLogs() {
        List<MethodCall> methodCallLogs = wasRun.getMethodCallLogs();
        if (!methodCallLogs.isEmpty()) {
            Assertions.assertEquals(MethodCall.SET_UP, methodCallLogs.get(0));
            Assertions.assertEquals(MethodCall.TEAR_DOWN, methodCallLogs.get(methodCallLogs.size() - 1));
        }
    }

    private String renderExpectedResultString(int runCount, int filedCount) {
        return new StringBuilder("test result : " )
            .append(runCount)
            .append(" run, ")
            .append(filedCount)
            .append(" failed!")
            .toString();
    }
}
