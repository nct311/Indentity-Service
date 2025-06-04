# Identity Service

## Purpose and Scope

This document provides a comprehensive overview of the **Identity Service**, a JWT-based authentication and authorization system built with **Spring Boot**. The Identity Service implements a complete user management solution with **role-based access control (RBAC)**, secure token handling, and RESTful API endpoints for authentication operations.

For detailed information about specific system components, see:

- **Authentication system implementation**: `Authentication System`
- **Security configuration and JWT processing**: `Security Configuration`
- **User management operations**: `User Management`
- **REST API endpoints**: `REST API Layer`
- **Database design and RBAC model**: `Data Layer`

---

## System Overview

The Identity Service is a Spring Boot application that provides centralized **authentication and authorization** services through **JWT tokens**. It manages users, roles, and permissions using a hierarchical RBAC model and supports secure token lifecycle management including generation, validation, refresh, and invalidation.

---

## Technology Stack

| Component        | Technology                            | Version   | Purpose                                      |
|------------------|----------------------------------------|-----------|----------------------------------------------|
| Framework        | Spring Boot                            | 3.4.1     | Application framework and dependency injection |
| Security         | Spring Security OAuth2 Resource Server | 3.4.1     | JWT processing and security configuration    |
| Database         | MySQL                                  | 8.x       | Primary data persistence                     |
| ORM              | Spring Data JPA                        | 3.4.1     | Database access and entity management        |
| Validation       | Spring Boot Validation                 | 3.4.1     | Request validation with JSR-303              |
| Mapping          | MapStruct                              | 1.5.5.Final | DTO-Entity mapping                         |
| Password Hashing | Spring Security Crypto                 | 6.x       | Secure password storage                      |
| Build Tool       | Maven                                  | 3.x       | Dependency management and build automation   |
| Java Version     | Java                                   | 23        | Runtime environment                          |

---

## Key Features

### Authentication & Authorization

- **JWT Token Management**: Secure token generation, validation, refresh, and blacklisting
- **Role-Based Access Control**: Hierarchical user-role-permission model
- **Method-Level Security**: `@PreAuthorize`, `@PostAuthorize` for fine-grained access control
- **Token Introspection**: Real-time token validation and status checking

### User Management

- **User CRUD Operations**: Full lifecycle management of user accounts
- **Password Security**: Secure hashing using BCrypt via Spring Security
- **Profile Management**: Self-service profile update APIs
- **Administrative Controls**: Admin capabilities for managing all users

### Security Features

- **Custom JWT Processing**: Integrated with Spring Security filter chain
- **Token Blacklisting**: Secure logout by invalidating JWTs
- **CORS Configuration**: Cross-origin request support
- **Input Validation**: JSR-303 and custom validation support

### Data Management

- **MySQL Integration**: Persistent storage with connection pooling
- **JPA Repository Pattern**: Clean and testable data access layer
- **Entity Mapping**: MapStruct-powered DTO transformation
- **Database Migration**: Auto-update schema with Hibernate DDL

### Error Handling

- **Centralized Exception Management**: Global exception handler with standardized responses
- **Custom Error Codes**: Enumerated codes for clear and consistent API error responses
- **Validation Error Processing**: Detailed constraint violation reporting

---

## Getting Started

To build and run the service:

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
