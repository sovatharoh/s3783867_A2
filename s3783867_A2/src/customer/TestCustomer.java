package customer;

public class TestCustomer {
	public void testValid() {
		Customer c1 = new Customer("John", "Smith", new Address("1 Test Street"));
		Customer c2 = new Customer("David", "Jones", new Address("11 Test Road"), new Address("12 Alternate Road"));
		Customer c3 = new Customer("David", "Jones", null, null);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
	}
}
