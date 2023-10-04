package limaHeat.dao;

import java.util.List;

public interface ICategoria {

    List<Object[]> insertarDatos(String NOMBRE_CATEGORIA, String ABREVIATURA, String DESC_CATEGORIA, String IMAGEN );

    List<Object[]> listarCategorias();

    List<Object[]> editarCategoria(String NOMBRE_CATEGORIA, String ABREVIATURA, String DESC_CATEGORIA, String ID_CATEGORIA);

    List<Object[]> obtenerCategoria(String ID_CATEGORIA);
}
