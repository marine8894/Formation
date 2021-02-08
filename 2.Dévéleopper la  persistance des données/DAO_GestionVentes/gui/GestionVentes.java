package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.mysql.jdbc.Driver;

import Entities.User;
import dao.daoCommand;
import dao.daoCommandLine;
import dao.daoProduct;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class GestionVentes extends JFrame {

	private JFrame frame;
	protected double total = 00.00;
	protected String recapitul = "";
	protected DecimalFormat df = new DecimalFormat("##.##");
	protected double resultat;
	//protected String [] tab = { "cahier bleu", "cahier blanc", "stylo rouge", "stylo vert", "effaceur", "crayon à papier", "gomme"} ;
	protected double totalActuel;
	protected String strQte;
	protected String strPrix;
	protected boolean check;
	private JTable table;
	private double totalprice = 0;
	private JTable table_1;
	private double quantitetotale;
	private double prixTotale;
	private int quantity = 0;
	private User userATraiter;
	
	//protected Date DATRCP =(Date) new GregorianCalendar(Locale.getDefault()).getTime(); ;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionVentes window = new GestionVentes();
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
	public GestionVentes() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		initialize();

		
	}

	
	public GestionVentes(User user) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		initialize(user);

		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JPanel panelSelection = new JPanel();
		panelSelection.setForeground(new Color(0, 0, 0));
		panelSelection.setBounds(21, 78, 239, 371);
		panelSelection.setBackground(Color.GRAY);
		frame.getContentPane().add(panelSelection);
		panelSelection.setLayout(null);
		
		
		JLabel saisiePrix = new JLabel();
		saisiePrix.setForeground(new Color(255, 255, 255));
		saisiePrix.setBounds(15, 166, 205, 35);
		saisiePrix.setFont(new Font("Helvetica", Font.PLAIN, 16));
		panelSelection.add(saisiePrix);
		
		DefaultComboBoxModel<Vector> modelProduits = new DefaultComboBoxModel<Vector>();
		daoProduct product = new daoProduct();
		try {
			modelProduits.addAll(product.checkProduct());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		JComboBox comboBox = new JComboBox(modelProduits);
		comboBox.setForeground(new Color(0, 0, 0));
		
		comboBox.setLocation(6, 53);
		comboBox.setSize(227,27);
		comboBox.setFont(new Font("Helvetica", Font.PLAIN, 16));
		panelSelection.add(comboBox);

		
		JTextField saisieQuantite = new JTextField();
		saisieQuantite.setBounds(6, 288, 227, 44);
		saisieQuantite.setFont(new Font("Helvetica", Font.PLAIN, 16));
		panelSelection.add(saisieQuantite);
		
		JLabel choixproduit = new JLabel("Choisir le produit");
		choixproduit.setForeground(new Color(255, 255, 255));
		choixproduit.setBounds(12, 33, 215, 16);
		choixproduit.setFont(new Font("Helvetica", Font.PLAIN, 16));
		panelSelection.add(choixproduit);
		
		JLabel prixunitaire = new JLabel("Prix unitaire");
		prixunitaire.setForeground(new Color(255, 255, 255));
		prixunitaire.setFont(new Font("Helvetica", Font.PLAIN, 16));
		prixunitaire.setBounds(12, 149, 215, 16);
		panelSelection.add(prixunitaire);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoCommandLine product = new daoCommandLine();
				try {
					String produit = comboBox.getSelectedItem().toString();
					saisiePrix.setText(product.getPrice(produit));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel nombre = new JLabel("Entrer la quantité");
		nombre.setForeground(new Color(255, 255, 255));
		nombre.setFont(new Font("Helvetica", Font.PLAIN, 16));
		nombre.setBounds(12, 273, 215, 16);
		panelSelection.add(nombre);

		
		
		JPanel panelListes = new JPanel();
		panelListes.setBounds(284, 78, 495, 371);
		panelListes.setBackground(new Color(245, 245, 245));
		frame.getContentPane().add(panelListes);
		panelListes.setLayout(null);
		
		
		JLabel listeachat = new JLabel("Liste d'achat");
		listeachat.setForeground(new Color(105, 105, 105));
		listeachat.setHorizontalAlignment(JLabel.CENTER);
		listeachat.setFont(new Font("Helvetica", Font.PLAIN, 20));
		listeachat.setBounds(27, 16, 444, 21);
		panelListes.add(listeachat);
		
		
		JTextPane result = new JTextPane();
		result.setForeground(new Color(165, 42, 42));
		result.setBounds(339, 318, 132, 32);
		result.setFont(new Font("Helvetica", Font.PLAIN, 16));
		result.setBackground(new Color(245, 245, 245));
		panelListes.add(result);
		
		
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.DARK_GRAY);
		panelTop.setBounds(16, 6, 764, 56);
		frame.getContentPane().add(panelTop);
		panelTop.setLayout(null);
		
		JLabel titre = new JLabel("COMMANDE");
		titre.setBounds(291, 19, 179, 31);
		titre.setForeground(Color.WHITE);
		titre.setFont(new Font("Helvetica", Font.PLAIN, 30));
		panelTop.add(titre);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GestionVentes.class.getResource("/icons/shopping-cart (1).png")));
		lblNewLabel.setBounds(247, 6, 61, 44);
		panelTop.add(lblNewLabel);
		
		

		Vector <String> nomsCol = new Vector();
		nomsCol.add("Produit");
		nomsCol.add("Quantite");
		nomsCol.add("Prix");
		
		Vector <Vector> contenant = new Vector<Vector>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 60, 444, 244);
		panelListes.add(scrollPane);
		
		table = new JTable(contenant, nomsCol);
		scrollPane.setViewportView(table);
		

		
		
		
		JPanel panelBoutons = new JPanel();
		panelBoutons.setBounds(16, 472, 764, 41);
		panelBoutons.setBackground(Color.DARK_GRAY);
		//panelBoutons.setBorder(BorderFactory.createLineBorder(Color.black,1));
		frame.getContentPane().add(panelBoutons);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBounds(2, 0, 152, 41);
		ajouter.setFont(new Font("Helvetica", Font.PLAIN, 15));
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (saisiePrix.getText().equals("0") || saisieQuantite.getText().equals("0") || saisieQuantite.getText().isEmpty() || saisiePrix.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Le champ ne peut être vide", "Erreur : saisie", JOptionPane.INFORMATION_MESSAGE);
				} else {
				
					Pattern p = Pattern.compile("[0-9]*\\.?[0-9]*|[0-9]*\\,?[0-9]*");
					Matcher m = p.matcher(saisiePrix.getText());
					Matcher n = p.matcher(saisieQuantite.getText());
					boolean b = m.matches();
					boolean c = n.matches();
					
					
					if(b && c) {

						table = new JTable(contenant, nomsCol);
						scrollPane.setViewportView(table);
						
						Vector <String> contenu = new Vector<String>();
						
						
						for(int i = 0;i<table.getModel().getRowCount();i++)
						{
							
							if(comboBox.getSelectedItem().toString().equals(table.getModel().getValueAt(i,0))) {//on parcourt a la recherche d'un identique
                                String quantiteDejaLa = (String) table.getModel().getValueAt(i, 1);//on recupere le montant de l'identique
                                quantitetotale = Double.parseDouble(quantiteDejaLa);
                                String prixDejaLa = (String) table.getModel().getValueAt(i, 2);
                                prixTotale = Double.parseDouble(prixDejaLa);
                                contenant.remove(i);
                               }  
						}
						contenu.addElement(comboBox.getSelectedItem().toString());
						
						double quantite = Double.parseDouble(saisieQuantite.getText());
						double quantiteTotal = quantite + quantitetotale;
						contenu.addElement(df.format(quantiteTotal));
						double prix = Double.parseDouble(saisiePrix.getText());
						double totall = quantite * prix;
						String resulttotal = String.valueOf(totall);
						contenu.addElement(df.format(totall + prixTotale));
						contenant.add(contenu);
						prixTotale = 0;
						quantitetotale = 0;
						
						totalprice = totalprice + totall;
						result.setText("Total : " + df.format(totalprice));
						
						quantity = (int) (quantity + quantite);
							
	
					} else {
						JOptionPane.showMessageDialog(null, "Veuillez saisir des chiffres valides", "Erreur : saisie", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
			}
		});
		panelBoutons.setLayout(null);
		ajouter.setFont(new Font("Helvetica", Font.PLAIN, 12));
		panelBoutons.add(ajouter);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.setBounds(154, 0, 152, 41);
		panelBoutons.add(supprimer);
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				String montantARemove = (String) table.getModel().getValueAt(index, 2);
				double montantASuppr = Double.parseDouble(montantARemove);
				contenant.remove(index);
				
				String quantiteARemove = (String) table.getModel().getValueAt(index, 1);
				int quantiteASuppr = Integer.parseInt(quantiteARemove);
				quantity = quantity - quantiteASuppr;
				
				totalprice = totalprice - montantASuppr;
				result.setText("Total : " + df.format(totalprice));

				
			}
		});
		supprimer.setFont(new Font("Helvetica", Font.PLAIN, 12));
		
		JButton effacer = new JButton("Effacer");
		effacer.setBounds(306, 0, 152, 41);
		effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contenant.removeAllElements();
				result.setText("");
				saisieQuantite.setText("");
				saisiePrix.setText("");
			}
		});
		effacer.setFont(new Font("Helvetica", Font.PLAIN, 12));
		panelBoutons.add(effacer);
		
		JButton valider = new JButton("Valider");
		valider.setBounds(458, 0, 152, 41);
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoCommand commande = new daoCommand();
				daoCommandLine commandeLigne = new daoCommandLine();
				double totalPrice = totalprice;
				
				ArrayList <String> arrayQuantite = new ArrayList<String>();
				ArrayList <String> arrayProducts = new ArrayList<String>();
				for (int i = 0; i <table.getModel().getRowCount(); i++) {
					arrayProducts.add((String) table.getModel().getValueAt(i, 0));
					arrayQuantite.add((String) table.getModel().getValueAt(i, 1));
				}
				
				if (arrayQuantite.size()>0 && arrayProducts.size()>0) {
				
					try {
						commandeLigne.addCmdLine(arrayProducts, arrayQuantite);
						commande.addCommand(totalPrice, quantity);
						int resultat = JOptionPane.showConfirmDialog(null,  "Commande validé ! Souhaitez-vous en effectuer une autre ?", "C'est parti !", JOptionPane.YES_NO_OPTION);
						if(resultat==JOptionPane.NO_OPTION) {
							frame.setVisible(false);
						} else {
							contenant.removeAllElements();
							result.setText("");
							saisieQuantite.setText("");
							saisiePrix.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null, "Le panier ne peut être vide", "Le panier est vide...", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		valider.setFont(new Font("Helvetica", Font.PLAIN, 12));
		panelBoutons.add(valider);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AffichageVentes rechercheCmde = new AffichageVentes();
				rechercheCmde.setVisible(true);
				setVisible(false);
			}
		});
		btnRechercher.setBounds(612, 0, 152, 41);
		panelBoutons.add(btnRechercher);
		btnRechercher.setFont(new Font("Helvetica", Font.PLAIN, 12));
		}
	
private void initialize(User user) {
		
		JPanel panelSelection = new JPanel();
		panelSelection.setForeground(new Color(0, 0, 0));
		panelSelection.setBounds(21, 78, 239, 371);
		panelSelection.setBackground(Color.GRAY);
		frame.getContentPane().add(panelSelection);
		panelSelection.setLayout(null);
		
		
		JLabel saisiePrix = new JLabel();
		saisiePrix.setForeground(new Color(255, 255, 255));
		saisiePrix.setBounds(15, 166, 205, 35);
		saisiePrix.setFont(new Font("Helvetica", Font.PLAIN, 16));
		panelSelection.add(saisiePrix);
		
		DefaultComboBoxModel<Vector> modelProduits = new DefaultComboBoxModel<Vector>();
		daoProduct product = new daoProduct();
		try {
			modelProduits.addAll(product.checkProduct());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		JComboBox comboBox = new JComboBox(modelProduits);
		comboBox.setForeground(new Color(0, 0, 0));
		
		comboBox.setLocation(6, 53);
		comboBox.setSize(227,27);
		comboBox.setFont(new Font("Helvetica", Font.PLAIN, 16));
		panelSelection.add(comboBox);

		
		JTextField saisieQuantite = new JTextField();
		saisieQuantite.setBounds(6, 288, 227, 44);
		saisieQuantite.setFont(new Font("Helvetica", Font.PLAIN, 16));
		panelSelection.add(saisieQuantite);
		
		JLabel choixproduit = new JLabel("Choisir le produit");
		choixproduit.setForeground(new Color(255, 255, 255));
		choixproduit.setBounds(12, 33, 215, 16);
		choixproduit.setFont(new Font("Helvetica", Font.PLAIN, 16));
		panelSelection.add(choixproduit);
		
		JLabel prixunitaire = new JLabel("Prix unitaire");
		prixunitaire.setForeground(new Color(255, 255, 255));
		prixunitaire.setFont(new Font("Helvetica", Font.PLAIN, 16));
		prixunitaire.setBounds(12, 149, 215, 16);
		panelSelection.add(prixunitaire);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoCommandLine product = new daoCommandLine();
				try {
					String produit = comboBox.getSelectedItem().toString();
					saisiePrix.setText(product.getPrice(produit));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel nombre = new JLabel("Entrer la quantité");
		nombre.setForeground(new Color(255, 255, 255));
		nombre.setFont(new Font("Helvetica", Font.PLAIN, 16));
		nombre.setBounds(12, 273, 215, 16);
		panelSelection.add(nombre);

		
		
		JPanel panelListes = new JPanel();
		panelListes.setBounds(284, 78, 495, 371);
		panelListes.setBackground(new Color(245, 245, 245));
		frame.getContentPane().add(panelListes);
		panelListes.setLayout(null);
		
		
		JLabel listeachat = new JLabel("Liste d'achat");
		listeachat.setForeground(new Color(105, 105, 105));
		listeachat.setHorizontalAlignment(JLabel.CENTER);
		listeachat.setFont(new Font("Helvetica", Font.PLAIN, 20));
		listeachat.setBounds(27, 16, 444, 21);
		panelListes.add(listeachat);
		
		
		JTextPane result = new JTextPane();
		result.setForeground(new Color(165, 42, 42));
		result.setBounds(339, 318, 132, 32);
		result.setFont(new Font("Helvetica", Font.PLAIN, 16));
		result.setBackground(new Color(245, 245, 245));
		panelListes.add(result);
		
		
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.DARK_GRAY);
		panelTop.setBounds(16, 6, 764, 56);
		frame.getContentPane().add(panelTop);
		panelTop.setLayout(null);
		
		JLabel titre = new JLabel("COMMANDE");
		titre.setBounds(291, 19, 179, 31);
		titre.setForeground(Color.WHITE);
		titre.setFont(new Font("Helvetica", Font.PLAIN, 30));
		panelTop.add(titre);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GestionVentes.class.getResource("/icons/shopping-cart (1).png")));
		lblNewLabel.setBounds(247, 6, 61, 44);
		panelTop.add(lblNewLabel);
		
		
		

		Vector <String> nomsCol = new Vector();
		nomsCol.add("Produit");
		nomsCol.add("Quantite");
		nomsCol.add("Prix");
		
		Vector <Vector> contenant = new Vector<Vector>();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 60, 444, 244);
		panelListes.add(scrollPane);
		
		table = new JTable(contenant, nomsCol);
		scrollPane.setViewportView(table);
		
		
		
		
		
		JPanel panelBoutons = new JPanel();
		panelBoutons.setBounds(16, 472, 764, 41);
		panelBoutons.setBackground(Color.DARK_GRAY);
		//panelBoutons.setBorder(BorderFactory.createLineBorder(Color.black,1));
		frame.getContentPane().add(panelBoutons);
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.setBounds(2, 0, 152, 41);
		ajouter.setFont(new Font("Helvetica", Font.PLAIN, 15));
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (saisiePrix.getText().equals("0") || saisieQuantite.getText().equals("0") || saisieQuantite.getText().isEmpty() || saisiePrix.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Le champ ne peut être vide", "Erreur : saisie", JOptionPane.INFORMATION_MESSAGE);
				} else {
				
					Pattern p = Pattern.compile("[0-9]*\\.?[0-9]*|[0-9]*\\,?[0-9]*");
					Matcher m = p.matcher(saisiePrix.getText());
					Matcher n = p.matcher(saisieQuantite.getText());
					boolean b = m.matches();
					boolean c = n.matches();
					
					
					if(b && c) {

						table = new JTable(contenant, nomsCol);
						scrollPane.setViewportView(table);
						
						Vector <String> contenu = new Vector<String>();
						
						
						for(int i = 0;i<table.getModel().getRowCount();i++)
						{
							
							if(comboBox.getSelectedItem().toString().equals(table.getModel().getValueAt(i,0))) {//on parcourt a la recherche d'un identique
                                String quantiteDejaLa = (String) table.getModel().getValueAt(i, 1);//on recupere le montant de l'identique
                                quantitetotale = Double.parseDouble(quantiteDejaLa);
                                String prixDejaLa = (String) table.getModel().getValueAt(i, 2);
                                prixTotale = Double.parseDouble(prixDejaLa);
                                contenant.remove(i);
                               }  
						}
						contenu.addElement(comboBox.getSelectedItem().toString());
						
						double quantite = Double.parseDouble(saisieQuantite.getText());
						double quantiteTotal = quantite + quantitetotale;
						contenu.addElement(df.format(quantiteTotal));
						double prix = Double.parseDouble(saisiePrix.getText());
						double totall = quantite * prix;
						String resulttotal = String.valueOf(totall);
						contenu.addElement(df.format(totall + prixTotale));
						contenant.add(contenu);
						prixTotale = 0;
						quantitetotale = 0;
						
						totalprice = totalprice + totall;
						result.setText("Total : " + df.format(totalprice));
						
						quantity = (int) (quantity + quantite);
							
	
					} else {
						JOptionPane.showMessageDialog(null, "Veuillez saisir des chiffres valides", "Erreur : saisie", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
			}
		});
		panelBoutons.setLayout(null);
		ajouter.setFont(new Font("Helvetica", Font.PLAIN, 12));
		panelBoutons.add(ajouter);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.setBounds(154, 0, 152, 41);
		panelBoutons.add(supprimer);
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				String montantARemove = (String) table.getModel().getValueAt(index, 2);
				double montantASuppr = Double.parseDouble(montantARemove);
				contenant.remove(index);
				
				String quantiteARemove = (String) table.getModel().getValueAt(index, 1);
				int quantiteASuppr = Integer.parseInt(quantiteARemove);
				quantity = quantity - quantiteASuppr;
				
				totalprice = totalprice - montantASuppr;
				result.setText("Total : " + df.format(totalprice));

				
			}
		});
		supprimer.setFont(new Font("Helvetica", Font.PLAIN, 12));
		
		JButton effacer = new JButton("Effacer");
		effacer.setBounds(306, 0, 152, 41);
		effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contenant.removeAllElements();
				result.setText("");
				saisieQuantite.setText("");
				saisiePrix.setText("");
			}
		});
		effacer.setFont(new Font("Helvetica", Font.PLAIN, 12));
		panelBoutons.add(effacer);
		
		JButton valider = new JButton("Valider");
		
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoCommand commande = new daoCommand();
				daoCommandLine commandeLigne = new daoCommandLine();
				double totalPrice = totalprice;
				
				ArrayList <String> arrayQuantite = new ArrayList<String>();
				ArrayList <String> arrayProducts = new ArrayList<String>();
				for (int i = 0; i <table.getModel().getRowCount(); i++) {
					arrayProducts.add((String) table.getModel().getValueAt(i, 0));
					arrayQuantite.add((String) table.getModel().getValueAt(i, 1));
				}

				if (arrayQuantite.size()>0 && arrayProducts.size()>0) {
					
					try {
						commandeLigne.addCmdLine(arrayProducts, arrayQuantite);
						commande.addCommand(totalPrice, quantity);
						int resultat = JOptionPane.showConfirmDialog(null,  "Commande validé ! Souhaitez-vous en effectuer une autre ?", "C'est parti !", JOptionPane.YES_NO_OPTION);
						if(resultat==JOptionPane.NO_OPTION) {
							frame.setVisible(false);
						} else {
							contenant.removeAllElements();
							result.setText("");
							saisieQuantite.setText("");
							saisiePrix.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null, "Le panier ne peut être vide", "Le panier est vide...", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		valider.setFont(new Font("Helvetica", Font.PLAIN, 12));
		panelBoutons.add(valider);
		
		
		this.userATraiter = user;
		if (user.getAccess().equals("Admin")) {
			
			valider.setBounds(458, 0, 152, 41);
			
			JButton btnRechercher = new JButton("Rechercher");
			btnRechercher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AffichageVentes rechercheCmde = new AffichageVentes();
					rechercheCmde.setVisible(true);
					setVisible(false);
				}
			});
			btnRechercher.setBounds(612, 0, 152, 41);
			panelBoutons.add(btnRechercher);
			btnRechercher.setFont(new Font("Helvetica", Font.PLAIN, 12));
		} 
		if (user.getAccess().equals("User")) {
			valider.setBounds(612, 0, 152, 41);
		}
	}
}
