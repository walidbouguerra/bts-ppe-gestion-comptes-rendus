package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.*;
import view.*;

public class PraticienController implements ActionListener {
	private Model m;
	private View v;
	
	public PraticienController(Model m, View v){
		this.m = m;
		this.v = v;
		
		this.v.getMenuView().getBtnPraticiens().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)  {
		
		this.v.getPraticiensView().getPraticiens().setVisible(true);
		this.v.getConsulterRapportView().getRapport().setVisible(false);
		this.v.getMedicamentsView().getMedicaments().setVisible(false);
		this.v.getSaisirRapportView().getRapport().setVisible(false);
		this.v.getVisiteursView().getVisiteurs().setVisible(false);
		
		try {
			afficherTousLesVisiteurs();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void afficherTousLesVisiteurs() throws SQLException {
		ResultSet rs = this.m.tousLesPraticiens();
		DefaultTableModel tm = (DefaultTableModel) v.getPraticiensView().getTablePraticiens().getModel();
		while(rs.next()) {
			
			Object o [] = {
					rs.getString("PRA_NOM"),
					rs.getString("PRA_PRENOM"),
					rs.getString("PRA_ADRESSE"),
					rs.getString("PRA_VILLE"),
					rs.getString("TYP_LIEU")
			};
			
			tm.addRow(o);
			
		}
	}
	
	
}
