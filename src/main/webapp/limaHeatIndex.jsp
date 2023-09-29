<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lima Heat</title>
        <%@include file="components/includes/header-noUser.jspf"%>
        <link rel="stylesheet" href="css/limaHeatIndex.css"/>
    </head>
    <body>
        
        <button id="btbQuienesSomos">¿Quienes Somos?</button>

        <button id="btnInicioSesion">Iniciar Sesion</button>

        

        <%@include file="components/includes/footer-noUser.jspf"%>
        <script>
            
            $('#btbQuienesSomos').on('click', function(event){
                window.location.href = "nosotros.jsp";
            });
            
            $('#btnInicioSesion').on('click', function(event){
                window.location.href = "login.jsp";
            });
          
            
        </script>
    </body>
</html>
