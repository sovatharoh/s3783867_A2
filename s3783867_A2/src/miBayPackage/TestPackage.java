package miBayPackage;

import customer.Address;
import customer.Customer;
import product.Product;

public class TestPackage {
	public void testPackageValid() {
		Address addr1 = new Address("1", "Test Street", "South Yarra", "3141");
		Customer cust1 = new Customer("John", "Smith", addr1);
		Product prod1 = new Product("Toilet Paper", 200.00, 15.00);
		Package p1 = new Package(cust1, prod1);
	}
}
