package limaHeat.dao;

import java.util.List;

public interface IColaboradores {
    List<Object[]> listarColaboradores(String idEquipo, String idTemporada, String idCategoria);
    List<Object[]> listarTipoDocumento();
    List<Object[]> registrarColaborador(String nombre, String apellido1, String apellido2, String idTipoDoc, String numDocumento, String fechaNacimiento, String idEquipo, String idCategoria, String idTemporada);
    List<Object[]> eliminarColaborador(String idColaborador);
    List<Object[]> obtenerColaborador(String idColaborador);
    List<Object[]> editarColaborador(String nombre, String apellido1, String apellido2, String idTipoDoc, String numDocumento, String fechaNacimiento, String idColaborador);
}
