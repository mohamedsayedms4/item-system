<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ar">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>تعديل المنتج</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <div class="form-container p-4">
                    <div class="text-center mb-4">
                        <h2><i class="fas fa-edit text-warning"></i> تعديل المنتج</h2>
                        <c:if test="${not empty item}">
                            <span class="badge item-id-badge fs-6 px-3 py-2">ID: ${item.id}</span>
                        </c:if>
                    </div>
                    
                    <c:if test="${not empty sessionScope.errorMessage}">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            <i class="fas fa-exclamation-circle"></i> ${sessionScope.errorMessage}
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                        </div>
                        <c:remove var="errorMessage" scope="session"/>
                    </c:if>
                    
                    <c:choose>
                        <c:when test="${not empty item}">
                            <form method="post" action="items" id="editItemForm" novalidate>
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="id" value="${item.id}">
                                
                                <div class="mb-3">
                                    <label for="name" class="form-label"><i class="fas fa-tag"></i> اسم المنتج <span class="required">*</span></label>
                                    <input type="text" class="form-control" id="name" name="name" value="${item.name}" placeholder="أدخل اسم المنتج" required maxlength="100">
                                    <div class="invalid-feedback">يرجى إدخال اسم المنتج</div>
                                </div>
                                
                                <div class="mb-3">
                                    <label for="price" class="form-label"><i class="fas fa-money-bill"></i> السعر (جنيه) <span class="required">*</span></label>
                                    <input type="number" class="form-control" id="price" name="price" value="${item.price}" placeholder="0.00" min="0" step="0.01" required>
                                    <div class="invalid-feedback">يرجى إدخال سعر صحيح (أكبر من صفر)</div>
                                </div>
                                
                                <div class="mb-3">
                                    <label for="quantity" class="form-label"><i class="fas fa-cubes"></i> الكمية <span class="required">*</span></label>
                                    <input type="number" class="form-control" id="quantity" name="quantity" value="${item.quantity}" placeholder="0" min="0" required>
                                    <div class="invalid-feedback">يرجى إدخال كمية صحيحة (أكبر من أو يساوي صفر)</div>
                                </div>
                                
                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                    <a href="items" class="btn btn-secondary me-md-2"><i class="fas fa-arrow-left"></i> العودة للقائمة</a>
                                    <button type="reset" class="btn btn-outline-warning me-md-2">إلغاء التغييرات</button>
                                    <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> حفظ التعديلات</button>
                                </div>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-warning text-center" role="alert">
                                <i class="fas fa-exclamation-triangle fa-2x mb-3"></i>
                                <h4>المنتج غير موجود</h4>
                                <p>لم يتم العثور على المنتج المطلوب تعديله.</p>
                                <a href="items" class="btn btn-primary"><i class="fas fa-arrow-left"></i> العودة للقائمة</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
