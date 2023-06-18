package main.java.assertv;

import java.lang.reflect.Method;

public abstract class TestCase {

    private final String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public TestResult run() {
        TestResult testResult = new TestResult();
        testResult.startTest();

        setUp();

        try {
            Method method = getClass().getMethod(methodName);
            method.invoke(this);
        } catch (Exception e) {
            testResult.fail();
        } finally {
            tearDown();
        }
        return testResult;
    }

    abstract public void setUp();
    abstract public void tearDown();
}
