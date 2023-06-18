package main.java.assertv;

import java.lang.reflect.Method;

public abstract class TestCase implements Testable {

    private final String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public void test(TestResult testResult) {
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
    }

    abstract public void setUp();
    abstract public void tearDown();
}
