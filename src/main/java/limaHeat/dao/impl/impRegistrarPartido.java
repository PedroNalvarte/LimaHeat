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
    public List<Object[]> listarPartidos() {

        String sql = new StringBuilder()
                .append("SELECT * FROM \"PARTIDO\"")
                .toString();

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
