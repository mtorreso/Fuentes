<%@page import="webservice.Usuario"%>
<%@page import="webservice.Localidad"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Modelo.*" %>
<%@page import="java.util.List"%>
<%@page import="webservice.Departamento"%>
<%@page import="Modelo.DepartamentoService"%>
<!DOCTYPE html>
<%
    //obtenemos la sesion del usuario
    HttpSession sesion = request.getSession();
    //preguntamo por la variable de sesion creada en el servlet
    if ((sesion.getAttribute("logeado") == null
            || (Boolean) sesion.getAttribute("logeado") != true) && sesion.getAttribute("tipo") != "Administrador del Sistema") {
        //si es nula o vale false.... redirijo al usuario hacia la pagina de Login
        out.print("<script>alert('Para entrar a esta página debes estar logueado como Administrador del Sistema'); window.history.back(-1);</script>");
        response.sendRedirect("index.jsp");
    }
%>
<html lang="en">
    <head>
        <title>Portafolio de Título | Turismo Real </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!--usuarios!!-->
        <link type="text/css" rel="stylesheet" href="turismo/css/bootstrap.min.css">
        <link href='https://fonts.googleapis.com/css?family=Hind:400,300,500,600%7cMontserrat:400,700' rel='stylesheet'>
        <link href="https://fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.css">
        <!--  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.20/af-2.3.4/b-1.6.1/b-colvis-1.6.1/b-flash-1.6.1/b-html5-1.6.1/b-print-1.6.1/cr-1.5.2/fc-3.3.0/fh-3.1.6/kt-2.5.1/r-2.2.3/rg-1.1.1/rr-1.2.6/sc-2.0.1/sl-1.3.1/datatables.min.css"/>!-->
        <!-- js-!--->

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>

        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.20/af-2.3.4/b-1.6.1/b-colvis-1.6.1/b-flash-1.6.1/b-html5-1.6.1/b-print-1.6.1/cr-1.5.2/fc-3.3.0/fh-3.1.6/kt-2.5.1/r-2.2.3/rg-1.1.1/rr-1.2.6/sc-2.0.1/sl-1.3.1/datatables.min.js"></script>
        <link rel="stylesheet" href="css/tablas.css">

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


        <script src="cssadmin/js/ie/html5shiv.js"></script>
        <script src="cssadmin/js/ie/respond.min.js"></script>
        <script src="cssadmin/js/ie/excanvas.js"></script>


        <!--tablas nuevas!-->

        <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="docsupport/prism.css">
        <link rel="stylesheet" href="chosen.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/admin.css">
    </head>
    <body>

        <nav class="navbar navbar-inverse navbar-expand-xl navbar-dark">
            <div class="navbar-header d-flex col">
                <a class="navbar-brand" href="indexadmin.jsp"><i class="fa fa-briefcase"></i>Turismo <b> Real</b></a>  		
                <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto">
                    <span class="navbar-toggler-icon"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- Collection of nav links, forms, and other content for toggling -->
            <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">		
                <form class="navbar-form form-inline">
                    <div class="input-group search-box">								

                        <select data-placeholder="Seleccionar Comuna..." class="form-control chosen-select" multiple tabindex="4" wrap-price>
                            <option>Seleccionar Comuna</option>
                            <%
                                LocalidadService loc = new LocalidadService();
                                List<Localidad> datos = loc.listarLocalidades();
                                for (Localidad d : datos) {
                            %>
                            <option value="<%= d.getNombreLocalidad()%>"><%= d.getNombreLocalidad()%></option>  
                            <%}%>
                        </select>
                    </div>
                </form>
                <ul class="nav navbar-nav navbar-right ml-auto">
                    <li class="nav-item "><a href="indexadmin.jsp" class="nav-link"><i class="fa fa-home"></i><span>Home</span></a></li>
                    <li class="nav-item"><a href="Usuarios.jsp" class="nav-link"><i class="fa fa-user-o"></i><span>Usuarios</span></a></li>
                    <li class="nav-item"><a href="Clientes.jsp" class="nav-link"><i class="fa fa-users"></i><span>Clientes</span></a></li>
                    <li class="nav-item "><a href="departamentos.jsp" class="nav-link"><i class="fa fa-building"></i><span>Departamentos</span></a></li>
                    <li class="nav-item"><a href="reportes.jsp" class="nav-link"><i class="fa fa-pie-chart"></i><span>Reportes</span></a></li>
                    <li class="nav-item dropdown active">
                        <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle user-action"><img src="images/avatar_default.jpg" class="avatar" alt="Avatar">  <%
                            //preguntamo por la variable de sesion creada en el servlet
                            if (sesion.getAttribute("nombre") != null) {
                                out.print(sesion.getAttribute("nombre"));
                            }
                            %><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="MisDatosAdmin.jsp" class="dropdown-item active"><i class="fa fa-user-o"></i>Mi Cuenta</a></li>
                            <li class="divider dropdown-divider"></li>
                            <li><a href="Logout" class="dropdown-item"><i class="material-icons">&#xE8AC;</i> Cerrar Sesión</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>


        <c:if test="${requestScope.error!=null}">
            <script>alert('<c:out value="${requestScope.error}"/>');</script>
        </c:if>
        <c:if test="${requestScope.msg!=null}">
            <script>alert('<c:out value="${requestScope.msg}"/>');</script>
        </c:if>

        <div class="container">
            <div class="col-md-12">
                <!-- breadcrumbs --> 
                <ol class="breadcrumb breadcrumb1">
                    <li><a href="indexadmin.jsp">Home</a></li>
                    <li class="active">Mi Cuenta</li>
                </ol> 
            </div>
        </div>
        <!--inicio!-->

        <div class="container bootstrap snippet">
            <div class="row ng-scope">
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-body text-center">
                            <div class="pv-lg"><img class="center-block img-responsive img-circle img-thumbnail thumb96" src="images/avatar_default.jpg" alt="Contact"></div>
                            <h3 class="m0 text-bold"><%
                                //preguntamo por la variable de sesion creada en el servlet
                                if (sesion.getAttribute("nombre") != null) {
                                    out.print(sesion.getAttribute("nombre"));
                                }
                                %></h3>
                            <div class="mv-lg">
                                <p><%
                                    //preguntamo por la variable de sesion creada en el servlet
                                    if (sesion.getAttribute("rut") != null) {
                                        out.print(sesion.getAttribute("rut"));
                                    }
                                    %></p>
                                <p> <%
                                    //preguntamo por la variable de sesion creada en el servlet
                                    if (sesion.getAttribute("email") != null) {
                                        out.print(sesion.getAttribute("email"));
                                    }
                                    %></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="pull-right">
                                <div class="btn-group dropdown" uib-dropdown="dropdown">
                                    <button class="btn btn-link dropdown-toggle" uib-dropdown-toggle="" aria-haspopup="true" aria-expanded="false"><em class="fa fa-ellipsis-v fa-lg text-muted"></em></button>
                                    <ul class="dropdown-menu dropdown-menu-right animated fadeInLeft" role="menu">                                                                          </ul>
                                </div>
                            </div>
                            <div class="h3 text-center">Mi Cuenta</div>
                            <hr>
                            <div class="row pv-lg">
                                <div class="col-lg-2"></div>
                                <div class="col-lg-8">

                                    <form class="form-horizontal ng-pristine ng-valid">


                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="inputContact5">Rut</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" id="inputContact5" type="text" value="<%
                                                    //preguntamo por la variable de sesion creada en el servlet
                                                    if (sesion.getAttribute("rut") != null) {
                                                        out.print(sesion.getAttribute("rut"));
                                                    }
                                                       %>" readonly="">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="inputContact6">Nombre</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" id="inputContact7" type="text" value="<%
                                                    //preguntamo por la variable de sesion creada en el servlet
                                                    if (sesion.getAttribute("nombre") != null) {
                                                        out.print(sesion.getAttribute("nombre"));
                                                    }
                                                    %>" >
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="inputContact7">Email</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" id="inputContact7" type="text" value="<%
                                                    //preguntamo por la variable de sesion creada en el servlet
                                                    if (sesion.getAttribute("email") != null) {
                                                        out.print(sesion.getAttribute("email"));
                                                    }
                                                       %>">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="inputContact8">Rol</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" id="inputContact8" type="text" placeholder="No Company" value="<%
                                                    //preguntamo por la variable de sesion creada en el servlet
                                                    if (sesion.getAttribute("tipo") != null) {
                                                        out.print(sesion.getAttribute("tipo"));
                                                    }
                                                       %>"readonly="">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="inputContact8">Contraseña</label>
                                            <div class="col-sm-10">
                                                <input class="form-control" id="inputContact8" type="password" placeholder="" value="">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button class="btn btn-primary active" type="submit">Actualizar Perfil</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--fin!-->
        

        <div class="products">	 
            <div class="clearfix"> </div>
        </div>
        <!-- //footer -->
        <div class="copy-right"> 
            <div class="container">
                <p>© 2019 Turismo Real | Portafolio de Titulo DUOCUC</p>
            </div>
        </div> 
        <script src="js/chosen.jquery.js" type="text/javascript"></script>
        <script src="docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
        <script src="docsupport/init.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/jquery.menu-aim.js"></script>
        <script src="js/main.js"></script> <!-- Resource jQuery -->

        <script src="js/bootstrap.js"></script>

    </body>
</html>