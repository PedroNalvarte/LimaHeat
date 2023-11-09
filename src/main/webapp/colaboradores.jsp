 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Colaboradores</title>
        <%@include file="components/includes/header.jspf"%>
    </head>
    <body>
        
        <div id="idParticipante" hidden><%=logged.getIdParticipante()%></div>
        <div id="idTipoCuenta" hidden><%=logged.getIdTipoCuenta()%></div>

        <div class="container">

            <div class="row">
                <div class="col col-md-12">
                    <h1>Administrar Colaboradores</h1> 
                </div>
            </div>

            <div class="row mt-2">
                <div class="col col-md-10">
                    <h2>Busqueda</h2>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="busquedaC" onkeyup="buscarColaborador()" placeholder="Buscar por nombre o apellidos..."/>
                    </div>
                </div>

                <div class="col col-md-2">
                    <div class="input-group-append mx-2">
                        <button class="btn btn-danger" type="button" id="btn-registrar-colaborador">REGISTRAR NUEVO COLABORADOR</button>
                    </div>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col col-md-12">
                    <div id="contenidoCol">

                    </div>
                </div>
            </div>

        </div>

        <!---- Modal Registrar colaborador --->
        <div id="modal-creacion-colaborador" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px;">Registrar Nuevo Colaborador</center>
                    </div>
                    <div class="modal-body">
                        <form action = "action" id="registrarColaborador">
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <select id="tipoParticipante" name="tipoParticipante" class="form-control" required>
                                        <option>--Tipo de Colaborador--</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="nombreColaborador" >Nombre del Colaborador:</label>
                                    <input id="nombreColaborador" name="nombreColaborador" type="text" class="form-control" placeholder="Nombre del Colaborador" required>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="apellido1Colaborador" >Primer Apellido:</label>
                                    <input id="apellido1Colaborador" name="apellido1Colaborador" type="text" class="form-control" placeholder="Primer Apellido" required>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="apellido2Colaborador" >Segundo Apellido:</label>
                                    <input id="apellido2Colaborador" name="apellido2Colaborador" type="text" class="form-control" placeholder="Segundo Apellido" required>
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

        <!---- Modal Eliminar Colaborador --->
        <div id="modal-eliminar-colaborador" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px;" >ELIMINAR COLABORADOR</center>
                    </div>
                    <div class="modal-body">
                        <p>¿Estás seguro de que deseas eliminar a este colaborador?</p>
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


    <!---- Modal Editar Colaborador--->
    <div id="modal-editar-colaborador" class="modal fade" role="dialog">
        <div class="modal-dialog  modal-dialog-centered modal-sm ">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header-color">
                    <center style="width: 100%;font-size: 20px;margin-top: 10px;">Editar Colaborador</center>
                </div>
                <div class="modal-body">
                    <form action = "action" id="editarColaborador">
                        <div class="row mt-4">
                            <div class="col col-md-12">
                                <select id="tipoParticipanteE" name="tipoParticipante" class="form-control" required>
                                    <option>--Tipo de Colaborador--</option>
                                </select>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col col-md-12">
                                <label for="nombreColaboradorE" >Nombre del Colaborador:</label>
                                <input id="nombreColaboradorE" name="nombreColaboradorE" type="text" class="form-control" placeholder="Nombre del Colaborador" required>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col col-md-12">
                                <label for="apellido1ColaboradorE" >Primer Apellido:</label>
                                <input id="apellido1ColaboradorE" name="apellido1ColaboradorE" type="text" class="form-control" placeholder="Primer Apellido" required>
                            </div>
                        </div>
                        <div class="row mt-4">
                            <div class="col col-md-12">
                                <label for="apellido2ColaboradorE" >Segundo Apellido:</label>
                                <input id="apellido2ColaboradorE" name="apellido2ColaboradorE" type="text" class="form-control" placeholder="Segundo Apellido" required>
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
                                <button type="submit" value="editar" class="btnEditarColaborador" id="confirmarEditarColaborador" data-dismiss="modal">Editar<i class="bi bi-plus-circle"></i></button>
                            </div>

                        </div>
                    </form>    
                </div>


            </div>
        </div>
    </div>
    <!-- Fin Modal -->


    <!-- Modal Asignar-->
    <div id="modal-asignar-colaborador" class="modal fade" role="dialog">
        <div class="modal-dialog  modal-dialog-centered modal-sm ">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header-color">
                    <center style="width: 100%;font-size: 20px;margin-top: 10px;" >ASIGNAR COLABORADOR</center>
                </div>
                <div class="modal-body">
                    <select id="equiposAsignar" name="equiposAsignar" class="form-control" required>

                    </select>  
                </div>
                <div class="modal-footer ">

                </div>
                <button value="SI" class="btn btn-primary" id="confirmar-asignacion" data-dismiss="modal">ASIGNAR</button>


            </div>


        </div>
    </div>
</div>
<!-- Fin modal -->

<!-- Modal Equipos Asignados-->
<div id="modal-equipos-colaborador" class="modal fade" role="dialog">
    <div class="modal-dialog  modal-dialog-centered modal-sm ">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header-color">
                <center style="width: 100%;font-size: 20px;margin-top: 10px;" >Equipos Asignados</center>
            </div>
            <div class="modal-body">
                <ul id="listaEquiposAsignados">

                </ul>
            </div>
            <div class="modal-footer ">

            </div>



        </div>


    </div>
</div>
</div>
<!-- Fin modal -->
<%@include file="components/includes/footer.jspf"%>
<script src="js/colaboradores.js"></script>
</body>
</html>
