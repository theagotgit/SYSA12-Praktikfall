package model;

import java.util.ArrayList;

public class SupplierRegister {

	private ArrayList<Supplier> supplierlist = new ArrayList<Supplier>();

	public ArrayList<Supplier> getSupplierlist() {
		return supplierlist;
	}

	public void setSupplierlist(ArrayList<Supplier> supplierlist) {
		this.supplierlist = supplierlist;
	}

	public void addSupplier(Supplier supplier) {
		supplierlist.add(supplier);
	}

	public Supplier findSupplier(String supplierName) {
		for (Supplier s : supplierlist) {
			if (s.getName().equals(supplierName)) {
				return s;
			}
		}
		return null;
	}
	
	public Supplier deleteSupplier(String SupplierName) {
		Supplier s = this.findSupplier(SupplierName);
		supplierlist.remove(s);
		return s;
	}

	public Supplier editSupplier(String supplierName, String faxNumber, String telephoneNumber, String webAddress) {
		Supplier s = this.findSupplier(supplierName);
		s.setFaxNumber(faxNumber);
		s.setName(supplierName);
		s.setTelephoneNumber(telephoneNumber);
		s.setWebAddress(webAddress);
		return s;
	}
}
