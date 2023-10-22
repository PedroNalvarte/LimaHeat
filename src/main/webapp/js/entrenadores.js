// Creacion de tabla
let contenidoCol = document.getElementById('contenidoCol');
let listaEntrenadores;

let idEquipo;
let idCategoria;
let idTemporada;

$(function() {
    
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
        let tipoDocumentoC = document.getElementById("tipoDocumento");
        listarTipoDocumento(tipoDocumentoC);
        listarTipoDocumento(document.getElementById("tipoDocumentoE"));
	idEquipo = urlParams.get('idE');
	idCategoria = urlParams.get('cat');
        idTemporada = urlParams.get('temp');
        

        $.ajax({
        url: "entrenadoresServlet",
        dataType: "json",
        data:{
            accion: "listar", equipo: idEquipo, temporada: idTemporada, categoria: idCategoria
        },
        success: function (result) {
            if(result.rows !== null)
            {
                   listaEntrenadores = result.rows;
                   let tablaCol = document.createElement("table");
                   tablaCol.classList.add("table");
                   tablaCol.id = "tablaCol";
                   tablaCol.classList.add("table-striped");
                   tablaCol.innerHTML += "<tr><th>Nombres</th><th>Apellidos</th><th>Tipo de Documento de Identidad</th><th>Documento de Identidad</th><th>Fecha de Nacimiento</th><th>Opciones</th></tr>";
                   let tbody = document.createElement("tbody");
                   

                   
                   for(let i = 0; i < result.rows.length; i++){
                      
                     let fila = document.createElement("tr");
                     fila.setAttribute('data-id', result.rows[i][0]);
                     fila.innerHTML = "<td>" + result.rows[i][1] + "</td>";
                     fila.innerHTML += "<td>" + result.rows[i][2] + ", " + result.rows[i][3] + "</td>";
                     fila.innerHTML += "<td>" + result.rows[i][4] + "</td>";
                     fila.innerHTML += "<td>" + result.rows[i][5] + "</td>";
                     fila.innerHTML += "<td>" + result.rows[i][6] + "</td>";
                  
                     fila.innerHTML += "<td><i class=\"bi bi-pencil boton-editar\"></i> <i class=\"bi bi-x-circle boton-eliminar\" id=\"boton-eliminar\"></i></td>";
                     tbody.appendChild(fila);
                   }
                
                   
                   
                  
                   tablaCol.appendChild(tbody);
                   contenidoCol.appendChild(tablaCol);
                   
                    let botonEliminarEntrenador =  document.getElementsByClassName("boton-eliminar");

                    for(let i = 0; i < botonEliminarEntrenador.length; i++){
                         botonEliminarEntrenador[i].addEventListener("click", function (){
                                   let dataId = this.parentElement.parentElement.getAttribute("data-id");
                                   eliminarEntrenador(dataId);
                         }); 
                    }
                    
                     let botonEditarEntrenador =  document.getElementsByClassName("boton-editar");

                    for(let i = 0; i < botonEditarEntrenador.length; i++){
                         botonEditarEntrenador[i].addEventListener("click", function (){
                                   let dataId = this.parentElement.parentElement.getAttribute("data-id");
                                   obtenerEntrenador(dataId);
                         }); 
                    }
                 
            }
            else{
                let mensajeNull = document.createElement("h2");
                mensajeNull.innerHTML = 'No hay colaboradores de este equipo para esta temporada';
                
                contenidoCol.appendChild(mensajeNull);
            }
    
        }
 });        
});

/*Busqueda de Entrenador*/
function buscarEntrenador(){
    var input, filter, tabla, fila, i, txtValue;
    //Optenemos el input
    input = document.getElementById("busquedaE");
    filter = input.value.toUpperCase();
  
    tabla = document.getElementById("tablaCol");
    fila = tabla.getElementsByTagName("tr");
    for (i = 1; i < fila.length; i++) {
        let campoNombre = fila[i].getElementsByTagName("td")[0];
        let apellidos = fila[i].getElementsByTagName("td")[1].textContent.split(", ");
        
        let campoApellido1 = apellidos[0];
        let campoApellido2 = apellidos[1];
        txtValue = campoNombre.textContent;
        
       
        if (txtValue.toUpperCase().indexOf(filter) > -1 || campoApellido1.toUpperCase().indexOf(filter) > -1 || campoApellido2.toUpperCase().indexOf(filter) > -1) {
            
            fila[i].style.display = "";
            
        } else {
            fila[i].style.display = "none";
        }
    }
}

/*Registrar Entrenador*/
let botonRegistrarEntrenador = document.getElementById("btn-registrar-entrenador");

botonRegistrarEntrenador.addEventListener("click", registrarEntrenador);
function registrarEntrenador(){
   
    $('#modal-creacion-entrenador').modal('show');
}

 $('#registrarEntrenador').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let nombreC = $("#nombreEntrenador").val();
    let apellido1C = $("#apellido1Entrenador").val();
    let apellido2C = $("#apellido2Entrenador").val();
    let tipoDocIdC = $("#tipoDocumento").val();
    let numeroDocC = $("#numeroDocumento").val();
    let fechaNacimientoC = $("#fechaNacimiento").val();
    
  
    $.ajax({
        url: "entrenadoresServlet",
        dataType: "json",
        data:{
            accion: "registrarEntrenador", nombre: nombreC, apellido1:apellido1C, apellido2:apellido2C,
            idTipoDoc: tipoDocIdC, numDocumento: numeroDocC, fecha_nacimiento: fechaNacimientoC, idEquipo: idEquipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {
             $("#modal-creacion-entrenador").modal("hide");
             window.location.href = "entrenadores.jsp?idE=" + idEquipo + "&cat=" + idCategoria + "&temp=" + idTemporada ;
      
            
        },
         error: function (error) {
          console.error("Error en la solicitud:", error.responseText);
        }
    });
 });

/*Elilminar Entrenador*/

 
 function eliminarEntrenador(id){
     $('#modal-eliminar-entrenador').modal('show');
     let botonConfirmar = document.getElementById("confirmar-eliminar");
     let botonCancelar = document.getElementById("cancelar-eliminar");
     
     botonConfirmar.addEventListener("click", function(){
       $.ajax({
            url: "colaboradores",
            dataType: "json",
            data:{
                accion: "eliminarColaborador",
                idColaborador: id
            },
            succes: function(result){


            }
        });
   
            setTimeout(function() {
                   $("#modal-eliminar").modal("hide");
                   window.location.href = "entrenadores.jsp?idE=" + idEquipo + "&cat=" + idCategoria + "&temp=" + idTemporada ;
                       }, 150);  
     });
     
     botonCancelar.addEventListener("click", function(){
         $('#modal-eliminar-entrenador').modal('hide');
     });
 }
 
 /*Editar Colaborador*/
function obtenerEntrenador(id){
    
    
  let nombreEntrenador = $('#nombreEntrenadorE');
  let apellido1 = $('#apellido1EntrenadorE');
  let apellido2 = $('#apellido2EntrenadorE');
  let numeroDoc = $("#numeroDocumentoE");
  let fechaNacimiento = $("#fechaNacimientoE");
  let tipoDocId = document.getElementById("tipoDocumentoE");
  let botonComfirmarEditarEntrenador = document.getElementById("confirmarEditarEntrenador");
  botonComfirmarEditarEntrenador.setAttribute('data-id', id);
  
  
  $.ajax({
      url: "colaboradores",
      dataType: "json",
      data:{
          accion: "obtenerColaborador",
          idColaborador: id
      },
      success: function(result){
          if(result.rows !== null ){
             
              nombreEntrenador.val(result.rows[0][0]);
              apellido1.val(result.rows[0][1]);
              apellido2.val(result.rows[0][2]);
              tipoDocId.selectedIndex = result.rows[0][3];
              numeroDoc.val(result.rows[0][4]);
            
              let fechaNacimientoSegundos= formatearFecha(result.rows[0][5]);
              
              
              fechaNacimiento.val(fechaNacimientoSegundos);
            
               setTimeout(function() {
                   $("#modal-editar-entrenador").modal('show');
                }, 150);
                
          }
      }
  });
    
}

$('#editarEntrenador').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let idEntrenador = document.getElementById("confirmarEditarEntrenador").getAttribute("data-id");
    let nombreE = $("#nombreEntrenadorE").val();
    let apellido1E = $("#apellido1EntrenadorE").val();
    let apellido2E= $("#apellido2EntrenadorE").val();
    let tipoDocIdE = $("#tipoDocumentoE").val();
    let numeroDocE = $("#numeroDocumentoE").val();
    let fechaNacimientoE = $("#fechaNacimientoE").val();
    
  
    $.ajax({
        url: "colaboradores",
        dataType: "json",
        data:{
            accion: "editarColaborador", nombre: nombreE, apellido1:apellido1E, apellido2:apellido2E,
            idTipoDoc: tipoDocIdE, numDocumento: numeroDocE, fecha_nacimiento: fechaNacimientoE, idColaborador: idEntrenador
        },
        success: function (result) {
             $("#modal-editar-entrenador").modal("hide");
             document.getElementById("confirmarEditarEntrenador").setAttribute('data-id', "");
             window.location.href = "entrenadores.jsp?idE=" + idEquipo + "&cat=" + idCategoria + "&temp=" + idTemporada ;
      
            
        },
         error: function (error) {
          console.error("Error en la solicitud:", error.responseText);
        }
    });
 });
 
 /* Utilidad*/
 function listarTipoDocumento(elemento){    
$.ajax({
        url: "colaboradores",
        dataType: "json",
        data:{
            accion: "listarTipoDocumento"
        },
        success: function (result) {
            if(result.rows !== null)
            {
                for(let i = 0; i < result.rows.length; i++){

                   let nuevaOpcion = document.createElement("option");
                   nuevaOpcion.innerHTML = result.rows[i][1];
                   nuevaOpcion.value = result.rows[i][0];
                   elemento.appendChild(nuevaOpcion);
                }
            }
    
        }
 });
 }
 
 
 function formatearFecha(fechaEnMilisegundos) {
    let fecha = new Date(fechaEnMilisegundos);
    
    let year = fecha.getFullYear();
    let month = (fecha.getMonth() + 1).toString().padStart(2, '0');
    let day = fecha.getDate().toString().padStart(2, '0');

    let fechaFormateada = `${year}-${month}-${day}`;

    return fechaFormateada;
}

