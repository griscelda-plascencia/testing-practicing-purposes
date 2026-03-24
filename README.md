API Test Automation Framework
This project is a Java-based API test automation framework for testing the JSONPlaceholder REST service. It uses RestAssured and TestNG, follows a layered architecture, and supports parallel test execution.

**Project Structure**

src
 ├── main
 │    └── resources
 │         └── Suites
 │              └── Suite.xml
 └── test
      └── java
           └── org
                ├── core           # Test runner classes (if any)
                ├── domain         # POJOs, endpoint definitions, payloads
                ├── tests          # Test classes grouped by endpoint, HTTP client/helper classes
                └── utils          # Common utility methods

How to Run Tests
Clone the repository
Install dependencies and run tests:
mvn clean test

TestNG Suite:
The main suite file is at src/main/resources/Suites/Suite.xml.
You can run it directly from your IDE or via Maven.

Design Decisions:
Layered Architecture:
core: HTTP clients, configuration, base classes.
domain: POJOs for requests/responses, endpoint definitions, business abstractions.
tests: Test logic grouped by endpoint/resource.

Frameworks Used:
RestAssured for HTTP requests and assertions.
TestNG for test orchestration and parallel execution.
Jackson for JSON serialization/deserialization.

Parallel Execution
Enabled via TestNG Suite.xml:
The suite is configured with parallel="tests" and a thread-count for concurrent execution.
