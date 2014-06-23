<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imran.azad
  Date: 5/18/14
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--action="<c:url value="/login"/>"--%>
    <form method="POST">
        <label for="username">Username :</label>
        <input type="text" id="username" name="username"> <br>
        <label for="password">Password :</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="Login">
    </form>

    <div id="message">
        <c:if test="${not empty message}">
            <p1>${message}</p1>
        </c:if>
    </div>
</body>
</html>