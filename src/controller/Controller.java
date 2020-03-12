package controller;
import java.util.Calendar;

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
	
	
	public void registerNewInvoice(String invoiceNumber, Calendar expiryDate, Calendar printedDate, Calendar acknowledgementDate, Calendar deliveryDate) {
		Invoice newInvoice = new Invoice (invoiceNumber, expiryDate, printedDate, acknowledgementDate, deliveryDate);
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
	public void addSupplier(String name) {
		Supplier supplier = new Supplier(name);
	}
	
}
