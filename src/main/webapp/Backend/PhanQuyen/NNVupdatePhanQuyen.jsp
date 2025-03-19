<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Phân Quyền</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="NNVupdatePhanQuyen" method="post">
        <h2>Cập Nhật Phân Quyền</h2>
        <input type="hidden" name="maPQ" value="${phanQuyen.maPQ}">
        
        <label for="tenQuyen">Tên Quyền:</label>
        <input type="text" name="tenQuyen" value="${phanQuyen.tenQuyen}" required>
        
        <label for="mucLuong">Mức Lương:</label>
        <input type="number" step="0.01" name="mucLuong" value="${phanQuyen.mucLuong}" required>
        
        <label for="dvt">Đơn Vị Tính:</label>
        <input type="text" name="dvt" value="${phanQuyen.dvt}" required>
        
        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/PhanQuyen/NNVlistPhanQuyen.jsp" class="back-link">Về Trang Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>