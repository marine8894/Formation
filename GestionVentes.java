package Application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class GestionVentes {

	private JFrame frame;
	protected double total = 00.00;
	protected String recapitul = "";
	protected DecimalFormat df = new DecimalFormat("##.##");
	protected double resultat;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		JPanel panelSelection = new JPanel();
		panelSelection.setBounds(16, 40, 120, 262);
		panelSelection.setBorder(BorderFactory.createLineBorder(Color.black,1));
		panelSelection.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panelSelection);
		panelSelection.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setLocation(6, 38);
		comboBox.setSize(108,27);
		comboBox.setFont(new Font("Helvetica", Font.PLAIN, 13));
		panelSelection.add(comboBox);
		String [] selection = {"cahier bleu", "cahier blanc", "stylo rouge", "stylo vert", "lunettes", "gomme", "ordinateur", "souris"};
		comboBox.setModel(new DefaultComboBoxModel(selection));
		
		JTextField saisiePrix = new JTextField();
		saisiePrix.setBounds(6, 111, 108, 26);
		saisiePrix.setFont(new Font("Helvetica", Font.PLAIN, 13));
		panelSelection.add(saisiePrix);
		
		JTextField saisieQuantite = new JTextField();
		saisieQuantite.setBounds(6, 183, 108, 26);
		saisieQuantite.setFont(new Font("Helvetica", Font.PLAIN, 13));
		panelSelection.add(saisieQuantite);
		
		JLabel choixproduit = new JLabel("Choisir le produit");
		choixproduit.setBounds(12, 19, 108, 16);
		choixproduit.setFont(new Font("Helvetica", Font.PLAIN, 11));
		panelSelection.add(choixproduit);
		
		JLabel prixunitaire = new JLabel("Entrer le prix unitaire");
		prixunitaire.setFont(new Font("Helvetica", Font.PLAIN, 11));
		prixunitaire.setBounds(12, 98, 108, 16);
		panelSelection.add(prixunitaire);
		
		JLabel nombre = new JLabel("Entrer le nombre");
		nombre.setFont(new Font("Helvetica", Font.PLAIN, 11));
		nombre.setBounds(12, 168, 108, 16);
		panelSelection.add(nombre);
		
		
		
		
		
		JPanel panelListes = new JPanel();
		panelListes.setBounds(148, 40, 282, 262);
		panelListes.setBackground(Color.WHITE);
		frame.getContentPane().add(panelListes);
		panelListes.setBorder(BorderFactory.createLineBorder(Color.black,1));
		panelListes.setLayout(null);
		
		
		JLabel listeachat = new JLabel("Liste d'achat");
		listeachat.setHorizontalAlignment(JLabel.CENTER);
		listeachat.setFont(new Font("Helvetica", Font.PLAIN, 14));
		listeachat.setBounds(17, 16, 119, 16);
		panelListes.add(listeachat);
		
		JLabel montants = new JLabel("Montant");
		montants.setHorizontalAlignment(JLabel.CENTER);
		montants.setFont(new Font("Helvetica", Font.PLAIN, 14));
		montants.setBounds(145, 16, 122, 16);
		panelListes.add(montants);
		
		DefaultListModel<String> modelProduits = new DefaultListModel<>();
		JList listProduits = new JList(modelProduits);
		listProduits.setLocation(17, 37);
		listProduits.setSize(119,170);
		panelListes.add(listProduits);
		
		DefaultListModel<String> modelMontants = new DefaultListModel<>();
		JList listMontants = new JList(modelMontants);
		listMontants.setBounds(145, 37, 122, 170);
		panelListes.add(listMontants);

		JTextPane recap = new JTextPane();
		recap.setBounds(17, 219, 119, 32);
		recap.setFont(new Font("Helvetica", Font.PLAIN, 10));
		panelListes.add(recap);
		
		JTextPane result = new JTextPane();
		result.setBounds(145, 219, 122, 32);
		result.setFont(new Font("Helvetica", Font.PLAIN, 13));
		result.setBackground(Color.WHITE);
		panelListes.add(result);
		

		
		
		
		

		
		
		
		JPanel panelTop = new JPanel();
		panelTop.setBounds(16, 6, 414, 21);
		frame.getContentPane().add(panelTop);
		
		JLabel titre = new JLabel("Gestion des ventes");
		titre.setFont(new Font("Helvetica", Font.PLAIN, 16));
		panelTop.add(titre);
		
		
		
		
		JPanel panelBoutons = new JPanel();
		panelBoutons.setBounds(16, 314, 414, 41);
		panelBoutons.setBackground(Color.WHITE);
		panelBoutons.setBorder(BorderFactory.createLineBorder(Color.black,1));
		frame.getContentPane().add(panelBoutons);
		
		JButton ajouter = new JButton("Ajouter");
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
						modelProduits.addElement(comboBox.getSelectedItem().toString());
						
						
						String strPrix = saisiePrix.getText().replace(',', '.');
						double prix = Double.parseDouble(strPrix);
						String strQte = saisieQuantite.getText().replace(',','.');
						double qte = Double.parseDouble(strQte);
						resultat = qte * prix;
						modelMontants.addElement(df.format(resultat));
	
						total = resultat + total;
						result.setText("Total : " + df.format(total));
						
						String str = comboBox.getSelectedItem().toString();
						recapitul += str + ", ";
						recap.setText(recapitul);
					} else {
						JOptionPane.showMessageDialog(null, "Veuillez saisir des chiffres valides", "Erreur : saisie", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		ajouter.setFont(new Font("Helvetica", Font.PLAIN, 12));
		ajouter.setSize(50, 20);
		panelBoutons.add(ajouter);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = listProduits.getSelectedIndex();
				String isole = listProduits.getSelectedValue().toString();
				String montantARemove = modelMontants.remove(i).toString();
				modelProduits.removeElement(listProduits.getSelectedValue());


				String strPrix = saisiePrix.getText().replace(',', '.');
				double prix = Double.parseDouble(strPrix);
				String strQte = saisieQuantite.getText();
				double qte = Double.parseDouble(strQte);
				double remove = Double.parseDouble(montantARemove);
				resultat = (qte * prix);
				total = total  - remove;
				result.setText("Total : " + df.format(total));
				
				recapitul = "";
				for (int j=0; j<listProduits.getModel().getSize(); j++) {
					String str = modelProduits.getElementAt(j);
					recapitul += str + ", ";
					recap.setText(recapitul);
				}				
			}
		});
		supprimer.setFont(new Font("Helvetica", Font.PLAIN, 12));
		supprimer.setSize(50, 20);
		panelBoutons.add(supprimer);
		
		JButton effacer = new JButton("Effacer");
		effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result.setText("Total : ");
				total = 00.00;
				recapitul = "";
				modelMontants.removeAllElements();
				modelProduits.removeAllElements();
				saisiePrix.setText("");
				saisieQuantite.setText("");
				recap.setText("");
			}
		});
		effacer.setFont(new Font("Helvetica", Font.PLAIN, 12));
		effacer.setSize(50, 20);
		panelBoutons.add(effacer);
		
		JButton quitter = new JButton("Quitter");
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitter.setFont(new Font("Helvetica", Font.PLAIN, 12));
		quitter.setSize(50, 20);
		panelBoutons.add(quitter);
		
		
	}
}
