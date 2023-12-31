package main.java.assertv;

import java.util.ArrayList;
import java.util.List;

public class WasRun extends TestCase {

    private final List<MethodCall> methodCallLogs;

    public WasRun(String methodName) {
        super(methodName);
        methodCallLogs = new ArrayList<>();
    }

    @Override
    public void setUp() {
        methodCallLogs.add(MethodCall.SET_UP);
    }

    @Override
    public void tearDown() {
        methodCallLogs.add(MethodCall.TEAR_DOWN);
    }

    public void setWasRunTrue() {
        methodCallLogs.add(MethodCall.SET_WAS_RUN_TRUE);
    }

    public void testBrokenMethod() {
        throw new AssertionError();
    }

    public List<MethodCall> getMethodCallLogs() {
        return List.copyOf(methodCallLogs);
    }
}
