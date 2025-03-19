<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVNguyenLieuDAO" %>
<%@ page import="model.NguyenLieu" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Nguyên Liệu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<%
    int maNL = Integer.parseInt(request.getParameter("maNL"));
    NNVNguyenLieuDAO nlDao = new NNVNguyenLieuDAO();
    NguyenLieu nl = nlDao.getNguyenLieuById(maNL);
%>

<section class="form-container">
    <form class="form" action="NNVupdateNguyenLieu" method="post">
        <h2>Cập Nhật Nguyên Liệu</h2>
        <input type="hidden" name="maNL" value="<%= nl.getMaNL() %>">
        
        <label for="tenNL">Tên Nguyên Liệu:</label>
        <input type="text" name="tenNL" value="<%= nl.getTenNL() %>" required>
        
        <label for="dvt">Đơn Vị Tính:</label>
        <input type="text" name="dvt" value="<%= nl.getDvt() %>" required>
        
        <label for="donGia">Đơn Giá:</label>
        <input type="number" step="0.01" name="donGia" value="<%= nl.getDonGia() %>" required>
        
        <label for="sl">Số Lượng:</label>
        <input type="number" step="1" name="sl" value="<%= nl.getSl() %>" required>
        
        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NguyenLieu/NNVlistNguyenLieu.jsp" class="back-link">Về Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
