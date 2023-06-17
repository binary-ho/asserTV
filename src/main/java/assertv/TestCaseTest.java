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

    public void runTest() {
        Assertions.assertEquals(false, wasRun.wasRun);
        wasRun.run();

        List<MethodCall> methodCallLogs = wasRun.getMethodCallLogs();
        Assertions.assertEquals(methodCallLogs.get(methodCallLogs.size() - 1), MethodCall.SET_WAS_RUN_TRUE);

        Assertions.assertEquals(true, wasRun.wasRun);
    }

    public void setUpTest() {
        Assertions.assertEquals(false, wasRun.wasSetUp);
        wasRun.run();

        List<MethodCall> methodCallLogs = wasRun.getMethodCallLogs();
        Assertions.assertEquals(methodCallLogs.get(0), MethodCall.SET_UP);

        Assertions.assertEquals(true, wasRun.wasSetUp);
    }
}
