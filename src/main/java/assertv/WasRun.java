package main.java.assertv;

public class WasRun extends TestCase {

    public boolean wasRun = false;
    public boolean wasSetUp = false;

    public WasRun(String methodName) {
        super(methodName);
    }

    public void setWasRunTrue() {
        wasRun = true;
    }

    @Override
    public void setUp() {
        wasSetUp = true;
    }
}
