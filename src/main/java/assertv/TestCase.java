package main.java.assertv;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TestCase {

    private final String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public void run() {
        setUp();

        try {
            Method method = getClass().getMethod(methodName);
            method.invoke(this);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        } finally {
            tearDown();
        }
    }

    abstract public void setUp();
    abstract public void tearDown();
}
