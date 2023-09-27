$(function() {
    
    cargarEquipos();
    //DDL categoias
    
    
});

function registrarNuevo(){
    
    cargarDDLCategorias("ddlCategoria");
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
            cargarEquipos();
            
        }
    }); 
     
});

//Cargar datos para select de categorias
function cargarDDLCategorias(id){
    
    $.ajax({
        url: "equiposRivalesServlet",
        dataType: "json",
        data:{
            accion: "listarCategorias"
        },
        success: function (result) {
            let cantidad = result.rows.length;
            $("#"+id).html("");
            $("#"+id).append("<option value=''>SELECCIONE CATEGORIA</option>");
            
            for (let i = 0; i < cantidad; i++) {
                $("#"+id).append("<option value='"+result.rows[i][0]+"'>"+result.rows[i][1]+"</option>");
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

function botonEquipo(idEquipo, idCategoria){
        
    location.href = 'equipoTemporada.jsp?idE='+idEquipo+"&cat="+idCategoria;
    
}

function editarEquipo(id){
    
    cargarDDLCategorias("ddlEditCategoria");
    
    //"ID_CATEGORIA"	"NOMBRE_CATEGORIA"	"ID_TIPO_EQUIPO"	"TIPO_EQUIPO"	"NOMBRE_EQUIPO"
    $.ajax({
        url: "equiposRivalesServlet",
        dataType: "json",
        data:{
            accion: "cargarDatosEquipo",id:id
        },
        success: function (result) {
            
            $("#txtEditNomEquipo").attr('idEquipo',id);
            $("#ddlEditCategoria").val((result.rows[0][0]).toString());
            $("#txtEditNomEquipo").val(result.rows[0][4]);
            $("#modal-editar").modal("show");
                 
        }
        
    }); 
    
    
  
}

$('#editar-Equipo-rival').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    //obtener datos y registrar equipo
    let idCategoria = $("#ddlEditCategoria option:selected").val();
    let nombreEquipo = $("#txtEditNomEquipo").val();
    let idEquipo = $("#txtEditNomEquipo").attr('idEquipo');
    
    $.ajax({
        url: "equiposRivalesServlet",
        dataType: "json",
        data:{
            accion: "editarEquipo", idCategoria:idCategoria, nombreEquipo:nombreEquipo, idEquipo:idEquipo
        },
        success: function (result) {
            
            $("#modal-editar").modal("hide");
            $("#txtEditNomEquipo").attr('idEquipo',"");
            cargarEquipos();
            
        }
    }); 
     
});