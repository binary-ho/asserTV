package main.java.assertv;

public class TestResult {

    private int runCount = 0;

    public void increaseRunCount() {
        runCount++;
    }

    public String getSummary() {
        return runCount + " 1 run, 0 failed";
    }
}
