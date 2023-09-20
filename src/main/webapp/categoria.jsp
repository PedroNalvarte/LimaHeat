<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="components/includes/header.jspf"%>
    </head>
    <body>
        <div class="row">
            <div class="col-4">
                <div class="card card-primary">
                    <img src="tu-imagen.jpg" alt="Imagen de la tarjeta">
                    <h2>Título de la Tarjeta 1</h2>
                    <p>Contenido de la tarjeta 1. Puedes agregar aquí información adicional.</p>
                    <a href="#">Botón 1</a>
                </div>
            </div>

            <div class="col-4">
                <div class="card card-secondary">
                    <img src="tu-imagen.jpg" alt="Imagen de la tarjeta">
                    <h2>Título de la Tarjeta 2</h2>
                    <p>Contenido de la tarjeta 2. Puedes agregar aquí información adicional.</p>
                    <button  onclick="modulo()" type="button" class="plus-button">+</button> 
                </div>
            </div>

            <%@include file="components/includes/footer.jspf"%>
             <script src="js/categoria.js"></script>
    </body>

</html>
