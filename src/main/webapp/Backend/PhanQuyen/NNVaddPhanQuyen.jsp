<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Phân Quyền</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/PhanQuyen/NNVaddPhanQuyen" method="post">
        <h2>Thêm Phân Quyền</h2>

        <label for="tenQuyen">Tên Quyền:</label>
        <input type="text" name="tenQuyen" required>

        <label for="mucLuong">Mức Lương:</label>
        <input type="number" name="mucLuong" step="0.01" required>

        <label for="dvt">Đơn Vị Tính:</label>
        <input type="text" name="dvt" required>

        <button type="submit">Thêm Quyền</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/PhanQuyen/NNVlistPhanQuyen.jsp" class="back-link">Về Trang Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
