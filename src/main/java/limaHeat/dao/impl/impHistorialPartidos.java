/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IHistorialPartidos;

/**
 *
 * @author creo0
 */
public class impHistorialPartidos implements IHistorialPartidos{

     
  @Override
  public List<Object[]> registrarPartido(String equipoLocal, String equipoVisitante, String fecha, String lugar, String idTemporada, String idCategoria, String idEquipo) {
    String sql = "INSERT INTO tu_tabla_partidos (equipo_local, equipo_visitante, fecha, categoria, temporada, lugar) " +
                 "VALUES ('" + equipoLocal + "', '" + equipoVisitante + "', '" + fecha + "', '" + idCategoria + "', '" + idTemporada + "', '" + lugar + "');";
    // Ejecuta la consulta SQL para registrar el partido y recupera la información necesaria
    SelectGeneral obj = new SelectGeneral();
    List<Object[]> listado = obj.selectGeneral(sql);
    return listado;
}

    @Override
    public List<Object[]> listarPartidos(String categoria, String temporada) {
        String sql = "SELECT \"ID_PARTIDO\", \"RESULTADO\", \"DETALLE_RESULTADO\", \"FECHA\" FROM PARTIDO " +
                     "WHERE \"CATEGORIA\" = '" + categoria + "' AND \"TEMPORADA\" = '" + temporada + "'";
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

    @Override
    public List<Object[]> editarPartido(String equipoLocal, String equipoVisitante, String fecha, String categoria, String temporada, String lugar, String idPartido) {
        String sql = "UPDATE tu_tabla_partidos " +
                     "SET equipo_local = '" + equipoLocal + "', equipo_visitante = '" + equipoVisitante + "', fecha = '" + fecha + "', categoria = '" + categoria + "', temporada = '" + temporada + "', lugar = '" + lugar + "'" +
                     "WHERE \"ID_PARTIDO\" = " + idPartido;
        // Ejecuta la consulta SQL para editar el partido y recupera la información necesaria
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

   

    
}
