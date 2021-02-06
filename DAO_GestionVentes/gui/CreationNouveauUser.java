package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreationNouveauUser extends JInternalFrame {

	private CreationNouveauUser frame;
	private JTextField saisieId;
	private JPasswordField saisieMdp;
	private JTextField textField;
	private JPasswordField saisiePasswrd;
	private JPasswordField saisieVerif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationNouveauUser frame = new CreationNouveauUser();
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
	public CreationNouveauUser() {
		setBounds(0, 0, 450, 301);
		getContentPane().setLayout(null);
		
		JLabel identifiant = new JLabel("Saisir votre Identifiant");
		identifiant.setBounds(22, 49, 157, 16);
		getContentPane().add(identifiant);
		
		textField = new JTextField();
		textField.setBounds(189, 44, 209, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		saisiePasswrd = new JPasswordField();
		saisiePasswrd.setBounds(189, 120, 209, 26);
		getContentPane().add(saisiePasswrd);
		
		saisieVerif = new JPasswordField();
		saisieVerif.setBounds(189, 170, 209, 26);
		getContentPane().add(saisieVerif);
		
		JLabel Password = new JLabel("Saisir votre password");
		Password.setBounds(22, 125, 157, 16);
		getContentPane().add(Password);
		
		JLabel Verif = new JLabel("Re-saisir votre password");
		Verif.setBounds(22, 175, 157, 16);
		getContentPane().add(Verif);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(158, 220, 117, 29);
		getContentPane().add(btnNewButton);
		
		JLabel titre = new JLabel("CREATION NOUVEL UTILISATEUR");
		titre.setBounds(22, 6, 376, 16);
		getContentPane().add(titre);
		
		JButton abort = new JButton("X");
		abort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
			}
		});
		abort.setBounds(369, 220, 29, 29);
		getContentPane().add(abort);

	}

}
