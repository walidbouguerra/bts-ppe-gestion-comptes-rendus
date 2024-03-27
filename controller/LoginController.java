package controller;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import model.*;

public class LoginController implements ActionListener  {
	private LoginModel m;
	private View v;
	private String id;
	
	public LoginController(LoginModel m, View v) {
		this.m = m;
		this.v = v;	
		this.v.getLogin().getBtnConnexion().addActionListener(this);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String username = v.getLogin().getUsername().getText();
		String password = v.getLogin().getPassword().getText();
		
		try {
			if(m.verifLogin(username, password)){
				v.getConnexion().setVisible(false);
				v.getMain().setVisible(true);
				ConsulterRapportController cr = new ConsulterRapportController(m,v,m.getId());
				QuitterController qc = new QuitterController(v);
				VisiteurModel vm = new VisiteurModel(m.getId());
				SaisirRapportController rc = new SaisirRapportController(m, v, m.getId());
				VisiteurController vc = new VisiteurController(vm ,v);
				PraticienController pc = new PraticienController(m,v);
				MedicamentController mc = new MedicamentController(m,v);
				
			}
			else {
				v.getLogin().getLoginIncorrect().setVisible(true);
				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}
		
}
