package Entities;

public class Product {
	
	protected int idProduct;
	protected String nameProduct;
	protected float priceProduct;
	
	
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	
	
	public float getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}
	
	
	
	public Product(int idProduct, String nameProduct, float priceProduct) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
	}
	
	
	
	
}
