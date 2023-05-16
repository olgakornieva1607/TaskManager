<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>Edit project</title>
    <style>
        .error{
            color:red;
        }
    </style>
</head>

<body>

<form:form action="/projects" method="put" modelAttribute="projectToEdit">

    <form:input type="hidden" name="id" path="id" id="id" />

    <label for="name">Name</label>
    <form:input path="name" id="name" maxlength="20"/><br>
    <form:errors path="name" cssClass="error" /><br>

    <label for="description">Description</label>
    <form:textarea path="description" id="description" maxlength="100"/><br>
    <form:errors path="description" cssClass="error" /><br>


    <label for="startDate">Start date</label>
    <form:input path="startDate" id="startDate" type="date" /><br><br>

    <label for="endDate">End date</label>
    <form:input path="endDate" id="endDate" type="date" /><br>

    <input type="hidden" name="userId" value="${user.id}">

    <input type="submit" value="Save">

</form:form>

</body>
</html>
