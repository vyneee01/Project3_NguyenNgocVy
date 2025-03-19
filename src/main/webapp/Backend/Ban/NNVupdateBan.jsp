<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVBanDAO" %>
<%@ page import="model.Ban" %>

<%
    int maBan = Integer.parseInt(request.getParameter("maBan"));
    NNVBanDAO dao = new NNVBanDAO();
    Ban ban = dao.getBanByMaBan(maBan);
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Bàn</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>

<%@ include file="../Layout/header.jsp" %>

<section class="form-container">
    <form class="form" action="${pageContext.request.contextPath}/Backend/Ban/NNVupdateBan" method="post">
        <h2>Cập Nhật Bàn</h2>

        <input type="hidden" name="maBan" value="<%= ban.getMaBan() %>">

        <label for="maKV">Mã Khu Vực:</label>
        <input type="text" name="maKV" value="<%= ban.getMaKV() %>" required>

        <label for="trangThai">Trạng Thái:</label>
        <input type="checkbox" id="trangThai" name="trangThai" <%= ban.isTrangThai() ? "checked" : "" %>> Hoạt động

        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/Ban/NNVlistBan.jsp" class="back-link">Về Trang Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
