package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.IGestionarUsuarios;

public class impGestionarUsuarios implements IGestionarUsuarios{

    @Override
    public List<Object[]> listarUsuarios() {
        
        String sql = new StringBuilder()
            .append("select p.\"ID_PARTICIPANTE\", concat(p.\"APELLIDO_1\",' ',p.\"APELLIDO_2\",' ',p.\"NOMBRES\"), ")
            .append("p.\"USUARIO\", c.\"CONTRASENA\", p.\"FECHA_REGISTRO\"  from \"PARTICIPANTE\" p ")
            .append("inner join \"CUENTA\" c on c.\"ID_PARTICIPANTE\" = p.\"ID_PARTICIPANTE\"")
            .append("where c.\"ID_TIPO_CUENTA\" != 1")
            .toString();
        
        System.out.println(sql);
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

    
    @Override
    public List<Object[]> eliminarCuenta(String idParticipante) {
        
        String sql = new StringBuilder()
            .append("delete from \"CUENTA\" c where c.\"ID_PARTICIPANTE\" = "+idParticipante+"")
            .toString();
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }

    @Override
    public List<Object[]> reiniciarCredenciales(String idParticipante) {
        
        String sql = new StringBuilder()
            .append("update \"CUENTA\" c set \"CONTRASENA\" = (select \"USUARIO\"  from \"PARTICIPANTE\" p where p.\"ID_PARTICIPANTE\" = "+idParticipante+") ")
            .append("where c.\"ID_PARTICIPANTE\" = "+idParticipante+" ")
            .toString();
        
        
             
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado =  obj.selectGeneral(sql);
        
        return listado;
    }
    
}
