package limaHeat.dao;

import java.util.List;

public interface ILimaHeat {
    
    List<Object[]> inicioSesion( String usuario);
    
    List<Object[]> cambiarContrasena( String usuario, String nuevaContrasena);
    
    List<Object[]> obtenerPersonaPorUsuario( String usuario);
    
}
