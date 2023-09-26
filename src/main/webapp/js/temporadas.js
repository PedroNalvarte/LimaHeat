    let container = document.getElementById("mainContainer");
    let botonAgregar;
    let listaTemporadas = [];
    let listaTiposTemp = [];
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
            nuevoDiv.innerHTML = "Temporada " + result.rows[i][0] + "<br>" + result.rows[i][1];
            
            container.appendChild(nuevoDiv);
         }
         
         let finalDiv = document.createElement("div");
         finalDiv.classList.add("carta");
         finalDiv.id = "agregarTemporada";
         finalDiv.innerHTML = " Agregar Temporada<br>+";
         
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
      console.log("Botón clickeado");
      $('#modal-creacion').modal('show');
  }

 $("#btnCrear").click(function(){
	
    $("#modal-creacion").modal("hide");
		
});



let listaTipos = document.getElementById("tipoTemporada");
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
                   listaTipos.appendChild(nuevaOpcion);
                }
            }
    
        }
 });
 
 
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
             console.log(result);
             $("#modal-creacion").modal("hide");
             window.location.href = "temporadas.jsp";
            
        },
         error: function (error) {
          console.error("Error en la solicitud:", error.responseText);
        }
    });
 });
 
 
