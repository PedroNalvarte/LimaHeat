package limaHeat.dao;

import java.util.List;

public interface IHistorialPartidos {
    

    List<Object[]> registrarPartido(String equipoLocal, String equipoVisitante, String fecha, String lugar,String idTemporada,String idCategoria,String idEquipo);

    List<Object[]> listarPartidos(String idEquipo, String idTemporada);

    List<Object[]> editarPartido(String equipoLocal,String equipoVisitante, String fecha, String lugar,String resultado,String detalleResultado, String idPartido);
    
    List<Object[]> cargarRendimientoGeneral(String idEquipo,String idCategoria,String idTemporada);

   
}