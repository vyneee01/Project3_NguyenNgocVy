<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVNhomSanPhamDAO" %>
<%@ page import="model.NhomSanPham" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cập Nhật Nhóm Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<%
    String maNhomSP = request.getParameter("maNhomSP");
    NNVNhomSanPhamDAO dao = new NNVNhomSanPhamDAO();
    NhomSanPham nhomSP = dao.getNhomSanPhamById(maNhomSP);
%>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/NhomSanPham/updateNhomSanPham" method="post">
        <h2>Cập Nhật Nhóm Sản Phẩm</h2>

        <input type="hidden" name="maNhomSP" value="<%= nhomSP.getMaNhomSP() %>">

        <label for="tenNhomSP">Tên Nhóm Sản Phẩm:</label>
        <input type="text" name="tenNhomSP" value="<%= nhomSP.getTenNhomSP() %>" required>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NhomSanPham/NNVlistNhomSanPham.jsp" class="back-link">Về Trang Danh Sách</a>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
