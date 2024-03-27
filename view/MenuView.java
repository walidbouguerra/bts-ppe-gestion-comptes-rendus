package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class MenuView {
	private JPanel menu;
	private JLabel nomVisiteur = new JLabel("");
	private JButton btnVisiteurs = new JButton("Visiteurs");
	private JButton btnPraticiens = new JButton("Praticiens");
	private JButton btnMedicaments = new JButton("Medicaments");
	private JButton btnConsulterRapport = new JButton("Consulter rapport");
	private JButton btnSaisirRapport = new JButton("Saisir Rapport");
	
	public JButton getBtnConsulterRapport() {
		return btnConsulterRapport;
	}

	public JButton getBtnSaisirRapport() {
		return btnSaisirRapport;
	}

	private JButton btnQuitter = new JButton("Quitter");
	
	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}
	public JButton getBtnQuitter() {
		return btnQuitter;
	}

	public JButton getBtnAccueil() {
		return btnConsulterRapport;
	}

	public JButton getBtnMedicaments() {
		return btnMedicaments;
	}

	public JButton getBtnPraticiens() {
		return btnPraticiens;
	}

	public JButton getBtnVisiteurs() {
		return btnVisiteurs;
	}

	public JLabel getNomVisiteur() {
		return nomVisiteur;
	}

	public MenuView() {
		menu = new JPanel();
		menu.setBackground(new Color(135, 206, 235));
		menu.setBounds(0, 0, 155, 541);
		
		JLabel logoMenu = new JLabel("");
		logoMenu.setBounds(5, 5, 145, 96);
		logoMenu.setIcon(new ImageIcon(View.class.getResource("/images/logo_menu.jpg")));
		
		JLabel titreMenu = new JLabel("MENU");
		titreMenu.setForeground(Color.DARK_GRAY);
		titreMenu.setBounds(42, 163, 71, 30);
		titreMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		titreMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setLayout(null);
		menu.add(logoMenu);
		menu.add(titreMenu);
		
		JPanel btnMenu = new JPanel();
		btnMenu.setBackground(new Color(135, 206, 235));
		btnMenu.setBounds(0, 193, 150, 337);
		menu.add(btnMenu);
		btnMenu.setLayout(null);
		
		
		btnConsulterRapport.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsulterRapport.setBounds(10, 9, 135, 45);
		btnMenu.add(btnConsulterRapport);
		
		
		btnSaisirRapport.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSaisirRapport.setBounds(10, 63, 135, 45);
		btnMenu.add(btnSaisirRapport);
		
		
		btnVisiteurs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVisiteurs.setBounds(10, 117, 135, 45);
		btnMenu.add(btnVisiteurs);
		
		
		btnPraticiens.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPraticiens.setBounds(10, 171, 135, 45);
		btnMenu.add(btnPraticiens);
		
		
		btnMedicaments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnMedicaments.setBounds(10, 225, 135, 45);
		btnMenu.add(btnMedicaments);
		
		
		btnQuitter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQuitter.setBounds(10, 279, 135, 45);
		btnMenu.add(btnQuitter);
		
		
		nomVisiteur.setHorizontalAlignment(SwingConstants.CENTER);
		nomVisiteur.setBounds(19, 119, 117, 33);
		menu.add(nomVisiteur);
	}


}
