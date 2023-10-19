<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    <%@include file="components/includes/header.jspf"%>
    <link rel="stylesheet" href="css/equiposRivales.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap" rel="stylesheet">
    </head>
    <body>
        
        <div id="idParticipante" hidden><%=logged.getIdParticipante()%></div>
        <div id="idTipoCuenta" hidden><%=logged.getIdTipoCuenta()%></div>
        
        <div class="container ">

            <div class="row mt-4">
                <div style="text-align: center" class="col-md-10">
                    <h1 style=" font-family: 'Alfa Slab One', serif; color: #5B5B5B">MIS EQUIPOS</h1>
                </div>
                
                <div style="text-align: center" class="col-md-2">
                    <button class="mi-button" onclick="registrarNuevo()">
                        <div class="card-agregar">
                            <i style="font-size: 25px" class="bi bi-plus-circle-fill"></i>
                            <h2 style="font-size: 15px">REGISTRAR NUEVO</h2>
                        </div>
                    </button>
                </div>
            </div>

            <div class="row mt-4">
                <div id="lista-mis-Equipos" class="col col-md-12 ">



                </div>
            </div>

        </div>
        
        <!-- Modal registrar equipo rival -->
        <div id="modal-registrar-equipo" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-md ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 3px; color: white">REGISTRAR NUEVO EQUIPO RIVAL</center>
                    </div>
                    <div class="modal-body">
                        <p style="color: black;font-size: 15px; color: white">Ingrese los datos del equipo rival que desea registrar.</p>
                        
                        <form action="action" id="registrar-Equipo">
                        <div class="row mt-3">
                            <div class="col col-md-12">
                                <label for="ddlCategoria" style="color: white"><strong>Categoria:</strong></label>
                                <select id="ddlCategoria" class="form-control" required></select>  
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col col-md-12">
                                <label for="txtNomEquipo" style="color: white"><strong>Nombre Equipo:</strong></label>
                                <input id="txtNomEquipo" class="form-control" required></input>  
                            </div>
                        </div>

                        <div class="modal-footer btnLogin">
                            <button style="width: 30%;font-size: 15px;color: white; background-color: #CA8B29; border-color: #CA8B29" type="submit" data-dismiss="modal">Registrar</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fin Modal -->
        
        <%@include file="components/includes/footer.jspf"%>
        <script src="js/misEquipos.js"></script>
    </body>

</html>
