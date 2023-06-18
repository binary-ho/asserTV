package main.java.assertv.assertions;

@FunctionalInterface
public interface ThrowingCallable {

    void call() throws Throwable;
}
