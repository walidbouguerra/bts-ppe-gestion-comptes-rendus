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
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Insets;

public class MedicamentsView {
	private JPanel medicaments;
	public JPanel getMedicaments() {
		return medicaments;
	}
	private JComboBox<Object> medicamentsComboBox = new JComboBox<Object>();
	public JComboBox<Object> getMedicamentsComboBox() {
		return medicamentsComboBox;
	}
	private JTextArea composition = new JTextArea();
	private final JTextArea effets = new JTextArea();
	private JPanel detailMedicament = new JPanel();
	public JPanel getDetailMedicament() {
		return detailMedicament;
	}
	public JTextArea getEffets() {
		return effets;
	}
	public JTextArea getContreindic() {
		return contreindic;
	}
	private final JTextArea contreindic = new JTextArea();
	private final JLabel labelMedicament = new JLabel("Medicament :");
	
	public JTextArea getComposition() {
		return composition;
	}

	public MedicamentsView() {
		medicaments = new JPanel();
		medicaments.setLayout(null);
		medicaments.setBackground(new Color(248, 248, 255));
		medicaments.setBounds(153, 0, 491, 541);
		
		JLabel titreMedicaments = new JLabel("Medicaments");
		titreMedicaments.setHorizontalAlignment(SwingConstants.CENTER);
		titreMedicaments.setForeground(Color.DARK_GRAY);
		titreMedicaments.setFont(new Font("Tahoma", Font.BOLD, 16));
		titreMedicaments.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
		titreMedicaments.setBounds(165, 11, 161, 43);
		medicaments.add(titreMedicaments);
		
		
		medicamentsComboBox.setBounds(165, 109, 161, 30);
		medicaments.add(medicamentsComboBox);
		
		
		detailMedicament.setBounds(28, 169, 435, 341);
		medicaments.add(detailMedicament);
		detailMedicament.setLayout(null);
		
		JLabel labelComposition = new JLabel("Composition : ");
		labelComposition.setBounds(24, 26, 85, 14);
		detailMedicament.add(labelComposition);
		composition.setMargin(new Insets(4, 4, 4, 4));
		composition.setWrapStyleWord(true);
		composition.setEditable(false);
		composition.setLineWrap(true);
		
		JLabel labelEffets = new JLabel("Effets : ");
		composition.setBounds(136, 11, 243, 51);
		detailMedicament.add(composition);
		labelEffets.setBounds(24, 109, 46, 14);
		
		detailMedicament.add(labelEffets);
		effets.setMargin(new Insets(4, 4, 4, 4));
		effets.setWrapStyleWord(true);
		effets.setLineWrap(true);
		effets.setEditable(false);
		effets.setBounds(136, 73, 243, 106);
		
		JLabel labelContreindic = new JLabel("Contre-indication : ");
		detailMedicament.add(effets);
		labelContreindic.setBounds(10, 208, 116, 44);
		
		detailMedicament.add(labelContreindic);
		contreindic.setMargin(new Insets(4, 4, 4, 4));
		contreindic.setWrapStyleWord(true);
		contreindic.setEditable(false);
		contreindic.setLineWrap(true);
		contreindic.setBounds(136, 192, 243, 123);
		
		detailMedicament.add(contreindic);
		labelMedicament.setBounds(47, 117, 85, 14);
		
		medicaments.add(labelMedicament);
		
		detailMedicament.setVisible(false);
	}
}
