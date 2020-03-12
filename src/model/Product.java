package model;

public class Product {
	private Supplier supplier;	
	private String productNumber;
	private double unitPrice;
	private String name;
	
	public Product (Supplier supplier, String productNumber, double unitPrice, String name) {
		this.setSupplier(supplier);
		this.setProductNumber(productNumber);
		this.setUnitPrice(unitPrice);
		this.setName(name);
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
