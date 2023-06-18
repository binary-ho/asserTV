package main.java.assertv;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private final List<WasRun> tests = new ArrayList<>();

    public void add(WasRun test) {
        tests.add(test);
    }

    public void run(TestResult testResult) {
        tests.forEach(test -> test.run(testResult));
    }
}
