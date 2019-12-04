<%@page import="webservice.Serviciosdepto"%>
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

<html lang="en">
    <head>
        <title>Portafolio de Título | Turismo Real </title>
        <meta charset="UTF-8">

        <!-- Google Fonts -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" /> 
        <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/admin.css">
        <link rel="stylesheet" href="docsupport/prism.css">
        <link rel="stylesheet" href="chosen.css">
        <link rel="stylesheet" href="turismo/css/style.css">
        <link rel="stylesheet" href="css/style_3.css"/>

        <!-- Stylesheets -->
        <link rel="stylesheet" href="css/font-awesome.min.css"/>
        <link rel="stylesheet" href="css/animate.css"/>
        <link rel="stylesheet" href="css/owl.carousel.css"/>
        <link rel="stylesheet" href="css/magnific-popup.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script type="text/javascript" src="js/validarut.js"></script>


    </head>
    <body>


        <nav class="navbar navbar-inverse navbar-expand-xl navbar-dark">
            <div class="navbar-header d-flex col">
                <a class="navbar-brand" href="index.jsp"><i class="fa fa-briefcase"></i>Turismo <b> Real</b></a>  		
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
                    <li class="nav-item active "><a href="index.jsp" class="nav-link"><i class="fa fa-home"></i><span>Home</span></a></li>
                    <li class="nav-item active"><a href="index.jsp" class="nav-link"><i class="fa fa-building"></i><span>Departamentos</span></a></li>
                    <li class="nav-item active"><a href="login.jsp" class="nav-link"><i class="fa fa-key"></i><span>Login</span></a></li>

                </ul>
            </div>
        </nav>
        <c:if test="${requestScope.error!=null}">
            <script>alert('<c:out value="${requestScope.error}"/>');</script>
        </c:if>
        <c:if test="${requestScope.msg!=null}">
            <script>alert('<c:out value="${requestScope.msg}"/>');</script>
        </c:if>
        <%
            int id = Integer.parseInt((String) request.getAttribute("id"));
            DepartamentoService depto = new DepartamentoService();
            Departamento d = depto.listarpordepartamento(id);
        %>

        <div class="container">
            <div class="col-md-12">
                <!-- breadcrumbs --> 
                <ol class="breadcrumb breadcrumb1">
                    <li><a href="index.jsp">Home</a></li>
                    <li class="active"><%=d.getNombre()%></li>
                </ol> 
            </div>


            <!-- Page -->
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 single-list-page">
                        <div class="single-list-slider owl-carousel" id="sl-slider">
                            <div id="flickrembed_87"></div><div style="position:absolute; top:-10px; display:block; text-align:center; z-index:-1;"></div><script src='https://flickrembed.com/embed_v2.js.rand.php?container=flickrembed_87&source=flickr&layout=responsive&input= <%=d.getUbicacion()%>&sort=0&by=keywords&theme=default&scale=fill&speed=3000&limit=100&skin=default&autoplay=true'></script><script type="text/javascript">function showpics() {
                    var a = $("#box").val();
                    $.getJSON("http://api.flickr.com/services/feeds/photos_public.gne?tags=" + a + "&tagmode=any&format=json&jsoncallback=?", function (a) {
                        $("#images").hide().html(a).fadeIn("fast"), $.each(a.items, function (a, e) {
                            $("<img/>").attr("src", e.media.m).appendTo("#images")
                        })
                    })
                }</script><small style="display: block; text-align: center; margin: 0 auto;"><a href="https://flickrembed.com"></a>.</small>                                                         
                        </div>
                        <div class="single-list-content">
                            <div class="row">
                                <div class="col-xl-8 sl-title">
                                    <h2><%=d.getNombre()%></h2>
                                    <p><i class="fa fa-map-marker"></i><%=d.getDireccion()%> | <%=d.getUbicacion()%></p>
                                </div>
                                <div class="col-xl-4">
                                    <a href="#" class="price-btn btn-primary active">$<%=d.getValorarriendo()%></a>
                                </div>
                            </div>

                            <h3 class="sl-sp-title">Descripción Aviso</h3>
                            <div class="description">
                                <p><%=d.getDescripcion()%></p>
                            </div>
                            <h3 class="sl-sp-title">Servicios Extras</h3>
                            <%
                                int cod = Integer.parseInt((String) request.getAttribute("id"));
                                ServicioService srv = new ServicioService();
                                List<Serviciosdepto> dato = srv.listarServicios(cod);
                                for (Serviciosdepto s : dato) {
                            %>
                            <div class="row property-details-list">
                                <div class="col-md-4 col-sm-6">
                                    <p><i class="fa fa-check-circle-o"></i><%= s.getNombreSrv()%></p>                                       
                                </div>                                  
                            </div>
                            <%}%>
                            <h3 class="sl-sp-title">Mapa</h3>
                                        <div class="mapouter"><div class="gmap_canvas"><iframe width="600" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=<%=d.getUbicacion()%>&t=k&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>Google Maps Generator by <a href="https://www.embedgooglemap.net">embedgooglemap.net</a></div><style>.mapouter{position:relative;text-align:right;height:500px;width:600px;}.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:600px;}</style></div>						

                        </div>
                        <div>

                        </div>
                    </div>
                    <!-- sidebar -->
                    <div class="col-lg-4 col-md-7 sidebar">
                        <div class="author-card">
                            <img src="./img/portadas.jpg" alt="">      
                            <div class="author-card">
                                <h5><%=d.getNombre()%></h5>
                                <%=d.getHabitaciones()%> Dormitorios -  <%=d.getBanos()%> Baños
                            </div>                               
                        </div>
                        <div class="contact-form-card">
                            <h5>Formulario de Reserva</h5>
                            <form name="reserva" method="post" action="NuevaReserva" role="form">  
                                <label for="fechareserva"><strong>Fecha Reserva</strong></label>
                                <input id="fecha_reserva" type="date" name="fecha_reserva"  required="required" data-error="fecha es requerida." value="" >
                                <label for="fechasalida"><strong>Fecha Salida</strong></label>
                                <input id="fecha_salida" type="date" name="fecha_salida" required="required" data-error="fecha es requerida." value="">
                                <label for="rut"><strong>Rut</strong></label>
                                <input type="text" name="rut" class="form-control" id="rut" size="11" value="" placeholder="11111111-1"  onblur="onRutBlur(this);">
                                <label for="cantidad_personas"><strong>N° Personas</strong></label>
                                <input id="cantidad_personas" type="number" name="cantidad_personas"  required="required" data-error="fecha es requerida." value="" >
                                <input type="hidden" class="form-control" name="id_departamento" id="id_departamento" value="<%=d.getId()%>">
                                <input type="hidden" class="form-control" name="habilitado" id="habilitado" value="0">

                                <input type="submit" class="btn btn-primary active" id="iniciar" value="Iniciar Reserva">   
                            </form>

                        </div>

                    </div>

                </div>

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