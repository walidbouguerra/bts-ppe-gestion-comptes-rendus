package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VisiteurModel extends Model {
	private String nom;
	private String prenom;
	private String idVisiteur;
	private Connection conn;
	
	public VisiteurModel(String id) throws SQLException {
		this.conn = bdd();
		this.idVisiteur = id;
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT * FROM Visiteur WHERE VIS_MATRICULE = '"+id+"'";
		ResultSet rs = stmt.executeQuery(req);
		while(rs.next()) {
			this.nom = rs.getString("VIS_NOM");
			this.prenom = rs.getString("Vis_PRENOM");
		}
		
	}
	
	public ResultSet tousLesVisiteurs() throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT * FROM visiteur INNER JOIN labo ON visiteur.LAB_CODE = labo.LAB_CODE";
		ResultSet rs = stmt.executeQuery(req);
		
		return rs;
	}
	public String getPrenom() {
		return prenom;
	}
	
	public String getNom() {
		return nom;
	}

	public String getIdVisiteur() {
		return idVisiteur;
	}

	
	
}
