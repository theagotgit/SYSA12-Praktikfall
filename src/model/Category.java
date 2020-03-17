package model;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	//Custom constructor
	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		products.add(product);
	}
	
	public Product findProduct(Supplier supplier, String productNumber) {
		for (Product product : products) {
			if (product.getSupplier().getName().equals(supplier) && product.getProductNumber().equals(productNumber)) {
				return product;
			}
		}
		return null;
	}
	public void removeProduct(Supplier supplier, String productNumber) {
		products.remove(this.findProduct(supplier, productNumber));
	}
}
