<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

    <section class="form-container">
        <form class="form" action="updateSanPham" method="post">
            <h2>Cập Nhật Sản Phẩm</h2>
            <input type="hidden" name="maSP" value="${sanPham.maSP}">
            
            <label for="tenSP">Tên Sản Phẩm:</label>
            <input type="text" name="tenSP" value="${sanPham.tenSP}" required>
            
            <label for="anh">Hình Ảnh:</label>
            <input type="text" name="anh" value="${sanPham.anh}" required>
            
            <label for="dvt">Đơn Vị Tính:</label>
            <input type="text" name="dvt" value="${sanPham.dvt}" required>
            
            <label for="donGia">Đơn Giá:</label>
            <input type="number" step="0.01" name="donGia" value="${sanPham.donGia}" required>
            
            <label for="maNhomSP">Mã Nhóm Sản Phẩm:</label>
            <input type="text" name="maNhomSP" value="${sanPham.maNhomSP}" required>
            
            <button type="submit">Cập Nhật</button>
        </form>
    </section>
    <a href="${pageContext.request.contextPath}/Backend/SanPham/NNVlistSanPham.jsp" class="back-link">Về Trang Danh Sách</a>
        <%@ include file="../Layout/footer.jsp" %>	
    
</body>
</html>
