<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/taglib.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

${company}
<c:forEach var="feedback" items="${feedbacks}">
    <br>${feedback}
</c:forEach>
<br>

<mytag:formatNumber pageCount="${pageCount}" command="CompanyDetails"/>

</body>
</html>
