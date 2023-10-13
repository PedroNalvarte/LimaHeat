<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lima Heat</title>
        <%@include file="components/includes/header-noUser.jspf"%>
        <link rel="stylesheet" href="css/limaHeatIndex.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400&display=swap" rel="stylesheet">
        <style>
            body {
                background-color: white;
            }

            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;

            }

            section{
                position:relative;
                width: 100%;
                min-height: 100vh;
                padding:100px;
                display:flex;
                justify-content: space-between;
                align-items: center;
                background: white;
            }

            header{
                position:absolute;
                top:0;
                left: 0;
                width: 100%;
                padding: 20px 100px;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            header .logo{
                position: relative;
                max-width: 80px;
                max-height: 100px;
            }

            header ul{
                position: relative;
                display: flex;
            }

            header ul li{
                list-style: none;
            }

            header ul li a{
                display: inline-block;
                color: #801F1F;
                font-weight: 400;
                margin-left: 40px;
                text-decoration: none;
            }

            .content{
                position:relative;
                width:100%;
                display:flex;
                justify-content:space-between;
                align-items: center;
            }

            .content .textBox{
                position: relative;
                max-width: 600px;
            }

            .content .textBox h2{
                color: black;
                font-size: 4em;
                line-height: 1.4em;
                font-weight: 500;
            }

            .content .textBox h2 span{
                color: #801F1F;
                font-size: 1.2em;
                font-weight: 900;
            }

            .content .textBox p{
                color: #333;
            }

            .content .textBox a{
                display: inline-block;
                margin-top: 20px;
                padding: 8px 20px;
                background: #801F1F;
                color: #fff;
                border-radius:40px;
                font-weight: 500;
                letter-spacing: 1px;
                text-decoration: none;
            }

            .content .imgBox{
                width: 850px; 
                height: 500px; 
                display: flex;

                padding-right: 800px; 
                margin-top: 50px;
            }

            .content .imgBox img{
                max-width: 340px;
            }

            .thumb{
                position: absolute;
                left: 50%;
                bottom: 20px;
                transform: translateX(-50%);
                display: flex;
            }

            .thumb li{
                list-style: none;
                display: inline-block;
                margin: 0 20px;
                cursor: pointer;

            }

            .thumb li:hover{
                transform: translateY(-15px);
            }

            .thumb li img{
                max-width: 60px;
            }

            .sci{
                position: absolute;
                top: 50%;
                right: 3%;
                transform: translateY(-50%);
                display: flex;
                justify-content: center;
                align-items:center;
                flex-direction: column;

            }

            .sci li{
                list-style: none;
            }

            .sci li a{
                display: inline-block;
                margin: 5px 0;
                transform: scale(0.6);
            }

            .circle{
                position: absolute;
                top: 50p;
                left: 0;
                width: 100%;
                height: 100%;
                background: #801F1F;
                clip-path: circle(600px at right 800px);
            }
        </style>
    </head>
    <body>
        <section>
            <div class="circle"></div>
            <header>
                <a href="#"><img src="https://cdn.discordapp.com/attachments/877328260357324832/1161403159122554910/logointento1.png?ex=65382bfa&is=6525b6fa&hm=b220f1351f103cc469d487b3f1a9eda8468efce47aba67eab5b672f647438a06&" class="logo"></a>
                <span style="font-weight: bold; font-size: 24px; margin-left: -1130px;">Lima Heat</span>
                <ul>
                    <li><a href="#" ><strong>Inicio</strong></a></li>
                    <li><a href="#"><strong>Nosotros</strong></a></li>
                    <li><a href="#" id="linkIniciarSesionHeader"><strong>Iniciar Sesión</strong></a></li>

                </ul>
            </header>
            <div class="content">
                <div class="textBox">
                    <h2> Lima Heat <br> Promoviendo el <span> Baloncesto</span></h2>
                    <p> Somos una organización que promueve el baloncesto como una vía para el crecimiento personal y 
                        desarrollo de habilidades que trasciendan el deporte, proporcionando un entorno 
                        donde nuestros jugadores aprenden a enfrentar desafíos, 
                        trabajo en equipo y perseguir la excelencia. </p>
                    <a href="#" id="linkIniciarSesion" > Iniciar Sesión </a>
                </div>  
                <div class="imgBox">
                    <img src="prueba.png" class="portada"/>
                </div>
            </div>
            <ul class="thumb">
                <li><img src="prueba.png" onclick="imgSlider('prueba.png')"></li>
                <li><img src="prueba2.png" onclick="imgSlider('prueba2.png')"></li>
                <li><img src="prueba3.png" onclick="imgSlider('prueba3.png')"></li>
            </ul>
            <ul class="sci">
                <li><a href="https://www.facebook.com/LimaHeatBasquet"><img src="facebookicon.png"></a>
                <li><a href="https://www.instagram.com/limaheat/"><img src="instagramicon.png"></a>
                <li><a href="https://www.tiktok.com/@limaheatbasquet?lang=es"><img src="tiktokicon2.png"></a>

            </ul>

        </section>


        <%@include file="components/includes/footer-noUser.jspf"%>

        <script type="text/javascript">
            function imgSlider(anything) {
                document.querySelector('.portada').src = anything;
            }

        </script>


        <script>

            $('#linkIniciarSesion').on('click', function (event) {
                window.location.href = "login.jsp";
            });

            $('#linkIniciarSesionHeader').on('click', function (event) {
                window.location.href = "login.jsp";
            });

        </script>
    </body>
</html>