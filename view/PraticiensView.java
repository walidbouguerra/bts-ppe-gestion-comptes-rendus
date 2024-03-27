package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class PraticiensView {	
	private JPanel praticiens;
	public JPanel getPraticiens() {
		return praticiens;
	}
	private JTable tablePraticiens;
	@SuppressWarnings("serial")
	
	public PraticiensView() {
		praticiens = new JPanel();
		praticiens.setLayout(null);
		praticiens.setBackground(new Color(248, 248, 255));
		praticiens.setBounds(153, 0, 491, 541);
		
		JLabel titrePraticiens = new JLabel("Praticiens");
		titrePraticiens.setHorizontalAlignment(SwingConstants.CENTER);
		titrePraticiens.setForeground(Color.DARK_GRAY);
		titrePraticiens.setFont(new Font("Tahoma", Font.BOLD, 16));
		titrePraticiens.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
		titrePraticiens.setBounds(165, 11, 161, 43);
		praticiens.add(titrePraticiens);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 96, 429, 406);
		praticiens.add(scrollPane);
		
		tablePraticiens = new JTable();
		tablePraticiens.setBackground(Color.WHITE);
		tablePraticiens.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom", "Prenom", "Adresse", "Ville", "Lieu"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class,String.class,String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tablePraticiens);
	}
	public JTable getTablePraticiens() {
		return tablePraticiens;
	}
}
