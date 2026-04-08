
<%--
  Created by IntelliJ IDEA.
  User: macpro
  Date: 8/4/26
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đay là danh sách sản phẩm</h1>
<table border="10" cellspacing="20" cellpadding="20">
    <thead>
    <tr>
        <td>STT</td>
        <td>Tên</td>
        <td>Mô tả</td>
        <td>Ảnh</td>
        <td>Giá</td>
    </tr>
    </thead>
  <tb>
      <c:forEach items="${products}" var="product" varStatus="loop">
      <tr>
          <td>${product.id}</td>
          <td>${product.name}</td>
          <td>${product.description}</td>
          <td>${product.imageUrl}</td>
          <td>${product.price}</td>

      </tr>
          </c:forEach>
  </tb>
</table>
</body>
</html>
