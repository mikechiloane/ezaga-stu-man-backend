# Ezaga Student Management Service
## Description

This Spring Boot application provides a backend service for a front-end project, managing student login, signup, password reset, and profile updates. It uses MySQL as the database and implements JWT authentication.

## Features

* User management:
    * Login
    * Signup
    * Reset password (temporary OTP-based using the code "1234" for now)
    * Profile updating
* JWT authentication for secure access

## Technologies

* Java 17
* Spring Boot
* MySQL (database)
* JWT (authentication)

## Requirements

* Java 17 JDK (https://www.oracle.com/java/technologies/javase-downloads.html)
* Maven (https://maven.apache.org/)
* MySQL database server ([invalid URL removed])

## Setup

1. Clone this project or download the ZIP file.
2. Install the required dependencies using Maven:

   ```bash
   mvn clean install

3. Configure the database connection by setting the following environment variables:

  MYSQL_URL: Your MySQL database connection URL (e.g., jdbc:mysql://localhost:3306/your_database_name)
  MYSQL_USER: Your MySQL database username
  MYSQL_PASSWORD: Your MySQL database password
    Option 1: Environment variables

  Set these environment variables in your operating system or container environment.
    Option 2: application.properties

  Uncomment the relevant lines in application.properties and replace them with your values:

## JWT Authentication
The service uses JWT for authentication. Include the generated JWT token in the headers of your requests for secure access to protected endpoints.

## Contributing
Feel free to contribute to the project by opening issues or submitting pull requests
