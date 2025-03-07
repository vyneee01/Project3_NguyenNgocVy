<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.PhanQuyen" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Phân Quyền</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="Layout/header.jsp" %>
<section>
    <h2 style="text-align: center;">Danh Sách Phân Quyền</h2>
    <table border="1" style="width: 80%; margin: auto; text-align: center;">
        <tr>
            <th>Mã Quyền</th>
            <th>Tên Quyền</th>
            <th>Mức Lương</th>
            <th>Đơn Vị Tính</th>
            <th>Hành Động</th>
        </tr>
        <%
        CoffeDAO dao = new CoffeDAO();
        List<PhanQuyen> danhSachPQ = dao.getAllPhanQuyen();

        if (danhSachPQ != null && !danhSachPQ.isEmpty()) {
            for (PhanQuyen pq : danhSachPQ) {
        %>
        <tr>
            <td><%= pq.getMaPQ() %></td>
            <td><%= pq.getTenQuyen() %></td>
            <td><%= pq.getMucLuong() %></td>
            <td><%= pq.getDvt() %></td>
            <td>
                <a href="updatePhanQuyen?maPQ=<%= pq.getMaPQ() %>" class="edit-btn">Sửa</a>
                <a href="deletePhanQuyen?maPQ=<%= pq.getMaPQ() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
        <% 
            }
        } else { 
        %>
        <tr>
            <td colspan="5">Không có phân quyền nào để hiển thị.</td>
        </tr>
        <% } %>
    </table>
    <br>
    <div style="text-align: center;">
        <a href="addPhanQuyen.jsp" class="add-button">Thêm Phân Quyền</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
    <a href="${pageContext.request.contextPath}/Backend/trangchu.jsp" class="back-button">Quay lại trang chủ</a>
</div>
    
</section>
<%@ include file="Layout/footer.jsp" %>
</body>
</html>
