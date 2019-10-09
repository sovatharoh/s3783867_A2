package customer;

public class TestCustomer {
	public void testValidCustomer() {
		Customer c1 = new Customer("John", "Smith", new Address("1 Test Street"));
		Customer c2 = new Customer("David", "Jones", new Address("11 Test Road"), new Address("12 Alternate Road"));
		Customer c3 = new Customer("David", "Jones", new Address("9 Blue Road"), new Address("15 Small Court"));
		
		System.out.println("\n Test Valid Customer");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		
		c1.setAltAddress(new Address("5 AltAddress Road"));
		c2.setAltAddress(new Address("11 First Road"));
		System.out.println("\n Test Set Alternate Address Method");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		c3.switchPreferredAddress();
		System.out.println("\n Test Switch Main Address with Alternate Address");
		System.out.println(c3.toString());
	}
	
	public void testInvalidCustomer() {
		Customer c4 = new Customer(null, "Smith", new Address("1 Test Street"));
		Customer c5 = new Customer("John", null, new Address("1 Test Street"));
		Customer c6 = new Customer("John", "Smith", null);
		Customer c7 = new Customer("John", "Smith", new Address("1 Test Road"), null);
		
		System.out.println("\n Test Invalid Customers");
		System.out.println(c4.toString());
		System.out.println(c5.toString());
		System.out.println(c6.toString());
		System.out.println(c7.toString());
	
		c4.switchPreferredAddress();
		System.out.println("\n Test Invalid Switch Address");
		System.out.println(c4.toString());
	}
}
