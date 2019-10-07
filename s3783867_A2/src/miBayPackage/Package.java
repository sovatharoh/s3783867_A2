package miBayPackage;

import customer.Customer;
import product.Product;

public class Package {
	private Customer customer;
	private Product product;
	private Product[] productArr;

	public Package(Customer customer, Product product) {
		this.customer = customer;
		productArr[0] = product;
	}
	
	
	public boolean addProduct(Product product) {
			return addProduct(product.getName(), product.getWeight(), product.getCost());
	}
	public boolean addProduct(String name, double weight, double cost) {
		for(int i = 0; i < productArr.length; i++)
		{
			if(productArr[i] == null)
			{
				productArr[i] = new Product(name, weight, cost);
				return true;
			}
		}
		return false;

	}
	public boolean removeProduct(Product product) {
		return true;
	}
}
