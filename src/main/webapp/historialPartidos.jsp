<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial de Partidos</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/historialPartidos.css"/>
         <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <div class="col col-md-9">
                    <h1 id="titulo">Historial de Partidos</h1>
                    <h3 id="temporada"></h3>
                </div>
                <div style="" class="col col-md-3">
                    <div style="text-align: center" class="col-md-2">
                        <button class="mi-button" onclick="registrarNuevo()">
                            <div class="agregar">
                                <i style="font-size: 25px" class="bi bi-plus-circle-fill"></i>
                                <h2 style="font-size: 15px">Registrar Nuevo Partido</h2>
                            </div>
                        </button>
                    </div>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col col-md-12">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nº</th>
                                <th>Resultado</th>
                                <th>Detalle del Resultado</th>
                                <th>Lugar</th>
                                <th>Fecha</th>
                                <th>Acción</th>
                            </tr>
                        </thead>
                        <tbody id="tblPartidos"></tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Modal registrar partido -->
        <div id="modal-registrar" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-xl ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px; color: white">REGISTRAR NUEVO PARTIDO</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px;color: white">Ingrese el Partido a Registrar.</p>

                        <form action="action" id="registrarPartido">

                            <div class="row">
                                <div class="col col-md-4">
                                    <label for="resultado" style="color: white"><strong>Resultado:</strong></label>
                                    <select id="resultado" class="form-control" required>
                                        <option value="Pendiente">Pendiente</option>
                                        <option value="Ganado">Ganado</option>
                                        <option value="Perdido">Perdido</option>
                                        <option value="Empate">Empate</option>
                                    </select>
                                </div>
                                <div class="col col-md-4">
                                    <label for="detalleResultado" style="color: white"><strong>Detalle Partido:</strong></label>
                                    <input id="detalleResultado" class="form-control" required> 
                                </div>

                                <div class="col col-md-4">
                                    <label for="lugar" style="color: white"><strong>Lugar:</strong></label>
                                    <input id="lugar" class="form-control" required> 
                                </div>
                            </div>
                            <div class="modal-footer btnLogin mt-2">
                                <button style="width: 30%;font-size: 15px; color: white; background-color: #CA8B29; border-color: #CA8B29" type="submit" data-dismiss="modal">Registrar Partido</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!---- Modal Editar Partido--->
        <!-- Modal para editar partido -->
        <div id="modal-editar" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm">
                <!-- Contenido del modal de edición -->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%; font-size: 20px; margin-top: 10px;">Editar Partido</center>
                    </div>
                    <div class="modal-body">
                        <form action="registrarPartido" method="post" id="editarPartidoForm">
                            <div class="form-group">
                                <label for="resultadoE">Resultado:</label>
                                <select class="form-control" id="resultadoE" name="resultadoE">
                                    <option value="Pendiente">Pendiente</option>
                                    <option value="Ganado">Ganado</option>
                                    <option value="Perdido">Perdido</option>
                                    <option value="Empate">Empate</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="detalleResultadoE">Detalle del Resultado:</label>
                                <input type="text" class="form-control" id="detalleResultadoE" name="detalleResultadoE" required>
                            </div>
                            <div class="form-group">
                                <label for="lugarE">Lugar:</label>
                                <input type="text" class="form-control" id="lugarE" name="lugarE" required>
                            </div>
                            <input type="hidden" id="ID_PARTIDOE" name="ID_PARTIDOE">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" id="btnEditarPartido">Guardar Cambios</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>


        <!-- Fin Modal -->

        <!---- Modal Eliminar Partido --->
        <div id="modal-eliminar-Partido" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px;" >ELIMINAR PARTIDO</center>
                    </div>
                    <div class="modal-body">
                        <p>¿Estás seguro de que deseas eliminar este Partido?</p>
                    </div>
                    <div class="modal-footer ">
                        <button value="SI" class="btn btn-danger" id="confirmar-eliminar" data-dismiss="modal">SI</button>
                        <button value="NO" class="btn btn-primary" id="cancelar-eliminar" data-dismiss="modal">NO</button>
                    </div>
                </div>
            </div>
        </div>
        
    <%@include file="components/includes/footer.jspf"%>
    <script src="js/historialPartidos.js"></script>

    </body>
</html>
