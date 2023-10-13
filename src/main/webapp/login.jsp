<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesion</title>
        <%@include file="components/includes/header-noUser.jspf"%>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="stylesheet" href="css/login.css"/>
    </head>
    <body>

        <div class="container-fluid">
        <div class="row justify-content-end align-items-center" style="background-image: url('img/jugador.png'); background-size: cover; height: 100vh;">
            <div class="col-md-6 col-lg-4 mr-4"> <!-- Cambiamos col-md-4 a col-md-6 y col-lg-4 -->
                <form action="action" id="inicio-sesion" style="background-color: rgba(45, 45, 44, 0.2); padding: 20px; border-radius: 10px;">
                    <center><h2 class="mb-4">INICIAR SESIÓN</h2></center>
                    <div class="form-group">
                        <input id="txtUsername" type="text" class="form-control" placeholder="Ingrese su Usuario" required>
                    </div>
                    <div class="form-group">
                        <input id="txtPassword" type="password" class="form-control" placeholder="Ingrese su Contraseña" required>
                    </div>
                    <button id="btnIngresar" type="submit" class="btn btn-primary btn-block">INGRESAR</button>
                </form>
            </div>
        </div>
    </div>



        <div>
           
        </div>

        <!-- Modal Confirmar proceso de datos -->
        <div id="modal-verificacion" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 3px">LIMA HEAT</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px;" id="mensaje"></p>
                    </div>
                    <div class="modal-footer btnLogin">
                        <button style="width: 30%;font-size: 15px" type="button" id="btnModalAceptar" data-dismiss="modal">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->

        <!-- Modal cambio de contraseña -->
        <div id="modal-cambio-contraseña" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-md ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 3px">LIMA HEAT</center>
                    </div>
                    <div class="modal-body">
                        
                        <p style="color: black;font-size: 15px;">Parece que es la primera vez que inicia sesion, debe cambiar su contraseña.</p>
                       
                        <form action="action" id="cambio-contraseña">
                            
                        <div class="row mt-2">
                            <div class="col col-md-12">
                                <label><strong>Nueva Contraseña:</strong></label>
                                <input id="txtNuevoPassword" class="form-control" required>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col col-md-12">
                                <label><strong>Repetir Nueva Contraseña:</strong></label>
                                <input id="txtRepetirPassword" class="form-control" required>
                            </div>
                        </div>
                        <div class="row mt-2 mb-3">
                            <div class="col col-md-12">
                                <p style="color: red;" id="mensajeTexto"></p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="modal-footer">
                        
                        <button id="btnModalContrasenaAceptar" style="width: 30%;font-size: 15px" type="submit"data-dismiss="modal">Aceptar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->



        <%@include file="components/includes/footer-noUser.jspf"%>
        <script src="js/login.js"></script>
    </body>
</html>