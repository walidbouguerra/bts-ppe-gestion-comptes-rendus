package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class View extends JFrame {
	private static final long serialVersionUID = 1L;

	
	private JPanel contentPane;
	
	
	//connexion
	private ConnexionView login = new ConnexionView();
	public ConnexionView getLogin() {
		return login;
	}

	private JPanel connexion = login.getConnexion();

	public JPanel getConnexion() {
		return connexion;
	}

	//menu
	private MenuView menuView = new MenuView();
	
	
	public MenuView getMenuView() {
		return menuView;
	}

	//Main View
	private JPanel main = new JPanel();
	public JPanel getMain() {
		return main;
	}
	
	//saisir rapport
	private SaisirRapportView saisirRapportView = new SaisirRapportView();
	public SaisirRapportView getSaisirRapportView() {
		return saisirRapportView;
	}
	//consulter rapport
		private ConsulterRapportView consulterRapportView = new ConsulterRapportView();
		public ConsulterRapportView getConsulterRapportView() {
			return consulterRapportView;
		}
	
	
	//visiteurs
	private VisiteursView visiteursView = new VisiteursView();
	public VisiteursView getVisiteursView() {
		return visiteursView;
	}
	
	//praticiens
	private PraticiensView praticiensView = new PraticiensView();

	public PraticiensView getPraticiensView() {
		return praticiensView;
	}
	
	//medicaments
		private MedicamentsView medicamentsView = new MedicamentsView();

		public MedicamentsView getMedicamentsView() {
			return medicamentsView;
		}
	

	
	public View() {
		
		//Fen�tre principale
		setTitle("GSB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Connexion
		contentPane.add(this.connexion);
		connexion.setLayout(null);
		
		
		//Main
		main.setBounds(0, 0, 644, 541);
		contentPane.add(main);
		main.setLayout(null);
		
		//Menu
		main.add(this.menuView.getMenu());
		
		//Compte Rendu
		
		main.add(consulterRapportView.getRapport());
		main.add(saisirRapportView.getRapport());
		main.add(visiteursView.getVisiteurs());
		main.add(praticiensView.getPraticiens());
		main.add(medicamentsView.getMedicaments());
		main.setVisible(false);
		
		saisirRapportView.getRapport().setVisible(false);
		visiteursView.getVisiteurs().setVisible(false);
		praticiensView.getPraticiens().setVisible(false);
		medicamentsView.getMedicaments().setVisible(false);
	}






}
