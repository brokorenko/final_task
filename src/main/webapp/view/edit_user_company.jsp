<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <input type="hidden" name="command"   value="EditUserCompany" />
    <input type="hidden" name="companyId"   value="${companyId}" />
    <input type="hidden" name="currentPage"   value="${currentPage}" />
    <fmt:message key="label.companyNameField" bundle="${rb}" />:<br>
    <label>
        <input type="text" name="name">
    </label>
    <br>
    <fmt:message key="label.companyServiceListField" bundle="${rb}" />:<br>
    <label>
        <input type="text" name="serviceList">
    </label>
    <input type="submit" value="<fmt:message key="label.changeButton" bundle="${rb}" />">
</form>
</body>
</html>
