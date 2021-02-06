package gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Driver;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField saisieId;
	private JPasswordField saisieMdp;
	private JTextField textField;
	private JPasswordField saisiePasswrd;
	private JPasswordField saisieVerif;

	private static JFrame frame;
	
	
	
	
	private static String protocole =  "jdbc:mysql:" ;
	private static String ip =  "localhost" ;  
	private static String port =  "3306" ;
	private static String nomBase =  "Gestion_Ventes" ; 
	private static String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
	private static String nomConnexion =  "root" ; 
	private static String motDePasse = "2021PasswordMySQL";
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	
	
	
	
	
	
	
	public static void main(String[] args) {
		try {
			Login dialog = new Login(frame, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
		
		
		

	/**
	 * Create the dialog.
	 */
	
	
	public Login() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel idlogin = new JLabel("Identifiant :");
			idlogin.setBounds(28, 103, 390, 16);
			idlogin.setFont(new Font("Helvetica", Font.PLAIN, 15));
			contentPanel.add(idlogin);
		}
		

		try {
	        Class c = Class.forName("com.mysql.jdbc.Driver") ;
	        Driver pilote = (Driver)c.newInstance() ;
	        DriverManager.registerDriver(pilote);
	        Connection con = DriverManager.getConnection(conString, nomConnexion, motDePasse) ;
			Statement myStmt = con.createStatement();

			//ResultSet myRs = myStmt.executeQuery("select * from Login");
			
			//while (myRs.next()) {
			//	System.out.println(myRs.getString("idLogin"));
			//	System.out.println(myRs.getString("mdpLogin"));
			//}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		saisieId = new JTextField();
		saisieId.setBounds(28, 118, 390, 26);
		contentPanel.add(saisieId);
		saisieId.setColumns(10);

		JLabel mdplogin = new JLabel("Mot de passe:");
		mdplogin.setBounds(28, 163, 390, 16);
		mdplogin.setFont(new Font("Helvetica", Font.PLAIN, 15));
		contentPanel.add(mdplogin);

		saisieMdp = new JPasswordField();
		saisieMdp.setBounds(28, 179, 390, 26);
		contentPanel.add(saisieMdp);


		JLabel bonjour = new JLabel("Bienvenue !");
		bonjour.setBounds(28, 29, 390, 42);
		bonjour.setHorizontalAlignment(JLabel.CENTER);
		bonjour.setFont(new Font("Helvetica", Font.BOLD, 18));
		contentPanel.add(bonjour);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
	}

	public Login(Frame owner, boolean modal) {
		super(owner, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel idlogin = new JLabel("Identifiant :");
			idlogin.setBounds(28, 103, 390, 16);
			idlogin.setFont(new Font("Helvetica", Font.PLAIN, 15));
			contentPanel.add(idlogin);
		}

		
		saisieId = new JTextField();
		saisieId.setBounds(28, 118, 390, 26);
		contentPanel.add(saisieId);
		saisieId.setColumns(10);

		JLabel mdplogin = new JLabel("Mot de passe:");
		mdplogin.setBounds(28, 163, 390, 16);
		mdplogin.setFont(new Font("Helvetica", Font.PLAIN, 15));
		contentPanel.add(mdplogin);

		saisieMdp = new JPasswordField();
		saisieMdp.setBounds(28, 179, 390, 26);
		contentPanel.add(saisieMdp);

		
		
		

		try {
	        Class c = Class.forName("com.mysql.jdbc.Driver") ;
	        Driver pilote = (Driver)c.newInstance() ;
	        DriverManager.registerDriver(pilote);
	        Connection con = DriverManager.getConnection(conString, nomConnexion, motDePasse) ;
			Statement myStmt = con.createStatement();

			//ResultSet myRs = myStmt.executeQuery("select * from Login");
			
			//4. Process the result set
			//while (myRs.next()) {
			//	System.out.println(myRs.getString("idLogin"));
			//	System.out.println(myRs.getString("mdpLogin"));
			//}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		JLabel bonjour = new JLabel("Bonjour !");
		bonjour.setBounds(28, 55, 390, 16);
		bonjour.setFont(new Font("Helvetica", Font.PLAIN, 18));
		bonjour.setHorizontalAlignment(JLabel.CENTER);
		contentPanel.add(bonjour);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String idEntree = saisieId.getText();
							String mdpEntree = saisieMdp.getText();
							String queryy= "SELECT idLogin, mdpLogin FROM Login;";
							String query = "SELECT statutLogin FROM Login WHERE idLogin =? AND mdpLogin = ? ;";
							Connection con = DriverManager.getConnection(conString, nomConnexion, motDePasse) ;
							PreparedStatement pstmt = con.prepareStatement(query);
							PreparedStatement pstmtt = con.prepareStatement(queryy);
							pstmt.setString(1, idEntree);
							pstmt.setString(2, mdpEntree);
							String acces =null;
							String check =null;
							String saved =null;
							int i = 0;
							ResultSet result = pstmt.executeQuery();
							ResultSet resultt = pstmtt.executeQuery();
							while (result.next()) {
								acces = result.getString("statutLogin");
								
							}
							while (resultt.next()) {
								check = resultt.getString("idLogin");
								saved = resultt.getString("mdpLogin");
								if(check.equals(idEntree) && saved.equals(mdpEntree)) {
									i=0;
									break;
								} else if (check.equals(idEntree)==false) {
									i=1;
								} else if (!check.equals(idEntree) && saved.equals(mdpEntree)) {
									i=1;
								} else if (!check.equals(idEntree) && !saved.equals(mdpEntree)) {
									i=1;
								}
							}
							
							if(i==0) {
								if (acces.equals("Admin")) {
									AffichageVentes aff = new AffichageVentes();
									aff.setVisible(true);
									setVisible(false);
								} else if (acces.equals("User")) {
									GestionVentes ppal = new GestionVentes();
									ppal.setVisible(true);
									setVisible(false);
								}
							} else
							JOptionPane.showMessageDialog(new Login(), "Identifiant et/ou mot de passe incorrect(s)", "Nous ne vous trouvons pas", JOptionPane.INFORMATION_MESSAGE);
							
						} catch (SQLException ex){
							
							System.err.println("Ooops:SQL : " +ex.getErrorCode() + "/" +ex.getMessage());
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.setFont(new Font("Helvetica", Font.PLAIN, 15));
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
				cancelButton.setFont(new Font("Helvetica", Font.PLAIN, 15));
				buttonPane.add(cancelButton);
			}
		}
	}

	
}
