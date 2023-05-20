<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>Registration page</title>
    <style>
        .error{
            color:red;
        }
    </style>
</head>

<body>

<form:form action="/registration" method="post" modelAttribute="user">

    <label for="username">Enter username</label>
    <form:input path="username" id="username" maxlength="20"/><br>
    <form:errors path="username" cssClass="error" /><br>

    <label for="password">Enter password</label>
    <form:password path="password" id="password" maxlength="20"/><br>
    <form:errors path="password" cssClass="error" /><br>


    <input type="submit" value="Sign up">

</form:form>

</body>
</html>


