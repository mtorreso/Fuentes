<%@page import="webservice.Inventarios"%>
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
<%
    int id1 = Integer.parseInt((String) request.getAttribute("id"));
    DepartamentoService depto = new DepartamentoService();
    Departamento d1 = depto.listarpordepartamento(id1);
%>
<html lang="en">
    <head>
        <title>Turismo Real | Inventario <%=d1.getNombre()%></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!--usuarios!!-->
        <link type="text/css" rel="stylesheet" href="turismo/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
        <script>
            var idioma =
                    {
                        "sProcessing": "Procesando...",
                        "sLengthMenu": "Mostrar _MENU_ registros",
                        "sZeroRecords": "No se encontraron resultados",
                        "sEmptyTable": "NingÃºn dato disponible en esta tabla",
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
                                title: 'Reporte Inventario <%=d1.getNombre()%> ',
                                titleAttr: 'Copiar',
                                className: 'btn btn-app export barras',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6]
                                }
                            },

                            {
                                extend: 'pdfHtml5',
                                text: '<i class="fa fa-file-pdf-o"></i>PDF',
                                title: 'Reporte Inventario <%=d1.getNombre()%>',
                                titleAttr: 'PDF',
                                className: 'btn btn-app export pdf',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6]
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
                                title: 'Reporte Inventario <%=d1.getNombre()%>',
                                titleAttr: 'Excel',
                                className: 'btn btn-app export excel',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6]
                                },
                            },
                            {
                                extend: 'csvHtml5',
                                text: '<i class="fa fa-file-text-o"></i>CSV',
                                title: 'Reporte Inventario <%=d1.getNombre()%>',
                                titleAttr: 'CSV',
                                className: 'btn btn-app export csv',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6]
                                }
                            },
                            {
                                extend: 'print',
                                text: '<i class="fa fa-print"></i>Imprimir',
                                title: 'Reporte Inventario <%=d1.getNombre()%>',
                                titleAttr: 'Imprimir',
                                className: 'btn btn-app export imprimir',
                                exportOptions: {
                                    columns: [0, 1, 2, 3, 4, 5, 6]
                                }
                            }
                        ]


                    }

                });


            });
        </script>

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
                    <li class="nav-item "><a href="indexadmin.jsp" class="nav-link"><i class="fa fa-home"></i><span>Home</span></a></li>
                    <li class="nav-item active"><a href="Usuarios.jsp" class="nav-link"><i class="fa fa-user-o"></i><span>Usuarios</span></a></li>
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
                    <li class="active">Inventario <%=d1.getNombre()%></li>
                </ol> 
            </div>
        </div>

        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Inventario <%=d1.getNombre()%></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="inventario?accion=nuevo&id=<%=d1.getId()%>" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>Nuevo</span></a>
                        </div>
                    </div>
                </div>
                <table id="ejemplo" class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Departamento</th>
                            <th>Locación</th>
                            <th>Producto</th> 
                            <th>Categoría</th>
                            <th>Stock</th> 
                            <th>Estado</th>                            
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody id="myTable">
                        <%
                            //   String rut = (String)request.getParameter("rut");
                            int id = Integer.parseInt((String) request.getAttribute("id"));
                            System.out.print("id departamento " + id);
                            InventarioService in = new InventarioService();
                            List<Inventarios> dato = in.listarInventario(id);
                            for (Inventarios d : dato) {
                        %>
                        <tr>
                            <td><%= d.getIdInv()%></td>
                            <td><%= d.getNombre()%></td>
                            <td><%= d.getUbicacion()%></td>
                            <td><%= d.getProducto()%></td>
                            <td><%= d.getCategoria()%></td>
                            <td><%= d.getCantidad()%></td>
                            <td><%= d.getEstado()%></td>   
                            <td>
                                <a href="modinventario?accion=modificar&id=<%= d.getIdInv()%>" class="edit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                <a href="Eliminarinventario?accion=eliminar&id=<%= d.getIdInv()%>" class="delete"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>

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