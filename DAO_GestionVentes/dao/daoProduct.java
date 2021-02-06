package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Connexion.connexion;
import Entities.Product;
import iDao.iProduct;

public class daoProduct implements iProduct{

	private Connection myConnection;
	private Statement stt ;
	private PreparedStatement pstmt;
	
	
	
	public daoProduct() {
		myConnection = connexion.getInstance();
	}

	@Override
	public void addroduct(Product p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector checkProduct() throws SQLException {
		Vector <String> v = new Vector<String>();
		stt = myConnection.createStatement();
		ResultSet res = stt.executeQuery("SELECT nameProduct FROM Product");
		
		while (res.next()) {
			v.add(res.getString("nameProduct"));
		}
		return v;
		
	}

	@Override
	public void modifyProduct(Product p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int i) throws SQLException {
		//String delete = "DELETE FROM Product WHERE idUser = '" + i +"';";
		//PreparedStatement pstmt = myConnection.prepareStatement(delete);
		//pstmt.executeUpdate();
	}






}
