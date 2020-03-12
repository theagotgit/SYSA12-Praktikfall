package model;

import java.util.Calendar;

public class Invoice {
	private String invoiceNumber;
	private Calendar expiryDate;
	private Calendar printedDate;
	private Calendar acknowledgementDate;
	private Calendar deliveryDate;
	
	public Invoice(String invoiceNumber, Calendar expiryDate, Calendar printedDate, Calendar acknowledgementDate, Calendar deliverydate) {
		this.setInvoiceNumber(invoiceNumber);
		this.setExpiryDate(expiryDate);
		this.setPrintedDate(printedDate);
		this.setAcknowledgementDate(acknowledgementDate);
		this.deliveryDate = deliveryDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Calendar getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Calendar expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Calendar getPrintedDate() {
		return printedDate;
	}

	public void setPrintedDate(Calendar printedDate) {
		this.printedDate = printedDate;
	}

	public Calendar getAcknowledgementDate() {
		return acknowledgementDate;
	}

	public void setAcknowledgementDate(Calendar acknowledgementDate) {
		this.acknowledgementDate = acknowledgementDate;
	}
	public Calendar getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}