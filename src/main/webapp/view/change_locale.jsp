<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="FrontController">
    <input type="hidden" name="command"   value="${commandName}" />
    <c:if test="${currentPage != null}">
        <input type="hidden" name="currentPage"   value="${currentPage}" />
    </c:if>
    <c:if test="${companyId != null}">
        <input type="hidden" name="companyId"   value="${companyId}" />
    </c:if>
    <input type="hidden" name="locale"   value="en_US" />
    <button type="submit" <c:if test="${locale eq 'en_US'}">disabled</c:if>>EN</button>
</form>
<form action="FrontController">
    <input type="hidden" name="command"   value="${commandName}" />
    <c:if test="${currentPage != null}">
        <input type="hidden" name="currentPage"   value="${currentPage}" />
    </c:if>
    <c:if test="${companyId != null}">
        <input type="hidden" name="companyId"   value="${companyId}" />
    </c:if>
    <input type="hidden" name="locale"   value="ru_RU" />
    <button type="submit" <c:if test="${locale eq 'ru_RU'}">disabled</c:if>>RU</button>
</form>
