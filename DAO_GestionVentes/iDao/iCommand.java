package iDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import Entities.Command;
import Entities.User;

public interface iCommand {


	public void addCommand (double totalPrice, int quantite) throws SQLException ;
	
	public Vector<Vector> checkCommand (String idCommand) throws SQLException;
	
	public void modifyCommand (Command c) throws SQLException;
	
	public void deleteCommand (Command c) throws SQLException;
	
}
