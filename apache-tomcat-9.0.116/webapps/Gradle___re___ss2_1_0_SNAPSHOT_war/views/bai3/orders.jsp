<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh sách đơn hàng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f5f7fb;
      margin: 30px;
    }
    .container {
      max-width: 1100px;
      margin: auto;
      background: white;
      padding: 24px;
      border-radius: 10px;
      box-shadow: 0 2px 10px rgba(0,0,0,0.08);
    }
    .topbar {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 18px;
    }
    .welcome {
      font-size: 18px;
      font-weight: bold;
      color: #1f3c88;
    }
    .logout a {
      color: #c62828;
      text-decoration: none;
      font-weight: bold;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 12px;
    }
    th, td {
      border: 1px solid #ddd;
      padding: 10px;
    }
    th {
      background: #eef3ff;
    }
    .footer-count {
      margin-top: 16px;
      font-weight: bold;
      color: #333;
    }
  </style>
</head>
<body>
<div class="container">

  <div class="topbar">
    <div class="welcome">
      Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}
    </div>
    <div class="logout">
      <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
    </div>
  </div>

  <table>
    <thead>
    <tr>
      <th>STT</th>
      <th>Mã đơn</th>
      <th>Tên sản phẩm</th>
      <th>Tổng tiền</th>
      <th>Ngày đặt</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="o" items="${requestScope.orders}" varStatus="loop">
      <tr>
        <td>${loop.index + 1}</td>
        <td>${o.orderCode}</td>
        <td>${o.productName}</td>
        <td>
          <fmt:formatNumber value="${o.totalAmount}" type="number" groupingUsed="true"/> VNĐ
        </td>
        <td>
          <fmt:formatDate value="${o.orderDate}" pattern="dd/MM/yyyy"/>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <div class="footer-count">
    Tổng lượt xem đơn hàng toàn hệ thống: ${applicationScope.totalViewCount}
  </div>

</div>
</body>
</html>