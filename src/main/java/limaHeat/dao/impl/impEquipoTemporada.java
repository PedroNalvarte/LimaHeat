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

    
    
    
    
}
