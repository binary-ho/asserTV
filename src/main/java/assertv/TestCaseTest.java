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

    public void runTemplateMethod() {
        wasRun.run();
        validateMethodCallLogs();
    }

    private void validateMethodCallLogs() {
        List<MethodCall> methodCallLogs = wasRun.getMethodCallLogs();
        Assertions.assertEquals(methodCallLogs.get(0), MethodCall.SET_UP);
        Assertions.assertEquals(methodCallLogs.get(1), MethodCall.SET_WAS_RUN_TRUE);
    }
}
