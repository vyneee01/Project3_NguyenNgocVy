<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVLoaiPhieuDAO" %>
<%@ page import="model.LoaiPhieu" %>

<%
    int maLP = Integer.parseInt(request.getParameter("maLP"));
    NNVLoaiPhieuDAO dao = new NNVLoaiPhieuDAO();
    LoaiPhieu loaiPhieu = dao.getLoaiPhieuByMaLP(maLP);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Loại Phiếu</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/LoaiPhieu/NNVupdateLoaiPhieu" method="post">
        <h2>Cập Nhật Loại Phiếu</h2>

        <input type="hidden" name="maLP" value="<%= loaiPhieu.getMaLP() %>">

        <label for="tenLP">Tên Loại Phiếu:</label>
        <input type="text" name="tenLP" value="<%= loaiPhieu.getTenLP() %>" required>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/LoaiPhieu/NNVlistLoaiPhieu.jsp" class="back-link">Về Trang Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
