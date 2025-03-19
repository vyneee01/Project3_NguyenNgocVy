<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVNguyenLieuDAO" %>
<%@ page import="model.NguyenLieu" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nguyên Liệu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="NNVaddNguyenLieu.jsp" class="btn">➕ Thêm Nguyên Liệu</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Nguyên Liệu</h2>

    <div class="cards-container">
        <% 
        NNVNguyenLieuDAO dao = new NNVNguyenLieuDAO();
        List<NguyenLieu> nguyenLieuList = dao.getAllNguyenLieu();

        if (nguyenLieuList != null && !nguyenLieuList.isEmpty()) {
            for (NguyenLieu nl : nguyenLieuList) {
        %>
            <div class="card">
                <h3><%= nl.getTenNL() %></h3>
                <p>Mã NL: <%= nl.getMaNL() %></p>
                <p>Đơn Vị Tính: <%= nl.getDvt() %></p>
                <p>Đơn Giá: <%= nl.getDonGia() %> VND</p>
                <p>Số Lượng: <%= nl.getSl() %></p>
                <div class="action-buttons">
                    <a href="NNVupdateNguyenLieu?maNL=<%= nl.getMaNL() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="NNVdeleteNguyenLieu?maNL=<%= nl.getMaNL() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có nguyên liệu nào.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
