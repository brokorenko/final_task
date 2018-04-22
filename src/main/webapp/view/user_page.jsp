<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/taglib.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="pagecontent" var = "rb"/>

<html>
<head>
    <title>Title</title>
</head>
<body>

Hello ${sessionScope.get("username")}
<form>
    <input type="hidden" name="command"   value="LogoutUser" />
    <input type="submit" value="<fmt:message key="label.logoutButton" bundle="${rb}" />">
</form>

<c:import url="change_locale.jsp"/>

<br>

<form>
    <input type="hidden" name="command"   value="ShowAddCompanyPage" />
    <input type="submit" value="<fmt:message key="label.addButton" bundle="${rb}" />">
</form>

<br>

<c:forEach var="userCompany" items="${userCompanyList}">
    <br><a href="${pageContext.request.contextPath}?command=CompanyDetails&companyId=${userCompany.getId()}&currentPage=0&username=${sessionScope.get("username")}">${userCompany}</a>
    <form>
        <input type="hidden" name="command"   value="DeleteUserCompany" />
        <input type="hidden" name="companyId"   value="${userCompany.getId()}" />
        <input type="hidden" name="currentPage"   value="${currentPage}" />
        <input type="submit" value="<fmt:message key="label.deleteButton" bundle="${rb}" />">
    </form>

    <form>
        <input type="hidden" name="command"   value="ShowEditUserCompanyPage" />
        <input type="hidden" name="companyId"   value="${userCompany.getId()}" />
        <input type="hidden" name="currentPage"   value="${currentPage}" />
        <input type="submit" value="<fmt:message key="label.editButton" bundle="${rb}" />">
    </form>
</c:forEach>
<br>

<mytag:formatNumber pageCount="${pageCount}" command="UserPage"/>

</body>
</html>
