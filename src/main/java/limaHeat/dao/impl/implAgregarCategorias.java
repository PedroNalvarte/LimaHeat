package limaHeat.dao.impl;

import general.conexion.ConectaDb;
import general.sql.SelectGeneral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import limaHeat.dao.ICategoria;


public class implAgregarCategorias implements ICategoria {

@Override
public boolean insertarDatos(String NOMBRE_CATEGORIA, String ABREVIATURA, String DESC_CATEGORIA, String ESTADO_REGISTRO, String IMAGEN) {
    String sql = "INSERT INTO \"CATEGORIA\" (\"NOMBRE_CATEGORIA\", \"ABREVIATURA\", \"DESC_CATEGORIA\", \"ESTADO_REGISTRO\",\"IMAGEN\") VALUES (?, ?, ?, ?, ? )";
    try (Connection connection = new ConectaDb().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, NOMBRE_CATEGORIA);
        preparedStatement.setString(2, ABREVIATURA);
        preparedStatement.setString(3, DESC_CATEGORIA);
        preparedStatement.setString(4, ESTADO_REGISTRO);
        preparedStatement.setString(5, IMAGEN);

        int rowsAffected = preparedStatement.executeUpdate();
        
     
        return rowsAffected > 0;
    } catch (SQLException e) {
        return false; 
    }
}





    @Override
    public List<Object[]> obtenerTodasLasCategorias() {
        String sql = new StringBuilder()
                .append("SELECT \"NOMBRE_CATEGORIA\", \"DESC_CATEGORIA\", \"IMAGEN\" FROM \"CATEGORIA\"")
                .toString();

        System.out.println(sql);

        SelectGeneral obj = new SelectGeneral();
        List<Object[]> obtener = obj.selectGeneral(sql);
        return obtener;
    }

    @Override
    public List<Object[]> editarCategoria(String ID_CATEGORIA, String NOMBRE_CATEGORIA, String ABREVIATURA, String DESC_CATEGORIA, String ESTADO_REGISTRO, String IMAGEN) {
        String sql = new StringBuilder()
                .append("UPDATE public.\"CATEGORIA\" ")
                .append("SET \"NOMBRE_CATEGORIA\" = ?, ")
                .append("\"ABREVIATURA\" = ?, ")
                .append("\"DESC_CATEGORIA\" = ?, ")
                .append("\"ESTADO_REGISTRO\" = ?, ")
                .append("\"IMAGEN\" = ? ")
                .append("WHERE \"ID_CATEGORIA\" = ?")
                .toString();
System.out.println(sql);

        try (Connection connection = new ConectaDb().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, NOMBRE_CATEGORIA);
            preparedStatement.setString(2, ABREVIATURA);
            preparedStatement.setString(3, DESC_CATEGORIA);
            preparedStatement.setString(4, ESTADO_REGISTRO);
            preparedStatement.setString(5, IMAGEN);
            preparedStatement.setString(6, ID_CATEGORIA);

            int rowsAffected = preparedStatement.executeUpdate();
            List<Object[]> resultList = new ArrayList<>();
            Object[] resultRow = new Object[1];
            resultRow[0] = rowsAffected; // Almacenar la cantidad de filas afectadas
            resultList.add(resultRow);

            return resultList;
        } catch (SQLException e) {
            return null; // En caso de error de SQL, retornar null
        }
    }

}
