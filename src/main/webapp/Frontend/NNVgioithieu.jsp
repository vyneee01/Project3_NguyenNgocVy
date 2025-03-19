<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giới thiệu về CoffeLuck</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Frontend/css/gioithieu.css">
</head>
<body>
    <%@ include file="Layout2/NNVHeader2.jsp" %>
    
   <div class="banner-container">
    <img src="${pageContext.request.contextPath}/images/anhbia100.jpg" alt="Giới thiệu CoffeLuck" class="custom-banner">
</div>

    <div class="container py-5">
        <!-- Giới thiệu tổng quan -->
        <h2 class="text-center mb-4 text-primary">☕ CoffeLuck - Đậm đà từng khoảnh khắc ☕</h2>
        <p>CoffeLuck không chỉ đơn thuần là một thương hiệu cà phê, mà là một hành trình khám phá những giá trị tinh túy nhất của cà phê Việt Nam. Được tạo nên từ đam mê, sự tận tâm và tình yêu với hạt cà phê, chúng tôi mong muốn mang đến những ly cà phê nguyên bản, giúp bạn tận hưởng trọn vẹn từng khoảnh khắc.</p>

        <h4 class="mt-4 text-success">🌿 Giá trị cốt lõi của CoffeLuck</h4>
        <ul>
            <li><strong>Chất lượng hàng đầu:</strong> Hạt cà phê được tuyển chọn kỹ lưỡng, rang xay theo công nghệ hiện đại để giữ trọn hương vị.</li>
            <li><strong>Bảo vệ môi trường:</strong> Chúng tôi áp dụng phương pháp canh tác bền vững, giảm thiểu tác động đến thiên nhiên.</li>
            <li><strong>Kết nối con người:</strong> Cà phê là cầu nối mang mọi người xích lại gần nhau hơn, từ những cuộc trò chuyện ấm áp đến những buổi họp mặt ý nghĩa.</li>
        </ul>

        <h4 class="mt-4 text-danger">🎯 Sứ mệnh của chúng tôi</h4>
        <p>Lan tỏa tình yêu cà phê, mang đến những trải nghiệm thưởng thức chân thực nhất và góp phần xây dựng một cộng đồng yêu cà phê mạnh mẽ.</p>

        <!-- Phản hồi khách hàng -->
        <div class="mt-5">
            <h2 class="text-center mb-4 text-warning">Khách hàng nói gì về CoffeLuck?</h2>
            <div class="row">
                <div class="col-md-4 mb-4">
                    <div class="border p-3 rounded shadow-sm bg-light">
                        <p>“Hương vị cà phê tuyệt vời, rất tự nhiên và nguyên bản. Một ly cà phê buổi sáng tại CoffeLuck giúp tôi khởi đầu ngày mới tràn đầy năng lượng!”</p>
                        <small class="text-muted">- Thanh Tâm, Hà Nội</small>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="border p-3 rounded shadow-sm bg-light">
                        <p>“Quán có không gian thoáng đãng, cà phê đậm đà và nhân viên rất thân thiện. Tôi cảm thấy rất hài lòng!”</p>
                        <small class="text-muted">- Hoàng Anh, Sài Gòn</small>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="border p-3 rounded shadow-sm bg-light">
                        <p>“Thật bất ngờ về chất lượng cà phê tại đây! Rất thơm và có hậu vị đặc trưng, chắc chắn tôi sẽ quay lại.”</p>
                        <small class="text-muted">- Minh Khoa, Đà Nẵng</small>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="Layout2/NNVFooter2.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>