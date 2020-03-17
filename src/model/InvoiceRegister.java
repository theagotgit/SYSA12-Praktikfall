package model;
import java.util.*;

public class InvoiceRegister {
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	
	public InvoiceRegister() {
	}
	
	
	public InvoiceRegister (ArrayList<Invoice> invoices) {
		this.setInvoices(invoices);
	}
	public ArrayList<Invoice> getInvoice() {
		return this.invoices;
	}
	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}
	public void addInvoice(Invoice invoice) {
		this.invoices.add(invoice);
	}
	
	public Invoice findInvoice(String invoiceNumber) {
		for(Invoice tmp: invoices) {
			if(tmp.getInvoiceNumber().equals(invoiceNumber)){
				return tmp;
			}	
		}
		return null;
	}
	public Invoice removeInvoice(String invoiceNumber) {
		Invoice invoice = this.findInvoice(invoiceNumber);
		invoices.remove(invoice);
		return invoice;
	}
	//Changes everything but invoicenumber, which is unique for each invoice.
	public void editInvoice(String invoiceNumber, Supplier supplier, Calendar expiryDate, Calendar printDate, Calendar acknowledgementDate, Calendar deliveryDate) {
		Invoice invoice = this.findInvoice(invoiceNumber);
		invoice.setSupplier(supplier);
		invoice.setExpiryDate(expiryDate);
		invoice.setPrintedDate(printDate);
		invoice.setAcknowledgementDate(acknowledgementDate);
		invoice.setDeliveryDate(deliveryDate);
	}
}

