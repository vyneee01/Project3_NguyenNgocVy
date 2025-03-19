<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVNhanVienDAO" %>
<%@ page import="DAO.NNVNCCDAO" %>
<%@ page import="model.NhanVien" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Phiếu Nhập</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/NhapHang/addNhapHang" method="post">
        <h2>Thêm Phiếu Nhập</h2>

        <label for="ngayNhap">Ngày Nhập:</label>
        <input type="date" name="ngayNhap" required>

        <label for="maNV">Mã Nhân Viên:</label>
        <select name="maNV" required>
            <option value="">Chọn Mã Nhân Viên</option>
            <% 
                NNVNhanVienDAO nvDAO = new NNVNhanVienDAO();
                List<NhanVien> nhanVienList = nvDAO.getAllNhanVien();
                for (NhanVien nv : nhanVienList) {
            %>
                <option value="<%= nv.getMaNV() %>"><%= nv.getMaNV() %></option>
            <% } %>
        </select>

        <label for="maNCC">Nhà Cung Cấp:</label>
        <select name="maNCC" required>
            <option value="">Chọn Nhà Cung Cấp</option>
            <% 
                DAO.NNVNCCDAO nccDAO = new DAO.NNVNCCDAO();
                List<model.NhaCungCap> nccList = nccDAO.getAllNhaCungCap();
                for (model.NhaCungCap ncc : nccList) {
            %>
                <option value="<%= ncc.getMaNCC() %>">
                    <%= ncc.getMaNCC() %> - <%= ncc.getTenNCC() %>
                </option>
            <% } %>
        </select>

        <label for="tongTien">Tổng Tiền:</label>
        <input type="number" step="0.01" name="tongTien" required placeholder="Nhập tổng tiền">

        <label for="ghiChu">Ghi Chú:</label>
        <textarea name="ghiChu" rows="3" placeholder="Nhập ghi chú"></textarea>

        <button type="submit">Thêm Phiếu Nhập</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NhapHang/NNVlistNhapHang.jsp" class="back-link">Về Trang Danh Sách</a>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
