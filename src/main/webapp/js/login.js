$(function() {
    
    $.ajax({
            url: "limaHeatServlet",
            dataType: "json",
            data:{
                accion: "prueba"
            },
            success: function (result) {

                

            }
        });
});