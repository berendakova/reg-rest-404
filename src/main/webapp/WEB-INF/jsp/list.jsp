<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <c:if test="${not empty users}">
        <c:forEach var="user" items="${users}" varStatus="counter">
            <h1>${user.email}</h1>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
