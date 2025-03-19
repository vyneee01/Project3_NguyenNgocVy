<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quà Tặng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        body {
            background-color: #f8f1e7;
            font-family: "Arial", sans-serif;
        }
        .gift-container {
            background: linear-gradient(135deg, #8B4513, #D2B48C);
            padding: 50px 20px;
            border-radius: 15px;
            color: white;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }
        .gift-card {
            background: white;
            border-radius: 12px;
            padding: 20px;
            text-align: center;
            transition: 0.3s;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.15);
        }
        .gift-card:hover {
            transform: translateY(-5px);
            box-shadow: 0px 6px 20px rgba(0, 0, 0, 0.2);
        }
        .gift-card img {
            width: 120px;
            height: 120px;
            object-fit: contain;
            margin-bottom: 15px;
        }
        .gift-card h5 {
            color: #8B4513;
            font-size: 1.25rem;
            font-weight: bold;
        }
        .gift-card p {
            color: #555;
            font-size: 1rem;
        }
        .gift-card button {
            background: linear-gradient(135deg, #ff9f1c, #ff6b6b);
            color: white;
            border: none;
            border-radius: 8px;
            padding: 10px 15px;
            font-weight: bold;
            transition: 0.3s;
        }
        .gift-card button:hover {
            background: linear-gradient(135deg, #ff6b6b, #ff9f1c);
            transform: scale(1.05);
        }
    </style>
</head>
<body>
  <%@ include file="Layout2/NNVHeader2.jsp" %>

    <div class="container mt-4">
        <div class="gift-container text-center">
            <h2 class="mb-4">🎁 Quà Tặng Đặc Biệt 🎁</h2>
            <div class="row g-4">
                <!-- Quà tặng 1 -->
                <div class="col-md-4">
                    <div class="gift-card">
                        <img src="${pageContext.request.contextPath}/images/khuyenmai.jpg" alt="Quà 1">
                        <h5>Ly Cà Phê Miễn Phí</h5>
                        <p>Nhận ngay một ly cà phê miễn phí khi đăng ký hội viên!</p>
                        <button class="btn">Nhận Quà</button>
                    </div>
                </div>
                
                <!-- Quà tặng 2 -->
                <div class="col-md-4">
                    <div class="gift-card">
                        <img src="${pageContext.request.contextPath}/images/khuyenmai2.jpg" alt="Quà 2">
                        <h5>Voucher 20%</h5>
                        <p>Giảm ngay 20% cho đơn hàng đầu tiên của bạn!</p>
                        <button class="btn">Nhận Quà</button>
                    </div>
                </div>
                
                <!-- Quà tặng 3 -->
                <div class="col-md-4">
                    <div class="gift-card">
                        <img src="${pageContext.request.contextPath}/images/khuyenmai3.jpg" alt="Quà 3">
                        <h5>Thẻ Hội Viên VIP</h5>
                        <p>Đăng ký ngay để nhận thẻ VIP với nhiều ưu đãi hấp dẫn!</p>
                        <button class="btn">Nhận Quà</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
      <%@ include file="Layout2/NNVFooter2.jsp" %>
</body>
</html>
