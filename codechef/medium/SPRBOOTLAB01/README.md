# SPRBOOTLAB01

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Lab- Configure and Start a Spring Boot Application

A college is creating a small  **Campus Portal**  using Spring Boot. The Maven project and required Spring Boot Web dependency are already configured.

Your task is to complete the Spring Boot application entry point and configure the application using `application.properties`.

You must make changes only in the following files:

 **1. `BootFundamentalsApplication.java`** 

- Make the class the main Spring Boot application.
- Add the appropriate Spring Boot annotation.
- Inside main(), start the application using SpringApplication.run().

 **2. `application.properties`** 

Configure:

- Application name as campus-portal
- Server port as 9090

Do not modify `pom.xml`.

#### Expected Configuration & Behavior

After successfully completing the lab, the application should:

- Be recognized as a valid Spring Boot application context.
- Start successfully via SpringApplication.run().
- Register its application name as campus-portal.
- Bind its embedded Tomcat server to port 9090.
#### Expected Output (Console Logs)

When you run the project, your terminal or console should successfully boot up and display logs similar to the following:

```
 .   ____          _            __ _ _
 / / / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
(()\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \/  ___)| |_)| | | | | || (_| | ))))
  '  |____|.__,|_| |_|_| |_\__, | / / / /
=========|_|==============|_|/=/_/_/

 [INFO] 282 --- [campus-portal] [ main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
 [INFO] 282 --- [campus-portal] [ main] o.a.c.c.StandardEngine                   : Starting Servlet engine: [Apache Tomcat/10.1.31]
 [INFO] 282 --- [campus-portal] [ main] o.a.s.c.c.StandardServletWebServer     : Initializing Spring embedded WebApplicationContext
 [INFO] 282 --- [campus-portal] [ main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 4340 ms
 [INFO] 282 --- [campus-portal] [ main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 9090 (http) with context path '/'
 [INFO] 282 --- [campus-portal] [ main] c.b.BootFundamentalsApplication          : Started BootFundamentalsApplication in 8.098 seconds (process running for 9.823)

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T14:58:38.422Z  

```cpp
# TODO: Configure the application name.

# TODO: Configure the server to run on port 9090.
spring.application.name=campus-portal
server.port=9090
```

---

[View on CodeChef](https://www.codechef.com/problems/SPRBOOTLAB01)