package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class SaisirRapportView {
	private JPanel rapport;
	private JTextField dateRapport;
	private JTextField motif;
	private JTextArea bilan = new JTextArea();
	private JComboBox<Object> nomMedicament = new JComboBox<Object>();
	private JTable tableOffre;
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JSpinner nbEchant = new JSpinner();
	private JButton btnEffacer = new JButton("Effacer");
	private JButton btnValider = new JButton("Valider");
	
	public JButton getBtnValider() {
		return btnValider;
	}


	public JButton getBtnEffacer() {
		return btnEffacer;
	}


	public JSpinner getNbEchant() {
		return nbEchant;
	}


	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}


	public JButton getBtnAjouter() {
		return btnAjouter;
	}


	public JComboBox<Object> getNomMedicament() {
		return nomMedicament;
	}


	public JTextArea getBilan() {
		return bilan;
	}


	public JTextField getMotif() {
		return motif;
	}


	public JTextField getDateRapport() {
		return dateRapport;
	}


	
	public JTable getTableOffre() {
		return tableOffre;
	}


	private JComboBox<Object> praticien = new JComboBox<Object>();
	
	
	public JComboBox<Object> getPraticien() {
		return praticien;
	}


	public JPanel getRapport() {
		return rapport;
	}


	public void setRapport(JPanel rapport) {
		this.rapport = rapport;
	}


	public SaisirRapportView() {
		rapport = new JPanel();
		rapport.setLayout(null);
		rapport.setBackground(new Color(248, 248, 255));
		rapport.setBounds(153, 0, 491, 541);
		
		JLabel titreRapport = new JLabel("Saisir rapport");
		titreRapport.setHorizontalAlignment(SwingConstants.CENTER);
		titreRapport.setForeground(Color.DARK_GRAY);
		titreRapport.setFont(new Font("Tahoma", Font.BOLD, 16));
		titreRapport.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
		titreRapport.setBounds(108, 11, 251, 43);
		rapport.add(titreRapport);
		
		JLabel labelPraticien = new JLabel("Praticien ");
		labelPraticien.setBounds(10, 125, 88, 22);
		rapport.add(labelPraticien);
		
		
		praticien.setBounds(108, 124, 143, 22);
		rapport.add(praticien);
		
		JLabel labelDateRapport = new JLabel("Date rapport ");
		labelDateRapport.setBounds(10, 158, 88, 22);
		rapport.add(labelDateRapport);
		
		dateRapport = new JTextField();
		dateRapport.setColumns(10);
		dateRapport.setBounds(108, 159, 143, 20);
		rapport.add(dateRapport);
		
		JLabel labelMotifVisite = new JLabel("Motif Visite\r\n");
		labelMotifVisite.setBounds(10, 191, 88, 22);
		rapport.add(labelMotifVisite);
		
		JLabel labelBilan = new JLabel("Bilan");
		labelBilan.setBounds(10, 234, 48, 22);
		rapport.add(labelBilan);
		
		
		btnValider.setBounds(145, 496, 89, 23);
		rapport.add(btnValider);
		
		JLabel labelOffreEchant = new JLabel("Offre d'\u00E9chantillons");
		labelOffreEchant.setBounds(301, 238, 143, 14);
		rapport.add(labelOffreEchant);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 329, 217, 137);
		rapport.add(scrollPane);
		
		tableOffre = new JTable();
		tableOffre.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E9dicament", "Nb \u00E9chantillion"
			}
		));
		scrollPane.setViewportView(tableOffre);
		
		
		bilan.setBorder(new LineBorder(new Color(0, 0, 0)));
		bilan.setLineWrap(true);
		bilan.setWrapStyleWord(true);
		bilan.setBounds(10, 262, 206, 204);
		rapport.add(bilan);
		
		JLabel labelMedicament = new JLabel("Médicament");
		labelMedicament.setBounds(226, 266, 74, 14);
		rapport.add(labelMedicament);
		
		
		nomMedicament.setBounds(301, 262, 112, 22);
		rapport.add(nomMedicament);
		nbEchant.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		
		nbEchant.setBounds(423, 263, 30, 20);
		rapport.add(nbEchant);
		
		motif = new JTextField();
		motif.setBounds(108, 190, 143, 20);
		rapport.add(motif);
		motif.setColumns(10);
		
		
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAjouter.setBounds(245, 296, 88, 22);
		rapport.add(btnAjouter);
		
		
		btnEffacer.setBounds(244, 496, 89, 23);
		rapport.add(btnEffacer);
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimer.setBounds(372, 295, 89, 23);
		rapport.add(btnSupprimer);
	}
}
