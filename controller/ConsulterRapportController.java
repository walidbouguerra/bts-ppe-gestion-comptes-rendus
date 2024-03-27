package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.Model;
import view.View;

public class ConsulterRapportController implements ActionListener {
	private Model m;
	private View v;
	private String idVisiteur;
	private RapportListe rl ;
	
	public ConsulterRapportController(Model m, View v, String idVisiteur) throws SQLException {
		this.m = m;
		this.v=v;
		this.idVisiteur = idVisiteur;
		afficherTousLesRapports(idVisiteur);
		this.rl = new RapportListe(this.m, this.v);
		this.v.getMenuView().getBtnConsulterRapport().addActionListener(this);
		
	}
	
	public void afficherTousLesRapports(String idVisiteur) throws SQLException {
		v.getConsulterRapportView().getRapports().removeAllItems();
		ResultSet rs = this.m.tousLesRapports(idVisiteur);
		 
		while(rs.next()) {
			
			
			int numero =rs.getInt("RAP_NUM");
			
			v.getConsulterRapportView().getRapports().addItem(numero);
	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 try {
			afficherTousLesRapports(this.idVisiteur);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.v.getConsulterRapportView().getRapport().setVisible(true);
		this.v.getSaisirRapportView().getRapport().setVisible(false);
		this.v.getMedicamentsView().getMedicaments().setVisible(false);
		this.v.getPraticiensView().getPraticiens().setVisible(false);
		this.v.getVisiteursView().getVisiteurs().setVisible(false);
		
	}
	public class RapportListe implements ActionListener{
		private View v;
		private Model m;
		public RapportListe(Model m ,View v) {
			this.m = m;
			this.v=v;
			this.v.getConsulterRapportView().getRapports().addActionListener(this);
		}
		
		public void afficherRapport(int num) throws SQLException {
			ResultSet rs = this.m.unRapport(num);
			ResultSet rs2 = this.m.unPraticient(num);
			DefaultTableModel tm = (DefaultTableModel) v.getConsulterRapportView().getTableOffert().getModel();
			while(rs2.next()) {
				v.getConsulterRapportView().getPraticien().setText(rs2.getString("PRA_NOM"));
			}
			
			while(rs.next()) {
				v.getConsulterRapportView().getDate().setText(rs.getString("RAP_DATE"));
				v.getConsulterRapportView().getMotif().setText(rs.getString("RAP_MOTIF"));
				v.getConsulterRapportView().getBilan().setText(rs.getString("RAP_BILAN"));
				Object o [] = {
						rs.getString("medicament.MED_NOMCOMMERCIAL"),
						rs.getString("OFF_QTE"),
					
				};
				
				tm.addRow(o);
				
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel tm = (DefaultTableModel) v.getConsulterRapportView().getTableOffert().getModel();
			tm.setRowCount(0);
			this.v.getConsulterRapportView().getPanelRapport().setVisible(true);
			if(v.getConsulterRapportView().getRapports().getItemCount()>0) {
				int num = (int) v.getConsulterRapportView().getRapports().getSelectedItem();
				try {
					afficherRapport(num);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		
		
		}

	}
}
