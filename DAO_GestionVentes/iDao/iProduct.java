package iDao;

import java.sql.SQLException;
import java.util.Vector;

import Entities.Product;

public interface iProduct {

	
	public void  addroduct (Product p) throws SQLException;
	
	public Vector checkProduct () throws SQLException;
	
	public void  modifyProduct (Product p) throws SQLException;
	
	public void  deleteProduct (int i) throws SQLException;
	
	
	
}
