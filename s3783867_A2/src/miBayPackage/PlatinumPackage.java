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
		if(this.memberNumber != null) {
			if(memberNumber.length() == 10 && memberNumber.matches("[A-Z][0-9][A-Z][0-9][A-Z][0-9][A-Z][0-9][A-Z][0-9]")){
				this.memberNumber = memberNumber;
			}
		}
		if(this.memberNumber == null) {
			return false;
		}
		return true;
	}
}
