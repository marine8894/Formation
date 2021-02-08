package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import Entities.User;
import dao.daoUser;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Acceuil extends JDialog {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil frame = new Acceuil();
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
	public Acceuil() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(Acceuil.class.getResource("/icons/locked (1).png")));
		lblNewLabel.setBounds(26, 6, 397, 56);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(134, 87, 272, 38);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(134, 153, 272, 38);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Identifiant");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 87, 115, 38);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mot de passe");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(23, 152, 115, 38);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String mdp = passwordField.getText();
				User user = null;
				daoUser daoUser = new daoUser();
				try {
					user = daoUser.identification(id, mdp);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "Petit probleme...", JOptionPane.INFORMATION_MESSAGE);
					e1.printStackTrace();
				}
				
				if(user.getUserName()==null) {
					JOptionPane.showMessageDialog(new Acceuil(), "L'identifiant et/ou le mot de passe sont erronnés.\nVeuillez réessayer !", "Petit probleme...", JOptionPane.INFORMATION_MESSAGE);
				} else if (user.getPassword() == null) {
					JOptionPane.showMessageDialog(null, "Mot de passe incorrect", "Petit probleme...", JOptionPane.INFORMATION_MESSAGE);
				} else {
					Home home = new Home (user);
					home.setVisible(true);
					setVisible(false);
				}
				
				
			}
		});
		btnConnexion.setForeground(Color.DARK_GRAY);
		btnConnexion.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		btnConnexion.setBounds(134, 222, 272, 38);
		getContentPane().add(btnConnexion);

	}
}
