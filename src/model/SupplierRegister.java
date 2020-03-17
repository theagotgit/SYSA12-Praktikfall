package model;

import java.util.ArrayList;

public class SupplierRegister {
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();


	public SupplierRegister() {

	}

	public SupplierRegister(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	
	public SupplierRegister (ArrayList<Supplier> suppliers) {
		this.setSupplierlist(suppliers);


	}
	public SupplierRegister (ArrayList<Supplier> suppliers) {
		this.setSupplierlist(suppliers);


	}
	public SupplierRegister() {};
	public ArrayList<Supplier> getSupplierlist() {
		return this.suppliers;
	}
	public void setSupplierlist(ArrayList<Supplier> supplierlist) {
		this.suppliers = supplierlist;
	}
	public void addSupplier(Supplier supplier) {
		this.suppliers.add(supplier);
	}
	public Supplier findSupplier(String supplierName) {
		for (Supplier s : suppliers) {
			if (s.getName().equals(supplierName)) {
				return s;
			}
		}
		return null;
	}



	public Supplier deleteSupplier(String SupplierName) {
		Supplier s = this.findSupplier(SupplierName);
		suppliers.remove(s);
		return s;
	}

	public Supplier editSupplier(String supplierName, String faxNumber, String telephoneNumber, String webAddress) {
		Supplier s = this.findSupplier(supplierName);
		s.setFaxNumber(faxNumber);
		s.setTelephoneNumber(telephoneNumber);
		s.setWebAddress(webAddress);
		return s;
	}
}
