let idEquipoLoc;
let idCategoriaLoc;
let idTemporadaLoc;

let qJugadoresLoc;
let qJugadoresRiv;

$(function () {

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);

    idEquipoLoc = urlParams.get('idE');
    idCategoriaLoc = urlParams.get('cat');
    idTemporadaLoc = urlParams.get('temp');

    cargarDDLEquiposRivales(idEquipoLoc, idCategoriaLoc, idTemporadaLoc);
    listarJugadores(idEquipoLoc, idCategoriaLoc, idTemporadaLoc,"tbEquipoLocal","Loc");


});

function listarJugadores(idEquipo, idCategoria, idTemporada, tablaInsertar, tipo) {

    //"ID_PARTICIPANTE"	"NUMERO_DORSAL"	nombre
    $.ajax({
        url: "registrarEstadisticasPartidoServlet",
        dataType: "json",
        data: {
            accion: "listarJugadoresLocales", idEquipo: idEquipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {
            
            let cantidad = result.rows.length;
            
            if(tipo === "Loc"){
                
                qJugadoresLoc = cantidad;
                
            }else if(tipo === "Riv"){
                
                qJugadoresRiv = cantidad;
                
            }

            $("#"+tablaInsertar).html("");

            if (cantidad >= 1) {

                for (let i = 0; i < cantidad; i++) {
                    //ptmmmmmmmmmmmmm
                    $("#"+tablaInsertar)
                            .append(
                                    `<tr>` + `<td id="idI${tipo}${i}" idParticipante="${result.rows[i][0]}">`
                                    + (i + 1)
                                    + `</td>`

                                    + `<td>`
                                    + result.rows[i][2]
                                    + `</td>`
                            
                                    + `<td>`
                                    + result.rows[i][1]
                                    + `</td>`
                            
                                    + `<td>`
                                    + `<input id="txt${tipo}Min${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}Sec${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}TCA${i}" required>`
                                    + `</td>`
                                    + `<td>`
                                    + `<input id="txt${tipo}TCR${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}2PTCA${i}" required>`
                                    + `</td>`
                                    + `<td>`
                                    + `<input id="txt${tipo}2PTCR${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}3PTCA${i}" required>`
                                    + `</td>`
                                    + `<td>`
                                    + `<input id="txt${tipo}3PTCR${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}TLA${i}" required>`
                                    + `</td>`
                                    + `<td>`
                                    + `<input id="txt${tipo}TLR${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}REBRO${i}" required>`
                                    + `</td>`
                                    + `<td>`
                                    + `<input id="txt${tipo}REBRD${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}AS${i}" required>`
                                    + `</td>`
                                    + `<td>`
                                    + `<input id="txt${tipo}TO${i}" required>`
                                    + `</td>`
                                    + `<td>`
                                    + `<input id="txt${tipo}RB${i}" required>`
                                    + `</td>`
                                    + `<td>`
                                    + `<input id="txt${tipo}TP${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}FPC${i}" required>`
                                    + `</td>`
                                    + `<td>`
                                    + `<input id="txt${tipo}FPD${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}MasMenos${i}" required>`
                                    + `</td>`
                                    
                                    + `<td>`
                                    + `<input id="txt${tipo}PTS${i}" required>`
                                    + `</td>`
                                    
                                    + `</tr>`);

                }

            }
        }
    });
}

//Carga de DDls
function cargarDDLEquiposRivales(idEquipo, idCategoria, idTemporada) {

    //"ID_EQUIPO"	"ID_CATEGORIA"	"ID_TEMPORADA"	"NOMBRE_EQUIPO"
    $.ajax({
        url: "registrarEstadisticasPartidoServlet",
        dataType: "json",
        data: {
            accion: "listarEquiposRivales", idEquipo: idEquipo, idCategoria: idCategoria, idTemporada: idTemporada
        },
        success: function (result) {

            let cantidad = result.rows.length;

            $("#ddlEquipoRival").html("");
            $("#ddlEquipoRival").append("<option id='ddlTipDocIde0' value=''>Seleccione Equipo Rival</option>");
            for (let i = 0; i < cantidad; i++) {

                $("#ddlEquipoRival").append("<option idEquipo=" + result.rows[i][0] + " idCategoria=" + result.rows[i][1] + " idTemporada=" + result.rows[i][2] + " >" + result.rows[i][3] + "</option>");
            }
        }
    });
}

function equipoRivalSelect(){
    
    let idEquipo = $("#ddlEquipoRival option:selected").attr("idEquipo");
    let idCategoria = $("#ddlEquipoRival option:selected").attr("idCategoria");
    let idTemporada = $("#ddlEquipoRival option:selected").attr("idTemporada");
    
    listarJugadores(idEquipo, idCategoria, idTemporada,"tbEquipoRival","Riv");
       
}

$('#form-estadisticas').on('submit', function (event) {

    event.preventDefault();
    event.stopImmediatePropagation();
    
    //Datos partido
    let lugar = $("#txtLugar").val();
    let detalleResultado = $("#txtDetalleResultado").val();
    let resultado = $("#ddlResultado option:selected").val();
    
    //Datos equipo local a nivelglobal
    
    //Datos EquipoRival
    let idEquipoRiv = $("#ddlEquipoRival option:selected").attr("idEquipo");
    let idCategoriaRiv = $("#ddlEquipoRival option:selected").attr("idCategoria");
    let idTemporadaRiv = $("#ddlEquipoRival option:selected").attr("idTemporada");
    
    //Estadisticas equipo local
    let idJugadoresLoc = "";
    let MINloc = "";
    let SECloc = "";
    let TCAloc = "";
    let TCRloc = "";
    let dosTPCAloc = "";
    let dosTPCRloc = "";
    let tresPTCAloc = "";
    let tresPTCRloc = "";
    let TLAloc = "";
    let TLRloc = "";
    let REBROloc = "";
    let REBRDloc = "";
    let ASloc = "";
    let TOloc = "";
    let RBloc = "";
    let TPloc = "";
    let FPCloc = "";
    let FPDloc = "";
    let masmenosloc = "";
    let PTSloc = "";
    
    for(let i=0;i < qJugadoresLoc;i++){
        
        idJugadoresLoc = idJugadoresLoc + $("#idILoc"+i).attr("idParticipante") + ";";
        MINloc = MINloc + $("#txtLocMin"+i).val() + ";";
        SECloc = SECloc + $("#txtLocSec"+i).val() + ";";
        TCAloc = TCAloc + $("#txtLocTCA"+i).val() + ";";
        TCRloc = TCRloc + $("#txtLocTCR"+i).val() + ";";
        dosTPCAloc = dosTPCAloc + $("#txtLoc2PTCA"+i).val() + ";";
        dosTPCRloc = dosTPCRloc + $("#txtLoc2PTCR"+i).val() + ";";
        tresPTCAloc = tresPTCAloc + $("#txtLoc3PTCA"+i).val() + ";";
        tresPTCRloc = tresPTCRloc + $("#txtLoc3PTCR"+i).val() + ";";
        TLAloc = TLAloc + $("#txtLocTLA"+i).val() + ";";
        TLRloc = TLRloc + $("#txtLocTLR"+i).val() + ";";
        REBROloc = REBROloc + $("#txtLocREBRO"+i).val() + ";";
        REBRDloc = REBRDloc + $("#txtLocREBRD"+i).val() + ";";
        ASloc = ASloc + $("#txtLocAS"+i).val() + ";";
        TOloc = TOloc + $("#txtLocTO"+i).val() + ";";
        RBloc = RBloc + $("#txtLocRB"+i).val() + ";";
        TPloc = TPloc + $("#txtLocTP"+i).val() + ";";
        FPCloc = FPCloc + $("#txtLocFPC"+i).val() + ";";
        FPDloc = FPDloc + $("#txtLocFPD"+i).val() + ";";
        masmenosloc = masmenosloc + $("#txtLocMasMenos"+i).val() + ";";
        PTSloc = PTSloc + $("#txtLocPTS"+i).val() + ";";
        
    }
    
    //Estadisticas equipo rival
    let idJugadoresRiv = "";
    let MINriv = "";
    let SECriv = "";
    let TCAriv = "";
    let TCRriv = "";
    let dosTPCAriv = "";
    let dosTPCRriv = "";
    let tresPTCAriv = "";
    let tresPTCRriv = "";
    let TLAriv = "";
    let TLRriv = "";
    let REBROriv = "";
    let REBRDriv = "";
    let ASriv = "";
    let TOriv = "";
    let RBriv = "";
    let TPriv = "";
    let FPCriv = "";
    let FPDriv = "";
    let masmenosriv = "";
    let PTSriv = "";
    
    for(let i=0;i < qJugadoresRiv;i++){
        
        idJugadoresRiv = idJugadoresRiv + $("#idIRiv"+i).attr("idParticipante") + ";";
        MINriv = MINriv + $("#txtRivMin"+i).val() + ";";
        SECriv = SECriv + $("#txtRivSec"+i).val() + ";";
        TCAriv = TCAriv + $("#txtRivTCA"+i).val() + ";";
        TCRriv = TCRriv + $("#txtRivTCR"+i).val() + ";";
        dosTPCAriv = dosTPCAriv + $("#txtRiv2PTCA"+i).val() + ";";
        dosTPCRriv = dosTPCRriv + $("#txtRiv2PTCR"+i).val() + ";";
        tresPTCAriv = tresPTCAriv + $("#txtRiv3PTCA"+i).val() + ";";
        tresPTCRriv = tresPTCRriv + $("#txtRiv3PTCR"+i).val() + ";";
        TLAriv = TLAriv + $("#txtRivTLA"+i).val() + ";";
        TLRriv = TLRriv + $("#txtRivTLR"+i).val() + ";";
        REBROriv = REBROriv + $("#txtRivREBRO"+i).val() + ";";
        REBRDriv = REBRDriv + $("#txtRivREBRD"+i).val() + ";";
        ASriv = ASriv + $("#txtRivAS"+i).val() + ";";
        TOriv = TOriv + $("#txtRivTO"+i).val() + ";";
        RBriv = RBriv + $("#txtRivRB"+i).val() + ";";
        TPriv = TPriv + $("#txtRivTP"+i).val() + ";";
        FPCriv = FPCriv + $("#txtRivFPC"+i).val() + ";";
        FPDriv = FPDriv + $("#txtRivFPD"+i).val() + ";";
        masmenosriv = masmenosriv + $("#txtRivMasMenos"+i).val() + ";";
        PTSriv = PTSriv + $("#txtRivPTS"+i).val() + ";";
    }
    
    alert("Datos local"+idEquipoLoc+" / "+idCategoriaLoc+" / "+idTemporadaLoc+" datos rival "+idEquipoRiv+" / "+idCategoriaRiv+" / "+
            idTemporadaRiv+" datos partido "+lugar+" / "+detalleResultado+" / "+resultado+" estadistica local "+" "+idJugadoresLoc +" "+MINloc+" / "+SECloc+" / "+TCAloc+" / "+
            TCRloc+" / "+dosTPCAloc+" / "+dosTPCRloc+" / "+tresPTCAloc+" / "+tresPTCRloc+" / "+TLAloc+" / "+TLRloc+" / "+REBROloc+" / "+
            REBRDloc+" / "+ASloc+" / "+TOloc+" / "+RBloc+" / "+TPloc+" / "+FPCloc+" / "+FPDloc+" / "+masmenosloc+" / "+PTSloc+" estadisticas rival "+
            " "+idJugadoresRiv +" "+MINriv+" / "+SECriv+" / "+TCAriv+" / "+TCRriv+" / "+dosTPCAriv+" / "+dosTPCRriv+" / "+tresPTCAriv+" / "+tresPTCRriv+" / "+TLAriv+" / "+TLRriv+" / "+
            REBROriv+" / "+REBRDriv+" / "+ASriv+" / "+TOriv+" / "+RBriv+" / "+TPriv+" / "+FPCriv+" / "+FPDriv+" / "+masmenosriv+" / "+PTSriv);
    
    //todos las datos al servel luego al procedure para registrar
    

});

