
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrenadores</title>
        <%@include file="components/includes/header.jspf"%>
    </head>
    <body>
        <h1>Entrenadores</h1>
        <br>
        <h2>Busqueda</h2>
        <div class="input-group">
            <div class="col-sm-8">
                <input type="text" class="form-control" id="busquedaE" onkeyup="buscarEntrenador()" placeholder="Buscar por nombre o apellidos..."/>
            </div>
           
            <div class="input-group-append mx-2">
                <button class="btn btn-danger" type="button" id="btn-registrar-entrenador">REGISTRAR NUEVO ENTRENADOR</button>
            </div>
           
        </div>
            
        <br><br>
        <div id="idParticipante" hidden><%=logged.getIdParticipante()%></div>
        <div id="idTipoCuenta" hidden><%=logged.getIdTipoCuenta()%></div>
        
        <div id="contenidoCol">
            
            
        </div>
        
        
          
        <!---- Modal Registrar entrenador --->
        <div id="modal-creacion-entrenador" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px;">Registrar Nuevo Entrenador</center>
                    </div>
                    <div class="modal-body">
                        <form action = "action" id="registrarEntrenador">
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="nombreEntrenador" >Nombre del Entrenador:</label>
                                    <input id="nombreEntrenador" name="nombreEntrenador" type="text" class="form-control" placeholder="Nombre del Entrenador" required>
                                </div>
                            </div>
                          <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="apellido1Entrenador" >Primer Apellido:</label>
                                    <input id="apellido1Entrenador" name="apellido1Entrenador" type="text" class="form-control" placeholder="Primer Apellido" required>
                                </div>
                            </div>
                              <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="apellido2Entrenador" >Segundo Apellido:</label>
                                    <input id="apellido2Entrenador" name="apellido2Entrenador" type="text" class="form-control" placeholder="Segundo Apellido" required>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <select id="tipoDocumento" name="tipoDocumento" class="form-control" required>
                                        <option>--Tipo de Documento de Identidad--</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="numeroDocumento">Número de Documento de Identidad:</label>
                                    <input id="numeroDocumento" name="numeroDocumento" type="text" class="form-control" placeholder="Número de Documento de Identidad" required>
                                </div>
                            </div>
                             <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="fechaNacimiento" >Fecha de Nacimiento:</label>
                                    <input id="fechaNacimiento" name="fechaNacimiento" type="date" placeholder="Fecha de Inicio" class="form-control"  required/>
                                </div>
                            </div>
                            <div>

                                <div class="modal-footer ">
                                    <button type="submit" value="registrar" class="btnRegistrar" data-dismiss="modal">Registrar <i class="bi bi-plus-circle"></i></button>
                                </div>

                            </div>
                        </form>    
                    </div>


                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
                 <!---- Modal Eliminar Entrenador --->
        <div id="modal-eliminar-entrenador" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px;" >ELIMINAR ENTRENADOR</center>
                    </div>
                    <div class="modal-body">
                        <p>¿Estás seguro de que deseas eliminar a este entrenador?</p>
                    </div>
                    <div class="modal-footer ">
                                    <button value="SI" class="btn btn-danger" id="confirmar-eliminar" data-dismiss="modal">SI</button>
                                    <button value="NO" class="btn btn-primary" id="cancelar-eliminar" data-dismiss="modal">NO</button>
                    </div>

                            
                           
                    </div>


                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
                  
        <!---- Modal Editar Entrenador-->
        <div id="modal-editar-entrenador" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px;">Editar Colaborador</center>
                    </div>
                    <div class="modal-body">
                        <form action = "action" id="editarEntrenador">
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="nombreEntrenadorE" >Nombre del Colaborador:</label>
                                    <input id="nombreEntrenadorE" name="nombreEntrenadorE" type="text" class="form-control" placeholder="Nombre del Colaborador" required>
                                </div>
                            </div>
                          <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="apellido1EntrenadorE" >Primer Apellido:</label>
                                    <input id="apellido1EntrenadorE" name="apellido1EntrenadorE" type="text" class="form-control" placeholder="Primer Apellido" required>
                                </div>
                            </div>
                              <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="apellido2EntrenadorE" >Segundo Apellido:</label>
                                    <input id="apellido2EntrenadorE" name="apellido2EntrenadorE" type="text" class="form-control" placeholder="Segundo Apellido" required>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <select id="tipoDocumentoE" name="tipoDocumentoE" class="form-control" required>
                                        <option>--Tipo de Documento de Identidad--</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="numeroDocumentoE">Número de Documento de Identidad:</label>
                                    <input id="numeroDocumentoE" name="numeroDocumento" type="text" class="form-control" placeholder="Número de Documento de Identidad" required>
                                </div>
                            </div>
                             <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="fechaNacimientoE" >Fecha de Nacimiento:</label>
                                    <input id="fechaNacimientoE" name="fechaNacimiento" type="date" placeholder="Fecha de Inicio" class="form-control"  required/>
                                </div>
                            </div>
                            <div>

                                <div class="modal-footer ">
                                    <button type="submit" value="editar" class="btnEditarEntrenador" id="confirmarEditarEntrenador" data-dismiss="modal">Editar<i class="bi bi-plus-circle"></i></button>
                                </div>

                            </div>
                        </form>    
                    </div>


                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
    <%@include file="components/includes/footer.jspf"%>
    <script src="js/entrenadores.js"></script>
    </body>
</html>
