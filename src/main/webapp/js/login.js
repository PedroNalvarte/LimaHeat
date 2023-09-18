$('#inicio-sesion').on('submit', function(event){
    
    event.preventDefault();
    event.stopImmediatePropagation();
    
    let usuario = $("#txtUsername").val();
    let contra = $("#txtPassword").val();
    
    $.ajax({
        url: "limaHeatServlet",
        dataType: "json",
        data:{
            accion: "iniciar-sesion",usuario:usuario
        },
        success: function (result) {
            
            
            if(result.rows.length === 1){
                
                let contraObtenida = result.rows[0][0];
                
                if(contra === contraObtenida){
                
                    if(usuario = contraObtenida){
                        $("#modal-cambio-contraseña").modal("show");
                        $("#btnModalContrasenaAceptar").attr("usuario",usuario);
                        
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
            
            alert(result);
            alert(result.rows[0][0]);
            
            
            
   
        }
    }); 		
});