<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Project's details</title>
</head>
<body>
<table border="1">
    <th>name</th>
    <th>description</th>
    <th>start date</th>
    <th>end date</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${project.name}"/></td>
        <td><c:out value="${project.description}"/></td>
        <td><c:out value="${project.startDate}"/></td>
        <td><c:out value="${project.endDate}"/></td>

    </tr>

    </tbody>
</table>


<br>
<a href="<c:out value="/projects/all"/>">Go to all projects</a>
<br>
<h3>Tasks</h3>

<a href="<c:out value="/tasks/${project.id}/new"/>">Add new task</a>
<br><br>
<table border="1">
    <thead>
    <th>name</th>
    <th>description</th>
    <th>start date</th>
    <th>end date</th>
    <th>status</th>
    </thead>
    <tbody>

    <c:forEach items="${tasks}" var="task">
    <tr>
        <td><c:out value="${task.name}"/></td>
        <td><c:out value="${task.description}"/></td>
        <td><c:out value="${task.startDate}"/></td>
        <td><c:out value="${task.endDate}"/></td>
        <td><c:out value="${task.status}"/></td>
        <td>
            <a href="<c:out value="/tasks/${task.id}/edit"/>">Edit</a>
            <a href="<c:out value="/tasks/${task.id}"/>">Delete</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>