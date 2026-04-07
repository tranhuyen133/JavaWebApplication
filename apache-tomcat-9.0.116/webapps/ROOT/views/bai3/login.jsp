<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Đăng nhập</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f4f6fb;
      margin: 0;
      padding: 40px;
    }
    .box {
      width: 380px;
      margin: 0 auto;
      background: #fff;
      padding: 24px;
      border-radius: 10px;
      box-shadow: 0 2px 12px rgba(0,0,0,0.1);
    }
    h2 {
      margin-top: 0;
      color: #1f3c88;
    }
    .form-group {
      margin-bottom: 14px;
    }
    label {
      display: block;
      margin-bottom: 6px;
    }
    input {
      width: 100%;
      height: 38px;
      padding: 0 10px;
      box-sizing: border-box;
    }
    button {
      width: 100%;
      height: 40px;
      border: none;
      background: #1f3c88;
      color: white;
      border-radius: 6px;
      cursor: pointer;
    }
    .error {
      color: #c62828;
      margin-bottom: 12px;
      font-weight: bold;
    }
    .note {
      margin-top: 12px;
      font-size: 13px;
      color: #666;
    }
  </style>
</head>
<body>
<div class="box">
  <h2>Đăng nhập hệ thống</h2>

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>

  <form action="${pageContext.request.contextPath}/login" method="post">
    <div class="form-group">
      <label>Tài khoản</label>
      <input type="text" name="username" />
    </div>

    <div class="form-group">
      <label>Mật khẩu</label>
      <input type="password" name="password" />
    </div>

    <button type="submit">Đăng nhập</button>
  </form>

  <div class="note">
    admin / admin123 <br/>
    staff / staff123
  </div>
</div>
</body>
</html>