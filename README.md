# API Test Automation Framework

This project is a **Java-based API test automation framework** for testing the [JSONPlaceholder REST service](https://jsonplaceholder.typicode.com).  
It uses **RestAssured** and **TestNG**, follows a layered architecture, and supports parallel test execution.
## 📁 Project Structure
```
src
├── main
│   └── resources
│       └── Suites
│           └── Suite.xml
└── test
    └── java
        └── org
            ├── core      # Test runner classes (e.g., TestRunner)

            ├── domain    # POJOs, endpoint definitions, payloads
            ├── tests     # Test classes grouped by endpoint/resource
            └── utils     # Common utility methods
```


## 🚀 How to
Run Tests

1. **Clone the repository:**
   ```sh
   git clone <your-repo-url>
   cd <your-repo-folder>
Install dependencies and run tests:

sh


mvn clean test
Run the TestNG Suite:

The main suite file is at src/main/resources/Suites/Suite.xml.
You can run it directly from your IDE or via Maven.

🏗️ Design Decisions
Layered Architecture
core: HTTP clients, configuration, base classes, and the main test runner.
domain: POJOs for requests/responses, endpoint definitions, business abstractions.
tests: Test logic grouped by endpoint/resource.
utils: Common utility methods for JSON parsing, payload serialization, etc.

Frameworks Used
RestAssured: For HTTP requests and assertions.
TestNG: For test orchestration, grouping, and parallel execution.
Jackson: For JSON serialization/deserialization.

⚡ Parallel Execution
Enabled via TestNG Suite.xml:
The suite is configured with parallel="tests" and a thread-count for concurrent execution.
Each test class runs in its own thread for faster feedback and better resource utilization.

📊 Reporting (Optional/Bonus)
TestNG generates HTML and XML reports in the test-output directory after each run.
(Optional) Integrate with Allure or other reporting tools for enhanced reports.

🔄 CI/CD Integration (Optional/Bonus)
The framework can be integrated with CI/CD tools like GitHub Actions or Jenkins.
Example: Add a workflow to run mvn clean test on every push or pull request.

📝 Notes
Schema validation can be added using RestAssured’s JSON schema validation module.
The framework is designed for easy extension—add new endpoints, payloads, or test classes as needed.
Follows Google Java Style Guide for code consistency.



