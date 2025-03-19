<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="model.NNVKhachHang" %> 
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hội Viên - Ưu Đãi Đặc Biệt</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Frontend/css/hoivien.css">
    
</head>
<body>

    <%@ include file="Layout2/NNVHeader2.jsp" %>

    <div class="container mt-5">
        <%
            // Lấy thông tin hội viên từ session
        
            if (khachHang == null) {
        %>
        <!-- Hiển thị phần giới thiệu hội viên nếu chưa đăng nhập -->
        <h2 class="text-center text-primary">Trở Thành Hội Viên Ngay Hôm Nay!</h2>
        <p class="text-center">Nhận ngay hàng loạt ưu đãi độc quyền khi đăng ký hội viên.</p>

        <div class="row">
            <div class="col-md-6">
                <h4 class="text-success"><i class="fa-solid fa-gift"></i> Lợi Ích Khi Là Hội Viên</h4>
                <ul>
                    <li>Nhận <b>voucher giảm giá</b> đến 50% mỗi tháng.</li>
                    <li>Ưu đãi đặc biệt cho thành viên VIP.</li>
                    <li>Hưởng chính sách đổi trả linh hoạt hơn.</li>
                    <li>Tham gia các sự kiện độc quyền dành cho hội viên.</li>
                    <li>Tích điểm đổi quà cực hấp dẫn.</li>
                </ul>
            </div>

            <div class="col-md-6">
                <h4 class="text-info"><i class="fa-solid fa-user"></i> Đăng Nhập Hội Viên</h4>

                <% String error = (String) request.getAttribute("error"); %>
                <% if (error != null) { %>
                    <div class="alert alert-danger"><%= error %></div>
                <% } %>

                <form action="${pageContext.request.contextPath}/DangNhapServlet" method="POST">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Mật khẩu:</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Đăng Nhập</button>
                    <p class="mt-2 text-center">Chưa có tài khoản? <a href="dangky.jsp">Đăng ký ngay</a></p>
                </form>
            </div>
        </div>
        <%
            } else {
        %>

        <!-- Hiển thị thông tin hội viên khi đã đăng nhập -->
        <div class="d-flex justify-content-center">
            <div class="col-md-6 card shadow-lg p-4 text-center">
                <h3 class="text-info"><i class="fa-solid fa-user"></i> Thông Tin Hội Viên</h3>
                <p><b>Họ tên:</b> <%= khachHang.getHoTen() %></p>
                <p><b>Email:</b> <%= khachHang.getEmail() %></p>
                <p><b>Số điện thoại:</b> <%= khachHang.getSoDienThoai() %></p>
                <p><b>Ngày đăng ký:</b> <%= khachHang.getNgayDangKy() %></p>
                <a href="${pageContext.request.contextPath}/DangXuatServlet" class="btn btn-danger w-100">Đăng Xuất</a>
            </div>
        </div>

        <%
            }
        %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <%@ include file="Layout2/NNVFooter2.jsp" %>

</body>
</html>
