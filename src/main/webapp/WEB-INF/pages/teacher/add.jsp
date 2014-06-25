<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imran.azad
  Date: 6/24/14
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form:form commandName="teacher" method="post">
        <table>
            <%--Table generation with loop on listOfFields--%>
            <%--<c:forEach var="field" items="${fieldsOfTeacher}">--%>
                <%--<tr>--%>
                    <%--<td><form:label path="${field}">${field}</form:label></td>--%>
                    <%--<td><form:input path="${field}" /></td>--%>
                    <%--<td><form:errors path="${field}" cssClass="error" /></td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>

            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" cssClass="error" /></td>
            </tr>

            <tr>
                <td><form:label path="email">Email</form:label></td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>

            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:input path="password" /></td>
                <td><form:errors path="password" cssClass="error" /></td>
            </tr>

            <%--<tr>--%>
                <%--<td><form:label path="dob">DOB</form:label></td>--%>
                <%--<td><form:input path="dob" /></td>--%>
                <%--<td><form:errors path="dob" cssClass="error" /></td>--%>
            <%--</tr>--%>

        </table>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
