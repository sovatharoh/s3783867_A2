package application;
/**
* <h1>MiBayApplication</h1>
* <p><b>This class stores and create customer, product, package and platpackage
* in order to display and search through. Creates the
* seed data.</b></p>
* <p><b>References: None</b></p>
*
* @author Sovatharo Huy (s3783867)
* @version 1.0
* @since 2019-10-11
*/
import customer.Address;
import customer.Customer;
import product.Product;
import utilities.DateTime;
import miBayPackage.Package;
import miBayPackage.PlatinumPackage;
public class MiBayApplication {
	private Customer[] customers = new Customer[15];
	private Product[] productArr = new Product[15];
	private Package[] packageArr = new Package[15];
	private PlatinumPackage[] platPackage = new PlatinumPackage[15];
	int itemCountCust = 0;
	int itemCountProd = 0;
	int itemCountPack = 0;
	int itemCountPlat = 0;
	private Menu menu;
	
	
	public MiBayApplication() {
		this.menu = new Menu(this);
	}
	/*
	 * Creates the customer using user input from Menu and stores it in an array.
	 * Used when user chooses Add Customer (AC)
	 */
	public String createCustomer(String firstName, String lastName, Address address) 
	{
			customers[itemCountCust] = new Customer(firstName, lastName, address);
			itemCountCust++;
			return  customers[itemCountCust-1].getFirstName() +" "+ customers[itemCountCust-1].getLastName() + 
					" was succesfully added to the system";
	}
	/*
	 * Creates the product using user input from Menu and stores it in an array.
	 * Used when user chooses Add Product (AP)
	 */
	public String createProduct(String name, double weight, double cost) 
	{
			productArr[itemCountProd] = new Product(name, weight, cost);
			itemCountProd++;
			return  productArr[itemCountProd-1].getName() +" was succesfully added to the system";
	}
	/*
	 * Creates a package using user input from Menu and stores it in an array.
	 * Used when user chooses Prepare Order PP, and creates a normal package.
	 */
	public void createPackage(Customer customer, Product product, DateTime date, 
			Product[] tempProdArr, Product[] tempRemProdArr) {
		packageArr[itemCountPack] = new Package(customer, product);
		packageArr[itemCountPack].setDate(date);
		for(int i=0; i < tempProdArr.length; i++) {
			if(tempProdArr[i] != null) {
				packageArr[itemCountPack].addProduct(tempProdArr[i]);
			}
		}
		for(int j=0; j < tempRemProdArr.length; j++) {
			if(tempRemProdArr[j] != null) {
				packageArr[itemCountPack].removeProduct(tempRemProdArr[j]);
			}
		}
		itemCountPack++;
	}
	/*
	 * Creates a package using user input from Menu and stores it in an array.
	 * Used when user chooses Prepare Order PP, and creates a platinum package.
	 */
	public void createPlatPackage(Customer customer, Product product, String memberNumber, 
			DateTime date, Product[] tempProdArr, Product[] tempRemProdArr) {
		platPackage[itemCountPlat] = new PlatinumPackage(customer, product, memberNumber);
		platPackage[itemCountPlat].setDate(date);
		for(int i=0; i < tempProdArr.length; i++) {
			if(tempProdArr[i] != null) {
				platPackage[itemCountPlat].addProduct(tempProdArr[i]);
			}
		}
		for(int j=0; j < tempRemProdArr.length; j++) {
			if(tempRemProdArr[j] != null) {
				platPackage[itemCountPack].removeProduct(tempRemProdArr[j]);
			}
		}
		itemCountPlat++;
	}
	/*
	 * Creates a 3 hard-coded customers and 3 hard-coded products and stores them
	 * in their respective arrays.
	 * Used when user chooses Seed Data SA
	 */
	public boolean seedData()
	{
		for(int i = 0; i < customers.length; i++)
		{
			if(customers[i] != null)
			{
				return false;
			}
		}
		//4 hard coded customers
		Address seedAdd1 = new Address("83", "Daliesh Street", "South Yarra", "3141");
		Customer seed1 = new Customer("Henry", "Cavill", seedAdd1);
		customers[itemCountCust] = seed1;
		itemCountCust++;
		Address seedAdd2 = new Address("11", "Kings Road", "Dandenong", "3175");
		Customer seed2 = new Customer("Luke", "Merrel", seedAdd2);
		customers[itemCountCust] = seed2;
		Address seedAdd3 = new Address("32", "Manson Court", "Noble Park", "3174");
		Customer seed3 = new Customer("Harry", "Chong", seedAdd3);
		customers[itemCountCust] = seed3;
		itemCountCust++;
		Address seedAdd4 = new Address("19", "Ford Lane", "Noble Park", "3174");
		Customer seed4 = new Customer("Lisa", "Herald", seedAdd4);
		customers[itemCountCust] = seed4;
		itemCountCust++;
		//4 hard coded products
		Product seed5 = new Product("Man Of Steel DVD", 300.00, 24.99);
		productArr[itemCountProd] = seed5;
		itemCountProd++;
		Product seed6 = new Product("The Lion King", 320.00, 17.99);
		productArr[itemCountProd] = seed6;
		Product seed7 = new Product("Toilet Paper", 500.00, 5.00);
		productArr[itemCountProd] = seed7;
		itemCountProd++;
		Product seed8 = new Product("Toothe Paste", 150.00, 4.50);
		productArr[itemCountProd] = seed8;
		itemCountProd++;
		return true;
	}
	/*
	 * Required getters and setters
	 */
	public Customer[] getCustomers() {
		return customers;
	}
	
	public Product[] getProductArr() {
		return productArr;
	}
	public Package[] getPackagesArr() {
		return packageArr;
	}
	public PlatinumPackage[] getPlatinumPackageArr() {
		return platPackage;
	}
	public void showMenu() {
		menu.run();
	}
}
