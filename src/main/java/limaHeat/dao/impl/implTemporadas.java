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
    public boolean registrarTemporadas(String nombreTemporada, String tipoTemporada, String fechaInicio, String fechaFin) {
        String sql = "INSERT INTO \"TEMPORADA\" (\"NOMBRE_TEMPORADA\", \"ID_TIPO_TEMPORADA\", \"FECHA_INICIO\", \"FECHA_FIN\", \"ESTADO_REGISTRO\") VALUES (?, ?, ?, ? )";
        try (Connection connection = new ConectaDb().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            int tipoInt = Integer.parseInt(tipoTemporada);
            Date fechaI = Date.valueOf(fechaInicio);
            Date fechaF = Date.valueOf(fechaFin);
            preparedStatement.setString(1, nombreTemporada);
            preparedStatement.setInt(2, tipoInt);
            preparedStatement.setDate(3, fechaI);
            preparedStatement.setDate(4, fechaF);
            preparedStatement.setString(5, "A");
            
           
     
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
