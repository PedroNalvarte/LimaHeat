/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limaHeat.dao.impl;

import general.conexion.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import limaHeat.dao.ICategoria;

/**
 *
 * @author creo0
 */
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
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Map<String, String>> obtenerTodasLasCategorias() {
                List<Map<String, String>> categorias = new ArrayList<>();

        String sql = new StringBuilder()
                .append("SELECT \"NOMBRE_CATEGORIA\", \"DESC_CATEGORIA\", \"IMAGEN\" FROM \"CATEGORIA\"")
                .toString();
                System.out.println(sql);
        try (Connection connection = new ConectaDb().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Map<String, String> categoria = new HashMap<>();
                categoria.put("NOMBRE_CATEGORIA", resultSet.getString("NOMBRE_CATEGORIA"));
                categoria.put("DESC_CATEGORIA", resultSet.getString("DESC_CATEGORIA"));
                categoria.put("IMAGEN", resultSet.getString("IMAGEN"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }


}
