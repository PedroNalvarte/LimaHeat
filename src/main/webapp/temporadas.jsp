<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Temporadas</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/temporadas.css"/>
    </head>
    <body>
        <h1>Temporadas</h1>
        
        <div class="container" id="mainContainer">
            
        </div>
        
        
        <!---- Modal Detalle de temporada --->
        <div id="modal-creacion" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 3px">LIMA HEAT</center>
                    </div>
                    <div class="modal-body">
                        <form action = "action" id="crearTemporada">
                             <div class="row mt-4">
                                <div class="col col-md-12">
                                    <input id="nombreTemporada" name="nombreTemporada" type="text" class="form-control" placeholder="Nombre de Temporada" required>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="fechaInicio">Fecha de inicio:</label>
                                    <input id="fechaInicio" name="fechaInicio "type="date" placeholder="Fecha de Inicio" class="form-control"  required/>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="fechaFin">Fecha de fin:</label>
                                    <input id="fechaFin" name="fechaFin" type="date" placeholder="Fecha de Fin" class="form-control"  required/>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <select id="tipoTemporada" name="tipoTemporada" class="form-control" required>
                                        <option>--Seleccionar Tipo--</option>
                                    </select>
                                </div>
                                
                            <div class="modal-footer btnLogin">
                                <button type="submit" value="registrar" data-dismiss="modal">Registrar</button>
                             </div>
                                
                            </div>
                         </form>    
                    </div>
                        
                    
                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
         <%@include file="components/includes/footer-login.jspf"%>
         <script src="js/temporadas.js"></script>
    </body>
</html>
