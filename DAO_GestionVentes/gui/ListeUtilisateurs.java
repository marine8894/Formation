package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Entities.User;
import dao.daoUser;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ListeUtilisateurs extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeUtilisateurs frame = new ListeUtilisateurs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ListeUtilisateurs() {
		
		daoUser daouser = new daoUser();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTE DES UTILISATEURS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(31, 22, 730, 27);
		contentPane.add(lblNewLabel);
		
		
		Vector<String> nomColonnes = new Vector ();
		nomColonnes.addElement("USER ID");
		nomColonnes.addElement("USER NAME");
		nomColonnes.addElement("USER PASSWORD");
		nomColonnes.addElement("USER ACCESS");
		
		Vector v = new Vector();		
		daoUser showUser = new daoUser();
		try {
			v = showUser.checkUser();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		

		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(31, 470, 730, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton BtnSupprimer = new JButton("Supprimer");
		
		BtnSupprimer.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		BtnSupprimer.setBounds(515, 6, 209, 41);
		panel.add(BtnSupprimer);
		//BtnSupprimer.hide();
		//BtnSupprimer.setVisible(false);
		BtnSupprimer.setEnabled(false);
		
		JButton BtnModifier = new JButton("Modifier");
		BtnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				String valueid = (String) table.getValueAt(row, 0);
				int id = Integer.parseInt(valueid);

				String valueUsername = (String) table.getValueAt(row, 1);
				String valuePassword = (String) table.getValueAt(row, 2);
				String valueAccess = (String) table.getValueAt(row, 3);

				User user = new User(id, valueUsername, valuePassword, valueAccess);
				NouvelUtilisateur newUser2 = new NouvelUtilisateur(frame, false, user);
				newUser2.setVisible(true);
				setVisible(false);

			}
		});
		
		BtnModifier.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		BtnModifier.setBounds(257, 6, 209, 41);
		panel.add(BtnModifier);
		BtnModifier.setEnabled(false);
		

		

		
		
		DefaultTableModel model = new DefaultTableModel(v, nomColonnes);

		//ModeleTable model = new ModeleTable(v, nomColonnes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 76, 733, 362);
		contentPane.add(scrollPane);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		model.addTableModelListener(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				System.out.println(row);
				BtnSupprimer.setEnabled(true);
				BtnSupprimer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						daoUser supprUser = new daoUser();
						String valueid = (String) table.getValueAt(row, 0);
						try {
							System.out.println("delete " + valueid);
							supprUser.deleteUser(valueid);
							model.fireTableDataChanged();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				BtnModifier.setEnabled(true);
				BtnModifier.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						
					}
				});
			
			}
		});


		JButton BtnAjouter = new JButton("Ajouter");
		BtnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NouvelUtilisateur newUser = new NouvelUtilisateur(frame, false);
				newUser.setVisible(true);
				setVisible(false);
			
			}
		});
		BtnAjouter.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		BtnAjouter.setBounds(6, 6, 209, 41);
		panel.add(BtnAjouter);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().revalidate();
				getContentPane().repaint();
			}
		});
		btnRefresh.setBounds(645, 22, 117, 29);
		contentPane.add(btnRefresh);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ListeUtilisateurs.class.getResource("/icons/review (1).png")));
		lblNewLabel_1.setBounds(171, 10, 40, 54);
		contentPane.add(lblNewLabel_1);

	}
}



