<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Partidos Jugador</title>
         <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/historialPartidos.css"/>
         <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <style>
        thead th {
               text-align: center;
        }
        tbody tr{
               text-align: center;
        }
    </style>
    <body>
          <div id="idParticipante" hidden><%=logged.getIdParticipante()%></div>
        <h1>Detalle de Partido</h1>
        
        <br>
        <h2 id="equipoLocal"></h2>
         <div class="row mt-4">
                <div class="col col-md-12">
                      <table id="tblEquipoLocal" class="table table-striped">
                        <thead class="thead-dark">

                            <tr>
                                <th colspan="3"></th>
                                <th colspan="2">TC</th>
                                <th colspan="2">2P TC</th>
                                <th colspan="2">3P TC</th>
                                <th colspan="2">TL</th>
                                <th colspan="3">REB</th>
                                <th colspan="4"></th>
                                <th colspan="2">FP</th>
                                <th colspan="2"></th>
                            </tr>
                            <tr>
                                <th>N°</th>
                                <th>Nombre</th>
                                <th>Min</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>RO</th>
                                <th>RD</th>
                                <th>Tot</th>
                                <th>AS</th>
                                <th>TO</th>
                                <th>RB</th>
                                <th>TP</th>
                                <th>C</th>
                                <th>D</th>
                                <th>+/-</th>
                                <th>PTS</th>
                            </tr>

                        </thead>
                        <tbody id="tbEquipoLocal">

                        </tbody>
                        
                    </table>
                    
                  
                </div>
            </div>
        <br>
         <h2 id="equipoRival"></h2>
         <div class="row mt-4">
                <div class="col col-md-12">
                      <table id="tblEquipoRival" class="table table-striped">
                        <thead class="thead-dark">

                            <tr>
                                <th colspan="3"></th>
                                <th colspan="2">TC</th>
                                <th colspan="2">2P TC</th>
                                <th colspan="2">3P TC</th>
                                <th colspan="2">TL</th>
                                <th colspan="3">REB</th>
                                <th colspan="4"></th>
                                <th colspan="2">FP</th>
                                <th colspan="2"></th>
                            </tr>
                            <tr>
                                <th>N°</th>
                                <th>Nombre</th>
                                <th>Min</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>A/R</th>
                                <th>%</th>
                                <th>RO</th>
                                <th>RD</th>
                                <th>Tot</th>
                                <th>AS</th>
                                <th>TO</th>
                                <th>RB</th>
                                <th>TP</th>
                                <th>C</th>
                                <th>D</th>
                                <th>+/-</th>
                                <th>PTS</th>
                            </tr>

                        </thead>
                        <tbody id="tbEquipoRival">

                        </tbody>
                        
                    </table>
                    
                  
                </div>
            </div>
        
        
           <%@include file="components/includes/footer.jspf"%>
        <script src="js/detallePartidoJugador.js"></script>
    </body>
</html>
