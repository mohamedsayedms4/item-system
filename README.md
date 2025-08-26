# 🛒 Product Management WebApp

A simple Java Web Application for managing products using JSP, Servlets, and JDBC. Users can add, update, delete, and view products with prices and quantities. The interface is RTL (Arabic) with Bootstrap 5 for styling.

---

## 📝 Features

- Add new products with name, price, and quantity.
- Update existing products.
- Delete products with confirmation.
- View products in a responsive table with total count.
- Input validation for price > 0 and quantity ≥ 0.
- RTL (Arabic) interface using Bootstrap 5.
- Error and success messages using Bootstrap alerts.

---

## 🏗️ Project Structure

```text
ProductManagementWebApp/
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  ├─ controller/
│  │  │  │  └─ ItemController.java
│  │  │  ├─ model/
│  │  │  │  └─ Item.java
│  │  │  └─ service/
│  │  │     ├─ ItemService.java
│  │  │     └─ impl/
│  │  │        └─ ItemServiceImpl.java
│  │  └─ webapp/
│  │     ├─ WEB-INF/
│  │     │  └─ web.xml
│  │     ├─ css/
│  │     │  └─ style.css
│  │     ├─ js/  (optional)
│  │     │  └─ validation.js
│  │     ├─ addItem.jsp
│  │     ├─ editItem.jsp
│  │     └─ items.jsp
└─ README.md
