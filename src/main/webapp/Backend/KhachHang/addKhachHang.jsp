<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Khách Hàng</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/KhachHang/addKhachHang" method="post">
        <h2>Thêm Khách Hàng Mới</h2>

        <label for="hoTen">Họ và Tên:</label>
        <input type="text" name="hoTen" required>

        <label for="email">Email:</label>
        <input type="email" name="email" required>

        <label for="soDienThoai">Số Điện Thoại:</label>
        <input type="text" name="soDienThoai" required>

        <label for="matKhau">Mật Khẩu:</label>
        <input type="password" name="matKhau" required>

        <button type="submit">Thêm Khách Hàng</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/NNVlistKhachHang.jsp" class="back-link">Về Trang Danh Sách</a>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
