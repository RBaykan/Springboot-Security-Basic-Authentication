


# Springboot Security Basic Authentication

## Overview

A Spring Boot-based project implementing authentication, role-based access control, and basic CRUD functionality for managing accounts.

## Features

1. **Authentication and Authorization**:
    
    - Custom authentication provider (`AccountAuthenticationProvider`).
    - Role-based access control with `ADMIN`, `USER`, and `GUEST` roles.
    - Password encryption using `BCryptPasswordEncoder`.
2. **CRUD Operations**:
    
    - Create, read, update, and delete (CRUD) accounts via `AccountController`.
3. **H2 Database Configuration**:
    
    - In-memory database for development/testing.
    - Configurable via `application.yml`.
4. **Role Management**:
    
    - Roles managed through `Role` enumeration.
    - Integrated with Spring Security.

---

## Project Structure

### 1. **Configuration**

- **`AccountAuthenticationProvider`**: Custom authentication logic.
- **`AccountSecurityConfig`**: Configures security filters and authentication provider.

### 2. **Controller**

- **`AccountController`**:
    - Endpoints for account management:
        - `GET /api/account` - List all accounts.
        - `POST /api/account` - Create a new account.
        - `PUT /api/account/{id}` - Update an account by ID.
        - `DELETE /api/account/{id}` - Delete an account by ID.

### 3. **Entities**

- **`Account`**: Represents account data.
- **`Role`**: Defines account roles (`ADMIN`, `USER`, `GUEST`).

### 4. **DTOs and Mappers**

- **`AccountDTO`**: Data transfer object for `Account`.
- **`AccountMapper`**: Converts between `Account` and `AccountDTO`.

### 5. **Services**

- **`AccountService`**: Interface for account operations.
- **`AccountServiceImpl`**: Implementation of `AccountService`.

### 6. **Repository**

- **`AccountRepository`**: Provides database access for `Account` entities.

---

## Security Configuration

- Restricts `/api/account/**` to `ADMIN` role.
- Basic HTTP authentication enabled.
- API access permissions can be modified in the AccountSecurityConfig class by updating the authorizeHttpRequests() configuration.
	- Example:
		-```java
    		http.authorizeHttpRequests()
    		.requestMatchers("/api/account/**").hasRole("USER") // Change required role here
    		.anyRequest().authenticated();
   		```



---

## Endpoints

|Method|Endpoint|Description|Role Required|
|---|---|---|---|
|GET|`/api/account`|Get all accounts|`ADMIN`|
|POST|`/api/account`|Create a new account|`ADMIN`|
|PUT|`/api/account/{id}`|Update account by ID|`ADMIN`|
|DELETE|`/api/account/{id}`|Delete account by ID|`ADMIN`|

---

## Technologies Used

- **Spring Boot** (Security, JPA)
- **H2 Database**
- **Lombok**
- **Maven**


## How to Run

1. Clone the repository.
2. Configure the application in `application.yml`.
3. Run the application using:

    
    ```bash
    mvn spring-boot:run
    ```
    
4. Access API endpoints via Postman or your preferred client.
## Example Requests

### 1. Create an Account

**Endpoint**: `POST /api/account`  
**Request Body**:
```json
{
  "firstname": "John",
  "lastname": "Doe",
  "username": "johndoe",
  "password": "password123",
  "email": "johndoe@example.com",
  "roles": ["ADMIN", "USER"]
}
```

### 2. Get All Accounts

**Endpoint**: `GET /api/account`  
**Response**:
 ```json
  {
    "id": 1,
    "firstname": "John",
    "lastname": "Doe",
    "username": "johndoe",
    "email": "johndoe@example.com",
    "roles": ["ADMIN", "USER"],
    "createdAccountTime": "2024-12-01T12:00:00"
  }
 ```
### 3. Update an Account

**Endpoint**: `PUT /api/account/{id}`  
**Request Body**:

```json
{
  "firstname": "Jane",
  "lastname": "Doe",
  "username": "janedoe",
  "password": "newpassword",
  "email": "janedoe@example.com",
  "roles": ["USER"]
}
 ```
### 4. Delete an Account

**Endpoint**: `DELETE /api/account/{id}`

---

## Notes

- Passwords are hashed using `BCryptPasswordEncoder`.
- Ensure proper role-based access control by assigning appropriate roles to users.
