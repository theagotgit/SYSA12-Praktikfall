package model;
import java.util.*;

public class InvoiceRegister {
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	
	public InvoiceRegister (ArrayList<Invoice> invoices) {
		this.setInvoice(invoices);
	}
	public ArrayList<Invoice> getInvoice() {
		return this.invoices;
	}
	public void setInvoice(ArrayList<Invoice> invoices) {
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
	public void removeInvoice(String invoiceNumber) {
		invoices.remove(this.findInvoice(invoiceNumber));
	}
}

