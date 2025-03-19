<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Nhà Cung Cấp</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/NhaCungCap/NNVaddNCC" method="post">
        <h2>Thêm Nhà Cung Cấp</h2>
        
        <label for="tenNCC">Tên Nhà Cung Cấp:</label>
        <input type="text" name="tenNCC" required>
        
        <label for="sdt">Số Điện Thoại:</label>
        <input type="text" name="sdt" required>
        
        <label for="diaChi">Địa Chỉ:</label>
        <input type="text" name="diaChi" required>
        
        <label for="congNo">Công Nợ:</label>
        <input type="number" step="0.01" name="congNo" required>
        
        <label for="ghiChu">Ghi Chú:</label>
        <input type="text" name="ghiChu">
        
        <button type="submit">Thêm Nhà Cung Cấp</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NhaCungCap/NNVlistNCC.jsp" class="back-link">Về Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
