<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.banner {
    width: 1300px;              /* Chiều rộng cố định */
    height: 300px;              /* Chiều cao cố định */
    margin: 0 auto;             /* Căn giữa banner */
    position: relative;
    background: url('${pageContext.request.contextPath}/images/anhbia2.jpg') no-repeat center center;
    background-size: cover;     /* Ảnh phủ đầy khung */
    border-radius: 8px;         /* Bo góc nếu cần */
    overflow: hidden;
}

.banner-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.3);  /* Lớp overlay tối nhẹ để chữ nổi bật */
}

.banner-content {
    position: relative;
    z-index: 2;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    color: #fff;
    text-align: center;
    padding: 0 20px;
}

.banner-content h1 {
    font-size: 48px;
    margin: 0;
    font-weight: bold;
    text-shadow: 2px 2px 6px rgba(0, 0, 0, 0.5);
}

.banner-content p {
    font-size: 20px;
    margin-top: 10px;
    text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.5);
}

</style>
</head>
<body>
<!-- Banner CoffeLuck -->
<div class="banner">
    <div class="banner-overlay"></div>
    <div class="banner-content">
        <h1>CoffeLuck</h1>
        <p>Thương yêu thiên nhiên - Hương vị độc đáo</p>
    </div>
</div>

</body>
</html>