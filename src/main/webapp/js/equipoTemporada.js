$(function() {

	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);

	let idEquipo = urlParams.get('idE');
	let idCategoria = urlParams.get('cat');
        
        $("#container-temporadas").attr("idEquipo",idEquipo);
        $("#container-temporadas").attr("idCategoria",idCategoria);
        
        cargarTitulo(idEquipo, idCategoria);
        cargarTemporadas();
        
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

//Cargar equipos registrados
//ID_EQUIPO ID_CATEGORIA NOMBRE_CATEGORIA NOMBRE_EQUIPO
function cargarTemporadas(){
    
    /*
    $.ajax({
        url: "equiposRivalesServlet",
        dataType: "json",
        data:{
            accion: "listarEquiposRegistrados"
        },
        success: function (result) {
            let cantidad = result.rows.length;
            
            $(".lista-equipos-rivales").html("");
            
            for (let i = 0; i < cantidad; i++) {
                
                var html = ``;
                    html += `<article class="mi-button" >`;
                        html += `<div class="card mi-card">`;
                            html += `<h2>${result.rows[i][3]}</h2>`;
                            html += `<div class="row"><i class="bi bi-bookmark"></i><label>${result.rows[i][2]}</label></div>`;
                            html += `<div class="botones"><a id="${result.rows[i][0]}" onclick="editarEquipo(this.id)" <i class="bi bi-pencil"></i>      <a id="${result.rows[i][0]}" cat="${result.rows[i][1]}" onclick="botonEquipo(this.id,this.getAttribute('cat'))"<i class="bi bi-eye-fill"></i></a></div>`;
                        html += `</div>`;
                    html += `</article>`;
                 
                $(".lista-equipos-rivales").append(html);
            }
            
            
                  
        }
    });
    */
    
    var html = ``;
                    html += `<button class="mi-button" onclick="registrarNuevo()">`;
                        html += `<div class="card mi-card card-agregar">`;
                            html += `<i style="font-size: 70px" class="bi bi-plus-circle-fill"></i>`;
                            html += `<h2>REGISTRAR NUEVO</h2>`;
                        html += `</div>`;
                    html += `</button>`;

            $("#container-temporadas").append(html);
     
}

function registrarNuevo(){
    
    $("#modal-registrar-equipo-rival").modal("show");
    
} 

$('#registrar-equipo-temporada').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    alert("hola");
    
    /*
    $.ajax({
        url: "limaHeatServlet",
        dataType: "json",
        data:{
            accion: "iniciar-sesion",usuario:usuario, contra:contra
        },
        success: function (result) {
            

        }
    }); 
    */
});
