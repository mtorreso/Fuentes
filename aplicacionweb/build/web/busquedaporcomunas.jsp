<%@page import="webservice.Reservas"%>
<%@page import="webservice.Solicitudes"%>
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
        <link type="text/css" rel="stylesheet" href="turismo/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.css">
        <!-- js-!--->

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.6.0/js/buttons.html5.min.js"></script>

        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.20/af-2.3.4/b-1.6.1/b-colvis-1.6.1/b-flash-1.6.1/b-html5-1.6.1/b-print-1.6.1/cr-1.5.2/fc-3.3.0/fh-3.1.6/kt-2.5.1/r-2.2.3/rg-1.1.1/rr-1.2.6/sc-2.0.1/sl-1.3.1/datatables.min.js"></script>

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


        <script src="cssadmin/js/ie/html5shiv.js"></script>
        <script src="cssadmin/js/ie/respond.min.js"></script>
        <script src="cssadmin/js/ie/excanvas.js"></script>


        <!--tablas nuevas!-->

        <link rel="stylesheet" href="docsupport/prism.css">
        <link rel="stylesheet" href="chosen.css">
        <link rel="stylesheet" href="css/admin.css">

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

        <script>
            var idioma =
                    {
                        "sProcessing": "Procesando...",
                        "sLengthMenu": "Mostrar _MENU_ registros",
                        "sZeroRecords": "No se encontraron resultados",
                        "sEmptyTable": "No exiten registros para el filtro de busqueda",
                        "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                        "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                        "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                        "sInfoPostFix": "",
                        "sSearch": "Buscar:",
                        "sUrl": "",
                        "sInfoThousands": ",",
                        "sLoadingRecords": "Cargando...",
                        "oPaginate": {
                            "sFirst": "Primero",
                            "sLast": "Ãšltimo",
                            "sNext": "Siguiente",
                            "sPrevious": "Anterior"
                        },
                        "oAria": {
                            "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                        },
                        "buttons": {
                            "copyTitle": 'Informacion copiada',
                            "copyKeys": 'Use your keyboard or menu to select the copy command',
                            "copySuccess": {
                                "_": '%d filas copiadas al portapapeles',
                                "1": '1 fila copiada al portapapeles'
                            },

                            "pageLength": {
                                "_": "Mostrar %d filas",
                                "-1": "Mostrar Todo"
                            }
                        }
                    };

            $(document).ready(function () {


                var table = $('#ejemplo').DataTable({

                    "paging": true,
                    "lengthChange": true,
                    "searching": true,
                    "ordering": true,
                    "info": true,
                    "autoWidth": true,
                    "language": idioma,
                    "lengthMenu": [[5, 10, 20, -1], [5, 10, 50, "Mostrar Todo"]],
                    dom: 'Bfrt<"col-md-6 inline"i> <"col-md-6 inline"p>',

                    buttons: {
                        dom: {
                            container: {
                                tag: 'div',
                                className: 'flexcontent'
                            },
                            buttonLiner: {
                                tag: null
                            }
                        },

                        buttons: [

                            {
                                extend: 'copyHtml5',
                                text: '<i class="fa fa-clipboard"></i>Copiar',
                                title: 'Reporte Reservas <%=request.getParameter("ubicacion")%>  ',
                                titleAttr: 'Copiar',
                                className: 'btn btn-app export barras',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6,7,8]
                                }
                            },

                            {
                                extend: 'pdfHtml5',
                                text: '<i class="fa fa-file-pdf-o"></i>PDF',
                                title: 'Reporte Reservas <%=request.getParameter("ubicacion")%> ',
                                titleAttr: 'PDF',
                                className: 'btn btn-app export pdf',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6,7,8]
                                },
                                customize: function (doc) {

                                    doc.styles.title = {
                                        color: '#4c8aa0',
                                        fontSize: '30',
                                        alignment: 'center'
                                    }
                                    doc.styles['td:nth-child(2)'] = {
                                        width: '100px',
                                        'max-width': '100px'
                                    },
                                            doc.styles.tableHeader = {
                                                fillColor: '#4c8aa0',
                                                color: 'white',
                                                alignment: 'center'
                                            },
                                            doc.content[1].margin = [100, 0, 100, 0]

                                }

                            },

                            {
                                extend: 'excelHtml5',
                                text: '<i class="fa fa-file-excel-o"></i>Excel',
                                title: 'Reporte Reservas <%=request.getParameter("ubicacion")%> ',
                                titleAttr: 'Excel',
                                className: 'btn btn-app export excel',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6,7,8]
                                },
                            },
                            {
                                extend: 'csvHtml5',
                                text: '<i class="fa fa-file-text-o"></i>CSV',
                                title: 'Reporte Reservas <%=request.getParameter("ubicacion")%> ',
                                titleAttr: 'CSV',
                                className: 'btn btn-app export csv',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6,7,8]
                                }
                            },
                            {
                                extend: 'print',
                                text: '<i class="fa fa-print"></i>Imprimir',
                                title: 'Reporte Reservas <%=request.getParameter("ubicacion")%>',
                                titleAttr: 'Imprimir',
                                className: 'btn btn-app export imprimir',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6,7,8]
                                }
                            }
                        ]


                    }

                });


            });
        </script>
        <style>
            @import url(https://fonts.googleapis.com/css?family=Lato:400,900,700,300);
            .heading4{font-size:18px;font-weight:400;font-family:'Lato', sans-serif;color:#111111;margin:0px 0px 5px 0px;}
            .heading1{font-size:30px;line-height:20px;font-family:'Lato', sans-serif;text-transform:uppercase;color:#1b2834;font-weight:900;}
            .content-quality{float:left;width:193px;}
            .content-quality p{margin-left:10px;font-family:'Open Sans', sans-serif;font-size:14px;font-weight:600;line-height:17px;}
            .content-quality p span{display:block;}
            .tabtop li a{font-family:'Lato', sans-serif;font-weight:700;color:#1b2834;border-radius:0px;margin-right:22.008px;border:1px solid #ebebeb !important;}
            .tabtop .active a:before{content:"♦";position:absolute;top:15px;left:82px;color:#0f1e8b;font-size:30px;}
            .tabtop li a:hover{color:#0f1e8b !important;text-decoration:none;}
            .tabtop .active a:hover{color:#fff !important;}
            .tabtop .active a{background-color:#0f1e8b !important;color:#FFF !important;}
            .margin-tops{margin-top:30px;}
            .tabtop li a:last-child{padding:10px 22px;}
            .thbada{padding:10px 28px !important;}
            section p{font-family:'Lato', sans-serif;}
            .margin-tops4{margin-top:20px;}
            .tabsetting{border-top:5px solid #ebebeb;padding-top:6px;}
            .services{background-color:#d4d4d4;min-height:710px;padding:65px 0 27px 0;}
            .services a:hover{color:#000;}
            .services h1{margin-top:0px !important;}
            .heading-container p{font-family:'Lato', sans-serif;text-align:center;font-size:16px !important;text-transform:uppercase;}
        </style> 
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


        <c:if test="${requestScope.error!=null}">
            <script>swal("<c:out value="${requestScope.error}"/>!", "", "warning");</script>   
        </c:if>
        <c:if test="${requestScope.msg!=null}">
            <script>swal("<c:out value="${requestScope.msg}"/>!", "", "success");</script>   
        </c:if>

        <div class="container">
            <h1 class="heading1 align-items-center">Reportes</h1>
        </div>


        <div class="container">

            <!--our-quality-shadow-->
            <div class="clearfix"></div>

            <div class="tabbable-panel margin-tops4 ">
                <div class="tabbable-line">
                    <ul class="nav nav-tabs tabtop  tabsetting">
                        <li class="active"> <a href="#filtrocomunal" data-toggle="tab">Filtro Comunal</a> </li>
                        <li> <a href="#reservasfechas" data-toggle="tab">Reservas por Fechas</a> </li>
                        <li> <a href="#filtronumeropersonas" data-toggle="tab">Búsqueda por Número de Personas</a> </li>
                        <li> <a href="#transporte" data-toggle="tab" class="thbada">Planificación Transporte </a> </li>
                    </ul>
                    <div class="tab-content margin-tops">
                        <div class="tab-pane active fade in" id="filtrocomunal">
                            <div class="col-md-7">
                                <form method="post" action="Busquedaporcomunas" role="form">
                                    <section class="panel panel-default">

                                        <div class="panel-body">
                                            <div class="form-group col-lg-8">
                                                <label>Seleccionar Comuna</label>
                                                <select class="form-control selectric" name="ubicacion" required="">
                                                    <option value="<%=request.getParameter("ubicacion")%>"><%=request.getParameter("ubicacion")%></option>

                                                    <%
                                                        LocalidadService lo = new LocalidadService();
                                                        List<Localidad> dato = lo.listarLocalidades();
                                                        for (Localidad d : dato) {
                                                    %>
                                                    <option value="<%= d.getNombreLocalidad()%>"><%= d.getNombreLocalidad()%></option>  
                                                    <%}%>
                                                </select>                                               </div>

                                        </div>
                                        <footer class="panel-footer text-right bg-light lter">
                                            <input type="submit" class="btn btn-primary active" name="accion" value="Buscar">&nbsp&nbsp;
                                        </footer>
                                    </section> 
                                </form>   


                            </div>
                            <div class="col-md-12">
                                <table id="ejemplo" class="table table-striped table-hover" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Rut</th>
                                            <th>Cliente</th>
                                            <th>Departamento</th>
                                            <th>Fecha Reserva</th>
                                            <th>Locación</th>
                                            <th>Fecha Salida</th>  
                                            <th>N° de Personas</th>
                                            <th>Monto</th>
                                        </tr>
                                    </thead>
                                    <tbody id="myTable">
                                        <%
                                            //   String rut = (String)request.getParameter("rut");
                                            String ubicacion = ((String) request.getParameter("ubicacion"));
                                            System.out.print(" Comuna " + ubicacion);
                                            ReservasService reser = new ReservasService();
                                            List<Reservas> datos = reser.listarreservasporcomuna(ubicacion);
                                            for (Reservas d : datos) {
                                        %>
                                        <tr>
                                            <td><%= d.getIdReserva()%></td>
                                            <td><%= d.getRut()%></td>
                                            <td><%= d.getNombre()%></td>
                                            <td><%= d.getNombre1()%></td>
                                            <td><%= d.getFechaReserva()%></td>
                                            <td><%= d.getUbicacion()%></td>
                                            <td><%= d.getFechaSalida()%></td>
                                            <td><%= d.getCantidadPersonas()%></td>
                                            <td><%= d.getValorarriendo()%></td>

                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="reservasfechas">
                            <div class="col-md-7">
                                <form method="post" action="Busquedaporfechas" role="form">
                                    <section class="panel panel-default">

                                        <div class="panel-body">
                                            <div class="form-group col-lg-5">
                                                <label>Fecha Inicial</label>
                                                <input id="fecha_inicio" type="date" name="fecha_inicio" class="form-control" placeholder="Ingresar fecha inicial *" required="required" value="">
                                            </div>
                                            <div class="form-group col-lg-5">
                                                <label>Fecha Final</label>
                                                <input id="fecha_final" type="date" name="fecha_final" class="form-control" placeholder="Ingresar fecha final *" required="required" value="">
                                            </div>
                                        </div>
                                        <footer class="panel-footer text-right bg-light lter">
                                            <input type="submit" class="btn btn-primary active" name="accion" value="Buscar">&nbsp&nbsp;
                                        </footer>
                                    </section> 
                                </form> 
                            </div>

                        </div>           
                        <div class="tab-pane fade" id="filtronumeropersonas">
                            <div class="col-md-4">
                                <form method="post" action="Busquedaporpersonas" role="form">
                                    <section class="panel panel-default">

                                        <div class="panel-body">
                                            <div class="form-group col-lg-10">
                                                <label>Ingresar Número de Personas</label>
                                                <input id="cantidad_personas" type="number" name="cantidad_personas" class="form-control" placeholder="Ingresar Cantidad Personas *" required="required" value="">
                                            </div>

                                        </div>
                                        <footer class="panel-footer text-right bg-light lter">
                                            <input type="submit" class="btn btn-primary active" name="accion" value="Buscar">&nbsp&nbsp;
                                        </footer>
                                    </section> 
                                </form>  
                            </div>

                        </div> 

                        <div class="tab-pane fade" id="transporte">
                            <div class="col-md-7">
                                <form method="post" action="Busquedatransporte" role="form">
                                    <section class="panel panel-default">

                                        <div class="panel-body">
                                            <div class="form-group col-lg-5">
                                                <label>Fecha Inicial</label>
                                                <input id="fecha_inicio" type="date" name="fecha_inicio" class="form-control" placeholder="Ingresar fecha inicial *" required="required" value="">
                                            </div>
                                            <div class="form-group col-lg-5">
                                                <label>Fecha Final</label>
                                                <input id="fecha_final" type="date" name="fecha_final" class="form-control" placeholder="Ingresar fecha final *" required="required" value="">
                                            </div>
                                        </div>
                                        <footer class="panel-footer text-right bg-light lter">
                                            <input type="submit" class="btn btn-primary active" name="accion" value="Buscar">&nbsp&nbsp;
                                        </footer>
                                    </section> 
                                </form>                              </div>

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