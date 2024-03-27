package controller;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import model.*;

public class SaisirRapportController implements ActionListener {
	private Model m;
	private View v;
	private Ajouter a;
	private Supprimer s;
	private Effacer e;
	private Valider va;
	
	public SaisirRapportController(Model m, View v, String idVisiteur) throws SQLException {
		this.m = m;
		this.v = v;	
		this.v.getMenuView().getBtnSaisirRapport().addActionListener(this);
		afficherTousLesPraticiens();
		afficherTousLesMedicaments();
		dateRapport();
		this.a = new Ajouter(this.m, this.v);
		this.s = new Supprimer(this.m, this.v);
		this.m.supprimerTempRapport();
		this.e = new Effacer(this.m, this.v);
		this.va = new Valider(this.m, this.v, idVisiteur);
		
	}
	
	
	public void afficherTousLesPraticiens() throws SQLException {
		ResultSet rs = this.m.tousLesPraticiens();	 
		while(rs.next()) {
			String nom =rs.getString("PRA_NOM");
			v.getSaisirRapportView().getPraticien().addItem(nom);
		}
	}
	
	public void afficherTousLesMedicaments() throws SQLException {
		ResultSet rs = this.m.tousLesMedicaments();	 
		while(rs.next()) {
			String nom =rs.getString("MED_NOMCOMMERCIAL");
			v.getSaisirRapportView().getNomMedicament().addItem(nom);
		}
	}
	
	public void dateRapport() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateRapport = (String) dateFormat.format(date);
		this.v.getSaisirRapportView().getDateRapport().setText(dateRapport);
	}
	

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.v.getSaisirRapportView().getRapport().setVisible(true);
		this.v.getConsulterRapportView().getRapport().setVisible(false);
		this.v.getMedicamentsView().getMedicaments().setVisible(false);
		this.v.getPraticiensView().getPraticiens().setVisible(false);
		this.v.getVisiteursView().getVisiteurs().setVisible(false);
		
	}
	
	public class Ajouter implements ActionListener{
		private Model m;
		private View v;
		public Ajouter(Model m, View v) {
			this.m = m;
			this.v = v;	
			this.v.getSaisirRapportView().getBtnAjouter().addActionListener(this);
		}
		public void afficherEchantillons() throws SQLException {
			ResultSet rs = this.m.tousLesEchantillons();
			DefaultTableModel tm = (DefaultTableModel) v.getSaisirRapportView().getTableOffre().getModel();
			tm.setRowCount(0);
			while(rs.next()) {
				
				Object o [] = {
						rs.getString("nom_medicament"),
						rs.getInt("nombre")
					
				};
				tm.addRow(o);
				
			}
		}
		
		public void ajouterEchantillon() {
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				this.m.ajouterEchantillon((String)this.v.getSaisirRapportView().getNomMedicament().getSelectedItem(),(Integer)this.v.getSaisirRapportView().getNbEchant().getValue());
				afficherEchantillons();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	

	}
	public class Supprimer implements ActionListener{
		private Model m;
		private View v;
		public Supprimer(Model m, View v) {
			this.m = m;
			this.v = v;	
			this.v.getSaisirRapportView().getBtnSupprimer().addActionListener(this);
		}
		public void afficherEchantillons() throws SQLException {
			ResultSet rs = this.m.tousLesEchantillons();
			DefaultTableModel tm = (DefaultTableModel) v.getSaisirRapportView().getTableOffre().getModel();
			tm.setRowCount(0);
			while(rs.next()) {
				
				Object o [] = {
						rs.getString("nom_medicament"),
						rs.getInt("nombre")
					
				};
				tm.addRow(o);
				
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				this.m.supprimerEchantillon();
				afficherEchantillons();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	

	}
	public class Effacer implements ActionListener{
		private Model m;
		private View v;
		public Effacer(Model m, View v) {
			this.m=m;
			this.v = v;	
			this.v.getSaisirRapportView().getBtnEffacer().addActionListener(this);
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel tm = (DefaultTableModel) v.getSaisirRapportView().getTableOffre().getModel();
			tm.setRowCount(0);
			this.v.getSaisirRapportView().getMotif().setText("");
			this.v.getSaisirRapportView().getBilan().setText("");
			try {
				this.m.supprimerTempRapport();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	

	}
	
	public class Valider implements ActionListener{
		private Model m;
		private View v;
		private String idVisiteur;
		public Valider(Model m, View v, String idVisiteur) {
			this.idVisiteur = idVisiteur;
			this.m=m;
			this.v = v;	
			this.v.getSaisirRapportView().getBtnValider().addActionListener(this);
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			String motif = this.v.getSaisirRapportView().getMotif().getText();
			String bilan = this.v.getSaisirRapportView().getBilan().getText();
			String date = this.v.getSaisirRapportView().getDateRapport().getText()+" 00:00:00";
			String praticien = (String) this.v.getSaisirRapportView().getPraticien().getSelectedItem();
			
			try {
				this.m.validerRapport(praticien, date, motif, bilan, this.idVisiteur);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			DefaultTableModel tm = (DefaultTableModel) v.getSaisirRapportView().getTableOffre().getModel();
			tm.setRowCount(0);
			this.v.getSaisirRapportView().getMotif().setText("");
			this.v.getSaisirRapportView().getBilan().setText("");
			try {
				this.m.supprimerTempRapport();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	

	}
	
}

