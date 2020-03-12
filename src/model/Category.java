package model;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<Product> products = new ArrayList<Product>();

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

}
