<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Sửa thú cưng</title>
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
      width: 520px;
      max-width: 100%;
      margin: 0 auto;
      background: #fff;
      padding: 28px;
      border-radius: 18px;
      box-shadow: 0 10px 24px rgba(0,0,0,0.08);
    }

    .title {
      text-align: center;
      font-size: 28px;
      color: #1A0DEE;
      margin-bottom: 24px;
    }

    .form-group {
      margin-bottom: 18px;
    }

    label {
      display: block;
      margin-bottom: 8px;
      font-weight: bold;
      color: #333;
    }

    input, textarea {
      width: 100%;
      padding: 12px 14px;
      border: 1px solid #dcdfe6;
      border-radius: 10px;
      outline: none;
      font-size: 15px;
    }

    textarea {
      min-height: 100px;
      resize: vertical;
    }

    input:focus, textarea:focus {
      border-color: #1A0DEE;
    }

    .actions {
      display: flex;
      gap: 12px;
      margin-top: 22px;
    }

    .btn {
      flex: 1;
      border: none;
      text-decoration: none;
      text-align: center;
      padding: 12px;
      border-radius: 10px;
      font-weight: bold;
      cursor: pointer;
      font-size: 15px;
    }

    .btn-submit {
      background: #f59e0b;
      color: white;
    }

    .btn-back {
      background: #e5e7eb;
      color: #333;
    }

    .btn-submit:hover {
      background: #d97706;
    }

    .btn-back:hover {
      background: #d1d5db;
    }
  </style>
</head>
<body>
<div class="container">
  <h1 class="title">Sửa thú cưng</h1>

  <%-- form gửi dữ liệu bằng POST lên /animals/update --%>
  <form action="${pageContext.request.contextPath}/animals/update" method="post">

    <%-- id: mã của animal, dùng để xác định đang sửa bản ghi nào --%>
    <input type="hidden" name="id" value="${animal.id}">

    <div class="form-group">
      <%-- name: tên animal --%>
      <label>Tên thú cưng</label>
      <input type="text" name="name" value="${animal.name}" required>
    </div>

    <div class="form-group">
      <%-- description: mô tả animal --%>
      <label>Mô tả</label>
      <textarea name="description" required>${animal.description}</textarea>
    </div>

    <div class="form-group">
      <%-- url: link ảnh của animal --%>
      <label>URL ảnh</label>
      <input type="text" name="url" value="${animal.url}" required>
    </div>

    <div class="form-group">
      <%-- price: giá tiền --%>
      <label>Giá</label>
      <input type="number" step="0.1" name="price" value="${animal.price}" required>
    </div>

    <div class="actions">
      <%-- nút submit để cập nhật --%>
      <button type="submit" class="btn btn-submit">Cập nhật</button>

      <a href="${pageContext.request.contextPath}/animals" class="btn btn-back">Quay lại</a>
    </div>
  </form>
</div>
</body>
</html>