<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Nguyên Liệu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/NguyenLieu/NNVaddNguyenLieu" method="post">
        <h2>Thêm Nguyên Liệu</h2>
        
        <label for="tenNL">Tên Nguyên Liệu:</label>
        <input type="text" name="tenNL" required>
        
        <label for="dvt">Đơn Vị Tính:</label>
        <input type="text" name="dvt" required>
        
        <label for="donGia">Đơn Giá:</label>
        <input type="number" step="0.01" name="donGia" required>
        
        <label for="sl">Số Lượng:</label>
        <input type="number" step="1" name="sl" required>
        
        <button type="submit">Thêm Nguyên Liệu</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NguyenLieu/NNVlistNguyenLieu.jsp" class="back-link">Về Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
