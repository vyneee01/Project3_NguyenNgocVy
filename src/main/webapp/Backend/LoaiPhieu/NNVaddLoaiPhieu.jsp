<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Loại Phiếu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/LoaiPhieu/NNVaddLoaiPhieu" method="post">
        <h2>Thêm Loại Phiếu</h2>

        <label for="tenLP">Tên Loại Phiếu:</label>
        <input type="text" name="tenLP" required>

        <button type="submit">Thêm</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/LoaiPhieu/NNVlistLoaiPhieu.jsp" class="back-link">Về Trang Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
