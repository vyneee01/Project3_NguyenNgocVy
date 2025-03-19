<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVNhomSanPhamDAO" %>
<%@ page import="model.NhomSanPham" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhóm Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="addNhomSanPham.jsp" class="btn">➕ Thêm Nhóm Sản Phẩm</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Nhóm Sản Phẩm</h2>

    <div class="cards-container">
        <% 
        NNVNhomSanPhamDAO dao = new NNVNhomSanPhamDAO();
        List<NhomSanPham> nhomSPList = dao.getAllNhomSanPham();

        if (nhomSPList != null && !nhomSPList.isEmpty()) {
            for (NhomSanPham sp : nhomSPList) {
        %>
            <div class="card">
                <h3><%= sp.getTenNhomSP() %></h3>
                <p>Mã Nhóm: <%= sp.getMaNhomSP() %></p>
                <div class="action-buttons">
                    <a href="updateNhomSanPham?maNhomSP=<%= sp.getMaNhomSP() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="deleteNhomSanPham?maNhomSP=<%= sp.getMaNhomSP() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có nhóm sản phẩm nào.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
