<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVChamCongDAO" %>
<%@ page import="model.ChamCong" %>

<%
    int maCC = Integer.parseInt(request.getParameter("maCC"));
    NNVChamCongDAO dao = new NNVChamCongDAO();
    ChamCong chamCong = dao.getChamCongById(maCC);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Chấm Công</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/ChamCong/NNVupdateChamCong" method="post">
        <h2>Cập Nhật Chấm Công</h2>

        <input type="hidden" name="maCC" value="<%= chamCong.getMaCC() %>">

        <label for="ngayCong">Ngày Công:</label>
        <input type="datetime-local" name="ngayCong" value="<%= chamCong.getNgayCong() %>" required>

        <label for="maNV">Mã Nhân Viên:</label>
        <input type="text" name="maNV" value="<%= chamCong.getMaNV() %>" required>

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/ChamCong/NNVlistChamCong.jsp" class="back-link">Về Trang Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
