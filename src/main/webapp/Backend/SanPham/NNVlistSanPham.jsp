<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.SanPham" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="addSanPham.jsp" class="btn">➕ Thêm Sản Phẩm</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Sản Phẩm</h2>

    <div class="cards-container">
        <% 
        CoffeDAO dao = new CoffeDAO();
        List<SanPham> sanPhamList = dao.getAllSanPham();

        if (sanPhamList != null && !sanPhamList.isEmpty()) {
            for (SanPham sp : sanPhamList) {
        %>
            <div class="card">
                <img src="${pageContext.request.contextPath}/images/<%= sp.getAnh() %>" alt="<%= sp.getTenSP() %>">
                <h3><%= sp.getTenSP() %></h3>
                <p>Mã: <%= sp.getMaSP() %></p>
                <p>Giá: <%= sp.getDonGia() %> VND</p>
                <p>Đơn Vị Tính: <%= sp.getDvt() %></p>
                <div class="action-buttons">
                    <a href="updateSanPham?maSP=<%= sp.getMaSP() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="deleteSanPham?maSP=<%= sp.getMaSP() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có sản phẩm nào để hiển thị.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
