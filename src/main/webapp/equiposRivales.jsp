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

        <div class="container">

            <div class="row mt-4">
                <div style="text-align: center; margin-bottom: 25px" class="col-md-12">
                    <h1>EQUIPOS RIVALES</h1>
                </div>
               
            </div>

            <div class="row mt-3">
                  <div class="col col-md-12 lista-equipos-rivales">

                      
                      
                      
                      
                </div>
                
                
            </div>

        </div>

        <!-- Modal registrar equipo rival -->
        <div id="modal-registrar-equipo-rival" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-md ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px">REGISTRAR NUEVO EQUIPO RIVAL</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px;">Ingrese los datos del equipo rival que desea registrar.</p>
                        
                        <form action="action" id="registrar-Equipo-rival">
                        <div class="row mt-3">
                            <div class="col col-md-12">
                                <label for="ddlCategoria"><strong>Categoria:</strong></label>
                                <select id="ddlCategoria" class="form-control" required></select>  
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col col-md-12">
                                <label for="txtNomEquipo"><strong>Nombre Equipo:</strong></label>
                                <input id="txtNomEquipo" class="form-control" required></input>  
                            </div>
                        </div>

                        <div class="modal-footer btnLogin">
                            <button style="width: 30%;font-size: 15px" type="submit" data-dismiss="modal">Registrar</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->
            
            <!-- Modal Confirmar proceso de datos -->
            <div id="modal-verificacion" class="modal fade" role="dialog">
                <div class="modal-dialog  modal-dialog-centered modal-sm ">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header-color">
                            <center style="width: 100%;font-size: 20px;margin-top: 10px">LIMA HEAT</center>
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
            
        <!-- Modal registrar equipo rival -->
        <div id="modal-editar" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-md ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 10px">EDITAR DATOS DEL EQUIPO</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px;">Ingrese los datos que desea modificar del equipo rival.</p>
                        
                        <form action="action" id="editar-Equipo-rival">
                        <div class="row mt-3">
                            <div class="col col-md-12">
                                <label for="ddlEditCategoria"><strong>Categoria:</strong></label>
                                <select id="ddlEditCategoria" class="form-control" required></select>  
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col col-md-12">
                                <label for="txtNomEquipo"><strong>Nombre Equipo:</strong></label>
                                <input id="txtEditNomEquipo" class="form-control" required></input>  
                            </div>
                        </div>

                        <div class="modal-footer btnLogin">
                            <button style="width: 30%;font-size: 15px" type="submit" data-dismiss="modal">Editar</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->


            <%@include file="components/includes/footer.jspf"%>
            <script src="js/equiposRivales.js"></script>
    </body>
</html>
