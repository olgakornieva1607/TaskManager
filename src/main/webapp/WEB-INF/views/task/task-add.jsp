<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <title>Add new task</title>

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

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Add new task</h1>
                </div>

                <div class="card shadow mb-4">
                    <div class="card-body">

                        <form:form action="/tasks" method="post" modelAttribute="task">

                            <label for="name">Name</label>
                            <form:input class="form-control" path="name" id="name" maxlength="50"/><br>
                            <form:errors path="name" cssClass="error" style="color: red; font-size: smaller;"/><br>

                            <label for="description">Description</label>
                            <form:textarea class="form-control" path="description" id="description"
                                           maxlength="100"/><br>
                            <form:errors path="description" cssClass="error"
                                         style="color: red; font-size: smaller;"/><br>

                            <label for="status">Status</label>
                            <form:input class="form-control" path="status" id="status"/><br>
                            <form:errors path="status" cssClass="error" style="color: red; font-size: smaller;"/><br>

                            <label for="startDate">Start Date</label>
                            <form:input class="form-control" path="startDate" id="startDate" type="date"/><br><br>

                            <label for="endDate">End Date</label>
                            <form:input class="form-control" path="endDate" id="endDate" type="date"/><br><br>

                            <form:input type="hidden" name="project.id" path="project.id" id="id"/>

                            <form:input type="hidden" name="user.id" path="user.id" id="id"/>

                            <input class="btn btn-primary" type="submit" value="Add Task">

                        </form:form>
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

