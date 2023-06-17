package main.java.assertv;

import java.util.ArrayList;
import java.util.List;

public class WasRun extends TestCase {

    public boolean wasRun = false;
    public boolean wasSetUp = false;
    private final List<MethodCall> methodCallLogs;

    public WasRun(String methodName) {
        super(methodName);
        methodCallLogs = new ArrayList<>();
    }

    @Override
    public void setUp() {
        wasSetUp = true;
        methodCallLogs.add(MethodCall.SET_UP);
    }

    public void setWasRunTrue() {
        wasRun = true;
        methodCallLogs.add(MethodCall.SET_WAS_RUN_TRUE);
    }

    public List<MethodCall> getMethodCallLogs() {
        return List.copyOf(methodCallLogs);
    }
}
