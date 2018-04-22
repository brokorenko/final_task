<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/taglib.tld" %>


<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="pagecontent" var = "rb"/>

<html>

<head>
    <title>main</title>
    <%--<link rel="stylesheet" type="text/css" href="/css/app.css">--%>
</head>
<body>

<div class="menu-list">
    <form action="FrontController">
        <input type="hidden" name="command"   value="FiltrateCompanyByType" />
        <input type="hidden" name="currentPage"   value="0" />
        <input type="hidden" name="type"   value="STO" />
        <%--<input type="submit" name="submit" value="<fmt:message key="label.repiarServiceButton" bundle="${rb}" />">--%>
        <input type="submit" value="<fmt:message key="label.repiarServiceButton" bundle="${rb}" />">
    </form>
    <form action="FrontController">
        <input type="hidden" name="command"   value="FiltrateCompanyByType" />
        <input type="hidden" name="currentPage"   value="0" />
        <input type="hidden" name="type"   value="autowash" />
        <input type="submit" value="<fmt:message key="label.washesButton" bundle="${rb}" />">
    </form>
    <form action="FrontController">
        <input type="hidden" name="command"   value="ShowLoginPage" />
        <input type="submit" value="<fmt:message key="label.loginButton" bundle="${rb}" />">
    </form>
</div>

<c:import url="change_locale.jsp"/>

<%--<c:import url="header.jsp"/>--%>

<div class="section">
<c:forEach var="coorinate" items="${coordinates}">
    <br><a href="${pageContext.request.contextPath}?command=CompanyDetails&companyId=${coorinate.getId()}&currentPage=0">${coorinate}</a>
</c:forEach>
<br>
</div>

<div class="pagination">

<mytag:formatNumber pageCount="${pageCount}" command="FillStartPage" type="${type}"/>


</div>

<script src="/js/try.js"></script>
</body>
</html>
