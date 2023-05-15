<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Project details</title>
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
        </td>
    </tr>

    </tbody>
</table>
</body>
</html>