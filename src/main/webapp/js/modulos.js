$(function() {
    
    let idTipoCuenta = $("#idTipoCuenta").text();
    
    if(idTipoCuenta === "2"){
       
       alert("te vas");
        
        
        
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
