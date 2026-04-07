<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách nhân viên</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 30px;
      background-color: #f5f7fa;
    }

    h2 {
      text-align: center;
      color: #333;
    }

    table {
      width: 80%;
      margin: 20px auto;
      border-collapse: collapse;
      background-color: white;
      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    }

    th, td {
      border: 1px solid #ddd;
      padding: 12px;
      text-align: center;
    }

    th {
      background-color: #007bff;
      color: white;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2;
    }

    .high-salary {
      color: green;
      font-weight: bold;
    }

    .basic-salary {
      color: #d35400;
      font-weight: bold;
    }
  </style>
</head>
<body>

<h2>Danh sách nhân viên phòng Đào tạo</h2>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Họ tên</th>
    <th>Phòng ban</th>
    <th>Lương</th>
    <th>Đánh giá</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="emp" items="${employees}">
    <tr>
      <td>${emp.id}</td>
      <td>${emp.fullName}</td>
      <td>${emp.department}</td>
      <td>${emp.salary}</td>
      <td>
        <c:choose>
          <c:when test="${emp.salary >= 10000}">
            <span class="high-salary">Mức lương cao</span>
          </c:when>
          <c:otherwise>
            <span class="basic-salary">Mức lương cơ bản</span>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>