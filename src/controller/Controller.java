package controller;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;

import model.*;

public class Controller {
	private InvoiceRegister invoiceRegister;
	private SupplierRegister supplierRegister;
	private CategoryRegister categoryRegister;
	
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
	public void removeSupplier(String name) {
		supplierRegister.deleteSupplier(name);
	}
	public void addCategory(String name) {
		categoryRegister.addCategory(new Category(name));
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
		String result = "Fakturor med varor från kategorin \"" + name + "\":\n";
		ArrayList<Invoice> invoicesAlreadyRecorded = new ArrayList<Invoice>();
		for (Invoice invoice : invoiceRegister.getInvoice()) {
			for (OrderLine tmp : invoice.getOrderLine()) {
				if (tmp.getProduct().getCategory().getName().equals(name) && !invoicesAlreadyRecorded.contains(invoice)) {
					result += "\nFakturanummer: " + invoice.getInvoiceNumber() + "\nLadda ner fil...\nFörfallodatum: " + invoice.getExpiryDate() +"\nSumma: " + this.findSum(invoice.getInvoiceNumber() + " SEK");
					invoicesAlreadyRecorded.add(invoice);
				}
			}
		}
		return result;
	}
}