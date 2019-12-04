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
       <style>
            #scroll{
                border:0px solid;
                height:300px;
                width:300px;
                overflow-y:scroll;
                overflow-x:hidden;
            }
        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${requestScope.msg =='3'}">
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


        <c:if test="${requestScope.error!=null}">
            <script>swal("<c:out value="${requestScope.error}"/>!", "", "warning");</script>   
        </c:if>
        <c:if test="${requestScope.detalle!=null}">
            <script>alert('<c:out value="${requestScope.detalle}"/>');</script>
        </c:if>
        <c:if test="${requestScope.msg!=null and requestScope.msg !='0'}">
            <script>alert('<c:out value="${requestScope.msg}"/>');</script>
        </c:if>

        <div class="container">
            <div class="col-l12">
                <!-- breadcrumbs --> 
                <ol class="breadcrumb breadcrumb1">
                    <li><a href="indexcliente.jsp">Home</a></li>
                    <li class="active">Bienvenido</li>
                </ol> 
            </div>
        </div>

        <div class="main">
            <div class="container">
                                <div class="slider-left">
                    <h4>Filtrar Por Comuna</h4> 
                    <div   class="col-11  col-sm-2" id="scroll"> 
                        <div class="row row1 scroll-pane">
                            <input class="form-control" id="myInput" type="text" placeholder="Buscar" value="" size="9">
                            <table  class="table table-bordered responsive" id="dataTable">
                                <thead class="thead-dark">
                                    <tr>


                                    </tr>
                                </thead>
                                <tbody id="myTable">
                                    <%
                                        LocalidadService lo = new LocalidadService();
                                        List<Localidad> localidades = lo.listarLocalidades();
                                        for (Localidad l : localidades) {
                                    %>

                                    <tr>
                                        <td><a href='Servcomunasc?accion=comunas&ubicacion=<%= l.getNombreLocalidad()%>'><%= l.getNombreLocalidad()%></a></td>
                                    </tr>
                                    <%}%>


                                </tbody>
                            </table> 
                            <script>
                                $(document).ready(function () {
                                    $("#myInput").on("keyup", function () {
                                        var value = $(this).val().toLowerCase();
                                        $("#myTable tr").filter(function () {
                                            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                        });
                                    });
                                });
                            </script>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <%
                        DepartamentoService depto = new DepartamentoService();
                        List<Departamento> dato = depto.listarHabilitados();
                        for (Departamento d : dato) {
                    %>
                    <div class="col-lg-4 col-xs-6">
                        <div class="section border bg-white rounded p-2">
                            <div class="row">
                                <div class="col-lg-12 img-section">
                                    <img src="./img/portadas.jpg" class="p-0 m-0 res-ponsive">
                                    <span class="badge badge-success-w add-sens p-2 rounded-0"><%
                                        if (d.getHabilitado().equals("1")) {
                                            out.println("Disponible");
                                        }
                                        %></span>
                                    <span class="badge badge-danger add-sens p-2 rounded-0"><%
                                        if (d.getHabilitado().equals("0")) {

                                            out.println("Reservado");
                                        }
                                        %></span>
                                </div>
                                <div class="col-lg-12 sectin-title">
                                    <h1 class="pt-1 pb-2"><%=d.getNombre()%></h1>
                                </div>
                                <div class="col-lg-12">
                                    <div class="row">
                                        <div class="col-lg-2">
                                            <span class="badge badge-success p-2">$ <%=d.getValorarriendo()%></span>
                                        </div>
                                        <div class="col-lg-10 text-right">
                                            <div class="beds">
                                                <img src="img/bed.png" alt="">
                                                <span><%=d.getHabitaciones()%></span>
                                                <img src="img/bath.png" alt="">
                                                <span><%=d.getBanos()%></span>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                </div>
                                <div class="col-lg-12 section-detail">
                                    <p class="ml-2"> <span><%=d.getDireccion()%>-<%=d.getUbicacion()%></span></p>
                                </div>
                                <div class="col-lg-12 pb-2">
                                    <div class="row">
                                        <div class="col-lg-6">
                                        </div>                                       
                                        <div class="col-lg-6">

                                            <a href="Servdeptocliente?accion=detalle&id=<%=d.getId()%>" class="btn btn-info active btn-block btn-sm">Detalles</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>  
                    </div>
                    <%}%>


                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>        
        <script>
            $(document).ready(function () {
                $('#example').DataTable({
                    dom: 'Bfrtip',
                    buttons: [
                        'copyHtml5',
                        'excelHtml5',
                        'csvHtml5',
                        'pdfHtml5'
                    ]
                });
            });
        </script>
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