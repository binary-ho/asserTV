package main.java.assertv;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Testable {
    private final List<Testable> tests = new ArrayList<>();

    public void add(Testable test) {
        tests.add(test);
    }

    public void test(TestResult testResult) {
        tests.forEach(test -> test.test(testResult));
    }
}
