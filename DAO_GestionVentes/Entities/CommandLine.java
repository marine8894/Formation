package Entities;

import java.util.Vector;

public class CommandLine {

	private Vector ligneCommande = new Vector();

	


	protected int idProduct;
	protected int idCommandLine;
	protected int idCommand;
	protected int quantite;
	
	
	public CommandLine(Vector ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	
	public int getIdCommandLine() {
		return idCommandLine;
	}
	public void setIdCommandLine(int idCommandLine) {
		this.idCommandLine = idCommandLine;
	}
	
	
	public int getIdCommand() {
		return idCommand;
	}
	public void setIdCommand(int idCommand) {
		this.idCommand = idCommand;
	}
	
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	public CommandLine() {
	}
	
	public CommandLine(int idProduct, int idCommand, int quantite) {
		this.idProduct = idProduct;
		this.idCommand = idCommand;
		this.quantite = quantite;
	}
	
	public CommandLine(int idProduct, int idCommandLine, int idCommand, int quantite) {
		this.idCommandLine = idCommandLine;
		this.idProduct = idProduct;
		this.idCommand = idCommand;
		this.quantite = quantite;
	}
	
	
	
	
	
	
}
