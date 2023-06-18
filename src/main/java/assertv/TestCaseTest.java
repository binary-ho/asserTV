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
        wasRun.run();
    }

    public void collectTestResult() {
        TestResult testResult = wasRun.run();
        Assertions.assertEquals(
            renderExpectedResultString(1, 0), testResult.getSummary()
        );
    }

    public void formatTestFailedResult() {
        TestResult testResult = wasRun.run();
        testResult.fail();

        Assertions.assertEquals(
            renderExpectedResultString(1, 1), testResult.getSummary()
        );
    }

    public void testFailedResult() {
        wasRun = new WasRun("testBrokenMethod");
        Assertions.assertThrow(AssertionError.class, () -> wasRun.run());
    }

    private void validateMethodCallLogs() {
        List<MethodCall> methodCallLogs = wasRun.getMethodCallLogs();
        Assertions.assertEquals(MethodCall.SET_UP, methodCallLogs.get(0));
        Assertions.assertEquals(MethodCall.TEAR_DOWN, methodCallLogs.get(methodCallLogs.size() - 1));
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
