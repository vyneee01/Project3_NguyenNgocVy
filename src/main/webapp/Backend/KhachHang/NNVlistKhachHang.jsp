<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVKhachHangDAO" %>
<%@ page import="model.NNVKhachHang" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Khách Hàng</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
    
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <!-- Nút điều hướng đầu trang -->
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="addKhachHang.jsp" class="btn">➕ Thêm Khách Hàng</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Khách Hàng</h2>

    <div class="cards-container">
        <% 
        NNVKhachHangDAO dao = new NNVKhachHangDAO();
        List<NNVKhachHang> khachHangList = dao.getAllKhachHang();

        if (khachHangList != null && !khachHangList.isEmpty()) {
            for (NNVKhachHang kh : khachHangList) {
        %>
            <div class="card">
                <h3><%= kh.getHoTen() %></h3>
                <p>Email: <%= kh.getEmail() %></p>
                <p>Số Điện Thoại: <%= kh.getSoDienThoai() %></p>
                <p>Ngày Đăng Ký: <%= kh.getNgayDangKy() %></p>
                <div class="action-buttons">
                    <a href="updateKhachHang?maKH=<%= kh.getMaKH() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="deleteKhachHang?maKH=<%= kh.getMaKH() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có khách hàng nào để hiển thị.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
