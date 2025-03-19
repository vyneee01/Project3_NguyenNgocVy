<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Nhóm Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/NhomSanPham/addNhomSanPham" method="post">
        <h2>Thêm Nhóm Sản Phẩm</h2>

        <label for="maNhomSP">Mã Nhóm:</label>
        <input type="text" name="maNhomSP" required>

        <label for="tenNhomSP">Tên Nhóm:</label>
        <input type="text" name="tenNhomSP" required>

        <button type="submit">Thêm Nhóm</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NhomSanPham/NNVlistNhomSanPham.jsp" class="back-link">Về Trang Danh Sách</a>
<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
