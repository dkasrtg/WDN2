<%@ page import="etu1995.framework.FileUpload" %>
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
                <h4 class="page-title-main">FORM DATA</h4>
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
                                <div class="responsive-table-plugin">
                                    <div class="table-rep-plugin">
                                        <div class="table-responsive" data-pattern="priority-columns">
                                            <table id="tech-companies-1" class="table table-striped">
                                                <thead>
                                                <tr>
                                                    <th>Parameters</th>
                                                    <th data-priority="1">Values</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>Text</td>
                                                    <td><%= request.getAttribute("text") %></td>
                                                </tr>
                                                <tr>
                                                    <td>Mail</td>
                                                    <td><%= request.getAttribute("mail") %></td>
                                                </tr>
                                                <tr>
                                                    <td>Password</td>
                                                    <td><%= request.getAttribute("password") %></td>
                                                </tr>
                                                <tr>
                                                    <td>Textarea</td>
                                                    <td><%= request.getAttribute("textarea") %></td>
                                                </tr>
                                                <tr>
                                                    <td>Checkbox</td>
                                                    <td><% String[] checkboxes = (String[]) request.getAttribute("checkbox") ;
                                                        for (int i = 0; i < checkboxes.length; i++) {
                                                            out.print(checkboxes[i]+" - ");
                                                        }
                                                    %></td>
                                                </tr>
                                                <tr>
                                                    <td>Radio</td>
                                                    <td><%= request.getAttribute("radio") %></td>
                                                </tr>
                                                <tr>
                                                    <td>Select</td>
                                                    <td><%= request.getAttribute("select") %></td>
                                                </tr>
                                                <tr>
                                                    <td>File</td>
                                                    <td><% FileUpload fileUpload = (FileUpload) request.getAttribute("file");
                                                    out.print(fileUpload.getName());
                                                    %></td>
                                                </tr>
                                                <tr>
                                                    <td>Text</td>
                                                    <td><% FileUpload[] fileUploads = (FileUpload[]) request.getAttribute("files");
                                                        for (int i = 0; i < fileUploads.length; i++) {
                                                            out.print(fileUploads[i].getName()+" - ");
                                                        }
                                                    %></td>
                                                </tr>
                                                <tr>
                                                    <td>Date</td>
                                                    <td><%= request.getAttribute("date") %></td>
                                                </tr>
                                                <tr>
                                                    <td>Number</td>
                                                    <td><%= request.getAttribute("number") %></td>
                                                </tr>
                                                <tr>
                                                    <td>Color</td>
                                                    <td><%= request.getAttribute("color") %></td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div> <!-- end .table-responsive -->

                                    </div> <!-- end .table-rep-plugin-->
                                </div> <!-- end .responsive-table-plugin-->
                            </div>
                        </div> <!-- end card -->
                    </div> <!-- end col -->
                </div>
                <!-- end row -->

            </div> <!-- container -->

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