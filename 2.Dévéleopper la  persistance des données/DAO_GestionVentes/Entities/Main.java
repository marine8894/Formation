package Entities;

import java.sql.SQLException;

import dao.daoCommandLine;
import dao.daoProduct;
import dao.daoUser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		/*daoUser daoUser = new daoUser();
		User u = new User();
		u.setUserName("toto");
		u.setPassword("1234");
		u.setAccess("user");
		try {
			daoUser.addUser(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*daoCommandLine cl = new daoCommandLine();
		String s = "cahier rouge";
		try {
			cl.getPrice(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		daoProduct pr = new daoProduct();
		try {
			pr.checkProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
