package application;

import java.util.Scanner;

import customer.Address;
import customer.Customer;

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
				case "EX":
					//System.out.println("Exiting Program ... Goodbye!");
					break;
				default:
					//System.out.println("Error, invalid option selected!");
					System.out.println("Please try Again...");
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
	
	private void createPackage() {
		System.out.println("Please choose a customer from the list:");
		Customer[] customers = app.getCustomers();
		for(int i = 0; i < customers.length; i++) {
			if(customers[i] != null) {
			System.out.println(String.format("%-15s %s\n", i+1 + ":\n", customers[i].getDetails()));
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
		System.out.printf("%-30s %s\n", "Prepere Order", "PP");
		System.out.printf("%-30s %s\n", "Display ALL Deliveries (Sorted by name)", "DA");
		System.out.printf("%-30s %s\n", "Delivery Search (display deliveries on date", "DS");
		System.out.printf("%-30s %s\n", "Seed Data", "SA");
		System.out.printf("%-30s %s\n", "Exit Program", "EX");
		System.out.println("\nEnter your selection: ");
	}
}

