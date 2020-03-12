package model;

import java.util.ArrayList;

public class Supplier {
	ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	ArrayList<Product> products = new ArrayList<Product>();
	private String name;
	private String faxNumber;
	private String telephoneNumber;
	private String webAddress;

	public Supplier(String name, String faxNumber, String telephoneNumber, String webAddress) {
		this.name = name;
		this.faxNumber = faxNumber;
		this.telephoneNumber = telephoneNumber;
		this.webAddress = webAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public ArrayList<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}

	public ArrayList<Product> getProducts() {
		return this.products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void addInvoice(Invoice invoice) {
		invoices.add(invoice);
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeInvoice(Invoice invoice) {
		invoices.remove(invoice);
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}
}
