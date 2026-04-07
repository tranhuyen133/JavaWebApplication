<%@ page import="re.mvc.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: a
  Date: 06/04/2026
  Time: 7:52 SA
  To change this template use File | Settings | File Templates.
--%>

<%-- Directive :  điều hướng (ko cần viết bằng tay) --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- thêm thư viện JSTL để dùng c:if, c:forEach --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--Scriptlet : Code logic java --%>

<%
  int a = 10;
  String message = "";

  if (a == 10){
    message = "a = 10";
  }

  Student s = new Student(1,"Nguyen Van A", 20);

  // thêm dữ liệu vào request để EL ${a} và JSTL dùng được
  request.setAttribute("a", a);
  request.setAttribute("student", s);
%>

<%--Declaration code : Khai váo các thành phần --%>
<%!
  private int status = 1;

  public String printName(String name){
    return "Tên sinh viên: " + name;
  }
%>

<%--Expression : biểu thức (phải trả về 1 giá trị)--%>

<%-- Chú thích --%>

<html>
<head>
  <title>Trang demo JSP</title>
</head>
<body>
<h1>Đây là trang demo <%= a + 10 %></h1>

<p>Giá trị của a: <%= a %></p>
<p>Kết quả kiểm tra: <%= message %></p>

<p>ID sinh viên: <%= s.getId() %></p>
<p>Tên sinh viên: <%= s.getName() %></p>
<p>Tuổi sinh viên: <%= s.getAge() %></p>

<p><%= printName(s.getName()) %></p>

<p>Trạng thái: <%= status %></p>

<h3>Danh sách số từ 0 đến 9:</h3>
<ul>
  <%
    for (int i = 0; i < a; i++) {
  %>
  <li><%= i %></li>
  <%
    }
  %>
</ul>

<%--Khi bấm vào thẻ a thì làm gì --%>

<%--đây là if-else--%>
<c:if test="${a == 10}">
  <p>Giá trị a bằng 10, hiển thị liên kết gửi</p>
</c:if>

<%-- sai vì !a sẽ biến a thành boolean rồi lại so sánh với 10 nên lỗi 500 --%>
<%-- <c:if test="${!a == 10}"> --%>
<%--   <p>Giá trị a bằng 10, hiển thị liên kết gửi</p> --%>
<%-- </c:if> --%>

<%-- sửa đúng điều kiện a khác 10 --%>
<c:if test="${a != 10}">
  <p>Giá trị a khác 10</p>
</c:if>

<%--vòg lặp--%>
<%-- đoạn cũ sai vì c:forEach thiếu items hoặc begin/end nên không chạy --%>
<%-- <c:forEach var="num" > --%>
<%--    <li>${num}</li> --%>
<%-- </c:forEach> --%>

<ul>
  <c:forEach var="num" begin="0" end="9">
    <li>${num}</li>
  </c:forEach>
</ul>

<a href="/submit?a=10">Gửi</a>
</body>
</html>