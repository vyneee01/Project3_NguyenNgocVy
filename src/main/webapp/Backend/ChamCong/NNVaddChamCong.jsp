<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Chấm Công</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/ChamCong/NNVaddChamCong" method="post">
        <h2>Thêm Chấm Công</h2>

        <label for="ngayCong">Ngày Công:</label>
        <input type="datetime-local" name="ngayCong" required>

        <label for="maNV">Mã Nhân Viên:</label>
        <input type="text" name="maNV" required>

        <button type="submit">Thêm</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/ChamCong/NNVlistChamCong.jsp" class="back-link">Về Trang Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
