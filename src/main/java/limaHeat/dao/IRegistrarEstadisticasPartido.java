package limaHeat.dao;

import java.util.List;
public interface IRegistrarEstadisticasPartido {
    List<Object[]> listarEquiposRivales(String idEquipo, String idTemporada, String idCategoria);
    List<Object[]> listarJugadores(String idEquipo, String idTemporada, String idCategoria);
}
