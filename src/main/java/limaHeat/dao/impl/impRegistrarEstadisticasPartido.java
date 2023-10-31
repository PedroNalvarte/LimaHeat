/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IRegistrarEstadisticasPartido;

public class impRegistrarEstadisticasPartido implements IRegistrarEstadisticasPartido {

    //"ID_EQUIPO"	"ID_CATEGORIA"	"ID_TEMPORADA"	"NOMBRE_EQUIPO"
    @Override
    public List<Object[]> listarEquiposRivales(String idEquipo, String idTemporada, String idCategoria) {
        String sql = new StringBuilder()
                .append("SELECT DISTINCT ej.\"ID_EQUIPO\", ej.\"ID_CATEGORIA\", ej.\"ID_TEMPORADA\" ,e.\"NOMBRE_EQUIPO\" ")
                .append("FROM \"EQUIPO_JUGADOR\" ej ")
                .append("INNER JOIN \"EQUIPO\" e ON e.\"ID_EQUIPO\" = ej.\"ID_EQUIPO\" ")
                .append("WHERE ej.\"ID_EQUIPO\" <> "+idEquipo+" AND ej.\"ID_CATEGORIA\" = "+idCategoria+" AND ej.\"ID_TEMPORADA\" = "+idTemporada+" ")
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
                .append("WHERE p.\"ID_TIPO_PARTICIPANTE\" = 2 AND ej.\"ID_EQUIPO\" = "+idEquipo+" AND ej.\"ID_CATEGORIA\" = "+idCategoria+" AND ej.\"ID_TEMPORADA\" = "+idTemporada+" ")
                .toString();
        
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);

        return listado;
    }

}
