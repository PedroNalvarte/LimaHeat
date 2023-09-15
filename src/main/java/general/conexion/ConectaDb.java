package general.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDb {

    public Connection getConnection() throws SQLException {
        Connection cn = null;

        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return cn;
    }


    
    //SAP TESTING
    private final String url = "jdbc:sqlserver://172.25.12.46:1433;databaseName=FIA360;integratedSecurity=false;encrypt=true;trustServerCertificate=true";
    private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String user = "fia_user";
    private final String password = "fia_user";
}
