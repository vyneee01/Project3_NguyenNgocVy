<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVBanDAO" %>
<%@ page import="model.Ban" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Bàn</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="NNVaddBan.jsp" class="btn">➕ Thêm Bàn</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Bàn</h2>

    <div class="cards-container">
        <% 
        NNVBanDAO dao = new NNVBanDAO();
        List<Ban> danhSachBan = dao.getAllBan();

        if (danhSachBan != null && !danhSachBan.isEmpty()) {
            for (Ban ban : danhSachBan) {
        %>
            <div class="card">
                <p>Mã Bàn: <%= ban.getMaBan() %></p>
                <p>Trạng Thái: <%= ban.isTrangThai() ? "Hoạt động" : "Không hoạt động" %></p>
                <p>Mã Khu Vực: <%= ban.getMaKV() %></p>
                <div class="action-buttons">
                    <a href="NNVupdateBan.jsp?maBan=<%= ban.getMaBan() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="NNVdeleteBan?maBan=<%= ban.getMaBan() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có dữ liệu bàn.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
