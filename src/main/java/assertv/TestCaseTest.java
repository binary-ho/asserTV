package main.java.assertv;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String methodName) {
        super(methodName);
    }

    public void runTest() {
        WasRun wasRun = new WasRun("setWasRunTrue");
        Assertions.assertEquals(false, wasRun.wasRun);
        wasRun.run();
        Assertions.assertEquals(true, wasRun.wasRun);
    }

    public void setUpTest() {
        WasRun wasRun = new WasRun("setWasRunTrue");
        Assertions.assertEquals(false, wasRun.wasSetUp);
        wasRun.run();
        Assertions.assertEquals(true, wasRun.wasSetUp);
    }
}
