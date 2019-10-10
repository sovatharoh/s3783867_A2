package application;


import customer.Address;
import customer.Customer;
import product.Product;

public class MiBayApplication {
	private Customer[] customers = new Customer[15];
	private Product[] productArr = new Product[15];
	private Menu menu;
	
	
	public MiBayApplication() {
		this.menu = new Menu(this);
	}

	public String createCustomer(String firstName, String lastName, Address address) 
	{
			int itemCount = 0;
			customers[itemCount] = new Customer(firstName, lastName, address);
			itemCount++;
			return  customers[itemCount-1].getFirstName() +" "+ customers[itemCount-1].getLastName() + " was succesfully added to the system";
	}
	
	public String createProduct(String name, double weight, double cost) 
	{
			int itemCount = 0;
			productArr[itemCount] = new Product(name, weight, cost);
			itemCount++;
			return  productArr[itemCount-1].getName() +" was succesfully added to the system";
	}
	
	public Customer[] getCustomers() {
		return customers;
	}
	public void showMenu() {
		menu.run();
	}
}
