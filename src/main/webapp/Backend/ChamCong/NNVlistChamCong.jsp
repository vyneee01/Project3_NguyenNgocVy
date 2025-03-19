<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVChamCongDAO" %>
<%@ page import="model.ChamCong" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Chấm Công</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="NNVaddChamCong.jsp" class="btn">➕ Thêm Chấm Công</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Chấm Công</h2>

    <div class="cards-container">
        <% 
        NNVChamCongDAO dao = new NNVChamCongDAO();
        List<ChamCong> chamCongList = dao.getAllChamCong();

        if (chamCongList != null && !chamCongList.isEmpty()) {
            for (ChamCong cc : chamCongList) {
        %>
            <div class="card">
                <p>Mã Chấm Công: <%= cc.getMaCC() %></p>
                <p>Ngày Công: <%= cc.getNgayCong() %></p>
                <p>Mã Nhân Viên: <%= cc.getMaNV() %></p>
                <div class="action-buttons">
                    <a href="NNVupdateChamCong.jsp?maCC=<%= cc.getMaCC() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="NNVdeleteChamCong?maCC=<%= cc.getMaCC() %>" class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có dữ liệu chấm công.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
