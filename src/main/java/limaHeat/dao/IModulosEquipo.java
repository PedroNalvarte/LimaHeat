package limaHeat.dao;

import java.util.List;

public interface IModulosEquipo {
    
    List<Object[]> cargarTitulo(String idEquipo, String idCategoria, String idTemporada);
    
}
