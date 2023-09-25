$(function() {
    
    cargarEquipos();
    //DDL categoias
    
    
});

function registrarNuevo(){
    
    cargarDDLCategorias();
    $("#ddlCategoria").val("0");
    $("#txtNomEquipo").val("");
    $("#modal-registrar-equipo-rival").modal("show");
    
}

$('#registrar-Equipo-rival').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    //obtener datos y registrar equipo
    let idCategoria = $("#ddlCategoria option:selected").val();
    let nombreEquipo = $("#txtNomEquipo").val();
    
    $.ajax({
        url: "equiposRivalesServlet",
        dataType: "json",
        data:{
            accion: "registrarEquipo", idCategoria:idCategoria, nombreEquipo:nombreEquipo
        },
        success: function (result) {
            
            $("#modal-registrar-equipo-rival").modal("hide");
            
        }
    }); 
     
});

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

//Cargar equipos registrados
//ID_EQUIPO ID_CATEGORIA NOMBRE_CATEGORIA NOMBRE_EQUIPO
function cargarEquipos(){
    
    $.ajax({
        url: "equiposRivalesServlet",
        dataType: "json",
        data:{
            accion: "listarEquiposRegistrados"
        },
        success: function (result) {
            let cantidad = result.rows.length;
            
            for (let i = 0; i < cantidad; i++) {
                
                var html = ``;
                    html += `<button idEquipo="${result.rows[i][0]}" idCategoria="${result.rows[i][1]}" class="mi-button">`;
                        html += `<div class="card mi-card">`;
                            html += `<h2>${result.rows[i][3]}</h2>`;
                            html += `<div class="input-group">`;
                                html += `<i class="bi bi-bookmark"> </i> <label>${result.rows[i][2]}</label>`;
                            html += `</div>`;
                        html += `</div>`;
                    html += `</button>`;
                 
                $(".lista-equipos-rivales").append(html);
            }
            
            var html = ``;
                    html += `<button class="mi-button" onclick="registrarNuevo()">`;
                        html += `<div class="card mi-card card-agregar">`;
                            html += `<i style="font-size: 70px" class="bi bi-plus-circle-fill"></i>`;
                            html += `<h2>REGISTRAR NUEVO</h2>`;
                        html += `</div>`;
                    html += `</button>`;

            $(".lista-equipos-rivales").append(html);
                  
        }
    }); 
     
}