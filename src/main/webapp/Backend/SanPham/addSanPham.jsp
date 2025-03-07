<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

    <section class="form-container">
        <form class="form" action="addSanPham" method="post">
            <h2>Thêm Sản Phẩm Mới</h2>
            
            <label for="tenSP">Tên Sản Phẩm:</label>
            <input type="text" name="tenSP" required>
            
            <label for="anh">Hình Ảnh:</label>
            <input type="text" name="anh" required>
            
            <label for="dvt">Đơn Vị Tính:</label>
            <input type="text" name="dvt" required>
            
            <label for="donGia">Đơn Giá:</label>
            <input type="number" step="0.01" name="donGia" required>
            
            <label for="maNhomSP">Mã Nhóm Sản Phẩm:</label>
            <input type="text" name="maNhomSP" required>
            
            <button type="submit">Thêm Sản Phẩm</button>
        </form>
    </section>
    <a href="${pageContext.request.contextPath}/listSanPham.jsp" class="back-link">Về Trang Danh Sách</a>
        <%@ include file="/Backend/Layout/footer.jsp" %>
    
</body>
</html>
