<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVKhuVucDAO" %>
<%@ page import="model.KhuVuc" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Khu Vực</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="NNVaddKhuVuc.jsp" class="btn">➕ Thêm Khu Vực</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Khu Vực</h2>

    <div class="cards-container">
        <% 
        NNVKhuVucDAO dao = new NNVKhuVucDAO();
        List<KhuVuc> khuVucList = dao.getAllKhuVuc();

        if (khuVucList != null && !khuVucList.isEmpty()) {
            for (KhuVuc kv : khuVucList) {
        %>
            <div class="card">
                <p>Mã Khu Vực: <%= kv.getMaKV() %></p>
                <p>Tên Khu Vực: <%= kv.getTenKV() %></p>
                <p>Trạng Thái: <%= kv.isTrangThai() ? "Hoạt động" : "Không hoạt động" %></p>
                <div class="action-buttons">
                    <a href="NNVupdateKhuVuc.jsp?maKV=<%= kv.getMaKV() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="NNVdeleteKhuVuc?maKV=<%= kv.getMaKV() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có dữ liệu khu vực.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
