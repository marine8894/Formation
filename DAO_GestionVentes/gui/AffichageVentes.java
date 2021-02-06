package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Driver;

import dao.daoCommand;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AffichageVentes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object[][] donnees = {{"", "", "", ""}};
	private JTextField textField;
	private Vector <Vector> contenu = new Vector <Vector>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AffichageVentes frame = new AffichageVentes();
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public AffichageVentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel titre = new JLabel("Recherche de commandes");
		titre.setForeground(Color.WHITE);
		titre.setFont(new Font("Helvetica", Font.BOLD, 30));
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setBounds(47, 20, 700, 27);
		contentPane.add(titre);
		
		JLabel labelSaisie = new JLabel("Commande trouvée :");
		labelSaisie.setForeground(Color.WHITE);
		labelSaisie.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		labelSaisie.setBounds(48, 161, 477, 16);
		contentPane.add(labelSaisie);
	
		Vector entetes = new Vector();
		entetes.add("Num de commande");
		entetes.add("Ligne de commande");
		entetes.add("Libellé produits");
		entetes.add("Prix unitaire") ;
		entetes.add("Quantite");
		entetes.add("Date de la commande");
				
		textField = new JTextField();
		textField.setToolTipText("Saisir le numéro de commande");
		textField.setBounds(47, 104, 442, 29);
		contentPane.add(textField);
		textField.setColumns(10);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Affichage des commandes trouvées");
		scrollPane.setBounds(47, 189, 700, 255);
		contentPane.add(scrollPane);
				
				
			
			JButton Afficher = new JButton("Rechercher");
			Afficher.setToolTipText("Rechercher");
			Afficher.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
			Afficher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {

					    String idCommand = textField.getText();
					    daoCommand daoCmd = new daoCommand();
					    contenu = daoCmd.checkCommand(idCommand);
					    table = new JTable(contenu, entetes);
						scrollPane.setViewportView(table);
						table.setRowSelectionAllowed(false);
				
					} catch (Exception exc) {
						exc.printStackTrace();
					}
			
				
				}	
			});
			Afficher.setBounds(508, 104, 239, 29);
			contentPane.add(Afficher);
			
			JButton nouvelleCommande = new JButton("Quitter");
			nouvelleCommande.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
			nouvelleCommande.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			nouvelleCommande.setBounds(639, 475, 108, 29);
			contentPane.add(nouvelleCommande);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(AffichageVentes.class.getResource("/icons/box (1).png")));
			lblNewLabel.setBounds(161, 6, 37, 52);
			contentPane.add(lblNewLabel);
		
	}
}
