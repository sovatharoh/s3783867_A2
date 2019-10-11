package customer;
/**
* <h1>Customer</h1>
* <p><b>This class creates an customer object  and
*applys all the business rules and operations.
*</b></p>
* <p><b>References: None</b></p>
*
* @author Sovatharo Huy (s3783867)
* @version 1.0
* @since 2019-10-11
*/
public class Customer {
	private String firstName;
	private String lastName;
	private Address address;
	private Address altAddress = null;

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
	/*
	 * validates and checks if name is null or empty.
	 */
		public boolean checkName(String name) {
			if(firstName == null || lastName == null || firstName.isEmpty() || lastName.isEmpty()) 
			{
				return false;
			}else 
			{
				return true;
			}
		}
		/*
		 * validates and checks if address is null or empty.
		 */
		public boolean checkNullAddress(Address tempAddress) {
			if(tempAddress == null) {
				return false;
			} else
			{
				return true;
			}
		}
		/*
		 * sets the alt address
		 */
		public void setAltAddress(Address altAddress) {
			this.altAddress = altAddress;
		}
		/*
		 * switches the main and alternate address
		 */
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
		
		public String toString() {
			return firstName + " " + lastName + " " + address + " " + altAddress;
		}
		/*
		 * required getters
		 */
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
}
