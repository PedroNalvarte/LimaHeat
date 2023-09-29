package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IEquiposRivales;

public class impEquiposRivales implements IEquiposRivales{

    @Override
    public List<Object[]> listarCategorias() {
        
        String sql = new StringBuilder()
            .append("select \"ID_CATEGORIA\", \"NOMBRE_CATEGORIA\" from \"CATEGORIA\" c where \"ESTADO_REGISTRO\" = 'A'")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    
    }

    @Override
    public List<Object[]> registrarEquipos(String idCategoria, String nombreEquipo) {
        
        String sql = new StringBuilder()
            .append("INSERT INTO public.\"EQUIPO\" ")
            .append("(\"ID_EQUIPO\", \"ID_CATEGORIA\", \"ID_TIPO_EQUIPO\", \"NOMBRE_EQUIPO\", \"ESTADO_REGISTRO\", \"FECHA_REGISTRO\") ")
            .append("VALUES(nextval('\"EQUIPO_ID_EQUIPO_seq\"'::regclass), "+idCategoria+", 2, '"+nombreEquipo+"', 'A', now()); ")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
     
    }

    @Override
    public List<Object[]> listarEquiposRegistrados() {
        
        String sql = new StringBuilder()
            .append("select e.\"ID_EQUIPO\", e.\"ID_CATEGORIA\", c.\"NOMBRE_CATEGORIA\", e.\"NOMBRE_EQUIPO\"  from \"EQUIPO\" e  ")
            .append("inner join \"CATEGORIA\" c on c.\"ID_CATEGORIA\" = e.\"ID_CATEGORIA\" ")
            .append("where e.\"ID_TIPO_EQUIPO\" = '2' and e.\"ESTADO_REGISTRO\" = 'A'")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
       
    }

    @Override
    public List<Object[]> cargarDatosEquipo(String id) {
        
        String sql = new StringBuilder()
            .append("select e.\"ID_CATEGORIA\", c.\"NOMBRE_CATEGORIA\", e.\"ID_TIPO_EQUIPO\", te.\"TIPO_EQUIPO\", e.\"NOMBRE_EQUIPO\"  from \"EQUIPO\" e ")
            .append("inner join \"CATEGORIA\" c on c.\"ID_CATEGORIA\"=e.\"ID_CATEGORIA\" ")
            .append("inner join \"TIPO_EQUIPO\" te on te.\"ID_TIPO_EQUIPO\"=e.\"ID_TIPO_EQUIPO\" ")
            .append("where e.\"ID_EQUIPO\" = "+id+"")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
        
    }

    @Override
    public List<Object[]> editarEquipo(String idCategoria, String nombreEquipo, String idEquipo) {
        
        String sql = new StringBuilder()
            .append("UPDATE public.\"EQUIPO\" ")
            .append("SET \"ID_CATEGORIA\"="+idCategoria+", \"NOMBRE_EQUIPO\"='"+nombreEquipo+"', \"FECHA_REGISTRO\"= now() ")
            .append("WHERE \"ID_EQUIPO\"="+idEquipo+"; ")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
       
    }
    
    
    
}
