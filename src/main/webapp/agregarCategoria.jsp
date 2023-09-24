<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registrar Categoria</title>
    <%@include file="components/includes/header.jspf"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 class="mt-5">Registro de Categoría</h1>
    <div class="row mt-4">
        <div class="col-md-6">
            <form action="enviar_registro" id="insertar" method="post">
                <div class="form-group">
                    <label for="NOMBRE_CATEGORIA">Nombre de la Categoría:</label>
                    <input type="text" class="form-control" id="NOMBRE_CATEGORIA" name="NOMBRE_CATEGORIA" required>
                </div>
                <div class="form-group">
                    <label for="ABREVIATURA">Abreviatura:</label>
                    <input type="text" class="form-control" id="ABREVIATURA" name="ABREVIATURA" required>
                </div>
                <div class="form-group">
                    <label for="DESC_CATEGORIA">Descripción de la Categoría:</label>
                    <input type="text" class="form-control" id="DESC_CATEGORIA" name="DESC_CATEGORIA" required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="ESTADO_REGISTRO">Estado de Registro:</label>
                    <div>
                        <input type="radio" id="activo" name="ESTADO_REGISTRO" value="ACTIVO"> Activo
                        <input type="radio" id="inactivo" name="ESTADO_REGISTRO" value="INACTIVO"> Inactivo
                    </div>
                </div>
                <div class="form-group">
                    <label for="IMAGEN">Imagen:</label>
                    <input type="text" class="form-control-file" id="IMAGEN" name="IMAGEN" accept="image/*" required>
                </div>
                <button id="btnInsertar" type="submit" class="btn btn-primary">Registrar</button>
            </form>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col-md-6">
            <a href="modulos.jsp" class="btn btn-secondary">Ir a Modulos</a>
            
        </div>
    </div>
</div>
   

<%@include file="components/includes/footer.jspf"%>

</body>
</html>
