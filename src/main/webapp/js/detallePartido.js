let idEquipo;
let idPartido;
let tituloLocal = document.getElementById("equipoLocal");
let tituloRival = document.getElementById("equipoRival");
$(function () {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);

    idEquipo = urlParams.get('idE');
    idPartido = urlParams.get('id');

    estadisticaLocal();
    estadisticaRival();
    cargarTitulos();
});

function estadisticaLocal(){
    $.ajax({
        url: "partidosJugadorServlet",
        dataType: "json",
        data: {
            accion: "listarEstadisticaLocal", partido: idPartido, equipo: idEquipo
        },
        success: function (result) {
            
            if(result.rows.length > 0){
             for(let i = 0; i < result.rows.length; i++){
                  $("#tbEquipoLocal").append("<tr><td>" + result.rows[i][0] + "</td>"
                         + "<td>" +  result.rows[i][1]
                         + "</td><td>" + result.rows[i][2] 
                         + "</td><td>" + result.rows[i][3] 
                         + "</td><td>" +  (result.rows[i][4] * 100).toFixed(2) + "%"
                         + "</td><td>" +  result.rows[i][5] 
                         + "</td><td>" + (result.rows[i][6] * 100).toFixed(2) + "%"
                         + "</td><td>" + result.rows[i][7] 
                         + "</td><td>" + (result.rows[i][8] * 100).toFixed(2) + "%"
                         + "</td><td>" + result.rows[i][9]
                         + "</td><td>" + (result.rows[i][10] * 100).toFixed(2) + "%"
                         + "</td><td>" + result.rows[i][11]
                         + "</td><td>" + result.rows[i][12]
                         + "</td><td>" + result.rows[i][13]
                         + "</td><td>" + result.rows[i][14]
                         + "</td><td>" + result.rows[i][15]
                         + "</td><td>" + result.rows[i][16]
                         + "</td><td>" + result.rows[i][17]
                         + "</td><td>" + result.rows[i][18]
                         + "</td><td>" + result.rows[i][19]
                         + "</td><td>" + result.rows[i][20]
                         + "</td><td>" + result.rows[i][21]
                         + "</td></tr>");
             }
         
            }
            
            
            
       
        }
    });
}

function estadisticaRival(){
    $.ajax({
        url: "partidosJugadorServlet",
        dataType: "json",
        data: {
            accion: "listarEstadisticaRival", partido: idPartido, equipo: idEquipo
        },
        success: function (result) {
            console.log(result.rows);
            if(result.rows.length > 0){
             for(let i = 0; i < result.rows.length; i++){
                  $("#tbEquipoRival").append("<tr><td>" + result.rows[i][0] + "</td>"
                         + "<td>" +  result.rows[i][1]
                         + "</td><td>" + result.rows[i][2] 
                         + "</td><td>" + result.rows[i][3] 
                         + "</td><td>" +  (result.rows[i][4] * 100).toFixed(2) + "%"
                         + "</td><td>" +  result.rows[i][5] 
                         + "</td><td>" + (result.rows[i][6] * 100).toFixed(2) + "%"
                         + "</td><td>" + result.rows[i][7] 
                          + "</td><td>" + (result.rows[i][8] * 100).toFixed(2) + "%"
                         + "</td><td>" + result.rows[i][9]
                          + "</td><td>" + (result.rows[i][10] * 100).toFixed(2) + "%"
                         + "</td><td>" + result.rows[i][11]
                         + "</td><td>" + result.rows[i][12]
                         + "</td><td>" + result.rows[i][13]
                         + "</td><td>" + result.rows[i][14]
                         + "</td><td>" + result.rows[i][15]
                         + "</td><td>" + result.rows[i][16]
                         + "</td><td>" + result.rows[i][17]
                         + "</td><td>" + result.rows[i][18]
                         + "</td><td>" + result.rows[i][19]
                         + "</td><td>" + result.rows[i][20]
                         + "</td><td>" + result.rows[i][21]
                         + "</td></tr>");
             }
         
            }
            
            
            
       
        }
    });
}


function cargarTitulos(){
     $.ajax({
        url: "partidosJugadorServlet",
        dataType: "json",
        data: {
            accion: "cargarTitulos", partido: idPartido, equipo: idEquipo
        },
        success: function (result) {    
            console.log(result.rows);
            if(result.rows.length > 0){
                for(let i = 0; i < result.rows.length; i++){
                    if(result.rows[i][0] == idEquipo){
                       tituloLocal.textContent += "Equipo Local: " + result.rows[i][1];
                    }
                    else{
                        tituloRival.textContent += "Equipo Rival: " + result.rows[i][1];
                    }
                }
            }
        
        }
    
    });
}
