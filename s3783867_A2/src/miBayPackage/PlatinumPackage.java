package miBayPackage;
/**
* <h1>PlatinumPackage</h1>
* <p><b>This class creates a platinum package object  and
*applies all the business rules and operations.
*</b></p>
* <p><b>References: None</b></p>
*
* @author Sovatharo Huy (s3783867)
* @version 1.0
* @since 2019-10-11
*/
import customer.Customer;
import product.Product;
import utilities.DateTime;

public class PlatinumPackage extends Package{
	private String memberNumber;

	public PlatinumPackage(Customer customer, Product product, String memberNumber) {
		super(customer, product);
		this.memberNumber = memberNumber;
		if(checkMemberNumber(memberNumber)) {
			this.memberNumber = memberNumber;
		} else {
			this.memberNumber = "N/A";
		}
	}
	public PlatinumPackage(Customer customer, Product[] products, String memberNumber, DateTime date) {
		super(customer, products, date);
		this.memberNumber = memberNumber;
		if(checkMemberNumber(memberNumber)) {
			this.memberNumber = memberNumber;
		} else {
			this.memberNumber = "N/A";
		}
	}
	/*
	 * updates member number in a platinum package object
	 */
	public boolean updateMemberNumber(String memberNumber) {
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
	/*
	 * validates and checks if memberNumber is null or meets business rules.
	 */
	public boolean checkMemberNumber(String memberNumber) {
		if(memberNumber == null || memberNumber.length() == 10 || memberNumber.isEmpty() ||
				!(memberNumber.matches("[A-Z][0-9][A-Z][0-9][A-Z][0-9][A-Z][0-9][A-Z][0-9]"))){
			return false;
		} else {
			return true;
		}
	}
	
	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-15s %s\n", "\nCustomer:\n ", this.getCustomer().getDetails()));
		sb.append(String.format("%-15s ", "Product:\n "));
		for(int i = 0; i < this.getProducts().length; i++) {
			sb.append(String.format("%-15s %s\n", "Product:", this.getProducts()[i].getDetails()));
		}
		if(this.getDate() != null) {
			sb.append(String.format("%-15s %s\n", "Delivery Date:", this.getDate().getFormattedDate()));
		}
		sb.append(String.format("%-15s %s\n", "Member Number:\n ", memberNumber));
		return sb.toString();
	}
	public String toString() {
		return "Customer: " + this.getCustomer() + "\nProduct: " + this.getProduct();
	}
}
