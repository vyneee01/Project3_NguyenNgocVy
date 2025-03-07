<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.KhuVuc" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Khu Vực</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="Layout/header.jsp" %>
<section>
    <h2 style="text-align: center;">Danh Sách Khu Vực</h2>
    <table border="1" style="width: 90%; margin: auto; text-align: center;">
        <tr>
            <th>Mã Khu Vực</th>
            <th>Tên Khu Vực</th>
            <th>Trạng Thái</th>
            <th>Hành Động</th>
        </tr>
        <%
        CoffeDAO dao = new CoffeDAO();
        List<KhuVuc> danhSachKV = dao.getAllKhuVuc();

        if (danhSachKV != null && !danhSachKV.isEmpty()) {
            for (KhuVuc kv : danhSachKV) {
        %>
        <tr>
            <td><%= kv.getMaKV() %></td>
            <td><%= kv.getTenKV() %></td>
            <td><%= kv.getTrangThai() %></td>
            <td>
                <a href="updateKhuVuc?maKV=<%= kv.getMaKV() %>" class="edit-btn">Sửa</a>
                <a href="deleteKhuVuc?maKV=<%= kv.getMaKV() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
        <% 
            }
        } else { 
        %>
        <tr>
            <td colspan="4">Không có khu vực nào để hiển thị.</td>
        </tr>
        <% } %>
    </table>
    <br>
    <div style="text-align: center;">
        <a href="addKhuVuc.jsp" class="add-button">Thêm Khu Vực</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
<a href="${pageContext.request.contextPath}/Backend/trangchu.jsp" class="back-button">Quay lại trang chủ</a></div>
    
</section>
<%@ include file="Layout/footer.jsp" %>
</body>
</html>
