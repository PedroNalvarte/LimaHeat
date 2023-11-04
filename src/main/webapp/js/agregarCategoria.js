$('#crearCategoria').on('submit', function (event) {

    event.preventDefault();
    event.stopImmediatePropagation();

    let NOMBRE_CATEGORIA = $("#NOMBRE_CATEGORIA").val();
    let ABREVIATURA = $("#ABREVIATURA").val();
    let DESC_CATEGORIA = $("#DESC_CATEGORIA").val();
    let IMAGEN = $("#IMAGEN").val();


    $.ajax({
        url: "categoria",
        dataType: "json",
        method: "POST",
        data: {
            accion: "registrar-categoria", NOMBRE_CATEGORIA: NOMBRE_CATEGORIA, ABREVIATURA: ABREVIATURA, DESC_CATEGORIA: DESC_CATEGORIA, IMAGEN: IMAGEN
        },
        success: function () {
            $("#modal-creacion").modal("hide");
            window.location.href = "agregarCategoria.jsp";

        },
        error: function (error) {
            console.error("Error en la solicitud:", error.responseText);
        }
    });
});

//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////


function obtenerDatos(ID_CATEGORIA) {

    let NOMBRE_CATEGORIAe = $('#NOMBRE_CATEGORIAe');
    let ABREVIATURAe = $('#ABREVIATURAe');
    let DESC_CATEGORIAe = $('#DESC_CATEGORIAe');


    $.ajax({
        url: "categoria",
        dataType: "json",
        method: "GET",
        data: {
            accion: "obtener-categoria",
            ID_CATEGORIA: ID_CATEGORIA
        },
        success: function (result) {
            if (result.rows !== null) {
                NOMBRE_CATEGORIAe.val(result.rows[0][1]);
                ABREVIATURAe.val(result.rows[0][2]);
                DESC_CATEGORIAe.val(result.rows[0][3]);
                if (result.rows[0][4] === 'A') {
                    $('#activo').prop('checked', true);
                    $('#inactivo').prop('checked', false);
                } else if (result.rows[0][4] === 'I') {
                    $('#activo').prop('checked', false);
                    $('#inactivo').prop('checked', true);
                }
                setTimeout(function () {
                    $('#modal-detalles').modal('show');
                }, 150);
            }
        }
    });
}

///////////////////////////////////////////////////////////////////////////////
//LISTAR
///////////////////////////////////////////////////////////////////////////////

let container = document.getElementById("lista-mis-Equipos");
let botonAgregar;
let botonEditarCategoria;
let listaCategorias = [];
$.ajax({
    url: "categoria",
    dataType: "json",
    method: "GET",
    data: {
        accion: "listar"
    },
    success: function (result) {
        if (result.rows !== null) {
            for (let i = 0; i < result.rows.length; i++) {

                
                let nuevoDiv = document.createElement("div");
                nuevoDiv.classList.add("carta");
                listaCategorias.push("Categoría " + result.rows[i][1] + " " + result.rows[i][2]);
                nuevoDiv.innerHTML = "Categoría " + result.rows[i][1] + "<br>" + result.rows[i][2] + "<br><i class=\"bi bi-pencil boton-editar\"></i>";
                nuevoDiv.style.borderRadius = "10px";
                nuevoDiv.setAttribute('data-id', result.rows[i][0]);

                container.appendChild(nuevoDiv);
            }

            botonEditarCategoria = document.getElementsByClassName("boton-editar");


            for (let k = 0; k < botonEditarCategoria.length; k++) {
                botonEditarCategoria[k].addEventListener("click", function () {
                    let cartaElement = this.parentNode;
                    let dataId = cartaElement.getAttribute('data-id');
                    verDetalles(dataId);
                });
            }

            /*let finalDiv = document.createElement("div");
            finalDiv.classList.add("carta");
            finalDiv.classList.add("agregar");
            finalDiv.id = "agregarCategoria";
            finalDiv.innerHTML = "Agregar Categoría<br><br><i class=\"bi bi-plus-circle\"></i>";
            finalDiv.style.backgroundColor = "#ffcd39";
            finalDiv.style.borderRadius = "10px";

            container.appendChild(finalDiv);*/

            botonAgregar = document.getElementById("agregarCategoria");

            botonAgregar.addEventListener("click", agregar);
        } else {
            console.log("Lista vacía");
        }
    },
    error: function (error) {
        console.error("Error en la solicitud:", error.responseText);
    }
});

function verDetalles(ID_CATEGORIA) {
    categoriaSeleccionada = ID_CATEGORIA;
    obtenerDatos(categoriaSeleccionada);

}
function agregar() {
    $('#modal-creacion').modal('show');
}


let botonConfirmarEditar = document.getElementById("btnEditarCategoria");
botonConfirmarEditar.addEventListener("click", function () {
    event.preventDefault();
    event.stopImmediatePropagation();


    
    let NOMBRE_CATEGORIA = $("#NOMBRE_CATEGORIAe").val();
    let ABREVIATURA = $("#ABREVIATURAe").val();
    let DESC_CATEGORIA = $("#DESC_CATEGORIAe").val();
    let ID_CATEGORIA = categoriaSeleccionada;
    
    $.ajax({
        url: "categoria",
        dataType: "json",
         method: "POST",
        data: {
            accion: "editar-categoria", NOMBRE_CATEGORIA: NOMBRE_CATEGORIA, ABREVIATURA: ABREVIATURA, DESC_CATEGORIA: DESC_CATEGORIA,ID_CATEGORIA: ID_CATEGORIA
            
        },
        success: function (result) {
            $("#modal-creacion").modal("hide");
            window.location.href = "agregarCategoria.jsp";

        },
        error: function (error) {
            console.error("Error en la solicitud:", error.responseText);
        }
    });
});
 