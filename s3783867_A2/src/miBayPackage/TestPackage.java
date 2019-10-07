package miBayPackage;

import customer.Address;
import customer.Customer;
import product.Product;

public class TestPackage {
	public void testPackageValid() {
		Customer cust1 = new Customer("John", "Smith", new Address("1 Test Street"));
		Product prod1 = new Product("Toilet Paper", 200.00, 15.00);
		Package p1 = new Package(cust1, prod1);
	}
}
