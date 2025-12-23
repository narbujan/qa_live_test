# QA Live Test

This is a qa candidate live test coding project

## Project Overview

This project demonstrates integrates Cucumber JVM with Spring Boot using JUnit 5. It uses:
- **Spring Boot 4.0.1**
- **Cucumber JVM** (Java, JUnit Platform Engine, Spring integration)
- **Lombok** to reduce boilerplate
- **Java 25**

## Getting Started

### Prerequisites

- Java 25
- Gradle

### Running Tests

You can run the tests using Gradle:

```bash
./gradlew test
```

The tests are configured to run via the `TestRunner` class using the JUnit 5 `@Suite` annotation.

## Project Structure

- `src/main/java/qa_live_test`: Main application and configuration files.
- `src/test/java/features`: Cucumber feature files.
- `src/main/java/qa_live_test/steps`: Step definitions for Cucumber.
- `src/main/java/qa_live_test/context`: Test context for sharing state between steps.
- `src/main/java/qa_live_test/runner`: JUnit 5 suite runner for Cucumber.
