$('#btnInsertar').on('submit', function (event) {
    event.preventDefault(); // 
    event.stopImmediatePropagation();

    let NOMBRE_CATEGORIA = $("#NOMBRE_CATEGORIA").val();
    let ABREVIATURA = $("#ABREVIATURA").val();
    let DESC_CATEGORIA = $("#DESC_CATEGORIA").val();
    let ESTADO_REGISTRO = $("input[name='ESTADO_REGISTRO']:checked").val();
    let IMAGEN = $("#IMAGEN").val();

    $.ajax({
        url: "enviar_registro",
        dataType: "json",
        method: "POST",
        data: {
            NOMBRE_CATEGORIA: NOMBRE_CATEGORIA,
            ABREVIATURA: ABREVIATURA,
            DESC_CATEGORIA: DESC_CATEGORIA,
            ESTADO_REGISTRO: ESTADO_REGISTRO,
            IMAGEN: IMAGEN,
            accion: "agregar_categoria"

        },
        success: function (result) {
            window.location.href = "modulos.jsp";
        }
    });
});


const urlParams = new URLSearchParams(window.location.search);
const accion = urlParams.get('accion');


if (accion === 'Editar') {

    $("#titulo").text("Editar Categoría");


    $("#btnInsertar").text("Actualizar");
    

    
            $("input[name='accion']").val("Editar");


    const ID_CATEGORIA = urlParams.get('ID_CATEGORIA');
    $("#ID_CATEGORIA").val(ID_CATEGORIA);

    $.ajax({
        url: 'enviar_registro',
        dataType: 'json',
        method: 'POST',
        data: {
            accion: 'obtener'
        },
        success: function (response) {

            llenarCamposCategoria(response);
        },
        error: function (error) {
            console.error('Error al cargar datos de la categoría:', error);
        }
    });
}



function llenarCamposCategoria(categoria) {

    $("#NOMBRE_CATEGORIA").val(categoria.NOMBRE_CATEGORIA);
    $("#ABREVIATURA").val(categoria.ABREVIATURA);
    $("#DESC_CATEGORIA").val(categoria.DESC_CATEGORIA);


    if (categoria.ESTADO_REGISTRO === "ACTIVO") {
        $("#activo").prop("checked", true);
    } else if (categoria.ESTADO_REGISTRO === "INACTIVO") {
        $("#inactivo").prop("checked", true);
    }

    $("#IMAGEN").val(categoria.IMAGEN);
}
