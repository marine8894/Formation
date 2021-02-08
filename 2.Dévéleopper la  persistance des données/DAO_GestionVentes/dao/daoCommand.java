package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import Connexion.connexion;
import Entities.Command;
import iDao.iCommand;

public class daoCommand implements iCommand {
	
	static Statement stmt;
	static PreparedStatement pstmt;
	static PreparedStatement pstmtt;
	static PreparedStatement pstmtBase;
	static PreparedStatement pstmtProduct;
	private Connection myConnection;
	
	
	
	public daoCommand() {
		this.myConnection = connexion.getInstance();
	}

	@Override
	public void addCommand(double totalPrice, int quantite) throws SQLException {
		String insert = "Insert Into Command (totalPrice, dateCommand) Values (?, ?);";

		pstmtt = myConnection.prepareStatement(insert);
		
		String queryy= "SELECT idCommand FROM Command;";
		pstmtBase = myConnection.prepareStatement(queryy);
		int numCmde = 0;
		ResultSet resultBase = pstmtBase.executeQuery();
		while (resultBase.next()) {
			numCmde = resultBase.getInt("idCommand");
		}
		numCmde = numCmde +1;

		//Table Commande
		pstmtt.setDouble(1, totalPrice);
		pstmtt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
	
		int resultt = pstmtt.executeUpdate();

	}

	@Override
	public Vector<Vector> checkCommand(String idCommand) throws SQLException {
		
		
		Vector <Vector> conteneur = new Vector();
		Statement myStmt = myConnection.createStatement();
		ResultSet myRs = myStmt.executeQuery("SELECT LC.idCommand, idCommandLine, nameProduct, priceProduct, quantite, dateCommand "
				+ "FROM CommandLine LC "
				+ "INNER JOIN Command C "
				+ "ON LC.idCommand=C.idCommand "
				+ "INNER JOIN Product P "
				+ "ON P.idProduct = LC.idProduct "
				+ "WHERE LC.idCommand = '" + idCommand + "';");
		
			while (myRs.next()) {
				 
				Vector donnees = new Vector ();
		        donnees.add(myRs.getString("idCommand"));
		        donnees.add(myRs.getString("idCommandLine"));
		        donnees.add(myRs.getString("nameProduct"));
		        donnees.add(myRs.getString("priceProduct"));
		        donnees.add(myRs.getString("Quantite"));
		        donnees.add(myRs.getDate("dateCommand"));
		        conteneur.add(donnees); 

		        
			}

		return conteneur;
	}

	@Override
	public void modifyCommand(Command c) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCommand(Command c) throws SQLException {
		// TODO Auto-generated method stub
		
	}



}
