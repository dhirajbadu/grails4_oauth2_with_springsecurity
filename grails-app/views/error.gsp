<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Error</title>
    <!-- Tell the browser to be responsive to screen width -->
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="AdminLTE.min.css"/>
    <asset:stylesheet src="font-awesome.min.css"/>
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
    <body>

    <div class="container">
        <div style="display: none">
            <g:if env="development">
                <g:if test="${Throwable.isInstance(exception)}">
                    <g:renderException exception="${exception}" />
                </g:if>
                <g:elseif test="${request.getAttribute('javax.servlet.error.exception')}">
                    <g:renderException exception="${request.getAttribute('javax.servlet.error.exception')}" />
                </g:elseif>
                <g:else>
                    <ul class="errors">
                        <li>An error has occurred</li>
                        <li>Exception: ${exception}</li>
                        <li>Message: ${message}</li>
                        <li>Path: ${path}</li>
                    </ul>
                </g:else>
            </g:if>
            <g:else>
                <ul class="errors">
                    <li>An error has occurred</li>
                </ul>
            </g:else>
        </div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>500 Error Page</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="${createLink(controller: 'home' ,  action: 'index')}">Home</a></li>
                            <li class="breadcrumb-item active">500 Error Page</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="error-page">
                <h2 class="headline text-danger">500</h2>

                <div class="error-content">
                    <h3><i class="fas fa-exclamation-triangle text-danger"></i> Oops! Something went wrong.</h3>

                    <p>
                        We will work on fixing that right away.
                        Meanwhile, you may <a href="${createLink(controller: 'home' ,  action: 'index')}">return to dashboard</a> or try using the search form.
                    </p>

%{--                    <form class="search-form">--}%
%{--                        <div class="input-group">--}%
%{--                            <input type="text" name="search" class="form-control" placeholder="Search">--}%

%{--                            <div class="input-group-append">--}%
%{--                                <button type="submit" name="submit" class="btn btn-danger"><i class="fas fa-search"></i>--}%
%{--                                </button>--}%
%{--                            </div>--}%
%{--                        </div>--}%
%{--                        <!-- /.input-group -->--}%
%{--                    </form>--}%
                </div>
            </div>
            <!-- /.error-page -->

        </section>
        <!-- /.content -->
    </div>

    </body>
</html>
