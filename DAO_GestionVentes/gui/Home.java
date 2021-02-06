package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Entities.User;

import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	
	private JFrame frame;
	private static User user;
	private User userAdmin;
	private User userUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		
		initialize();
		
	}
	
	public Home(User userATraiter) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.DARK_GRAY);


		initialize(userATraiter);
	
		

	}
	

	private void initialize() {
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuHome = new JMenu("Home");
		menuHome.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		menuHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(menuHome);
		

		
		
		
		JMenu menuCmde = new JMenu("Commande");
		menuCmde.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		menuBar.add(menuCmde);
		
		JMenuItem mnNouvelleCmde = new JMenuItem("Nouvelle commande");
		mnNouvelleCmde.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		menuCmde.add(mnNouvelleCmde);
	
		
		JMenu mnNewMenu = new JMenu("Utilisateurs");
		mnNewMenu.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mnAjoutUtil= new JMenuItem("Ajout");
		mnAjoutUtil.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		mnNewMenu.add(mnAjoutUtil);
		
		JMenuItem mnModifUtil = new JMenuItem("Modification");
		mnModifUtil.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		mnNewMenu.add(mnModifUtil);
		frame.getContentPane().setLayout(null);
		
		JButton btnVentes = new JButton();
		btnVentes.setText("Gestion des ventes");
		btnVentes.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		btnVentes.setBounds(90, 180, 620, 61);
		frame.getContentPane().add(btnVentes);
		
		JButton btnUtilisateurs = new JButton("Gestion des utilisateurs");
		btnUtilisateurs.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		btnUtilisateurs.setBounds(90, 303, 620, 61);
		frame.getContentPane().add(btnUtilisateurs);
		
		JLabel lblWelcome = new JLabel("New label");
		lblWelcome.setIcon(null);
		lblWelcome.setForeground(Color.DARK_GRAY);
		lblWelcome.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(90, 50, 620, 36);
		frame.getContentPane().add(lblWelcome);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuHome = new JMenu("Home");
		menuHome.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		menuHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(menuHome);
		
		
		
		JMenu menuCmde = new JMenu("Commande");
		menuCmde.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		menuBar.add(menuCmde);
		
		JMenuItem mnNouvelleCmde = new JMenuItem("Nouvelle commande");
		mnNouvelleCmde.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		menuCmde.add(mnNouvelleCmde);
		
		
		
		JButton btnVentes = new JButton();
		btnVentes.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		btnVentes.setBounds(90, 180, 620, 61);
		frame.getContentPane().add(btnVentes);
		
		JButton btnUtilisateurs = new JButton("Gestion des utilisateurs");
		btnUtilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeUtilisateurs lu = new ListeUtilisateurs();
				lu.setVisible(true);
			}
		});
		btnUtilisateurs.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		btnUtilisateurs.setBounds(90, 303, 620, 61);
		frame.getContentPane().add(btnUtilisateurs);
		
		JLabel lblWelcome = new JLabel();
		lblWelcome.setForeground(Color.LIGHT_GRAY);
		lblWelcome.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(90, 90, 620, 36);
		lblWelcome.setText("Bonjour " + user.getUserName()+ " !");
		frame.getContentPane().add(lblWelcome);
		
		/*JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/icons/hello (1).png")));
		lblNewLabel.setBounds(386, 21, 39, 85);
		frame.getContentPane().add(lblNewLabel);*/
		
		if (user.getAccess().equals("Admin")) {
			this.userAdmin = user ;
			btnUtilisateurs.setEnabled(true);
			btnVentes.setEnabled(true);

			btnVentes.setText("Gestion des ventes");
			btnVentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestionVentes gv = new GestionVentes();
					gv.setVisible(true);
				}
			});
			
	

			JMenuItem mnReconnect = new JMenuItem("Reconnect");
			mnReconnect.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
			menuHome.add(mnReconnect);
			mnReconnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Acceuil accueil = new Acceuil();
					accueil.setVisible(true);
					setVisible(false);
				}
			});
			
			mnNouvelleCmde.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestionVentes gv = new GestionVentes();
					gv.setVisible(true);
				}
			});
			
			JMenu mnNewMenu = new JMenu("Utilisateurs");
			mnNewMenu.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
			menuBar.add(mnNewMenu);
			
			JMenuItem mnAjoutUtil= new JMenuItem("Ajout");
			mnAjoutUtil.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
			mnAjoutUtil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NouvelUtilisateur newUser = new NouvelUtilisateur(frame, false);
					newUser.setVisible(true);
				}
			});
			mnNewMenu.add(mnAjoutUtil);
			
			JMenuItem mnModifUtil = new JMenuItem("Affichage");
			mnModifUtil.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
			mnModifUtil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListeUtilisateurs lu = new ListeUtilisateurs();
					lu.setVisible(true);
				}
			});
			mnNewMenu.add(mnModifUtil);
			frame.getContentPane().setLayout(null);
			
			JMenuItem mnAffichageCmd= new JMenuItem("Affichage des commandes");
			mnAffichageCmd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AffichageVentes av = new AffichageVentes();
					av.setVisible(true);
				}
			});
			mnAffichageCmd.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
			menuCmde.add(mnAffichageCmd);

		} 
		else if (user.getAccess().equals("User")) {

			this.userUser = user;
			
			btnUtilisateurs.setEnabled(false);
			btnVentes.setEnabled(true);
			
			btnVentes.setText("Nouvelle commande");
			mnNouvelleCmde.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestionVentes gv = new GestionVentes(user);
					gv.setVisible(true);
				}
			});
			
			btnVentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GestionVentes gv = new GestionVentes(user);
					gv.setVisible(true);
				}
			});
			


			
		}
	}
}
