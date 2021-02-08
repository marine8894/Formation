package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Driver;

import Connexion.connexion;
import Entities.User;
import dao.daoUser;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class NouvelUtilisateur extends JDialog {

	private final JPanel contentPanel = new JPanel();


	private JPasswordField saisieMdp;
	private JTextField textField;
	private JPasswordField saisiePasswrd;
	private JPasswordField saisieVerif;
	private daoUser daoUser;
	static Connection myConnection;
	private User userAModif;

	private static JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NouvelUtilisateur dialog = new NouvelUtilisateur(frame, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NouvelUtilisateur() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setBounds(0, 233, 450, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setToolTipText("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setToolTipText("Annuler");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel identifiant = new JLabel("Saisir l'identifiant :");
		identifiant.setForeground(Color.WHITE);
		identifiant.setBounds(22, 62, 157, 16);
		identifiant.setFont(new Font("Helvetica", Font.PLAIN, 15));
		getContentPane().add(identifiant);
		
		textField = new JTextField();
		textField.setToolTipText("Saisir l'identifiant");
		textField.setBounds(209, 56, 209, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		saisiePasswrd = new JPasswordField();
		saisiePasswrd.setToolTipText("Saisir le mot de passe");
		saisiePasswrd.setBounds(209, 98, 209, 26);
		getContentPane().add(saisiePasswrd);
		
		saisieVerif = new JPasswordField();
		saisieVerif.setToolTipText("Re-saisir le mot de passe");
		saisieVerif.setBounds(209, 145, 209, 26);
		getContentPane().add(saisieVerif);
		
		JLabel Password = new JLabel("Saisir le password");
		Password.setForeground(Color.WHITE);
		Password.setFont(new Font("Helvetica", Font.PLAIN, 15));
		Password.setBounds(22, 108, 157, 16);
		getContentPane().add(Password);
		
		JLabel Verif = new JLabel("Re-saisir le password :");
		Verif.setForeground(Color.WHITE);
		Verif.setFont(new Font("Helvetica", Font.PLAIN, 15));
		Verif.setBounds(22, 151, 185, 16);
		getContentPane().add(Verif);
		
		JLabel titre = new JLabel("CREATION D'UN NOUVEL UTILISATEUR");
		titre.setForeground(Color.WHITE);
		titre.setFont(new Font("Helvetica", Font.PLAIN, 18));
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setBounds(65, 20, 353, 26);
		getContentPane().add(titre);
		
		JLabel saisieDroitsAcces = new JLabel("Attribuer un droit d'accès");
		saisieDroitsAcces.setForeground(Color.WHITE);
		saisieDroitsAcces.setFont(new Font("Helvetica", Font.PLAIN, 15));
		saisieDroitsAcces.setBounds(22, 199, 185, 16);
		getContentPane().add(saisieDroitsAcces);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Sélectionner un droit d'accès");
		comboBox.setBounds(209, 194, 209, 27);
		getContentPane().add(comboBox);
		

		
	}

	public NouvelUtilisateur(Frame owner, boolean modal) {
		//super(owner, modal);
		
		// TODO Auto-generated constructor stub
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel identifiant = new JLabel("Saisir l'identifiant :");
			identifiant.setForeground(Color.WHITE);
			identifiant.setBounds(22, 62, 157, 16);
			identifiant.setFont(new Font("Helvetica", Font.PLAIN, 15));
			getContentPane().add(identifiant);
			
			textField = new JTextField();
			textField.setToolTipText("Saisir l'identifiant");
			textField.setBounds(209, 56, 209, 26);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			saisiePasswrd = new JPasswordField();
			saisiePasswrd.setToolTipText("Saisir le mot de passe");
			saisiePasswrd.setBounds(209, 98, 209, 26);
			getContentPane().add(saisiePasswrd);
			
			saisieVerif = new JPasswordField();
			saisieVerif.setToolTipText("Re-saisir le mot de passe");
			saisieVerif.setBounds(209, 145, 209, 26);
			getContentPane().add(saisieVerif);
			
			JLabel Password = new JLabel("Saisir le password");
			Password.setForeground(Color.WHITE);
			Password.setFont(new Font("Helvetica", Font.PLAIN, 15));
			Password.setBounds(22, 108, 157, 16);
			getContentPane().add(Password);
			
			JLabel Verif = new JLabel("Re-saisir le password :");
			Verif.setForeground(Color.WHITE);
			Verif.setFont(new Font("Helvetica", Font.PLAIN, 15));
			Verif.setBounds(22, 151, 185, 16);
			getContentPane().add(Verif);
			
			JLabel titre = new JLabel("CREATION D'UN NOUVEL UTILISATEUR");
			titre.setForeground(Color.WHITE);
			titre.setFont(new Font("Helvetica", Font.PLAIN, 18));
			titre.setHorizontalAlignment(JLabel.CENTER);
			titre.setBounds(65, 20, 353, 26);
			getContentPane().add(titre);
			
			JLabel saisieDroitsAcces = new JLabel("Attribuer un droit d'accès");
			saisieDroitsAcces.setForeground(Color.WHITE);
			saisieDroitsAcces.setFont(new Font("Helvetica", Font.PLAIN, 15));
			saisieDroitsAcces.setBounds(22, 199, 185, 16);
			getContentPane().add(saisieDroitsAcces);
			

			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(NouvelUtilisateur.class.getResource("/icons/add-friend.png")));
			lblNewLabel.setBounds(36, 10, 32, 35);
			getContentPane().add(lblNewLabel);
			
			
			
			DefaultComboBoxModel<String> modelAcces = new DefaultComboBoxModel<String>();
			try {
		        myConnection = connexion.getInstance();
				Statement myStmt = myConnection.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from DroitAcces");
				while (myRs.next()) {
					modelAcces.addElement(myRs.getString("Access"));
				}	
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			JComboBox comboBox = new JComboBox(modelAcces);
			comboBox.setBounds(209, 194, 209, 27);
			getContentPane().add(comboBox);
			
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setBounds(0, 233, 450, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String userssname = textField.getText();
						String password = saisiePasswrd.getText();
						String access = comboBox.getSelectedItem().toString();
						if(saisiePasswrd.getText().equals(saisieVerif.getText())){
							User x = new User(userssname, password, access);
							daoUser recupUser = new daoUser();
							try {
								recupUser.addUser(x);
								JOptionPane.showMessageDialog(new NouvelUtilisateur(), "Création de compte réalisée avec succès", "BIENVENUE", JOptionPane.INFORMATION_MESSAGE);
								ListeUtilisateurs lu = new ListeUtilisateurs();
								lu.setVisible(true);
								setVisible(false);
							} catch (SQLIntegrityConstraintViolationException ez) {
								JOptionPane.showMessageDialog(new NouvelUtilisateur(), "Cet identifiant est déjà utilisé", "Oops ! Trop tard !", JOptionPane.INFORMATION_MESSAGE);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else {
							JOptionPane.showMessageDialog(new NouvelUtilisateur(), "Les mots de passe saisis ne sont pas identiques", "Erreur Mot de Passe", JOptionPane.CANCEL_OPTION);
						}
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	
	public NouvelUtilisateur (Frame owner, boolean modal, User user) {

		this.userAModif = user;
		
		int i = user.getIdUser();
		
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel identifiant = new JLabel("Saisir l'identifiant :");
			identifiant.setForeground(Color.WHITE);
			identifiant.setBounds(22, 62, 157, 16);
			identifiant.setFont(new Font("Helvetica", Font.PLAIN, 15));
			getContentPane().add(identifiant);
			
			textField = new JTextField();
			textField.setBounds(209, 56, 209, 26);
			getContentPane().add(textField);
			textField.setColumns(10);
			textField.setText(user.getUserName());
			
			JTextField saisiePasswrd = new JTextField();
			saisiePasswrd.setBounds(209, 98, 209, 26);
			getContentPane().add(saisiePasswrd);
			saisiePasswrd.setText(user.getPassword());
			
			JTextField saisieVerif = new JTextField();
			saisieVerif.setBounds(209, 145, 209, 26);
			getContentPane().add(saisieVerif);
			saisieVerif.setText(user.getPassword());
			
			JLabel Password = new JLabel("Saisir le password :");
			Password.setForeground(Color.WHITE);
			Password.setFont(new Font("Helvetica", Font.PLAIN, 15));
			Password.setBounds(22, 108, 157, 16);
			getContentPane().add(Password);
			
			JLabel Verif = new JLabel("Re-saisir le password :");
			Verif.setForeground(Color.WHITE);
			Verif.setFont(new Font("Helvetica", Font.PLAIN, 15));
			Verif.setBounds(22, 151, 185, 16);
			getContentPane().add(Verif);
			
			JLabel titre = new JLabel("MODIFICATION D'UN UTILISATEUR");
			titre.setForeground(Color.WHITE);
			titre.setFont(new Font("Helvetica", Font.PLAIN, 18));
			titre.setHorizontalAlignment(JLabel.CENTER);
			titre.setBounds(65, 20, 353, 26);
			getContentPane().add(titre);
			
			JLabel saisieDroitsAcces = new JLabel("Attribuez un droit d'accès");
			saisieDroitsAcces.setForeground(Color.WHITE);
			saisieDroitsAcces.setFont(new Font("Helvetica", Font.PLAIN, 15));
			saisieDroitsAcces.setBounds(22, 199, 185, 16);
			getContentPane().add(saisieDroitsAcces);
			
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(NouvelUtilisateur.class.getResource("/icons/management.png")));
			lblNewLabel.setBounds(36, 10, 32, 35);
			getContentPane().add(lblNewLabel);
			
			
			DefaultComboBoxModel<String> modelAcces = new DefaultComboBoxModel<String>();
			try {
		        myConnection = connexion.getInstance();
				Statement myStmt = myConnection.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from DroitAcces");
				while (myRs.next()) {
					modelAcces.addElement(myRs.getString("Access"));
				}	
			} catch (Exception exc) {
				exc.printStackTrace();
			}
			JComboBox comboBox = new JComboBox(modelAcces);
			comboBox.setBounds(209, 194, 209, 27);
			getContentPane().add(comboBox);
			comboBox.setSelectedItem(user.getAccess());
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setBounds(0, 233, 450, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String userssname = textField.getText();
						String password = saisiePasswrd.getText();
						String access = comboBox.getSelectedItem().toString();
						User x = new User(i, userssname, password, access);
						daoUser recupUser = new daoUser();
						if(saisiePasswrd.getText().equals(saisieVerif.getText())){
							try {
								recupUser.modifyUser(x);
								System.out.println(x);
								JOptionPane.showMessageDialog(null, "Modification de compte réalisée avec succès", "BIENVENUE", JOptionPane.INFORMATION_MESSAGE);
								ListeUtilisateurs lu = new ListeUtilisateurs();
								lu.setVisible(true);
								setVisible(false);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "Les mots de passe saisis ne sont pas identiques", "Erreur Mot de Passe", JOptionPane.CANCEL_OPTION);
						}
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

		}
	}
}
