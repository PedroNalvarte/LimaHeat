<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <%@include file="components/includes/header.jspf"%>
         <link rel="stylesheet" href="css/modulos.css"/>
    </head>
    <body>
        <div class="centered-container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                            <img src="https://www.eltiempo.com/files/article_main_1200/uploads/2023/06/28/649ca60ba186f.png" alt="Imagen de la tarjeta 1">
                            <div class="card-body">
                                <h2 class="card-title">CATEGORIAS</h2>
                                <button onclick="modulo()" type="button" class="btn btn-custom plus-button">+</button>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="card">
                            <img src="https://www.eltiempo.com/files/article_main_1200/uploads/2023/06/28/649ca60ba186f.png" alt="Imagen de la tarjeta 2">
                            <div class="card-body">
                                <h2 class="card-title">MIS EQUIPOS</h2>
                                <button onclick="equipoTemporada()" type="button" class="btn btn-custom plus-button">+</button>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-md-4">
                        <div class="card">
                            <img src="https://www.eltiempo.com/files/article_main_1200/uploads/2023/06/28/649ca60ba186f.png" alt="Imagen de la tarjeta 2">
                            <div class="card-body">
                                <h2 class="card-title">EQUIPOS RIVALES</h2>
                                <button onclick="equiposRivales()" type="button" class="btn btn-custom plus-button">+</button>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-md-4">
                        <div class="card">
                            <img src="https://www.eltiempo.com/files/article_main_1200/uploads/2023/06/28/649ca60ba186f.png" alt="Imagen de la tarjeta 2">
                            <div class="card-body">
                                <h2 class="card-title">TEMPORADAS</h2>
                                <button onclick="temporadas()" type="button" class="btn btn-custom plus-button">+</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mt-4">
        <div class="col-md-6">
            <a href="categoria.jsp" class="btn btn-secondary">Ir a Categorias</a>
        </div>
    </div>
        <%@include file="components/includes/footer.jspf"%>
        
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="js/modulos.js"></script>
    </body>

</html>
