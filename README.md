# 🚀 REST API Automation Framework | Rest Assured | TestNG | Java

## 📌 Overview

This project is a scalable and reusable REST API Automation Framework developed using **Java**, **Rest Assured**, and **TestNG**.

The framework follows **Layered Architecture**, **Builder Pattern**, **API Chaining**, **POJO Mapping**, and **Generic Programming** principles to make API automation clean, maintainable, and extensible.

---

# 🛠 Tech Stack

* Java
* Rest Assured
* TestNG
* Maven
* Jackson (POJO Mapping)
* Lombok
* Log4j
* Git & GitHub

---

# 📂 Framework Architecture

```
Tests
   │
   ▼
Services
   │
   ▼
Generic RestClient
   │
   ▼
Request Builder
   │
   ▼
Rest Assured
```

---

# 🔄 State Management

```
AuthenticationManager
        │
        ▼
      Token

ProductManager
        │
        ▼
     ProductId

OrderManager
        │
        ▼
      OrderId
```

The framework automatically stores and reuses runtime values across API calls.

---

# 📁 Project Structure

```
src
│
├── builders
├── client
├── config
├── constants
├── managers
├── models
├── pojo
├── services
├── specifications
├── tests
└── utils
```

---

# ✨ Features

* Generic RestClient
* Generic Request Builder
* Generic RequestData Model
* Generic Response Specification
* Builder Pattern
* Layered Architecture
* API Chaining
* POJO Serialization & Deserialization
* Authentication Manager
* Product Manager
* Order Manager
* Multipart Request Support
* Query Parameters
* Path Parameters
* Form Parameters
* Centralized Response Validation
* Reusable Services

---

# 🔥 Implemented APIs

✅ Login

✅ Add Product (Multipart)

✅ Create Order

✅ Get Order Details

✅ Delete Product

---

# 🔗 End-to-End API Flow

```
Login
   │
   ▼
Add Product
   │
   ▼
Create Order
   │
   ▼
Get Order Details
   │
   ▼
Delete Product
```

---

# 🎯 Design Patterns Used

* Layered Architecture
* Builder Pattern
* Singleton Manager
* Generic Programming
* POJO Mapping
* API Chaining

---

# ▶️ How to Run

Clone the repository

```
git clone https://github.com/someswar01/RestAPIFramework1_TestNG.git
```

Navigate to the project

```
cd RestAPIFramework1_TestNG
```

Run the tests

```
mvn clean test
```

Or execute using TestNG from your IDE.

---

# 📈 Future Enhancements

* PUT API
* PATCH API
* JSON Schema Validation
* Extent Reports
* Retry Mechanism
* Data Providers
* Environment Switching (QA/UAT/PROD)
* Jenkins Integration
* Azure Pipelines
* Docker
* Parallel Execution
* GitHub Actions

---

# 👨‍💻 Author

**Somesh C**

Automation Test Engineer

Specialized in:

* Selenium with Java
* Playwright
* REST Assured
* API Automation
* TestNG
* Cucumber
* CI/CD
* Git & GitHub

---

## ⭐ If you find this project useful, don't forget to star the repository!
