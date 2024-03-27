package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;

public class ConnexionView {
	
	private JPanel formulaire = new JPanel();
	public JPanel getFormulaire() {
		return formulaire;
	}

	private JPanel connexion;
	private JTextField username;
	private JButton btnConnexion = new JButton("SE CONNECTER");
	private JLabel loginIncorrect = new JLabel("Mot de passe ou nom d\'utilisateur incorrect !");
	private JPasswordField password;
	
	public JLabel getLoginIncorrect() {
		return loginIncorrect;
	}

	public JButton getBtnConnexion() {
		return btnConnexion;
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	
	public JPanel getConnexion() {
		return connexion;
	}

	public void setConnexion(JPanel connexion) {
		this.connexion = connexion;
	}

	public ConnexionView(){
		this.connexion = new JPanel();
		connexion.setBackground(new Color(135, 206, 250));
		connexion.setBounds(0, 0, 644, 541);
		connexion.setLayout(null);
		formulaire.setBounds(140, 120, 363, 300);
		
		
		formulaire.setBackground(Color.WHITE);
		connexion.add(formulaire);
		formulaire.setLayout(null);
		
		JLabel logoGsb = new JLabel("");
		logoGsb.setBounds(10, 11, 50, 32);
		formulaire.add(logoGsb);
		logoGsb.setBackground(Color.WHITE);
		logoGsb.setIcon(new ImageIcon(View.class.getResource("/images/logo.jpg")));
		
		JLabel titreConnexion = new JLabel("Connexion");
		titreConnexion.setBounds(99, 11, 165, 42);
		titreConnexion.setFont(new Font("Tahoma", Font.BOLD, 17));
		titreConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		formulaire.add(titreConnexion);
		
		JLabel titreUsername = new JLabel("Nom d'utilisateur");
		titreUsername.setBounds(46, 83, 130, 20);
		titreUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		formulaire.add(titreUsername);
		
		username = new JTextField();
		username.setBounds(46, 114, 270, 20);
		formulaire.add(username);
		username.setColumns(10);
		
		JLabel titrePassword = new JLabel("Mot de passe");
		titrePassword.setBounds(46, 145, 130, 20);
		titrePassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		formulaire.add(titrePassword);
		btnConnexion.setBounds(111, 234, 140, 42);
		
		
		btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 13));
		formulaire.add(btnConnexion);
		loginIncorrect.setBounds(10, 58, 343, 14);
		loginIncorrect.setHorizontalAlignment(SwingConstants.CENTER);
		
		loginIncorrect.setForeground(Color.RED);
		formulaire.add(loginIncorrect);
		
		password = new JPasswordField();
		password.setBounds(46, 176, 270, 20);
		formulaire.add(password);
		loginIncorrect.setVisible(false);
		
		
	}
}
