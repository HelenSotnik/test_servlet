<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ClientStatuses</title>
</head>
<body>
<a href="/app">Back to Main Page</a> <br>
<div align="center">
    <h2>ClientStatuses</h2>
    </form>
    <table border="1" cellpadding="5">
        <tr>
            <th>ClientId</th>
            <th>StatusId</th>
        </tr>
        <c:forEach items="${clientStatuses}" var="item">
            <tr>
                <td>${item.clientId}</td>
                <td>${item.statusId}</td>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
