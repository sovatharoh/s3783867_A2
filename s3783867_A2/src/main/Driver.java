package main;

import customer.TestCustomer;
import product.TestProduct;

public class Driver {

	public static void main(String[] args) {
		TestProduct testProduct = new TestProduct();
		testProduct.testValid();
		testProduct.testInvalid();
		
		TestCustomer testCustomer = new TestCustomer();
		testCustomer.testValid();
		

	}

}
