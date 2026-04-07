<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%-- Trang báo cáo điểm sinh viên (Refactor chuẩn JSTL + EL) --%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Báo cáo điểm sinh viên</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f7fb;
            margin: 30px;
        }

        .container {
            max-width: 1000px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        h1 {
            color: #1f3c88;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
        }

        th {
            background: #eef3ff;
        }

        .pass {
            color: green;
            font-weight: bold;
        }

        .fail {
            color: red;
            font-weight: bold;
        }

        .empty {
            padding: 15px;
            background: #fff3cd;
            border-radius: 6px;
        }
    </style>
</head>

<body>
<div class="container">

    <h1>
        <c:out value="${reportTitle}" default="Báo cáo điểm sinh viên"/>
    </h1>

    <c:choose>

        <c:when test="${not empty students}">
            <table>
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã SV</th>
                    <th>Họ tên</th>
                    <th>Môn</th>
                    <th>Điểm</th>
                    <th>Kết quả</th>
                    <th>Ghi chú</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="s" items="${students}" varStatus="loop">
                    <tr>
                        <td><c:out value="${loop.index + 1}"/></td>
                        <td><c:out value="${s.id}"/></td>
                        <td><c:out value="${s.name}"/></td>
                        <td><c:out value="${s.subject}"/></td>
                        <td><c:out value="${s.score}"/></td>

                        <td>
                            <c:choose>
                                <c:when test="${s.score >= 5}">
                                    <span class="pass">Đạt</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="fail">Không đạt</span>
                                </c:otherwise>
                            </c:choose>
                        </td>

                        <td>
                            <c:out value="${s.comment}" default="Không có"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:when>

        <c:otherwise>
            <div class="empty">
                Không có dữ liệu sinh viên.
            </div>
        </c:otherwise>

    </c:choose>

</div>
</body>
</html>