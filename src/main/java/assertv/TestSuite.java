package main.java.assertv;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private final List<TestCase> tests = new ArrayList<>();

    public void add(TestCase test) {
        tests.add(test);
    }

    public void run(TestResult testResult) {
        tests.forEach(test -> test.run(testResult));
    }
}
