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
    public List<Object[]> listarColaboradores() {
      String sql = new StringBuilder()
            .append("select p.\"ID_PARTICIPANTE\", p.\"NOMBRES\", p.\"APELLIDO_1\" || ', ' || p.\"APELLIDO_2\", tdi.\"TIPO_DOCUMENTO_IDENTIDAD\", p.\"NUMERO_DOCUMENTO_IDENTIDAD\", tp.\"TIPO_PARTICIPANTE\", TO_CHAR(p.\"FECHA_NACIMIENTO\", 'DD-MM-YYYY')  ")
              .append("from \"PARTICIPANTE\" p join \"TIPO_DOCUMENTO_IDENTIDAD\" tdi  on p.\"ID_TIPO_DOCUMENTO_IDENTIDAD\"  = tdi.\"ID_TIPO_DOCUMENTO_IDENTIDAD\" ")
              .append("join \"TIPO_PARTICIPANTE\" tp ON tp.\"ID_TIPO_PARTICIPANTE\" = p.\"ID_TIPO_PARTICIPANTE\" where p.\"ID_TIPO_PARTICIPANTE\" in (1, 3);")
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
    public List<Object[]> registrarColaborador(String nombre, String apellido1, String apellido2, String idTipoDoc, String numDocumento, String fechaNacimiento, String idEquipo, String idCategoria, String idTemporada, String tipoParticipante) {
        String sql = new StringBuilder()
                .append("CALL public.registrarcolaborador (")
                .append("'" + nombre + "', '" + apellido1 + "', '" + apellido2 + "', " + idTipoDoc + ", '" + numDocumento + "', '" + fechaNacimiento + "'::DATE, " + idEquipo + ", " + idCategoria + ", " + idTemporada + ", " +  tipoParticipante + ");")
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
                .append("SELECT \"NOMBRES\", \"APELLIDO_1\", \"APELLIDO_2\", \"ID_TIPO_DOCUMENTO_IDENTIDAD\", \"NUMERO_DOCUMENTO_IDENTIDAD\", \"FECHA_NACIMIENTO\", \"ID_TIPO_PARTICIPANTE\" ")
                .append("FROM \"PARTICIPANTE\" ")
                .append("WHERE \"ID_PARTICIPANTE\" = " +  idColaborador)
                .toString();
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

    @Override
    public List<Object[]> editarColaborador(String nombre, String apellido1, String apellido2, String idTipoDoc, String numDocumento, String fechaNacimiento, String idColaborador, String tipoParticipante) {
             String sql = new StringBuilder()
                .append("UPDATE \"PARTICIPANTE\" SET \"NOMBRES\" = '" + nombre + "', \"APELLIDO_1\" = '" + apellido1 + "', \"APELLIDO_2\" = '" + apellido2 + "', \"ID_TIPO_DOCUMENTO_IDENTIDAD\" = " + idTipoDoc + ", \"NUMERO_DOCUMENTO_IDENTIDAD\" = '" + numDocumento + "', \"FECHA_NACIMIENTO\" = '" + fechaNacimiento + "', \"FECHA_REGISTRO\" = now(), ")
                .append("\"ID_TIPO_PARTICIPANTE\" = " + tipoParticipante + " WHERE \"ID_PARTICIPANTE\" = " + idColaborador).toString();
        
  
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        
              String sql1 = new StringBuilder()
                      .append("UPDATE \"ID_TIPO_CUENTA\" = " + tipoParticipante + "WHERE \"ID_PARTICPANTE\" = " + idColaborador).toString();
              
        listado = obj.selectGeneral(sql1);
           return listado;
    }

    @Override
    public List<Object[]> listarTipoParticipante() {
              String sql = new StringBuilder()
                .append("select tp.\"ID_TIPO_PARTICIPANTE\", tp.\"TIPO_PARTICIPANTE\"  from \"TIPO_PARTICIPANTE\" tp where tp.\"ID_TIPO_PARTICIPANTE\" in (1, 3);")
                .toString();
  
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

    @Override
    public List<Object[]> listarEquipos(String participante) {
                  String sql = new StringBuilder()
                .append("select distinct e.\"ID_EQUIPO\", e.\"ID_CATEGORIA\",  t.\"ID_TEMPORADA\", e.\"NOMBRE_EQUIPO\" || ', TEMPORADA: ' || t.\"NOMBRE_TEMPORADA\" || ' ' || tt.\"TIPO_TEMPORADA\"  from \"EQUIPO\" e ")
                .append("join \"EQUIPO_JUGADOR\" ej on e.\"ID_EQUIPO\" = ej.\"ID_EQUIPO\" ")
                .append("join \"TEMPORADA\" t on t.\"ID_TEMPORADA\" = ej.\"ID_TEMPORADA\" ")
                .append("join \"TIPO_TEMPORADA\" tt on tt.\"ID_TIPO_TEMPORADA\" = t.\"ID_TIPO_TEMPORADA\" ")
                .append("where e.\"ID_TIPO_EQUIPO\" = 1")
                .append("and ej.\"ID_PARTICIPANTE\" <> " +  participante + ";")
                .toString();
  
                 
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

    @Override
    public List<Object[]> asignarEquipo(String equipo, String categoria, String temporada, String participante) {
         String sql = new StringBuilder()
            .append("INSERT INTO public.\"EQUIPO_JUGADOR\" ")
            .append("(\"ID_CATEGORIA\", \"ID_EQUIPO\", \"ID_TEMPORADA\", \"ID_PARTICIPANTE\", \"ID_POSICION\", \"NUMERO_DORSAL\", \"ESTADO_REGISTRO\", \"FECHA_REGISTRO\") ")
            .append("VALUES (" + categoria + ", " + equipo + ", " + temporada + ", " + participante + ", null, null, 'A', now()); ")
            .toString();
        
        
    
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

    @Override
    public List<Object[]> equiposAsignados(String participante) {
               String sql = new StringBuilder()
                .append("select distinct e.\"NOMBRE_EQUIPO\", t.\"NOMBRE_TEMPORADA\" || ' ' || tt.\"TIPO_TEMPORADA\"  from \"EQUIPO_JUGADOR\" ej ")
                .append("join \"EQUIPO\" e on e.\"ID_EQUIPO\" = ej.\"ID_EQUIPO\" ")
                .append("join \"TEMPORADA\" t on t.\"ID_TEMPORADA\" = ej.\"ID_TEMPORADA\" ")
                .append("join \"TIPO_TEMPORADA\" tt on tt.\"ID_TIPO_TEMPORADA\" = t.\"ID_TIPO_TEMPORADA\" ")
                .append("and ej.\"ID_PARTICIPANTE\" = " +  participante + ";")
                .toString(); 
               
                SelectGeneral obj = new SelectGeneral();
                List<Object[]> listado =  obj.selectGeneral(sql);
        
                return listado;
    }



    
}
