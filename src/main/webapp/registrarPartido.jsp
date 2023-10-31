<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Partido</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/registrarPartido.css"/>
         <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body>
        <h1 style="text-align: center;">Registrar Estadisticas Nuevo Partido</h1>
        
        <div class="inputs-partido">
            <div class="ip-first-row">
                <h4 style="display: inline-block; margin-right: 10px;">LUGAR: </h4>
                <input id="lugar" name="lugar" type="text" required/>
                 <h4 style="display: inline-block; margin-right: 10px;">NOMBRE: </h4>
                <input id="nombre" name="nombre" type="text" required/>
            </div>
            <div class="ip-second-row" id="ip-second-row">
                    
            </div>
        </div>
        
        <div class="input-equipo-local">
            <table id="tablaCol" class="table">
                <tr>
                    <th rowspan="2">N°</th>
                    <th rowspan="2">Nombre</th>
                    <th rowspan="2">Min</th>
                    <th colspan="2">TC</th>
                    <th colspan="2">2P TC</th>
                    <th colspan="2">3P TC</th>
                    <th colspan="2">TL</th>
                    <th colspan="3">REB</th>
                    <th rowspan="2">AS</th>
                    <th rowspan="2">TO</th>
                    <th rowspan="2">RB</th>
                    <th rowspan="2">TP</th>
                    <th colspan="2">FP</th>
                    <th rowspan="2">+/-</th>
                    <th rowspan="2">PTS</th>
                </tr>
                <tr>
                    <th colspan="2">A/R</th>
                    <th colspan="2">A/R</th>
                    <th colspan="2">A/R</th>
                    <th colspan="2">A/R</th>
                    <th>RO</th>
                    <th>RD</th>
                    <th>Tot</th>
                    <th>C</th>
                    <th>D</th>
                   
                </tr>
            </table>
        </div>
        <br>
        <br>
        
        <div id="jugadoresRiv">
             <table id="tablaRiv" class="table">
                         <tr>
                    <th rowspan="2">N°</th>
                    <th rowspan="2">Nombre</th>
                    <th rowspan="2">Min</th>
                    <th colspan="2">TC</th>
                    <th colspan="2">2P TC</th>
                    <th colspan="2">3P TC</th>
                    <th colspan="2">TL</th>
                    <th colspan="3">REB</th>
                    <th rowspan="2">AS</th>
                    <th rowspan="2">TO</th>
                    <th rowspan="2">RB</th>
                    <th rowspan="2">TP</th>
                    <th colspan="2">FP</th>
                    <th rowspan="2">+/-</th>
                    <th rowspan="2">PTS</th>
                </tr>
               <tr>
                    <th colspan="2">A/R</th>
                    <th colspan="2">A/R</th>
                    <th colspan="2">A/R</th>
                    <th colspan="2">A/R</th>
                    <th>RO</th>
                    <th>RD</th>
                    <th>Tot</th>
                    <th>C</th>
                    <th>D</th>
                   
                </tr>
            </table>
            
        </div>
        
        <div id="jugadoresRiv">
            
        </div>
        
    <%@include file="components/includes/footer.jspf"%>
    <script src="js/registrarPartido.js"></script>
    </body>
</html>