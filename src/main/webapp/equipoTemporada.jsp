<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipos Rivales</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/equiposRivales.css"/>
    </head>
    <body>
        
        <h1 id="titulo"></h1>

        <div id="container-temporadas">
            
            
            
            



        </div>

        <!-- Modal registrar equipo rival -->
        <div id="modal-registrar-equipo-rival" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-xl ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px">REGISTRAR NUEVA TEMPORADA</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px;">Debe asignar un entrenador para la temporada:</p>

                        <form action="action" id="registrar-equipo-temporada">
                            <div class="row mt-3">

                                <div style="border-right: 2px solid red" class="col col-md-6">

                                    <div class="row">
                                        <div class="col col-md-12">
                                            <label for="ddlCategoria"><strong>Nombre:</strong></label>
                                            <input id="txtNom" class="form-control" required>  
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col col-md-12">
                                            <label for="ddlCategoria"><strong>Primer Apellido:</strong></label>
                                            <input id="txtApe1" class="form-control" required> 
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col col-md-12">
                                            <label for="ddlCategoria"><strong>Segundo Apellido:</strong></label>
                                            <input id="txtApe2" class="form-control" required> 
                                        </div>
                                    </div>

                                </div>

                                <div class="col col-md-6">
                                    
                                    <div class="row">
                                        <div class="col col-md-12">
                                            <label for="ddlDocId"><strong>Tipo Documento Identidad:</strong></label>
                                            <select id="ddlDocId" class="form-control" required></select>
                                        </div>
                                    </div>

                                    <div class="row mt-3">
                                        <div class="col col-md-12">
                                            <label for="txtNomEquipo"><strong>Numero Documento Identidad:</strong></label>
                                            <input id="txtDocIde" class="form-control" required>
                                        </div>
                                    </div>
                                    
                                    <div class="row mt-3">
                                        <div class="col col-md-12">
                                            <label for="ddlTemporada"><strong>Temporada:</strong></label>
                                            <select id="ddlTemporada" class="form-control" required></select>
                                        </div>
                                    </div>
                                </div>
                            </div>



                            <div class="modal-footer btnLogin mt-2">
                                <button style="width: 30%;font-size: 15px" type="submit" data-dismiss="modal">Registrar</button>
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
