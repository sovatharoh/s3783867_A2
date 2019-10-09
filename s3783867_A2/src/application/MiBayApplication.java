package application;

import com.sun.jndi.cosnaming.IiopUrl.Address;

import customer.Customer;

public class MiBayApplication {
	private Customer[] customers = new Customer[15];
	public String createCustomer(String firstName, String lastName, customer.Address address) 
	{
			int itemCount = 0;
			customers[itemCount] = new Customer(firstName, lastName, address);
			itemCount++;
			return  customers[itemCount-1].getCustomerName() + "was succesfully added to the system";
		}
		return "Error: Already exists in the system.";
	}

}
