package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import Connexion.connexion;

import Entities.User;
import iDao.iUser;

public class daoUser implements iUser {

	
	static Statement state;
	static Connection myConnection;
	static PreparedStatement pstmt;
	
	
	
	
	
	public daoUser() {
		myConnection = connexion.getInstance();
		
	}

	@Override
	public void addUser(User u) throws SQLException {
		String insert = "INSERT INTO User (userName, password, access) VALUES (?, ?, ?);"; 
		PreparedStatement pstmt = myConnection.prepareStatement(insert);
		pstmt.setString(1, u.getUserName());
		pstmt.setString(2, u.getPassword());
		pstmt.setString(3, u.getAccess());
		int result = pstmt.executeUpdate();
	}

	@Override
	public Vector<Vector> checkUser() throws SQLException {
		Vector <Vector> vector = new Vector();
		ResultSet res = null;
		state = connexion.getInstance().createStatement();
		String query = "SELECT idUser, username, password, access FROM User WHERE idUser IS NOT NULL;";
		res = state.executeQuery(query);
		while (res.next()) {
			Vector<String> users = new Vector<>();
			users.add(res.getString("idUser"));
			users.add(res.getString("username"));
			users.add(res.getString("password"));
			users.add(res.getString("access"));
			vector.add(users);
		}
		return vector;
	}

	@Override
	public void modifyUser(User u) throws SQLException {
		// TODO Auto-generated method stub
		//daoUser userr = new daoUser();
		
		String update = "UPDATE User SET username ='" + u.getUserName() + "', password ='" + u.getPassword() + ""
				+ "', access ='" + u.getAccess() +"' WHERE idUser = '"+u.getIdUser()+"';";
		PreparedStatement pstmtt = myConnection.prepareStatement(update);
		pstmtt.executeUpdate();
	}

	@Override
	public void deleteUser(String s) throws SQLException {
		ResultSet res = null;
		
		String delete = "DELETE FROM user WHERE idUser = '" + s +"';";
		PreparedStatement pstmt = myConnection.prepareStatement(delete);
		pstmt.executeUpdate();

	}

	@Override
	public User findUser(int id) throws SQLException {
		
			User user = null;
			String query = "SELECT * FROM User WHERE idUser =" + id + ";";
			state = myConnection.createStatement();
			ResultSet res = state.executeQuery(query);
			while (res.next()) {
				user = new User (res.getString("username"), res.getString("password"), res.getString("access") );
			}
			return user;
	}

	@Override
	public User identification(String id, String mdp) throws SQLException {
		User user = new User();
		String query = "SELECT username, password, access FROM User WHERE username ='" +id+ "' AND password ='" +mdp+"';";
		state = myConnection.createStatement();
		ResultSet set = state.executeQuery(query);
		while(set.next()) {
			if (id.toString().equals(set.getString("username").toString()) && mdp.toString().equals(set.getString("password").toString())){
			user = new User(set.getString("username"), set.getString("password"), set.getString("access"));
			}// else {
				//JOptionPane.showMessageDialog(null, "oops", "oops", JOptionPane.INFORMATION_MESSAGE);
			//}
		}
		return user;
	}


}
