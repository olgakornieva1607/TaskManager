<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit task</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<form:form action="/tasks" method="put" modelAttribute="taskToEdit">

    <form:input type="hidden" name="id" path="id" id="id" />

    <label for="name">Name</label>
    <form:input path="name" id="name" maxlength="50"/><br>
    <form:errors path="name" cssClass="error" /><br>

    <label for="description">Description</label>
    <form:textarea path="description" id="description" maxlength="200"/><br>
    <form:errors path="description" cssClass="error" /><br>

    <label for="status">Status</label>
    <form:input path="status" id="status" /><br>
    <form:errors path="status" cssClass="error" /><br>

    <label for="startDate">Start Date</label>
    <form:input path="startDate" id="startDate" type="date" /><br><br>

    <label for="endDate">End Date</label>
    <form:input path="endDate" id="endDate" type="date" /><br><br>

    <form:input type="hidden" name="project.id" path="project.id" id="project.id" />

    <input type="submit" value="Save">

</form:form>

</body>
</html>