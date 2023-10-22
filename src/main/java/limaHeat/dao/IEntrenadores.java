package limaHeat.dao;
import java.util.List;
public interface IEntrenadores {
     List<Object[]> listarEntrenadores(String idEquipo, String idTemporada, String idCategoria);
     List<Object[]> registrarEntrenador(String nombre, String apellido1, String apellido2, String idTipoDoc, String numDocumento, String fechaNacimiento, String idEquipo, String idCategoria, String idTemporada);
}
