<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Accounts</title>
</head>
<body>
<a href="/app">Back to Main Page</a> <br>
<div align="center">
    <h2>Accounts</h2>
    </form>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>ClientId</th>
            <th>Number</th>
            <th>Value</th>
        </tr>
        <c:forEach items="${accounts}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.clientId}</td>
                <td>${item.number}</td>
                <td>${item.value}</td>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>