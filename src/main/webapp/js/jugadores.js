let idEquipo;
let idCategoria;
let idTemporada;

$(function() {

	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);

	idEquipo = urlParams.get('idE');
	idCategoria = urlParams.get('cat');
        idTemporada = urlParams.get('temp');
        
        cargarTitulo(idEquipo, idCategoria, idTemporada);
        cargarlista();
});

function registrarNuevo(){
    
    cargarDDLTipoDocumento();
    cargarDDLPosicion();
    $("#txtNom").val("");
    $("#txtApe1").val("");
    $("#txtApe2").val("");
    $("#txtDocIde").val("");
    $("#txtPeso").val("");
    $("#txtAltura").val("");
    $("#fecNac").val("");
    $("#txtDorsal").val("");
    
    $("#modal-registrar").modal("show");
    
}

$('#registrar-jugador').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let nom = $("#txtNom").val();
    let ape1 = $("#txtApe1").val();
    let ape2 = $("#txtApe2").val();
    let tipDoc = $("#ddlDocId").val();
    let numDoc = $("#txtDocIde").val();
    let peso = $("#txtPeso").val();
    let altura = $("#txtAltura").val();
    let fecnac = $("#fecNac").val();
    let posicion = $("#ddlPosicion").val();
    let numeroDorsal = $("#txtDorsal").val();
    
    //alert(nom+" "+ape1+" "+ape2+" "+tipDoc+" "+numDoc+" "+peso+" "+altura+" "+fecnac+" "+posicion+" "+numeroDorsal);
    
    $.ajax({
        url: "jugadoresServlet",
        dataType: "json",
        data:{
            accion: "registrar-jugador", nom:nom, ape1:ape1, ape2:ape2, tipDoc:tipDoc, numDoc:numDoc, peso:peso, altura:altura,
                fecnac:fecnac, posicion:posicion, numeroDorsal:numeroDorsal, idEquipo:idEquipo, idCategoria:idCategoria, idTemporada:idTemporada
        },
        success: function (result) {
            
            $("#modal-registrar").modal("hide");
            cargarlista();
            
        }
    });

 });

function cargarlista(){
    
    //"ID_PARTICIPANTE"	"NOMBRES"	"APELLIDO_1"	"APELLIDO_2"	"NUMERO_DORSAL"	"POSICION"	date_part	"PESO"	"ALTURA"
    $.ajax({
        url: "jugadoresServlet",
        dataType: "json",
        data:{
            accion: "cargaListaJugadores", idEquipo:idEquipo, idCategoria:idCategoria, idTemporada:idTemporada
        },
        success: function (result) {
            
            let cantidad = result.rows.length;
            
            $("#tblJugadores").html("");
            
            if(cantidad > 0){
                
                for(let i = 0; i<cantidad; i++){
                    
                    var html = ``;
                        html += `<tr>`;
                            html += `<td>${i+1}</td>`;
                            html += `<td id="nom${result.rows[i][0]}">${result.rows[i][1]} ${result.rows[i][2]} ${result.rows[i][3]}</td>`;
                            html += `<td id="dorsal${result.rows[i][0]}">${result.rows[i][4]}</td>`;
                            html += `<td id="posicion${result.rows[i][0]}">${result.rows[i][5]}</td>`;
                            html += `<td id="edad${result.rows[i][0]}"${result.rows[i][6]}</td>`;
                            html += `<td id="peso${result.rows[i][0]}">${result.rows[i][7]}</td>`;
                            html += `<td id="nom${result.rows[i][0]}">${result.rows[i][8]}</td>`;
                            html += `<td id="nom${result.rows[i][0]}"><a id="${result.rows[i][0]}" onclick="editarJugador(this.id)" <i class="bi bi-pencil"></i></td>`;
                            html += `<td>Estadisticas</td>`;
                    html += `</tr>`;
                 
                $("#tblJugadores").append(html); 
                }
            }
               
        }
    }); 
    
}

function editarJugador(idJugador){
    
    $("#modal-editar").modal("show");
}

//"NOMBRE_EQUIPO"	"NOMBRE_TEMPORADA"	"TIPO_TEMPORADA"	nombre    ID_TIPO_EQUIPO      TIPO_EQUIPO
function cargarTitulo(idEquipo, idCategoria, idTemporada){
    
    $.ajax({
        url: "modulosEquipoServlet",
        dataType: "json",
        data:{
            accion: "cargarTitulo", idEquipo:idEquipo, idCategoria:idCategoria, idTemporada:idTemporada
        },
        success: function (result) {
            
            $("#titulo").text("Jugadores de "+result.rows[0][0]);
            $("#temporada").text("Temporada: "+result.rows[0][1]+" "+result.rows[0][2]);
            
        }
    });  
}

//----------------------------Carga de DDLs--------------------
function cargarDDLTipoDocumento(){
    
    $.ajax({
        url: "equipoTemporadaServlet",
        dataType: "json",
        data:{
            accion: "cargarTipoDni"
        },
        success: function (result) {
            
            let cantidad = result.rows.length;
            $("#ddlDocId").html("");
            $("#ddlDocId").append("<option value=''>SELECCIONE TIPO DOCUMENTO</option>");
            
            for (let i = 0; i < cantidad; i++) {
                $("#ddlDocId").append("<option value='"+result.rows[i][0]+"'>"+result.rows[i][1]+"</option>");
            }
        }
    }); 
}

function cargarDDLPosicion(){
    
    ////ID_POSICION     POSICION     ABREVIATURA
    $.ajax({
        url: "jugadoresServlet",
        dataType: "json",
        data:{
            accion: "cargarDDLPosicion"
        },
        success: function (result) {
            
            let cantidad = result.rows.length;
            $("#ddlPosicion").html("");
            $("#ddlPosicion").append("<option value=''>SELECCIONE POSICIÓN</option>");
            
            for (let i = 0; i < cantidad; i++) {
                $("#ddlPosicion").append("<option value='"+result.rows[i][0]+"'>"+result.rows[i][1]+"</option>");
            }
        }
    }); 
}