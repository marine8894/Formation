package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connexion.connexion;
import Entities.CommandLine;
import iDao.iLineCommand;

public class daoCommandLine implements iLineCommand {

	static Connection myConnection;
	static Statement stmt;
	static Statement stt;
	static PreparedStatement pstmt;
	static PreparedStatement pstmtBase;
	

	public daoCommandLine() {
		myConnection = connexion.getInstance();
	}

	@Override
	public void addCmdLine(ArrayList<String> list, ArrayList <String> qte) throws SQLException {
		
		
		String query = "Insert Into CommandLine (idCommandLine, idProduct, quantite, idCommand) Values (?, ?, ?, ?);";
		pstmt = myConnection.prepareStatement(query);
		
		String queryy= "SELECT idCommand FROM Command ;";
		pstmtBase = myConnection.prepareStatement(queryy);
		int numCmde = 0;
		ResultSet resultBase = pstmtBase.executeQuery();
		while (resultBase.next()) {
			numCmde = resultBase.getInt("idCommand");
		}
		numCmde = numCmde +1;

			//Colonne idCommand
		pstmt.setInt(4, numCmde);
		
		int intNum = 0;
		String numPrdt = "";
		int quantite = 0;
		String valeurQte ="";
		
		for (int i =0; i<list.size(); i++) {
			String str = list.get(i).toString();
			

			String query3 = "SELECT idProduct FROM Product WHERE nameProduct = '"+str+"';";
			stmt = myConnection.createStatement();
			ResultSet resultQuery3 = stmt.executeQuery(query3);
			while (resultQuery3.next()) {
				numPrdt = resultQuery3.getString("idProduct");
				if (numPrdt.equals("PRT1")) {
					intNum = 1;
				} else if (numPrdt.equals("PRT2")) {
					intNum = 2;
				} else if (numPrdt.equals("PRT3")) {
					intNum = 3;
				} else if (numPrdt.equals("PRT4")) {
					intNum = 4;
				} else if (numPrdt.equals("PRT5")) {
					intNum = 5;
				} else if (numPrdt.equals("PRT6")) {
					intNum = 6;
				} else if (numPrdt.equals("PRT7")) {
					intNum = 7;
				} else if (numPrdt.equals("PRT8")) {
					intNum = 8;
				}
					valeurQte = qte.get(i).toString();
					quantite = Integer.parseInt(valeurQte);
			}
			pstmt.setInt(3, quantite);
			pstmt.setInt(1, intNum);
			pstmt.setString(2, numPrdt);
		int result = pstmt.executeUpdate();
		System.out.println("Result - numComde: " + numCmde +  " + numPrdt: " + numPrdt + " + numLigne: " + intNum + " + quantite: " + quantite);

		}

	}

	@Override
	public void checkCmdLine(CommandLine cl) throws SQLException {
		
		
	}

	@Override
	public void modifyCmdLine(CommandLine cl) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCmdLine(CommandLine cl) throws SQLException {
		
		
	}

	@Override
	public String getPrice(String s) throws SQLException {
		String select = "SELECT priceProduct FROM Product WHERE nameProduct='"+s+"';" ;
		String str = "";
		stt = connexion.getInstance().createStatement();
		ResultSet res = stt.executeQuery(select);
		while (res.next()) {
			str = res.getString("priceProduct");
		}
		return str;
		
	}

}
