<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.NguyenLieu" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nguyên Liệu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="Layout/header.jsp" %>
<section>
    <h2 style="text-align: center;">Danh Sách Nguyên Liệu</h2>
    <table border="1" style="width: 90%; margin: auto; text-align: center;">
        <tr>
            <th>Mã Nguyên Liệu</th>
            <th>Tên Nguyên Liệu</th>
            <th>Đơn Vị Tính</th>
            <th>Đơn Giá</th>
            <th>Số Lượng</th>
            <th>Hành Động</th>
        </tr>
        <%
        CoffeDAO dao = new CoffeDAO();
        List<NguyenLieu> danhSachNL = dao.getAllNguyenLieu();

        if (danhSachNL != null && !danhSachNL.isEmpty()) {
            for (NguyenLieu nl : danhSachNL) {
        %>
        <tr>
            <td><%= nl.getMaNL() %></td>
            <td><%= nl.getTenNL() %></td>
            <td><%= nl.getDvt() %></td>
            <td><%= nl.getDonGia() %></td>
            <td><%= nl.getSl() %></td>
            <td>
                <a href="updateNguyenLieu?maNL=<%= nl.getMaNL() %>" class="edit-btn">Sửa</a>
                <a href="deleteNguyenLieu?maNL=<%= nl.getMaNL() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
        <% 
            }
        } else { 
        %>
        <tr>
            <td colspan="6">Không có nguyên liệu nào để hiển thị.</td>
        </tr>
        <% } %>
    </table>
    <br>
    <div style="text-align: center;">
        <a href="addNguyenLieu.jsp" class="add-button">Thêm Nguyên Liệu</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
<a href="${pageContext.request.contextPath}/Backend/trangchu.jsp" class="back-button">Quay lại trang chủ</a></div>
    
</section>
<%@ include file="Layout/footer.jsp" %>
</body>
</html>
