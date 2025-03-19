<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVNhanVienDAO" %>
<%@ page import="model.NhanVien" %>
<%@ page import="DAO.NNVPhanQuyenDAO" %>
<%@ page import="model.PhanQuyen" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhân Viên</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
    
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="addNhanVien.jsp" class="btn">➕ Thêm Nhân Viên</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Nhân Viên</h2>

    <div class="cards-container">
        <% 
        NNVNhanVienDAO dao = new NNVNhanVienDAO();
        List<NhanVien> nhanVienList = null;
        NNVPhanQuyenDAO pqDao = new NNVPhanQuyenDAO();
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
				<%
				    PhanQuyen pq = pqDao.getPhanQuyenByMaPQ(nv.getMaPQ()); // Lấy tên quyền từ mã PQ
				    String tenQuyen = (pq != null) ? pq.getTenQuyen() : "Không xác định";
				%>
				<p>Chức Vụ: <%= tenQuyen %></p>
                <p>Trạng Thái: <%= nv.isTrangThai() ? "Hoạt động" : "Ngừng hoạt động" %></p>
                <div class="action-buttons">
                    <a href="updateNhanVien?maNV=<%= nv.getMaNV() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="deleteNhanVien?maNV=<%= nv.getMaNV() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có nhân viên nào để hiển thị.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
