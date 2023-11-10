<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/modulos.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
    </head>
    <body>
        
        <div class="container">
            
            <div class="row mt-2">
                <div class="col col-md">
                    <h1>Gestionar Usuarios</h1>
                </div>
            </div>
            
            <div class="row mt-2">
                <div class="col col-md">
                     <table class="table">
                        <thead>
                            <tr>
                                <th>Nº</th>
                                <th>Fecha Registro</th>
                                <th>Nombre Completo</th>
                                <th>Usuario</th>
                                <th>Reiniciar Credenciales</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>

                        <tbody id="tblJugadores"></tbody>
                    </table>
                </div>
            </div>
            
        </div>
        
        <!-- Modal Confirmar proceso de datos -->
        <div id="modal-reiniciar" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="color: white; width: 100%;font-size: 20px;margin-top: 3px">LIMA HEAT</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: white;font-size: 15px;">¿Seguro que desea reiniciar las credenciales del usuario?</p>
                    </div>
                    <div class="modal-footer btnLogin">
                        <button style="width: 30%;font-size: 15px" type="button" id="btnModalReiniciarAceptar" data-dismiss="modal">Aceptar</button>
                        <button style="width: 30%;font-size: 15px" type="button" id="btnModalReiniciarCancelar" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
        <!-- Modal Confirmar proceso de datos -->
        <div id="modal-eliminar" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="color: white; width: 100%;font-size: 20px;margin-top: 3px">LIMA HEAT</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: white;font-size: 15px;">¿Seguro que desea eliminar el usuario?</p>
                    </div>
                    <div class="modal-footer btnLogin">
                        <button style="width: 30%;font-size: 15px" type="button" id="btnModalEliminarAceptar" data-dismiss="modal">Aceptar</button>
                        <button style="width: 30%;font-size: 15px" type="button" id="btnModalEliminarCancelar" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
        

        


            <%@include file="components/includes/footer.jspf"%>

            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="js/gestionarUsuarios.js"></script>
    </body>

</html>