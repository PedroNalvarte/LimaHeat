$(function() {

	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);

	let idEquipo = urlParams.get('idE');
	let idCategoria = urlParams.get('cat');
        
        $("#container-temporadas").attr("idEquipo",idEquipo);
        $("#container-temporadas").attr("idCategoria",idCategoria);
        
        cargarTitulo(idEquipo, idCategoria);
        cargarTemporadas(idEquipo, idCategoria);
        
});

function cargarTitulo(idEquipo, idCategoria){
    
    $.ajax({
        url: "equipoTemporadaServlet",
        dataType: "json",
        data:{
            accion: "cargarTitulo", idEquipo:idEquipo, idCategoria:idCategoria
        },
        success: function (result) {
            
            $("#titulo").text("Temporadas del Equipo "+result.rows[0][0]); 
        }
    });
    
}

//Cargar temporadas registradas
//"ID_TEMPORADA"	"NOMBRE_TEMPORADA"	"TIPO_TEMPORADA"	"FECHA_INICIO"	"FECHA_FIN"
function cargarTemporadas(idEquipo, idCategoria){
    
    $.ajax({
        url: "equipoTemporadaServlet",
        dataType: "json",
        data:{
            accion: "listarTemporadas", idEquipo:idEquipo, idCategoria:idCategoria
        },
        success: function (result) {
            let cantidad = result.rows.length;
            
            $("#container-temporadas").html("");
            
            for (let i = 0; i < cantidad; i++) {
                
                let dateInicio = new Date(result.rows[0][3]);
                let dateFinal = new Date(result.rows[0][4]);
                
                var html = ``;
                    html += `<article class="mi-button" >`;
                        html += `<div class="card mi-card">`;
                            html += `<h2>${result.rows[i][1]} ${result.rows[i][2]}</h2>`;
                            html += `<div class="row"><i class="bi bi-calendar"></i><label>${dateInicio.getFullYear()+"/"+(dateInicio.getMonth()+1).toString().padStart(2, '0')} - ${dateFinal.getFullYear()+"/"+(dateFinal.getMonth()+1).toString().padStart(2, '0')}</label></div>`;
                            html += `<div class="botones"><a id="${result.rows[i][0]}" onclick="botonTemporada(this.id)"><i class="bi bi-eye-fill"></i></a></div>`;
                        html += `</div>`;
                    html += `</article>`;
                 
                $("#container-temporadas").append(html);
            }
            
            var html = ``;
                    html += `<button class="mi-button" onclick="registrarNuevo()">`;
                        html += `<div class="card mi-card card-agregar">`;
                            html += `<i style="font-size: 70px" class="bi bi-plus-circle-fill"></i>`;
                            html += `<h2>REGISTRAR NUEVO</h2>`;
                        html += `</div>`;
                    html += `</button>`;

            $("#container-temporadas").append(html);
                   
        }
    });
    
    
     
}

function registrarNuevo(){
    
    cargarDDLTipoDocumento();
    cargarDDLTemporadas();
    $("#txtNom").val("");
    $("#txtApe1").val("");
    $("#txtApe2").val("");
    $("#txtDocIde").val("");

    $("#modal-registrar-equipo-rival").modal("show");
    
} 

$('#registrar-equipo-temporada').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let nombres = $("#txtNom").val();
    let ape1 = $("#txtApe1").val();
    let ape2 = $("#txtApe2").val();
    let tipoDocIde = $("#ddlDocId option:selected").val();
    let numDocIDe = $("#txtDocIde").val();
    let idTemporada = $("#ddlTemporada option:selected").val();
    let idEquipo = $("#container-temporadas").attr("idEquipo");
    let idCategoria = $("#container-temporadas").attr("idCategoria");
    
    //alert(nombres+" "+ape1+" "+ape2+" "+tipoDocIde+" "+numDocIDe+" "+idTemporada+" "+idEquipo+" "+idCategoria);
            
    $.ajax({
        url: "equipoTemporadaServlet",
        dataType: "json",
        data:{
            accion: "registrarTemporada", nombres:nombres, ape1:ape1, ape2:ape2, tipoDocIde:tipoDocIde, numDocIDe:numDocIDe, 
            idTemporada:idTemporada, idEquipo:idEquipo, idCategoria:idCategoria
        },
        success: function (result) {
            
            $("#modal-registrar-equipo-rival").modal("hide");
            cargarTemporadas(idEquipo, idCategoria);
            
        }
    }); 
    
});

//-------------------------------------------------------Carga DDLS----------------------------------------------------------------------

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
            $("#ddlDocId").append("<option value=''>SELECCIONE TIPO DOCUMENTO DE IDENTIDAD</option>");
            
            for (let i = 0; i < cantidad; i++) {
                $("#ddlDocId").append("<option value='"+result.rows[i][0]+"'>"+result.rows[i][1]+"</option>");
            }
        }
    });
      
}

//"ID_TEMPORADA"	"ID_TIPO_TEMPORADA"	"TIPO_TEMPORADA"	"NOMBRE_TEMPORADA"	"FECHA_INICIO"	"FECHA_FIN"
function cargarDDLTemporadas(){
    
    $.ajax({
        url: "equipoTemporadaServlet",
        dataType: "json",
        data:{
            accion: "cargarDDLTemporadas"
        },
        success: function (result) {
            
            let cantidad = result.rows.length;
            $("#ddlTemporada").html("");
            $("#ddlTemporada").append("<option value=''>SELECCIONE TEMPORADA</option>");
            
            for (let i = 0; i < cantidad; i++) {
                $("#ddlTemporada").append("<option value='"+result.rows[i][0]+"' tipoTemporada='"+result.rows[i][1]+"'>"+result.rows[i][3]+" "+result.rows[i][2]+"</option>");
            }
        }
    });
}

function botonTemporada(id){
    
    let idEquipo = $("#container-temporadas").attr("idEquipo");
    let idCategoria = $("#container-temporadas").attr("idCategoria");
    
    
    location.href = 'modulosEquipo.jsp?idE='+idEquipo+"&cat="+idCategoria+"&temp="+id;
}
