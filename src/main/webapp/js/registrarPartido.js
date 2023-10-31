let idEquipo;
let idCategoria;
let idTemporada;
let seleccionarEquipoRival;
let contenidoCol = document.getElementById('jugadoresLoc');
$(function () {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);

    idEquipo = urlParams.get('idE');
    idCategoria = urlParams.get('cat');
    idTemporada = urlParams.get('temp');
    
    seleccionarEquipoRival = document.createElement('select');
    let resultados;
    $.ajax({
        url: "registrarEstadisticasPartidoServlet",
        dataType: "json",
        data:{
            accion: "listarEquiposRivales", idEquipo: idEquipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {
            if(result.rows !== null)
            {
                resultados = result.rows;
                let opcionDefault = document.createElement("option");
                opcionDefault.innerHTML = "---Seleccionar Equipo Rival ---";
                opcionDefault.value = " ";
                seleccionarEquipoRival.appendChild(opcionDefault);
                for(let i = 0; i < result.rows.length; i++){

                   let nuevaOpcion = document.createElement("option");
                   nuevaOpcion.innerHTML = result.rows[0][1];
                   nuevaOpcion.value = result.rows[0][i];
                   seleccionarEquipoRival.appendChild(nuevaOpcion);
                   
                }
                
                seleccionarEquipoRival.id = "select-equipo-rival";
                
                
                document.getElementById("ip-second-row").appendChild(seleccionarEquipoRival);
            }
            
            document.getElementById("select-equipo-rival").addEventListener("change",function(){
                   var valorSeleccionado = event.target.value;  
                   listarJugadores(valorSeleccionado);      
             
            });
    
        }
 });
});


function listarJugadores(equipo){
   
   
        

        $.ajax({
        url: "registrarEstadisticasPartidoServlet",
        dataType: "json",
        data:{
            accion: "listarJugadoresLocales", idEquipo: equipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {
            
           
            if(result.rows !== null)
            {
                   
                   let tablaCol = document.getElementById("tablaRiv");
                   
                  
       
                   let tbody = document.createElement("tbody");
                   

                   
                   for(let i = 0; i < result.rows.length; i++){
                      
                     let fila = document.createElement("tr");
                     fila.setAttribute('data-id', result.rows[i][0]);
                     fila.innerHTML = "<td>" + result.rows[i][1] + "</td>";
                     fila.innerHTML += "<td>" + result.rows[i][2] + ", " + result.rows[i][3] + " " + result.rows[i][4] + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtMinRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTCARiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTCRRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt2PTCARiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt2PTCRRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt3PTCARiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt3PTCRRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTLARiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTLRRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtRebRORiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtRebRDRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtRebTotRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtAsRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTORiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtRBRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTPRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtFPCRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtFPDRiv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt+/-Riv" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtPTSRiv" + (i+1) + "\"/>" + "</td>";
                     
                     tbody.appendChild(fila);
                   }
                
                   
                   
                  
                   tablaCol.appendChild(tbody);
                   
                   
                 
            }
            
    
        }
        
        
 });  
 
    
;}



$(function() {
        

        $.ajax({
        url: "registrarEstadisticasPartidoServlet",
        dataType: "json",
        data:{
            accion: "listarJugadoresLocales", idEquipo: idEquipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {
            if(result.rows !== null)
            {
                   
                   let tablaCol = document.getElementById("tablaCol");
                   
                  
       
                   let tbody = document.createElement("tbody");
                   

                   
                   for(let i = 0; i < result.rows.length; i++){
                      
                     let fila = document.createElement("tr");
                     fila.setAttribute('data-id', result.rows[i][0]);
                     fila.innerHTML = "<td>" + result.rows[i][1] + "</td>";
                     fila.innerHTML += "<td>" + result.rows[i][2] + ", " + result.rows[i][3] + " " + result.rows[i][4] + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtMinLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTCALoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTCRLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt2PTCALoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt2PTCRLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt3PTCALoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt3PTCRLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTLALoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTLRLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtRebROLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtRebRDLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtRebTotLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtAsLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTOLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtRBLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtTPLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtFPCLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtFPDLoc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txt+/-Loc" + (i+1) + "\"/>" + "</td>";
                     fila.innerHTML += "<td>" + "<input type=\"text\" class=\"small-input\" id=\"txtPTSLoc" + (i+1) + "\"/>" + "</td>";
                     
                     tbody.appendChild(fila);
                   }
                
                  
                   
                  
                   tablaCol.appendChild(tbody);
             
                   
                 
            }
            
    
        }
        
        
 });  
 
    
});









