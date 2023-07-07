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
                <h4 class="page-title-main">FORM</h4>
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
                <form action="/TestFramework/formdata.do" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">

                                <div class="row">
                                    <div class="col-lg-6">


                                            <div class="mb-3">
                                                <label for="simpleinput" class="form-label">Text</label>
                                                <input required type="text" id="simpleinput" name="text" class="form-control">
                                            </div>

                                            <div class="mb-3">
                                                <label for="example-email" class="form-label">Email</label>
                                                <input required type="email" id="example-email" name="mail" class="form-control" placeholder="Email">
                                            </div>

                                            <div class="mb-3">
                                                <label for="example-password" class="form-label">Password</label>
                                                <input required type="password" id="example-password" name="password" class="form-control" value="password">
                                            </div>

                                            <div class="mb-3">
                                                <label for="example-textarea" class="form-label">Text area</label>
                                                <textarea class="form-control" id="example-textarea" name="textarea" rows="5"></textarea>
                                            </div>

                                            <div class="col-md-6">
                                                <h4 class="header-title mt-5 mt-sm-0">Checkboxes and radios</h4>
                                                <div class="mt-3">
                                                    <div class="form-check">
                                                        <input required type="checkbox" class="form-check-input" id="customCheck1" name="checkbox[]" value="Checkbox1">
                                                        <label class="form-check-label" for="customCheck1">Checkbox1</label>
                                                    </div>
                                                    <div class="form-check">
                                                        <input required type="checkbox" class="form-check-input" id="customCheck2" name="checkbox[]" value="Checkbox2">
                                                        <label class="form-check-label" for="customCheck2">Checkbox2</label>
                                                    </div>
                                                    <div class="form-check">
                                                        <input required type="checkbox" class="form-check-input" id="customCheck3" name="checkbox[]" value="Checkbox3">
                                                        <label class="form-check-label" for="customCheck3">Checkbox3</label>
                                                    </div>
                                                </div>
                                                <div class="mt-3">
                                                    <div class="form-check">
                                                        <input required type="radio" id="customRadio1" name="radio" class="form-check-input" value="Radio1">
                                                        <label class="form-check-label" for="customRadio1">Radio1</label>
                                                    </div>
                                                    <div class="form-check">
                                                        <input required type="radio" id="customRadio2" name="radio" class="form-check-input" value="Radio2">
                                                        <label class="form-check-label" for="customRadio2">Radio2</label>
                                                    </div>
                                                </div>
                                            </div> <!-- end col -->

                                    </div> <!-- end col -->

                                    <div class="col-lg-6">

                                            <div class="mb-3">
                                                <label for="example-select" class="form-label">Input Select</label>
                                                <select class="form-select" id="example-select" name="select">
                                                    <option value="Select1">Select1</option>
                                                    <option value="Select2">Select2</option>
                                                    <option value="Select3">Select3</option>
                                                    <option value="Select4">Select4</option>
                                                    <option value="Select5">Select5</option>
                                                </select>
                                            </div>

                                            <div class="mb-3">
                                                <label for="example-fileinput" class="form-label">File input</label>
                                                <input required type="file" id="example-fileinput" class="form-control" name="file">
                                            </div>

                                            <div class="mb-3">
                                                <label for="example-fileinput2" class="form-label">Files input</label>
                                                <input required type="file" id="example-fileinput2" class="form-control" name="files" multiple>
                                            </div>

                                            <div class="mb-3">
                                                <label for="example-month" class="form-label">Date</label>
                                                <input required class="form-control" id="example-month" type="date" name="date">
                                            </div>

                                            <div class="mb-3">
                                                <label for="example-number" class="form-label">Number</label>
                                                <input required class="form-control" id="example-number" type="number" name="number">
                                            </div>

                                            <div class="mb-3">
                                                <label for="example-color" class="form-label">Color</label>
                                                <input required class="form-control" id="example-color" type="color" name="color" value="#71b6f9">
                                            </div>

                                            <div class="mb-3">
                                                <button class="btn btn-primary" type="submit">Submit form</button>
                                            </div>

                                    </div> <!-- end col -->
                                </div>
                                <!-- end row-->

                            </div> <!-- end card-body -->
                        </div> <!-- end card -->
                    </div><!-- end col -->
                </div>
                <!-- end row -->
                </form>

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