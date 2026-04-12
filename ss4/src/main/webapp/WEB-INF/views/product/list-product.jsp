<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 08/04/2026
  Time: 9:37 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a href="/products."></a>
<table border="10" cellspacing="20" cellpadding="20">
    <thead>
    <tr>
        <td>STT</td>
        <td>Tên</td>
        <td>Mô tả</td>
        <td>Ảnh</td>
        <td>Giá</td>
        <td colspan="2">Thao tác</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="pro" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${pro.name}</td>
            <td>${pro.description}</td>
            <td><img src="${pro.imageUrl}" alt="" width="200" height="150" style="object-fit: cover"></td>
            <td>${pro.price} vnđ</td>
            <td><a href="">Sửa</a></td>
            <td><a href="">Xóa</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>