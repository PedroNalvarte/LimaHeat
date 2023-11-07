package limaHeat.dao;

import java.util.List;

public interface IGestionarUsuarios {
    
    List<Object[]> listarUsuarios();
    
    List<Object[]> eliminarCuenta(String idParticipante);
    
    List<Object[]> reiniciarCredenciales(String idParticipante);
    
    

    
}
