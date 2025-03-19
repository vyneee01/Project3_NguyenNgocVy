<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Khuyến mãi</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Frontend/css/khuyenmai.css">
</head>
<body>
  <%@ include file="Layout2/NNVHeader2.jsp" %>
  
  <div class="container promo-container">
<h3 class="mb-4" style="color: #D2691E; font-size: 25px; line-height: 1.2;">Chương Trình Khuyến Mãi</h3>

    <!-- Sử dụng Bootstrap grid với gap (g-4) để đảm bảo khoảng cách đều giữa các card -->
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
      <%
        // Danh sách ảnh khuyến mãi theo tên file thực tế
        String[][] khuyenMaiList = {
          {"khuyenmai.jpg", "Mua 1 tặng 1 toàn bộ menu!"},
          {"khuyenmai2.jpg", "Ưu đãi 50% cho đơn hàng trên 200K"},
          {"khuyenmai3.jpg", "Giảm 20K khi thanh toán qua ví điện tử"},
          {"khuyenmai4.jpg", "Đồng giá 29K cho tất cả trà sữa"}
        };

        for (String[] km : khuyenMaiList) { 
      %>
        <div class="col">
          <div class="card promo-card">
            <img src="${pageContext.request.contextPath}/images/<%= km[0] %>" class="promo-img" alt="<%= km[1] %>">
            <div class="promo-info">
              <p class="promo-title"><%= km[1] %></p>
            </div>
          </div>
        </div>
      <%
        } 
      %>
    </div>
  </div>
  
  <%@ include file="Layout2/NNVFooter2.jsp" %>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
