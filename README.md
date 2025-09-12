# Qualco Case Study Project

This project is an Angular + Spring Boot application that displays country data, statistics, and allows filtering and pagination.  

---

## Prerequisites

Make sure you have the following installed:

- **Java JDK 17 +  node.js**  
  Check version with:
  
  java -version

I used:
node -v   # v22.19.0
npm -v    # 11.6.0

Backend Setup (Spring Boot)

Navigate to the backend folder (if separate) or project root:

cd backend

Build and run the Spring Boot application:
a) build with :
mvn clean install -DskipTests
b) mvn spring-boot:run -DskipTests

or you can use package.json script like :
npm run build
or 
npm run start

The backend will run by default on http://localhost:8082 if you copy the following .yml

Ensure your database is running and accessible as configured in application.properties or application.yml .
You should create the .yml/.properties file here: server\src\main\resources\application.yml

Must look like :
spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/nation
    username: {username-and-remove-brackets}  
    password: {password-and-remove-brackets}  
    driver-class-name: org.mariadb.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update      # options: validate | update | create | create-drop
    show-sql: true           # shows SQL in console
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MariaDBDialect
  profiles:
    active: dev              # can be 'dev', 'test', 'prod'
server:
  port: 8082
  servlet:
    context-path: /api
logging:
  level:
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE

Frontend Setup (Angular)

Navigate to the Angular frontend folder (or project root if combined):

cd ui


Install dependencies:

npm install


Run the Angular development server:

ng serve


Access the frontend at http://localhost:4200

Usage

The home page shows navigation links to different tasks (countries, stats, etc.)

Use the filters and pagination controls in the /country-data page to query data dynamically.

The menu and pages are implemented in Angular with a Spring Boot REST backend.

Notes

Angular CLI is required for running the frontend:

npm install -g @angular/cli


Database schema is expected to be pre-populated as per the SQL provided in the project.

License

This project is for demonstration purposes and does not include a specific license.