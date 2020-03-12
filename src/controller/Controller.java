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
	
	public void registerNewInvoice(String invoiceNumber, Calendar expiryDate, Calendar printedDate, Calendar acknowledgementDate, Calendar deliveryDate) {
		Invoice newInvoice = new Invoice (invoiceNumber, expiryDate, printedDate, acknowledgementDate, deliveryDate);
		invoiceRegister.addInvoice(newInvoice);
	}
	public void registerNewOrderLine(Invoice invoice, Product product, int lineNumber, int amount) {
		Orderline newOrderLine = new OrderLine(invoice, product, lineNumber, amount);
		invoiceRegister.addOrderLine(newOrderLine);
	}
}
