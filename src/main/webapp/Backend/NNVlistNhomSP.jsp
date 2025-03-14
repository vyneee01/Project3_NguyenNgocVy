<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.NhomSanPham" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhóm Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="Layout/header.jsp" %>
<section>
    <h2 style="text-align: center;">Danh Sách Nhóm Sản Phẩm</h2>
    <div class="cards-container">
        <%
        CoffeDAO dao = new CoffeDAO();
        List<NhomSanPham> nhomSPList = dao.getAllNhomSanPham();

        if (nhomSPList != null && !nhomSPList.isEmpty()) {
            for (NhomSanPham nsp : nhomSPList) {
        %>
        <div class="card">
            <h3><%= nsp.getTenNhomSP() %></h3>
            <p>Mã Nhóm: <%= nsp.getMaNhomSP() %></p>
            <div class="action-buttons">
                <a href="updateNhomSanPham?maNhomSP=<%= nsp.getMaNhomSP() %>" class="edit-btn">Sửa</a>
                <a href="deleteNhomSanPham?maNhomSP=<%= nsp.getMaNhomSP() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </div>
        </div>
        <% 
            }
        } else { 
        %>
        <p>Không có nhóm sản phẩm nào để hiển thị.</p>
        <% } %>
    </div>
    <br>
    <div style="text-align: center;">
        <a href="addNhomSanPham.jsp" class="add-button">Thêm Nhóm Sản Phẩm</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
<a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="back-button">Quay lại trang chủ</a></div>
    
</section>
<%@ include file="Layout/footer.jsp" %>
</body>
</html>
