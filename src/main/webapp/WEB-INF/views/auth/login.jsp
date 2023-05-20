<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login page</title>
</head>
<body>


<c:if test="${param.error != null}">
    <div style="color: red;">Incorrect login details</div>
</c:if>
<form method="post" action="/process_login">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<br>
<a href="<c:out value="/registration"/>">Sign up</a>
<br>

</body>
</html>
