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
import limaHeat.dao.ITemporadas;
import java.sql.Date;


public class implTemporadas implements ITemporadas {
  

    @Override
    public List<Object[]> listarTemporadas() {
     
        String sql = new StringBuilder()
            .append("SELECT \"NOMBRE_TEMPORADA\", \"TIPO_TEMPORADA\", \"ID_TEMPORADA\" FROM \"TEMPORADA\", \"TIPO_TEMPORADA\" WHERE \"TEMPORADA\".\"ID_TIPO_TEMPORADA\" = \"TIPO_TEMPORADA\".\"ID_TIPO_TEMPORADA\"")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;   
    }

    @Override
    public List<Object[]> tiposTemporadas() {
        String sql = new StringBuilder()
            .append("SELECT \"ID_TIPO_TEMPORADA\",\"TIPO_TEMPORADA\" FROM \"TIPO_TEMPORADA\"")
            .toString();
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

    @Override
    public List<Object[]> registrarTemporada(String nombreTemporada, String tipoTemporada, String fechaInicio, String fechaFin) {
        String sql = new StringBuilder()
            .append("INSERT INTO public.\"TEMPORADA\" ")
            .append("(\"ID_TEMPORADA\", \"NOMBRE_TEMPORADA\", \"ID_TIPO_TEMPORADA\", \"FECHA_INICIO\", \"FECHA_FIN\", \"ESTADO_REGISTRO\", \"FECHA_REGISTRO\")")
            .append("VALUES(nextval('\"TEMPORADA_ID_TEMPORADA_seq\"'::regclass), '"+nombreTemporada+"', "+tipoTemporada+", '" + fechaInicio + "'::DATE, '" + fechaFin + "'::DATE, 'A', now()); ")
            .toString();
        
    
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

    @Override
    public List<Object[]> obtenerTemporada(String id) {
        String sql = new StringBuilder()
                .append("SELECT \"TEMPORADA\".*, \"TIPO_TEMPORADA\" FROM \"TEMPORADA\", \"TIPO_TEMPORADA\" WHERE \"TEMPORADA\".\"ID_TIPO_TEMPORADA\" = \"TIPO_TEMPORADA\".\"ID_TIPO_TEMPORADA\" AND \"ID_TEMPORADA\" = " + id).toString();
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> temporada = obj.selectGeneral(sql);
   
        return temporada;
    }

    @Override
    public List<Object[]> eliminarTemporada(String id) {
       String sql = new StringBuilder()
               .append("DELETE FROM \"TEMPORADA\" WHERE \"ID_TEMPORADA\" = "  + id).toString();
       SelectGeneral obj = new SelectGeneral();
       List<Object[]>  resultado = obj.selectGeneral(sql);
       return resultado;
    }

    @Override
    public List<Object[]> editarTemporada(String nombreTemporada, String tipoTemporada, String fechaInicio, String fechaFin, String id) {
       String sql = new StringBuilder()
               .append("UPDATE \"TEMPORADA\" SET \"NOMBRE_TEMPORADA\" = '" + nombreTemporada + "', \"ID_TIPO_TEMPORADA\" = " + tipoTemporada + ", \"FECHA_INICIO\" = '" + fechaInicio + "'::DATE, \"FECHA_FIN\" = '" + fechaFin + "'::DATE," + " \"FECHA_REGISTRO\" = now()")
               .append(" WHERE \"ID_TEMPORADA\" = " + id).toString();

       SelectGeneral obj = new SelectGeneral();
       List<Object[]> resultado = obj.selectGeneral(sql);
       return resultado;
    }

  
}
