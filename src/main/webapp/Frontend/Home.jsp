<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.SanPham" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoffeLuck - Thương yêu thiên nhiên</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<!-- Hammer.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/hammer.js/2.0.8/hammer.min.js"></script>
<style>

/* Định kích thước cố định cho carousel */
.carousel-container {
    width: 100%;
    display: flex;
    justify-content: center;
}

/* Định kích thước cụ thể cho khung ảnh */
#carouselExampleIndicators {
    width: 1000px; /* Chiều rộng cố định */
    height: 400px; /* Chiều cao cố định */
}

/* Định kích thước cho ảnh bên trong */
.carousel-inner {
    width: 100%;
    height: 100%;
}

/* Cố định kích thước ảnh */
.carousel-inner img {
    width: 1000px; /* Chiều rộng ảnh */
    height: 400px; /* Chiều cao ảnh */
    object-fit: cover; /* Đảm bảo ảnh không bị méo */
    object-position: center;
}


</style>
</head>
<body>

<%@ include file="Layout2/Header2.jsp" %>

<!-- Carousel -->
<div class="carousel-container">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3500">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${pageContext.request.contextPath}/images/anhbia.jpg" class="d-block w-100" alt="Ảnh bìa 1">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/images/banhbia5.jpg" class="d-block w-100" alt="Ảnh bìa 2">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
        </button>
    </div>
</div>
<!-- Best Seller Section -->
<div class="container mt-5">
    <h2 class="text-center">🔥 Sản phẩm Best Seller 🔥</h2>
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        <% 
        CoffeDAO dao = new CoffeDAO();
        List<SanPham> bestSellerList = dao.getBestSeller();

        if (bestSellerList != null && !bestSellerList.isEmpty()) {
            for (SanPham sp : bestSellerList) {
        %>
            <div class="col">
                <div class="card product-card">
                    <img src="${pageContext.request.contextPath}/images/<%= sp.getAnh() %>" class="product-img" alt="<%= sp.getTenSP() %>">
                    <div class="product-info">
                        <p class="product-name"><%= sp.getTenSP() %></p>
                        <p class="product-price"><%= sp.getDonGia() %> VND</p>
                    </div>
                    <a href="muaSanPham?maSP=<%= sp.getMaSP() %>" class="buy-button"> 🛒 Đặt Mua</a>
                </div>
            </div>
        <% 
            }
        } else { 
        %>
            <p class="text-center text-danger">Không có sản phẩm Best Seller nào để hiển thị.</p>
        <% 
        } 
        %>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<!-- Import Hammer.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/hammer.js/2.0.8/hammer.min.js"></script>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        var myCarousel = document.querySelector("#carouselExampleIndicators");
        var carousel = new bootstrap.Carousel(myCarousel, {
            interval: 1200,
            ride: "carousel"
        });

        // Kích hoạt tính năng kéo để trượt ảnh bằng Hammer.js
        var hammer = new Hammer(myCarousel);
        hammer.on("swipeleft", function () {
            carousel.next();
        });
        hammer.on("swiperight", function () {
            carousel.prev();
        });
    });
</script>

<%@ include file="Layout2/Footer2.jsp" %>

</body>
</html>
