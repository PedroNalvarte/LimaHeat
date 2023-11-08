package limaHeat.dao;

import java.util.List;

public interface IColaboradores {
    List<Object[]> listarColaboradores();
    List<Object[]> listarTipoDocumento();
    List<Object[]> listarTipoParticipante();
    List<Object[]> registrarColaborador(String nombre, String apellido1, String apellido2, String idTipoDoc, String numDocumento, String fechaNacimiento, String idEquipo, String idCategoria, String idTemporada, String tipoParticipante);
    List<Object[]> eliminarColaborador(String idColaborador);
    List<Object[]> obtenerColaborador(String idColaborador);
    List<Object[]> editarColaborador(String nombre, String apellido1, String apellido2, String idTipoDoc, String numDocumento, String fechaNacimiento, String idColaborador, String tipoParticipante);
    List<Object[]> listarEquipos(String participante);
    List<Object[]> asignarEquipo(String equipo, String categoria, String temporada, String participante);
    List<Object[]> equiposAsignados(String participante);
}
