package Entities;

public class User {

	protected int idUser;
	
	protected String userName;
	
	protected String password;
	
	protected String access;
	
	public User() {

	}
	
	public User(int idUser, String userName, String password, String access) {
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.access = access;
	}

	public User( String userName, String password, String access) {
		this.userName = userName;
		this.password = password;
		this.access = access;
	}
	

	
	

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", access=" + access
				+ "]";
	}
	
	
	
	
	
	
}
