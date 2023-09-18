package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.List;
import limaHeat.dao.ILimaHeat;


public class implLimaHeat implements ILimaHeat{

    /*
    @Override
    public List<Object[]> prueba() {
        
       String sql = new StringBuilder()
            .append("select \"ABREVIATURA\"  from \"TIPO_DOCUMENTO_IDENTIDAD\" tdi where \"ID_TIPO_DOCUMENTO_IDENTIDAD\" = 1")
            .toString();
        
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }
    */
    
    @Override
    public List<Object[]> inicioSesion(String usuario) {   
        
        String sql = new StringBuilder()
            .append("select \"CONTRASENA\"  from \"CUENTA\" c where \"ID_PARTICIPANTE\" = (select \"ID_PARTICIPANTE\"  ")
            .append("from \"PARTICIPANTE\" p where \"USUARIO\" = '"+usuario+"')")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

    @Override
    public List<Object[]> cambiarContrasena(String usuario, String nuevaContrasena) {
        
        String sql = new StringBuilder()
            .append("UPDATE public.\"CUENTA\" ")
            .append("SET \"CONTRASENA\"='"+nuevaContrasena+"'")
            .append("WHERE \"ID_PARTICIPANTE\"= (select \"ID_PARTICIPANTE\"  from \"PARTICIPANTE\" p where \"USUARIO\" = '"+usuario+"')")
            .toString();
        
        System.out.println(sql);
        
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

    @Override
    public List<Object[]> obtenerDatosPorUsuario(String usuario) {
        
        String sql = new StringBuilder()
            .append("select p.\"ID_PARTICIPANTE\", p.\"ID_TIPO_PARTICIPANTE\", tp.\"TIPO_PARTICIPANTE\",  p.\"NOMBRES\", p.\"APELLIDO_1\", p.\"APELLIDO_2\", ")
            .append("tdi.\"TIPO_DOCUMENTO_IDENTIDAD\", p.\"NUMERO_DOCUMENTO_IDENTIDAD\", p.\"FECHA_NACIMIENTO\", c.\"ID_TIPO_CUENTA\", tc.\"TIPO_CUENTA\" ")
            .append("from \"PARTICIPANTE\" p ")
            .append("inner join \"CUENTA\" c on c.\"ID_PARTICIPANTE\" = p.\"ID_PARTICIPANTE\" ")
            .append("inner join \"TIPO_CUENTA\" tc on tc.\"ID_TIPO_CUENTA\" = c.\"ID_TIPO_CUENTA\" ")
            .append("inner join \"TIPO_PARTICIPANTE\" tp on tp.\"ID_TIPO_PARTICIPANTE\" = p.\"ID_PARTICIPANTE\" ")
            .append("inner join \"TIPO_DOCUMENTO_IDENTIDAD\" tdi on tdi.\"ID_TIPO_DOCUMENTO_IDENTIDAD\" = p.\"ID_TIPO_DOCUMENTO_IDENTIDAD\" ")
            .append("where p.\"USUARIO\" = '"+usuario+"'")
            .toString();
        
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }
    
    
    
}
