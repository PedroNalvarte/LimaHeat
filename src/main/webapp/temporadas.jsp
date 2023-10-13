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
        
        
        <div class="container"> 
            <div class="row mt-4">
                <div style="text-align: center" class="col-md-10">
                    <h1 >Temporadas</h1>
                </div>
                
                <div style="text-align: center" class="col-md-2">
                    <button class="mi-button" onclick="agregar()">
                        <div class="agregar">
                            <i style="font-size: 25px" class="bi bi-plus-circle-fill"></i>
                            <h2 style="font-size: 15px">Agregar Temporada</h2>
                        </div>
                    </button>
                </div>
                
            </div>

            <div class="row mt-4">
                 <div class="container" id="mainContainer">

                </div>
            </div>
        </div>
        
        


        
        
        
        
        
        
        
        <!---- Modal Crear temporada --->
        <div id="modal-creacion" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px; color: white">LIMA HEAT</center>
                    </div>
                    <div class="modal-body">
                        <form action = "action" id="crearTemporada">
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="fechaInicio" style="color: white;">Nombre de Temporada:</label>
                                    <input id="nombreTemporada" name="nombreTemporada" type="text" class="form-control" placeholder="Nombre de Temporada" required>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="fechaInicio" style="color: white;">Fecha de inicio:</label>
                                    <input id="fechaInicio" name="fechaInicio" type="date" placeholder="Fecha de Inicio" class="form-control"  required/>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="fechaFin" style="color: white;">Fecha de fin:</label>
                                    <input id="fechaFin" name="fechaFin" type="date" placeholder="Fecha de Fin" class="form-control"  required/>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <select id="tipoTemporada" name="tipoTemporada" class="form-control" required>
                                        <option>--Seleccionar Tipo--</option>
                                    </select>
                                </div>

                                <div class="modal-footer ">
                                    <button type="submit" value="registrar" class="btn btn-primary" data-dismiss="modal">Registrar <i class="bi bi-plus-circle"></i></button>
                                </div>

                            </div>
                        </form>    
                    </div>


                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        <!-- Modal Detalles-->
        <div id="modal-detalles" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color modalEliminarHeader">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px; color: white">EDITAR TEMPORADA</center>

                    </div>
                    <div class="modal-body">
                   
                        <form action = "action" id="editarTemporada">
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="nombreTemporadaE" style="color: white">Nombre de Temporada:</label>
                                    <input id="nombreTemporadaE" name="nombreTemporada" type="text" class="form-control" required>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="fechaInicioE" style="color: white">Fecha de inicio:</label>
                                    <input id="fechaInicioE" name="fechaInicio" type="date" placeholder="Fecha de Inicio" class="form-control"  required/>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="fechaFinE" style="color: white">Fecha de fin:</label>
                                    <input id="fechaFinE" name="fechaFin" type="date" placeholder="Fecha de Fin" class="form-control"  required/>
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col col-md-12">
                                    <label for="tipoTemporadaE" style="color: white">Tipo de Temporada:</label>
                                    <select id="tipoTemporadaE" name="tipoTemporadaE" class="form-control" required>
                                        <option>--Seleccionar Tipo--</option>
                                    </select>
                                </div>

                                <div class="modal-footer btnEditar">
                                    <button  id="btnEditarTemporada" type="submit" data-dismiss="modal" class="btn btn-primary"><i class="bi bi-pencil-square"></i></button>
                                    </form>     

                                </div>

                            </div>

                    </div>


                </div>
            </div>
        </div>
        <!--Final Modal-->
        
           <!---- Modal Eliminar Temporada --->
        <div id="modal-eliminar" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-sm ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px; color: white" >ELIMINAR TEMPORADA</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: white">¿Estás seguro de que deseas eliminar esta temporada?</p>
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

        <%@include file="components/includes/footer.jspf"%>
        <script src="js/temporadas.js"></script>
    </body>
</html>
