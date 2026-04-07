<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 06/04/2026
  Time: 9:41 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Thêm động vật</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f4f6f9;
      margin: 0;
      padding: 20px;
    }
    h1 {
      text-align: center;
      color: #2c3e50;
    }
    form {
      max-width: 500px;
      margin: 30px auto;
      background: #fff;
      padding: 25px;
      border-radius: 10px;
      box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }
    label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
      color: #34495e;
    }
    input, textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 14px;
    }
    input:focus, textarea:focus {
      border-color: #3498db;
      outline: none;
      box-shadow: 0 0 5px rgba(52,152,219,0.5);
    }
    button {
      width: 100%;
      padding: 12px;
      background: #3498db;
      color: #fff;
      font-size: 16px;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      transition: background 0.3s ease;
    }
    button:hover {
      background: #2980b9;
    }
  </style>
</head>
<body>
<h1>Thêm động vật mới</h1>
<form action="/animals/add" method="post">
  <label for="id">ID</label>
  <input type="number" id="id" name="id" required>

  <label for="name">Tên động vật</label>
  <input type="text" id="name" name="name" required>

  <label for="description">Mô tả</label>
  <textarea id="description" name="description" rows="4" required></textarea>

  <label for="url">URL hình ảnh</label>
  <input type="url" id="url" name="url" placeholder="https://example.com/animal.jpg" required>

  <label for="price">Giá</label>
  <input type="number" id="price" name="price" step="0.01" required>

  <button type="submit">Thêm vào danh sách</button>
</form>
</body>
</html>