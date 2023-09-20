<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Categoria</title>
        <%@include file="components/includes/header.jspf"%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="js/categoria.js"/>
    </head>

    <body>

        <br><!-- salto de linea -->
        <div class="container">
            <h1>Registro de Categoria</h1>
            <br>
            <br>
            <form action="enviar_registro" id="insertar" method="post">
                <label for="nombre">NOMBRE_CATEGORIA:</label>
                <input type="text" id="NOMBRE_CATEGORIA" name="NOMBRE_CATEGORIA" required><br>

                <label for="email">ABREVIATURA:</label>
                <input type="text" id="ABREVIATURA" name="ABREVIATURA" required><br>

                <label for="edad">DESC_CATEGORIA:</label>
                <input type="text" id="DESC_CATEGORIA" name="DESC_CATEGORIA" required><br>

                <label for="estado">ESTADO_REGISTRO:</label>
                <input type="radio" id="activo" name="ESTADO_REGISTRO" value="ACTIVO"> Activo
                <input type="radio" id="inactivo" name="ESTADO_REGISTRO" value="INACTIVO"> Inactivo<br>

                <label for="imagen">Imagen:</label>
                <input type="file" id="IMAGEN" name="IMAGEN" accept="image/*" required><br>


                <button id="btnInsertar" type="submit">Ingresar</button>
            </form>
        </div>



        <%@include file="components/includes/footer.jspf"%>

    </body>

</html>
