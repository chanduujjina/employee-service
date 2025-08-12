# Employee Service

A Spring Boot application that demonstrates **CRUD operations** for managing employees using **MapStruct** for object mapping.

## 🚀 Features
- Add, update, delete, and fetch employee details
- **MapStruct** integration for DTO ↔ Entity conversion
- **Spring Boot** REST API
- **H2 Database** for easy setup
- **Global Exception Handling**
- Well-structured, modular code

---

## 🛠️ Tech Stack
- **Java 17+** (Compatible with Java 23 if configured)
- **Spring Boot** (REST, Data JPA)
- **MapStruct** (Object Mapper)
- **H2 Database** (in-line database)
- **Maven**

---

---

## **2️⃣ Project Explanation**

I’ll break it down so you can easily explain it to anyone (including in interviews):

---

### **📌 Project Goal**
The **Employee Service** project manages employees in a system.  
It provides REST APIs to **create, read, update, and delete** employee records,  
while keeping the code clean using **MapStruct** for object mapping and **Spring Boot** for REST APIs.

---

### **🔍 How It Works**
1. **Controller Layer (`controller`)**
   - Handles incoming API requests from clients.
   - Example: `POST /employees` will accept employee details and pass them to the service layer.

2. **Service Layer (`service`)**
   - Contains business logic.
   - Example: Save employee details, validate data, call repository methods.

3. **Repository Layer (Spring Data JPA)**
   - Uses JPA to interact with the **H2 in-memory database**.
   - No manual SQL needed — Spring Data generates queries.

4. **Entity (`entity`)**
   - Represents database table structure in Java.
   - Example: `Employee` class has fields like `id`, `name`, `department`, `salary`.

5. **DTO (`dto`)**
   - Data Transfer Object — used to transfer data between layers without exposing entity directly.
   - Example: `EmployeeDTO` matches the API request/response structure.

6. **Mapper (`mapper`)**
   - MapStruct interface to convert between `Employee` (entity) and `EmployeeDTO` (data object).
   - MapStruct generates the mapping code automatically at build time.

7. **Exception Handling (`exception`)**
   - Catches errors like "Employee Not Found" and sends proper JSON error messages to clients.

---

# Spring Boot Advanced Features

This document explains **Actuator**, **Global Exception Handling**, and **Profiling** in Spring Boot with examples.

---

## 📊 1. Spring Boot Actuator

Spring Boot **Actuator** provides production-ready features to monitor and manage your application.

### ✨ Features
- Health check
- Metrics
- Environment info
- Application info
- Loggers management
- Thread dump

### 🛠️ How to Enable
Add dependency in `pom.xml`:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
```
management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always

```

# Spring Boot Profiling

Spring Boot **Profiles** allow you to run the same application in different environments (e.g., `dev`, `test`, `prod`) with different configurations.

---

## 📌 Why Use Profiles?
- Separate database configurations for each environment
- Enable or disable beans for specific environments
- Avoid changing code when deploying to different stages

---

## 🛠 Creating Profiles

### 1️⃣ Create Profile-Specific Config Files
You can create different property files for each environment:

**application-dev.yml**
```yaml
spring:
  profiles:
    active: dev

```
```command
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```
### ** Buid and run

- **mvn clean install,
  
- **mvn spring-boot:run

# Aceess the application
API Base URL: http://localhost:8086 (port as per choice default 8080)

H2 Console: http://localhost:8086/h2-console
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave blank)
