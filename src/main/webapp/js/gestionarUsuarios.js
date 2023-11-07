$(function () {

    listarUsuarios();

});

function listarUsuarios(){
    
    //"ID_PARTICIPANTE"	concat	"USUARIO"	"CONTRASENA"	"FECHA_REGISTRO"
    $.ajax({
        url: "gestionarUsuariosServlet",
        dataType: "json",
        data: {
            accion: "listarUsuarios"
        },
        success: function (result) {

            let cantidad = result.rows.length;
            

            $("#tblJugadores").html("");

            if (cantidad > 0) {

                for (let i = 0; i < cantidad; i++) {
                    
                    let date = new Date(result.rows[i][4]);

                    var html = ``;
                    html += `<tr>`;
                    html += `<td>${i + 1}</td>`;
                    html += `<td>${date.getDate()}/${date.getMonth()+1}/${date.getFullYear()}</td>`;
                    html += `<td>${result.rows[i][1]}</td>`;
                    html += `<td>${result.rows[i][2]}</td>`;
                    html += `<td><button id="${result.rows[i][0]}" onClick="btnreiniciarCredenciales(this.id)">Reiniciar</button></td>`;
                    html += `<td><button id="${result.rows[i][0]}" onClick="btneliminarCuenta(this.id)">Eliminar</button></td>`;
                    html += `</tr>`;

                    $("#tblJugadores").append(html);
                }
            }

        }
    });
}

function btnreiniciarCredenciales(idParticipante){
    
    $('#modal-reiniciar').attr('idParticipante',idParticipante);
    $('#modal-reiniciar').modal('show');
}

function btneliminarCuenta(idParticipante){
    
    $('#modal-eliminar').attr('idParticipante',idParticipante);
    $('#modal-eliminar').modal('show');
}

function reiniciarCredenciales(){
    
    let idParticipante = $('#modal-reiniciar').attr('idParticipante');
    
    alert(idParticipante);
    
    $.ajax({
        url: "gestionarUsuariosServlet",
        dataType: "json",
        data: {
            accion: "reiniciarCredenciales", idParticipante:idParticipante
        },
        success: function (result) {
            
            $("#modal-reiniciar").modal("hide");
            listarUsuarios();

        }
    });
 
}

function eliminarCuenta(){
    
    let idParticipante = $('#modal-eliminar').attr('idParticipante');
    
    $.ajax({
        url: "gestionarUsuariosServlet",
        dataType: "json",
        data: {
            accion: "eliminarCuenta", idParticipante:idParticipante
        },
        success: function (result) {

          $("#modal-eliminar").modal("hide");
          listarUsuarios();

        }
    });
    
}

//Funciones de modales
$("#btnModalReiniciarAceptar").click(function(){
	
    reiniciarCredenciales();
		
});

$("#btnModalReiniciarCancelar").click(function(){
	
    $("#modal-reiniciar").modal("hide");
		
});

$("#btnModalEliminarAceptar").click(function(){
	
    eliminarCuenta();
		
});

$("#btnModalEliminarCancelar").click(function(){
	
    $("#modal-eliminar").modal("hide");
		
});