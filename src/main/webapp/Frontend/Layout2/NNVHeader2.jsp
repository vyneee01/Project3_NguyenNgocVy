<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="model.NNVKhachHang" %>
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

		<form class="d-flex me-auto flex-grow-1 align-items-center" action="timkiem.jsp" method="GET" 
		      style="max-width: 400px; height: 36px;">
		    <input class="form-control me-2" type="search" name="query" placeholder="Tìm kiếm" 
		           aria-label="Search" 
		           style="height: 100%; font-size: 14px; border-radius: 20px; padding-left: 15px;">
		    <button class="btn btn-outline-danger d-flex align-items-center justify-content-center" type="submit" 
		            style="font-size: 14px; width: 36px; height: 36px; border-radius: 50%; display: flex;">
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
           
            <%
			    NNVKhachHang khachHang = (NNVKhachHang) session.getAttribute("khachHang");
			    if (khachHang != null) {
			%>
			    <a href="NNVHoiVien.jsp" class="btn btn-outline-dark">Chào <%= khachHang.getHoTen() %></a>
			<%
			    } else {
			%>
			    <a href="NNVHoiVien.jsp" class="btn btn-outline-dark">Đăng nhập</a>
			<%
			    }
			%>

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
                    <a class="nav-link" href="${pageContext.request.contextPath}/Frontend/NNVHoiVien.jsp">Hội viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Frontend/NNVQuaTang.jsp"  >Quà Tặng</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
