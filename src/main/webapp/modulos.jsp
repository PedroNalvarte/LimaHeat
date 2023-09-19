<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulos</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="css/modulos.css"/>
         
    </head>
    <body>


        <br><!-- salto de linea -->

        <div class="container_details" id="categoria">
            <div class="col-sm-3">
                <div class="card card-d mb-3 neon">
                    <div class="card-body">
                        <div class="card-img-actions">
                            <p>CREAR CATEGORIAS</p>
                            <div class="image-container">
                                <img class="img-responsive" src="https://media.istockphoto.com/id/959080376/es/foto/de-b%C3%A1squetbol.jpg?b=1&s=612x612&w=0&k=20&c=6UBcxBWQHoZYoXBKKKXU3-Eke3HgWnPMGbSelT1PIt4=" alt="Imagen de fondo">
                                
                                    <button  onclick="categoria()" type="button" class="plus-button"></button> 
                               
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="components/includes/footer.jspf"%>
        <script src="js/modulos.js"></script>
    </body>
</html>
