<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.NNVNCCDAO" %>
<%@ page import="model.NhaCungCap" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Nhà Cung Cấp</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nhapdulieu.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

<%
    int maNCC = Integer.parseInt(request.getParameter("maNCC"));
    NNVNCCDAO nccDao = new NNVNCCDAO();
    NhaCungCap ncc = nccDao.getNhaCungCapById(maNCC);
%>

<section class="form-container">
    <form class="form" action="NNVupdateNCC" method="post">
        <h2>Cập Nhật Nhà Cung Cấp</h2>
        <input type="hidden" name="maNCC" value="<%= ncc.getMaNCC() %>">
        
        <label for="tenNCC">Tên Nhà Cung Cấp:</label>
        <input type="text" name="tenNCC" value="<%= ncc.getTenNCC() %>" required>
        
        <label for="sdt">Số Điện Thoại:</label>
        <input type="text" name="sdt" value="<%= ncc.getSdt() %>" required>
        
        <label for="diaChi">Địa Chỉ:</label>
        <input type="text" name="diaChi" value="<%= ncc.getDiaChi() %>" required>
        
        <label for="congNo">Công Nợ:</label>
        <input type="number" step="0.01" name="congNo" value="<%= ncc.getCongNo() %>" required>
        
        <label for="ghiChu">Ghi Chú:</label>
        <input type="text" name="ghiChu" value="<%= ncc.getGhiChu() %>">
        
        <button type="submit">Cập Nhật</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/Backend/NhaCungCap/NNClistNCC.jsp" class="back-link">Về Danh Sách</a>

<%@ include file="../Layout/footer.jsp" %>
</body>
</html>
