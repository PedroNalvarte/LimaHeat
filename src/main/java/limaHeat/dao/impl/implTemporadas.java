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
            .append("SELECT \"NOMBRE_TEMPORADA\", \"TIPO_TEMPORADA\" FROM \"TEMPORADA\", \"TIPO_TEMPORADA\" WHERE \"TEMPORADA\".\"ID_TIPO_TEMPORADA\" = \"TIPO_TEMPORADA\".\"ID_TIPO_TEMPORADA\"")
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
        
        System.out.println(sql);
    
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

  
}
