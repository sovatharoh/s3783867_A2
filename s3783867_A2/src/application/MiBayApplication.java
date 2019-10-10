package application;


import customer.Address;
import customer.Customer;

public class MiBayApplication {
	private Customer[] customers = new Customer[15];
	private Menu menu;
	
	
	public MiBayApplication() {
		this.menu = new Menu(this);
	}

	public String createCustomer(String firstName, String lastName, Address address) 
	{
			int itemCount = 0;
			customers[itemCount] = new Customer(firstName, lastName, address);
			itemCount++;
			return  customers[itemCount-1].getFirstName() +" "+ customers[itemCount-1].getLastName() + "was succesfully added to the system";
	}
	
	public void showMenu() {
		menu.run();
	}
}
