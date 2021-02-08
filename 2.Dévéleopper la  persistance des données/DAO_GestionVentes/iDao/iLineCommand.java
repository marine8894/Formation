package iDao;

import java.sql.SQLException;
import java.util.ArrayList;

import Entities.CommandLine;



public interface iLineCommand {

	public void addCmdLine (ArrayList <String> list, ArrayList <String> qte) throws SQLException ;
	
	public String getPrice (String s) throws SQLException;
	
	public void checkCmdLine (CommandLine cl) throws SQLException;
	
	public void modifyCmdLine (CommandLine cl) throws SQLException;
	
	public void deleteCmdLine (CommandLine cl) throws SQLException;
	
}
