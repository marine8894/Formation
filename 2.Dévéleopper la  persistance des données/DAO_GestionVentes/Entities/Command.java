package Entities;

public class Command {

	
	protected int idCommand;
	
	protected String dateCommand;
	
	protected float totalPrice;
	
	

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getIdCommand() {
		return idCommand;
	}

	public void setIdCommand(int idCommand) {
		this.idCommand = idCommand;
	}

	public String getDateCommand() {
		return dateCommand;
	}

	public void setDateCommand(String dateCommand) {
		this.dateCommand = dateCommand;
	}

	
	public Command(int idCommand, String dateCommand, float totalPrice) {
		super();
		this.idCommand = idCommand;
		this.dateCommand = dateCommand;
		this.totalPrice = totalPrice;
	}
	
	
}
