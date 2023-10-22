// Creacion de tabla
let contenidoCol = document.getElementById('contenidoCol');
let listaColaboradores;

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
        url: "colaboradores",
        dataType: "json",
        data:{
            accion: "listar", equipo: idEquipo, temporada: idTemporada, categoria: idCategoria
        },
        success: function (result) {
            if(result.rows !== null)
            {
                   listaColaboradores = result.rows;
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
                   
                    let botonEliminarColaborador =  document.getElementsByClassName("boton-eliminar");

                    for(let i = 0; i < botonEliminarColaborador.length; i++){
                         botonEliminarColaborador[i].addEventListener("click", function (){
                                   let dataId = this.parentElement.parentElement.getAttribute("data-id");
                                   eliminarColaborador(dataId);
                         }); 
                    }
                    
                     let botonEditarColaborador =  document.getElementsByClassName("boton-editar");

                    for(let i = 0; i < botonEditarColaborador.length; i++){
                         botonEditarColaborador[i].addEventListener("click", function (){
                                   let dataId = this.parentElement.parentElement.getAttribute("data-id");
                                   obtenerColaborador(dataId);
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


/*Busqueda de Colaborador*/
function buscarColaborador(){
    var input, filter, tabla, fila, i, txtValue;
    //Optenemos el input
    input = document.getElementById("busquedaC");
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

/*Registrar Colaborador*/
let botonRegistrarColaborador = document.getElementById("btn-registrar-colaborador");

botonRegistrarColaborador.addEventListener("click", registrarColaborador);
function registrarColaborador(){
   
    $('#modal-creacion-colaborador').modal('show');
}

 $('#registrarColaborador').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let nombreC = $("#nombreColaborador").val();
    let apellido1C = $("#apellido1Colaborador").val();
    let apellido2C = $("#apellido2Colaborador").val();
    let tipoDocIdC = $("#tipoDocumento").val();
    let numeroDocC = $("#numeroDocumento").val();
    let fechaNacimientoC = $("#fechaNacimiento").val();
    
  
    $.ajax({
        url: "colaboradores",
        dataType: "json",
        data:{
            accion: "registrarColaborador", nombre: nombreC, apellido1:apellido1C, apellido2:apellido2C,
            idTipoDoc: tipoDocIdC, numDocumento: numeroDocC, fecha_nacimiento: fechaNacimientoC, idEquipo: idEquipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {
             $("#modal-creacion-colaborador").modal("hide");
             window.location.href = "colaboradores.jsp?idE=" + idEquipo + "&cat=" + idCategoria + "&temp=" + idTemporada ;
      
            
        },
         error: function (error) {
          console.error("Error en la solicitud:", error.responseText);
        }
    });
 });
 
 /*Elilminar Colaborador*/

 
 function eliminarColaborador(id){
     $('#modal-eliminar-colaborador').modal('show');
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
                   window.location.href = "colaboradores.jsp?idE=" + idEquipo + "&cat=" + idCategoria + "&temp=" + idTemporada ;
                       }, 150);  
     });
     
     botonCancelar.addEventListener("click", function(){
         $('#modal-eliminar-colaborador').modal('hide');
     });
 }
 
 /*Editar Colaborador*/
function obtenerColaborador(id){
    
    
  let nombreColaborador = $('#nombreColaboradorE');
  let apellido1 = $('#apellido1ColaboradorE');
  let apellido2 = $('#apellido2ColaboradorE');
  let numeroDoc = $("#numeroDocumentoE");
  let fechaNacimiento = $("#fechaNacimientoE");
  let tipoDocId = document.getElementById("tipoDocumentoE");
  let botonComfirmarEditarColaborador = document.getElementById("confirmarEditarColaborador");
  botonComfirmarEditarColaborador.setAttribute('data-id', id);
  
  
  $.ajax({
      url: "colaboradores",
      dataType: "json",
      data:{
          accion: "obtenerColaborador",
          idColaborador: id
      },
      success: function(result){
          if(result.rows !== null ){
             
              nombreColaborador.val(result.rows[0][0]);
              apellido1.val(result.rows[0][1]);
              apellido2.val(result.rows[0][2]);
              tipoDocId.selectedIndex = result.rows[0][3];
              numeroDoc.val(result.rows[0][4]);
            
              let fechaNacimientoSegundos= formatearFecha(result.rows[0][5]);
              
              
              fechaNacimiento.val(fechaNacimientoSegundos);
            
               setTimeout(function() {
                   $("#modal-editar-colaborador").modal('show');
                }, 150);
                
          }
      }
  });
    
}

$('#editarColaborador').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let idColaborador = document.getElementById("confirmarEditarColaborador").getAttribute("data-id");
    let nombreC = $("#nombreColaboradorE").val();
    let apellido1C = $("#apellido1ColaboradorE").val();
    let apellido2C = $("#apellido2ColaboradorE").val();
    let tipoDocIdC = $("#tipoDocumentoE").val();
    let numeroDocC = $("#numeroDocumentoE").val();
    let fechaNacimientoC = $("#fechaNacimientoE").val();
    
  
    $.ajax({
        url: "colaboradores",
        dataType: "json",
        data:{
            accion: "editarColaborador", nombre: nombreC, apellido1:apellido1C, apellido2:apellido2C,
            idTipoDoc: tipoDocIdC, numDocumento: numeroDocC, fecha_nacimiento: fechaNacimientoC, idColaborador: idColaborador
        },
        success: function (result) {
             $("#modal-editar-colaborador").modal("hide");
             document.getElementById("confirmarEditarColaborador").setAttribute('data-id', "");
             window.location.href = "colaboradores.jsp?idE=" + idEquipo + "&cat=" + idCategoria + "&temp=" + idTemporada ;
      
            
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
 






