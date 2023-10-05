
package limaHeat.dao;

import java.util.List;

public interface IMisEquipos {
    
    List<Object[]> cargarMisEquipos();
    
    List<Object[]> registrarNuevoEquipo(String nombreEquipo, String idCategoria);
    
}
