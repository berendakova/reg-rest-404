<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="form" type="ru.kpfu.springcontrollers.model.Form"--%>
<form:form method="post" modelAttribute="form">

    <form:label path="email">Email</form:label>
    <form:input type="email" path="email"/>
    <form:errors cssClass="text-danger" path="email"/>
    <br>

    <form:label path="password">Password</form:label>
    <form:password path="password"/>
    <form:errors cssClass=" text-danger" path="password"/>
    <br>

    <form:label path="confirmPassword">Password confirm</form:label>
    <form:password path="confirmPassword"/>
    <form:errors cssClass="text-danger" path="confirmPassword"/>
    <br>

    <form:label path="country">Country</form:label>
    <form:input type="text" path="country"/>
    <form:errors cssClass="text-danger" path="country"/>
    <br>

    <form:label path="gender">Gender</form:label>
    <form:input type="text" path="gender"/>
    <form:errors cssClass="text-danger" path="gender"/>
    <br>

    <form:label path="birthday">Birthday</form:label>
    <form:input type="text" path="birthday"/>
    <form:errors cssClass="text-danger" path="birthday"/>
    <br>

    <input class="btn btn-info" type="submit" value="Submit">
</form:form>

<c:if test="${not empty message}">
    <h1>${message}</h1>
</c:if>
</body>
</html>
