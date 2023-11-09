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
    <body>
        
         <div id="idParticipante" hidden><%=logged.getIdParticipante()%></div>
         
         <div class="container">
             
         
                 <div class="row mt-4">
                <div class="col col-md-12">
                    <h5 style="text-align: center;" id="nombreJugador" >RENDIMIENTO GENERAL DEL JUGADOR: </h5>
                    <table id="tblRendimiendoGeneral" class="table table-striped">
                        <thead class="thead-dark">

                            <tr>
                                <th>% Tiro</th>
                                <th>% Tiro 2 puntos</th>
                                <th>% Tiro 3 puntos</th>
                                <th>% Tiro Libre</th>
                                <th>Rebotes totales</th>
                                <th>Asistencias Totales</th>
                                <th>Pérdidas Totales</th>
                                <th>Robos Totales</th>
                                <th>Tapones Totales</th>
                                <th>Faltas Cometidas Totales</th>
                                <th>Faltas Recibidas Totales</th>
                                <th>Puntos Netos Totales</th>
                                <th>Puntos anotados</th>
                            </tr>

                        </thead>
                        <tbody id="tbRendimiendoGeneral">

                        </tbody>
                    </table>
                </div>  
            </div>
        
        <h1>Observaciones</h1>
        
             
            <div class="row mt-4">
                <div class="col col-md-12">                    
                    
                        <div id="tblPartidos" class="container">
                            
                        </div>
                    
                </div>
            </div>
        
        </div>
       
        <%@include file="components/includes/footer.jspf"%>
        <script src="js/partidosJugador.js"></script>
    </body>
    
    
</html>
