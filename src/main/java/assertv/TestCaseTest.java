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
        TestResult testResult = wasRun.run();
        Assertions.assertEquals("test result : 1 run, 0 failed!", testResult.getSummary());
    }

    public void formatTestFailedResult() {
        TestResult testResult = wasRun.run();
        testResult.fail();

        Assertions.assertEquals("test result : 1 run, 1 failed!", testResult.getSummary());
    }

    private void validateMethodCallLogs() {
        List<MethodCall> methodCallLogs = wasRun.getMethodCallLogs();
        Assertions.assertEquals(MethodCall.SET_UP, methodCallLogs.get(0));
        Assertions.assertEquals(MethodCall.SET_WAS_RUN_TRUE, methodCallLogs.get(1));
        Assertions.assertEquals(MethodCall.TEAR_DOWN, methodCallLogs.get(2));
    }
}
