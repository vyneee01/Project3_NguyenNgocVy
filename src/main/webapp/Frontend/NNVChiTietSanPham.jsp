<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="DAO.NNvSanPhamDAO, model.SanPham" %>
<%@ page import="java.util.Optional" %>

<%
    String maSP = request.getParameter("maSP");
    NNvSanPhamDAO spDAO = new NNvSanPhamDAO();
    SanPham sp = (maSP != null) ? spDAO.getSanPhamById(Integer.parseInt(maSP)) : null;
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi Tiết Sản Phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 800px;
            margin-top: 50px;
        }
        .product-image {
            width: 100%;
            height: auto;
            max-height: 400px;
            object-fit: cover;
            border-radius: 10px;
        }
        .product-name {
            font-size: 24px;
            font-weight: bold;
        }
        .product-price {
            font-size: 20px;
            color: red;
        }
    </style>
</head>
<body>
  <%@ include file="Layout2/NNVHeader2.jsp" %>
<div class="container text-center">
    <% if (sp != null) { %>
        <h2 class="mb-4">Chi Tiết Sản Phẩm</h2>
        <img src="<%= sp.getAnh() %>" alt="Ảnh sản phẩm" class="product-image mb-3">
        <h3 class="product-name"><%= sp.getTenSP() %></h3>
        <p class="product-price">Giá: <%= String.format("%,.0f", sp.getDonGia()) %> VNĐ</p>
        <p>Đơn vị tính: <%= sp.getDvt() %></p>

        <!-- Nút đặt mua -->
        <a href="muaSanPham?maSP=<%= sp.getMaSP() %>" class="btn btn-primary">
            🛒 Đặt Mua
        </a>

        <!-- Nút quay lại menu -->
        <a href="SanPham2/NNVlistSP.jsp" class="btn btn-secondary mt-3">🔙 Quay lại Menu</a>
    <% } else { %>
        <h3 class="text-danger">Không tìm thấy sản phẩm!</h3>
        <a href="SanPham2/NNVlistSP.jsp" class="btn btn-secondary mt-3">🔙 Quay lại Menu</a>
    <% } %>
</div>
    <%@ include file="Layout2/NNVFooter2.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
