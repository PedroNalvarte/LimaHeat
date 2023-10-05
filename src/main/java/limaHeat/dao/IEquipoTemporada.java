package limaHeat.dao;

import java.util.List;


public interface IEquipoTemporada {
    
    List<Object[]> cargarTitulo(String idEquipo, String idCategoria);
    
    List<Object[]> cargarTipoDni();
    
    List<Object[]> cargarDDLTemporadas();
    
    List<Object[]> registrarTemporada(String nombres, String ape1, String ape2, String tipoDocIde, String numDocIDe, String idTemporada, String idEquipo, String idCategoria);
    
    List<Object[]> listarTemporadas(String idEquipo, String idCategoria);
}
