<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVNCCDAO" %>
<%@ page import="model.NhaCungCap" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhà Cung Cấp</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="addNCC.jsp" class="btn">➕ Thêm Nhà Cung Cấp</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Nhà Cung Cấp</h2>

    <div class="cards-container">
        <% 
        NNVNCCDAO dao = new NNVNCCDAO();
        List<NhaCungCap> nhaCungCapList = dao.getAllNhaCungCap();

        if (nhaCungCapList != null && !nhaCungCapList.isEmpty()) {
            for (NhaCungCap ncc : nhaCungCapList) {
        %>
            <div class="card">
                <h3><%= ncc.getTenNCC() %></h3>
                <p>Mã NCC: <%= ncc.getMaNCC() %></p>
                <p>Địa Chỉ: <%= ncc.getDiaChi() %></p>
                <p>SĐT: <%= ncc.getSdt() %></p>
                <div class="action-buttons">
                    <a href="NNVupdateNCC?maNCC=<%= ncc.getMaNCC() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="NNVdeleteNCC?maNCC=<%= ncc.getMaNCC() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có nhà cung cấp nào.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
