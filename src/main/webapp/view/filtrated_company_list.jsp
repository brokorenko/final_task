<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/taglib.tld" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<c:import url="header.jsp"/>--%>
<c:forEach var="coordinate" items="${coordinates}">
    <br><a href="${pageContext.request.contextPath}?command=CompanyDetails&companyId=${coordinate.getId()}&currentPage=0">${coordinate}</a>
</c:forEach>
<br>

<mytag:formatNumber pageCount="${pageCount}" command="FiltrateCompanyByType" type = "${type}"/>


</body>
</html>
