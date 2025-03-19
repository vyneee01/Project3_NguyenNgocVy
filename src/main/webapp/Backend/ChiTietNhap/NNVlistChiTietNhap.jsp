<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVChiTietNhapDAO" %>
<%@ page import="model.ChiTietNhap" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Chi Tiết Nhập</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="NNVaddChiTietNhap.jsp" class="btn">➕ Thêm Chi Tiết Nhập</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Chi Tiết Nhập</h2>

    <div class="cards-container">
        <% 
        NNVChiTietNhapDAO dao = new NNVChiTietNhapDAO();
        List<ChiTietNhap> chiTietNhapList = dao.getAllChiTietNhap(); // Đảm bảo đã có hàm getAllChiTietNhap()

        if (chiTietNhapList != null && !chiTietNhapList.isEmpty()) {
            for (ChiTietNhap ct : chiTietNhapList) {
        %>
            <div class="card">
                <h3>📄 Phiếu Nhập #<%= ct.getMaNH() %></h3>
                <p>🔢 Mã Nguyên Liệu: <%= ct.getMaNL() %></p>
                <p>📦 Số Lượng: <%= ct.getSoLuong() %></p>
                <p>💰 Giá Nhập: <%= ct.getDonGia() %> VNĐ</p>

                <div class="action-buttons">
                    <a href="deleteChiTietNhap?maNH=<%= ct.getMaNH() %>&maNL=<%= ct.getMaNL() %>" 
                       class="delete-btn" 
                       onclick="return confirm('Bạn có chắc chắn muốn xóa?')">
                        🗑️ Xóa
                    </a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center; font-weight: bold;">Không có chi tiết nhập nào.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
