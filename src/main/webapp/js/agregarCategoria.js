$('#insertar').on('submit', function(event) {
    event.preventDefault(); // Evitar que se envíe el formulario
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
        success: function(result) {
            window.location.href = "modulos.jsp";
        }
    });
});

