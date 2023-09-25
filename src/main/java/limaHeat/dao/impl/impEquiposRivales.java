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
    
    
    
}
