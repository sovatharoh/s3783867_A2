package application;
/**
* <h1>Menu</h1>
* <p><b>This class provides a user interface to allow the user to
to create customer, product, prepare order, display deliveries and
* search deliveries.</b></p>
* <p><b>References: None</b></p>
*
* @author Sovatharo Huy (s3783867)
* @version 1.0
* @since 2019-10-11
*/
import java.util.Scanner;

import customer.Address;
import customer.Customer;
import miBayPackage.PlatinumPackage;
import product.Product;
import utilities.DateTime;

public class Menu {
	private Scanner console = new Scanner(System.in);
	private MiBayApplication app;
	
	public Menu(MiBayApplication app) {
		this.app = app;
	}

	/*
	 * Runs the menu in a loop until the user decides to exit the system.
	 */
	public void run()
	{
		final int MENU_ITEM_LENGTH = 2;
		String input;
		String choice = "";
		do
		{
			printMenu();

			input = console.nextLine().toUpperCase();

			if (input.length() != MENU_ITEM_LENGTH)
			{
				System.out.println("Error - selection must be two characters!");
			} else
			{
				System.out.println();

				switch (input)
				{
				case "AC":
					addCustomer();
					break;
				case "AP":
					addProduct();
					break;
				case "PP":
					createPackage();
					break;
				case "DA":
					displayDeliveries();
					break;
				case "DS":
					searchDeliveries();
					break;
				case "SA":
					app.seedData();
					break;
				case "EX":
					System.out.println("Exiting Program ... Goodbye!");
					break;
				default:
					System.out.println("");
				}
			}

		} while (choice != "EX");
	}

	/*
	 * Creates customer in the system.
	 */
	private void addCustomer()
	{
			// Get details required for creating a customer.
			System.out.print("Enter First Name: ");
			String firstName = console.nextLine();

			System.out.print("Enter Last Name: ");
			String lastName = console.nextLine();

			System.out.print("Enter street number: ");
			String streetNumber = console.nextLine();

			System.out.print("Enter street name: ");
			String streetName = console.nextLine();
			
			System.out.println("Enter suburb: ");
			String suburb = console.nextLine();
			
			System.out.println("Enter postcode: ");
			String postcode = console.nextLine();
			
			Address tempAddress = new Address(streetNumber, streetName, suburb, postcode);
			String result = app.createCustomer(firstName, lastName, tempAddress);
			System.out.println(result);
			}
	
	/*
	 * Creates product in the system.
	 */
	private void addProduct()
	{
			// Get details required for creating a product.
			System.out.print("Enter Product Name: ");
			String name = console.nextLine();

			System.out.print("Enter Weight: ");
			double weight = console.nextDouble();

			System.out.print("Enter Cost: ");
			double cost = console.nextDouble();
	
			String result = app.createProduct(name, weight, cost);
			System.out.println(result);
			}
	/*
	 * Creates a package or a platinum package in the system.
	 */
	private void createPackage() {
		Customer[] customers = app.getCustomers();
		printCustomerList();
		int custResponse = console.nextInt() -1;
		
		Product[] products = app.getProductArr();
		if(products[0] == null) {
			System.out.println("Sorry no products available.");
			return;
		} else {
			System.out.println("Please choose a product from the list:");
			for(int i = 0; i < products.length; i++) {
				if(products[i] != null) {
					System.out.println(String.format("%-15s %s\n", i+1 + ":\n", 
							products[i].getName()));
				}
			}
		}
		int prodResponse = console.nextInt() - 1;
		
		System.out.println("Please enter the delivery date:");
		System.out.println("Enter Day:");
		int day = console.nextInt();
		System.out.println("Enter Month:");
		int month = console.nextInt();
		System.out.println("Enter Year:");
		int year = console.nextInt();
		DateTime date = new DateTime(day, month, year);
		
		String input;
		Product[] tempProdArr = new Product[15];
		do
		{
			int tempProdItemCount = 0;
			System.out.println("Would you like to add another product? (Y/N)");
			console.nextLine();
			input = console.nextLine().toUpperCase();

			if (input.length() != 1)
			{
				System.out.println("Error - selection must be Y/N");
			} else
			{
				System.out.println();

				switch (input)
				{
				case "Y":
					printProductList();
					int productPos = console.nextInt() - 1;
					tempProdArr[tempProdItemCount] = products[productPos];
					tempProdItemCount++;
					break;
				case "N":
					break;
				default:
					System.out.println("");
				}
			}
			}while (!(input.equals("N")));
		
		String choice;
		Product[] tempRemProdArr = new Product[15];
		do
		{
			int tempRemProdCount = 0;
			System.out.println("Would you like to remove a product? (Y/N)");
			choice = console.nextLine().toUpperCase();

			if (choice.length() != 1)
			{
				System.out.println("Error - selection must be Y/N");
			} else
			{
				System.out.println();

				switch (choice)
				{
				case "Y":
					printProductList();
					int productPos = console.nextInt() - 1;
					tempRemProdArr[tempRemProdCount] = products[productPos];
					tempRemProdCount++;
					break;
				case "N":
					break;
				default:
					System.out.println("");
				}
			}
			}while (!(choice.equals("N")));
		
		
		System.out.println("Is this a Platinum Package? (Y/N)");
		String platResponse = console.nextLine().toUpperCase();
			if(platResponse.equals("Y")) {
				System.out.println("Please input your member number:");
				String memberNumber = console.nextLine();
				app.createPlatPackage(customers[custResponse], products[prodResponse], memberNumber, date, tempProdArr, tempRemProdArr);
				System.out.println(products[prodResponse].getName() + " was succesfully added to the order");
			} else {
				app.createPackage(customers[custResponse], products[prodResponse], date, tempProdArr, tempRemProdArr);
				System.out.println(products[prodResponse].getName() + " was succesfully added to the order");
			}
}
	/*
	 * Displays all deliveries in either ascending or descending order depending on input.
	 */
	public void displayDeliveries() {
		PlatinumPackage[] platArray = app.getPlatinumPackageArr();
		miBayPackage.Package[] packArr = app.getPackagesArr();
		String[] combineDetailArr = new String[30];
		String[] combineLastNameArr = new String[30];
		int spotCount = 0;
		for(int i=0; i < platArray.length; i++) {
			if(platArray[i] != null) {
				combineDetailArr[spotCount] = platArray[i].getDetails();
				combineLastNameArr[spotCount] = platArray[i].getCustomer().getLastName();
				spotCount++;
			}
		}
		for(int j=0; j < packArr.length; j++) {
			if(packArr[j] != null) {
				combineDetailArr[spotCount] = packArr[j].getDetails();
				combineLastNameArr[spotCount] = packArr[j].getCustomer().getLastName();
				spotCount++;
			}
		}
		System.out.println("Enter sort order (A/D):");
		String choice = console.nextLine().toUpperCase();
		switch(choice) {
			case "A":
				boolean swapped = false;
				do {
					swapped = false;
					for(int i=0; i<(combineLastNameArr.length-1); i++) {
						if(combineLastNameArr[i+1] != null) {
							String name1 = combineLastNameArr[i];
							String name2 = combineLastNameArr[i+1];
							int compared = name1.compareTo(name2);
							if(compared>0) {
								String temp = combineLastNameArr[i+1];
								String temp2 = combineDetailArr[i+1];
								combineLastNameArr[i+1]=combineLastNameArr[i];
								combineDetailArr[i+1]=combineDetailArr[i];
								combineLastNameArr[i] = temp;
								combineDetailArr[i] = temp2;
								swapped = true;
							}
						}
					}
				}while((swapped));
				break;
			case "D":
				boolean swappedD = false;
				do {
					swappedD = false;
					for(int i=0; i<(combineLastNameArr.length-1); i++) {
						if(combineLastNameArr[i+1] != null) {
							String name1 = combineLastNameArr[i];
							String name2 = combineLastNameArr[i+1];
							int compared = name1.compareTo(name2);
							if(compared<0) {
								String temp = combineLastNameArr[i+1];
								String temp2 = combineDetailArr[i+1];
								combineLastNameArr[i+1]=combineLastNameArr[i];
								combineDetailArr[i+1]=combineDetailArr[i];
								combineLastNameArr[i] = temp;
								combineDetailArr[i] = temp2;
								swapped = true;
							}
						}
					}
				}while((swappedD));
				break;
					}
		for(int i=0; i<combineDetailArr.length;i++) {
			if(combineDetailArr[i] != null) {
				System.out.println(combineDetailArr[i]);
			}
		}
	}
	/*
	 * Searches and prints packages and platinum package with same date as input
	 */
	public void searchDeliveries() {
		System.out.println("Enter Day:");
		int day = console.nextInt();
		System.out.println("Enter Month:");
		int month = console.nextInt();
		System.out.println("Enter Year:");
		int year = console.nextInt();
		DateTime searchDate = new DateTime(day, month, year);
		miBayPackage.Package[] packageArr = app.getPackagesArr();
		PlatinumPackage[] platPackageArr = app.getPlatinumPackageArr();
		
		for(int i = 0; i < packageArr.length; i++) {
			if(packageArr[i] != null) {
			if(packageArr[i].getDate().getFormattedDate().equals(searchDate.getFormattedDate())){
				System.out.println("----------------------------");
				System.out.println(packageArr[i].getDetails());
			}
			}
		}
		
		for(int i = 0; i < platPackageArr.length; i++) {
			if(platPackageArr[i] != null) {
			if(platPackageArr[i].getDate().getFormattedDate().equals(searchDate.getFormattedDate())){
				System.out.println("----------------------------");
				System.out.println(platPackageArr[i].getDetails());
			}
			}
		}
		
	}
	/*
	 * Prints all created customers. Used in the create createPackage method
	 */
	public void printCustomerList() {
		Customer[] customers = app.getCustomers();
		if(customers[0] == null) {
			System.out.println("Sorry no customers available.");
			return;
		} else {
			System.out.println("Please choose a customer from the list:");
			for(int i = 0; i < customers.length; i++) {
				if(customers[i] != null) {
					System.out.println(String.format("%-15s %s\n", i+1 + ":\n", 
							customers[i].getFirstName() + " " + customers[i].getLastName()));
				}
			}
		}
		
	}
	/*
	 * Prints all created products. Used in the create createPackage method
	 */
	public void printProductList(){
		Product[] products = app.getProductArr();
		if(products[0] == null) {
			System.out.println("Sorry no products available.");
			return;
		} else {
			System.out.println("Please choose a product from the list:");
			for(int i = 0; i < products.length; i++) {
				if(products[i] != null) {
					System.out.println(String.format("%-15s %s\n", i+1 + ":\n", 
							products[i].getName()));
				}
			}
		}
	}
	/*
	 * Prints the menu.
	 */
	private void printMenu()
	{
		System.out.printf("\n********** MiBay System Menu **********\n\n");

		System.out.printf("%-30s %s\n", "Add Customer", "AC");
		System.out.printf("%-30s %s\n", "Add Product", "AP");
		System.out.printf("%-30s %s\n", "Prepare Order", "PP");
		System.out.printf("%-30s %s\n", "Display ALL Deliveries", "DA");
		System.out.printf("%-30s %s\n", "Delivery Search", "DS");
		System.out.printf("%-30s %s\n", "Seed Data", "SA");
		System.out.printf("%-30s %s\n", "Exit Program", "EX");
		System.out.println("\nEnter your selection: ");
	}
}

