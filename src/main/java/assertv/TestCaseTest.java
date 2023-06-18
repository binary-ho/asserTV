package main.java.assertv;

import java.util.List;

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
        TestResult result = wasRun.run();
        Assertions.assertEquals("1 run, 0 failed", result.getSummary());
    }

    private void validateMethodCallLogs() {
        List<MethodCall> methodCallLogs = wasRun.getMethodCallLogs();
        Assertions.assertEquals(methodCallLogs.get(0), MethodCall.SET_UP);
        Assertions.assertEquals(methodCallLogs.get(1), MethodCall.SET_WAS_RUN_TRUE);
        Assertions.assertEquals(methodCallLogs.get(2), MethodCall.TEAR_DOWN);
    }
}
