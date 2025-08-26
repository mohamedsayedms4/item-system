🛒 Product Management WebApp

A simple Java Web Application for managing products using JSP, Servlets, and JDBC. Users can add, update, delete, and view products with prices and quantities. The interface is RTL (Arabic) with Bootstrap 5 for styling.

📝 Features

Add new products with name, price, and quantity.

Update existing products.

Delete products with confirmation.

View products in a responsive table with total count.

Input validation for price > 0 and quantity ≥ 0.

RTL (Arabic) interface using Bootstrap 5.

Error and success messages using Bootstrap alerts.

🏗️ Project Structure
ProductManagementWebApp/
│
├─ src/main/java/
│   └─ controller/
│       └─ ItemController.java
│   └─ model/
│       └─ Item.java
│   └─ service/
│       └─ ItemService.java
│       └─ impl/ItemServiceImpl.java
│
├─ src/main/webapp/
│   ├─ WEB-INF/
│   │   └─ web.xml
│   ├─ css/
│   │   └─ style.css
<<<<<<< HEAD
=======
│   ├─ js/
│   │   └─ validation.js (optional)
>>>>>>> 6494704 (update readMe)
│   ├─ addItem.jsp
│   ├─ editItem.jsp
│   └─ items.jsp
│
└─ README.md

⚙️ Technologies Used

Java EE / Jakarta EE

JSP & Servlets

JDBC for database connection

Bootstrap 5 for responsive design

HTML5, CSS3, JS

💾 Database Setup

Create a database product_db.

Create a table items:

CREATE TABLE items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL
);


Configure JDBC connection in your project (ItemServiceImpl or DBUtil).

🚀 How to Run

Clone the repository:

git clone https://github.com/your-username/ProductManagementWebApp.git


Import the project into Eclipse/IntelliJ IDEA as a Dynamic Web Project.

Deploy to Tomcat 9+ server.

Access the application at:

http://localhost:8080/ProductManagementWebApp/items
<<<<<<< HEAD
=======

📄 License

This project is MIT Licensed.
>>>>>>> 6494704 (update readMe)
