# 🛒 Product Management WebApp

A simple Java Web Application for managing products using JSP, Servlets, and JDBC. Users can add, update, delete, and view products with prices and quantities. The interface is RTL (Arabic) with Bootstrap 5 for styling.

---

## 📝 Features

- ✅ **Add Products**: Add new products with name, price, and quantity
- 🔄 **Update Products**: Edit existing product information
- 🗑️ **Delete Products**: Remove products with confirmation dialog
- 👀 **View Products**: Display products in a responsive table with total count
- ✔️ **Input Validation**: Ensure price > 0 and quantity ≥ 0
- 🌐 **RTL Interface**: Arabic-friendly interface using Bootstrap 5
- 💬 **User Feedback**: Error and success messages using Bootstrap alerts

---

## 🏗️ Project Structure

```text
ProductManagementWebApp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/
│   │   │   │   └── ItemController.java
│   │   │   ├── model/
│   │   │   │   └── Item.java
│   │   │   └── service/
│   │   │       ├── ItemService.java
│   │   │       └── impl/
│   │   │           └── ItemServiceImpl.java
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       ├── css/
│   │       │   └── style.css
│   │       ├── js/
│   │       │   └── validation.js
│   │       ├── addItem.jsp
│   │       ├── editItem.jsp
│   │       └── items.jsp
└── README.md
```

---

## ⚙️ Technologies Used

| Technology | Purpose |
|------------|---------|
| **Java EE / Jakarta EE** | Backend framework |
| **JSP & Servlets** | Web layer |
| **JDBC** | Database connectivity |
| **Bootstrap 5** | Responsive UI design |
| **HTML5, CSS3, JavaScript** | Frontend technologies |

---

## 💾 Database Setup

### 1. Create Database
```sql
CREATE DATABASE product_db;
```

### 2. Create Items Table
```sql
CREATE TABLE items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL
);
```

### 3. Configure Connection
Configure JDBC connection in your project (`ItemServiceImpl` or `DBUtil`).

---

## 🚀 How to Run

### Prerequisites
- Java 8+ installed
- Apache Tomcat 9+ server
- MySQL/MariaDB database
- IDE (Eclipse/IntelliJ IDEA)

### Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/ProductManagementWebApp.git
   ```

2. **Import Project:**
   - Import into Eclipse/IntelliJ IDEA as a Dynamic Web Project

3. **Database Setup:**
   - Create database and table as shown above
   - Update database connection settings

4. **Deploy to Server:**
   - Deploy to Tomcat 9+ server

5. **Access Application:**
   ```
   http://localhost:8080/ProductManagementWebApp/items
   ```

---

## 📱 Screenshots

> Add screenshots of your application here to showcase the interface

---

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Your Name**
- GitHub: Mohamed Sayed
- Email: ms4002@fayoum.edu.eg

---

## 🙏 Acknowledgments

- Bootstrap team for the amazing UI framework
- Apache Tomcat for the servlet container
- MySQL for the database system

---

