<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.NNVLoaiPhieuDAO" %>
<%@ page import="model.LoaiPhieu" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Loại Phiếu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/listsp.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section>
    <div class="top-buttons">
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp" class="btn">🏠 Về Trang Chủ</a>
        <a href="NNVaddLoaiPhieu.jsp" class="btn">➕ Thêm Loại Phiếu</a>
    </div>

    <h2 style="text-align: center;">Danh Sách Loại Phiếu</h2>

    <div class="cards-container">
        <% 
        NNVLoaiPhieuDAO dao = new NNVLoaiPhieuDAO();
        List<LoaiPhieu> loaiPhieuList = dao.getAllLoaiPhieu();

        if (loaiPhieuList != null && !loaiPhieuList.isEmpty()) {
            for (LoaiPhieu lp : loaiPhieuList) {
        %>
            <div class="card">
                <p>Mã Loại Phiếu: <%= lp.getMaLP() %></p>
                <p>Tên Loại Phiếu: <%= lp.getTenLP() %></p>
                <div class="action-buttons">
                    <a href="NNVupdateLoaiPhieu.jsp?maLP=<%= lp.getMaLP() %>" class="edit-btn">✏️ Sửa</a>
                    <a href="<%= request.getContextPath() %>/Backend/LoaiPhieu/NNVdeleteLoaiPhieu?maLP=<%= lp.getMaLP() %>" 
   						class="delete-btn" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">🗑️ Xóa</a>

                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p style="text-align: center;">Không có dữ liệu loại phiếu.</p>
        <% 
        } 
        %>
    </div>
</section>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
