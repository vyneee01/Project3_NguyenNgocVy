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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Frontend/css/trangchu.css">

</head>
<body>
 <%@ include file="Layout2/NNVHeader2.jsp" %>
<!-- Carousel -->
<div class="carousel-container">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3500">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${pageContext.request.contextPath}/images/anhbia100.jpg" class="d-block w-100" alt="Ảnh bìa 1">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/images/anhbia110.jpg" class="d-block w-100" alt="Ảnh bìa 2">
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



<!-- Phần Giới thiệu "Về Chúng Tôi" -->
<section class="about-us">
    <div class="container">
        <h2>Về Chúng Tôi</h2>
        <p>CoffeLuck cam kết mang đến trải nghiệm thưởng thức cà phê đích thực với chất lượng tốt nhất, nguồn gốc tự nhiên và phong cách thân thiện.</p>
        <a href="NNVgioithieu.jsp" class="btn btn-primary">Tìm hiểu thêm</a>
    </div>
</section>

<!-- Phần Tính Năng Nổi Bật -->
<section class="features">
    <div class="container">
        <div class="row">
            <div class="col-md-4 feature-item">
                <i class="fas fa-shipping-fast"></i>
                <h5>Giao Hàng Nhanh Chóng</h5>
                <p>Chúng tôi đảm bảo giao hàng đến tay bạn trong thời gian ngắn nhất.</p>
            </div>
            <div class="col-md-4 feature-item">
                <i class="fas fa-lock"></i>
                <h5>Bảo Mật Thanh Toán</h5>
                <p>Thanh toán an toàn và bảo mật với các phương thức hiện đại.</p>
            </div>
            <div class="col-md-4 feature-item">
                <i class="fas fa-headset"></i>
                <h5>Hỗ Trợ 24/7</h5>
                <p>Đội ngũ hỗ trợ luôn sẵn sàng giải đáp mọi thắc mắc của bạn.</p>
            </div>
        </div>
    </div>
</section>

<!-- Phần Đăng Ký Nhận Tin -->
<section class="newsletter">
    <div class="container">
        <h4>Đăng Ký Nhận Tin</h4>
        <p>Nhận thông tin khuyến mãi và ưu đãi đặc biệt từ CoffeLuck.</p>
        <form action="dangKyNhanTin" method="post" class="d-flex justify-content-center">
            <input type="email" name="email" class="form-control me-2" placeholder="Email của bạn" required style="max-width: 300px;">
            <button type="submit" class="btn btn-danger">Đăng Ký</button>
        </form>
    </div>
</section>

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
<%@ include file="Layout2/NNVFooter2.jsp" %>
</body>
</html>
