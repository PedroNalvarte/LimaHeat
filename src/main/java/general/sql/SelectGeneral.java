package general.sql;

import general.Transversal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectGeneral extends Transversal{

	public List<Object[]> selectGeneral(String sql) {
		List<Object[]> lista = null;

		try {
			Connection con = DB.getConnection();
			//Connection con = DAOFactory.getDAOFactory().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			try {
				ResultSet rs = ps.executeQuery();
				ResultSetMetaData md = rs.getMetaData();
				Integer canCol = md.getColumnCount();

				lista = new ArrayList<>();
				while (rs.next()) {
					Object[] fila = new Object[canCol];
					for (int i = 0; i < fila.length; i++) {
						fila[i] = rs.getObject(1 + i);
					}
					lista.add(fila);
				}
			} catch (SQLException e) {
				// message = e.getMessage();
				System.out.println("Select Universal: " + e.getMessage());
			}

		} catch (SQLException e) {
			// message = e.getMessage();
			System.out.println("Select Universal: " + e.getMessage());
		}
		return lista;
	}
	
}
