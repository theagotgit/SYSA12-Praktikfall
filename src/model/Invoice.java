package model;

import java.util.Calendar;
import java.util.*;

public class Invoice {
	private Supplier supplier;
	private ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>();
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
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public ArrayList<OrderLine> getOrderLine() {
		return this.orderLines;
	}
	public void setOrderLine(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
}