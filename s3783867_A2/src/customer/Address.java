package customer;
/**
* <h1>Address</h1>
* <p><b>This class creates an address object 
*in for use in the customer class constructor
*</b></p>
* <p><b>References: None</b></p>
*
* @author Sovatharo Huy (s3783867)
* @version 1.0
* @since 2019-10-11
*/
public class Address {
	private String streetNumber;
	private String streetName;
	private String postcode;
	private String suburb;
	public Address(String streetNumber, String streetName, String suburb, String postcode) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.suburb = suburb;
		this.postcode = postcode;
		
		setPostcode(postcode);
		setStreetNumber(streetNumber);
		setStreetName(streetName);
		setSuburb(suburb);
		
		
	}
	
	/*
	 * validates and checks if postcode is null or empty.
	 */
		public void setPostcode(String postcode){
			if(postcode == null || postcode.isEmpty()) {
				this.postcode = "N/A";
			}else
			{
				this.postcode = postcode;
			}
		}
		/*
		 * validates and checks if street number is null or empty.
		 */
		public void setStreetNumber(String streetNumber) {
			if(streetNumber == null || streetNumber.isEmpty()) 
			{
				this.streetNumber = "N/A";
			}else 
			{
				this.streetNumber = streetNumber;
			}
		}
		/*
		 * validates and checks if street name is null or empty.
		 */
		public void setStreetName(String streetName) {
			if(streetName == null || streetName.isEmpty()) 
			{
				this.streetName = "N/A";
			}else 
			{
				this.streetName = streetName;
			}
		}
		/*
		 * validates and checks if suburb is null or empty.
		 */
		public void setSuburb(String suburb) {
			if(suburb == null) 
			{
				this.suburb = "N/A";
			}else 
			{
				this.suburb = suburb;
			}
		}
	public String toString() {
		if(streetNumber.isEmpty()) {
			return "";
		}
		return streetNumber + " " + streetName + " " + suburb + " " + postcode;
	}
}
