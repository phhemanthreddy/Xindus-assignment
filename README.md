# E-Commerce Wishlist Management Application

## Overview

This application provides backend functionality for managing wishlists in an e-commerce platform. It includes features such as user authentication, wishlist creation, and item management.

## Getting Started

Follow the steps below to set up and run the application locally.

### Prerequisites

- Java 17
- Gradle (for building and running the application)
- Git (for version control)

### Installation

1. Clone the repository to your local machine.

    ```bash
    git clone https://github.com/your-username/e-commerce-wishlist.git
    ```

2. Navigate to the project directory.

    ```bash
    cd e-commerce-wishlist
    ```

3. Build the application using Gradle.

    ```bash
    ./gradlew build
    ```

### Running the Application

1. Run the application.

    ```bash
    ./gradlew bootRun
    ```

2. The application will be accessible at `http://localhost:8080`.

### User Authentication

- To register a new user, make a POST request to `http://localhost:8080/api/wishlists/register` with the user details in the request body.

- To log in, make a POST request to `http://localhost:8080/authenticate` with the user credentials.

### Wishlist Management

- Use the following endpoints for wishlist management:

    - `GET /api/wishlists`: Retrieve a user's wishlist.
    - `POST /api/wishlists`: Create a new wishlist item.
    - `DELETE /api/wishlists/{id}`: Remove a wishlist item by ID.

### Running Unit Tests

1. Execute the unit tests.

    ```bash
    ./gradlew test
    ```

### Additional Considerations for Deployment

- Ensure that the application is configured with the appropriate database settings for your deployment environment.

- Update the `application.properties` file with the necessary configurations.

- Deploy the application to your chosen server or cloud platform.

## Author

Your Name

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
