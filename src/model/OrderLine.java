package model;

public class OrderLine {
	private Product product;
	private Invoice invoice; 
	private int lineNumber; 
	private int amount;
	
	public OrderLine (Product product, Invoice invoice, int lineNumber, int amount) {
		this.setProduct(product);
		this.setInvoice(invoice);
		this.setLineNumber(lineNumber);
		this.setAmount(amount);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
