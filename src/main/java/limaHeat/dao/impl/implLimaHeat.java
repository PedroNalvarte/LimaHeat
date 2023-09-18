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
    public List<Object[]> obtenerPersonaPorUsuario(String usuario) {
        
        String sql = new StringBuilder()
            .append("select concat(\"NOMBRES\",' ',\"APELLIDO_1\",' ',\"APELLIDO_2\")  from \"PARTICIPANTE\" p where \"USUARIO\" = '"+usuario+"'")
            .toString();
        
        System.out.println(sql);
        
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }
    
    
    
}
