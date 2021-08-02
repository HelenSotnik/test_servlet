<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Clients</title>
</head>
<body>
<a href="/app">Back to Main Page</a> <br>
<div align="center">
    <h2>Clients</h2>
    </form>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                 <th>Phone</th>
                 <th>About</th>
                <th>Age</th>
            </tr>
            <c:forEach items="${clients}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.email}</td>
                    <td>${item.phone}</td>
                    <td>${item.about}</td>
                    <td>${item.age}</td>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
