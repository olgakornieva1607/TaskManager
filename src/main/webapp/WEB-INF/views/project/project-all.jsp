<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>All projects</title>

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

                <form action="<c:url value="/logout"/>" method="post">
                    <input class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" type="submit"
                           value="Logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                </ul>

            </nav>
            <!-- End of Topbar -->
            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">TaskManager</h1>
                    <a href="<c:out value="/projects/new"/>"
                       class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                        <i class="fas fa-download fa-sm text-white-50"></i> Add new project</a>
                </div>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h5 class="m-0 font-weight-bold text-primary">List of projects</h5>
                    </div>
                    <div class="card-body">

                        <div class="table-responsive">
                            <table class="table">
                                <tr>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Start date</th>
                                    <th>End date</th>
                                </tr>
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


