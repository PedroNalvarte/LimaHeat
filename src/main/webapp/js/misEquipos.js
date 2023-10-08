let idParticipante;
let idTipoCuenta;

$(function() {
    
    idParticipante = $("#idParticipante").text();
    idTipoCuenta = $("#idTipoCuenta").text();
    
    if(idTipoCuenta === "1"){
        
        cargarMisEquipos();
        
    }else{
        
        cargarMisEquiposParticipante(idParticipante);
        
    }
});

function cargarMisEquipos(){
    
    $.ajax({
        url: "misEquiposServlet",
        dataType: "json",
        data:{
            accion: "cargarMisEquipos"
        },
        success: function (result) {
            let cantidad = result.rows.length;
            
            $("#lista-mis-Equipos").html("");
            
            for (let i = 0; i < cantidad; i++) {
                
                var html = ``;
                    html += `<article class="mi-button" >`;
                        html += `<div class="card mi-card">`;
                            html += `<h2 class="hola">${result.rows[i][3]}</h2>`;
                            html += `<div class="row"><i class="bi bi-bookmark"></i><label>${result.rows[i][2]}</label></div>`;
                            html += `<div class="botones"><a id="${result.rows[i][0]}" onclick="editarEquipo(this.id)" <i class="bi bi-pencil"></i>      <a id="${result.rows[i][0]}" cat="${result.rows[i][1]}" onclick="botonEquipo(this.id,this.getAttribute('cat'))"<i class="bi bi-eye-fill"></i></a></div>`;
                        html += `</div>`;
                    html += `</article>`;
                 
                $("#lista-mis-Equipos").append(html);
            }
            
            var html = ``;
                    html += `<button class="mi-button" onclick="registrarNuevo()">`;
                        html += `<div class="card mi-card card-agregar">`;
                            html += `<i style="font-size: 70px" class="bi bi-plus-circle-fill"></i>`;
                            html += `<h2>REGISTRAR NUEVO</h2>`;
                        html += `</div>`;
                    html += `</button>`;

            $("#lista-mis-Equipos").append(html);       
        }
    });    
}

function cargarMisEquiposParticipante(idParticipante){
    
    $.ajax({
        url: "misEquiposServlet",
        dataType: "json",
        data:{
            accion: "cargarMisEquiposParticipante", participante: idParticipante
        },
        success: function (result) {
            let cantidad = result.rows.length;
            
            $("#lista-mis-Equipos").html("");
            
            for (let i = 0; i < cantidad; i++) {
                
                var html = ``;
                    html += `<article class="mi-button" >`;
                        html += `<div class="card mi-card">`;
                            html += `<h2>${result.rows[i][3]}</h2>`;
                            html += `<div class="row"><i class="bi bi-bookmark"></i><label>${result.rows[i][2]}</label></div>`;
                            html += `<div class="botones"><a id="${result.rows[i][0]}" onclick="editarEquipo(this.id)" <i class="bi bi-pencil"></i>      <a id="${result.rows[i][0]}" cat="${result.rows[i][1]}" onclick="botonEquipo(this.id,this.getAttribute('cat'))"<i class="bi bi-eye-fill"></i></a></div>`;
                        html += `</div>`;
                    html += `</article>`;
                 
                $("#lista-mis-Equipos").append(html);
            }       
        }
    });    
}



//Cargar datos para select de categorias
function cargarDDLCategorias(){
    
    $.ajax({
        url: "equiposRivalesServlet",
        dataType: "json",
        data:{
            accion: "listarCategorias"
        },
        success: function (result) {
            let cantidad = result.rows.length;
            $("#ddlCategoria").html("");
            $("#ddlCategoria").append("<option value=''>SELECCIONE CATEGORIA</option>");
            
            for (let i = 0; i < cantidad; i++) {
                $("#ddlCategoria").append("<option value='"+result.rows[i][0]+"'>"+result.rows[i][1]+"</option>");
            }
        }
    });   
}

function registrarNuevo(){
    
    cargarDDLCategorias();
   $("#modal-registrar-equipo").modal("show");
}


$('#registrar-Equipo').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let idCategoria = $("#ddlCategoria option:selected").val();
    let nombreEquipo = $("#txtNomEquipo").val();
    
    $.ajax({
        url: "misEquiposServlet",
        dataType: "json",
        data:{
            accion: "registrarEquipo", idCategoria:idCategoria, nombreEquipo:nombreEquipo
        },
        success: function (result) {
            
            $("#modal-registrar-equipo").modal("hide");
            cargarMisEquipos();
            
        }
    });
    
    
});

function botonEquipo(idEquipo, idCategoria){
        
    location.href = 'equipoTemporada.jsp?idE='+idEquipo+"&cat="+idCategoria;
    
}

