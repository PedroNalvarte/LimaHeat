package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IEquipoTemporada;

public class impEquipoTemporada implements IEquipoTemporada{

    @Override
    public List<Object[]> cargarTitulo(String idEquipo, String idCategoria) {
        
        String sql = new StringBuilder()
            .append("select \"NOMBRE_EQUIPO\"  from \"EQUIPO\" e ")
            .append("where \"ID_EQUIPO\" = "+idEquipo+" and \"ID_CATEGORIA\" = "+idCategoria+" and \"ESTADO_REGISTRO\" = 'A'")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
       
    }

    //"ID_TIPO_DOCUMENTO_IDENTIDAD"	"TIPO_DOCUMENTO_IDENTIDAD"	"ABREVIATURA"
    @Override
    public List<Object[]> cargarTipoDni() {
        
        String sql = new StringBuilder()
            .append("select \"ID_TIPO_DOCUMENTO_IDENTIDAD\", \"TIPO_DOCUMENTO_IDENTIDAD\", \"ABREVIATURA\"  from \"TIPO_DOCUMENTO_IDENTIDAD\" tdi")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

    //"ID_TEMPORADA"	"ID_TIPO_TEMPORADA"	"TIPO_TEMPORADA"	"NOMBRE_TEMPORADA"	"FECHA_INICIO"	"FECHA_FIN"
    @Override
    public List<Object[]> cargarDDLTemporadas() {
        
        String sql = new StringBuilder()
            .append("select t.\"ID_TEMPORADA\", t.\"ID_TIPO_TEMPORADA\",  tt.\"TIPO_TEMPORADA\", t.\"NOMBRE_TEMPORADA\", t.\"FECHA_INICIO\", t.\"FECHA_FIN\" ")
            .append("from \"TEMPORADA\" t ")
            .append("inner join \"TIPO_TEMPORADA\" tt on t.\"ID_TIPO_TEMPORADA\" = tt.\"ID_TIPO_TEMPORADA\" ")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

    @Override
    public List<Object[]> registrarTemporada(String nombres, String ape1, String ape2, String tipoDocIde, String numDocIDe, String idTemporada, String idEquipo, String idCategoria) {

        String sql = new StringBuilder()
            .append("CALL public.registrarequipotemporada('"+nombres+"', '"+ape1+"', '"+ape2+"', "+tipoDocIde+", '"+numDocIDe+"', "+idTemporada+", "+idEquipo+", "+idCategoria+"); ")
            .toString();
        
        System.out.println(sql);
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
        
    }

    @Override
    public List<Object[]> listarTemporadas(String idEquipo, String idCategoria) {
        
        String sql = new StringBuilder()
            .append("select ej.\"ID_TEMPORADA\", t.\"NOMBRE_TEMPORADA\", tt.\"TIPO_TEMPORADA\" , t.\"FECHA_INICIO\", t.\"FECHA_FIN\" from \"EQUIPO_JUGADOR\" ej ")
            .append("inner join \"TEMPORADA\" t on T.\"ID_TEMPORADA\" = EJ.\"ID_TEMPORADA\" ")
            .append("inner join \"TIPO_TEMPORADA\" tt on tt.\"ID_TIPO_TEMPORADA\" = t.\"ID_TIPO_TEMPORADA\" ")
            .append("where \"ID_EQUIPO\" = "+idEquipo+" and \"ID_CATEGORIA\" = "+idCategoria+" ")
            .toString();
        
        System.out.println(sql);
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
       
    }

    
    
    
    
}
