    let container = document.getElementById("mainContainer");
    let botonAgregar;
    let listaTemporadas = [];
    let listaTiposTemp = [];
    let listaTipos = document.getElementById("tipoTemporada");
    let listaTiposE = document.getElementById("tipoTemporadaE");
    listarTipos(listaTipos);
    listarTipos(listaTiposE);
    
    
    let botonEditarTemporada;
    let botonEliminarTemporada;
   
    
    
    $.ajax({
        url: "temporadasServlet",
        dataType: "json",
        data:{
            accion: "listar"
        },
        success: function (result) {
            
         if(result.rows !== null)
         {
         for(let i = 0; i < result.rows.length; i++){
            
            let nuevoDiv = document.createElement("div");
            nuevoDiv.classList.add("carta");
            listaTemporadas.push("Temporada " + result.rows[i][0] + " " + result.rows[i][1]);
            nuevoDiv.innerHTML = "Temporada " + result.rows[i][0] + "<br>" + result.rows[i][1] + "<br><i class=\"bi bi-pencil boton-editar\"></i> <i class=\"bi bi-x-circle boton-eliminar\" id=\"boton-eliminar\"></i>";
            nuevoDiv.style.borderRadius = "10px";
            nuevoDiv.setAttribute('data-id', result.rows[i][2]);
            
            container.appendChild(nuevoDiv);
         
        }
         botonEliminarTemporada = document.getElementsByClassName("boton-eliminar");
         botonEditarTemporada = document.getElementsByClassName("boton-editar");
                
         for(let i = 0; i < botonEliminarTemporada.length; i++){
            
            botonEliminarTemporada[i].addEventListener("click", function (){
                let cartaElement = this.parentNode;
                let dataId = cartaElement.getAttribute('data-id');
                eliminarTemporada(dataId);
            }); 
           

         }
         
         for(let k = 0; k < botonEditarTemporada.length; k++){ 
             botonEditarTemporada[k].addEventListener("click", function(){
             let cartaElement = this.parentNode;
             let dataId = cartaElement.getAttribute('data-id');
             verDetalles(dataId);
             
             });
             
        }
         
         let finalDiv = document.createElement("div");
         finalDiv.classList.add("carta");
         finalDiv.classList.add("agregar");
         finalDiv.id = "agregarTemporada";
         finalDiv.innerHTML = "Agregar Temporada<br><br><i class=\"bi bi-plus-circle\"></i>";
         finalDiv.style.backgroundColor = "#bbbcbd";
         finalDiv.style.borderRadius = "10px";
      
         container.appendChild(finalDiv);
         
         
          botonAgregar = document.getElementById("agregarTemporada");
          
          
          botonAgregar.addEventListener("click", agregar);
          
        }
        else{
            console.log("Lista vacia");
        }
        },
        error: function (error) {
          console.error("Error en la solicitud:", error.responseText);
        }
    }); 
    
  function agregar(){   
      $('#modal-creacion').modal('show');
  }
  
 





function listarTipos(elemento){    
$.ajax({
        url: "temporadasServlet",
        dataType: "json",
        data:{
            accion: "listarTipos"
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
 
 
 $('#crearTemporada').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let nombreTemporada = $("#nombreTemporada").val();
    let fechaInicio = $("#fechaInicio").val();
    let fechaFin = $("#fechaFin").val();
    let tipoTemporada = $("#tipoTemporada").val();
    
    $.ajax({
        url: "temporadasServlet",
        dataType: "json",
        data:{
            accion: "registrar-temporada", nombreTemporada: nombreTemporada, tipoTemporada:tipoTemporada, fechaInicio:fechaInicio,
            fechaFin: fechaFin
        },
        success: function (result) {
             $("#modal-creacion").modal("hide");
             window.location.href = "temporadas.jsp";
            
        },
         error: function (error) {
          console.error("Error en la solicitud:", error.responseText);
        }
    });
 });
 

 function verDetalles(id){      
      temporadaSeleccionada = id;
      
      obtenerDatos(temporadaSeleccionada);
      
  }
  
 
 
 function obtenerDatos(id){
  let nombreTemporadaE = $('#nombreTemporadaE');
  let fechaInicioE = $('#fechaInicioE');
  let fechaFinE = $('#fechaFinE');
  let tipoE = document.getElementById("tipoTemporadaE");
  
  $.ajax({
      url: "temporadasServlet",
      dataType: "json",
      data:{
          accion: "obtener-temporada",
          idTemporada: id
      },
      success: function(result){
          if(result.rows !== null ){

              nombreTemporadaE.val(result.rows[0][2]);
              let fechaInicio = formatearFecha(result.rows[0][3]);
              let fechaFin = formatearFecha(result.rows[0][4]);
              
              fechaInicioE.val(fechaInicio);
              fechaFinE.val(fechaFin);
              tipoE.selectedIndex = result.rows[0][1];
               setTimeout(function() {
                    $('#modal-detalles').modal('show');
                }, 150);
          }
      }
  });
 }
 

 function formatearFecha(fechaEnMilisegundos) {
    let fecha = new Date(fechaEnMilisegundos);
    
    let year = fecha.getFullYear();
    let month = (fecha.getMonth() + 1).toString().padStart(2, '0'); // Sumar 1 al mes ya que en JavaScript los meses van de 0 a 11
    let day = fecha.getDate().toString().padStart(2, '0');

    let fechaFormateada = `${year}-${month}-${day}`;

    return fechaFormateada;
}

   
function eliminarTemporada (id) {
   
   $('#modal-eliminar').modal('show');
   
   let botonConfirmar = document.getElementById("confirmar-eliminar");
   let botonCancelar = document.getElementById("cancelar-eliminar");
   
   
   
   botonConfirmar.addEventListener("click", function(){
       $.ajax({
      url: "temporadasServlet",
      dataType: "json",
      data:{
          accion: "eliminar-temporada",
          idTemporada: id
      },
      succes: function(result){
        
        
      }
   });
   
     setTimeout(function() {
            $("#modal-eliminar").modal("hide");
            window.location.href = "temporadas.jsp";
                }, 150);  
   });
   
   botonCancelar.addEventListener("click", function(){
      $("#modal-eliminar").modal("hide"); 
   });
};



let botonConfirmarEditar = document.getElementById("btnEditarTemporada");
botonConfirmarEditar.addEventListener("click", function(){
    event.preventDefault();
    event.stopImmediatePropagation();
    
    
    let id = temporadaSeleccionada;
    let nombreTemporada = $("#nombreTemporadaE").val();
    let fechaInicio = $("#fechaInicioE").val();
    let fechaFin = $("#fechaFinE").val();
    let tipoTemporada = $("#tipoTemporadaE").val();
    
    $.ajax({
        url: "temporadasServlet",
        dataType: "json",
        data:{
            accion: "editar-temporada", nombreTemporada: nombreTemporada, tipoTemporada:tipoTemporada, fechaInicio:fechaInicio,
            fechaFin: fechaFin, idTemporada: id
        },
        success: function (result) {
             $("#modal-creacion").modal("hide");
             window.location.href = "temporadas.jsp";
            
        },
         error: function (error) {
          console.error("Error en la solicitud:", error.responseText);
        }
    }); 
});







 
  
 
