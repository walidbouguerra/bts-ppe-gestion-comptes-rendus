package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Insets;

public class ConsulterRapportView {
	private JPanel rapport;
	private JComboBox<Object> rapports = new JComboBox<Object>();
	private JTextField praticien;
	private JTextField date;
	private JTextField motif;
	private JTable tableOffert;
	private JTextArea bilan = new JTextArea();
	private JPanel panelRapport = new JPanel();
	
	public JPanel getPanelRapport() {
		return panelRapport;
	}

	public JTextArea getBilan() {
		return bilan;
	}

	public JComboBox<Object> getRapports() {
		return rapports;
	}

	public ConsulterRapportView() {
		rapport = new JPanel();
		rapport.setLayout(null);
		rapport.setBackground(new Color(248, 248, 255));
		rapport.setBounds(153, 0, 491, 541);
		
		JLabel titreRapport = new JLabel("Consulter rapport");
		titreRapport.setHorizontalAlignment(SwingConstants.CENTER);
		titreRapport.setForeground(Color.DARK_GRAY);
		titreRapport.setFont(new Font("Tahoma", Font.BOLD, 16));
		titreRapport.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
		titreRapport.setBounds(165, 11, 161, 43);
		rapport.add(titreRapport);
		
		
		rapports.setBounds(172, 128, 147, 22);
		rapport.add(rapports);
		
		JLabel labelRapport = new JLabel("Rapports :");
		labelRapport.setBounds(61, 132, 101, 14);
		rapport.add(labelRapport);
		
		
		panelRapport.setBounds(10, 161, 471, 369);
		rapport.add(panelRapport);
		panelRapport.setLayout(null);
		
		JLabel labelPraticien = new JLabel("Praticien");
		labelPraticien.setBounds(10, 25, 66, 14);
		panelRapport.add(labelPraticien);
		
		praticien = new JTextField();
		praticien.setBounds(76, 22, 138, 20);
		panelRapport.add(praticien);
		praticien.setColumns(10);
		
		JLabel labelDate = new JLabel("Date");
		labelDate.setBounds(10, 69, 46, 14);
		panelRapport.add(labelDate);
		
		date = new JTextField();
		date.setBounds(76, 66, 138, 20);
		panelRapport.add(date);
		date.setColumns(10);
		
		JLabel labelMotif = new JLabel("Motif");
		labelMotif.setBounds(10, 115, 46, 14);
		panelRapport.add(labelMotif);
		
		motif = new JTextField();
		motif.setBounds(76, 112, 138, 20);
		panelRapport.add(motif);
		motif.setColumns(10);
		
		JLabel labelBilan = new JLabel("Bilan");
		labelBilan.setBounds(78, 160, 46, 14);
		panelRapport.add(labelBilan);
		bilan.setMargin(new Insets(4, 4, 4, 4));
		
		
		bilan.setLineWrap(true);
		bilan.setEditable(false);
		bilan.setWrapStyleWord(true);
		bilan.setBounds(20, 185, 168, 173);
		panelRapport.add(bilan);
		
		JLabel labelEchantillon = new JLabel("Echantillons");
		labelEchantillon.setBounds(316, 160, 103, 14);
		panelRapport.add(labelEchantillon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 185, 226, 173);
		panelRapport.add(scrollPane);
		
		tableOffert = new JTable();
		tableOffert.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicament", "Nb echantillons"
			}
		));
		
		scrollPane.setViewportView(tableOffert);
		
		panelRapport.setVisible(false);
	}

	public JPanel getRapport() {
		return rapport;
	}

	public JTextField getPraticien() {
		return praticien;
	}

	public JTextField getDate() {
		return date;
	}

	public JTextField getMotif() {
		return motif;
	}

	public JTable getTableOffert() {
		return tableOffert;
	}
}
