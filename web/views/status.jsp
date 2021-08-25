<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Statuses</title>
</head>
<body>
<a href="/app">Back to Main Page</a> <br>
<div align="center">
    <h2>Statuses</h2>
    </form>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Alias</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${statuses}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.alias}</td>
                <td>${item.description}</td>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
