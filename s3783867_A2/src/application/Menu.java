package application;

import java.util.Scanner;

public class Menu {
	private Scanner console = new Scanner(System.in);
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
		String id = "", firstName, lastName, address;
	
			// Get details required for creating a customer.
			System.out.print("Enter First Name: ");
			firstName = console.nextLine();

			System.out.print("Enter Last Name: ");
			lastName = console.nextLine();

			System.out.print("Enter street number: ");
			int streetNo = Integer.parseInt(console.nextLine());

			System.out.print("Enter street name");
			String streetName = console.nextLine();

				
			} else
			{
				System.out.println("Error - Already exists in the system");
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

