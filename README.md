E-Commerce Wishlist Management Application

Overview

This Spring Boot application provides backend functionality for wishlist management in an e-commerce platform.

Setup Instructions

Step 1: Clone the Repository
bash
git clone https://github.com/your-username/eCommerce.git
cd eCommerce

Step 2: Build the Application
bash
./gradlew build

Step 3: Set Up Database
The application uses an H2 database for simplicity during development. No additional setup is required.

Step 4: Run the Application
bash

./gradlew bootRun
The application will be accessible at http://localhost:8080. You can test the endpoints using tools like Postman.

Running Unit Tests
bash
./gradlew test
This command will execute all the unit tests and provide information about their success or failure.

Additional Considerations for Deployment

Database Configuration: When deploying to production, configure the application to use a production-grade database (e.g., MySQL, PostgreSQL).

Security Considerations: Ensure that appropriate security measures, such as HTTPS, are implemented. Modify security settings based on your production environment.

Logging: Configure and monitor application logs for debugging and tracking purposes.

External Configuration: Use external configuration files for sensitive information such as database credentials. Do not include sensitive information in version control.

Assumptions
The application assumes the availability of a Java 17 runtime environment.

For simplicity, the application uses an H2 in-memory database during development. In production, switch to a more robust database.

License
This project is licensed under the MIT License - see the LICENSE file for details.me/e-commerce.git
cd e-commerce
