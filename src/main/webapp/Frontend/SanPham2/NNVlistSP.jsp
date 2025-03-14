<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CoffeDAO" %>
<%@ page import="model.SanPham" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sản Phẩm</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    
    <!-- File CSS tùy chỉnh -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Frontend/css/sanpham.css">
</head>
<body>

    <%@ include file="../Layout2/NNVHeader2.jsp" %>

    <div class="container my-4">
        <!-- Breadcrumb -->
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/Frontend/NNVHome.jsp">Trang chủ</a></li>
                <li class="breadcrumb-item active" aria-current="page">Sản phẩm</li>
            </ol>
        </nav>

        <div class="row">
            <!-- Sidebar: Cột danh mục bên trái -->
            <div class="col-md-3 mb-4">
                <ul class="list-group sidebar-menu">
                    <li class="list-group-item active">
                        <a href="#" id="allProductsLink">Tất cả</a>
                    </li>
                    <li class="list-group-item">
                        <a href="#" id="bestSellerLink">Best Seller</a>
                    </li>
                    <li class="list-group-item">
                        <a href="#" id="category1Link">Cà Phê</a>
                    </li>
                    <li class="list-group-item">
                        <a href="#" id="category2Link">Nước Ép</a>
                    </li>
                    <li class="list-group-item">
                        <a href="#" id="category3Link">Bánh</a>
                    </li>
                    <li class="list-group-item">
                        <a href="#" id="category4Link">Đồ Ăn Vặt</a>
                    </li>
                </ul>
            </div>

            <!-- Nội dung sản phẩm bên phải -->
            <div class="col-md-9">
                <!-- Khối sản phẩm Tất cả -->
                <div id="allProducts">
                    <h2 class="text-center small-title">Tất Cả Các Sản Phẩm</h2>
                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 product-row">
                        <%
                            CoffeDAO dao = new CoffeDAO();
                            List<SanPham> sanPhamList = dao.getAllSanPham();
                            if (sanPhamList != null && !sanPhamList.isEmpty()) {
                                for (SanPham sp : sanPhamList) {
                        %>
                        <div class="col">
                            <div class="card product-card">
                                <img src="${pageContext.request.contextPath}/images/<%= sp.getAnh() %>" 
                                     class="product-img" 
                                     alt="<%= sp.getTenSP() %>">
                                <div class="product-info p-2">
                                    <p class="product-name fw-bold"><%= sp.getTenSP() %></p>
                                    <p class="product-price text-danger"><%= sp.getDonGia() %> VND</p>
                                </div>
                                <a href="muaSanPham?maSP=<%= sp.getMaSP() %>" class="buy-button">
                                    🛒 Đặt Mua
                                </a>
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
			               
                <!-- Khối sản phẩm Best Seller -->
                <div id="bestSellers" style="display: none;">
                    <h2 class="text-center small-title">Best Seller - Sản Phẩm Được Yêu Thích</h2>
                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 product-row">
                        <%
                            CoffeDAO dao2 = new CoffeDAO();
                            List<SanPham> bestSellers = dao2.getBestSellersByPrice();
                            if (bestSellers != null && !bestSellers.isEmpty()) {
                                for (SanPham sp : bestSellers) {
                        %>
                        <div class="col">
                            <div class="card product-card">
                                <img src="${pageContext.request.contextPath}/images/<%= sp.getAnh() %>" 
                                     class="product-img" alt="<%= sp.getTenSP() %>">
                                <div class="product-info p-2">
                                    <p class="product-name"><%= sp.getTenSP() %></p>
                                    <p class="product-price"><%= sp.getDonGia() %> VND</p>
                                </div>
                                <a href="muaSanPham?maSP=<%= sp.getMaSP() %>" class="buy-button">
                                    🛒 Đặt Mua
                                </a>
                            </div>
                        </div>
                        <%
                                }
                            } else {
                        %>
                        <p class="text-center text-danger">
                            Không có sản phẩm Best Seller nào để hiển thị.
                        </p>
                        <%
                            }
                        %>
                    </div>
                </div>
                
                <!-- Khối sản phẩm thuộc mã nhóm 1 (Cà Phê) -->
                <div id="category1Products" style="display: none;">
                    <h2 class="text-center small-title">Cà Phê</h2>
                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 product-row">
                        <%
                            CoffeDAO dao3 = new CoffeDAO();
                            List<SanPham> products = dao3.getSanPhamByMaNhom("1");
                            if (products != null && !products.isEmpty()) {
                                for (SanPham sp : products) {
                        %>
                        <div class="col">
                            <div class="card product-card">
                                <img src="${pageContext.request.contextPath}/images/<%= sp.getAnh() %>" 
                                     class="product-img" alt="<%= sp.getTenSP() %>">
                                <div class="product-info p-2">
                                    <p class="product-name"><%= sp.getTenSP() %></p>
                                    <p class="product-price"><%= sp.getDonGia() %> VND</p>
                                </div>
                                <a href="muaSanPham?maSP=<%= sp.getMaSP() %>" class="buy-button">
                                    🛒 Đặt Mua
                                </a>
                            </div>
                        </div>
                        <%
                                }
                            } else {
                        %>
                        <p class="text-center text-danger">Không có sản phẩm nào thuộc danh mục này.</p>
                        <%
                            }
                        %>
                    </div>
                </div>
                
                <!-- Khối sản phẩm thuộc mã nhóm 2 (Nước Ép) -->
                <div id="category2Products" style="display: none;">
                    <h2 class="text-center small-title">Nước Ép</h2>
                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 product-row">
                        <%
                            CoffeDAO dao4 = new CoffeDAO();
                            List<SanPham> products2 = dao4.getSanPhamByMaNhom("2");
                            if (products2 != null && !products2.isEmpty()) {
                                for (SanPham sp : products2) {
                        %>
                        <div class="col">
                            <div class="card product-card">
                                <img src="${pageContext.request.contextPath}/images/<%= sp.getAnh() %>" 
                                     class="product-img" alt="<%= sp.getTenSP() %>">
                                <div class="product-info p-2">
                                    <p class="product-name"><%= sp.getTenSP() %></p>
                                    <p class="product-price"><%= sp.getDonGia() %> VND</p>
                                </div>
                                <a href="muaSanPham?maSP=<%= sp.getMaSP() %>" class="buy-button">
                                    🛒 Đặt Mua
                                </a>
                            </div>
                        </div>
                        <%
                                }
                            } else {
                        %>
                        <p class="text-center text-danger">Không có sản phẩm nào thuộc danh mục này.</p>
                        <%
                            }
                        %>
                    </div>
                </div>
                
                <!-- Khối sản phẩm thuộc mã nhóm 3 (Bánh) -->
                <div id="category3Products" style="display: none;">
                    <h2 class="text-center small-title">Bánh</h2>
                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 product-row">
                        <%
                            CoffeDAO dao5 = new CoffeDAO();
                            List<SanPham> products3 = dao5.getSanPhamByMaNhom("3");
                            if (products3 != null && !products3.isEmpty()) {
                                for (SanPham sp : products3) {
                        %>
                        <div class="col">
                            <div class="card product-card">
                                <img src="${pageContext.request.contextPath}/images/<%= sp.getAnh() %>" 
                                     class="product-img" alt="<%= sp.getTenSP() %>">
                                <div class="product-info p-2">
                                    <p class="product-name"><%= sp.getTenSP() %></p>
                                    <p class="product-price"><%= sp.getDonGia() %> VND</p>
                                </div>
                                <a href="muaSanPham?maSP=<%= sp.getMaSP() %>" class="buy-button">
                                    🛒 Đặt Mua
                                </a>
                            </div>
                        </div>
                        <%
                                }
                            } else {
                        %>
                        <p class="text-center text-danger">Không có sản phẩm nào thuộc danh mục này.</p>
                        <%
                            }
                        %>
                    </div>
                </div>
                
                <!-- Khối sản phẩm thuộc mã nhóm 4 (Đồ Ăn Vặt) -->
                <div id="category4Products" style="display: none;">
                    <h2 class="text-center small-title">Đồ Ăn Vặt</h2>
                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 product-row">
                        <%
                            CoffeDAO dao6 = new CoffeDAO();
                            List<SanPham> products4 = dao6.getSanPhamByMaNhom("4");
                            if (products4 != null && !products4.isEmpty()) {
                                for (SanPham sp : products4) {
                        %>
                        <div class="col">
                            <div class="card product-card">
                                <img src="${pageContext.request.contextPath}/images/<%= sp.getAnh() %>" 
                                     class="product-img" alt="<%= sp.getTenSP() %>">
                                <div class="product-info p-2">
                                    <p class="product-name"><%= sp.getTenSP() %></p>
                                    <p class="product-price"><%= sp.getDonGia() %> VND</p>
                                </div>
                                <a href="muaSanPham?maSP=<%= sp.getMaSP() %>" class="buy-button">
                                    🛒 Đặt Mua
                                </a>
                            </div>
                        </div>
                        <%
                                }
                            } else {
                        %>
                        <p class="text-center text-danger">Không có sản phẩm nào thuộc danh mục này.</p>
                        <%
                            }
                        %>
                    </div>
                </div>
                
            </div>
        </div>
    </div>

    <script>
        document.getElementById("allProductsLink").addEventListener("click", function(e) {
            e.preventDefault();
            document.getElementById("allProducts").style.display = "block";
            document.getElementById("bestSellers").style.display = "none";
            document.getElementById("category1Products").style.display = "none";
            document.getElementById("category2Products").style.display = "none";
            document.getElementById("category3Products").style.display = "none";
            document.getElementById("category4Products").style.display = "none";
        });
        
        document.getElementById("bestSellerLink").addEventListener("click", function(e) {
            e.preventDefault();
            document.getElementById("allProducts").style.display = "none";
            document.getElementById("bestSellers").style.display = "block";
            document.getElementById("category1Products").style.display = "none";
            document.getElementById("category2Products").style.display = "none";
            document.getElementById("category3Products").style.display = "none";
            document.getElementById("category4Products").style.display = "none";
        });
        
        document.getElementById("category1Link").addEventListener("click", function(e) {
            e.preventDefault();
            document.getElementById("allProducts").style.display = "none";
            document.getElementById("bestSellers").style.display = "none";
            document.getElementById("category1Products").style.display = "block";
            document.getElementById("category2Products").style.display = "none";
            document.getElementById("category3Products").style.display = "none";
            document.getElementById("category4Products").style.display = "none";
        });
        
        document.getElementById("category2Link").addEventListener("click", function(e) {
            e.preventDefault();
            document.getElementById("allProducts").style.display = "none";
            document.getElementById("bestSellers").style.display = "none";
            document.getElementById("category1Products").style.display = "none";
            document.getElementById("category2Products").style.display = "block";
            document.getElementById("category3Products").style.display = "none";
            document.getElementById("category4Products").style.display = "none";
        });
        
        document.getElementById("category3Link").addEventListener("click", function(e) {
            e.preventDefault();
            document.getElementById("allProducts").style.display = "none";
            document.getElementById("bestSellers").style.display = "none";
            document.getElementById("category1Products").style.display = "none";
            document.getElementById("category2Products").style.display = "none";
            document.getElementById("category3Products").style.display = "block";
            document.getElementById("category4Products").style.display = "none";
        });
        
        document.getElementById("category4Link").addEventListener("click", function(e) {
            e.preventDefault();
            document.getElementById("allProducts").style.display = "none";
            document.getElementById("bestSellers").style.display = "none";
            document.getElementById("category1Products").style.display = "none";
            document.getElementById("category2Products").style.display = "none";
            document.getElementById("category3Products").style.display = "none";
            document.getElementById("category4Products").style.display = "block";
        });
    </script>

    <%@ include file="../Layout2/NNVFooter2.jsp" %>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
