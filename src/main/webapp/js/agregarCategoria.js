$('#insertar').on('submit', function(event) {
    event.preventDefault(); // Evitar que se envíe el formulario
    event.stopImmediatePropagation();

    let NOMBRE_CATEGORIA = $("#NOMBRE_CATEGORIA").val();
    let ABREVIATURA = $("#ABREVIATURA").val();
    let DESC_CATEGORIA = $("#DESC_CATEGORIA").val();
    let ESTADO_REGISTRO = $("input[name='ESTADO_REGISTRO']:checked").val();
    let IMAGEN = $("#IMAGEN").val();

    $.ajax({
        url: "enviar_registro", // Reemplaza con la URL correcta de tu servlet
        dataType: "json",
        method: "POST", // Método HTTP POST para enviar los datos
        data: {
            NOMBRE_CATEGORIA: NOMBRE_CATEGORIA,
            ABREVIATURA: ABREVIATURA,
            DESC_CATEGORIA: DESC_CATEGORIA,
            ESTADO_REGISTRO: ESTADO_REGISTRO,
            IMAGEN: IMAGEN
            accion: "agregar_categoria" // Puedes cambiar esto según tu lógica en el servlet
        },
        success: function(result) {
            $("#btnInsertar").text("Cargando...");
            
            // Realiza la redirección después de agregar la categoría
            window.location.href = "modulos.jsp";
        }
    });
});

