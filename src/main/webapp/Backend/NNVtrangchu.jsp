<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    if (session == null || session.getAttribute("user") == null) {
        // Nếu session không tồn tại hoặc không có thông tin người dùng
        response.sendRedirect(request.getContextPath() + "/Backend/login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ - Quản Lý Quán Cà Phê</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/trangchu.css">
</head>
<body>
    <%@ include file="Layout/header.jsp" %>

    <section class="dashboard">
        <h2 style="text-align: center;">Hệ Thống Quản Lý Quán Cà Phê</h2>
        
        <div class="cards-container">
            <a href="${pageContext.request.contextPath}/Backend/NhomSanPham/NNVlistNhomSanPham.jsp" class="card">
                <img src="${pageContext.request.contextPath}/images/nhomsp.jpg" alt="Nhóm Sản Phẩm">
                <h3>Nhóm Sản Phẩm</h3>
                <p>Quản lý danh sách nhóm sản phẩm.</p>
            </a>

            <a href="${pageContext.request.contextPath}/Backend/PhanQuyen/NNVlistPhanQuyen.jsp" class="card">
                <img src="${pageContext.request.contextPath}/images/phanquyen.jpg" alt="Phân Quyền">
                <h3>Phân Quyền</h3>
                <p>Quản lý quyền hạn của nhân viên.</p>
            </a>

            <a href="${pageContext.request.contextPath}/Backend/NhaCungCap/NNVlistNCC.jsp" class="card">
                <img src="${pageContext.request.contextPath}/images/nhacungcap.jpg" alt="Nhà Cung Cấp">
                <h3>Nhà Cung Cấp</h3>
                <p>Quản lý danh sách nhà cung cấp.</p>
            </a>

            <a href="${pageContext.request.contextPath}/Backend/NguyenLieu/NNVlistNguyenLieu.jsp" class="card">
                <img src="${pageContext.request.contextPath}/images/nguyenlieu.jpg" alt="Nguyên Liệu">
                <h3>Nguyên Liệu</h3>
                <p>Quản lý nguyên liệu phục vụ chế biến.</p>
            </a>

            <a href="${pageContext.request.contextPath}/Backend/LoaiPhieu/NNVlistLoaiPhieu.jsp" class="card">
                <img src="${pageContext.request.contextPath}/images/loaiphieu.jpg" alt="Loại Phiếu">
                <h3>Loại Phiếu</h3>
                <p>Quản lý các loại phiếu nhập/xuất kho.</p>
            </a>

            <a href="${pageContext.request.contextPath}/Backend/KhuVuc/NNVlistKhuVuc.jsp" class="card">
                <img src="${pageContext.request.contextPath}/images/khuvuc.jpg" alt="Khu Vực">
                <h3>Khu Vực</h3>
                <p>Quản lý các khu vực trong quán.</p>
            </a>

            <a href="${pageContext.request.contextPath}/Backend/ChamCong/NNVlistChamCong.jsp" class="card">
                <img src="${pageContext.request.contextPath}/images/chamcong.jpg" alt="Chấm Công">
                <h3>Chấm Công</h3>
                <p>Quản lý chấm công nhân viên.</p>
            </a>

            <a href="${pageContext.request.contextPath}/Backend/Ban/NNVlistBan.jsp" class="card">
                <img src="${pageContext.request.contextPath}/images/ban.jpg" alt="Bàn">
                <h3>Bàn</h3>
                <p>Quản lý danh sách bàn trong quán.</p>
            </a>
        </div>
    </section>

    <%@ include file="Layout/footer.jsp" %>
</body>
</html>