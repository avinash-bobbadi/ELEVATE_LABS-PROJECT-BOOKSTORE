# 📚 RESTful Bookstore API

## 📌 Project Overview
The **Bookstore API** is a backend application built with **Spring Boot** that manages books and authors.  
It follows **RESTful principles**, supports CRUD operations, filtering, pagination, and sorting, and is documented with **Swagger UI**.  
The project uses an **in-memory H2 Database** for easy testing with **Postman**.

---

## 🎯 Objectives
- Build a **RESTful API** for managing books and authors.
- Implement **CRUD operations**.
- Support **filtering, pagination, and sorting**.
- Document APIs with **Swagger**.
- Provide a **Postman collection** for testing.

---

## 🛠️ Tools & Technologies
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Web & Spring Data JPA**
- **H2 Database**
- **Swagger / Springdoc OpenAPI**
- **Postman**

---

## 📂 Entities

### 👤 Author
- `id` (Long, Primary Key)
- `name` (String)
- `nationality` (String)
- `books` (One-to-Many relationship with Book)

### 📖 Book
- `id` (Long, Primary Key)
- `title` (String)
- `genre` (String)
- `price` (Double)
- `author` (Many-to-One relationship with Author)

---

## 🔗 API Endpoints

### 📍 Author APIs
| Method | Endpoint            | Description       |
|--------|--------------------|-------------------|
| GET    | `/api/authors`     | Get all authors   |
| GET    | `/api/authors/{id}`| Get author by ID  |
| POST   | `/api/authors`     | Create author     |
| PUT    | `/api/authors/{id}`| Update author     |
| DELETE | `/api/authors/{id}`| Delete author     |

### 📍 Book APIs
| Method | Endpoint          | Description       |
|--------|------------------|-------------------|
| GET    | `/api/books`     | Get all books     |
| GET    | `/api/books/{id}`| Get book by ID    |
| POST   | `/api/books`     | Create book       |
| PUT    | `/api/books/{id}`| Update book       |
| DELETE | `/api/books/{id}`| Delete book       |

✅ Supports **pagination & sorting**:  
