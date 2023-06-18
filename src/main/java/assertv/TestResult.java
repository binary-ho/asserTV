package main.java.assertv;

public class TestResult {

    private int runCount = 0;
    private int failCount = 0;

    public void startTest() {
        runCount++;
    }

    public void fail() {
        failCount++;
    }

    public String getSummary() {
        return new StringBuilder("test result : ")
            .append(runCount)
            .append(" run, ")
            .append(failCount)
            .append(" failed!")
            .toString();
    }
}
