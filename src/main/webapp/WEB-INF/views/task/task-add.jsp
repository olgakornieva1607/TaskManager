<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add new task</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h3>Add New Task</h3>

<form:form action="/tasks" method="post" modelAttribute="task" >

    <label for="name">Name</label>
    <form:input path="name" id="name" maxlength="50"/><br>
    <form:errors path="name" cssClass="error" /><br>

    <label for="description">Description</label>
    <form:textarea path="description" id="description" maxlength="100"/><br>
    <form:errors path="description" cssClass="error" /><br>

    <label for="status">Status</label>
    <form:input path="status" id="status" /><br>
    <form:errors path="status" cssClass="error" /><br>

    <label for="startDate">Start Date</label>
    <form:input path="startDate" id="startDate" type="date" /><br><br>

    <label for="endDate">End Date</label>
    <form:input path="endDate" id="endDate" type="date" /><br><br>

    <form:input type="hidden" name="project.id" path="project.id" id="id" />

    <form:input type="hidden" name="user.id" path="user.id" id="id" />

    <input type="submit" value="Add Task" />
</form:form>
</body>
</html>

