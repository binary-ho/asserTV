package main.java.assertv;

public class WasRun extends TestCase {

    public boolean wasRun = false;

    public WasRun(String methodName) {
        super(methodName);
    }

    public void setWasRunTrue() {
        wasRun = true;
    }
}
