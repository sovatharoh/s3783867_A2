package miBayPackage;
/**
* <h1>package</h1>
* <p><b>This class creates an package object  and
*applies all the business rules and operations.
*</b></p>
* <p><b>References: None</b></p>
*
* @author Sovatharo Huy (s3783867)
* @version 1.0
* @since 2019-10-11
*/
import customer.Customer;
import product.Product;
import utilities.DateTime;

public class Package {
	private Customer customer;
	private Product product;
	private Product[] products = new Product[1];
	private DateTime date;

	public Package(Customer customer, Product product) {
		this.customer = customer;
		products[0] = product;
	}
	
	public Package(Customer customer, Product[] products, DateTime date) {
		this.customer = customer;
		this.products = products;
		this.date = date;
	}
	
	/*
	 * adds a product to a package object
	 */
	public boolean addProduct(Product product) {
		boolean valid = false;
		if(products != null) {
			for(int i = 0; i< products.length; i++) {
				if(products[i] != null) {
					if(!(products[i].getName().equals(product.getName())) || !(products[i].getName().equals(product.getName())) || 
							products[i].getCost() != product.getCost()) {
						valid = true;
					}
			    }
			}
		}
		
		if(valid)
			if(products !=null){
			Product[] temp = new Product[products.length + 1];
			for(int i = 0; i < products.length; i++) {
				temp[i] = products[i];
			}
			temp[products.length] = product;
			this.products = temp;
			System.out.println(temp[1].getDetails());
			return true;
		}
		return false;
	}
	/*
	 * removes a product from a package object
	 */
	public boolean removeProduct(Product product) {
		if(products != null) {
			Product[] temp = new Product[products.length - 1];
			int j = 0;
			for(int i = 0; i < products.length; i++) {
				if(products[i] != null && !(products[i].equals(product))) {
					temp[j] = products[i];
					j++;
				}
			}
			products = temp;
			return true;
		}
		return false;
	}

	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-15s %s\n", "\nCustomer:\n ", customer.getDetails()));
		sb.append(String.format("%-15s ", "Product:\n "));
		for(int i = 0; i < products.length; i++) {
			sb.append(String.format("%-15s %s\n", "Product:", products[i].getDetails()));
		}
		if(this.date != null) {
			sb.append(String.format("%-15s %s\n", "Delivery Date:", date.getFormattedDate()));
		}
		return sb.toString();
	}
	/*
	 * required getters and setters.
	 */
	public String toString() {
		return "Customer: " + customer + "\nProduct: " + product;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public DateTime getDate() {
		return date;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}
	
	
}
