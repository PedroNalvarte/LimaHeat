$(function() {
    
    let idTipoCuenta = $("#idTipoCuenta").text();
    
    if(idTipoCuenta === "2"){
       
      window.location.href = "misEquipos.jsp";
        
        
        
    }else if(idTipoCuenta === "3"){
        
        $("#moduloCategoria").attr("hidden",1);
        $("#moduloTemporadas").attr("hidden",1);
        
    }
    
    
});






function categorias() {
    window.location.href = "agregarCategoria.jsp";
}
function equiposRivales() {
    window.location.href = "equiposRivales.jsp";
}

function misEquipos() {
    window.location.href = "misEquipos.jsp";
}
function temporadas() {
    window.location.href = "temporadas.jsp";
}

function gestionarUsuarios(){
    window.location.href = "gestionarUsuarios.jsp";
}

