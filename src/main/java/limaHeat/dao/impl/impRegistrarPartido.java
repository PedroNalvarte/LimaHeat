/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IRegistrarPartido;

/**
 *
 * @author creo0
 */
public class impRegistrarPartido implements IRegistrarPartido {

    @Override
    public List<Object[]> registrarPartido(String RESULTADO, String DETALLE_RESULTADO, String LUGAR) {

        // ID_PARTIDO|RESULTADO|DETALLE_RESULTADO|LUGAR|ESTADO_REGISTRO|FECHA_REGISTRO|
        String sql = new StringBuilder()
                .append("INSERT INTO public.\"PARTIDO\" ")
                .append("(\"RESULTADO\",\"DETALLE_RESULTADO\",\"LUGAR\",\"ESTADO_REGISTRO\",\"FECHA_REGISTRO\")")
                .append("VALUES ('" + RESULTADO + "', '" + DETALLE_RESULTADO + "', '" + LUGAR + "', 'A', now())")
                .toString();
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);

        return listado;

    }

    @Override
    public List<Object[]> listarPartidos(String equipo, String categoria, String temporada) {

        String sql = new StringBuilder()
        .append("select  distinct p.\"ID_PARTIDO\", p.\"RESULTADO\", p.\"DETALLE_RESULTADO\", p.\"LUGAR\", ")
        .append("e.\"NOMBRE_EQUIPO\", case when ej.\"ID_EQUIPO\" = " + equipo)
        .append(" then 'LOCAL' else 'RIVAL' end as \"RIVAL\", ")
        .append(" p.fecha_partido    from \"PARTIDO\" p ")
        .append("inner join \"ESTADISTICAS_JUGADOR\" ej  on p.\"ID_PARTIDO\" = ej.\"ID_PARTIDO\" ")
        .append("inner join \"EQUIPO\" e on e.\"ID_EQUIPO\" = ej.\"ID_EQUIPO\" ")
        .append("where ej.\"ID_EQUIPO\"  in (select ej.\"ID_EQUIPO\"  from \"PARTIDO\" p inner join \"ESTADISTICAS_JUGADOR\" ej ON ej.\"ID_PARTIDO\" = p.\"ID_PARTIDO\" where ej.\"ID_TEMPORADA\" = " + temporada)
        .append(" and ej.\"ID_CATEGORIA\" = " + categoria)
        .append(" and ej.\"ID_PARTIDO\" in (select p2.\"ID_PARTIDO\" from \"PARTIDO\" p2 inner join \"ESTADISTICAS_JUGADOR\" ej2 on p2.\"ID_PARTIDO\" = ej2.\"ID_PARTIDO\" and ej2.\"ID_EQUIPO\" = " + equipo)
        .append(")  ) and ej.\"ID_TEMPORADA\" = " + temporada)
        .append(" and ej.\"ID_CATEGORIA\" = " + categoria + ";")
        .toString();
       System.out.println(sql);
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

    @Override
    public List<Object[]> EditarPartido(String RESULTADO, String DETALLE_RESULTADO, String LUGAR, String idPartido) {
        String sql = new StringBuilder()
                .append("UPDATE \"PARTIDO\" SET \"RESULTADO\" = '" + RESULTADO + "', \"DETALLE_RESULTADO\" = '" + DETALLE_RESULTADO + "', \"LUGAR\" = '" + LUGAR + "'")
                .append(" WHERE \"ID_PARTIDO\" = " + idPartido)
                .toString();

        SelectGeneral obj = new SelectGeneral();
        List<Object[]> resultado = obj.selectGeneral(sql);
        return resultado;
    }

    @Override
    public List<Object[]> eliminarPartido(String idPartido) {
        String sql = new StringBuilder()
                .append("DELETE FROM \"PARTIDO\" WHERE \"ID_PARTIDO\" = " +idPartido)
                .toString();

        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql.toString());
        return listado;
    }
 @Override
public List<Object[]> obtenerPartido(String idPartido) {
    String sql = new StringBuilder()
            .append("SELECT \"ID_PARTIDO\", \"RESULTADO\", \"DETALLE_RESULTADO\", \"LUGAR\" ")
            .append("FROM \"PARTIDO\" WHERE \"ID_PARTIDO\" = " + idPartido)
            .toString();
    SelectGeneral obj = new SelectGeneral();
    List<Object[]> partido = obj.selectGeneral(sql);

    return partido;
}

  

   

}
