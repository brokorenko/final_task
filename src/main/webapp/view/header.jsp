<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<%--
<div class="menu-list">
    <form action="FrontController">
        <input type="hidden" name="command"   value="FiltrateCompanyByType" />
        <input type="hidden" name="currentPage"   value="0" />
        <input type="hidden" name="type"   value="STO" />
        <fmt:message key="login.button.submit" var="buttonValue" />
        <button type="submit">${repiarServiceButton}</button>
    </form>
    <form action="FrontController">
        <input type="hidden" name="command"   value="FiltrateCompanyByType" />
        <input type="hidden" name="currentPage"   value="0" />
        <input type="hidden" name="type"   value="autowash" />
        <button type="submit">${washesButton}</button>
    </form>
    <form action="FrontController">
        <input type="hidden" name="command"   value="ShowLoginPage" />
        <button type="submit">${loginButton}</button>
    </form>
&lt;%&ndash;

    <form>
        <select id="language" name="language" onchange="submit()">
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
            <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
        </select>
    </form>
&ndash;%&gt;

&lt;%&ndash;    <form action="FrontController">
        <input type="hidden" name="command"   value="${commandName}" />

        <input type="hidden" name="currentPage"   value="${currentPage}" />
        <input type="hidden" name="locale"   value="EN" />
        <button type="submit">EN</button>
    </form>
    <form action="FrontController">
        <input type="hidden" name="command"   value="${commandName}" />
        <input type="hidden" name="currentPage"   value="${currentPage}" />
        <input type="hidden" name="locale"   value="RU" />
        <button type="submit">RU</button>&ndash;%&gt;
    </form>

</div>
--%>
