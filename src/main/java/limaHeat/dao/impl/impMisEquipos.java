package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.sql.SQLOutput;
import java.util.List;
import limaHeat.dao.IMisEquipos;

public class impMisEquipos implements IMisEquipos{

    @Override
    public List<Object[]> cargarMisEquipos() {
        
        String sql = new StringBuilder()
            .append("select e.\"ID_EQUIPO\", e.\"ID_CATEGORIA\", c.\"NOMBRE_CATEGORIA\", e.\"NOMBRE_EQUIPO\"  from \"EQUIPO\" e  ")
            .append("inner join \"CATEGORIA\" c on c.\"ID_CATEGORIA\" = e.\"ID_CATEGORIA\" ")
            .append("where e.\"ID_TIPO_EQUIPO\" = '1' and e.\"ESTADO_REGISTRO\" = 'A'")
            .toString();
        
        System.out.println(sql);
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
        
    }

    @Override
    public List<Object[]> registrarNuevoEquipo(String nombreEquipo, String idCategoria) {
        
        String sql = new StringBuilder()
            .append("INSERT INTO public.\"EQUIPO\" ")
            .append("(\"ID_EQUIPO\", \"ID_CATEGORIA\", \"ID_TIPO_EQUIPO\", \"NOMBRE_EQUIPO\", \"ESTADO_REGISTRO\", \"FECHA_REGISTRO\") ")
            .append("VALUES(nextval('\"EQUIPO_ID_EQUIPO_seq\"'::regclass), "+idCategoria+", 1, '"+nombreEquipo+"', 'A', 'NOW()');")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }
    
}
