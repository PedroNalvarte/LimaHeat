
package limaHeat.dao;

import java.util.List;

public interface IPartidosJugador {
     List<Object[]> listarPartidosJugador(String jugador, String equipo);
     List<Object[]> mostrarEstadisticaPartidoLocal(String partido, String equipo);
     List<Object[]> mostrarEstadisticaPartidoRival(String partido, String equipo);
     List<Object[]> mostrarRendimientoGeneral(String jugador);
     List<Object[]> cargarTitulos(String partido);
}
