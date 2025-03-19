<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cập Nhật Khách Hàng</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/KhachHang/updateKhachHang" method="post">
        <h2>Cập Nhật Khách Hàng</h2>

        <input type="hidden" name="maKH" value="${khachHang.maKH}">

        <label for="hoTen">Họ và Tên:</label>
        <input type="text" name="hoTen" value="${khachHang.hoTen}" required>

        <label for="email">Email:</label>
        <input type="email" name="email" value="${khachHang.email}" required>

        <label for="soDienThoai">Số Điện Thoại:</label>
        <input type="text" name="soDienThoai" value="${khachHang.soDienThoai}" required>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/NNVlistKhachHang.jsp" class="back-link">Về Trang Danh Sách</a>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
