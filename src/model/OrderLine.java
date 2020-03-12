package model;

public class OrderLine {
	private Product product;
	private Invoice invoice; 
	private int lineNumber; 
	private int amount;
	
	public OrderLine (Product product, Invoice invoice, int lineNumber, int amount) {
		this.product = product;
		this.invoice = invoice;
		this.lineNumber = lineNumber;
		this.amount = amount;
	}

}
