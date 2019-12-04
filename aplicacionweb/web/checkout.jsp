<%@page import="webservice.Solicitudtransporte"%>
<%@page import="webservice.Servicioreserva"%>
<%@page import="webservice.Servicioreserva"%>
<%@page import="webservice.Checkout"%>
<%@page import="webservice.Checkin"%>
<%@page import="webservice.Reserva"%>
<%@page import="webservice.Inventarios"%>
<%@page import="webservice.Reservas"%>
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
            || (Boolean) sesion.getAttribute("logeado") != true) && sesion.getAttribute("tipo") != "Funcionario") {
        //si es nula o vale false.... redirijo al usuario hacia la pagina de Login
        out.print("<script>alert('Para entrar a esta página debes estar logueado como Administrador del Sistema'); window.history.back(-1);</script>");
        response.sendRedirect("index.jsp");
    }
%>
<%
    int id_reserva = Integer.parseInt((String) request.getAttribute("id_reserva"));
    ReservasService reservas = new ReservasService();
    Reserva r = reservas.idReserva(id_reserva);
%>
<%
    int codigo = Integer.parseInt((String) request.getAttribute("id"));
    DepartamentoService depto = new DepartamentoService();
    Departamento d = depto.listarpordepartamento(codigo);
%>
<%
    String rut = ((String) request.getAttribute("rut"));
    CuentasService cta = new CuentasService();
    Usuario u = cta.mostrarporrut(rut);
%>

<%
    String idreserva = ((String) request.getAttribute("id_reserva"));
    CheckinService rs = new CheckinService();
    Checkin re = rs.listarCheckin(idreserva);
%>

<%
    String reserva = ((String) request.getAttribute("id_reserva"));
    CheckoutService check = new CheckoutService();
    Checkout res = check.listarCheckout(reserva);
%>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link type="text/css" rel="stylesheet" href="turismo/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
    body {
        color: #566787;
        background: #f5f5f5;
        font-family: 'Varela Round', sans-serif;
        font-size: 13px;
    }
    .table-wrapper {
        background: #fff;
        padding: 20px 25px;
        margin: 30px 0;
        border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
    .table-title {        
        padding-bottom: 15px;
        background: #435d7d;
        color: #fff;
        padding: 16px 30px;
        margin: -20px -25px 10px;
        border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
        margin: 5px 0 0;
        font-size: 24px;
    }
    .table-title .btn-group {
        float: right;
    }
    .table-title .btn {
        color: #fff;
        float: right;
        font-size: 13px;
        border: none;
        min-width: 50px;
        border-radius: 2px;
        border: none;
        outline: none !important;
        margin-left: 10px;
    }
    .table-title .btn i {
        float: left;
        font-size: 21px;
        margin-right: 5px;
    }
    .table-title .btn span {
        float: left;
        margin-top: 2px;
    }
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
        padding: 12px 15px;
        vertical-align: middle;
    }
    table.table tr th:first-child {
        width: 60px;
    }
    table.table tr th:last-child {
        width: 100px;
    }
    table.table-striped tbody tr:nth-of-type(odd) {
        background-color: #fcfcfc;
    }
    table.table-striped.table-hover tbody tr:hover {
        background: #f5f5f5;
    }
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
    table.table td:last-child i {
        opacity: 0.9;
        font-size: 22px;
        margin: 0 5px;
    }
    table.table td a {
        font-weight: bold;
        color: #566787;
        display: inline-block;
        text-decoration: none;
        outline: none !important;
    }
    table.table td a:hover {
        color: #2196F3;
    }
    table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
    table.table .avatar {
        border-radius: 50%;
        vertical-align: middle;
        margin-right: 10px;
    }
    .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 13px;
        min-width: 30px;
        min-height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 2px !important;
        text-align: center;
        padding: 0 6px;
    }
    .pagination li a:hover {
        color: #666;
    }	
    .pagination li.active a, .pagination li.active a.page-link {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
    .pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    }    
    /* Custom checkbox */
    .custom-checkbox {
        position: relative;
    }
    .custom-checkbox input[type="checkbox"] {    
        opacity: 0;
        position: absolute;
        margin: 5px 0 0 3px;
        z-index: 9;
    }
    .custom-checkbox label:before{
        width: 18px;
        height: 18px;
    }
    .custom-checkbox label:before {
        content: '';
        margin-right: 10px;
        display: inline-block;
        vertical-align: text-top;
        background: white;
        border: 1px solid #bbb;
        border-radius: 2px;
        box-sizing: border-box;
        z-index: 2;
    }
    .custom-checkbox input[type="checkbox"]:checked + label:after {
        content: '';
        position: absolute;
        left: 6px;
        top: 3px;
        width: 6px;
        height: 11px;
        border: solid #000;
        border-width: 0 3px 3px 0;
        transform: inherit;
        z-index: 3;
        transform: rotateZ(45deg);
    }
    .custom-checkbox input[type="checkbox"]:checked + label:before {
        border-color: #03A9F4;
        background: #03A9F4;
    }
    .custom-checkbox input[type="checkbox"]:checked + label:after {
        border-color: #fff;
    }
    .custom-checkbox input[type="checkbox"]:disabled + label:before {
        color: #b8b8b8;
        cursor: auto;
        box-shadow: none;
        background: #ddd;
    }
    /* Modal styles */
    .modal .modal-dialog {
        max-width: 400px;
    }
    .modal .modal-header, .modal .modal-body, .modal .modal-footer {
        padding: 20px 30px;
    }
    .modal .modal-content {
        border-radius: 3px;
    }
    .modal .modal-footer {
        background: #ecf0f1;
        border-radius: 0 0 3px 3px;
    }
    .modal .modal-title {
        display: inline-block;
    }
    .modal .form-control {
        border-radius: 2px;
        box-shadow: none;
        border-color: #dddddd;
    }
    .modal textarea.form-control {
        resize: vertical;
    }
    .modal .btn {
        border-radius: 2px;
        min-width: 100px;
    }	
    .modal form label {
        font-weight: normal;
    }	
</style>

<style>

    :after, :before {
        box-sizing: border-box;
    }

    a {
        color: #337ab7;
        text-decoration: none;
    }
    i{
        margin-bottom:4px;
    }

    .btn {
        display: inline-block;
        font-size: 14px;
        font-weight: 400;
        line-height: 1.42857143;
        text-align: center;
        white-space: nowrap;
        vertical-align: middle;
        cursor: pointer;
        user-select: none;
        background-image: none;
        border: 1px solid transparent;
        border-radius: 4px;
    }


    .btn-app {
        color: white;
        box-shadow: none;
        border-radius: 3px;
        position: relative;
        padding: 10px 15px;
        margin: 0;
        min-width: 60px;
        max-width: 80px;
        text-align: center;
        border: 1px solid #ddd;
        background-color: #f4f4f4;
        font-size: 12px;
        transition: all .2s;
        background-color: steelblue !important;
    }

    .btn-app > .fa, .btn-app > .glyphicon, .btn-app > .ion {
        font-size: 30px;
        display: block;
    }

    .btn-app:hover {
        border-color: #aaa;
        transform: scale(1.1);
    }

    .pdf {
        background-color: #dc2f2f !important;
    }

    .excel {
        background-color: #3ca23c !important;
    }

    .csv {
        background-color: #e86c3a !important;
    }

    .imprimir {
        background-color: #8766b1 !important;
    }

    /*
    Esto es opcional pero sirve para que todos los botones de exportacion se distribuyan de manera equitativa usando flexbox
    
    .flexcontent {
        display: flex;
        justify-content: space-around;
    }
    */

    .selectTable{
        height:40px;
        float:right;
    }

    div.dataTables_wrapper div.dataTables_filter {
        text-align: left;
        margin-top: 15px;
    }

    .btn-secondary {
        color: #fff;
        background-color: #4682b4;
        border-color: #4682b4;
    }
    .btn-secondary:hover {
        color: #fff;
        background-color: #315f86;
        border-color: #545b62;
    }



    .titulo-tabla{
        color:#606263;
        text-align:center;
        margin-top:15px;
        margin-bottom:15px;
        font-weight:bold;
    }






    .inline{
        display:inline-block;
        padding:0;
    }

</style>
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>

<script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.20/af-2.3.4/b-1.6.1/b-colvis-1.6.1/b-flash-1.6.1/b-html5-1.6.1/b-print-1.6.1/cr-1.5.2/fc-3.3.0/fh-3.1.6/kt-2.5.1/r-2.2.3/rg-1.1.1/rr-1.2.6/sc-2.0.1/sl-1.3.1/datatables.min.js"></script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


<script src="cssadmin/js/ie/html5shiv.js"></script>
<script src="cssadmin/js/ie/respond.min.js"></script>
<script src="cssadmin/js/ie/excanvas.js"></script>

<link rel="stylesheet" href="docsupport/prism.css">
<link rel="stylesheet" href="chosen.css">
<link rel="stylesheet" href="css/admin.css">
<script src='https://cdn.tiny.cloud/1/olssbszkqq9nym6pdj3gtefcayfizbvn3qzr2zyjp0xydnl3/tinymce/5/tinymce.min.js' referrerpolicy="origin"></script>
<script>
    tinymce.init({
        selector: '#mytextarea'
    });
</script>
<script src="https://cdn.tiny.cloud/2/olssbszkqq9nym6pdj3gtefcayfizbvn3qzr2zyjp0xydnl3/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
<script>tinymce.init({selector: 'textarea'});</script>
<nav class="navbar navbar-inverse navbar-expand-xl navbar-dark">
    <div class="navbar-header d-flex col">
        <a class="navbar-brand" href="indexfuncionario.jsp"><i class="fa fa-briefcase"></i>Turismo <b> Real</b></a>  		
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


            </div>
        </form>
        <ul class="nav navbar-nav navbar-right ml-auto">
            <li class="nav-item active"><a href="indexfuncionario.jsp" class="nav-link"><i class="fa fa-home"></i><span>Home</span></a></li>
            <li class="nav-item dropdown">
                <a href="#" data-toggle="dropdown" class="nav-link dropdown-toggle user-action"><img src="images/avatar_default.jpg" class="avatar" alt="Avatar">  <%
                    //preguntamo por la variable de sesion creada en el servlet
                    if (sesion.getAttribute("nombre") != null) {
                        out.print(sesion.getAttribute("nombre"));
                    }
                    %><b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="MisDatosFuncionario.jsp" class="dropdown-item"><i class="fa fa-user-o"></i>Mi Cuenta</a></li>
                    <li class="divider dropdown-divider"></li>
                    <li><a href="Logout" class="dropdown-item"><i class="material-icons">&#xE8AC;</i> Cerrar Sesión</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>        


<div class="container">
    <div class="row">
        <div class="col-sm-3 col-md-2">
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                    Check-out Reserva N° <%=r.getIdReserva()%>
                </button>

            </div>
        </div>

    </div>
    <hr />
    <div class="row">
        <div class="col-sm-9 col-md-10">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
                <li class="active"><a href="#reserva" data-toggle="tab"><span class="glyphicon glyphicon-book">
                        </span>Datos Reserva</a></li>
                <li><a href="#inventario" data-toggle="tab"><span class="glyphicon glyphicon-check"></span>
                        Inventario</a></li>
                <li><a href="#servicios" data-toggle="tab"><span class="glyphicon glyphicon-list"></span>
                        Servicios</a></li>
                <li><a href="#transporte" data-toggle="tab"><span class="glyphicon glyphicon-bullhorn"></span>
                        Transporte</a></li>
                <li><a href="#checkin" data-toggle="tab"><span class="glyphicon glyphicon-certificate"></span>
                        Acta de Check-in</a></li>
                <li><a href="#checkout" data-toggle="tab"><span class="glyphicon glyphicon-certificate"></span>
                        Acta de Check-out</a></li>

            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane fade in active" id="reserva">
                    <div class="list-group">

                        <section class="panel panel-default">                               

                            <div class="panel-body">

                                <div class="form-group col-lg-5">
                                    <label>Nombre Departamento</label>
                                    <input id="form_email" type="text" name="nombre" class="form-control" placeholder="Ingresar nombre del departamento*" required="required" value="<%=d.getNombre()%>" readonly="">

                                </div>
                                <div class="form-group col-lg-5">
                                    <label>Dirección</label>
                                    <input id="form_email" type="text" name="ubicacion" class="form-control" placeholder="Ingresar ubicación departamento" required="required" value="<%=d.getDireccion()%> - <%=d.getUbicacion()%>" readonly="">
                                </div>

                                <div class="form-group col-lg-1">
                                    <label>Dormitorios</label>
                                    <input id="form_email" type="text" name="habitaciones" class="form-control" placeholder="Ingresar habilitaciones" required="required" value="<%=d.getHabitaciones()%>" readonly="">


                                </div>   
                                <div class="form-group col-lg-1">
                                    <label>Baños</label>
                                    <input id="form_email" type="text" name="banos" class="form-control" placeholder="Ingresar banos" required="required" value="<%=d.getBanos()%>" readonly="">


                                </div>   
                                <div class="form-group col-lg-3">
                                    <label>Rut</label>
                                    <input id="form_email" type="text" name="nombre" class="form-control" placeholder="Ingresar nombre del departamento*" required="required" value="<%=r.getRut()%>" readonly="">

                                </div>
                                <div class="form-group col-lg-7">
                                    <label>Nombres</label>
                                    <input id="form_email" type="text" name="nombres" class="form-control" placeholder="Nombre cliente" required="required" value="<%=u.getNombre()%>" readonly="">


                                </div>

                                <div class="form-group">
                                    <div class="form-group col-lg-3">
                                        <label>Fecha Reserva</label>
                                        <input id="form_name" type="date" name="fecha_reserva" class="form-control" required="required" data-error="Fecha Reserva" value="<%=r.getFechaReserva()%>" readonly="" >
                                    </div>
                                    <div class="form-group col-lg-3">
                                        <label>Fecha Salida</label>
                                        <input id="form_email" type="date" name="fecha_salida" class="form-control" placeholder="Fecha Salida*" value="<%=r.getFechaSalida()%>" readonly="" >                               
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-group col-lg-2">
                                        <label>N° de Personas</label>
                                        <input id="cantidad_personas" type="number" class="form-control" placeholder="Nª Personas*" name="cantidad_personas" value="<%=r.getCantidadPersonas()%>" readonly="">
                                    </div>
                                    <div class="form-group col-lg-2">
                                        <label>Valor Arriendo</label>
                                        <input type="number" class="form-control" name="valorarriendo" id="valorarriendo" value="<%=d.getValorarriendo()%>" readonly="" >
                                    </div>
                                </div>


                            </div>

                        </section>



                    </div>
                </div>
                <div class="tab-pane fade in" id="inventario">
                    <div class="list-group">
                        <div class="list-group-item">

                            <table id="example" class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Departamento</th>
                                        <th>Producto</th>
                                        <th>Categoría</th>
                                        <th>Stock</th>
                                        <th>Estado</th>
                                    </tr>
                                </thead>
                                <tbody id="myTable">
                                    <%
                                        //   String rut = (String)request.getParameter("rut");
                                        int id = Integer.parseInt((String) request.getAttribute("id"));
                                        System.out.print("id departamento " + id);
                                        InventarioService in = new InventarioService();
                                        List<Inventarios> dato = in.listarInventario(id);
                                        for (Inventarios i : dato) {
                                    %>
                                    <tr>
                                        <td><%= i.getIdInv()%></td>
                                        <td><%= i.getNombre()%></td>
                                        <td><%= i.getProducto()%></td>
                                        <td><%= i.getCategoria()%></td>
                                        <td><%= i.getCantidad()%></td>
                                        <td><%= i.getEstado()%></td>
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
                        </div>
                    </div>
                </div>
                                <div class="tab-pane fade in" id="servicios">
                    <div class="table-wrapper">
                        <div class="list-group">
                            <div class="list-group-item">


                                <table id="ejemplo" class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>Fecha</th>
                                            <th>Servicio</th> 
                                            <th>Valor</th>  
                                        </tr>
                                    </thead>
                                    <tbody id="myTable">
                                        <%
                                            //   String rut = (String)request.getParameter("rut");
                                            int codigor = Integer.parseInt((String) request.getAttribute("id_reserva"));
                                            System.out.print("id_reserva " + id_reserva);
                                            ServicioService srv = new ServicioService();
                                            List<Servicioreserva> datore = srv.servicioscontratados(codigor);
                                            for (Servicioreserva s : datore) {
                                        %>
                                        <tr>
                                            <td><%=s.getFechaContratacion()%></td>
                                            <td><%=s.getNombreSrv()%></td>
                                            <td><%=s.getPrecio()%></td>      
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
                                <script>
                                    $(document).ready(function () {
                                        $('#ejemplo').DataTable({
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
                            </div>
                        </div>

                    </div>
                </div>
                               <div class="tab-pane fade in" id="transporte">
                    <div class="table-wrapper">
                        <div class="list-group">
                            <div class="list-group-item">


                                <table id="ejemplo" class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID Solicitud</th>
                                            <th>Fecha</th>
                                            <th>Hora</th>
                                            <th>Órigen</th>
                                            <th>Destino</th>                          
                                            <th>Estado</th> 
                                        </tr>
                                    </thead>
                                    <tbody id="myTable">
                                         <%
                                            //   String rut = (String)request.getParameter("rut");
                                            String id_reservas = ((String) request.getParameter("id_reserva"));
                                            System.out.print("id_recerva " + id_reserva);
                                            TransporteService trs = new TransporteService();
                                            List<Solicitudtransporte> datos = trs.listarmissolicitudes(id_reservas);
                                            for (Solicitudtransporte s : datos) {
                                        %>
                                        <td><%= s.getIdSolicitud()%></td>
                                            <td><%= s.getFechaSolicitud()%></td>
                                            <td><%= s.getHoraSolicitud()%></td>
                                            <td><%=s.getOrigen()%></td>
                                            <td><%= s.getDestino()%></td>
                                            <td><%
                                                if (s.getEstado().equals("0")) {
                                                    out.print("<span class='btn btn-danger btn-xs'>");
                                                    out.println("Sin Asignación");
                                                    out.print("</span>");
                                                } else if (s.getEstado().equals("1")) {
                                                    out.print("<span class='btn btn-danger'>");
                                                    out.println("<a href='#' class='btn btn-success btn-xs' role='button' '>Asignada<span class='glyphicon glyphicon-trash'></span></a>");
                                                    out.print("</span>");
                                                }

                                                %></td>
                                        <%}%>
                                    </tbody>
                                </table>
                                
                            </div>
                        </div>

                    </div>
                </div>
                <div class="tab-pane fade in" id="checkin">

                    <form method="post" action="nuevocheckin" role="form">
                        <section class="panel panel-default">

                            <div class="panel-body">

                                <div class="form-group">
                                    <%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");%>

                                    <input type="hidden" class="form-control" name="id_reserva" id="id_reserva" value="<%= request.getParameter("id_reserva")%>">
                                    <input type="hidden" class="form-control" name="fecha_checkin" id="fecha_checkin" value="<%= df.format(new java.util.Date())%>">
                                </div>
                                <div class="form-group">
                                    <% if (re.getFechaCheckin() == null) {

                                            out.println("<label></label>");
                                        } else {
                                            out.println("<div class='form-group col-lg-10'>");
                                            out.println("<label>Fecha</label>");
                                            out.println("<input id='fecha' type='text' name='fecha' class='form-control' placeholder='id' required='required' value='" + re.getFechaCheckin() + "' readonly=''>");
                                            out.println("</div>");
                                        }
                                    %>

                                    <div class="form-group col-lg-10">
                                        <label>Acta</label>
                                        <textarea id="mytextarea"  name="descripcion"> <%=re.getDescripcion()%></textarea>
                                    </div>

                                </div>
                            </div>
                            <footer class="panel-footer text-right bg-light lter">
                                <input type="submit" class="btn btn-primary active" value="Guardar">&nbsp&nbsp;<button type="reset" class="btn btn-warning">Cancelar</button>
                            </footer>
                        </section> 

                    </form>  
                </div>
                <div class="tab-pane fade in" id="checkout">

                    <form method="post" action="nuevocheckout" role="form">
                        <section class="panel panel-default">

                            <div class="panel-body">

                                <div class="form-group">

                                    <input type="hidden" class="form-control" name="id_reserva" id="id_reserva" value="<%= request.getParameter("id_reserva")%>">
                                    <input type="hidden" class="form-control" name="fecha_checkout" id="fecha_checkin" value="<%= df.format(new java.util.Date())%>">
                                </div>
                                <div class="form-group">
                                    <% if (res.getFechaCheckout() == null) {

                                            out.println("<label></label>");
                                        } else {
                                            out.println("<div class='form-group col-lg-10'>");
                                            out.println("<label>Fecha</label>");
                                            out.print("<input id='fecha' type='text' name='fecha' class='form-control' placeholder='id' required='required' value='" + res.getFechaCheckout() + "' readonly=''>");
                                            out.println("</div>");
                                        }
                                    %>
                                    <div class="form-group col-lg-10">
                                        <label>Acta</label>
                                        <textarea name="descripcion"><%=res.getDescripcion()%></textarea>

                                    </div>
                                </div>
                            </div>
                            <footer class="panel-footer text-right bg-light lter">
                                <input type="submit" class="btn btn-primary active" value="Guardar">&nbsp&nbsp;<button type="reset" class="btn btn-warning">Cancelar</button>
                            </footer>
                        </section> 

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
