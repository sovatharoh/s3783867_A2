package customer;

public class Customer {
	private String firstName;
	private String lastName;
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
		
		if(checkNullAddress(address)) {
			this.address = address;
		} else {
			this.address = new Address("N/A", "", "", "");
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
		public boolean checkNullAddress(Address tempAddress) {
			if(tempAddress == null) {
				return false;
			} else
			{
				return true;
			}
		}
		
		public void setAltAddress(Address altAddress) {
			this.altAddress = altAddress;
		}
		
		public void switchPreferredAddress() {
			if(altAddress != null) {
			Address TempAddress = address;
			this.address = altAddress;
			this.altAddress = TempAddress;
			} else {
				System.out.println("No Alternate Address to switch");
			}
			
		}
		
		public String getDetails() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("%-15s %s\n", "First Name:", firstName));
			sb.append(String.format("%-15s %s\n", "Last Name:", lastName));
			sb.append(String.format("%-15s %s\n", "Address:", address));
			if(altAddress != null) {
			sb.append(String.format("%-15s %s\n", "Alternate Address:", altAddress));
			}
			return sb.toString();
		}
}
