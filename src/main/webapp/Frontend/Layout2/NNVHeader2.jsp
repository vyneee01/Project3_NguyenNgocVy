<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Frontend/css/header.css">
   
</head>
<body>
    <header class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container d-flex align-items-center justify-content-between">
        <!-- Logo nhỏ hơn -->
        <a class="navbar-brand me-3" href="${pageContext.request.contextPath}/Frontend/NNVHome.jsp">
            <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo" width="60" height="60">
        </a>

		<!-- Thanh tìm kiếm dài hơn, thu nhỏ chiều rộng -->
		<form class="d-flex me-auto w-40" action="timkiem.jsp" method="GET">
		    <input class="form-control me-2" type="search" name="query" placeholder="Tìm kiếm" aria-label="Search">
		    <button class="btn btn-outline-danger" type="submit" style="font-size: 12px; padding: 3px 8px;">
		        <i class="fa-solid fa-magnifying-glass"></i>
		    </button>
		</form>

        <!-- Giỏ hàng và Hotline -->
        <div class="d-flex align-items-center">
            <a href="tel:0123456789" class="hotline fw-bold me-3">
                <i class="fas fa-phone-alt"></i> Hotline: 0358072868
            </a>
            <a href="${pageContext.request.contextPath}/giohang.jsp" class="btn btn-outline-dark">
                <i class="fas fa-shopping-cart"></i> Giỏ hàng
            </a>
        </div>
    </div>
</header>

    <!-- Menu điều hướng -->
<nav class="navbar navbar-expand-lg bg-white">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between" id="navbarNav">
            <ul class="navbar-nav w-100 d-flex justify-content-around">
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/Frontend/NNVHome.jsp">
                        <i class="fas fa-home"></i> Trang chủ
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Frontend/NNVgioithieu.jsp">Về chúng tôi</a>
                </li>
                <li class="nav-item">
                	<a class="nav-link" href="${pageContext.request.contextPath}/Frontend/SanPham2/NNVlistSP.jsp" >Menu	</a>
                 
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Frontend/NNVkhuyenMai.jsp" >Khuyến mãi</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="alert('Chức năng đang bảo trì!'); return false;">Hội viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="alert('Chức năng đang bảo trì!'); return false;">Quà Tặng</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
