<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giới thiệu về CoffeLuck</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .banner {
            background: url('images/coffee-banner.jpg') no-repeat center/cover;
            height: 300px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 2rem;
            font-weight: bold;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5);
        }
        .container {
            margin-top: 30px;
        }
        .highlight {
            color: #8B4513;
            font-weight: bold;
        }
        .footer {
            background-color: #343a40;
            color: white;
            text-align: center;
            padding: 15px;
            margin-top: 30px;
        }
        .banner {
    background: linear-gradient(to right, #d2b48c, #ffffff); /* Nâu nhạt dần qua trắng */
    height: 300px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #8B4513; /* Màu chữ nâu đậm */
    font-size: 2rem;
    font-weight: bold;
    text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
}
.banner {
    background: linear-gradient(to right, rgba(210, 180, 140, 0.8), rgba(255, 255, 255, 0.8)), 
                url('${pageContext.request.contextPath}/images/anhbia2.jpg') no-repeat center/cover;
    height: 300px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #8B4513; /* Màu chữ nâu đậm */
    font-size: 2rem;
    font-weight: bold;
    text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
}

        
    </style>
</head>
<body>
 <%@ include file="Layout2/Header2.jsp" %>
    <!-- Banner -->
    <div class="banner">
        Giới thiệu về CoffeLuck
    </div>

    <div class="container">
        <h2 class="text-center my-4">☕ CoffeLuck - Hương vị từ trái tim, gắn kết thiên nhiên ☕</h2>

        <p><strong class="highlight">CoffeLuck</strong> là thương hiệu cà phê đến từ <strong class="highlight">Hưng Yên</strong> – vùng đất nổi tiếng với khí hậu ôn hòa, đất đai màu mỡ. Nhờ điều kiện tự nhiên lý tưởng, CoffeLuck mang đến những hạt cà phê thơm ngon, nguyên chất, làm say đắm lòng người.</p>

        <h4 class="mt-4">🌱 Sự chăm sóc tận tâm – Chất lượng tuyệt vời</h4>
        <p>Tại CoffeLuck, từng hạt cà phê được trồng, chăm sóc và thu hoạch bằng quy trình nghiêm ngặt. Chúng tôi áp dụng <strong class="highlight">phương pháp canh tác bền vững</strong>, đảm bảo mỗi hạt cà phê đều đạt chất lượng tốt nhất, giữ trọn hương vị tự nhiên.</p>

        <h4 class="mt-4">🌿 Khí hậu – Yếu tố tạo nên hương vị đặc biệt</h4>
        <p>Hưng Yên có <strong class="highlight">khí hậu thuận lợi</strong> cho cây cà phê phát triển. Mùa nắng nhẹ, mùa đông se lạnh cùng lượng mưa vừa đủ giúp hạt cà phê đậm đà, hương thơm đặc trưng.</p>

        <h4 class="mt-4">🎯 Sứ mệnh của CoffeLuck</h4>
        <p>CoffeLuck không chỉ mang đến những ly cà phê nguyên chất mà còn truyền tải tình yêu với thiên nhiên. Chúng tôi cam kết cung cấp sản phẩm <strong class="highlight">chất lượng, nguyên bản</strong>, giúp khách hàng tận hưởng từng khoảnh khắc thư giãn trọn vẹn.</p>

        <div class="text-center mt-4">
            <h3 class="highlight">☕ CoffeLuck – Đậm đà thiên nhiên, gắn kết yêu thương! ☕</h3>
        </div>
    </div>

    <%@ include file="Layout2/Footer2.jsp" %>

</body>
</html>
