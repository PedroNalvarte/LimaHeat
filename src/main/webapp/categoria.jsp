<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulos</title>
        <%@include file="components/includes/header.jspf"%>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/categoria.css"/>
         <script src="js/categoria.js"></script>

    </head>
    <body>


        <br><!-- salto de linea -->

        <div class="container-fluid" id="categoria">
            <div class="row ">
                <div class="col-sm-6">
                    <div class="card card-d mb-3 neon mi-tarjeta">
                        <div class="card-body">
                            <div class="card-img-actions">
                                <p>CREAR CATEGORIAS</p>
                                <div class="image-container">
                                    <img class="img-responsive" src="https://media.istockphoto.com/id/959080376/es/foto/de-b%C3%A1squetbol.jpg?b=1&s=612x612&w=0&k=20&c=6UBcxBWQHoZYoXBKKKXU3-Eke3HgWnPMGbSelT1PIt4=" alt="Imagen de fondo">
                                    <button onclick="categoria()" type="button" class="plus-button">+</button> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container  text-center" id="categorias-container">
            
        </div>

            <%@include file="components/includes/footer.jspf"%>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </body>
</html>