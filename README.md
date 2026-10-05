# Spring-Boot-learning

A structured, hands-on repository documenting my daily progress, implementations, and architectural code as I master **Spring Boot** and backend software engineering in Java.

---

## 🎯 Purpose & Goals

- Master core dependency injection, configuration, and the Spring IoC container.
- Build clean, production-ready RESTful APIs adhering to industry standards.
- Deep dive into relational data persistence using Spring Data JPA & Hibernate.
- Learn enterprise patterns: exception handling, DTO mapping, validations, and layered architecture.
- Understand Spring Security, authentication mechanisms, and API performance.

---

## 🗺️ Roadmap & Curriculum

This repository is organized topic-by-topic to reflect a complete backend learning path:

### Phase 1: Core Spring Framework & IoC
- [ ] **Spring Architecture:** The Inversion of Control (IoC) Container & ApplicationContext.
- [ ] **Bean Lifecycle & Scopes:** Singleton, Prototype, Request, and Session scopes.
- [ ] **Dependency Injection (DI):** Constructor injection vs. Field injection (`@Autowired`).
- [ ] **Configuration Annotations:** `@Configuration`, `@Bean`, `@Component`, `@Service`, `@Repository`.
- [ ] **Component Scanning & Filtering:** Managing bean discovery.

### Phase 2: Spring Boot Fundamentals
- [ ] **Spring Boot Architecture:** Starter dependencies, `@SpringBootApplication`, and Auto-Configuration.
- [ ] **Configuration Management:** `application.properties` vs. `application.yml`, profile-specific configs (`@Profile`).
- [ ] **Spring Boot DevTools:** Hot reloading and rapid development workflows.
- [ ] **Logging & Monitoring:** SLF4J, Logback basics, and Spring Boot Actuator health endpoints.

### Phase 3: RESTful Web Services & Layered Architecture
- [ ] **REST Architecture:** Controller-Service-Repository separation of concerns.
- [ ] **HTTP Handling:** `@RestController`, `@GetMapping`, `@PostMapping`, `@PutMapping`, `@PatchMapping`, `@DeleteMapping`.
- [ ] **Request Data Processing:** `@PathVariable`, `@RequestParam`, `@RequestBody`, `@RequestHeader`.
- [ ] **HTTP Response Management:** `ResponseEntity<?>`, HTTP status code best practices.
- [ ] **Data Validation:** Bean Validation API (`@Valid`, `@NotNull`, `@Size`, `@Min`, `@Max`).
- [ ] **Global Exception Handling:** `@ControllerAdvice`, `@ExceptionHandler`, and structured error responses.
- [ ] **DTO Pattern:** Decoupling persistence entities from API contracts using DTOs and Mappers.

### Phase 4: Data Persistence with Spring Data JPA & Hibernate
- [ ] **Database Setup:** Connecting to H2 (in-memory), PostgreSQL, and MySQL.
- [ ] **Entity Modeling:** `@Entity`, `@Id`, `@GeneratedValue`, `@Column`, `@Table`.
- [ ] **JPA Relationships:**
  - One-to-One (`@OneToOne`)
  - One-to-Many & Many-to-One (`@OneToMany`, `@ManyToOne`)
  - Many-to-Many (`@ManyToMany`)
- [ ] **Cascade Types & Fetch Types:** `LAZY` vs. `EAGER` loading and preventing the $N+1$ query problem.
- [ ] **Spring Data Repositories:** `CrudRepository`, `JpaRepository`, custom query methods (`findBy...`).
- [ ] **Advanced Queries:** JPQL, Native SQL queries (`@Query`), and Pagination/Sorting (`Pageable`).
- [ ] **Transaction Management:** ACID principles and `@Transactional` propagation.

### Phase 5: Security & Production Readiness
- [ ] **Spring Security Architecture:** Filter chains, authentication, and authorization.
- [ ] **Authentication Patterns:** In-memory users, database-backed authentication, and JWT tokens.
- [ ] **API Documentation:** Swagger / OpenAPI 3 integration for interactive documentation.
- [ ] **Testing:** Unit testing with JUnit 5 & Mockito, integration testing with `@SpringBootTest` and MockMvc.

---

## 🛠️ Tech Stack & Prerequisites

- **Language:** Java 17+ / Java 21 LTS
- **Framework:** Spring Boot 3.x
- **Build Tool:** Maven / Gradle
- **Database:** PostgreSQL / MySQL
- **Testing:** JUnit 5, Mockito
- **Tools:** IntelliJ IDEA / VS Code, Postman, Docker

---
