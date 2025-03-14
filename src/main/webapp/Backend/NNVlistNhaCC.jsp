<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.NhaCungCap" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhà Cung Cấp</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

</head>
<body>
<%@ include file="Layout/header.jsp" %>
<section>
    <h2 style="text-align: center;">Danh Sách Nhà Cung Cấp</h2>
    <table border="1" style="width: 90%; margin: auto; text-align: center;">
        <tr>
            <th>Mã NCC</th>
            <th>Tên Nhà Cung Cấp</th>
            <th>Số Điện Thoại</th>
            <th>Địa Chỉ</th>
            <th>Công Nợ</th>
            <th>Ghi Chú</th>
            <th>Hành Động</th>
        </tr>
        <%
        CoffeDAO dao = new CoffeDAO();
        List<NhaCungCap> danhSachNCC = dao.getAllNhaCungCap();

        if (danhSachNCC != null && !danhSachNCC.isEmpty()) {
            for (NhaCungCap ncc : danhSachNCC) {
        %>
        <tr>
            <td><%= ncc.getMaNCC() %></td>
            <td><%= ncc.getTenNCC() %></td>
            <td><%= ncc.getSdt() %></td>
            <td><%= ncc.getDiaChi() %></td>
            <td><%= ncc.getCongNo() %></td>
            <td><%= ncc.getGhiChu() %></td>
            <td>
                <a href="updateNhaCungCap?maNCC=<%= ncc.getMaNCC() %>" class="edit-btn">Sửa</a>
                <a href="deleteNhaCungCap?maNCC=<%= ncc.getMaNCC() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
        <% 
            }
        } else { 
        %>
        <tr>
            <td colspan="7">Không có nhà cung cấp nào để hiển thị.</td>
        </tr>
        <% } %>
    </table>
    <br>
    <div style="text-align: center;">
        <a href="addNhaCungCap.jsp" class="add-button">Thêm Nhà Cung Cấp</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
<a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="back-button">Quay lại trang chủ</a></div>
    
</section>
<%@ include file="Layout/footer.jsp" %>
</body>
</html>
