package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VisiteursView {
	
	private JPanel visiteurs;
	public JPanel getVisiteurs() {
		return visiteurs;
	}
	private JTable tableVisiteurs;
	@SuppressWarnings("serial")
	
	public VisiteursView() {
		visiteurs = new JPanel();
		visiteurs.setLayout(null);
		visiteurs.setBackground(new Color(248, 248, 255));
		visiteurs.setBounds(153, 0, 491, 541);
		
		JLabel titreVisiteurs = new JLabel("Visiteurs");
		titreVisiteurs.setHorizontalAlignment(SwingConstants.CENTER);
		titreVisiteurs.setForeground(Color.DARK_GRAY);
		titreVisiteurs.setFont(new Font("Tahoma", Font.BOLD, 16));
		titreVisiteurs.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
		titreVisiteurs.setBounds(165, 11, 161, 43);
		visiteurs.add(titreVisiteurs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 96, 429, 406);
		visiteurs.add(scrollPane);
		
		tableVisiteurs = new JTable();
		tableVisiteurs.setBackground(Color.WHITE);
		tableVisiteurs.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom", "Prenom", "Adresse", "Ville", "Laboratoire"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class,String.class,String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableVisiteurs);
	}
	public JTable getTableVisiteurs() {
		return tableVisiteurs;
	}
}
