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
                <div style="text-align: center" class="col-md-12">
                    <h1>EQUIPOS RIVALES</h1>
                </div>
            </div>

            <div class="row mt-3">
                <div class="col col-md-12 lista-equipos-rivales">

                    <button class="mi-button">
                        <div class="card mi-card">
                            <h2>hola</h2>
                            <div class="input-group">
                                <i class="bi bi-people"></i><label"> asdasd: asdsad</label><br>
                                <i class="bi bi-person-fill"></i><label"> asdsad</label>
                            </div>
                        </div>
                    </button>

                    <button class="mi-button" onclick="registrarNuevo()">
                        <div class="card mi-card card-agregar">

                            <i style="font-size: 70px" class="bi bi-plus-circle-fill"></i>
                            <h2>REGISTRAR NUEVO</h2>

                        </div>
                    </button>

                </div>
            </div>

        </div>

        <!-- Modal registrar equipo rival -->
        <div id="modal-registrar-equipo-rival" class="modal fade" role="dialog">
            <div class="modal-dialog  modal-dialog-centered modal-md ">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header-color">
                        <center style="width: 100%;font-size: 20px;margin-top: 3px">LIMA HEAT</center>
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
            <!-- Fin Modal -->

            <%@include file="components/includes/footer.jspf"%>
            <script src="js/equiposRivales.js"></script>
    </body>
</html>
