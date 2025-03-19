<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVNhapHangDAO" %>
<%@ page import="model.NhapHang" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Phiếu Nhập</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="NNVaddNhapHang.jsp" class="btn">➕ Thêm Phiếu Nhập</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Phiếu Nhập</h2>

    <div class="cards-container">
        <% 
        NNVNhapHangDAO dao = new NNVNhapHangDAO();
        List<NhapHang> nhapHangList = dao.getAllNhapHang();

        if (nhapHangList != null && !nhapHangList.isEmpty()) {
            for (NhapHang nh : nhapHangList) {
        %>
            <div class="card">
                <h3>Phiếu Nhập #<%= nh.getMaNH() %></h3>
                <p>📅 Ngày Nhập: <%= nh.getNgayNhap() %></p>
                <p>👨‍💼 Mã Nhân Viên: <%= nh.getMaNV() %></p>
                <p>🏢 Mã Nhà Cung Cấp: <%= nh.getMaNCC() %></p>
                <p>💰 Tổng Tiền: <%= nh.getTongTien() %> VNĐ</p>
                <p>📝 Ghi Chú: <%= nh.getGhiChu() != null ? nh.getGhiChu() : "Không có ghi chú" %></p>
                
                <div class="action-buttons">
                    <a href="updateNhapHang?maNH=<%= nh.getMaNH() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="deleteNhapHang?maNH=<%= nh.getMaNH() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có phiếu nhập nào.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
