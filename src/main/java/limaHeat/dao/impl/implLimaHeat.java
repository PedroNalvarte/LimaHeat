package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import limaHeat.dao.ILimaHeat;


public class implLimaHeat implements ILimaHeat{

    @Override
    public List<Object[]> prueba() {
        
       String sql = new StringBuilder()
            .append("select * from \"TIPO_DOCUMENTO_IDENTIDAD\" tdi ")
            .toString();
        
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }
    
}
