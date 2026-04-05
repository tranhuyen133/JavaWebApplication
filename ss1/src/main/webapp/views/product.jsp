<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Product - Sản phẩm</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Segoe UI', sans-serif;
    }

    body {
      background: linear-gradient(135deg, #fa709a, #fee140);
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
      max-width: 1100px;
      margin: 40px auto;
    }

    .title-box {
      text-align: center;
      color: white;
      margin-bottom: 30px;
    }

    .title-box h1 {
      font-size: 40px;
      margin-bottom: 10px;
    }

    .products {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 20px;
    }

    .product-card {
      background: white;
      border-radius: 18px;
      padding: 20px;
      box-shadow: 0 10px 25px rgba(0,0,0,0.15);
      text-align: center;
    }

    .product-card img {
      width: 100%;
      height: 180px;
      object-fit: cover;
      border-radius: 15px;
      margin-bottom: 15px;
    }

    .product-card h3 {
      color: #ff4f81;
      margin-bottom: 10px;
    }

    .product-card p {
      font-size: 15px;
      line-height: 1.6;
      margin-bottom: 15px;
    }

    .btn {
      display: inline-block;
      padding: 10px 18px;
      background: #ff4f81;
      color: white;
      text-decoration: none;
      border-radius: 25px;
    }

    .btn:hover {
      background: #e63b6f;
    }

    .bottom-links {
      text-align: center;
      margin-top: 30px;
    }

    .bottom-links a {
      text-decoration: none;
      color: white;
      background: rgba(255,255,255,0.2);
      padding: 12px 20px;
      border-radius: 25px;
      margin: 0 8px;
      display: inline-block;
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
  <div class="title-box">
    <h1>Sản phẩm của tôi</h1>
    <p>Một số dự án và sản phẩm tiêu biểu tôi đã thực hiện</p>
  </div>

  <div class="products">
    <div class="product-card">
      <img src="https://picsum.photos/400/250?random=1" alt="product 1">
      <h3>Website bán hàng</h3>
      <p>Xây dựng bằng JSP/Servlet, kết nối MySQL, hỗ trợ quản lý sản phẩm và đơn hàng.</p>
      <a href="#" class="btn">Xem thêm</a>
    </div>

    <div class="product-card">
      <img src="https://picsum.photos/400/250?random=2" alt="product 2">
      <h3>Quản lý sinh viên</h3>
      <p>Ứng dụng Java hỗ trợ thêm, sửa, xóa, tìm kiếm thông tin sinh viên hiệu quả.</p>
      <a href="#" class="btn">Xem thêm</a>
    </div>

    <div class="product-card">
      <img src="https://picsum.photos/400/250?random=3" alt="product 3">
      <h3>Blog cá nhân</h3>
      <p>Trang web giới thiệu bản thân, bài viết cá nhân và danh sách kỹ năng nổi bật.</p>
      <a href="#" class="btn">Xem thêm</a>
    </div>
  </div>

  <div class="bottom-links">
    <a href="home.jsp">Về Home</a>
    <a href="about.jsp">Sang About</a>
  </div>
</div>

<footer>
  <p>© 2026 - Trang Product của RE</p>
</footer>

</body>
</html>