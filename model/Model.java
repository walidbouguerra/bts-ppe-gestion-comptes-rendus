package model;
import java.sql.*;

public class Model {
	private Connection conn;
	
	public Model() throws SQLException {
		
		this.conn= bdd();
	}
	
	public Connection bdd() throws SQLException {
		
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		   
		}
		
		String url = "jdbc:mysql://localhost:3306/gsb?useUnicode=yes&characterEncoding=UTF-8";
		String utilisateur = "root";
		String motDePasse = "root";
		Connection connexion = null;
		 
		try {
		    connexion = DriverManager.getConnection( url, utilisateur, motDePasse );  
		    

		} catch ( SQLException e ) {
		
		} 
		return  connexion;	 
	}
	
	
	public ResultSet tousLesPraticiens() throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT * FROM praticien INNER JOIN type_praticien ON praticien.TYP_CODE = type_praticien.TYP_CODE";
		ResultSet rs = stmt.executeQuery(req);
		
		return rs;
	}
	
	
	public ResultSet tousLesMedicaments() throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT * FROM medicament";
		ResultSet rs = stmt.executeQuery(req);
		
		return rs;
	}
	
	public ResultSet tousLesRapports(String id) throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT * FROM rapport_visite WHERE VIS_MATRICULE = '"+id+"'";
		ResultSet rs = stmt.executeQuery(req);
		return rs;
	}
	public ResultSet unRapport(int num) throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT * FROM rapport_visite LEFT JOIN offrir ON rapport_visite.RAP_NUM = offrir.RAP_NUM LEFT JOIN medicament ON offrir.MED_DEPOTLEGAL = medicament.MED_DEPOTLEGAL WHERE rapport_visite.RAP_NUM = '"+num+"'";
		ResultSet rs = stmt.executeQuery(req);
		return rs;
	}
	
	public ResultSet unPraticient(int num) throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT * FROM rapport_visite INNER JOIN praticien ON rapport_visite.PRA_NUM = praticien.PRA_NUM WHERE rapport_visite.RAP_NUM = '"+num+"'";
		ResultSet rs = stmt.executeQuery(req);
		return rs;
	}
	

	
	
	public ResultSet detailMedicament(String nom) throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT * FROM medicament WHERE MED_NOMCOMMERCIAL = '"+nom+"'";
		ResultSet rs = stmt.executeQuery(req);
		
		return rs;
	}
	
	public ResultSet tousLesEchantillons() throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT * FROM temp_rapport";
		ResultSet rs = stmt.executeQuery(req);
		
		return rs;
	}
	
	public void ajouterEchantillon(String nomMedicament, int nombre) throws SQLException {
		String req = "INSERT INTO temp_rapport (nom_medicament, nombre) VALUES(?,?)";
		PreparedStatement  pstmt = this.conn.prepareStatement(req);
		pstmt.setString(1, nomMedicament);
		pstmt.setInt(2, nombre);
		pstmt.executeUpdate();
		
	}

	public void supprimerEchantillon() throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "DELETE FROM temp_rapport ORDER BY id DESC LIMIT 1";
		 stmt.executeUpdate(req);
		
	}

	public void supprimerTempRapport() throws SQLException {
		Statement  stmt = this.conn.createStatement();
		String req = "DELETE FROM temp_rapport";
		 stmt.executeUpdate(req);
	}

	public void validerRapport(String praticien, String date, String motif, String bilan, String idVisiteur) throws SQLException {
		
		Statement  stmt = this.conn.createStatement();
		String req = "SELECT PRA_NUM FROM praticien WHERE PRA_NOM = '"+praticien+"'";
		ResultSet rs = stmt.executeQuery(req);
		while(rs.next()) {
			int idPraticien = rs.getInt("PRA_NUM");
			String req2 = "INSERT INTO rapport_visite (VIS_MATRICULE, PRA_NUM, RAP_DATE, RAP_BILAN, RAP_MOTIF) VALUES(?,?,?,?,?)";
			PreparedStatement  pstmt = this.conn.prepareStatement(req2);
			pstmt.setString(1, idVisiteur);
			pstmt.setInt(2, idPraticien);
			pstmt.setString(3, date);
			pstmt.setString(4, bilan);
			pstmt.setString(5, motif);
			pstmt.executeUpdate();
			
		}
		
		Statement  stmt2 = this.conn.createStatement();
		String req2 = "SELECT RAP_NUM FROM rapport_visite ORDER BY RAP_NUM DESC LIMIT 1";
		ResultSet rs2 = stmt2.executeQuery(req2);
		while(rs2.next()) {
			int idRapport = rs2.getInt("RAP_NUM");
			Statement  stmt3 = this.conn.createStatement();
			String req3 = "SELECT * FROM temp_rapport INNER JOIN medicament ON temp_rapport.nom_medicament = medicament.MED_NOMCOMMERCIAL";
			ResultSet rs3  = stmt3.executeQuery(req3);
			while(rs3.next()) {
				String depotLegal = rs3.getString("MED_DEPOTLEGAL");
				int nombre = rs3.getInt("nombre");
				String req4 = "INSERT INTO offrir (VIS_MATRICULE, RAP_NUM, MED_DEPOTLEGAL, OFF_QTE) VALUES(?,?,?,?)";
				PreparedStatement  pstmt2 = this.conn.prepareStatement(req4);
				pstmt2.setString(1, idVisiteur);
				pstmt2.setInt(2, idRapport);
				pstmt2.setString(3, depotLegal);
				pstmt2.setInt(4, nombre);
				pstmt2.executeUpdate();
			}
		}
		
		
		
		
	}
	
}




