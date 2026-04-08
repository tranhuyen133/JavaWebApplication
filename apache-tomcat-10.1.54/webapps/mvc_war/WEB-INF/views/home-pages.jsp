<%--
  Created by IntelliJ IDEA.
  User: macpro
  Date: 8/4/26
  Time: 07:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>homePage</title>
</head>
<body>
<h1>Hello</h1><h1>Hello</h1>

<form action="${pageContext.request.contextPath}/student/submit" method="post">
    <input type="text" name="name" placeholder="Name" required>
    <input type="number" name="age" placeholder="Age" required>
    <button type="submit">Submit</button>
</form>
<%--    LÀm sao đẻ dữ liệu model ra--%>
<%--Epression Laguage : ${}}--%>
<h2>Chiều cao : ${heigh}</h2>
<h2>Cân nặng : ${weight}kg</h2>
</body>
</html>
