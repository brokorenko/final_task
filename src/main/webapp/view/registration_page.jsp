<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 29.03.2018
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="pagecontent" var = "rb"/>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:import url="change_locale.jsp"/>

<form action="FrontController" method="post">
    <input type="hidden" name="command"   value="Registration"/>

    <fmt:message key="label.usernameField" bundle="${rb}" />:<br>
    <input type="text" name="username" required>
    <br>
    <fmt:message key="label.passwordField" bundle="${rb}" />:<br>
    <input type="password" name="password" required>
    <input type="submit" value="<fmt:message key="label.registerButton" bundle="${rb}" />">
</form>
</body>
</html>
