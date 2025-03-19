<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVNhapHangDAO" %>
<%@ page import="DAO.NNVNguyenLieuDAO" %>
<%@ page import="model.NhapHang" %>
<%@ page import="model.NguyenLieu" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Chi Tiết Nhập</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/NhapHang/addChiTietNhap" method="post">
        <h2>Thêm Chi Tiết Nhập</h2>

        <label for="maNH">Chọn Phiếu Nhập:</label>
        <select name="maNH" required>
            <option value="">Chọn Phiếu Nhập</option>
            <% 
                NNVNhapHangDAO nhapHangDAO = new NNVNhapHangDAO();
                List<NhapHang> dsNhapHang = nhapHangDAO.getAllNhapHang();
                for (NhapHang nh : dsNhapHang) {
            %>
                <option value="<%= nh.getMaNH() %>">
                    Phiếu #<%= nh.getMaNH() %> - Ngày: <%= nh.getNgayNhap() %>
                </option>
            <% } %>
        </select>

        <label for="maNL">Chọn Nguyên Liệu:</label>
        <select name="maNL" required>
            <option value="">Chọn Nguyên Liệu</option>
            <% 
                NNVNguyenLieuDAO nlDAO = new NNVNguyenLieuDAO();
                List<NguyenLieu> dsNguyenLieu = nlDAO.getAllNguyenLieu();
                for (NguyenLieu nl : dsNguyenLieu) {
            %>
                <option value="<%= nl.getMaNL() %>">
                    <%= nl.getMaNL() %> - <%= nl.getTenNL() %>
                </option>
            <% } %>
        </select>

        <label for="soLuong">Số Lượng:</label>
        <input type="number" name="soLuong" min="1" required>

        <label for="donGia">Giá Nhập:</label>
        <input type="number" name="donGia" min="0" step="0.01" required>

        <button type="submit">➕ Thêm Chi Tiết Nhập</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/ChiTietNhap/NNVlistChiTietNhap.jsp" class="back-link">⬅ Về Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
