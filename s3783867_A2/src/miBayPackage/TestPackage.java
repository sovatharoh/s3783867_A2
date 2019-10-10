package miBayPackage;

import customer.Address;
import customer.Customer;
import product.Product;

public class TestPackage {
	public void testPackageValid() {
		Address addr1 = new Address("1", "Test Street", "South Yarra", "3141");
		Customer cust1 = new Customer("John", "Smith", addr1);
		Product prod1 = new Product("Toilet Paper", 200.00, 15.00);
		Product prod2 = new Product("Tooth Paste", 100.00, 5.00);
		Product prod3 = new Product("Pie", 50.00, 2.50);
		Package p1 = new Package(cust1, prod1);
		System.out.println("Test Valid Package");
		System.out.println(p1.getDetails());
		System.out.println("Test Valid AddProduct");
		p1.addProduct(prod2);
		System.out.println(p1.getDetails());
		p1.addProduct(prod3);
		System.out.println(p1.getDetails());
		
		System.out.println("Test Valid RemoveProduct");
		p1.removeProduct(prod2);
		System.out.println(p1.getDetails());
		
		PlatinumPackage platP1 = new PlatinumPackage(cust1, prod1, "D0B4M4S7Y5");
		System.out.println("Test Valid Platinum Package");
		System.out.println(platP1.getDetails());
		platP1.addProduct(prod2);
		System.out.println("Test Valid Add Product to Platinum Package");
		System.out.println(platP1.getDetails());
		
		
	}
}
