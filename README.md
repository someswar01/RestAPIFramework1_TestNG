# 🚀 Rest API Automation Framework | Java | Rest Assured | TestNG | Jenkins | Allure | Extent Reports

A scalable, reusable, and enterprise-level REST API Automation Framework built using **Java**, **Rest Assured**, **TestNG**, and **Maven** following industry best practices.

---

# 📌 Tech Stack

- Java 21
- Rest Assured
- TestNG
- Maven
- Log4j2
- Extent Reports
- Allure Reports
- Jenkins
- Jenkins Pipeline
- Git & GitHub
- Jackson
- JSON Schema Validation

---

# 📂 Project Structure

```
APIFramework1
│
├── src
│   ├── main
│   │     ├── constants
│   │     ├── enums
│   │     ├── managers
│   │     ├── models
│   │     ├── requests
│   │     ├── specifications
│   │     ├── utilities
│   │     └── listeners
│   │
│   └── test
│         ├── tests
│         ├── base
│         └── resources
│
├── reports
├── target
├── Jenkinsfile
├── testng.xml
├── pom.xml
└── README.md
```

---

# ✨ Features

✔ Generic Rest Client

✔ Request Builder Pattern

✔ Authentication Token Management

✔ Response Specification

✔ Request Specification

✔ API Chaining

✔ Reusable Utilities

✔ Logging using Log4j2

✔ Extent HTML Reports

✔ Allure Reports

✔ Jenkins CI Integration

✔ Jenkins Declarative Pipeline

✔ JSON Schema Validation

✔ TestNG Execution

✔ Maven Build Support

---

# 🏗 Framework Design

```
Test

↓

Service Layer

↓

Rest Client

↓

Request Builder

↓

Response Specification

↓

Rest Assured
```

---

# 🚀 Reports

## Extent Report

```
reports/
    API-Automation-Report.html
```

Contains

- Test Summary
- Pass/Fail Status
- Execution Time
- Logs
- Exception Details

---

## Allure Report

Generated under

```
target/allure-results
```

View inside Jenkins

or

```
allure serve target/allure-results
```

---

# ⚙ Running Tests

## Using Maven

```bash
mvn clean test
```

---

## Using TestNG

```
testng.xml
```

Run the suite directly from IDE.

---

# 🔥 Jenkins Pipeline

Pipeline stages

```
Checkout

↓

Build

↓

Execute Tests

↓

Generate Allure Report

↓

Archive Artifacts
```

---

# 📊 Reports Generated

✅ Extent HTML Report

✅ Allure Dashboard

---

# 📸 Jenkins Pipeline

- Git Checkout
- Maven Build
- Test Execution
- Allure Report Generation
- Artifact Archival

---

# 📁 Current Test Coverage

Authentication API

- Login

Product API

- Add Product
- Get Product
- Delete Product

Order API

- Create Order
- Get Order Details

---

# 🧩 Design Patterns Used

- Builder Pattern
- Singleton Pattern
- Factory Pattern
- Utility Pattern
- Service Layer Pattern

---

# 📈 CI/CD

Integrated with

- Jenkins
- GitHub
- Maven
- Allure

---

# 🛠 Future Enhancements

- Docker Integration
- GitHub Actions
- Retry Analyzer
- Parallel Execution
- Environment Configuration
- Slack Notifications
- SonarQube Integration
- Performance Testing
- API Data Driven Framework

---

# 👨‍💻 Author

**Somesh C**

Automation Test Engineer

Skills

- Java
- Rest Assured
- Selenium
- Playwright
- TestNG
- Jenkins
- Maven
- Git
- Azure DevOps

---

# ⭐ If you found this project useful

Please give this repository a ⭐ on GitHub.
