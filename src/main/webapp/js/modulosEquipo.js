$(function() {

	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);

	let idEquipo = urlParams.get('idE');
	let idCategoria = urlParams.get('cat');
        let idTemporada = urlParams.get('temp');
        
        cargarTitulo(idEquipo, idCategoria, idTemporada);
        
});

//"NOMBRE_EQUIPO"	"NOMBRE_TEMPORADA"	"TIPO_TEMPORADA"	nombre    ID_TIPO_EQUIPO      TIPO_EQUIPO
function cargarTitulo(idEquipo, idCategoria, idTemporada){
    
    $.ajax({
        url: "modulosEquipoServlet",
        dataType: "json",
        data:{
            accion: "cargarTitulo", idEquipo:idEquipo, idCategoria:idCategoria, idTemporada:idTemporada
        },
        success: function (result) {
            
            $("#titulo").text("Equipo "+result.rows[0][0]+" en la temporada "+result.rows[0][1]+" "+result.rows[0][2]); 
            $("#entrenador").text("Entrenador: "+result.rows[0][3]);
            
            let tipoEquipo = result.rows[0][5];
            let tipoCuenta = $("#idTipoCuenta").text();
            
            if(tipoEquipo === "CASA"){
                
                if(tipoCuenta === "ADMINISTRADOR"){
                    
                    $("#cardHistorialPartidos").removeAttr("hidden");
                    $("#cardJugadores").removeAttr("hidden");
                    $("#cardGestionarColaborador").removeAttr("hidden");
                    $("#cardCompararPartidos").removeAttr("hidden");
                    $("#cardCompararJugadores").removeAttr("hidden");
                    
                    
                }else{
                    
                    $("#cardHistorialPartidos").removeAttr("hidden");
                    $("#cardCompararPartidos").removeAttr("hidden");
                    $("#cardCompararJugadores").removeAttr("hidden");
                      
                }       
                
            }else{
                
                $("#cardHistorialPartidos").removeAttr("hidden");
                $("#cardJugadores").removeAttr("hidden");
            }
        }
    });
    
    
    
    
}
