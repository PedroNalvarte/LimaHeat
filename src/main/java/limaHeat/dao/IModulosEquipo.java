package limaHeat.dao;

import java.util.List;

public interface IModulosEquipo {
    
    public List<Object[]> cargarTitulo(String idEquipo, String idCategoria, String idTemporada);
    
}
