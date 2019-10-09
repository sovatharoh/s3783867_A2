package customer;

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
	
	//validates and checks if postcode is null or matches the specification
		public void setPostcode(String postcode){
			if(postcode == null || postcode.isEmpty()) {
				this.postcode = "N/A";
			}
			int pLength = postcode.length();
			char pInitial = postcode.charAt(0);
			if(pLength != 4 || postcode.matches(".*[1-9].*") == false || Character.getNumericValue(pInitial) > 8 || 
					Character.getNumericValue(pInitial) < 1)
			{
				this.postcode = "N/A";
			} else
			{
				this.postcode = postcode;
			}
		}
		//checks if streeno is null and replaces it with N/A
		public void setStreetNumber(String streetNumber) {
			if(streetNumber == null || streetNumber.isEmpty()) 
			{
				this.streetNumber = "N/A";
			}else 
			{
				this.streetNumber = streetNumber;
			}
		}
		//checks if streetname is null and replaces it with N/A
		public void setStreetName(String streetName) {
			if(streetName == null || streetName.isEmpty()) 
			{
				this.streetName = "N/A";
			}else 
			{
				this.streetName = streetName;
			}
		}
		//checks if suburb is null and replaces it with N/A
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
		return streetNumber + " " + streetName + " " + suburb + " " + postcode;
	}
}
