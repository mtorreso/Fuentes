<%@page import="webservice.Localidad"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.LocalidadService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Turismo Real - Portafolio de Titulo</title>


        <!-- End plugin css for this page -->

        <link rel="stylesheet" href="css/materialdesignicons.min.css">
        <link rel="stylesheet" href="css/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- Plugin css for this page -->
        <link rel="stylesheet" href="css/flag-icon.min.css">
        <link rel="stylesheet" href="css/jquery-jvectormap.css">
        <!-- End plugin css for this page -->
        <!-- Layout styles -->
        <link rel="stylesheet" href="css/style_2.css">
        <!-- End layout styles -->
        <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="docsupport/prism.css">
        <link rel="stylesheet" href="chosen.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/admin.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <c:choose>
            <c:when test="${requestScope.msg =='1'}">
                <script>swal("Bienvenido!", "<%
                    //preguntamo por la variable de sesion creada en el servlet
                    if (sesion.getAttribute("nombre") != null) {
                        out.print(sesion.getAttribute("nombre"));
                    }
                    %> !", "success");</script>
                </c:when>
                <c:when test="${requestScope.msg !=null}">
                <script>alert('<c:out value="${requestScope.msg}"/>');</script>
            </c:when>
        </c:choose>
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

                <ul class="nav navbar-nav navbar-right ml-auto">
                    <li class="nav-item active"><a href="indexadmin.jsp" class="nav-link"><i class="fa fa-home"></i><span>Home</span></a></li>
                    <li class="nav-item"><a href="Usuarios.jsp" class="nav-link"><i class="fa fa-user-o"></i><span>Usuarios</span></a></li>
                    <li class="nav-item"><a href="Clientes.jsp" class="nav-link"><i class="fa fa-users"></i><span>Clientes</span></a></li>
                    <li class="nav-item"><a href="departamentos.jsp" class="nav-link"><i class="fa fa-building"></i><span>Departamentos</span></a></li>
                    <li class="nav-item"><a href="solicitudestransporte.jsp" class="nav-link"><i class="fa fa-bus"></i><span>Planificar Transporte</span></a></li>
                    <li class="nav-item"><a href="reportes.jsp" class="nav-link"><i class="fa fa-pie-chart"></i><span>Reportes</span></a></li>
                    <li class="nav-item dropdown">
                        <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle user-action"><img src="images/avatar_default.jpg" class="avatar" alt="Avatar">  <%
                            //preguntamo por la variable de sesion creada en el servlet
                            if (sesion.getAttribute("nombre") != null) {
                                out.print(sesion.getAttribute("nombre"));
                            }
                            %><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="MisDatosAdmin.jsp" class="dropdown-item"><i class="fa fa-user-o"></i>Mi Cuenta</a></li>
                            <li class="divider dropdown-divider"></li>
                            <li><a href="Logout" class="dropdown-item"><i class="material-icons">&#xE8AC;</i> Cerrar Sesión</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>        


        <div class="container">
            <div class="col-md-12">
                <!-- breadcrumbs --> 
                <ol class="breadcrumb breadcrumb1">
                    <li><a href="indexadmin.jsp">Home</a></li>
                    <li class="active">Actualizar Cuentas</li>
                </ol> 
            </div>
            <hr />
            <div class="row">
                <div class="col-sm-9 col-md-10">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#home" data-toggle="tab"><span class="glyphicon glyphicon-book">
                                </span>Actualizar Datos Cuentas</a></li>

                    </ul>
                    <%
                        if (request.getParameter("rut") != null
                                && request.getParameter("nombre") != null
                                && request.getParameter("correo") != null
                                && request.getParameter("telefono") != null) {
                            out.print("<form class='' id='Formulario' role='form' action='ModificaCliente' method='POST'>");
                            out.print("<div class='tab-content'>");
                            out.print("<div class='tab-pane fade in active' id='home'>");
                            out.print("<div class='list-group'>");
                            out.print("<section class='panel panel-default'>");
                            out.print("<div class='panel-body'>");
                            out.print("<div class='form-group col-lg-3'>");
                            out.print("<label>Folio Cuenta N°</label>");
                            out.print("<input id='id_usuario' type='text' name='id_usuario' class='form-control' placeholder='Rut' required='required' value='" + request.getParameter("id_usuario") + "' readonly=''>");
                            out.print("</div>");
                            out.print("<div class='form-group col-lg-3'>");
                            out.print("<label>Rut</label>");
                            out.print("<input id='rut' type='text' name='rut' class='form-control' placeholder='Rut' required='required' value='" + request.getParameter("rut") + "' readonly=''>");
                            out.print("</div>");
                            out.print("<div class='form-group'>");
                            out.print("<div class='form-group col-lg-7'>");
                            out.print("<label>Nombres</label>");
                            out.print("<input id='nombre' type='text' name='nombre' class='form-control' placeholder='Nombres' required='required' value='" + request.getParameter("nombre") + "'>");
                            out.print("</div>");
                            out.print("<div class='form-group col-lg-3'>");
                            out.print("<label>Teléfono</label>");
                            out.print("<input id='telefono' type='tel' name='telefono' class='form-control' placeholder='Ingresar número telefonico' required='required' value='" + request.getParameter("telefono") + "'>");
                            out.print("</div>");
                            out.print("</div>");
                            out.print("<div class='form-group'>");
                            out.print("<div class='form-group col-lg-7'>");
                            out.print("<label>Email</label>");
                            out.print("<input id='correo' type='email' name='correo' class='form-control' placeholder='Ingresar email' required='required' value='" + request.getParameter("correo") + "'>");
                            out.print("</div>");
                            out.print("</div>");
                            out.print("</div>");
                            out.print("<footer class='panel-footer text-right bg-light lter'>");
                            out.print("<input type='submit' class='btn btn-primary active' name='accion' value='Actualizar'>&nbsp&nbsp;<button type='reset' class='btn btn-warning'>Cancelar</button>");
                            out.print("</footer>");
                            out.print("</section>");
                            out.print("</div>");
                            out.print("</div>");
                            out.print("</div>");
                            out.print("</form>");
                        } else {
                            out.print("<h1>Ha ocurrido un error cargando los datos</h1>");
                            out.print("<br><br><br><br><a href='Usuarios.jsp'>Regresar</a>");
                        }
                    %>

                </div>
            </div>
        </div>


        <!--JQuery-->
        <script src="docsupport/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/chosen.jquery.js" type="text/javascript"></script>
        <script src="docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
        <script src="docsupport/init.js" type="text/javascript" charset="utf-8"></script>
    </body>
</html>
