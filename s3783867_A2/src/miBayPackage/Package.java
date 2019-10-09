package miBayPackage;

import customer.Customer;
import product.Product;

public class Package {
	private Customer customer;
	private Product product;
	private Product[] products = new Product[10];

	public Package(Customer customer, Product product) {
		this.customer = customer;
		products[0] = product;
	}
	
	public Package(Customer customer, Product[] products) {
		this.customer = customer;
		this.products = products;
	}
	
	
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
			temp[products.length -1] = product;
			products = temp;
			return true;
		}
		//if(products == null) {
			//Product[] temp = new Product[1];
			//temp[0] = product;
			//products = temp;
			//return true;
		//}
		return false;
	}
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
}
