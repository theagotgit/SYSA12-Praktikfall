package model;

import java.util.Calendar;

public class Invoice {
	String invoiceNumber;
	Calendar expiryDate;
	Calendar printedDate;
	Calendar acknowledgementDate;
	Calendar deliveryDate;
	
	public Invoice(String invoiceNumber, Calendar expiryDate, Calendar printedDate, Calendar acknowledgementDate, Calendar deliverydate) {
		this.invoiceNumber = invoiceNumber;
		this.expiryDate = expiryDate;
		this.printedDate = printedDate;
		this.acknowledgementDate = acknowledgementDate;
		this.deliveryDate = deliveryDate;
	}

}
