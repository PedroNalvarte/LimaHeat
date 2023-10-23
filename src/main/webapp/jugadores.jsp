<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/jugadores.css"/>
    </head>
    <body>
        
        

        <div class="container">

            <div class="row">

                <div class="col col-md-9">
                    <h1 id="titulo"></h1>
                    <h3 id="temporada"></h3>
                </div>

                <div style="" class="col col-md-3">
                    <div style="text-align: center" class="col-md-2">
                        <button class="mi-button" onclick="registrarNuevo()">
                            <div class="agregar">
                                <i style="font-size: 25px" class="bi bi-plus-circle-fill"></i>
                                <h2 style="font-size: 15px">Registrar Nuevo Jugador</h2>
                            </div>
                        </button>
                    </div>
                </div>

            </div>

            <div class="row mt-3">

                <div class="col col-md-12">

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nº</th>
                                <th>Nombre Completo</th>
                                <th>Tipo Documento</th>
                                <th>Numero Documento</th>
                                <th>Dorsal</th>
                                <th>Posicion</th>
                                <th>Edad</th>
                                <th>Peso</th>
                                <th>Estatura</th>
                                <th>Editar</th>
                                <th>Estadisticas</th>
                            </tr>
                        </thead>

                        <tbody id="tblJugadores"></tbody>
                    </table>
                    
                </div>

            </div>

        </div>

        <!-- Modal registrar equipo rival -->
        <div id="modal-registrar" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-xl ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px; color: white">REGISTRAR NUEVO JUGADOR</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px;color: white">Ingrese los datos del jugador que desea registrar.</p>

                        <form action="action" id="registrar-jugador">

                            <div class="row">
                                <div class="col col-md-4">
                                    <label for="ddlCategoria" style="color: white"><strong>Nombre:</strong></label>
                                    <input id="txtNom" class="form-control" required>  
                                </div>

                                <div class="col col-md-4">
                                    <label for="ddlCategoria" style="color: white"><strong>Primer Apellido:</strong></label>
                                    <input id="txtApe1" class="form-control" required> 
                                </div>

                                <div class="col col-md-4">
                                    <label for="ddlCategoria" style="color: white"><strong>Segundo Apellido:</strong></label>
                                    <input id="txtApe2" class="form-control" required> 
                                </div>
                            </div>

                            <div class="row mt-2">
                                <div class="col col-md-7">
                                    <div class="row">
                                        <div class="col col-md-6">
                                            <label for="ddlDocId" style="color: white"><strong>Tipo Documento Identidad:</strong></label>
                                            <select id="ddlDocId" class="form-control" required></select>
                                        </div>

                                        <div class="col col-md-6">
                                            <label for="txtDocIde" style="color: white"><strong>Número Documento Identidad:</strong></label>
                                            <input id="txtDocIde" class="form-control" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="col col-md-5">

                                    <div class="row">
                                        <div class="col col-md-6">
                                            <label for="txtPeso" style="color: white"><strong>Peso:</strong></label>
                                            <input id="txtPeso" class="form-control" required>
                                        </div>

                                        <div class="col col-md-6">
                                            <label for="txtAltura" style="color: white"><strong>Altura:</strong></label>
                                            <input id="txtAltura" class="form-control" required>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col col-md-4">
                                    <label for="fecNac" style="color: white"><strong>Fecha de Nacimiento:</strong></label>
                                    <input id="fecNac" class="form-control" type="date" required>  
                                </div>

                                <div class="col col-md-4">
                                    <label for="ddlPosicion" style="color: white"><strong>Posición:</strong></label>
                                    <select id="ddlPosicion" class="form-control" required></select>
                                </div>

                                <div class="col col-md-4">
                                    <label for="txtDorsal" style="color: white"><strong>Número Dorsal:</strong></label>
                                    <input id="txtDorsal" class="form-control" required> 
                                </div>
                            </div>

                            <div class="modal-footer btnLogin mt-2">
                                <button style="width: 30%;font-size: 15px; color: white; background-color: #CA8B29; border-color: #CA8B29" type="submit" data-dismiss="modal">Registrar Jugador</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
        <!-- Modal registrar equipo rival -->
        <div id="modal-editar" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-xl ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px; color: white">EDITAR JUGADOR</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px;color: white">Ingrese los datos del jugador que desea editar.</p>

                        <form action="action" id="editar-jugador">

                            <div class="row">
                                <div class="col col-md-4">
                                    <label for="ddlCategoria" style="color: white"><strong>Nombre:</strong></label>
                                    <input id="edttxtNom" class="form-control" required>  
                                </div>

                                <div class="col col-md-4">
                                    <label for="ddlCategoria" style="color: white"><strong>Primer Apellido:</strong></label>
                                    <input id="edttxtApe1" class="form-control" required> 
                                </div>

                                <div class="col col-md-4">
                                    <label for="ddlCategoria" style="color: white"><strong>Segundo Apellido:</strong></label>
                                    <input id="edttxtApe2" class="form-control" required> 
                                </div>
                            </div>

                            <div class="row mt-2">
                                <div class="col col-md-7">
                                    <div class="row">
                                        <div class="col col-md-6">
                                            <label for="ddlDocId" style="color: white"><strong>Tipo Documento Identidad:</strong></label>
                                            <select id="edtddlDocId" class="form-control" required></select>
                                        </div>

                                        <div class="col col-md-6">
                                            <label for="txtDocIde" style="color: white"><strong>Número Documento Identidad:</strong></label>
                                            <input id="edttxtDocIde" class="form-control" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="col col-md-5">

                                    <div class="row">
                                        <div class="col col-md-6">
                                            <label for="txtPeso" style="color: white"><strong>Peso:</strong></label>
                                            <input id="edttxtPeso" class="form-control" required>
                                        </div>

                                        <div class="col col-md-6">
                                            <label for="txtAltura" style="color: white"><strong>Altura:</strong></label>
                                            <input id="edttxtAltura" class="form-control" required>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col col-md-6">
                                    <label for="edtddlPosicion" style="color: white"><strong>Posición:</strong></label>
                                    <select id="edtddlPosicion" class="form-control" required></select>
                                </div>

                                <div class="col col-md-6">
                                    <label for="edttxtDorsal" style="color: white"><strong>Número Dorsal:</strong></label>
                                    <input id="edttxtDorsal" class="form-control" required> 
                                </div>
                            </div>

                            <div class="modal-footer btnLogin mt-2">
                                <button id="btnEditar" style="width: 30%;font-size: 15px; color: white; background-color: #CA8B29; border-color: #CA8B29" type="submit" data-dismiss="modal">Editar Jugador</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->



        <%@include file="components/includes/footer.jspf"%>
        <script src="js/jugadores.js"></script>
    </body>

</html>
