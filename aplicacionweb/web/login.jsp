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
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Turismo Real - Portafolio de Titulo</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="docsupport/prism.css">
        <link rel="stylesheet" href="chosen.css">
        <link rel="stylesheet" href="css/admin.css">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" /> 
        <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="js/validarut.js"></script>
        <script src="js/validarCampos.js"></script>
        <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
        <script src="js/<a href="https://www.jqueryscript.net/tags.php?/Validation/">Validation</a>FormScript.js"></script>
</head>
<style>
    .input-group-addon {
        color: #fff;
        background-color: #337ab7;
    }


    .form-control, .input-group-addon {
        border-radius: 0px;
    }
    label{
        text-align: left !important;
    }
</style>
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
        <script>swal("<c:out value="${requestScope.error}"/>!", "", "warning");</script>   
    </c:if>
    <c:if test="${requestScope.msg!=null}">
        <script>swal("<c:out value="${requestScope.msg}"/>!", "", "success");</script>   
    </c:if>

    <div class="container">
        <div class="container">    
            <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-5 col-md-offset-4 col-sm-7 col-sm-offset-3">                    
                <div class="panel panel-primary" >
                    <div class="panel-heading">
                        <div class="panel-title text-center"><i class="fa fa-sign-in" aria-hidden="true"></i>Control de Acceso</div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

                        <form id="loginform" action="ValidarUser" method="POST" class="form-horizontal">

                            <div style="margin-bottom: 25px" class="input-group col-sm-offset-3 col-sm-7">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="login-username" type="text" class="form-control input-sm" name="correo" value="" placeholder="correo@mail.com" required>                                        
                            </div>

                            <div style="margin-bottom: 25px" class="input-group col-sm-offset-3 col-sm-7">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" type="password" class="form-control input-sm" name="clave" placeholder="Contraseña" required>
                            </div>
                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls text-center">
                                    <input type="submit" name="login" class="btn btn-primary active btn-sm" value="Iniciar Sesión" required>
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-12 control">
                                    <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                        No tienes una cuenta! 
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Registrarse Aquí
                                        </a>
                                    </div>
                                </div>
                            </div>    
                        </form>     



                    </div>                     
                </div>  
            </div>
            <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-5 col-md-offset-4 col-sm-7 col-sm-offset-3">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="panel-title text-center">Nueva Cuenta<i class="fa fa-user-plus"></i></div>
                        <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                    </div>  
                    <div class="panel-body" >
                        <form id="form1" class="form-horizontal" method="post" action="NuevaCuenta" role="form">

                            <div id="signupalert" style="display:none" class="alert alert-danger">
                                <p>Error:</p>
                                <span></span>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-md-4 control-label">Rut</label>
                                <div class="col-md-8">
                                    <input id="rut" type="text" name="rut" class="form-control" required="required" placeholder="18215854-1" value="" onblur="onRutBlur(this);">                      
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="firstname" class="col-md-4 control-label">Nombres</label>
                                <div class="col-md-8">
                                    <input id="nombre" type="text" name="nombre" class="form-control" placeholder="" required="required">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastname" class="col-md-4 control-label">Email</label>
                                <div class="col-md-8">
                                    <input id="correo" type="email" name="correo" class="form-control" required="required" data-error="Dirección de email es requerida." value="" > 
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-md-4 control-label">Fono</label>
                                <div class="col-md-8">
                                    <input id="telefono" type="tel" name="telefono" class="form-control" required="required" data-error="Fono es requerido." value="" >   
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="icode" class="col-md-4 control-label">Password</label>
                                <div class="col-md-8">
                                    <input id="password" type="password" name="clave" class="form-control" placeholder="" required="required">
                                </div>
                            </div>
                            <input id="id_rol" type="hidden" name="id_rol" class="form-control"  value="3" >   

                            <div class="form-group">
                                <!-- Button -->                                        
                                <div class="col-md-offset-4 col-md-8">
                                    <input type="submit" class="btn btn-primary active btn-sm" value="Guardar">&nbsp&nbsp;<button type="reset" class="btn btn-warning btn-sm">Cancelar</button>
                                </div>
                            </div>
                            <script>
                                $('#form1').validate({

                                    rules: {}

                                }
                                );

                            </script>
                            <div class="form-group">
                                <div class="col-md-12 control">
                                    <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                        Tienes una cuenta ! 
                                        <a href="#" onClick="$('#signupbox').hide(); $('#loginbox').show()">
                                            Iniciar Sesión Aquí
                                        </a>
                                    </div>
                                </div>
                            </div>


                        </form>
                    </div>
                </div>




            </div> 
        </div>

    </div>
    <script src="js/chosen.jquery.js" type="text/javascript"></script>
    <script src="docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
    <script src="docsupport/init.js" type="text/javascript" charset="utf-8"></script>

</body> 
</html>
