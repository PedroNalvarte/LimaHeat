<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Partido</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/registrarPartido.css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        
        <style>
            th{
                text-align: center;
            }
            
            td{
                text-align: center;
            }
            
            input{
                width: 25px;
            }
        </style>
    </head>
    <body>
        

        <form action="action" id="form-estadisticas">
        <div class="container">

            <!-- Titulo -->
            <div class="row">
                <div class="col col-md-12">
                    <h1 style="text-align: center;">Registrar Estadisticas Nuevo Partido</h1>
                </div>
            </div>

            <!-- Datos del partido -->
            <div class="row mt-2">
                <div class="col col-md-2"></div>

                <div class="col col-md-12">
                    <div class="row">

                        <div class="col col-md-2">
                            <div class="col col-md-12">
                                <label for="txtLugar"><strong>Lugar:</strong></label>
                                <input id="txtLugar" class="form-control" required>
                            </div>
                        </div>
                        
                        <div class="col col-md-2">
                            <div class="col col-md-12">
                                <label for="txtFecha"><strong>Fecha:</strong></label>
                                <input id="txtFecha" type="date" class="form-control" required>
                            </div>
                        </div>

                        <div class="col col-md-3">
                            <div class="col col-md-12">
                                <label for="txtDetalleResultado"><strong>Detalle Resultado:</strong></label>
                                <input id="txtDetalleResultado" class="form-control" required> 
                            </div>
                        </div>

                        <div class="col col-md-2">
                            <div class="col col-md-12">
                                <label for="ddlResultado"><strong>Resultado:</strong></label>
                                <select id="ddlResultado" class="form-control" required>
                                    <option value="">SELECCIONES RESULTADO</option>
                                    <option value="G">GANADO</option>
                                    <option value="P">PERDIDO</option>
                                    <option value="E">EMPATADO</option>
                                </select>
                            </div>
                        </div>

                        <div class="col col-md-3">
                            <div class="col col-md-12">
                                <label for="ddlEquipoRival"><strong>Equipo Rival:</strong></label>
                                <select id="ddlEquipoRival" onchange="equipoRivalSelect();" class="form-control" required></select>
                            </div>
                        </div>

                    </div>
                </div>  

                <div class="col col-md-2"></div>
            </div>
            
            <div class="row mt-4">
                <div class="col col-md-12">
                    <h3>Jugadores del equipo Local</h3>
                </div>
            </div>

            <!-- Tabla Local -->
            <div class="row mt-2">
                <div class="col col-md-12">

                    <table id="tblEquipoLocal" class="table table-striped">
                        <thead class="thead-dark">

                            <tr>
                                <th colspan="5"></th>
                                <th colspan="2">TC</th>
                                <th colspan="2">2P TC</th>
                                <th colspan="2">3P TC</th>
                                <th colspan="2">TL</th>
                                <th colspan="2">REB</th>
                                <th colspan="4"></th>
                                <th colspan="2">FP</th>
                                <th colspan="3"></th>
                            </tr>
                            <tr>
                                <th>N°</th>
                                <th>Nombre</th>
                                <th>Dorsal</th>
                                <th>Min</th>
                                <th>Sec</th>
                                <th>A</th>
                                <th>R</th>
                                <th>A</th>
                                <th>R</th>
                                <th>A</th>
                                <th>R</th>
                                <th>A</th>
                                <th>R</th>
                                <th>RO</th>
                                <th>RD</th>
                                <th>AS</th>
                                <th>TO</th>
                                <th>RB</th>
                                <th>TP</th>
                                <th>C</th>
                                <th>D</th>
                                <th>+/-</th>
                                <th>PTS</th>
                                <th>Observación</th>
                            </tr>

                        </thead>
                        <tbody id="tbEquipoLocal">

                        </tbody>
                    </table>
                </div>
            </div>
            
            <div class="row mt-3">
                <div class="col col-md-12">
                    <h3>Jugadores del equipo Rival </h3>
                </div>
            </div>
            
            <!-- Tabla Rival -->
            <div class="row mt-2">
                <div class="col col-md-12">

                    <table id="tblEquipoRival" class="table table-striped">
                        <thead class="thead-dark">

                            <tr>
                                <th colspan="5"></th>
                                <th colspan="2">TC</th>
                                <th colspan="2">2P TC</th>
                                <th colspan="2">3P TC</th>
                                <th colspan="2">TL</th>
                                <th colspan="2">REB</th>
                                <th colspan="4"></th>
                                <th colspan="2">FP</th>
                                <th colspan="3"></th>
                            </tr>
                            <tr>
                                <th>N°</th>
                                <th>Nombre</th>
                                <th>Dorsal</th>
                                <th>Min</th>
                                <th>Sec</th>
                                <th>A</th>
                                <th>R</th>
                                <th>A</th>
                                <th>R</th>
                                <th>A</th>
                                <th>R</th>
                                <th>A</th>
                                <th>R</th>
                                <th>RO</th>
                                <th>RD</th>
                                <th>AS</th>
                                <th>TO</th>
                                <th>RB</th>
                                <th>TP</th>
                                <th>C</th>
                                <th>D</th>
                                <th>+/-</th>
                                <th>PTS</th>
                                <th>Observación</th>
                            </tr>

                        </thead>
                        <tbody id="tbEquipoRival">

                        </tbody>
                    </table>
                </div>
            </div>
            
            <div class="row mt-3">
                <div class="col col-md-9"></div>
                
                <div class="col col-md-3">
                    <input style="width: 100%" type="submit" value="Registrar"/>
                </div>
            </div>

        </div>
        
        </form>

        <%@include file="components/includes/footer.jspf"%>
        <script src="js/registrarPartido.js"></script>
    </body>
</html>
