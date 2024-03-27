package controller;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.*;

public class VisiteurController implements ActionListener {
	private VisiteurModel m;
	private View v;
	
	public VisiteurController(VisiteurModel m, View v){
		this.m = m;
		this.v = v;
		
		this.v.getMenuView().getNomVisiteur().setText(this.m.getNom()+" "+this.m.getPrenom());
		this.v.getMenuView().getBtnVisiteurs().addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e)  {
		
		this.v.getVisiteursView().getVisiteurs().setVisible(true);
		this.v.getConsulterRapportView().getRapport().setVisible(false);
		this.v.getMedicamentsView().getMedicaments().setVisible(false);
		this.v.getSaisirRapportView().getRapport().setVisible(false);
		this.v.getPraticiensView().getPraticiens().setVisible(false);
		
		try {
			afficherTousLesVisiteurs();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void afficherTousLesVisiteurs() throws SQLException {
		ResultSet rs = this.m.tousLesVisiteurs();
		DefaultTableModel tm = (DefaultTableModel) v.getVisiteursView().getTableVisiteurs().getModel();
		while(rs.next()) {
			
			Object o [] = {
					rs.getString("VIS_NOM"),
					rs.getString("Vis_PRENOM"),
					rs.getString("VIS_ADRESSE"),
					rs.getString("VIS_VILLE"),
					rs.getString("LAB_NOM")
			};
			
			tm.addRow(o);
			
		}
	}
}
