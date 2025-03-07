<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Objects" %>
<%
    // Kiểm tra nếu đã đăng nhập thì chuyển hướng về trang chủ
    if (session.getAttribute("user") != null) {
        response.sendRedirect("Backend/trangchu.jsp");
        return;
    }

    // Lấy thông báo lỗi (nếu có)
    String error = (String) request.getAttribute("error");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Nhập</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background: #fff;
            width: 100%;
            max-width: 360px;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
            font-size: 24px;
            color: #333;
            font-weight: 600;
        }
        .input-group {
            margin-bottom: 20px;
            text-align: left;
        }
        .input-group label {
            font-weight: 500;
            color: #333;
            margin-bottom: 5px;
            display: block;
        }
        .input-group input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 16px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }
        .input-group input:focus {
            border-color: #007bff;
            outline: none;
        }
        .error {
            color: #ff4d4d;
            font-size: 14px;
            margin-bottom: 20px;
        }
        .login-btn {
            width: 100%;
            padding: 12px;
            font-size: 18px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .login-btn:hover {
            background-color: #0056b3;
        }
        .login-btn:active {
            background-color: #004085;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Đăng Nhập</h2>
    
    <% if (error != null) { %>
        <p class="error"><%= error %></p>
    <% } %>

    <form action="${pageContext.request.contextPath}/Backend/NhanVien/LoginServlet" method="post">
        <div class="input-group">
            <label for="username">Tài khoản:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="input-group">
            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit" class="login-btn">Đăng Nhập</button>
    </form>
</div>

</body>
</html>
