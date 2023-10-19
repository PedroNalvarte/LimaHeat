package limaHeat.dao.impl;

import general.sql.SelectGeneral;
import java.util.List;
import limaHeat.dao.ICategoria;

public class implAgregarCategorias implements ICategoria {

    @Override
public List<Object[]> insertarDatos(String NOMBRE_CATEGORIA, String ABREVIATURA, String DESC_CATEGORIA, String IMAGEN) {
    String sql = new StringBuilder()
            .append("INSERT INTO public.\"CATEGORIA\" ")
            .append("( \"NOMBRE_CATEGORIA\", \"ABREVIATURA\", \"DESC_CATEGORIA\", \"IMAGEN\", \"ESTADO_REGISTRO\", \"FECHA_REGISTRO\") ")
            .append("VALUES ('" + NOMBRE_CATEGORIA + "', '" + ABREVIATURA + "', '" + DESC_CATEGORIA + "', '" + IMAGEN + "', 'A', now())")
            .toString();
    SelectGeneral obj = new SelectGeneral();
    List<Object[]> listado = obj.selectGeneral(sql);

    return listado;
}
    @Override
    public List<Object[]> listarCategorias() {
        String sql = new StringBuilder()
                .append("SELECT * FROM \"CATEGORIA\"")
                .toString();

        SelectGeneral obj = new SelectGeneral();
        List<Object[]> listado = obj.selectGeneral(sql);
        return listado;
    }

    @Override
    public List<Object[]> editarCategoria(String NOMBRE_CATEGORIA, String ABREVIATURA, String DESC_CATEGORIA, String ID_CATEGORIA) {
        String sql = new StringBuilder()
                .append("UPDATE \"public\".\"CATEGORIA\" ")
                .append("SET \"NOMBRE_CATEGORIA\" = '" + NOMBRE_CATEGORIA + "', ")
                .append("\"ABREVIATURA\" = '" + ABREVIATURA + "', ")
                .append("\"DESC_CATEGORIA\" = '" + DESC_CATEGORIA + "' ")
                .append("WHERE \"ID_CATEGORIA\" = " + ID_CATEGORIA)
                .toString();

        SelectGeneral obj = new SelectGeneral();
        List<Object[]> editar = obj.selectGeneral(sql);
        return editar;

    }

    @Override
    public List<Object[]> obtenerCategoria(String ID_CATEGORIA) {
        String sql = new StringBuilder()
                .append("SELECT \"ID_CATEGORIA\", \"NOMBRE_CATEGORIA\", \"ABREVIATURA\", \"DESC_CATEGORIA\", \"IMAGEN\"  FROM \"CATEGORIA\" WHERE \"ID_CATEGORIA\" = '")
                .append(ID_CATEGORIA)
                .append("'")
                .toString();
        
        SelectGeneral obj = new SelectGeneral();
        List<Object[]> obtener = obj.selectGeneral(sql);

        return obtener;
    }

}
