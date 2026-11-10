# 🛒 Order Management System

A **Spring Boot REST API application** for managing items, inventory, and customer orders. It supports item management, searching and filtering items, placing orders, checking product availability, and cancelling orders.

## ✨ Features

### 📦 Item Management
- ➕ Add new items.
- 🔍 Retrieve items by ID or view all items.
- ✏️ Update item details.
- 🗑️ Delete items.
- 🔎 Search items by name prefix or containing text.
- ⭐ Filter items by rating.
- 💰 Find items within a price range.
- 🔄 Update item ratings.

### 🧾 Order Management
- 🛍️ Place orders containing multiple items.
- 🔍 Retrieve orders by ID.
- 📋 Retrieve all orders.
- ❌ Cancel orders.
- 💵 Calculate the total order price.
- 📦 Check item availability before placing orders.
- 🔄 Automatically update inventory quantities when an order is placed.

### ⚙️ Additional Features
- 🏗️ Layered architecture.
- 📄 DTO-based request and response handling.
- 🧰 Builder pattern.
- ⚠️ Custom exception handling.
- 🗄️ Spring Data JPA and MySQL integration.
- 🌐 RESTful API endpoints.
- 📚 Swagger / OpenAPI documentation (after configuring the required dependency).

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| ☕ Java 21 | Programming language |
| 🍃 Spring Boot 4.1.2 | Application framework |
| 🌐 Spring WebMVC | REST API development |
| 🗄️ Spring Data JPA | Database operations |
| 🔗 Hibernate | ORM framework |
| 🐬 MySQL | Relational database |
| 📦 Maven | Dependency management |
| 🧩 Lombok | Boilerplate code reduction |
| 📚 Swagger / OpenAPI | API documentation |

## 📁 Project Structure

```text
OrderManagement
│
├── src/main/java
│   └── com/ordermanagement
│       │
│       ├── builder
│       │   ├── OrderBuilder.java
│       │   └── OrderItemBuilder.java
│       │
│       ├── controller
│       │   ├── ItemController.java
│       │   └── OrderController.java
│       │
│       ├── dao
│       │   ├── ItemRepository.java
│       │   ├── OrderItemRepository.java
│       │   └── OrderRepository.java
│       │
│       ├── dto
│       │   ├── AddItemDTO.java
│       │   ├── UpdateItemDTO.java
│       │   ├── NewOrderRequestDTO.java
│       │   ├── NewOrderItemRequestDTO.java
│       │   ├── ItemResponseDTO.java
│       │   ├── OrderResponseDTO.java
│       │   ├── OrderItemResponseDTO.java
│       │   └── OrderStatus.java
│       │
│       ├── exception
│       │   ├── GlobalExceptionHandler.java
│       │   ├── ItemNotFoundException.java
│       │   ├── OrderNotFoundException.java
│       │   ├── InsufficientQuantityException.java
│       │   └── InvalidRatingException.java
│       │
│       ├── model
│       │   ├── Item.java
│       │   ├── Order.java
│       │   └── OrderItem.java
│       │
│       └── service
│           ├── ItemService.java
│           ├── OrderService.java
│           ├── OrderItemService.java
│           │
│           └── impl
│               ├── ItemServiceImpl.java
│               └── OrderServiceImpl.java
│
├── src/main/resources
│   └── application.properties
│
├── src/test
├── pom.xml
└── README.md
```

## 📋 Prerequisites

Make sure you have installed:

- ☕ Java JDK 21
- 📦 Maven
- 🐬 MySQL Server
- 💻 Eclipse / IntelliJ IDEA / VS Code
- 🔍 Postman (for API testing)

## 🗄️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE ordermanagement;
```

Configure your database connection in `src/main/resources/application.properties`:

```properties
spring.application.name=OrderManagement

spring.datasource.url=jdbc:mysql://localhost:3306/ordermanagement
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8081
```

Set the `DB_USERNAME` and `DB_PASSWORD` environment variables with your MySQL credentials before starting the application.

## 🚀 How to Run the Application

**1️⃣ Clone the repository**

```bash
git clone https://github.com/karivetisandeepvarma/OrderManagement.git
```

**2️⃣ Navigate to the project directory**

```bash
cd OrderManagement
```

**3️⃣ Build the application**

```bash
mvn clean install
```

**4️⃣ Run the application**

```bash
mvn spring-boot:run
```

The application will run at:

🌐 `http://localhost:8081`

## 🌐 REST API Endpoints

### 📦 Item APIs

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/items/add` | ➕ Add a new item |
| GET | `/items/id/{itemId}` | 🔍 Get item by ID |
| GET | `/items` | 📋 Get all items |
| PUT | `/items/update` | ✏️ Update item details |
| DELETE | `/items/delete/{id}` | 🗑️ Delete an item |
| GET | `/items/findbynamestartswith/{name}` | 🔎 Search items by name prefix |
| GET | `/items/findbynamecontaining/{name}` | 🔎 Search items containing a name |
| GET | `/items/findbyratinggreaterthan/{rating}` | ⭐ Find items above a rating |
| GET | `/items/findbypricebetween/{price1}/{price2}` | 💰 Find items within a price range |
| PUT | `/items/updaterating?itemId={itemId}&rating={rating}` | 🔄 Update item rating |

### 🧾 Order APIs

| HTTP Method | Endpoint | Description |
|---|---|---|
| POST | `/orders/new` | 🛍️ Place a new order |
| GET | `/orders/findorderbyid/{orderId}` | 🔍 Get order by ID |
| GET | `/orders/allorders` | 📋 Get all orders |
| DELETE | `/orders/cancelorder/{orderId}` | ❌ Cancel an order |

## 📚 Swagger UI – API Documentation

After adding the Springdoc OpenAPI dependency and starting the application, access the interactive API documentation here:

🔗 **[Open Swagger UI](http://localhost:8081/swagger-ui/index.html)**

With Swagger UI, you can:

- 📖 View available REST API endpoints.
- 🔍 Inspect request parameters and response formats.
- 🧪 Execute API requests directly from the browser.
- 📋 Explore API operations and documentation.

## 🗃️ Database Entities

The application contains three main entities:

- **Item:** Stores item details such as name, category, price, quantity, discount, rating, and brand.
- **Order:** Stores order information such as order date, total price, number of items, and order status.
- **OrderItem:** Connects items with orders and stores order-specific quantity, price, and discount details.

### 🔗 Entity Relationships

- One `Order` can contain multiple `OrderItem` records.
- Each `OrderItem` is associated with one `Item`.
- Each `OrderItem` is associated with one `Order`.

## 🧪 API Testing

You can test the REST APIs using:

- Postman
- Swagger UI (after configuring the required dependency)

## 👨‍💻 Author

**Sandeep Varma Kariveti**

- 🐙 GitHub: https://github.com/karivetisandeepvarma
- 💼 LinkedIn: https://www.linkedin.com/in/sandeep-varma-kariveti-09a841350

---

⭐ If you find this project useful, feel free to explore the repository!
