<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipos Rivales</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/equiposRivales.css"/>
        <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="idParticipante" hidden><%=logged.getIdParticipante()%></div>
        <div id="idTipoCuenta" hidden><%=logged.getIdTipoCuenta()%></div>
        
        <div class="container">
            <div class="row mt-4">
                <div style="text-align: center" class="col-md-10">
                  <h1 id="titulo"></h1>
                </div>
        
                
                    <div style="text-align: center" class="col-md-2">
                        <button class="mi-button" onclick="registrarNuevo()">
                            <div class=" card-agregar">
                                <i style="font-size: 25px" class="bi bi-plus-circle-fill"></i>
                                <h2 style="font-size: 15px">REGISTRAR NUEVO</h2>
                            </div>
                        </button>
                    </div>
                
            </div>
        
            <div class="row mt-4" >
                <div id="container-temporadas" class="col col-md-12 ">

                </div>
            </div>
            
        </div>
        

        <!-- Modal registrar equipo rival -->
        <div id="modal-registrar-equipo-rival" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-xl ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px; color: white">REGISTRAR NUEVA TEMPORADA</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px; color: white">Debe asignar un entrenador para la temporada:</p>

                        <form action="action" id="registrar-equipo-temporada">
                            <div class="row mt-3">

                                <div style="border-right: 2px solid red" class="col col-md-6">

                                    <div class="row">
                                        <div class="col col-md-12">
                                            <label for="ddlCategoria" style="color: white"><strong>Nombre:</strong></label>
                                            <input id="txtNom" class="form-control" required>  
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col col-md-12">
                                            <label for="ddlCategoria" style="color: white"><strong>Primer Apellido:</strong></label>
                                            <input id="txtApe1" class="form-control" required> 
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col col-md-12">
                                            <label for="ddlCategoria" style="color: white"><strong>Segundo Apellido:</strong></label>
                                            <input id="txtApe2" class="form-control" required> 
                                        </div>
                                    </div>

                                </div>

                                <div class="col col-md-6">
                                    
                                    <div class="row">
                                        <div class="col col-md-12">
                                            <label for="ddlDocId" style="color: white"><strong>Tipo Documento Identidad:</strong></label>
                                            <select id="ddlDocId" class="form-control" required></select>
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col col-md-12">
                                            <label for="txtNomEquipo" style="color: white"><strong>Numero Documento Identidad:</strong></label>
                                            <input id="txtDocIde" class="form-control" required>
                                        </div>
                                    </div>
                                    
                                    <div class="row mt-3">
                                        <div class="col col-md-12">
                                            <label for="ddlTemporada" style="color: white"><strong>Temporada:</strong></label>
                                            <select id="ddlTemporada" class="form-control" required></select>
                                        </div>
                                    </div>
                                </div>
                            </div>



                            <div class="modal-footer btnLogin mt-2">
                                <button style="width: 30%;font-size: 15px; color: white; background-color: #CA8B29; border-color: #CA8B29"type="submit" data-dismiss="modal">Registrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
         <!-- Modal registrar equipo propio -->
        <div id="modal-registrar-equipo-propio" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-xl ">
                <!-- Modal content-->
                
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 3px; color: white">REGISTRAR NUEVA TEMPORADA</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px; color: white">Sera asignado como el entrenador de esta temporada</p>

                        <form action="action" id="registrar-equipo-temporada-propia">
                            <div class="row mt-3">    
                                 
                                        <div class="col col-md-12">
                                            <label for="ddlTemporada1" style="color: white"><strong>Temporada:</strong></label>
                                            <select id="ddlTemporada1" class="form-control" required></select>
                                        </div>
                                 
                                </div>
                            </div>



                            <div class="modal-footer btnLogin mt-2">
                                <button style="width: 30%;font-size: 15px;color: white; background-color: #CA8B29; border-color: #CA8B29" type="submit" data-dismiss="modal">Registrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->

        <%@include file="components/includes/footer.jspf"%>
        <script src="js/equipoTemporada.js"></script>
    </body>
</html>
