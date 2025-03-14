<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.ChamCong" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Chấm Công</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="Layout/header.jsp" %>
<section>
    <h2 style="text-align: center;">Danh Sách Chấm Công</h2>
    <table border="1" style="width: 90%; margin: auto; text-align: center;">
        <tr>
            <th>Mã Chấm Công</th>
            <th>Ngày Công</th>
            <th>Mã Nhân Viên</th>
            <th>Hành Động</th>
        </tr>
        <%
        CoffeDAO dao = new CoffeDAO();
        List<ChamCong> danhSachCC = dao.getAllChamCong();

        if (danhSachCC != null && !danhSachCC.isEmpty()) {
            for (ChamCong cc : danhSachCC) {
        %>
        <tr>
            <td><%= cc.getMaCC() %></td>
            <td><%= cc.getNgayCong() %></td>
            <td><%= cc.getMaNV() %></td>
            <td>
                <a href="updateChamCong?maCC=<%= cc.getMaCC() %>" class="edit-btn">Sửa</a>
                <a href="deleteChamCong?maCC=<%= cc.getMaCC() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
        <% 
            }
        } else { 
        %>
        <tr>
            <td colspan="4">Không có dữ liệu chấm công để hiển thị.</td>
        </tr>
        <% } %>
    </table>
    <br>
    <div style="text-align: center;">
        <a href="addChamCong.jsp" class="add-button">Thêm Chấm Công</a>
    </div>
    <div style="text-align: center; margin-top: 20px;">
<a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="back-button">Quay lại trang chủ</a></div>
    
</section>
<%@ include file="Layout/footer.jsp" %>
</body>
</html>
