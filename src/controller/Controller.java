package controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.swing.table.DefaultTableModel;

import model.*;

public class Controller {
	private InvoiceRegister invoiceRegister;
	private SupplierRegister supplierRegister;
	private CategoryRegister categoryRegister;
	private final String[] supplierTableColumns = new String[] {"Namn", "Telefonnummer", "Fax", "Webbaddress"};
	
	public Controller() {
		invoiceRegister = new InvoiceRegister();
		supplierRegister = new SupplierRegister();
		categoryRegister = new CategoryRegister();
	}
	
	public InvoiceRegister getInvoiceRegister() {
		return this.invoiceRegister;
	}
	public void setInvoiceRegister(InvoiceRegister invoiceRegister) {
		this.invoiceRegister = invoiceRegister;
	}
	public SupplierRegister getSupplierRegister() {
		return supplierRegister;
	}
	public void setSupplierRegister(SupplierRegister supplierRegister) {
		this.supplierRegister = supplierRegister;
	}
	public CategoryRegister getCategoryRegister() {
		return categoryRegister;
	}
	public void setCategoryRegister(CategoryRegister categoryRegister) {
		this.categoryRegister = categoryRegister;
	}
	
	
	public void registerNewInvoice(String supplierName, String invoiceNumber, Calendar expiryDate, Calendar printedDate, Calendar acknowledgementDate, Calendar deliveryDate) {
		Supplier supplier = supplierRegister.findSupplier(supplierName);
		Invoice newInvoice = new Invoice(supplier, invoiceNumber, expiryDate, printedDate, acknowledgementDate, deliveryDate);
		invoiceRegister.addInvoice(newInvoice);
	}
	public void registerNewOrderLine(Product product, String invoiceNumber, int lineNumber, int amount) {
		Invoice invoice = invoiceRegister.findInvoice(invoiceNumber);
		OrderLine orderLine = new OrderLine(product, invoice, lineNumber, amount);
		invoice.addOrderLine(orderLine);
	}
	public Invoice searchInvoice(String invoiceNumber) {
		return invoiceRegister.findInvoice(invoiceNumber);
	}
	//The method removeInvoice() is not implemented in the graphical user interface but is kept in the controller in case it will be in the future.
	public void removeInvoice(String invoiceNumber) {
		invoiceRegister.removeInvoice(invoiceNumber);
	}
	public void addSupplier(String name, String faxNumber, String telephoneNumber, String webAddress) {
		Supplier supplier = new Supplier(name, faxNumber, telephoneNumber, webAddress);
	}
	public Supplier searchSupplier(String name) {
		return supplierRegister.findSupplier(name);
	}
	
	public DefaultTableModel viewAllSuppliers() {
		//Sorting all suppliers alphabetically by name.
		TreeMap<String, Supplier> sortedSuppliers = new TreeMap<String, Supplier>();
		for (Supplier tmp : supplierRegister.getSupplierlist()) {
			sortedSuppliers.put(tmp.getName(), tmp);
		}

		//Adding sorted data into a DefaultTableModel
		String[][] allSupplierData = new String[sortedSuppliers.keySet().size()][supplierTableColumns.length];
		int i = 0;
		for (Map.Entry<String, Supplier> tmp : sortedSuppliers.entrySet()) {
			allSupplierData[i][0] = tmp.getKey();
			allSupplierData[i][1] = tmp.getValue().getTelephoneNumber();
			allSupplierData[i][2] = tmp.getValue().getFaxNumber();
			allSupplierData[i][3] = tmp.getValue().getWebAddress();
			i++;
		}
		return new DefaultTableModel(allSupplierData, supplierTableColumns);
	}
	public void removeSupplier(String name) {
		supplierRegister.deleteSupplier(name);
	}
	public void addCategory(String name) {
		Category category = new Category(name);
		categoryRegister.addCategory(category);
	}
	
	public void addProduct(String categoryName, String supplierName, String productNumber, double unitPrice, String name) {
		Category category = categoryRegister.findCategory(categoryName);
		Product product = new Product(category, supplierRegister.findSupplier(supplierName), productNumber, unitPrice, name);
		category.addProduct(product);
	}
	public void removeCategory(String name) {
		categoryRegister.deleteCategory(name);
	}
	public void removeProduct(String supplierName, String productNumber) {
		categoryRegister.removeProduct(supplierRegister.findSupplier(supplierName), productNumber);
	}
	//createReport() NOT DONE!!!
	public DefaultTableModel createReport() {
		DefaultTableModel model = new DefaultTableModel();
		return model;
	}
	
	public double findSum(String invoiceNumber) {
		double sum = 0;
		Invoice invoice = invoiceRegister.findInvoice(invoiceNumber);
		for (OrderLine orderLine : invoice.getOrderLine()) {
			double productPrice = orderLine.getProduct().getUnitPrice();
			sum += (productPrice * orderLine.getAmount());
		}
		return sum;
	}
	public String searchCategory(String name) {
		String result = "Fakturor med varor fr�n kategorin \"" + name + "\":\n";
		ArrayList<Invoice> invoicesAlreadyRecorded = new ArrayList<Invoice>();
		for (Invoice invoice : invoiceRegister.getInvoice()) {
			for (OrderLine tmp : invoice.getOrderLine()) {
				if (tmp.getProduct().getCategory().getName().equals(name) && !invoicesAlreadyRecorded.contains(invoice)) {
					result += "\nFakturanummer: " + invoice.getInvoiceNumber() + "\nLadda ner fil...\nF�rfallodatum: " + invoice.getExpiryDate() +"\nSumma: " + this.findSum(invoice.getInvoiceNumber() + " SEK");
					invoicesAlreadyRecorded.add(invoice);
				}
			}
		}
		return result;
	}
	
	//Returns an array with arrays which can be synched with comboboxes in Application.java.
	public String[][] updateComboBoxes () {
		//For updating comboboxes with suppliers 
		String[] suppliers = new String[supplierRegister.getSupplierlist().size()];
		for (int i = 0; i < supplierRegister.getSupplierlist().size(); i++) {
			suppliers[i] = supplierRegister.getSupplierlist().get(i).getName();
		}
		
		//For updating comboboxes with products
		ArrayList<Product> productList = new ArrayList<Product>();
		for (Supplier supplier : supplierRegister.getSupplierlist()) {
			for (Product product : supplier.getProducts()) {
				if (productList.indexOf(product) == -1) {
					productList.add(product);
				}
			}
		}
		String[] products = new String[productList.size()];
		for (int i = 0; i < productList.size(); i++) {
			products[i] = productList.get(i).getName() + ", " + productList.get(i).getProductNumber();
		}
		
		//For updating comboboxes with categories
		String[] categories = new String[categoryRegister.getCategories().size()];
		for (int i = 0; i < categoryRegister.getCategories().size(); i++) {
			suppliers[i] = categoryRegister.getCategories().get(i).getName();
		}
		String[][] result = {suppliers, products, categories};
		
		return result;
	}
	
	
	
	
	
}