<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Item" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html dir="rtl" lang="ar">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>قائمة المنتجات</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>📦 إدارة المنتجات</h1>

    <!-- Messages -->
    <c:if test="${not empty sessionScope.successMessage}">
        <div class="message success">${sessionScope.successMessage}</div>
        <c:remove var="successMessage" scope="session"/>
    </c:if>

    <c:if test="${not empty sessionScope.errorMessage}">
        <div class="message error">${sessionScope.errorMessage}</div>
        <c:remove var="errorMessage" scope="session"/>
    </c:if>

    <!-- Add Item Form -->
    <div class="add-form">
        <h2>➕ إضافة منتج جديد</h2>
        <form method="post" action="items">
            <input type="hidden" name="action" value="add">
            <label>الاسم:</label>
            <input type="text" name="name" required>
            <label>السعر:</label>
            <input type="number" name="price" step="0.01" required>
            <label>الكمية:</label>
            <input type="number" name="quantity" required>
            <button type="submit">إضافة المنتج</button>
        </form>
    </div>

    <!-- Items Table -->
    <%
        List<Item> items = (List<Item>) request.getAttribute("items");
        if (items != null && !items.isEmpty()) {
    %>
        <table>
            <thead>
            <tr>
                <th>رقم المنتج</th>
                <th>اسم المنتج</th>
                <th>السعر (جنيه)</th>
                <th>الكمية</th>
                <th>الإجراءات</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Item item : items) {
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getName() %></td>
                <td><%= String.format("%.2f", item.getPrice()) %></td>
                <td><%= item.getQuantity() %></td>
                <td>
                    <form method="post" action="items" style="display:inline;">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="id" value="<%= item.getId() %>">
                        <input type="text" name="name" value="<%= item.getName() %>" style="width:100px;" required>
                        <input type="number" name="price" value="<%= item.getPrice() %>" step="0.01" style="width:80px;" required>
                        <input type="number" name="quantity" value="<%= item.getQuantity() %>" style="width:60px;" required>
                        <button type="submit" class="update-btn">تحديث</button>
                    </form>
                    <form method="post" action="items" style="display:inline;" onsubmit="return confirm('هل أنت متأكد من حذف هذا المنتج؟')">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="<%= item.getId() %>">
                        <button type="submit" class="delete-btn">حذف</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>

        <div class="message success">
            📊 إجمالي المنتجات: <%= items.size() %> منتج
        </div>
    <%
        } else {
    %>
        <div class="message error">
            ❌ لا توجد منتجات حالياً!
        </div>
    <%
        }
    %>

</div>
</body>
</html>
