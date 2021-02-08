package Calculatrice;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CalculatriceApplication {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatriceApplication window = new CalculatriceApplication();
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
	public CalculatriceApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Calculatrice");
		frame.setBounds(100, 100, 266, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel result = new JLabel("0");
		result.setBounds(0, 2, 265, 61);
		result.setHorizontalAlignment(JLabel.RIGHT);
		result.setFont(new Font("Helvetica", Font.PLAIN, 25));
		result.setBorder(BorderFactory.createLineBorder(Color.black,1));
		panel.add(result);
		
		
		
		
		JButton ac = new JButton("AC");
		ac.setBounds(0, 68, 63, 61);
		ac.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(ac);
		
		
		JButton plusOuMoins = new JButton("+/-");
		plusOuMoins.setBounds(68, 68, 63, 61);
		plusOuMoins.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(plusOuMoins);
		
		JButton pourcent = new JButton("%");
		pourcent.setBounds(136, 68, 63, 61);
		pourcent.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(pourcent);
		
		JButton divide = new JButton("/");
		divide.setBounds(204, 68, 63, 61);
		divide.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(divide);
		
		JButton sept = new JButton("7");
		sept.setBounds(0, 134, 63, 61);
		sept.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(sept);
		
		
		JButton huit = new JButton("8");
		huit.setBounds(68, 134, 63, 61);
		huit.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(huit);
		
		JButton neuf = new JButton("9");
		neuf.setBounds(136, 134, 63, 61);
		neuf.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(neuf);
		
		JButton multiply = new JButton("x");
		multiply.setBounds(204, 134, 63, 61);
		multiply.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(multiply);
		
		JButton quatre = new JButton("4");
		quatre.setBounds(0, 200, 63, 61);
		quatre.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(quatre);
		
		
		JButton cinq = new JButton("5");
		cinq.setBounds(68, 200, 63, 61);
		cinq.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(cinq);
		
		JButton six = new JButton("6");
		six.setBounds(136, 200, 63, 61);
		six.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(six);
		
		JButton minus = new JButton("-");
		minus.setBounds(204, 200, 63, 61);
		minus.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(minus);
		
		JButton un = new JButton("1");
		un.setBounds(0, 266, 63, 61);
		un.setFont(new Font("Helvetica", Font.PLAIN, 15));
		un.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(un);
		
		JButton deux = new JButton("2");
		deux.setBounds(68, 266, 63, 61);
		deux.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(deux);
		
		JButton trois = new JButton("3");
		trois.setBounds(136, 266, 63, 61);
		trois.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(trois);
		
		JButton plus = new JButton("+");
		plus.setBounds(204, 266, 63, 61);
		plus.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(plus);
		
		JButton zero = new JButton("0");
		zero.setBounds(0, 332, 131, 66);
		zero.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(zero);
		
		JButton virgule = new JButton(",");
		virgule.setBounds(136, 332, 63, 66);
		virgule.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(virgule);
		
		JButton egal = new JButton("=");
		egal.setBounds(204, 332, 63, 66);
		egal.setFont(new Font("Helvetica", Font.PLAIN, 15));
		panel.add(egal);
		
		
	}
}
