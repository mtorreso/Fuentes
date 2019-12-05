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
            || (Boolean) sesion.getAttribute("logeado") != true) && sesion.getAttribute("tipo") != "Cliente") {
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
        <link rel="stylesheet" href="turismo/css/style.css">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" /> 
        <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/custom.css">
        <link rel="stylesheet" href="docsupport/prism.css">
        <link rel="stylesheet" href="chosen.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/admin.css">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    </head>
    <body>

        <nav class="navbar navbar-inverse navbar-expand-xl navbar-dark">
            <div class="navbar-header d-flex col">
                <a class="navbar-brand" href="indexcliente.jsp"><i class="fa fa-briefcase"></i>Turismo <b> Real</b></a>  		
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
                    <li class="nav-item active "><a href="indexcliente.jsp" class="nav-link"><i class="fa fa-home"></i><span>Home</span></a></li>
                    <li class="nav-item active"><a href="SrvMisReservas?accion=reservas&rut=<%
                        //preguntamo por la variable de sesion creada en el servlet
                        if (sesion.getAttribute("rut") != null) {
                            out.print(sesion.getAttribute("rut"));
                        }
                                                   %>" class="nav-link"><i class="fa fa-book"></i><span>Mis Reservas</span></a></li>
                    <li class="nav-item active"><a href="indexcliente.jsp" class="nav-link"><i class="fa fa-building"></i><span>Departamentos</span></a></li>
                    <li class="nav-item dropdown active">
                        <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle user-action"><img src="images/avatar_default.jpg" class="avatar" alt="Avatar">  <%
                            //preguntamo por la variable de sesion creada en el servlet
                            if (sesion.getAttribute("nombre") != null) {
                                out.print(sesion.getAttribute("nombre"));
                            }
                            %><b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="MisDatosCliente.jsp" class="dropdown-item"><i class="fa fa-user-o"></i>Mi Cuenta</a></li>
                            <li class="divider dropdown-divider"></li>
                            <li><a href="Logout" class="dropdown-item"><i class="material-icons">&#xE8AC;</i> Cerrar Sesión</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="col-l12">
                <!-- breadcrumbs --> 
                <ol class="breadcrumb breadcrumb1">
                    <li><a href="indexcliente.jsp">Home</a></li>
                    <li class="active">Comprobante de Reserva</li>
                </ol> 
            </div>
        </div>

        <div class="main">
            <div class="container">
                <div class="row">
                    <div  class="receipt-main col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
                        <div class="row">
                            <div class="receipt-header">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="receipt-left">
                                    </div>
                                </div>
                                <div class="col-xs-7 col-sm-6 col-md-6 text-center">
                                    <div class="receipt-right">
                                        <h5>Comprobante de Reserva</h5>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="receipt-header receipt-header-mid">
                                <div class="col-xs-8 col-sm-8 col-md-8 text-left">
                                    <div class="receipt-right">
                                        <h5>Turismo Real<small></small></h5>
                                    </div>
                                </div>

                            </div>
                        </div>

                        <div>
                            <%
                                String rut = ((String) request.getParameter("rut"));
                                CuentasService cuentas = new CuentasService();
                                Usuario c = cuentas.mostrarporrut(rut);
                            %>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Datos Cliente</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Rut</td>
                                        <td><%= request.getParameter("rut")%></td>
                                    </tr>
                                    <tr>
                                        <td>Nombres</td>
                                        <td><%=c.getNombre()%></td>
                                    </tr>


                                    </tr>

                                </tbody>
                                <%
                                    int id = Integer.parseInt((String) request.getParameter("id_departamento"));
                                    DepartamentoService depto = new DepartamentoService();
                                    Departamento d = depto.listarpordepartamento(id);
                                %>
                            </table>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Detalle Reserva</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td>Fecha de Ingreso</td>
                                        <td><%= request.getParameter("fecha_reserva")%> </td>
                                    </tr>
                                    <tr>
                                        <td>Departamento</td>
                                        <td><%=d.getNombre()%></td>
                                    </tr>
                                    <tr>
                                        <td>Dirección</td>
                                        <td><%=d.getDireccion()%>-<%=d.getUbicacion()%></td>
                                    </tr>
                                    <tr>
                                        <td>Fecha Salida</td>
                                        <td><%= request.getParameter("fecha_salida")%></td>
                                    </tr>
                                    <tr>
                                        <td>N° de Personas</td>
                                        <td><%= request.getParameter("cantidad_personas")%> </td>
                                    </tr>


                                    </tr>

                                </tbody>
                            </table>
                        </div>


                    </div>
                    


                </div>
            </div>
        </div>
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