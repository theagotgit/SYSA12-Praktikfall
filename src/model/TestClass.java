package model;

import java.util.Calendar;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SupplierRegister sRegister = new SupplierRegister();
		CategoryRegister cRegister = new CategoryRegister();
		InvoiceRegister iRegister = new InvoiceRegister();

		Supplier s = new Supplier("Vicky", "djjdh", "040", ".com");
		Supplier z = new Supplier("Thea", "yh", "070", ".se");

		sRegister.addSupplier(s);
		sRegister.addSupplier(z);
		Supplier supplier = sRegister.findSupplier("Vicky");
		System.out.println(supplier.getName());
		
		Supplier sus = sRegister.deleteSupplier("Vicky");
		System.out.println(sus.getName());
		
		sRegister.editSupplier("Thea", "dedu", "030", ".pl");
		Supplier thea = sRegister.findSupplier("Thea");
		System.out.println(thea.getWebAddress());
		
		Category cat = new Category("Nocco");
		Category dog = new Category("Celsius");
		
		cRegister.addCategory(cat);
		cRegister.addCategory(dog);
		Category cate = cRegister.findCategory("Nocco");
		System.out.println(cate.getName());
		
		Category yyy = cRegister.deleteCategory("Nocco");
		System.out.println(yyy.getName());
		
		cRegister.editCategory("Celsius", "Nocco");
		System.out.println(dog.getName());
		
		//(String invoiceNumber, Calendar expiryDate, Calendar printedDate, Calendar acknowledgementDate, Calendar deliveryDate)
	   	 InvoiceRegister invoiceRegister = new InvoiceRegister();
	   	 //Creating Calendar instance
	   	  Calendar expiryDate = Calendar.getInstance();
	   	  expiryDate.add(Calendar.DATE, 15);
	   	 
	   	  Calendar printedDate = Calendar.getInstance();
	   	  printedDate.add(Calendar.DATE, -15);
	   	 
	   	  Calendar acknowledgementDate = Calendar.getInstance();
	   	  acknowledgementDate.add(Calendar.DATE, -5);
	   	 
	   	  Calendar deliveryDate = Calendar.getInstance();
	   	  deliveryDate.add(Calendar.DATE, -1);
	    	 
	   	 Invoice a = new Invoice(s, "ett", expiryDate, printedDate, acknowledgementDate, deliveryDate);
	   	 Invoice b = new Invoice(z, "två", expiryDate, printedDate, acknowledgementDate, deliveryDate);
	   	 //Koppla supplier med invoice
	   	 
	   	 invoiceRegister.addInvoice(a);
	   	 invoiceRegister.addInvoice(b);
	   	 
	   	 Invoice c = invoiceRegister.findInvoice("ett");
	   	 System.out.println(c.getAcknowledgementDate().getTime());
	   	 
	   	 Invoice d = invoiceRegister.removeInvoice("ett");
	   	 System.out.println("Förfallodatum: " + d.getExpiryDate().getTime());
	   	 
	   	 


	}

}
