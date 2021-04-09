<%--
  Created by IntelliJ IDEA.
  User: dbadu
  Date: 2021-04-03
  Time: 21:43
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><g:layoutTitle default="Visitor Tracking"/></title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="font-awesome.min.css"/>
    <asset:stylesheet src="ionicons.min.css"/>
    <asset:stylesheet src="inventory.css"/>
    <asset:stylesheet src="style.css"/>
    <asset:stylesheet src="AdminLTE.min.css"/>
    <asset:stylesheet src="blue.css"/>
    <asset:stylesheet src="skin-blue.min.css"/>
    <asset:stylesheet src="OverlayScrollbars.min.css"/>
    <asset:stylesheet src="bootstrap-datepicker.min.css"/>
    <asset:stylesheet src="select2.min.css"/>
    <asset:stylesheet src="jquery.dataTables.min.css"/>
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <g:layoutHead/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="/" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>V</b>T</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Visitor</b>Tracker</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <g:render template="/parts/header_nav"/>
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                    <asset:image src="avatar5.png" class="user-image" alt="Grails Logo"/>
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs"><sec:loggedInUserInfo field='username'/></span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <g:render template="/parts/user_menu"/>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <asset:image src="avatar5.png" class="img-circle" alt="Grails Logo"/>
                </div>
                <div class="pull-left info">
                    <p><sec:loggedInUserInfo field='username'/></p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- search form (Optional) -->
            %{--<form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
            </form>--}%
            <!-- /.search form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu" data-widget="tree">
                <g:render template="/parts/sidebar"/>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
    <g:layoutBody/>

    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
    <g:render template="/parts/footer"/>
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <g:render template="/parts/setting"/>
    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->


<asset:javascript src="jquery-3.3.1.min.js"/>
<asset:javascript src="jquery-ui.js"/>
<asset:javascript src="bootstrap.min.js"/>
<asset:javascript src="bootstrap.bundle.min.js"/>
<asset:javascript src="moment.min.js"/>
<asset:javascript src="jquery.overlayScrollbars.min.js"/>
<asset:javascript src="adminlte.min.js"/>
<asset:javascript src="select2.full.min.js"/>
<asset:javascript src="jquery.dataTables.min.js"/>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<script>
    var A_PAGE_CONTEXT_PATH = $('#contextPathHolder').attr('data-contextPath');
    var pageContext = '';
    $(document).ready(function () {
        //$('.confirmDelete').bootstrap_confirm_delete({});

        //$(".content-wrapper").attr("style" , "style='min-height: 100%;'");

        $(document).on("click" , ".treeview" , function () {
            console.log("you clicked on sidebar");
            $(".scroll-style-4").attr("style" , "height: 100%; overflow-y: scroll ;");
        });

        $('.select2').select2();

        $(function () {
            $.fn.dataTable.ext.errMode = 'none';
            $('#ajaxTable').on('error.dt', function (e, settings, techNote, message) {
                console.log('An error has been reported by DataTables: ', message);
            }).DataTable({
                "processing": true,
                "serverSide": true,
                'searching': false,
                'ordering': true,
                'lengthChange': true,
                "ajax": $('#ajaxTable').attr('url')
            });

            $('#ajaxTableFilter').on('error.dt', function (e, settings, techNote, message) {
                console.log('An error has been reported by DataTables: ', message);
            }).DataTable({
                "processing": true,
                "serverSide": true,
                'searching': true,
                'ordering': true,
                'lengthChange': true,
                "ajax": $('#ajaxTableFilter').attr('url')
            });

            $('.datepicker').datepicker({
                autoclose: true,
                todayHighlight: true
                //format : "yyyy-mm-dd"
            });

            $(".datepickermonth").datepicker( {
                autoclose: true,
                todayHighlight: true,
                minViewMode: "months"
            });

            //bootstrap WYSIHTML5 - text editor

            /*
                        //iCheck for checkbox and radio inputs
                        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
                            checkboxClass: 'icheckbox_minimal-blue',
                            radioClass: 'iradio_minimal-blue'
                        });
                        //Red color scheme for iCheck
                        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
                            checkboxClass: 'icheckbox_minimal-red',
                            radioClass: 'iradio_minimal-red'
                        });
                        //Flat red color scheme for iCheck
                        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
                            checkboxClass: 'icheckbox_flat-green',
                            radioClass: 'iradio_flat-green'
                        });*/
        });

    });
</script>

<%--for sidebar active--%>
<script>
    /** add active class and stay opened when selected */
    var url = window.location;
    console.log('this is url '+url);
    $('ul.sidebar-menu li a').each(function(){
        console.log("this is iteration "+this.href);
        if(url==this.href){
            console.log("Active menu " + this.href);
            $(this).parent().addClass('active');
        }
    });

    $('ul.treeview-menu a').each(function(){
        if(url==this.href){
            $(this).parent().addClass('active');
            $('ul.treeview-menu').parent('li').addClass('active');
        }
    });
</script>

<script>
    $(function () {
        $('#table1').DataTable();
        $('#table2').DataTable({
            'paging': false,
            'lengthChange': false,
            'searching': true,
            'ordering': true,
            'info': false,
            'autoWidth': true
        });

        $('#table3').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': true,
            'ordering': true,
            'info': false,
            'autoWidth': true
        });
    })
</script>

</body>
</html>