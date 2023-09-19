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
            <form action="enviar_registro" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-3">
                        <label for="nombre">NOMBRE_CATEGORIA:</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" required>
                    </div>
                    <div class="col-3">
                        <label for="email">ABREVIATURA:</label>
                        <input type="text" id="email" name="email" class="form-control" required>
                    </div>
                    <div class="col-3">
                        <label for="edad">DESC_CATEGORIA:</label>
                        <input type="text" id="edad" name="edad" class="form-control" required>
                    </div>
                    <br>
                    <br>
                    <br>
                    <br>
                </div>
                <div class="row">
                    <div class="col-3">
                        <label for="fecha">FECHA_REGISTRO:</label>
                        <input type="date" id="fecha" name="fecha" class="form-control" required>
                    </div>
                    <div class="col-6">
                        <label for="estado">ESTADO_REGISTRO:</label>
                        <div>
                            <input type="radio" id="activo" name="estado" value="ACTIVO"> Activo
                            <input type="radio" id="inactivo" name="estado" value="INACTIVO"> Inactivo
                        </div>
                    </div>

                </div>
                <br>
                <br>
                <div class="row">
                    <div class="col-3">
                        <label for="imagen">Selecciona una imagen:</label>
                        <input type="file" id="imagen" name="imagen" accept="image/*" class="form-control-file" required>
                    </div>
                </div>    
                <input type="submit" value="Subir Imagen" class="btn btn-warning">

                <br><br>
                <input type="submit" value="Enviar" class="btn btn-primary">
            </form>
        </div>



        <%@include file="components/includes/footer.jspf"%>

    </body>

</html>
