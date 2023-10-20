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