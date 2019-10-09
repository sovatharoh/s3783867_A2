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
		
		if(checkAddress(address)) {
			this.address = address;
		} else {
			this.address = new Address("N/A");
		}
	}
	
	public Customer(String firstName, String lastName, Address address, Address altAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.altAddress = altAddress;
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
		
		if(checkAddress(address)) {
			this.address = address;
		} else {
			this.address = new Address("N/A");
		}
		if(checkAddress(altAddress)) {
			this.altAddress = altAddress;
		} else {
			this.altAddress = new Address("N/A");
		}
	}
		public boolean checkName(String name) {
			if(firstName == null || lastName == null || firstName.isEmpty() || lastName.isEmpty()) 
			{
				return false;
			}else 
			{
				return true;
			}
		}
		
		public boolean checkAddress(Address TemporaryAddress) {
			if(address == null || altAddress == null || address == new Address("") || altAddress == new Address("")) {
				return false;
			}else 
			{
				return true;
			}
		}
		public void setAltAddress(Address altAddress) {
			this.altAddress = altAddress;
		}
		
		public void switchPreferredAddress() {
			if(altAddress != null && altAddress != new Address("N/A") && altAddress != new Address("None")) {
			Address TempAddress = address;
			this.address = altAddress;
			this.altAddress = TempAddress;
			} else {
				System.out.println("No Alternate Address to switch");
			}
			
		}
		
		public String getCustomerName() {
			String fullName = firstName + lastName;
			return fullName;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(firstName + ":" + lastName + ":" + address + ":" + altAddress);
			return sb.toString();
		}
}
