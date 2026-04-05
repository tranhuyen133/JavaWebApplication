<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>About - Giới thiệu</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Segoe UI', sans-serif;
    }

    body {
      background: linear-gradient(135deg, #43e97b, #38f9d7);
      min-height: 100vh;
      color: #333;
    }

    .navbar {
      background: rgba(255,255,255,0.15);
      padding: 15px 0;
    }

    .nav-container {
      width: 90%;
      max-width: 1100px;
      margin: auto;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .logo {
      color: white;
      font-size: 24px;
      font-weight: bold;
    }

    .menu a {
      text-decoration: none;
      color: white;
      margin-left: 20px;
      font-weight: 500;
    }

    .menu a:hover {
      color: #fff176;
    }

    .container {
      width: 90%;
      max-width: 1000px;
      margin: 40px auto;
    }

    .card {
      background: white;
      border-radius: 20px;
      padding: 35px;
      box-shadow: 0 10px 25px rgba(0,0,0,0.15);
    }

    .about-box {
      display: flex;
      align-items: center;
      gap: 30px;
      flex-wrap: wrap;
    }

    .about-box img {
      width: 220px;
      border-radius: 20px;
      object-fit: cover;
    }

    .about-content {
      flex: 1;
      min-width: 280px;
    }

    .about-content h1 {
      color: #00a86b;
      margin-bottom: 15px;
    }

    .about-content p {
      line-height: 1.8;
      margin-bottom: 12px;
      font-size: 17px;
    }

    .btn {
      display: inline-block;
      padding: 12px 20px;
      background: #00c896;
      color: white;
      border-radius: 25px;
      text-decoration: none;
      margin-top: 10px;
      margin-right: 10px;
    }

    .btn:hover {
      background: #009f75;
    }

    footer {
      text-align: center;
      color: white;
      padding: 20px;
      margin-top: 30px;
    }
  </style>
</head>
<body>

<div class="navbar">
  <div class="nav-container">
    <div class="logo">MyProfile</div>
    <div class="menu">
      <a href="home.jsp">Home</a>
      <a href="about.jsp">About</a>
      <a href="product.jsp">Product</a>
    </div>
  </div>
</div>

<div class="container">
  <div class="card">
    <div class="about-box">
      <img src="https://i.pravatar.cc/250?img=12" alt="about image">
      <div class="about-content">
        <h1>Giới thiệu về tôi</h1>
        <p>
          Tôi là một Java Developer đang học và phát triển theo hướng Java Web.
          Tôi có hứng thú với JSP/Servlet, Spring Boot và xây dựng hệ thống quản lý.
        </p>
        <p>
          Mục tiêu của tôi là tạo ra những ứng dụng thực tế, giao diện thân thiện,
          dễ sử dụng và có thể kết nối tốt với cơ sở dữ liệu.
        </p>
        <p>
          Tôi luôn cố gắng cải thiện kỹ năng lập trình, tư duy xử lý bài toán
          và cách tổ chức source code rõ ràng hơn.
        </p>

        <a href="home.jsp" class="btn">Về Home</a>
        <a href="product.jsp" class="btn">Xem Product</a>
      </div>
    </div>
  </div>
</div>

<footer>
  <p>© 2026 - Trang About của RE</p>
</footer>

</body>
</html>