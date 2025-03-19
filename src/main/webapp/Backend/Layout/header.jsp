<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.NhanVien" %>
<%
    // Lấy thông tin nhân viên từ session
    NhanVien user = (NhanVien) session.getAttribute("user");
%>

<style>
    .header {
        display: flex;
        align-items: center;
        justify-content: space-between;
        background: #f8f9fa;
        padding: 10px 15px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    .header .logo {
        display: flex;
        align-items: center;
        font-size: 20px;
        font-weight: bold;
        color: #333;
    }
    .header .logo img {
        height: 35px;
        margin-right: 8px;
        border-radius: 50%;
        object-fit: cover;
    }
    .header nav {
        display: flex;
        gap: 12px;
    }
    .header nav a {
        text-decoration: none;
        color: #333;
        font-size: 15px;
        font-weight: 500;
        padding: 6px 10px;
        transition: all 0.3s;
    }
    .header nav a:hover {
        color: #007bff;
    }
</style>

<div class="header">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo">
        Quản Lý CoffeLuck
    </div>
    <nav>
        <a href="${pageContext.request.contextPath}/Backend/NNVtrangchu.jsp">Trang Chủ</a>
        <a href="${pageContext.request.contextPath}/Backend/NhanVien/NNVlistNhanVien.jsp">Nhân Viên</a>
        <a href="${pageContext.request.contextPath}/Backend/SanPham/NNVlistSanPham.jsp">Sản Phẩm</a>
        <a href="${pageContext.request.contextPath}/Backend/KhachHang/NNVlistKhachHang.jsp">Khách Hàng</a>
        <a href="${pageContext.request.contextPath}/Backend/NhapHang/NNVlistNhapHang.jsp">Nhập Hàng</a>
<a href="${pageContext.request.contextPath}/Backend/ChiTietNhap/NNVlistChiTietNhap.jsp">Chi Tiết Nhập</a>
        <% if (user != null) { %>
            <a href="#">Chào <%= user.getTen() %>!</a>
            <a href="${pageContext.request.contextPath}/LogoutServlet">Đăng Xuất</a>
        <% } else { %>
            <a href="${pageContext.request.contextPath}/Backend/login.jsp">Đăng Nhập</a>
        <% } %>
    </nav>
</div>
