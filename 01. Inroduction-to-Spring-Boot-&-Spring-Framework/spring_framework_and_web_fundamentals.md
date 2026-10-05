# Backend Architecture & Spring Framework Notes

---

## 1. Client-Server Architecture & HTTP Fundamentals

### 1.1 High-Level Overview
In a typical web architecture, a **Client** requests a resource, and a **Server** processes the request and returns a response.

```
+-------------------------------------------------------+
|                       CLIENT                          |
|  - Browser (e.g., Chrome, Edge)                       |
|  - Mobile App (Android / iOS)                         |
|  - Frontend Frameworks (React FE, Angular, Vue)       |
|  - API Testing Tools (Postman, cURL)                  |
+-------------------------------------------------------+
                           |
                           | HTTP / HTTPS Requests
                           v
+-------------------------------------------------------+
|                       SERVER                          |
|  - Listens for incoming connections                   |
|  - Processes business logic                           |
|  - Returns HTTP Response                              |
+-------------------------------------------------------+
```

* **Core Exchange:** 
  * **Client Ask:** Sends an HTTP/HTTPS Request.
  * **Server Respond:** Processes the entity/resource and sends back an HTTP Response.
* **HTTP:** HyperText Transfer Protocol.
* **HTTPS:** HyperText Transfer Protocol Secure (encrypted via TLS/SSL).

---

### 1.2 Structure of an HTTP Request and Response

#### A. HTTP Request Structure
An HTTP request consists of a **Method**, a **Path/URL**, **Headers**, and an optional **Body**:

```http
POST /login HTTP/1.1
Host: www.coderarmy.in
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "secretpassword"
}
```

* **HTTP Methods:**
  * `GET`: Retrieve data (e.g., `GET /courses`).
  * `POST`: Submit/create new data (e.g., `POST /login`).
  * `PUT`: Update/replace existing resource entirely.
  * `PATCH`: Partially modify an existing resource.
  * `DELETE`: Remove a resource.

#### B. HTTP Response Structure
An HTTP response consists of a **Status Code**, **Headers**, and a **Response Body**:

```http
HTTP/1.1 200 OK
Content-Type: application/json

{
  "message": "login successful"
}
```

* **Common Status Codes:**
  * `200 OK`: Request succeeded.
  * `201 Created`: Resource successfully created.
  * `400 Bad Request`: Client error in request format.
  * `401 Unauthorized` / `403 Forbidden`: Authentication & authorization errors.
  * `404 Not Found`: Resource does not exist.
  * `500 Internal Server Error`: Server failure.

---

## 2. Java Execution Lifecycle vs. Web Server Needs

### 2.1 Standard Core Java Program Flow
A standard standalone Java program compiles source code into bytecode and runs once from top to bottom through the `main` method before terminating.

```
   [Main.java] 
       |
       |  javac (Java Compiler)
       v
  [Main.class] (Bytecode)
       |
       |  JVM Execution
       v
     [JVM]
       |
  +----+----+
  |  START  |
  |   RUN   |  ---> Executes main(String[] args) ---> Terminates
  |  STOP   |
  |  EXIT   |
  +---------+
```

```java
public class Main {
    public static void main(String[] args) {
        // Runs sequentially and exits
        courses();
    }

    public static void courses() {
        // Fetch or print courses
    }
}
```

---

### 2.2 Why a Web Server Is Different
A web server cannot simply run and exit. It must continuously listen for incoming network traffic.

```
       START
         |
         v
       [RUN]
         |
  +----->|
  |      v
  |  [Wait for Request] <----------- (Client connects)
  |      |
  |      v
  |  [Process Request & Code Flow]
  |      |
  |      v
  |  [Give HTTP Response]
  |      |
  +------+ (Keep Running: while(true))
```

* A server keeps running indefinitely using an event/listening loop:
  ```java
  while (true) {
      // Wait for incoming socket connections
  }
  ```

---

## 3. Low-Level Networking: `java.net.ServerSocket`

Before modern frameworks, low-level Java networking handled HTTP traffic manually using sockets.

```java
import java.io.*;
import java.net.*;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        // Bind server to port 8080 on localhost (127.0.0.1)
        ServerSocket server = new ServerSocket(8080);
        
        while (true) {
            Socket socket = server.accept(); // Blocks until a client connects
            
            // 1. Read input byte stream
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // 2. Manually parse the HTTP Request lines (Headers, Path, Body)
            // 3. Map method/URL to an endpoint:
            //    if (endpoint.equals("/courses")) { ... }
            
            // 4. Manually construct raw HTTP Response string
            // 5. Handle multi-threading manually per connection
        }
    }
}
```

### Problems with raw `ServerSocket`:
* Manual byte-stream parsing.
* Manually implementing HTTP protocol compliance.
* Handling concurrency/multi-threading manually for each request.
* No standard request/response abstractions.

---

## 4. Evolution to Servlets and Servlet Containers (1997+)

To solve socket management issues, **Java EE** introduced the **Servlet API** and **Servlet Containers** (e.g., Apache Tomcat, Jetty, Undertow).

```
+-------------------------------------------------------------------+
|                     SERVLET CONTAINER (TOMCAT)                    |
|                                                                   |
|   1. Opens & binds port (e.g., 8080)                              |
|   2. Reads incoming raw bytes                                     |
|   3. Parses HTTP Request into `HttpServletRequest`                |
|   4. Manages Thread Pools                                         |
|                                                                   |
|             |                                        ^            |
|             | HttpServletRequest                     |            |
|             v                                        |            |
|       +-----------+                                  |            |
|       |  Servlet  |  -----> processes business logic |            |
|       +-----------+                                  |            |
|             |                                        |            |
|             +---------> HttpServletResponse ---------+            |
|                                                                   |
|   5. Serializes `HttpServletResponse` into raw HTTP bytes         |
+-------------------------------------------------------------------+
       ^                                              |
       |  GET /courses                                |  HTTP 200 OK
       |                                              v
+-------------------------------------------------------------------+
|                              CLIENT                               |
+-------------------------------------------------------------------+
```

---

## 5. The Spring Framework Ecosystem

The **Spring Framework** builds on top of servlets and eliminates boilerplate, providing enterprise-grade modules for application development.

```
+-------------------------------------------------------------------------+
|                              SPRING BOOT                                |
|           (Auto-configuration, Embedded Tomcat, Production Ready)       |
+-------------------------------------------------------------------------+
|  Spring MVC   | Spring Security |   Spring AOP    |  Spring Data / AI   |
+---------------+-----------------+-----------------+---------------------+
|                              SPRING CORE                                |
|        (Inversion of Control [IoC], Dependency Injection [DI], Beans)   |
+-------------------------------------------------------------------------+
```

### Key Modules:
* **Spring Core:** Foundational container for Dependency Injection (DI) and Inversion of Control (IoC).
* **Spring MVC:** Model-View-Controller framework for building REST APIs and web applications.
* **Spring Security:** Authentication, authorization, and protection against common exploits.
* **Spring AOP:** Aspect-Oriented Programming for cross-cutting concerns (logging, transactions).
* **Spring Data:** Consistent abstraction over relational and non-relational data persistence.

---

## 6. Persistence Layer Architecture: Spring Data JPA to Database

Modern Spring applications decouple business logic from raw SQL operations using layered persistence abstractions:

```
[ Spring Data JPA ]
        |
        v  (Specifies abstractions, interfaces, and repositories)
   [ Hibernate ]
        |
        v  (ORM Implementation: maps Java objects to SQL tables)
     [ JDBC ]
        |
        v  (Java Database Connectivity: handles drivers and connections)
  [( Database )]
```

### Full-Stack Microservices Architecture Context:
In modern enterprise applications, decoupled microservices interact over HTTP or message queues:

```
+----------+      HTTP / REST      +-------------+
|  Order   | --------------------> |   Payment   |
| Service  |                       |   Service   |
+----------+                       +-------------+
                                          |
                                          |
                                          v
                                   +-------------+
                                   |    User     |
                                   |   Service   |
                                   +-------------+
```