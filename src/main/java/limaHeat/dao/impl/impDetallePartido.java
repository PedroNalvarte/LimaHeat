/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IDetallePartido;

/**
 *
 * @author creo0
 */
public class impDetallePartido implements IDetallePartido {

    @Override
    public List<Object[]> CargarNombresJugadoresxCategoria(String ID_TEMPORADA, String ID_CATEGORIA, String ID_EQUIPO) {
       //para los jugadores locales 
   /* String sql = new StringBuilder()
            
        .append("SELECT PP.\"ID_PARTICIPANTE\", PP.\"NOMBRES\"")
        .append(" FROM \"EQUIPO_JUGADOR\" EJUG")
        .append(" JOIN \"PARTICIPANTE\" PP ON EJUG.\"ID_PARTICIPANTE\" = PP.\"ID_PARTICIPANTE\"")
        .append(" JOIN \"TIPO_PARTICIPANTE\" TP ON PP.\"ID_TIPO_PARTICIPANTE\" = TP.\"ID_TIPO_PARTICIPANTE\"")
        .append(" WHERE EJUG.\"ID_TEMPORADA\" = ").append(ID_TEMPORADA)
        .append(" AND EJUG.\"ID_CATEGORIA\" = ").append(ID_CATEGORIA)
        .append(" AND EJUG.\"ID_EQUIPO\" = ").append(ID_EQUIPO)
        .append(" AND TP.\"TIPO_PARTICIPANTE\" = 'JUGADOR';")
        .toString();

     SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
 */
   
   String sql = new StringBuilder()
        .append("CALL public.registrar_estadisticas_jugador(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
        .toString();
   SelectGeneral obj = new SelectGeneral();
    List<Object[]> listado = obj.selectGeneral(sql);
    return listado;
}

    @Override
    public List<Object[]> RegistrarEstadisticasJugador(int ID_TEMPORADA, int ID_EQUIPO, int ID_CATEGORIA, int ID_PARTICIPANTE, int ID_PARTIDO, int MINUTOS_JUGADOS, int SEGUNDOS_JUGADOS, int TC_TOTALES, int TC_ACERTADOS) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
