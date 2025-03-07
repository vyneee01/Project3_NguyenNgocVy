<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.SanPham" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sản Phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
  /* Bố cục danh sách sản phẩm */
.product-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between; /* Căn đều các sản phẩm */
    gap: 30px; /* Khoảng cách giữa các sản phẩm */
}

/* Card sản phẩm */
.product-card {
    width: 100%;
    max-width: 250px; /* Định kích thước tối đa */
    text-align: center;
    background: #fff;
    border-radius: 12px;
    padding: 10px 0;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
}

/* Ảnh sản phẩm */
.product-img {
    width: 100%;
    height: 250px;
    object-fit: cover;
    border-radius: 12px;
}
/* Nút "Bấm để mua ngay" */
.buy-button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #A52A2A; /* Màu đỏ đậm */
    color: white;
    text-decoration: none;
    font-weight: bold;
    border-radius: 20px;
    margin-top: 10px;
    transition: 0.3s;
}

.buy-button:hover {
    background-color: #8B0000;
    transform: scale(1.05);
}
    </style>
</head>
<body>

<%@ include file="../Layout2/Header2.jsp" %>

<div class="container">
    <h2 class="text-center">☕ Danh Sách Sản Phẩm ☕</h2>
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        <% 
        CoffeDAO dao = new CoffeDAO();
        List<SanPham> sanPhamList = dao.getAllSanPham();

        if (sanPhamList != null && !sanPhamList.isEmpty()) {
            for (SanPham sp : sanPhamList) {
        %>
            <div class="col">
                <div class="card product-card">
                    <img src="${pageContext.request.contextPath}/images/<%= sp.getAnh() %>" class="product-img" alt="<%= sp.getTenSP() %>">
                    <div class="product-info">
                        <p class="product-name"><%= sp.getTenSP() %></p>
                        <p class="product-price"><%= sp.getDonGia() %> VND</p>
                    </div>
                    <a href="muaSanPham?maSP=<%= sp.getMaSP() %>" class="buy-button"> 🛒Đặt Mua</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p class="text-center text-danger">Không có sản phẩm nào để hiển thị.</p>
        <% 
        } 
        %>
    </div>
</div>


<%@ include file="../Layout2/Footer2.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
