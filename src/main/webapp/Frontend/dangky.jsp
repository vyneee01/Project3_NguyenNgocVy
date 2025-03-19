<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Frontend/css/hoivien.css">
    
</head>
<body>
    <%@ include file="Layout2/NNVHeader2.jsp" %>

   <div class="form-container">
    <form action="${pageContext.request.contextPath}/DangKyServlet" method="POST" onsubmit="return kiemTraMatKhau()">
        <div class="mb-2">
            <label for="hoTen" class="form-label">Họ và Tên:</label>
            <input type="text" class="form-control" id="hoTen" name="hoTen" required>
        </div>
        <div class="mb-2">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="mb-2">
            <label for="soDienThoai" class="form-label">Số Điện Thoại:</label>
            <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" required>
        </div>
        <div class="mb-2">
            <label for="matKhau" class="form-label">Mật khẩu:</label>
            <input type="password" class="form-control" id="matKhau" name="matKhau" required>
        </div>
        <div class="mb-2">
            <label for="xacNhanMatKhau" class="form-label">Xác nhận mật khẩu:</label>
            <input type="password" class="form-control" id="xacNhanMatKhau" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Đăng Ký</button>
    </form>
</div>

<script>
    function kiemTraMatKhau() {
        var matKhau = document.getElementById("matKhau").value;
        var xacNhanMatKhau = document.getElementById("xacNhanMatKhau").value;

        if (matKhau !== xacNhanMatKhau) {
            alert("Mật khẩu xác nhận không khớp! Vui lòng nhập lại.");
            return false; // Ngăn form gửi đi
        }
        return true; // Cho phép form gửi đi
    }
</script>

        <%@ include file="Layout2/NNVFooter2.jsp" %>
    
</body>
</html>
