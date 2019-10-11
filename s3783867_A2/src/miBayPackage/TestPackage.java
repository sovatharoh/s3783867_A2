package miBayPackage;
/**
* <h1>Test Package</h1>
* <p><b>This class tests valid construction of a package and platinum package
* and also tests for invalid constructions with null and empty string.
* also tests the operations.</b></p>
* <p><b>References: None</b></p>
*
* @author Sovatharo Huy (s3783867)
* @version 1.0
* @since 2019-10-11
*/
import customer.Address;
import customer.Customer;
import product.Product;
import utilities.DateTime;

public class TestPackage {
	/*
	 * tests valid and invalid insantiation of packages
	 */
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
		
		System.out.println("Test Set Date");
		DateTime date1 = new DateTime(7, 11, 2000);
		p1.setDate(date1);
		System.out.println(p1.getDetails());
		
		PlatinumPackage platP1 = new PlatinumPackage(cust1, prod1, "D0B4M4S7Y5");
		System.out.println("Test Valid Platinum Package");
		System.out.println(platP1.getDetails());
		platP1.addProduct(prod2);
		System.out.println("Test Valid Add Product to Platinum Package");
		System.out.println(platP1.getDetails());
		System.out.println("Test Valid Remove Product to Platinum Package");
		platP1.removeProduct(prod2);
		System.out.println(platP1.getDetails());
		platP1.updateMemberNumber("D1B5M5S8Y6");
		System.out.println("Test Valid Update Member Number");
		System.out.println(platP1.getDetails());
		
		System.out.println("Test Valid Add date");
		platP1.setDate(date1);
		System.out.println(platP1.getDetails());
	}
	
	public void testInvalidPackage() {
		Customer cust1 = new Customer(null, null, null);
		Product prod1 = new Product(null, 0, 0);
		Package pack1 = new Package(cust1, prod1);
		System.out.println("Test Null Package");
		System.out.println(pack1.getDetails());
		
		PlatinumPackage plat1 = new PlatinumPackage(cust1, prod1, "D0B4M4S7Y");
		PlatinumPackage plat2 = new PlatinumPackage(cust1, prod1, null);
		PlatinumPackage plat3 = new PlatinumPackage(cust1, prod1, "D0B4M4S7Y5A");
		PlatinumPackage plat4 = new PlatinumPackage(cust1, prod1, "D0BM44S7Y5");
		PlatinumPackage plat5 = new PlatinumPackage(cust1, prod1, "D$B4M4S7Y5");
		System.out.println("Test Invalid Member Number");
		System.out.println(plat1.getDetails());
		System.out.println(plat2.getDetails());
		System.out.println(plat3.getDetails());
		System.out.println(plat4.getDetails());
		System.out.println(plat5.getDetails());
		
		plat1.updateMemberNumber("D0B4M4S7Y5A");
		System.out.println("Test Invalid Update Member Number");
		System.out.println(plat1.getDetails());
	}
}
