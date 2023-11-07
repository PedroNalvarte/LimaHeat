<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulos Equipo</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/modulos.css"/>
    </head>
    <body>
        
        <div id="idTipoCuenta" hidden><%=logged.getTipoCuenta()%></div>

        <div class="container">
            
            <div class="row">
                <div class="col col-md-12">
                    <h1 id="titulo"></h1>
                    <h3 id="entrenador"></h3>
                </div>
            </div>
            
            
            <div class="row justify-content-center align-items-center mt-2">
                
                <div hidden id="cardHistorialPartidos" class="col-md-4 mb-2" style="max-width: 300px;">
                    <center>
                        <div class="card custom-card" onclick="modulosPartidos()">
                            <img src="https://cdn.discordapp.com/attachments/877328260357324832/1161459981057540156/categorias.png?ex=653860e6&is=6525ebe6&hm=1d2270cc7b88bdf3590c61fe9fb54c8773ee977f417a2207cf37c0f997cae254&"  alt="Imagen de la tarjeta 1" width="250" height="250" class="mx-auto">
                            <div class="card-body">
                                <h4 class="card-title text-center">HISTORIAL DE PARTIDOS</h4>
                            </div>
                        </div>
                    </center>
                </div>

                <div hidden id="cardJugadores" class="col-md-4 mb-1" style="max-width: 300px;">
                    <div class="card custom-card" onclick="moduloJugadores()">
                        <img src=https://cdn.discordapp.com/attachments/877328260357324832/1161471743932764261/temporadas.png?ex=65386bda&is=6525f6da&hm=dc93a0a6915d3397555a7a005ce197b43f3419ad02cec06672ddd2c3a8b5b86e& alt="Imagen de la tarjeta 3" width="250" height="250" class="mx-auto">
                        <div class="card-body">
                            <h4 class="card-title text-center">JUGADORES</h4>
                        </div>
                    </div>
                </div>

                <div hidden id="cardGestionarColaborador" class="col-md-4 mb-2" style="max-width: 300px;">
                    <div class="card custom-card" onclick="misEquipos()">
                        <img src="https://cdn.discordapp.com/attachments/877328260357324832/1161471744289296384/equipos.png?ex=65386bda&is=6525f6da&hm=85deba80d44d7aa95c7ce86bcab6339f802003c937f339d0e5981a3bbcad4f08&"  alt="Imagen de la tarjeta 2" width="250" height="250" class="mx-auto">
                        <div class="card-body">
                            <h4 class="card-title text-center">GESTIONAR COLABORADOR</h4>
                        </div>
                    </div>
                </div>


                <br>
            </div>
        </div>

        <%@include file="components/includes/footer.jspf"%>
        <script src="js/modulosEquipo.js"></script>
    </body>

</html>
