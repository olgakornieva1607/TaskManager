<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE>
<html>
<head>
    <title>List of projects</title>
</head>
<body>

<a href="<c:out value="/projects/new"/>">Add new project</a>
<br><br>
<table border="1">
    <thead>
    <th>name</th>
    <th>description</th>
    <th>start date</th>
    <th>end date</th>
    </thead>
    <tbody>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td><c:out value="${project.name}"/></td>
            <td><c:out value="${project.description}"/></td>
            <td><c:out value="${project.startDate}"/></td>
            <td><c:out value="${project.endDate}"/></td>
            <td>
                <a href="<c:out value="/projects/${project.id}/details"/>">Show tasks</a>
                <a href="<c:out value="/projects/${project.id}/edit"/>">Edit</a>
                <a href="<c:out value="/projects/${project.id}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br><br>
<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="Logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>
