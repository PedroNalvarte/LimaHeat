$('#inicio-sesion').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let usuario = $("#txtUsername").val();
    let contra = $("#txtPassword").val();
    
    $.ajax({
        url: "limaHeatServlet",
        dataType: "json",
        data:{
            accion: "iniciar-sesion",usuario:usuario, contra:contra
        },
        success: function (result) {
            
            if(result.rows.length === 1){
                
                let contraObtenida = result.rows[0][0];
                
                if(contra === contraObtenida){
                    
                    //Primer inicio de sesion con contraseña asignada
                    if(usuario === contraObtenida){
                        $("#modal-cambio-contraseña").modal("show");
                        $("#btnModalContrasenaAceptar").attr("usuario",usuario);
                     
                    //Inicio de sesion comun con contraseña elejida
                    }else{
                        
                        $.ajax({
                            url: "limaHeatServlet",
                            dataType: "json",
                            data:{
                                accion: "agregarHTTPSesion", usuario:usuario
                            },
                            success: function (result) {
                                
                                window.location.href = "modulos.jsp";

                            }
                        }); 
                    }
                
                }else if(contra != contraObtenida){

                    $("#mensaje").text("La contraseña ingresada no es correcta.");
                    $("#modal-verificacion").modal("show");

                }
                 
            }else{
                    $("#mensaje").text("El usuario ingresado no existe.");
                    $("#modal-verificacion").modal("show");
            }

        }
    }); 

});

$("#btnModalAceptar").click(function(){
	
    $("#modal-verificacion").modal("hide");
		
});

$("#btnModalContrasenaAceptar").click(function(){
    
    let usuario = $("#btnModalContrasenaAceptar").attr("usuario");
    let nuevaContrasena = $("#txtNuevoPassword").val();
    
    $.ajax({
        url: "limaHeatServlet",
        dataType: "json",
        data:{
            accion: "cambiarContrasena", usuario:usuario, nuevaContrasena:nuevaContrasena
        },
        success: function (result) {
            
            $("#modal-cambio-contraseña").modal("hide");
            
            $("#mensaje").text("Contraseña cambiada, por favor inicie sesión.");
            $("#modal-verificacion").modal("show");
            let contra = $("#txtPassword").val("");
            

        }
    }); 		
});