package model;

import java.sql.*;

public class LoginModel extends Model {
	private String id;
	private Connection conn;

	public Connection getConn() {
		return conn;
	}

	public LoginModel() throws SQLException {
		this.conn = bdd();

	}

	public boolean verifLogin(String username, String password) throws SQLException {
		Statement stmt = this.conn.createStatement();
		password = password + " 00:00:00";
		String req = "SELECT VIS_MATRICULE, VIS_NOM, VIS_DATEEMBAUCHE FROM Visiteur WHERE VIS_NOM = '" + username
				+ "' AND VIS_DATEEMBAUCHE = '" + password + "' ";
		ResultSet rs = stmt.executeQuery(req);

		if (rs.next()) {

			this.id = rs.getString("VIS_MATRICULE");

			return true;

		} else {
			return false;
		}
	}

	public String getId() {
		return id;
	}

}
