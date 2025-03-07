<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.nio.charset.StandardCharsets" %>
<% 
    request.setCharacterEncoding("UTF-8"); 
    response.setCharacterEncoding("UTF-8"); 
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Nhân Viên</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="../Layout/header.jsp" %>

    <section class="form-container">
    <form class="form" action="addNhanVien" method="post">
        <h2>Thêm Nhân Viên Mới</h2>

        <label for="ho">Họ:</label>
        <input type="text" name="ho" required>

        <label for="ten">Tên:</label>
        <input type="text" name="ten" required>

        <label for="gioiTinh">Giới Tính:</label>
        <select name="gioiTinh">
            <option value="true">Nam</option>
            <option value="false">Nữ</option>
        </select>

        <label for="sdt">Số Điện Thoại:</label>
        <input type="text" name="sdt" required>

        <label for="cccd">CCCD:</label>
        <input type="text" name="cccd" required>

        <label for="trangThai">Trạng Thái:</label>
        <select name="trangThai">
            <option value="true">Hoạt động</option>
            <option value="false">Ngừng hoạt động</option>
        </select>

        <label for="taiKhoan">Tài Khoản:</label>
        <input type="text" name="taiKhoan" required>

        <label for="matKhau">Mật Khẩu:</label>
        <input type="password" name="matKhau" required>

        <label for="maPQ">Mã Phân Quyền:</label>
        <input type="text" name="maPQ" required>

        <button type="submit">Thêm Nhân Viên</button>
    </form>
</section>

<a href="${pageContext.request.contextPath}/listNhanVien.jsp" class="back-link">Về Trang Danh Sách</a>
    <%@ include file="../Layout/footer.jsp" %>	

</body>
</html>
