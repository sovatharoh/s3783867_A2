package customer;

public class Customer {
	private String firstName;
	private String lastName;
	private String streetNo;
	private Address address;
	private Address altAddress;

	public Customer(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		if(checkName(firstName)) {
			this.firstName = firstName;
		} else {
			this.firstName = "N/A";
		}
		if(checkName(lastName)) {
			this.lastName = lastName;
		} else {
			this.lastName = "N/A";
		}
		this.altAddress = new Address("None");
		
	}
	
	
	public Customer(String firstName, String lastName, Address address, Address altAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.altAddress = altAddress;
	}
		public boolean checkName(String name) {
			if(firstName == null || lastName == null) 
			{
				return false;
			}else 
			{
				return true;
			}
		}
		
		public void setAltAddress(Address altAddress) {
			this.altAddress = altAddress;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(firstName + ":" + lastName + ":" + address + ":" + altAddress);
			return sb.toString();
		}
}
