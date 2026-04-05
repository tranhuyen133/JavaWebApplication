<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Home - Trang cá nhân</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Segoe UI', sans-serif;
    }

    body {
      background: linear-gradient(135deg, #4facfe, #00f2fe);
      min-height: 100vh;
      color: #333;
    }

    .navbar {
      width: 100%;
      background: rgba(255,255,255,0.15);
      backdrop-filter: blur(8px);
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
      transition: 0.3s;
    }

    .menu a:hover {
      color: #ffe082;
    }

    .container {
      width: 90%;
      max-width: 1100px;
      margin: 30px auto;
    }

    .hero {
      background: white;
      border-radius: 20px;
      padding: 50px;
      box-shadow: 0 10px 25px rgba(0,0,0,0.15);
      display: flex;
      justify-content: space-between;
      align-items: center;
      gap: 30px;
      flex-wrap: wrap;
    }

    .hero-text {
      flex: 1;
      min-width: 280px;
    }

    .hero-text h1 {
      font-size: 42px;
      margin-bottom: 15px;
      color: #007bff;
    }

    .hero-text p {
      font-size: 18px;
      line-height: 1.7;
      margin-bottom: 20px;
    }

    .hero img {
      width: 280px;
      border-radius: 20px;
      object-fit: cover;
    }

    .btn {
      display: inline-block;
      padding: 12px 22px;
      background: #4facfe;
      color: white;
      border-radius: 30px;
      text-decoration: none;
      margin-right: 10px;
      transition: 0.3s;
    }

    .btn:hover {
      background: #007bff;
    }

    .cards {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 20px;
      margin-top: 30px;
    }

    .card {
      background: white;
      border-radius: 18px;
      padding: 25px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.12);
    }

    .card h3 {
      margin-bottom: 12px;
      color: #007bff;
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
  <div class="hero">
    <div class="hero-text">
      <h1>Xin chào, tôi là <%= "RE" %> 👋</h1>
      <p>
        Tôi là lập trình viên yêu thích Java Web, JSP/Servlet và Spring Boot.
        Tôi thích xây dựng giao diện đẹp, dễ dùng và kết nối dữ liệu hiệu quả.
      </p>
      <a href="about.jsp" class="btn">Xem giới thiệu</a>
      <a href="product.jsp" class="btn">Xem sản phẩm</a>
    </div>
    <img src="https://i.pravatar.cc/300" alt="avatar">
  </div>

  <div class="cards">
    <div class="card">
      <h3>Kỹ năng</h3>
      <p>Java, JSP/Servlet, Spring Boot, MySQL, HTML, CSS, JavaScript.</p>
    </div>

    <div class="card">
      <h3>Dự án</h3>
      <p>Website bán hàng, hệ thống quản lý sinh viên, blog cá nhân.</p>
    </div>

    <div class="card">
      <h3>Hệ thống</h3>
      <p>Thời gian hiện tại: <%= new java.util.Date() %></p>
    </div>
  </div>
</div>

<footer>
  <p>© 2026 - Trang Home của RE</p>
</footer>

</body>
</html>