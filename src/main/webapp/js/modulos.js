$(function() {
    
    let idTipoCuenta = $("#idTipoCuenta").text();
    
    if(idTipoCuenta === "2"){
       
      window.location.href = "misEquipos.jsp";
        
        
        
    }else if(idTipoCuenta === "3"){
        
        $(".card-categorias").attr("hidden",1);
        $(".card-temporadas").attr("hidden",1);
        $(".card-gestionar").attr("hidden",1);
        $(".card-colaboradores").attr("hidden",1);
        
     
        
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

function colaboradores(){
    window.location.href = "colaboradores.jsp";
}

