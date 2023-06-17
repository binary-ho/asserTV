package main.java.assertv;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {

    private final String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public void run() {
        try {
            Method method = getClass().getMethod(methodName);
            method.invoke(this);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
