<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVNhanVienDAO, model.NhanVien, java.util.List" %>
<%@ page import="model.NhapHang" %>

<% 
    NhapHang nhapHang = (NhapHang) request.getAttribute("nhapHang");
    DAO.NNVNhanVienDAO nvDAO = new DAO.NNVNhanVienDAO();
    List<NhanVien> nhanVienList = nvDAO.getAllNhanVien();
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Phiếu Nhập</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/NhapHang/updateNhapHang" method="post">
        <h2>Cập Nhật Phiếu Nhập</h2>

        <input type="hidden" name="maNH" value="<%= nhapHang.getMaNH() %>">

        <label for="ngayNhap">Ngày Nhập:</label>
        <input type="date" name="ngayNhap" value="<%= nhapHang.getNgayNhap().toLocalDateTime().toLocalDate() %>" required>

        <label for="maNCC">Nhà Cung Cấp:</label>
        <input type="text" name="maNCC" value="<%= nhapHang.getMaNCC() %>" required>

        <label for="maNV">Nhân Viên:</label>
        <select name="maNV" required>
            <option value="">Chọn Nhân Viên</option>
            <% for (NhanVien nv : nhanVienList) { %>
                <option value="<%= nv.getMaNV() %>" <%= (nv.getMaNV() == nhapHang.getMaNV()) ? "selected" : "" %>><%= nv.getMaNV() %></option>
            <% } %>
        </select>

        <label for="tongTien">Tổng Tiền:</label>
        <input type="text" name="tongTien" value="<%= nhapHang.getTongTien() %>" required>

        <label for="ghiChu">Ghi Chú:</label>
        <textarea name="ghiChu"><%= nhapHang.getGhiChu() %></textarea>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NhapHang/NNVlistNhapHang.jsp" class="back-link">Về Trang Danh Sách</a>
<%@ include file="../Layout/footer.jsp" %>

</body>
</html>
