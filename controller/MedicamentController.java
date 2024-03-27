package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.*;
import view.View;

public class MedicamentController implements ActionListener {
	private Model m;
	private View v;
	private MedicamentListe ml;
	
	public MedicamentController(Model m, View v){
		this.m = m;
		this.v = v;
		this.v.getMenuView().getBtnMedicaments().addActionListener(this);
		this.ml = new MedicamentListe(v);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)  {
		
		this.v.getMedicamentsView().getMedicaments().setVisible(true);
		this.v.getConsulterRapportView().getRapport().setVisible(false);
		this.v.getPraticiensView().getPraticiens().setVisible(false);
		this.v.getSaisirRapportView().getRapport().setVisible(false);
		this.v.getVisiteursView().getVisiteurs().setVisible(false);
		
		try {
			afficherTousLesMedicaments();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	
	public void afficherTousLesMedicaments() throws SQLException {
		ResultSet rs = this.m.tousLesMedicaments();
		 
		while(rs.next()) {
			
			
			String nom =rs.getString("MED_NOMCOMMERCIAL");
			
			v.getMedicamentsView().getMedicamentsComboBox().addItem(nom);
	
		}
	}
	
	public void afficherDetailsMedicament(String nom) throws SQLException {
		ResultSet rs = this.m.detailMedicament(nom);
		while(rs.next()) {
			v.getMedicamentsView().getComposition().setText(rs.getString("MED_COMPOSITION"));
			v.getMedicamentsView().getEffets().setText(rs.getString("MED_EFFETS"));
			v.getMedicamentsView().getContreindic().setText(rs.getString("MED_CONTREINDIC"));
		}
	}
	
	public class MedicamentListe implements ActionListener{
		private View v;
		public MedicamentListe(View v) {
			this.v=v;
			this.v.getMedicamentsView().getMedicamentsComboBox().addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			this.v.getMedicamentsView().getDetailMedicament().setVisible(true);
			String nom = (String) v.getMedicamentsView().getMedicamentsComboBox().getSelectedItem();
			try {
				afficherDetailsMedicament(nom) ;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		}

	}
}

