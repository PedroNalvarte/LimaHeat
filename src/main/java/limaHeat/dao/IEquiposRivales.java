package limaHeat.dao;

import java.util.List;

public interface IEquiposRivales {
    
    List<Object[]> listarCategorias();
    
    List<Object[]> registrarEquipos(String idCategoria, String nombreEquipo);
    
    List<Object[]> listarEquiposRegistrados();
    
}
