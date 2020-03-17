package model;

public class Product {
	private Category category;
	private Supplier supplier;	
	private String productNumber;
	private double unitPrice;
	private String name;
	
	public Product (Category category, Supplier supplier, String productNumber, double unitPrice, String name) {
		this.setCategory(category);
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
