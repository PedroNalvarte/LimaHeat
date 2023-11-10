/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IRegistrarEstadisticasPartido;

public class impRegistrarEstadisticasPartido implements IRegistrarEstadisticasPartido {

    @Override
    public List<Object[]> listarEquiposRivales(String idEquipo, String idTemporada, String idCategoria) {
        String sql = new StringBuilder()
                .append("SELECT DISTINCT ej.\"ID_EQUIPO\", ej.\"ID_CATEGORIA\", ej.\"ID_TEMPORADA\" ,e.\"NOMBRE_EQUIPO\" ")
                .append("FROM \"EQUIPO_JUGADOR\" ej ")
                .append("INNER JOIN \"EQUIPO\" e ON e.\"ID_EQUIPO\" = ej.\"ID_EQUIPO\" ")
                .append("WHERE ej.\"ID_EQUIPO\" <> " + idEquipo + " AND ej.\"ID_CATEGORIA\" = " + idCategoria + " AND ej.\"ID_TEMPORADA\" = " + idTemporada + " ")
                .toString();

        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);

        return listado;
    }

    @Override
    public List<Object[]> listarJugadores(String idEquipo, String idTemporada, String idCategoria) {
        String sql = new StringBuilder()
                .append("SELECT ej.\"ID_PARTICIPANTE\",  ej.\"NUMERO_DORSAL\", concat(p.\"NOMBRES\",' ',p.\"APELLIDO_1\",' ',p.\"APELLIDO_2\" ) nombre ")
                .append("FROM \"EQUIPO_JUGADOR\" ej ")
                .append("INNER JOIN \"PARTICIPANTE\" p ON ej.\"ID_PARTICIPANTE\" = p.\"ID_PARTICIPANTE\" ")
                .append("WHERE p.\"ID_TIPO_PARTICIPANTE\" = 2 AND ej.\"ID_EQUIPO\" = " + idEquipo + " AND ej.\"ID_CATEGORIA\" = " + idCategoria + " AND ej.\"ID_TEMPORADA\" = " + idTemporada + " ")
                .toString();

        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);

        return listado;
    }

    @Override
    public List<Object[]> registarEstadisticas(String idEquipoLoc, String idCategoriaLoc, String idTemporadaLoc, String idEquipoRiv, String idCategoriaRiv, String idTemporadaRiv, String lugar, String fechaPartido, String detalleResultado, String resultado, String idJugadoresLoc, String MINloc, String SECloc, String TCAloc, String TCRloc, String dosTPCAloc, String dosTPCRloc, String tresPTCAloc, String tresPTCRloc, String TLAloc, String TLRloc, String REBROloc, String REBRDloc, String ASloc, String TOloc, String RBloc, String TPloc, String FPCloc, String FPDloc, String masmenosloc, String PTSloc, String idJugadoresRiv, String MINriv, String SECriv, String TCAriv, String TCRriv, String dosTPCAriv, String dosTPCRriv, String tresPTCAriv, String tresPTCRriv, String TLAriv, String TLRriv, String REBROriv, String REBRDriv, String ASriv, String TOriv, String RBriv, String TPriv, String FPCriv, String FPDriv, String masmenosriv, String PTSriv, String OBSloc, String OBSriv) {
        
        String sql = new StringBuilder()
            .append("CALL public.registrar_estadisticas_partido('"+idEquipoLoc+"','"+idCategoriaLoc+"','"+idTemporadaLoc+"','"+idEquipoRiv+"','"+idCategoriaRiv+"','"+idTemporadaRiv+"','"+lugar+"','"+fechaPartido+"','"+detalleResultado+"','"+resultado+"','"+idJugadoresLoc+"','"+MINloc+"','"+SECloc+"','"+TCAloc+"','"+TCRloc+"','"+dosTPCAloc+"','"+dosTPCRloc+"','"+tresPTCAloc+"','"+tresPTCRloc+"','"+TLAloc+"','"+TLRloc+"','"+REBROloc+"','"+REBRDloc+"','"+ASloc+"','"+TOloc+"','"+RBloc+"','"+TPloc+"','"+FPCloc+"','"+FPDloc+"','"+masmenosloc+"','"+PTSloc+"','"+idJugadoresRiv+"','"+MINriv+"','"+SECriv+"','"+TCAriv+"','"+TCRriv+"','"+dosTPCAriv+"','"+dosTPCRriv+"','"+tresPTCAriv+"','"+tresPTCRriv+"','"+TLAriv+"','"+TLRriv+"','"+REBROriv+"','"+REBRDriv+"','"+ASriv+"','"+TOriv+"','"+RBriv+"','"+TPriv+"','"+FPCriv+"','"+FPDriv+"','"+masmenosriv+"','"+PTSriv+"','"+OBSloc+"','"+OBSriv+"');")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
            .toString(); 
        
        System.out.println(sql);

        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);

        return listado;
    }
    
    

}
