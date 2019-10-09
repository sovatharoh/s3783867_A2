package customer;

public class TestCustomer {
	public void testValidCustomer() {
		Address a1 = new Address("83", "Dalgliesh Street", "South Yarra", "3141");
		Address a2 = new Address("1", "Test Road", "Dandenong", "3175");
		Address a3 = new Address("12", "Alternate Road", "Noble Park", "3174");
		Address a4 = new Address("9", "Blue Road", "South Yarra", "3141");
		Address a5 = new Address("15", "Small Court", "South Yarra", "3141");
		Customer c1 = new Customer("John", "Smith", a1);
		Customer c2 = new Customer("David", "Jones", a2, a3);
		Customer c3 = new Customer("David", "Jones", a4, a5);
		
		System.out.println("\n Test Valid Customer");
		System.out.println(c1.getDetails());
		System.out.println(c2.getDetails());
		System.out.println(c3.getDetails());
		
		c1.setAltAddress(a3);
		c2.setAltAddress(a4);
		System.out.println("\n Test Set Alternate Address Method");
		System.out.println(c1.getDetails());
		System.out.println(c2.getDetails());
		
		c3.switchPreferredAddress();
		System.out.println("\n Test Switch Main Address with Alternate Address");
		System.out.println(c3.getDetails());
	}
	
	public void testInvalidCustomer() {
		Address a6 = new Address("1", "Test Street", "South Yarra", "3175");
		Customer c4 = new Customer(null, "Smith", a6);
		Customer c5 = new Customer("John", null, a6);
		Customer c6 = new Customer("John", "Smith", null);
		Customer c7 = new Customer("John", "Smith", a6, null);
		
		System.out.println("\n Test Invalid Customers");
		System.out.println(c4.getDetails());
		System.out.println(c5.getDetails());
		System.out.println(c6.getDetails());
		System.out.println(c7.getDetails());
	
		c4.switchPreferredAddress();
		System.out.println("\n Test Invalid Switch Address");
		System.out.println(c4.getDetails());
	}
}
