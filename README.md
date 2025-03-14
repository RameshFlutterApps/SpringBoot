# Spring-Boot
A Spring Boot CRUD (Create, Read, Update, Delete) operation sample demonstrating RESTful APIs with this project provides a simple implementation of CRUD operations for managing entities with minimal configuration. Ideal for beginners looking to learn Spring Boot fundamentals.

## Step 1: Set Up the Spring Boot Project
- Go to Spring Initializr: https://start.spring.io/
- Select the configurations:
- Project: Maven
- Language: Java
- Spring Boot Version: Latest stable version
- Dependencies: Spring Web, Spring Boot DevTools, Lombok, Spring Data JPA, H2 Database (or MySQL if using MySQL)
- Click "Generate" to download the project.
- Extract the ZIP and open it in your preferred IDE (Eclipse, IntelliJ, VS Code).

## Step 2: Configure application.properties
- Edit src/main/resources/application.properties to configure the database with MYSQL.
  
- spring.datasource.url=jdbc:mysql://localhost:3306/mydb
- spring.datasource.username=root
- spring.datasource.password=root
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
