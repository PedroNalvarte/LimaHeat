let idEquipo;
let idCategoria;
let idTemporada;

$(function () {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);

    idEquipo = urlParams.get('idE');
    idCategoria = urlParams.get('cat');
    idTemporada = urlParams.get('temp');

    cargarTitulo(idEquipo, idCategoria, idTemporada);
    cargarRendimientoGeneral(idEquipo, idCategoria, idTemporada);
    cargarlista();


});

function registrarNuevo() {
   location.href = 'registrarPartido.jsp?idE=' + idEquipo + "&cat=" + idCategoria + "&temp=" + idTemporada;

}

/*
$('#registrarPartido').on('submit', function (event) {

    event.preventDefault();
    event.stopImmediatePropagation();

    let resultado = $("#resultado").val();
    let detalleResultado = $("#detalleResultado").val();
    let lugar = $("#lugar").val();

    if (resultado === "Pendiente") {
        resultado = "P";
    } else if (resultado === "Ganada") {
        resultado = "G";
    } else if (resultado === "Perdido") {
        resultado = "L";
    } else if (resultado === "Empate") {
        resultado = "E";
    }
    $.ajax({
        url: "registrarPartido",
        dataType: "json",
        data: {
            accion: "registrarPartido", RESULTADO: resultado, DETALLE_RESULTADO: detalleResultado, LUGAR: lugar, idEquipo: idEquipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {

            $("#modal-registrar").modal("hide");
            cargarlista();

        }
    });

});
*/
function cargarlista() {
    $.ajax({
        url: "registrarPartido", // Asegúrate de que la URL sea correcta
        dataType: "json",
        data: {
            accion: "listarPartido",
            idEquipo: idEquipo,
            idCategoria: idCategoria,
            idTemporada: idTemporada
        },
        success: function (result) {
            console.log(result);
            let partido = result.rows; // Asume que la respuesta contiene una matriz de partidos

            $("#tblPartidos").html(""); // Limpia la tabla antes de agregar nuevos datos

            if (partido.length > 0) {
                for (let i = 0; i < partido.length; i++) {
                    var fechaEnBaseDeDatos = partido[i][6];
                    var fechaFormateada = new Date(fechaEnBaseDeDatos);
                    var opcionesDeFormato = {
                        year: 'numeric',
                        month: '2-digit',
                        day: '2-digit',
                        hour: '2-digit',
                        minute: '2-digit',
                        hour12: true
                    };
                    var fechaFormateada = fechaFormateada.toLocaleString(undefined, opcionesDeFormato);
                    //ACA SE PODRA VER MEJOR EL RESULTADO

                    let resultado = partido[i][1];
                    if (resultado === 'P') {
                        resultado = 'Perdido';
                    } else if (resultado === 'G') {
                        resultado = 'Ganado';
                    } 
                     else if (resultado === 'E') {
                        resultado = 'Empate';
                    }
                    
                    if(result.rows[i][5] === 'RIVAL'){
                    let contador = 1;
                        var html = ``;
                    html += `<tr>`;
                    
                    html += `<td>${contador}</td>`;
                    html += `<td id="txtrival${partido[i][0]}">${partido[i][4]}</td>`;
                    html += `<td id="txtresultado${partido[i][0]}">${resultado}</td>`;
                    html += `<td id="txtdetalle${partido[i][0]}">${partido[i][2]}</td>`;
                    html += `<td id="txtlugar${partido[i][0]}">${partido[i][3]}</td>`;
                     html += `<td id="txtfecha${partido[i][0]}">${fechaFormateada}</td>`;
                    html += `<td>
                                    <a class="btn-editar" data-partido-id="(${partido[i][0]})"><i class="bi bi-pencil"></i></a>

                                    
                                    <a class="btn-eliminar" data-partido-id="${partido[i][0]}"><i class="bi bi-trash"></i></a>
                    
                                    <a class="btn-Visualizar" data-partido-id="${partido[i][0]}" href="detallePartido.jsp?id=${partido[i][0]}"><i class="bi bi-plus-circle"></i></a>
                    </td>`;

                    html += `</tr>`;

                        
                    $("#tblPartidos").append(html);
                    contador++;
                    // Agregar un manejador de eventos para los botones de eliminar
                    $("#tblPartidos").on("click", ".btn-eliminar", function () {
                        let ID_PARTIDO = $(this).data("partido-id");
                        eliminarPartido(ID_PARTIDO);
                    });

                    $("#tblPartidos").on("click", ".btn-editar", function () {
                        let ID_PARTIDO = $(this).data("partido-id");
                        editarPartido(ID_PARTIDO);
                    });
                    }
                }
            }
        }

    });
}


function cargarTitulo(idEquipo, idCategoria, idTemporada) {

    $.ajax({
        url: "modulosEquipoServlet",
        dataType: "json",
        data: {
            accion: "cargarTitulo", idEquipo: idEquipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {

            $("#titulo").text("Historial de Partidos de " + result.rows[0][0]);
            $("#temporada").text("Temporada: " + result.rows[0][1] + " " + result.rows[0][2]);

        }
    });
}

function eliminarPartido(id_Partido) {
    $('#modal-eliminar-Partido').modal('show');
    let botonConfirmar = document.getElementById("confirmar-eliminar");
    let botonCancelar = document.getElementById("cancelar-eliminar");

    botonConfirmar.addEventListener("click", function () {
        $.ajax({
            url: "registrarPartido",
            dataType: "json",
            data: {
                accion: "eliminarPartido",
                ID_PARTIDO: id_Partido
            },
            success: function (result) {

                cargarlista();
            }
        });

        setTimeout(function () {
            $("#modal-eliminar-Partido").modal("hide");
            window.location.href = "historialPartidos.jsp?idE=" + idEquipo + "&cat=" + idCategoria + "&temp=" + idTemporada;
        }, 150);
    });

    botonCancelar.addEventListener("click", function () {
        $('#modal-eliminar-Partido').modal('hide');
    });
}

$("#tblPartidos").on("click", ".btn-editar", function () {
    // Obtener el ID_PARTIDO del botón clicado
    let ID_PARTIDO = $(this).data("partido-id");

    // Realiza una solicitud para obtener los datos del partido seleccionado
    $.ajax({
        url: "registrarPartido",
        dataType: "json",
        method: "GET",
        data: {
            accion: "obtenerPartido",
            ID_PARTIDO: ID_PARTIDO
        },
        success: function (result) {
            if (result.rows !== null) {
                // Rellena el formulario de edición con los datos del partido
                $("#resultadoE").val(result.rows[0][1]);
                $("#detalleResultadoE").val(result.rows[0][2]);
                $("#lugarE").val(result.rows[0][3]);
                $("#ID_PARTIDOE").val(ID_PARTIDO);

                // Abre el modal de edición
                $("#modal-editar").modal("show");
            }
        }
    });
});


$(document).on("click", "#btnEditarPartido", function () {
    // Obtener los datos del formulario de edición
    let ID_PARTIDOE = $("#ID_PARTIDOE").val();
    let resultadoE = $("#resultadoE").val();
    let detalleResultadoE = $("#detalleResultadoE").val();
    let lugarE = $("#lugarE").val();

    // Realizar una solicitud AJAX para editar el partido
    $.ajax({
        url: "registrarPartido",
        dataType: "json",
        method: "POST",
        data: {
            accion: "editarPartido",
            ID_PARTIDO: ID_PARTIDOE,
            RESULTADO: resultadoE,
            DETALLE_RESULTADO: detalleResultadoE,
            LUGAR: lugarE
        },
        success: function () {
            // Cerrar el modal de edición
            $("#modal-editar").modal("hide");
        }
    });
});


//////////////////////////////////////////
//"TC_TOTALES"	"TC_ACERTADOS"	"TC_2P_TOTALES"	"TC_2P_ACERTADOS"	"TC_3P_TOTALES"	"TC_3P_ACERTADOS"	"REB_RO"	"REB_RD"	"AS"	"TO"	"RB"	"TP"	"FP_C"	"FP_D"	"DIFERENCIA_PUNTOS"	"PTS"	"TL_ACERTADOS"	"TL_TOTALES"
function cargarRendimientoGeneral(idEquipo, idCategoria, idTemporada){
    
    $.ajax({
        url: "historialPartidosServlet",
        dataType: "json",
        data: {
            accion: "cargarRendimientoGeneral", idEquipo: idEquipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {
            
            let tiro = ((result.rows[0][1] / result.rows[0][0]) * 100).toFixed(2);
            let tiro2 = ((result.rows[0][3] / result.rows[0][2]) * 100).toFixed(2);
            let tiro3 = ((result.rows[0][5] / result.rows[0][4]) * 100).toFixed(2);
            let tiroLibre = ((result.rows[0][17] / result.rows[0][16]) * 100).toFixed(2);
            
            if (isNaN(tiro)) {
            tiro = 0;
            }
            if (isNaN(tiro2)) {
            tiro2 = 0;
            }
            if (isNaN(tiro3)) {
            tiro3 = 0;
            }
            if (isNaN(tiroLibre)) {
            tiroLibre = 0;
            }
            
            $("#tbRendimiendoGeneral").html("");
            
            $("#tbRendimiendoGeneral")
                            .append(
                                    `<tr>` + `<td class="porcentaje">`
                                    + tiro
                                    + `</td>`

                                    + `<td class="porcentaje">`
                                    + tiro2
                                    + `</td>`
                            
                                    + `<td class="porcentaje">`
                                    + tiro3
                                    + `</td>`
                            
                                    + `<td class="porcentaje">`
                                    + tiroLibre
                                    + `</td>`
                            
                                    + `<td>`
                                    + (result.rows[0][6] + result.rows[0][7])
                                    + `</td>`
                            
                                    + `<td>`
                                    + result.rows[0][8]
                                    + `</td>`
                            
                                    + `<td>`
                                    + result.rows[0][9]
                                    + `</td>`
                            
                                    + `<td>`
                                    + result.rows[0][10]
                                    + `</td>`
                            
                                    + `<td>`
                                    + result.rows[0][11]
                                    + `</td>`
                            
                                    + `<td>`
                                    + result.rows[0][12]
                                    + `</td>`
                            
                                    + `<td>`
                                    + result.rows[0][13]
                                    + `</td>`
                            
                                    + `<td>`
                                    + result.rows[0][14]
                                    + `</td>`
                            
                                    + `<td>`
                                    + result.rows[0][15]
                                    + `</td>`
                                   
                                    
                                    + `</tr>`);

                }
           
    });
    
    
}


