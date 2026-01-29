# Secure API Starter (Spring Boot + JWT)

Secure API Starter is a Spring Boot 3 project that provides a production-ready JWT authentication foundation using Spring Security, PostgreSQL, and clean layered architecture.

This project is designed as a starter template for building secure REST APIs.


---

## ✨ Features

- 🔐 JWT-based authentication
- 🛡️ Custom JWT authentication filter
- 👤 Secure user registration & login
- 📦 Clean layered architecture
- 🧾 Standardized API responses
- ✅ Request validation
- 🧪 Security test support

---

## 🛠️ Tech Stack


- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Security**
- **JWT (JJWT 0.11.x)**
- **Spring Data JPA**
- **PostgreSQL**
- **Jakarta Validation**
- **Lombok**
- **Maven**

---

## Package


- config
Contains Spring Security configuration, JWT filters, password encoder, and other app-level configs.

- controller
Handles incoming HTTP requests and returns responses.
Keeps controllers thin by delegating logic to services.

- dto
Data Transfer Objects used for:
	1. API requests
	2. API responses
Prevents exposing internal entities directly.

- entity
JPA entities representing database tables.

- exception
Centralized exception handling (e.g. @ControllerAdvice) and custom exceptions for clean error responses.

- mapper
Handles transformation between Entity ↔ DTO, keeping controllers and services clean.

- repository
Spring Data JPA interfaces for database access.

- service
Core business logic layer.
Coordinates repositories, validation, and security rules.

## endpoint url

- 🔐 Authentication API base Path /api/auth
- 🧾 Register User = POST /api/auth/register
- 🔑 Login User = POST /api/auth/login
- 👤 Get current user = GET /api/user/me (JWT required)

## Notes

This README was prepared with the help of AI tools (ChatGPT), including icon usage.
The project itself is fully implemented and structured by me as part of my journey
to becoming a better backend engineer with strong design and security fundamentals.
