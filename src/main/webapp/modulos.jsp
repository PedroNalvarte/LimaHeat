<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/modulos.css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
    </head>
    <body>

        <div id="idTipoCuenta" hidden><%=logged.getIdTipoCuenta()%></div>

        <div class="separator"></div> 
        <br>

        <div class="container">
            <div class="row justify-content-center align-items-center">
                <div class="card-categorias col-md-4 mb-2" style="max-width: 300px;">
                    <center>
                        <div class="card custom-card" onclick="categorias()">
                            <img src="https://cdn.discordapp.com/attachments/877328260357324832/1161459981057540156/categorias.png?ex=653860e6&is=6525ebe6&hm=1d2270cc7b88bdf3590c61fe9fb54c8773ee977f417a2207cf37c0f997cae254&"  alt="Imagen de la tarjeta 1" width="250" height="250" class="mx-auto">
                            <div class="card-body">
                                <h4 class="card-title text-center">CATEGORÍAS</h4>
                            </div>
                        </div>
                    </center>
                </div>

                <div class="card-temporadas col-md-4 mb-1" style="max-width: 300px;">
                    <div class="card custom-card" onclick="temporadas()">
                        <img src=https://cdn.discordapp.com/attachments/877328260357324832/1161471743932764261/temporadas.png?ex=65386bda&is=6525f6da&hm=dc93a0a6915d3397555a7a005ce197b43f3419ad02cec06672ddd2c3a8b5b86e& alt="Imagen de la tarjeta 3" width="250" height="250" class="mx-auto">
                        <div class="card-body">
                            <h4 class="card-title text-center">TEMPORADAS</h4>
                        </div>
                    </div>
                </div>

                <div class="card-equipos col-md-4 mb-2" style="max-width: 300px;">
                    <div class="card custom-card" onclick="misEquipos()">
                        <img src="https://cdn.discordapp.com/attachments/877328260357324832/1161471744289296384/equipos.png?ex=65386bda&is=6525f6da&hm=85deba80d44d7aa95c7ce86bcab6339f802003c937f339d0e5981a3bbcad4f08&"  alt="Imagen de la tarjeta 2" width="250" height="250" class="mx-auto">
                        <div class="card-body">
                            <h4 class="card-title text-center">MIS EQUIPOS</h4>
                        </div>
                    </div>
                </div>


                <div class="row justify-content-center align-items-center">
                    <div class="card-equipos-rivales col-md-4 mb-2" style="max-width: 300px;">
                        <center>
                            <div class="card custom-card" onclick="equiposRivales()">
                                <img src="https://cdn.discordapp.com/attachments/877328260357324832/1161471744893268061/rivales.png?ex=65386bdb&is=6525f6db&hm=cfbf639c39205d7ffb323918f5b45d9ea8e96c0061445b37ec1b883e718bd174&"  alt="Imagen de la tarjeta 1" width="250" height="250" class="mx-auto">
                                <div class="card-body">
                                    <h4 class="card-title text-center">EQUIPOS RIVALES</h4>
                                </div>
                            </div>
                        </center>
                    </div>

                    <div class="card-gestionar col-md-4 mb-1" style="max-width: 300px;">
                        <div class="card custom-card" onclick="gestionarUsuarios()">
                            <img src="https://www.xtrafondos.com/descargar.php?id=1774&resolucion=2560x1440https://www.xtrafondos.com/descargar.php?id=1774&resolucion=2560x1440" alt="Imagen de la tarjeta 3" width="250" height="250" class="mx-auto">
                            <div class="card-body">
                                <h4 class="card-title text-center">GESTIONAR USUARIOS</h4>
                            </div>
                        </div>
                    </div>
                    
                    <div class="card-colaboradores col-md-4 mb-1" style="max-width: 300px;">
                        <div class="card custom-card" onclick="colaboradores()">
                            <img src="https://www.elgrafico.com.ar/media/cache/pub_news_details_large/media/i/a3/90/a390b6dfa1b1c891050920e4bb9e41d1cc0ecd2c.jfif" alt="Imagen de la tarjeta 3" width="250" height="250" class="mx-auto">
                            <div class="card-body">
                                <h4 class="card-title text-center">GESTIONAR COLABORADORES</h4>
                            </div>
                        </div>
                    </div>
                    
                    <!<!-- comment 
                    <div class="card-estadisticas col-md-4 mb-1" style="max-width: 300px;">
                        <div class="card custom-card" onclick="colaboradores()">
                            <img src="" alt="Imagen de la tarjeta 3" width="250" height="250" class="mx-auto">
                            <div class="card-body">
                                <h4 class="card-title text-center">ESTADISTICAS GENERALES</h4>
                            </div>
                        </div>
                    </div>
                      -->


                </div>
                <br>
            </div>
        </div>


            <%@include file="components/includes/footer.jspf"%>

            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="js/modulos.js"></script>
    </body>

</html>