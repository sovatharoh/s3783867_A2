package miBayPackage;

import customer.Customer;
import product.Product;

public class PlatinumPackage extends Package{
	private String memberNumber;

	public PlatinumPackage(Customer customer, Product product, String memberNumber) {
		super(customer, product);
		this.memberNumber = memberNumber;
	}
	
	public boolean updateMemberNumer(String memberNumber) {
		return false;
		
	}
}
