let idParticipante;
let idEquipo;
let tituloJugador = document.getElementById("nombreJugador");

$(function () {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);

    idParticipante = $("#idParticipante").text();
    idEquipo = urlParams.get('idE');
    
  
    mostrarRendimiento();
    listarPartidos();
    cargarTitulo();
    
});



// id_partido, nombre_equipo, resultado, detalle_resultado, lugar, fecha_partido, nombre_temporada, 
function listarPartidos(){
     $.ajax({
        url: "partidosJugadorServlet",
        dataType: "json",
        data: {
            accion: "listarPartidos", jugador: idParticipante, equipo: idEquipo
        },
        success: function (result) {
           
            
            
            for(let i = 0; i < result.rows.length; i++){
                let resultado;
                if(result.rows[i][2] === 'G'){
                    resultado = 'Ganado';
                }
                else if(result.rows[i][2] === 'P'){
                    resultado = 'Perdido';
                }
                else{
                    resultado = 'Empate';
                }
                
                 var fechaEnBaseDeDatos = result.rows[i][5];
                    var fechaFormateada = new Date(fechaEnBaseDeDatos);
                    var opcionesDeFormato = {
                        year: 'numeric',
                        month: '2-digit',
                        day: '2-digit'              
                    };
                    var fechaFormateada = fechaFormateada.toLocaleString(undefined, opcionesDeFormato);
                
                $("#tblPartidos").append("<tr><td>" + result.rows[i][1] + "</td>"
                         + "<td>" + resultado 
                         + "</td><td>" + result.rows[i][3] 
                         + "</td><td>" + result.rows[i][4] 
                         + "</td><td>" + fechaFormateada 
                         + "</td><td>" + result.rows[i][6]
                         + "</td><td>" +
                            "<a class=\"btn-Visualizar\" data-partido-id=\"" + result.rows[i][0] + "\" href=\"detallePartidoJugador.jsp?id=" + result.rows[i][0] + "&idE=" + idEquipo + "\">" +
                                "<i class=\"bi bi-plus-circle\"></i>" +
                            "</a>"
 
                         + "</td></tr>");

            }
        }
    });
}


function mostrarRendimiento(){
     $.ajax({
        url: "partidosJugadorServlet",
        dataType: "json",
        data: {
            accion: "rendimientoGeneral", jugador: idParticipante
        },
        success: function (result) {
            if(result.rows.length > 0){
                for(let i = 0; i < result.rows.length; i++){
                      $("#tbRendimiendoGeneral").append("<tr><td>" + result.rows[i][0] + "</td>"
                         + "<td>" + result.rows[i][1]
                         + "</td><td>" + result.rows[i][2] 
                         + "</td><td>" + result.rows[i][3] 
                         + "</td><td>" + result.rows[i][4]
                         + "</td><td>" + result.rows[i][5]
                         + "</td><td>" + result.rows[i][6]
                         + "</td><td>" + result.rows[i][7]
                         + "</td><td>" + result.rows[i][8]
                         + "</td><td>" + result.rows[i][9]
                         + "</td><td>" + result.rows[i][10]
                         + "</td><td>" + result.rows[i][11]
                         + "</td><td>" + result.rows[i][12]
 
                         + "</td></tr>");
                }
            }
        }
    });
}

function cargarTitulo(){
    $.ajax({
        url: "partidosJugadorServlet",
        dataType: "json",
        data: {
            accion: "nombreJugador", jugador: idParticipante
        },
        success: function (result) {
             tituloJugador.textContent += " " + result.rows[0][0];
        }
    }); 
}





