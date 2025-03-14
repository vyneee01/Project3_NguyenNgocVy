<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.LoaiPhieu" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Loại Phiếu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="Layout/header.jsp" %>
<section>
    <h2 style="text-align: center;">Danh Sách Loại Phiếu</h2>
    <table border="1" style="width: 80%; margin: auto; text-align: center;">
        <tr>
            <th>Mã Loại Phiếu</th>
            <th>Tên Loại Phiếu</th>
            <th>Hành Động</th>
        </tr>
        <%
        CoffeDAO dao = new CoffeDAO();
        List<LoaiPhieu> danhSachLP = dao.getAllLoaiPhieu();

        if (danhSachLP != null && !danhSachLP.isEmpty()) {
            for (LoaiPhieu lp : danhSachLP) {
        %>
        <tr>
            <td><%= lp.getMaLP() %></td>
            <td><%= lp.getTenLP() %></td>
            <td>
                <a href="updateLoaiPhieu?maLP=<%= lp.getMaLP() %>" class="edit-btn">Sửa</a>
                <a href="deleteLoaiPhieu?maLP=<%= lp.getMaLP() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
        <% 
            }
        } else { 
        %>
        <tr>
            <td colspan="3">Không có dữ liệu loại phiếu để hiển thị.</td>
        </tr>
        <% } %>
    </table>
    <br>
    <div style="text-align: center;">
        <a href="addLoaiPhieu.jsp" class="add-button">Thêm Loại Phiếu</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
<a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="back-button">Quay lại trang chủ</a></div>
    
</section>
<%@ include file="Layout/footer.jsp" %>
</body>
</html>
