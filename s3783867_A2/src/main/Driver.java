package main;

import java.util.Scanner;

import application.Menu;
import application.MiBayApplication;
import customer.TestCustomer;
import miBayPackage.TestPackage;
import product.TestProduct;

public class Driver {

	public static void main(String[] args) {
		
		TestCustomer testCustomer = new TestCustomer();
		testCustomer.testValidCustomer();
		testCustomer.testInvalidCustomer();
		
		TestProduct testProduct = new TestProduct();
		testProduct.testValid();
		testProduct.testInvalid();
		
		TestPackage testPackage = new TestPackage();
		testPackage.testPackageValid();
		testPackage.testInvalidPackage();
	
		MiBayApplication app = new MiBayApplication();
		app.showMenu();
	
		
		
	}

}
