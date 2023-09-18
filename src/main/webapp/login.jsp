<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesion</title>
        <%@include file="components/includes/header-login.jspf"%> 
    </head>
    <body>
        
        <div >
            <form action="action" id="inicio-sesion">
                <input id="txtUsername" type="text" placeholder="Usuario" required>
                <input id="txtPassword" type="password" placeholder="Contraseña" required>
                <button type="button">¿Olvidaste tu contraseña?</button>
                <button type="submit">Ingresar</button>
            </form>
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
        
        <!-- Modal Confirmar proceso de datos -->
        <div id="modal-cambio-contraseña" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-md ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 3px">LIMA HEAT</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px;">Parece que es la primera vez que inicia sesion, debe cambiar su contraseña.</p>
                        <input id="txtNuevoPassword" type="text" placeholder="Nueva Contraseña" >
                    </div>
                    <div class="modal-footer btnLogin">
                        <button style="width: 30%;font-size: 15px" type="button" id="btnModalContrasenaAceptar" data-dismiss="modal">Aceptar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
        
        
        <%@include file="components/includes/footer-login.jspf"%>
        <script src="js/login.js"></script>
    </body>
</html>
