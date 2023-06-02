<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>Project's details</title>
</head>

<%@ include file="/header.jsp" %>
<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
        <!-- Divider -->
        <hr class="sidebar-divider my-0">
    </ul>

    <!-- End of Sidebar -->
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <div>
                            <form action="<c:out value="/projects/all"/>">
                                <input class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit"
                                       value="Home">
                            </form>
                        </div>
                        <div>
                            <form action="<c:url value="/logout"/>" method="post">
                                <input class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit"
                                       value="Logout">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </div>
                    </div>
                </div>
            </nav>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h4 class="h4 mb-0 text-gray-800"><c:out value="${project.name}"/></h4>
                    <h4 class="h4 mb-0 text-gray-800"><c:out value="${project.description}"/></h4>
                    <h4 class="h4 mb-0 text-gray-800"><c:out value="${project.startDate}"/></h4>
                    <h4 class="h4 mb-0 text-gray-800"><c:out value="${project.endDate}"/></h4>

                    <a href="<c:out value="/tasks/${project.id}/new"/>"
                       class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                        <i class="fas fa-download fa-sm text-white-50"></i> Add new task</a>
                </div>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h5 class="m-0 font-weight-bold text-primary">List of tasks</h5>
                    </div>
                    <div class="card-body">

                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Start date</th>
                                <th>End date</th>
                                <th>Status</th>
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
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->
    </div>
</div>
<!-- End of Main Content -->

</body>
</html>





