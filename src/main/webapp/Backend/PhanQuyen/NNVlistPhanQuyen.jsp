<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVPhanQuyenDAO" %>
<%@ page import="model.PhanQuyen" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Phân Quyền</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="NNVaddPhanQuyen.jsp" class="btn">➕ Thêm Phân Quyền</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Phân Quyền</h2>

    <div class="cards-container">
        <% 
        NNVPhanQuyenDAO dao = new NNVPhanQuyenDAO();
        List<PhanQuyen> phanQuyenList = dao.getAllPhanQuyen();

        if (phanQuyenList != null && !phanQuyenList.isEmpty()) {
            for (PhanQuyen pq : phanQuyenList) {
        %>
            <div class="card">
                <h3><%= pq.getTenQuyen() %></h3>
                <p>Mã Quyền: <%= pq.getMaPQ() %></p>
                <div class="action-buttons">
                    <a href="NNVupdatePhanQuyen?maPQ=<%= pq.getMaPQ() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="NNVdeletePhanQuyen?maPQ=<%= pq.getMaPQ() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có quyền nào.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
