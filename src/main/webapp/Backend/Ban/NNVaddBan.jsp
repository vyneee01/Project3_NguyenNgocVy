<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Bàn</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/Ban/NNVaddBan" method="post">
        <h2>Thêm Bàn</h2>

        <label for="maKV">Mã Khu Vực:</label>
        <input type="text" name="maKV" required>

        <label for="trangThai">Trạng Thái:</label>
        <input type="checkbox" id="trangThai" name="trangThai" checked> Hoạt động

        <button type="submit">Thêm</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/Ban/NNVlistBan.jsp" class="back-link">Về Trang Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
