package general.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDb {
    
    // jdbc:postgresql://192.168.0.26:5432/customerdb
    //SAP TESTING
    private final String url = "jdbc:postgresql://dpg-ck140qndorps73b5pe40-a.oregon-postgres.render.com:5432/limaheatdb_d95g";
    //private final String url = "jdbc:sqlserver://172.25.12.46:1433;databaseName=FIA360;integratedSecurity=false;encrypt=true;trustServerCertificate=true";
    private final String driver = "org.postgresql.Driver";
    private final String user = "limaheatdb_d95g_user";
    private final String password = "ZjW6zTi4ZrEt0gC5qXsP5O5JzEHgduxi";

    public Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en conexion");
            throw new SQLException(e.getMessage());
        }

        return conn;
    }


    
}
