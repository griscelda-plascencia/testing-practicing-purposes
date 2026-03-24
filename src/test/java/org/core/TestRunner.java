package org.core;

import org.testng.TestNG;
import java.util.Collections;

public class TestRunner {

    public static void main(String[] args) {
        String suitePath = "src/main/resources/Suites/Suite.xml";
        TestNG testNG = new TestNG();
        testNG.setTestSuites(Collections.singletonList(suitePath));
        try {
            testNG.run();
        } catch (Exception e) {
            System.err.println("Failed to run TestNG suite: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
