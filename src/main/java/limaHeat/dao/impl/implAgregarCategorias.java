/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limaHeat.dao.impl;

import general.conexion.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import limaHeat.dao.ICategoria;

/**
 *
 * @author creo0
 */
public class implAgregarCategorias implements ICategoria {

    @Override
    public boolean insertarDatos(String NOMBRE_CATEGORIA, String ABREVIATURA, String DESC_CATEGORIA, String ESTADO_REGISTRO, String IMAGEN) {
        String sql = "INSERT INTO \"CATEGORIA\" (\"NOMBRE_CATEGORIA\", \"ABREVIATURA\", \"DESC_CATEGORIA\", \"ESTADO_REGISTRO\",\"IMAGEN\") VALUES (?, ?, ?, ?, ? )";
        try (Connection connection = new ConectaDb().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, NOMBRE_CATEGORIA);
            preparedStatement.setString(2, ABREVIATURA);
            preparedStatement.setString(3, DESC_CATEGORIA);
            preparedStatement.setString(4, ESTADO_REGISTRO);
            preparedStatement.setString(5, IMAGEN);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
