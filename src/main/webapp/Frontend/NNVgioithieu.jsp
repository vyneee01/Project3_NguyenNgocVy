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
    <!-- Banner -->
    <div class="banner">
        Giới thiệu về CoffeLuck
    </div>

    <div class="container">
        <!-- Phần giới thiệu tổng quan -->
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

        <!-- 1) Phần Sứ mệnh & Tầm nhìn -->
        <div class="section-spacing">
            <h2 class="text-center mb-4" style="color:#D2691E;">Sứ mệnh & Tầm nhìn</h2>
            <div class="row">
                <div class="col-md-6">
                    <h5 class="highlight">Sứ mệnh</h5>
                    <p>CoffeLuck mang đến hương vị cà phê đích thực, gìn giữ và tôn vinh giá trị thiên nhiên, đồng thời xây dựng cộng đồng yêu cà phê thân thiện, gần gũi với môi trường.</p>
                </div>
                <div class="col-md-6">
                    <h5 class="highlight">Tầm nhìn</h5>
                    <p>Trở thành thương hiệu cà phê tiên phong trong lĩnh vực phát triển bền vững, mang đến trải nghiệm cà phê mới lạ và lan tỏa tinh thần “sống xanh” đến mọi người.</p>
                </div>
            </div>
        </div>

        <!-- 2) Phần Đội ngũ CoffeLuck -->
        <div class="section-spacing">
            <h2 class="text-center mb-4" style="color:#D2691E;">Đội ngũ CoffeLuck</h2>
            <div class="row">
                <!-- Thành viên 1 -->
                <div class="col-md-4 mb-4">
                    <div class="card team-card">
                        <img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Thành viên 1">
                        <h5>Nguyễn Ngọc Vỹ</h5>
                        <p>CEO - Kẻ Tạo Ra Thời Đại Mới Cho Cà Phê</p>
                    </div>
                </div>
                <!-- Thành viên 2 -->
                <div class="col-md-4 mb-4">
                    <div class="card team-card">
                        <img src="${pageContext.request.contextPath}/images/chutich.jpg" alt="Thành viên 2">
                        <h5>Lại Thị Phương Linh</h5>
                        <p>Đồng Sáng Lập CoffeLuck</p>
                    </div>
                </div>
               
        </div>

        <!-- 3) Phần Phản hồi khách hàng (Testimonials) -->
        <div class="section-spacing">
            <h2 class="text-center mb-4" style="color:#D2691E;">Khách hàng nói gì?</h2>
            <div class="row">
                <div class="col-md-4 mb-4">
                    <div class="testimonial-card">
                        <p>“Cà phê của CoffeLuck thật tuyệt vời, hương vị đậm đà mà vẫn thanh nhẹ. Mình sẽ tiếp tục ủng hộ!”</p>
                        <div class="testimonial-author">- Thanh Tâm, Hà Nội</div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="testimonial-card">
                        <p>“Tôi ấn tượng với quy trình canh tác bền vững của CoffeLuck. Uống cà phê vừa ngon, vừa thấy yên tâm!”</p>
                        <div class="testimonial-author">- Hoàng Anh, Sài Gòn</div>
                    </div>
                </div>
                <div class="col-md-4 mb-4">
                    <div class="testimonial-card">
                        <p>“Lần đầu thưởng thức cà phê Hưng Yên, cảm giác mới lạ và rất đặc trưng. Thật đáng để thử!”</p>
                        <div class="testimonial-author">- Minh Khoa, Đà Nẵng</div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Kết thúc nội dung -->
    </div>

    <%@ include file="Layout2/NNVFooter2.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
