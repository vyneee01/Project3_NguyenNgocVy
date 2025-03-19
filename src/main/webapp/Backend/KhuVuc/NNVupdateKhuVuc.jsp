<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVKhuVucDAO" %>
<%@ page import="model.KhuVuc" %>

<%
    int maKV = Integer.parseInt(request.getParameter("maKV"));
    NNVKhuVucDAO dao = new NNVKhuVucDAO();
    KhuVuc khuVuc = dao.getKhuVucByMaKV(maKV);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Khu Vực</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/KhuVuc/NNVupdateKhuVuc" method="post">
        <h2>Cập Nhật Khu Vực</h2>

        <input type="hidden" name="maKV" value="<%= khuVuc.getMaKV() %>">

        <label for="tenKV">Tên Khu Vực:</label>
        <input type="text" name="tenKV" value="<%= khuVuc.getTenKV() %>" required>

        <label for="trangThai">Trạng Thái:</label>
        <input type="checkbox" name="trangThai" <%= khuVuc.isTrangThai() ? "checked" : "" %>> Hoạt động

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/KhuVuc/NNVlistKhuVuc.jsp" class="back-link">Về Trang Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
