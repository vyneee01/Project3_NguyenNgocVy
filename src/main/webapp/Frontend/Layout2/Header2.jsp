<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
    /* Đổi màu chữ thành đen để dễ nhìn trên nền trắng */
.navbar .nav-link {
    color: #333 !important;
    font-weight: bold;
}

/* Khi hover, đổi màu chữ */
.navbar .nav-link:hover {
    color: #d9230f !important; /* Màu đỏ khi di chuột vào */
}

/* Logo lớn hơn */
.navbar-brand img {
    border-radius: 50%; /* Bo tròn */
    width: 50px; /* Kích thước lớn hơn */
    height: 50px;
    object-fit: cover; /* Cắt hình ảnh vừa khung tròn */
    border: 2px solid #ddd; /* Thêm viền nhẹ */
    margin-right: 30px; /* Tạo khoảng cách giữa logo và thanh tìm kiếm */
}

/* Thanh tìm kiếm dài hơn */
form.d-flex {
    flex-grow: 1; /* Mở rộng tối đa trong container */
    max-width: 500px; /* Giữ chiều rộng hợp lý */
}

    
    </style>
</head>
<body>
    <header class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container d-flex align-items-center justify-content-between">
        <!-- Logo lớn hơn -->
        <a class="navbar-brand me-3" href="${pageContext.request.contextPath}/Frontend/Home.jsp">
            <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo" width="80" height="80">
        </a>

        <!-- Thanh tìm kiếm gần hơn -->
        <form class="d-flex me-auto w-40" action="timkiem.jsp" method="GET">
            <input class="form-control me-2" type="search" name="query" placeholder="Tìm kiếm" aria-label="Search">
            <button class="btn btn-outline-danger" type="submit">
                <i class="fas fa-search"></i>
            </button>
        </form>

        <!-- Giỏ hàng và Hotline -->
        <div class="d-flex align-items-center">
            <a href="tel:0123456789" class="text-danger fw-bold me-3">
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
            <ul class="navbar-nav w-100 d-flex justify-content-around"> <%-- Chia đều menu --%>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/Frontend/Home.jsp">
                        <i class="fas fa-home"></i> Trang chủ
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/Frontend/gioithieu.jsp">Về chúng tôi</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="sanPhamDropdown" role="button" data-bs-toggle="dropdown">
                        Menu
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Frontend/SanPham2/listSP.jsp">Tất cả sản phẩm</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/sanpham.jsp?loai=caphe">Cà phê</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/sanpham.jsp?loai=tratai">Trà & Tại</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="alert('Chức năng đang bảo trì!'); return false;">Khuyến mãi</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="alert('Chức năng đang bảo trì!'); return false;">Hội viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="alert('Chức năng đang bảo trì!'); return false;">Liên hệ</a>
                </li>
            </ul>
        </div>
    </div>
</nav>



    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
