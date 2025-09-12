# Qualco Case Study Project

An Angular + Spring Boot application that displays country data and statistics, with filtering and pagination functionality.
---
## Prerequisites

Make sure the following are installed:

- **Java JDK 17 **  

java -version


- **Node.js & npm **  

node -v   # v22.19.0
npm -v    # 11.6.0


- **Angular CLI (for running the frontend)**  

npm install -g @angular/cli


- **Database (MariaDB, as configured in application.yml) **  

## Backend Setup (Spring Boot)

1. Navigate to the backend folder (or project root):

cd backend


2. Build the project:

mvn clean install -DskipTests


3. Run the Spring Boot application:

mvn spring-boot:run -DskipTests


The backend runs by default at: http://localhost:8082/api

## Database Configuration

Create an application.yml file in server/src/main/resources/ with the following template:

spring:
  datasource:
    url: jdbc:mariadb://localhost:3306/nation
    username: YOUR_DB_USERNAME
    password: YOUR_DB_PASSWORD
    driver-class-name: org.mariadb.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update   # options: validate | update | create | create-drop
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MariaDBDialect
  profiles:
    active: dev

server:
  port: 8082
  servlet:
    context-path: /api

logging:
  level:
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE


Note: Replace YOUR_DB_USERNAME and YOUR_DB_PASSWORD with your actual credentials. Do not commit this file to GitHub.

## Frontend Setup (Angular)

1. Navigate to the frontend folder (or project root if combined):

cd ui


2. Install dependencies:

npm install


3. Start the Angular development server:

ng serve


Access the frontend at: http://localhost:4200

## Usage

The home page provides navigation links to different tasks (e.g., countries, statistics).

The /country-data page supports filtering by region and year range, along with pagination controls.

Data is fetched dynamically from the Spring Boot REST backend.

## Notes

Ensure your database is populated according to the SQL scripts included in the project.

The project uses plain HTML + CSS for the UI without Angular Material.

## License

This project is for demonstration purposes only. No license is included.
