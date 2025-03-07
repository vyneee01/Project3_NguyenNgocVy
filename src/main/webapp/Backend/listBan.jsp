<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.Ban" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Bàn</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="Layout/header.jsp" %>
<section>
    <h2 style="text-align: center;">Danh Sách Bàn</h2>
    <div class="cards-container">
        <%
        CoffeDAO dao = new CoffeDAO();
        List<Ban> banList = dao.getAllBan();

        if (banList != null && !banList.isEmpty()) {
            for (Ban b : banList) {
        %>
        <div class="card">
            <h3>Bàn: <%= b.getMaBan() %></h3>
            <p>Khu Vực: <%= b.getMaKV() %></p>
            <p>Trạng Thái: <%= b.isTrangThai() ? "Đang sử dụng" : "Trống" %></p>
            <div class="action-buttons">
                <a href="updateBan?maBan=<%= b.getMaBan() %>" class="edit-btn">Sửa</a>
                <a href="deleteBan?maBan=<%= b.getMaBan() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </div>
        </div>
        <% 
            }
        } else { 
        %>
        <p>Không có bàn nào để hiển thị.</p>
        <% } %>
    </div>
    <br>
    <div style="text-align: center;">
        <a href="addBan.jsp" class="add-button">Thêm Bàn</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
<a href="${pageContext.request.contextPath}/Backend/trangchu.jsp" class="back-button">Quay lại trang chủ</a></div>
    
</section>
<%@ include file="Layout/footer.jsp" %>
</body>
</html>
