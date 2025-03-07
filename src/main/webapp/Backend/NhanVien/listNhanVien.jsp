<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.NhanVien" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhân Viên</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>
    <section>
    <h2 style="text-align: center;">Danh Sách Nhân Viên</h2>
    <div class="cards-container">
        <% 
        // Lấy danh sách nhân viên từ database thông qua DAO
        CoffeDAO dao = new CoffeDAO();
        List<NhanVien> nhanVienList = null;
        try {
            nhanVienList = dao.getAllNhanVien();
        } catch (Exception e) {
            out.println("Có lỗi trong quá trình lấy dữ liệu: " + e.getMessage());
        }

        if (nhanVienList != null && !nhanVienList.isEmpty()) {
            for (NhanVien nv : nhanVienList) {
        %>
            <div class="card">
                <h3><%= nv.getHo() + " " + nv.getTen() %></h3>
                <p>Mã Nhân Viên: <%= nv.getMaNV() %></p>
                <p>Giới Tính: <%= nv.isGioiTinh() ? "Nam" : "Nữ" %></p>
                <p>Số Điện Thoại: <%= nv.getSdt() %></p>
                <p>CCCD: <%= nv.getCccd() %></p>
                <p>Trạng Thái: <%= nv.isTrangThai() ? "Hoạt động" : "Ngừng hoạt động" %></p>
                <div class="action-buttons">
                    <a href="updateNhanVien?maNV=<%= nv.getMaNV() %>" class="edit-btn">Sửa</a>
                    <a href="deleteNhanVien?maNV=<%= nv.getMaNV() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p>Không có nhân viên nào để hiển thị.</p>
        <% 
        } 
        %>
    </div>
    <br>
    <div style="text-align: center;">
        <a href="addNhanVien.jsp" class="add-button">Thêm Nhân Viên</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
<a href="${pageContext.request.contextPath}/Backend/trangchu.jsp" class="back-button">Quay lại trang chủ</a></div>
    
</section>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
