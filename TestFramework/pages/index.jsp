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
                <h4 class="page-title-main">DOCS</h4>
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
                        <div class="col-sm-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row justify-content-center">
                                        <div class="col-sm-6">
                                            <div class="text-center">
                                                <h3>Framework documentation</h3>
                                            </div>
                                        </div><!-- end col -->
                                    </div><!-- end row -->

                                    <div class="row mt-4 justify-content-center">
                                        <div class="col-xl-5">
                                            <div class="p-2">

                                                <div class="accordion custom-accordion" id="accordionExample">
                                                    <div class="card mb-2">
                                                        <div class="card-header bg-light">
                                                            <h5 class="card-title m-0">
                                                                <a href="#" class="text-dark" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                                    Web.xml
                                                                </a>
                                                            </h5>
                                                        </div>

                                                        <div id="collapseOne" class="collapse show" data-bs-parent="#accordionExample">
                                                            <div class="card-body">
                                                                <p>The path to the model classes must be specified</p>
                                                                <p>
                                                                    <pre>
                                                                        <code>
    &lt;servlet-name&gt;etu1995.framework.servlet.FrontServlet&lt;/servlet-name&gt;
    &lt;servlet-class&gt;etu1995.framework.servlet.FrontServlet&lt;/servlet-class&gt;
    &lt;init-param&gt;
        &lt;param-name&gt;path&lt;/param-name&gt;
        &lt;param-value&gt;C:\xampp\tomcat\webapps\TestFramework\WEB-INF\classes\model&lt;/param-value&gt;
    &lt;/init-param&gt;
                                                                        </code>
                                                                    </pre>
                                                                </p>
                                                                <p>The session name for authentication</p>
                                                                <p>
                                                                    <pre>
                                                                        <code>
    &lt;init-param&gt;
    &lt;param-name&gt;authentication&lt;/param-name&gt;
    &lt;param-value&gt;is_connected&lt;/param-value&gt;
    &lt;/init-param&gt;
                                                                        </code>
                                                                    </pre>
                                                                </p>
                                                                <p>The name of the session HashMap</p>
                                                                <p>
                                                                    <pre>
                                                                        <code>
    &lt;init-param&gt;
    &lt;param-name&gt;session&lt;/param-name&gt;
    &lt;param-value&gt;sessions&lt;/param-value&gt;
    &lt;/init-param&gt;
                                                                        </code>
                                                                    </pre>
                                                                </p>
                                                                <p>Every url points to FrontServlet, url must end with .do</p>
                                                                <p>
                                                                    <pre>
                                                                        <code>
    &lt;servlet-mapping&gt;
    &lt;servlet-name&gt;etu1995.framework.servlet.FrontServlet&lt;/servlet-name&gt;
    &lt;url-pattern&gt;*.do&lt;/url-pattern&gt;
    &lt;/servlet-mapping&gt;
                                                                        </code>
                                                                    </pre>
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="card mb-2">
                                                        <div class="card-header bg-light">
                                                            <h5 class="card-title m-0">
                                                                <a href="#" class="text-dark" data-bs-toggle="collapse" data-bs-target="#collapseB" aria-expanded="true" aria-controls="collapseB">
                                                                    The sessions
                                                                </a>
                                                            </h5>
                                                        </div>

                                                        <div id="collapseB" class="collapse show" data-bs-parent="#accordionExample1">
                                                            <div class="card-body">
                                                                <p>Create the session with ModelView</p>
                                                                <p>
                                                                    <pre>
                                                                        <code>
modelView.addSession(name,value);
                                                                        </code>
                                                                    </pre>
                                                                </p>
                                                                <p>Get them by adding a HashMap attribute in your class named as you specified in the web.xml, and don' t forget to annotate the method with @Session</p>
                                                                <p>
                                                                <pre>
                                                                        <code>
HashMap&lt;String,Object&gt; sessions;
                                                                        </code>
                                                                    </pre>
                                                                </p>
                                                                <p>Delete the with ModelView too</p>
                                                                <p>
                                                                <pre>
                                                                        <code>
modelView.getRemoveSessions().add(name);
modelView.setInvalidateSession(true);
                                                                        </code>
                                                                    </pre>
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- accordian end -->

                                            </div>
                                        </div>
                                        <!-- end col -->

                                        <div class="col-xl-5">
                                            <div class="p-2">
                                                <div class="accordion custom-accordion" id="accordionExample1">
                                                    <div class="card mb-2">
                                                        <div class="card-header bg-light">
                                                            <h5 class="card-title m-0">
                                                                <a href="#" class="text-dark" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
                                                                    Where to put the framework
                                                                </a>
                                                            </h5>
                                                        </div>

                                                        <div id="collapseFour" class="collapse show" data-bs-parent="#accordionExample1">
                                                            <div class="card-body">
                                                                <p>The framework.jar must be placed into the lib folder of WEB-)INF</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="card mb-2">
                                                        <div class="card-header bg-light">
                                                            <h5 class="card-title m-0">
                                                                <a href="#" class="text-dark" class="collapsed" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                                                    The FileUpload class
                                                                </a>
                                                            </h5>
                                                        </div>
                                                        <div id="collapseFive" class="collapse show" data-bs-parent="#accordionExample1">
                                                            <div class="card-body">
                                                                <p>It lets you to get uploaded files from a form</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="card mb-2">
                                                        <div class="card-header bg-light">
                                                            <h5 class="card-title m-0">
                                                                <a href="#" class="text-dark" class="collapsed" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                                                                    The Authentication functionality
                                                                </a>
                                                            </h5>
                                                        </div>
                                                        <div id="collapseSix" class="collapse show" data-bs-parent="#accordionExample1">
                                                            <div class="card-body">
                                                                <p>You can specify who can access the method</p>
                                                                <p>For example this method is only accessible for admin</p>
                                                                <p>
                                                                    <pre>
                                                                        <code>
      @MappingUrl(url = &quot;auth3.do&quot;)
      @Authentication(users = &quot;admin&quot;)
      public ModelView Auth3(){
          ModelView modelView = new ModelView(&quot;authentications/auth3.jsp&quot;);
          return modelView;
      }
                                                                        </code>
                                                                    </pre>
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="card mb-2">
                                                        <div class="card-header bg-light">
                                                            <h5 class="card-title m-0">
                                                                <a href="#" class="text-dark" class="collapsed" data-bs-toggle="collapse" data-bs-target="#collapseA" aria-expanded="false" aria-controls="collapseA">
                                                                    The RestAPI functionnality
                                                                </a>
                                                            </h5>
                                                        </div>
                                                        <div id="collapseA" class="collapse show" data-bs-parent="#accordionExample">
                                                            <div class="card-body">
                                                                <p>Output your data to json format via ModelView or @RestAPI annotation</p>
                                                                <p>
                                                                    <pre>
                                                                        <code>
@MappingUrl(url = &quot;restapi1.do&quot;)
public ModelView Rest1(){
    ModelView modelView = new ModelView();
    modelView.addItem(&quot;Balou&quot;, new Dog(&quot;Balou&quot;, 5, true));
    modelView.setJson(true);
    return modelView;
}

@MappingUrl(url = &quot;restapi2.do&quot;)
@RestAPI
public String[] Rest2(){
    return new String[]{
            &quot;Balou&quot;,
            &quot;Kalou&quot;,
            &quot;Jalou&quot;
    };
}
                                                                        </code>
                                                                    </pre>
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- accordian end -->
                                            </div>
                                        </div>
                                        <!-- end col -->
                                    </div>
                                    <!-- end row -->


                                </div>
                            </div>

                        </div><!-- end col -->
                    </div>
                    <!-- end row -->

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

    <style>
        .tabu {
            text-indent: 20px;
        }
    </style>
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

<script>

</script>

</body>

<!-- Mirrored from coderthemes.com/adminto/layouts/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 03 Jul 2023 11:08:48 GMT -->
</html>