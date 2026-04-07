<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Chi tiết thú cưng</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: Arial, sans-serif;
    }

    body {
      background: #f4f7fb;
      padding: 40px 20px;
    }

    .container {
      width: 760px;
      max-width: 100%;
      margin: 0 auto;
      background: #fff;
      border-radius: 18px;
      overflow: hidden;
      box-shadow: 0 10px 24px rgba(0,0,0,0.08);
    }

    .image img {
      width: 100%;
      height: 360px;
      object-fit: cover;
      display: block;
    }

    .content {
      padding: 24px;
    }

    .title {
      font-size: 30px;
      color: #1A0DEE;
      margin-bottom: 16px;
    }

    .info {
      font-size: 16px;
      color: #333;
      margin-bottom: 12px;
      line-height: 1.7;
    }

    .price {
      font-size: 22px;
      font-weight: bold;
      color: #e53935;
      margin-top: 10px;
    }

    .back {
      display: inline-block;
      margin-top: 20px;
      text-decoration: none;
      background: #1A0DEE;
      color: white;
      padding: 12px 18px;
      border-radius: 10px;
      font-weight: bold;
    }

    .back:hover {
      background: #140bb8;
    }
  </style>
</head>
<body>
<div class="container">

  <div class="image">
    <%-- url: link ảnh của animal --%>
    <img src="${animal.url}" alt="${animal.name}">
  </div>

  <div class="content">
    <%-- name: tên animal --%>
    <h1 class="title">${animal.name}</h1>

    <%-- id: mã của animal --%>
    <p class="info"><strong>Mã:</strong> ${animal.id}</p>

    <%-- description: mô tả animal --%>
    <p class="info"><strong>Mô tả:</strong> ${animal.description}</p>

    <%-- price: giá tiền --%>
    <p class="price">${animal.price} VND</p>

    <a href="${pageContext.request.contextPath}/animals" class="back">Quay lại danh sách</a>
  </div>
</div>
</body>
</html>