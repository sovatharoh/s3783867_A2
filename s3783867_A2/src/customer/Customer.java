package customer;

public class Customer {
	private String firstName;
	private String lastName;
	private String streetNo;
	private Address address;

	public Customer(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
		public void setFirstname(String firstName) {
			if(firstName == null) 
			{
				this.firstName = "N/A";
			}else 
			{
				this.firstName = firstName;
			}
		}

		public void setLastname(String lastName) {
			if(lastName == null) 
			{
				this.lastName = "N/A";
			}else 
			{
				this.lastName = lastName;
			}
		}
		
		//public void setAddress(Address address) {
			//if(address == null) {
				//this.address = "N/A";
			//}else {
				//this.address = address;
			//}
		//}

}
