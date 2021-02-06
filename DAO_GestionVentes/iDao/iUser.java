package iDao;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Vector;

import Entities.User;

public interface iUser {

	
	public void addUser (User u) throws SQLException;
	
	public Vector<Vector> checkUser () throws SQLException;

	public void modifyUser (User u) throws SQLException;
	
	public void deleteUser (String s) throws SQLException;
	
	public User findUser (int id) throws SQLException ;
	
	public User identification(String id, String mdp) throws SQLException;
}
