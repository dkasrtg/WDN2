<%@ page import="java.util.Vector" %>
<%@ page import="model.entity.Dog" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from coderthemes.com/adminto/layouts/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 03 Jul 2023 11:06:38 GMT -->
<head>

    <meta charset="utf-8" />
    <title>Dashboard | Adminto - Responsive Admin Dashboard Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
    <meta content="Coderthemes" name="author" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- App favicon -->
    <link rel="shortcut icon" href="/TestFramework/assets/images/favicon.ico">

    <!-- App css -->

    <link href="/TestFramework/assets/css/app.min.css" rel="stylesheet" type="text/css" id="app-style" />

    <!-- icons -->
    <link href="/TestFramework/assets/css/icons.min.css" rel="stylesheet" type="text/css" />

</head>

<!-- body start -->
<body class="loading" data-layout-color="light"  data-layout-mode="default" data-layout-size="fluid" data-topbar-color="light" data-leftbar-position="fixed" data-leftbar-color="light" data-leftbar-size='default' data-sidebar-user='true'>

<!-- Begin page -->
<div id="wrapper">


    <!-- Topbar Start -->
    <div class="navbar-custom">
        <ul class="list-unstyled topnav-menu float-end mb-0">


        </ul>

        <!-- LOGO -->
        <div class="logo-box">

        </div>

        <ul class="list-unstyled topnav-menu topnav-menu-left mb-0">
            <li>
                <button class="button-menu-mobile disable-btn waves-effect">
                    <i class="fe-menu"></i>
                </button>
            </li>

            <li>
                <h4 class="page-title-main">CRUD EXAMPLE</h4>
            </li>

        </ul>

        <div class="clearfix"></div>

    </div>
    <!-- end Topbar -->
    <%@ include file="fragments/sidebar.jsp"%>


    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="mt-0 header-title">Dog List</h4>
                                <p class="text-muted font-14">
                                    <a href="/TestFramework/session_delete_all.do"><i class="fa fa-trash"></i> Delete all</a>
                                </p>
                                <table id="datatable" class="table table-bordered dt-responsive table-responsive nowrap">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Age</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>


                                    <tbody>

                                    <%
                                        Vector<Dog> dogs = (Vector<Dog>) request.getAttribute("list");
                                        for (int i = 0; i < dogs.size(); i++) {
                                            out.print("<tr><td>"+i+"</td>\n" +
                                                    "<td>"+dogs.get(i).getName()+"</td>\n" +
                                                    "<td>"+dogs.get(i).getAge()+"</td>\n" +
                                                    "<td><a href=\"/TestFramework/crud_delete.do?index="+i+"\"><i class=\"fa fa-trash\"></i></a> <a href=\"/TestFramework/crud_update.do?index="+i+"\"><i class=\"fas fa-edit\"></i></a> </td></tr>");
                                        }
                                    %>


                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div> <!-- end row -->
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title">New Dog</h4>
                                <form id="demo-form" data-parsley-validate="" action="/TestFramework/crud_create.do" method="get">
                                    <div class="mb-3">
                                        <label for="fullname" class="form-label">Name :</label>
                                        <input required type="text" class="form-control" name="name" id="fullname" required="">
                                    </div>

                                    <div class="mb-3">
                                        <label for="email" class="form-label">Age :</label>
                                        <input required type="number" id="email" class="form-control" name="age" data-parsley-trigger="change" required="">
                                    </div>
                                    <div>
                                        <input type="submit" class="btn btn-success" value="Validate">
                                    </div>

                                </form>
                            </div>
                        </div> <!-- end card-->
                    </div> <!-- end col-->
                </div>

            </div> <!-- container-fluid -->

        </div> <!-- content -->

        <!-- Footer Start -->
        <footer class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6">
                        2023 &copy; TestFramework
                    </div>
                </div>
            </div>
        </footer>
        <!-- end Footer -->

    </div>
    <!-- ============================================================== -->
    <!-- End Page content -->
    <!-- ============================================================== -->
    <%@ include file="fragments/sidebar.jsp"%>

    <!-- Vendor -->
    <script src="/TestFramework/assets/libs/jquery/jquery.min.js"></script>
    <script src="/TestFramework/assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/TestFramework/assets/libs/simplebar/simplebar.min.js"></script>
    <script src="/TestFramework/assets/libs/node-waves/waves.min.js"></script>
    <script src="/TestFramework/assets/libs/waypoints/lib/jquery.waypoints.min.js"></script>
    <script src="/TestFramework/assets/libs/jquery.counterup/jquery.counterup.min.js"></script>
    <script src="/TestFramework/assets/libs/feather-icons/feather.min.js"></script>

    <!-- knob plugin -->
    <script src="/TestFramework/assets/libs/jquery-knob/jquery.knob.min.js"></script>

    <!--Morris Chart-->
    <script src="/TestFramework/assets/libs/morris.js06/morris.min.js"></script>
    <script src="/TestFramework/assets/libs/raphael/raphael.min.js"></script>

    <!-- Dashboar init js-->
    <script src="/TestFramework/assets/js/pages/dashboard.init.js"></script>

    <!-- App js-->
    <script src="/TestFramework/assets/js/app.min.js"></script>

</body>

<!-- Mirrored from coderthemes.com/adminto/layouts/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 03 Jul 2023 11:08:48 GMT -->
</html>