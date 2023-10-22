package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import general.conexion.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import limaHeat.dao.IColaboradores;
import java.sql.Date;

public class impColaboradores implements IColaboradores {

    @Override
    public List<Object[]> listarColaboradores(String idEquipo, String idTemporada, String idCategoria) {
      String sql = new StringBuilder()
            .append("SELECT p.\"ID_PARTICIPANTE\", p.\"NOMBRES\", p.\"APELLIDO_1\", p.\"APELLIDO_2\", tdi.\"TIPO_DOCUMENTO_IDENTIDAD\", p.\"NUMERO_DOCUMENTO_IDENTIDAD\", COALESCE(TO_CHAR(p.\"FECHA_NACIMIENTO\", 'DD/MM/YYYY'),'-')")
            .append(" FROM \"PARTICIPANTE\" p")
            .append(" JOIN \"TIPO_PARTICIPANTE\" tp ON p.\"ID_TIPO_PARTICIPANTE\" = tp.\"ID_TIPO_PARTICIPANTE\"")
            .append(" JOIN \"TIPO_DOCUMENTO_IDENTIDAD\" tdi ON p.\"ID_TIPO_DOCUMENTO_IDENTIDAD\" = tdi.\"ID_TIPO_DOCUMENTO_IDENTIDAD\" ")
            .append(" LEFT OUTER JOIN \"CUENTA\" c ON p.\"ID_PARTICIPANTE\" = c.\"ID_PARTICIPANTE\"")
            .append(" LEFT OUTER JOIN \"TIPO_CUENTA\" tc ON c.\"ID_TIPO_CUENTA\" = tc.\"ID_TIPO_CUENTA\"")
            .append(" WHERE EXISTS (SELECT 1 FROM \"EQUIPO_JUGADOR\" ej WHERE ej.\"ID_PARTICIPANTE\" = p.\"ID_PARTICIPANTE\" AND ej.\"ID_EQUIPO\" = "  + idEquipo)
            .append(" AND tc.\"TIPO_CUENTA\" = 'ASISTENTE'")
            .append(" AND ej.\"ID_CATEGORIA\" = " + idCategoria)
            .append(" AND ej.\"ID_TEMPORADA\" = " + idTemporada + ");")
            .toString();
    
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;   
    }

    @Override
    public List<Object[]> listarTipoDocumento() {
       String sql = new StringBuilder()
               .append("SELECT td.\"ID_TIPO_DOCUMENTO_IDENTIDAD\", td.\"TIPO_DOCUMENTO_IDENTIDAD\"")
               .append("FROM \"TIPO_DOCUMENTO_IDENTIDAD\" td")
               .toString();
       
       SelectGeneral obj = new SelectGeneral();
       List<Object[]> listado = obj.selectGeneral(sql);
       return listado;
    }

    @Override
    public List<Object[]> registrarColaborador(String nombre, String apellido1, String apellido2, String idTipoDoc, String numDocumento, String fechaNacimiento, String idEquipo, String idCategoria, String idTemporada) {
        String sql = new StringBuilder()
                .append("CALL public.registrarcolaborador (")
                .append("'" + nombre + "', '" + apellido1 + "', '" + apellido2 + "', " + idTipoDoc + ", '" + numDocumento + "', '" + fechaNacimiento + "'::DATE, " + idEquipo + ", " + idCategoria + ", " + idTemporada + ");")
                .toString();
        
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

    @Override
    public List<Object[]> eliminarColaborador(String idColaborador) {
       String sql = new StringBuilder()
               .append("CALL public.eliminarcolaborador( ")
               .append(idColaborador + ");")
               .toString();
       SelectGeneral obj = new SelectGeneral();
       List<Object[]> listado = obj.selectGeneral(sql);
       return listado;
    }

    @Override
    public List<Object[]> obtenerColaborador(String idColaborador) {
        String sql = new StringBuilder()
                .append("SELECT \"NOMBRES\", \"APELLIDO_1\", \"APELLIDO_2\", \"ID_TIPO_DOCUMENTO_IDENTIDAD\", \"NUMERO_DOCUMENTO_IDENTIDAD\", \"FECHA_NACIMIENTO\"")
                .append("FROM \"PARTICIPANTE\"")
                .append("WHERE \"ID_PARTICIPANTE\" = " +  idColaborador)
                .toString();
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

    /**
     *
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param idTipoDoc
     * @param numDocumento
     * @param fechaNacimiento
     * @param idColaborador
     * @return
     */
    @Override
    public List<Object[]> editarColaborador(String nombre, String apellido1, String apellido2, String idTipoDoc, String numDocumento, String fechaNacimiento, String idColaborador) {
             String sql = new StringBuilder()
                .append("UPDATE \"PARTICIPANTE\" SET \"NOMBRES\" = '" + nombre + "', \"APELLIDO_1\" = '" + apellido1 + "', \"APELLIDO_2\" = '" + apellido2 + "', \"ID_TIPO_DOCUMENTO_IDENTIDAD\" = " + idTipoDoc + ", \"NUMERO_DOCUMENTO_IDENTIDAD\" = '" + numDocumento + "', \"FECHA_NACIMIENTO\" = '" + fechaNacimiento + "', \"FECHA_REGISTRO\" = now()")
                .append(" WHERE \"ID_PARTICIPANTE\" = " + idColaborador).toString();
        
        System.out.println(sql);
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }



    
}
